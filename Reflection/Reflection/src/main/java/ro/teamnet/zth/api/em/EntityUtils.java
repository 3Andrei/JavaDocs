package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolescu on 07.07.2016.
 */
public class EntityUtils {

    private EntityUtils() throws  UnsupportedOperationException{

    }

    public static String getTableName(Class entity){
        Table table=(Table)entity.getAnnotation(Table.class);
        if(table!=null){
          return  table.name();
        }else{
            return entity.getName();
        }
    }
    public static List<ColumnInfo> getColumn(Class entity){
        List<ColumnInfo> columnInfoList=null;
        columnInfoList=new ArrayList<ColumnInfo>();
        Field [] fieldArray=entity.getDeclaredFields();


        for (Field f: entity.getDeclaredFields()){
            ColumnInfo columnInfo=new ColumnInfo();
            columnInfo.setColumnName(f.getName());
            columnInfo.setColumnType(f.getType());

            if (f.getDeclaredAnnotation(Id.class) != null) {
                columnInfo.setId(true);
                columnInfo.setDbName(f.getAnnotation(Id.class).name());
            }else{
                columnInfo.setId(false);
                columnInfo.setDbName(f.getAnnotation(Column.class).name());
            }
            columnInfoList.add(columnInfo);
        }
        return columnInfoList;
    }


    public static Object castFromSqlType(Object value,Class wantedType){
        Object result=null;
        if(value instanceof BigDecimal){
            if( wantedType.equals(Integer.class)){
                result=((BigDecimal)value).intValue();
            }
            if(wantedType.equals(Long.class)){
                result= ((BigDecimal)value).longValue();
            }
            if(wantedType.equals(Float.class)){
                result= ((BigDecimal)value).floatValue();
            }
            if(wantedType.equals(Double.class)){
                result= ((BigDecimal)value).doubleValue();
            }
        }else{
            result=value;
        }
        return result;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz,Class annotation){
        List<Field> listOfFields=null;
        listOfFields=new ArrayList<Field>();

        for (Field field:clazz.getDeclaredFields()) {
            if(field.getAnnotation(annotation)!=null){
                listOfFields.add(field);
            }
        }

    return listOfFields;
    }

    public static Object getSqlValue(Object obj){
        Object result=null;
        Field fieldId=null;

        if(obj.getClass().getAnnotation(Table.class)!=null){
            fieldId=getFieldsByAnnotations(obj.getClass(),Id.class).get(0);
            fieldId.setAccessible(true);
            try {
                result=fieldId.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            try {
                result=fieldId.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
