package br.com.mastertech.couto.cartao.client;

import br.com.mastertech.couto.cartao.exception.CustomerUnavailableServiceException;

public class CustomerClientFallback implements CustomerClient {

    @Override
    public Customer getCustomerById(Long id) {
        throw new CustomerUnavailableServiceException();
    }
}
