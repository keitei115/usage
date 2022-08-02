package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class MoveCheckValidator implements ConstraintValidator<MoveCheck, String> {
    @Override
    public void initialize(MoveCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getMoveList().contains(value);
    }
}
