package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Nicolescu on 15.07.2016.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String name();
}
