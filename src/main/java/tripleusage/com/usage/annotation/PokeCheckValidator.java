package tripleusage.com.usage.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tripleusage.com.usage.service.NameList;

public class PokeCheckValidator implements ConstraintValidator<PokeCheck, String> {
    @Override
    public void initialize(PokeCheck constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        NameList nameList = new NameList();
        return nameList.getPokemonList().contains(value);
    }
}
