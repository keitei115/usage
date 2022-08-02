package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class AbilityCheckValidator implements ConstraintValidator<AbilityCheck, String> {
    @Override
    public void initialize(AbilityCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getAbilityList().contains(value);
    }
}
