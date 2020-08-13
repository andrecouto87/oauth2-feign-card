package br.com.mastertech.couto.cartao.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateCreditCardRequest {

    @NotNull
    @NotBlank
    @JsonProperty("numero")
    private String number;

    @NotNull
    @Min(1)
    @JsonProperty("clienteId")
    private Long customerId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
