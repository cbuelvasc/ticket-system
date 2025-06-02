package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation for event date consistency.
 * 
 * Validates that:
 * - Event end is after event start
 * - Sales end is before or equal to event start
 * - Sales start is before sales end
 * - All dates are properly timezone-aware
 */
@Documented
@Constraint(validatedBy = ValidEventDatesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEventDates {
    
    String message() default "Event dates are not valid";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
} 