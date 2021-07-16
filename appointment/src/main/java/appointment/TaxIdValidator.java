package appointment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaxIdValidator implements ConstraintValidator<TaxIdValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        final String NUMBERS = "0123456789";
        boolean taxIdReal = false;
        if (s.length() != 10) {
            throw new IllegalArgumentException("Not enough numbers!");
        }
        for (int i = 0; i < s.length(); i++) {
            if (!NUMBERS.contains(s.substring(i, i + 1))) {
                throw new IllegalArgumentException("Not only numbers!");
            }
        }

        int checksum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            checksum += Integer.parseInt(s.substring(i, i + 1)) * (i + 1);
        }
        if (checksum % 11 == Integer.parseInt(s.substring(9, 10))) {
            taxIdReal = true;
        }
        return taxIdReal;
    }

}
