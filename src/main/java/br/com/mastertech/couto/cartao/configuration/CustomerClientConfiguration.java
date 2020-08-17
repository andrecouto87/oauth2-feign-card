package br.com.mastertech.couto.cartao.configuration;

import br.com.mastertech.couto.cartao.client.CustomerClientFallback;
import br.com.mastertech.couto.cartao.decoder.CustomerClientDecoder;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new CustomerClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CustomerClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }

}
