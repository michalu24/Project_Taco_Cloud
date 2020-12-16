package com.cloud.taco.project.domain;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Data
@Component
public class Order {

    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String address;
    private String ccNumber;
    private String ccExpDate;
    private String ccCVV;
}
