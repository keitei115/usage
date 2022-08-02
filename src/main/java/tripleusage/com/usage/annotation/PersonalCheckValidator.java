package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class PersonalCheckValidator implements ConstraintValidator<PersonalCheck, String> {
    @Override
    public void initialize(PersonalCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getPersonalList().contains(value);
    }
}
