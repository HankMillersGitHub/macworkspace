package com._04_other;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

@Target({ FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Colum {
    String columName();
    String columType();
}
