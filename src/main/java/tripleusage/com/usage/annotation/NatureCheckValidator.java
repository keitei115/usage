package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class NatureCheckValidator implements ConstraintValidator<NatureCheck, String> {
    @Override
    public void initialize(NatureCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getPersonalList().contains(value);
    }
}
