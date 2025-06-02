package com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.validation;

import com.xeppelin.ticketsystem.infrastructure.adapter.input.rest.request.CreateEventRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.ZonedDateTime;

/**
 * Validator for the {@link ValidEventDates} annotation.
 * 
 * This validator ensures that event dates are logically consistent
 * and properly handle timezone-aware comparisons.
 */
public class ValidEventDatesValidator implements ConstraintValidator<ValidEventDates, CreateEventRequest> {

    @Override
    public void initialize(ValidEventDates constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(CreateEventRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return true; // Let other validators handle null checks
        }

        boolean isValid = true;
        
        // Disable default constraint violation and build custom messages
        context.disableDefaultConstraintViolation();

        // Validate event start and end times
        if (request.start() != null && request.end() != null) {
            if (!request.end().isAfter(request.start())) {
                context.buildConstraintViolationWithTemplate(
                    "Event end time must be after start time")
                    .addPropertyNode("end")
                    .addConstraintViolation();
                isValid = false;
            }
        }

        // Validate sales period
        if (request.salesStart() != null && request.salesEnd() != null) {
            if (!request.salesEnd().isAfter(request.salesStart())) {
                context.buildConstraintViolationWithTemplate(
                    "Sales end time must be after sales start time")
                    .addPropertyNode("salesEnd")
                    .addConstraintViolation();
                isValid = false;
            }
        }

        // Validate that sales end is before or at event start
        if (request.salesEnd() != null && request.start() != null) {
            // Allow sales to end exactly when event starts
            if (request.salesEnd().isAfter(request.start())) {
                context.buildConstraintViolationWithTemplate(
                    "Ticket sales must end before or when the event starts")
                    .addPropertyNode("salesEnd")
                    .addConstraintViolation();
                isValid = false;
            }
        }

        // Validate that all times are in the future (if present)
        ZonedDateTime now = ZonedDateTime.now();
        
        if (request.salesStart() != null && request.salesStart().isBefore(now)) {
            context.buildConstraintViolationWithTemplate(
                "Sales start time must be in the future")
                .addPropertyNode("salesStart")
                .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
} 