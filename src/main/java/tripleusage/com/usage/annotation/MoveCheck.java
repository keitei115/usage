package tripleusage.com.usage.annotation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MoveCheckValidator.class)
public @interface MoveCheck {
    String message() default "move is not in the list";
    Class<?>[] groups() default {};
    Class<? extends Payload >[] payload() default {};

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MoveCheck[] value();
    }
}