package ro.teamnet.zth;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
public class MyDispatcherServlet extends HttpServlet {

    HashMap<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        try {
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for(Class controller : classes) {

                if(controller.isAnnotationPresent(MyController.class)) {

                    MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method methods[] = controller.getMethods();

                    for(Method iter : methods) {
                        if(iter.isAnnotationPresent(MyRequestMethod.class)) {

                            MyRequestMethod mrm = (MyRequestMethod) iter.getAnnotation(MyRequestMethod.class);

                            String aux = mrm.urlPath();
                            String completePath = controllerUrlPath + aux;

                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(mrm.methodType());
                            methodAttributes.setMethodName(iter.getName());
                            methodAttributes.setParameterType(iter.getParameterTypes());

                            allowedMethods.put(completePath, methodAttributes);

                        }
                    }
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instr
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instr
        dispatchReply("POST", req, resp);

    }

    private void dispatchReply(String command, HttpServletRequest req, HttpServletResponse resp) {
        Object o = null;
        try {
            o = dispatch(req, resp);
        } catch (Exception ex) {
            sendExceptionError(ex, req, resp);
        }
        try {
            reply(o, req, resp);
        } catch (IOException ex) {
            sendExceptionError(ex, req, resp);
        }
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {

        String path = req.getPathInfo();
        MethodAttributes ma = allowedMethods.get(path);
        if(ma != null) {
            String cn = ma.getControllerClass();
            Object obj = null;
            try {
                Class<?> controllerClass = Class.forName(cn);
                Object controllerIns = controllerClass.newInstance();
                Method method = controllerClass.getMethod(ma.getMethodName(),ma.getParameterType());

                Parameter[] parameters=method.getParameters();
                List<Object> parameterValues=new ArrayList<>();
                for(Parameter parameter: parameters){
                    if(parameter.isAnnotationPresent(MyRequestParam.class)){
                        MyRequestParam annotation=parameter.getAnnotation(MyRequestParam.class);
                        String name=annotation.name();
                        String requestParamValue=req.getParameter(name);
                        Class<?> type=parameter.getType();
                        Object requestparamObject=new ObjectMapper().readValue(requestParamValue,type);
                        parameterValues.add(requestparamObject);
                    }
                }
               // obj = method.invoke(controllerIns,Long.valueOf(req.getParameter("id")));
                //return obj;
                return method.invoke(controllerIns,parameterValues.toArray());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "default";

    }

    private void reply(Object o, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper om=new ObjectMapper();
        String jsonString=om.writeValueAsString(o);
        resp.getWriter().print(jsonString);

       // resp.getWriter().write((String) o);
//        resp.getWriter().printf(allowedMethods.toString());
    }

    private void sendExceptionError(Exception ex, HttpServletRequest req, HttpServletResponse resp) {

    }
}
