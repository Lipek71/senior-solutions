package appointment;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TaxIdValidator.class)
public @interface TaxIdValidation {

    String message() default "Invalid Tax Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
