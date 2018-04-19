package com.jlu.common.aop.annotations;

import java.lang.annotation.*;

/**
 * Created by langshiquan on 18/1/25.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogExecTime {
}
