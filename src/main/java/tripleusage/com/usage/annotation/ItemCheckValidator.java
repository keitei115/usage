package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class ItemCheckValidator implements ConstraintValidator<ItemCheck, String> {
    @Override
    public void initialize(ItemCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getItemList().contains(value);
    }
}
