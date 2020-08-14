package br.com.mastertech.couto.cartao.configuration;

import br.com.mastertech.couto.cartao.decoder.CustomerClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new CustomerClientDecoder();
    }

}
