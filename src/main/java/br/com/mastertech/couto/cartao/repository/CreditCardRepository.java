package br.com.mastertech.couto.cartao.repository;

import br.com.mastertech.couto.cartao.models.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
