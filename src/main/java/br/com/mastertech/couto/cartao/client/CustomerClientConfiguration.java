package br.com.mastertech.couto.cartao.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new CustomerClientDecoder();
    }

}
