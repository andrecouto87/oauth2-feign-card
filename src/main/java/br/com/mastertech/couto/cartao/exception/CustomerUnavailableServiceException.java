package br.com.mastertech.couto.cartao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Serviço de clientes indisponível.")
public class CustomerUnavailableServiceException extends RuntimeException {
}
