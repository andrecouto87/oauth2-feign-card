package br.com.mastertech.couto.cartao.controller;

import br.com.mastertech.couto.cartao.models.CreditCard;
import br.com.mastertech.couto.cartao.models.dto.*;
import br.com.mastertech.couto.cartao.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @PostMapping
    public CreateCreditCardResponse create(@RequestBody @Valid CreateCreditCardRequest createCreditCardRequest) {
        CreditCard creditCard = creditCardMapper.toCreditCard(createCreditCardRequest);
        creditCard = creditCardService.create(creditCard);
        return creditCardMapper.toCreateCreditCardResponse(creditCard);
    }

    @GetMapping("/{id}")
    public GetCreditCardResponse getById(@PathVariable Long id) {
        CreditCard creditCard = creditCardService.getById(id);
        return creditCardMapper.toGetCreditCardResponse(creditCard);
    }

    @GetMapping("completecard/{id}")
    public CompleteCreditCardResponse getCompleteCardById(@PathVariable Long id) {
        CreditCard creditCard = creditCardService.getById(id);
        return creditCardMapper.toCompleteCreditCardResponse(creditCard);
    }

    @PatchMapping("/{id}")
    public UpdateCreditCardResponse update(@PathVariable Long id, @RequestBody @Valid UpdateCreditCardRequest updateCreditCardRequest) {
        CreditCard creditCard = creditCardMapper.toCreditCard(updateCreditCardRequest);
        creditCard.setId(id);

        creditCard = creditCardService.update(creditCard);

        return creditCardMapper.toUpdateCreditCardResponse(creditCard);
    }

}
