package br.com.mastertech.couto.cartao.models.dto;


import br.com.mastertech.couto.cartao.models.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCard toCreditCard(CreateCreditCardRequest createCreditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(createCreditCardRequest.getNumber());
        creditCard.setCustomerId(createCreditCardRequest.getCustomerId());

        return creditCard;
    }

    public CreditCard toCreditCard(UpdateCreditCardRequest updateCreditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setActive(updateCreditCardRequest.getActive());
        return creditCard;
    }

    public CreateCreditCardResponse toCreateCreditCardResponse(CreditCard creditCard) {
        CreateCreditCardResponse createCreditCardResponse = new CreateCreditCardResponse();
        createCreditCardResponse.setId(creditCard.getId());
        createCreditCardResponse.setNumber(creditCard.getNumber());
        createCreditCardResponse.setActive(creditCard.getActive());
        createCreditCardResponse.setCustomerId(creditCard.getCustomerId());
        return createCreditCardResponse;
    }

    public CompleteCreditCardResponse toCompleteCreditCardResponse(CreditCard creditCard) {
        CompleteCreditCardResponse completeCreditCardResponse = new CompleteCreditCardResponse();
        completeCreditCardResponse.setId(creditCard.getId());
        completeCreditCardResponse.setNumber(creditCard.getNumber());
        completeCreditCardResponse.setActive(creditCard.getActive());
        completeCreditCardResponse.setCustomerId(creditCard.getCustomerId());
        return completeCreditCardResponse;
    }

    public GetCreditCardResponse toGetCreditCardResponse(CreditCard creditCard) {
        GetCreditCardResponse getCreditCardResponse = new GetCreditCardResponse();
        getCreditCardResponse.setId(creditCard.getId());
        getCreditCardResponse.setNumber(creditCard.getNumber());
        getCreditCardResponse.setCustomerId(creditCard.getCustomerId());
        return getCreditCardResponse;
    }

    public UpdateCreditCardResponse toUpdateCreditCardResponse(CreditCard creditCard) {
        UpdateCreditCardResponse updateCreditCardResponse = new UpdateCreditCardResponse();
        updateCreditCardResponse.setId(creditCard.getId());
        updateCreditCardResponse.setNumber(creditCard.getNumber());
        updateCreditCardResponse.setActive(creditCard.getActive());
        updateCreditCardResponse.setCustomerId(creditCard.getCustomerId());
        return updateCreditCardResponse;
    }
}
