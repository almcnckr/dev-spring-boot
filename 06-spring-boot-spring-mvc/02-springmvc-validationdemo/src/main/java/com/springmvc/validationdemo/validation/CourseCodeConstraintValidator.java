package com.springmvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String prefix;

    @Override
    public void initialize(CourseCode courseCode) {
        prefix = courseCode.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null)
            return value.startsWith(prefix);
        return true;
    }
}
