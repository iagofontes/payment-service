package br.com.fiap.orderservice.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Pagamento {

    private Long idTransacao;
    private String numeroCartao;
    private Date validadeCartao;
    private String bandeira;

//    public Pagamento(){}
//
//    public Pagamento(Long idTransacao, String numeroCartao, Date validadeCartao, String bandeira) {
//        this.idTransacao = idTransacao;
//        this.numeroCartao = numeroCartao;
//        this.validadeCartao = validadeCartao;
//        this.bandeira = bandeira;
//    }

}
