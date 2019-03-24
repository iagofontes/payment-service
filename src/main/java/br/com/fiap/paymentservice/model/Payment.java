package br.com.fiap.paymentservice.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Payment {

    private Long idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private BigDecimal valorCompra;
    private String bandeiraCartao;

}
