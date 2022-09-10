package com.example.logging.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = Employeevalidator.class)
@Retention(RetentionPolicy.RUNTIME)

public @interface EmployeeConstraint {
    String message() default "Invalid Employees data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
