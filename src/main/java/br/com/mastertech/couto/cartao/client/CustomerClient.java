package br.com.mastertech.couto.cartao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

    @GetMapping("/cliente/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
