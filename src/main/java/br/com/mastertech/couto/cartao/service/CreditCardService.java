package br.com.mastertech.couto.cartao.service;

import br.com.mastertech.couto.cartao.client.Customer;
import br.com.mastertech.couto.cartao.client.CustomerClient;
import br.com.mastertech.couto.cartao.exception.CreditCardNotFoundException;
import br.com.mastertech.couto.cartao.exception.CustomerNotFoundException;
import br.com.mastertech.couto.cartao.models.CreditCard;
import br.com.mastertech.couto.cartao.repository.CreditCardRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private CustomerClient customerService;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCard create(CreditCard creditCard) {
        try {
            Customer customer = customerService.getCustomerById(creditCard.getCustomerId());
            creditCard.setCustomerId(customer.getId());
        } catch (FeignException.NotFound ex) {
            throw new CustomerNotFoundException();
        }

        creditCard.setActive(false);

        return creditCardRepository.save(creditCard);
    }

    public CreditCard update(CreditCard updatedCreditCard) {
        CreditCard creditCard = getById(updatedCreditCard.getId());

        creditCard.setActive(updatedCreditCard.getActive());

        return creditCardRepository.save(creditCard);
    }

    public CreditCard getById(Long id) {
        Optional<CreditCard> byId = creditCardRepository.findById(id);

        if (!byId.isPresent()) {
            throw new CreditCardNotFoundException();
        }

        return byId.get();
    }
}
