package io.github.vdubois.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by vdubois on 14/12/16.
 */
@Constraint(validatedBy = IsbnValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Isbn {

    String message() default "Bad ISBN number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
