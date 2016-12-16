package io.github.vdubois.validator;

import org.apache.commons.validator.routines.ISBNValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vdubois on 14/12/16.
 */
public class IsbnValidator implements ConstraintValidator<Isbn, String> {
   public void initialize(Isbn constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      return ISBNValidator.getInstance().isValidISBN10(value);
   }
}
