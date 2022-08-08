package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCheckValidator implements ConstraintValidator<DateCheck, String> {
    @Override
    public void initialize(DateCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dtf.format(LocalDate.parse(value, dtf));
            if (LocalDate.parse(value, dtf).isBefore(LocalDate.parse("2000-01-01")) || LocalDate.parse(value, dtf).isAfter(LocalDate.parse("2999-12-31"))) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
