package com.jlu.common.permission.annotations;

import java.lang.annotation.*;

/**
 * Created by langshiquan on 18/2/2.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionPass {
}
