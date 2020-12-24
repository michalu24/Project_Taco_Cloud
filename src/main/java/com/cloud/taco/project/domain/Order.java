package com.cloud.taco.project.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Component

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Podanie imienia jest obowiązkowe!")
    @Column(name = "customer_first_name")
    private String customerFirstName;
    @NotBlank(message = "Podanie nazwiska jest obowiązkowe!")
    @Column(name = "customer_last_name")
    private String customerLastName;
    @NotBlank(message = "Podanie adresu email jest obowiązkowe!")
    @Column(name = "customer_email")
    private String customerEmail;
    @NotBlank(message = "Podanie adresu dostawy jest obowiązkowe!")
    @Column(name = "customer_address")
    private String address;
    @CreditCardNumber(message = "Podaj prawidłowy numer karty kredytowej!")
    @Column(name = "customer_ccNumber")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$",
            message = "Wartość musi być w formacie MM/RR")
    @Column(name = "customer_ccExpDate")
    private String ccExpDate;
    @Digits(integer = 3, fraction = 0,message = "Kod musi składać się z 3 cyfr!")
    @Column(name = "customer_ccCVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private Set<Taco> tacos = new LinkedHashSet<>();
}
