package com.cloud.taco.project.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Component
public class Order {
    @NotBlank(message = "Podanie imienia jest obowiązkowe!")
    private String customerFirstName;
    @NotBlank(message = "Podanie nazwiska jest obowiązkowe!")
    private String customerLastName;
    @NotBlank(message = "Podanie adresu email jest obowiązkowe!")
    private String customerEmail;
    @NotBlank(message = "Podanie adresu dostawy jest obowiązkowe!")
    private String address;
    @CreditCardNumber(message = "Podaj prawidłowy numer karty kredytowej!")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]1[0-2])(\\/)([1-9][0-9])$",
            message = "Wartość musi być w formacie MM/RR")
    private String ccExpDate;
    @Digits(integer = 3, fraction = 0,message = "Kod musi składać się z 3 cyfr!")
    private String ccCVV;
}
