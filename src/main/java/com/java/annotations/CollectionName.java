package com.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionName {
    public String name() default "";

    public String[] indexes() default {};

    public String[] uniqueIndexes() default {};
    boolean premSyncDown() default  true;
    boolean premSyncUp() default true;
}
