package br.com.fiap.orderservice.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Item {

    private String nome;
    private String descricao;
    private Double valor;

//    @Autowired
//    public Item() {}
//
//    public Item(String nome, String descricao, Double valor) {
//        this.nome = nome;
//        this.descricao = descricao;
//        this.valor = valor;
//    }

}
