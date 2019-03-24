package br.com.fiap.orderservice.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Order {

    private Long idPedido;
    private String email;
    private String nomeCompleto;
    private String shippingAddress;
    private String formaPagamento;
    private Date dataPedido;
    private String statusPedido;
    private ArrayList<Item> itens;
    private Double valorPedido;
    private Pagamento pagamento;
//
//    @Autowired
//    public Order(){}
//
//    public Order(Long idPedido, String email, String nomeCompleto,
//                 String shippingAddress, String formaPagamento,
//                 Date dataPedido, String statusPedido,
//                 ArrayList<Item> itens, Double valorPedido, Pagamento pagamento){
//
//        this.idPedido = idPedido;
//        this.email = email;
//        this.nomeCompleto = nomeCompleto;
//        this.shippingAddress = shippingAddress;
//        this.formaPagamento = formaPagamento;
//        this.dataPedido = dataPedido;
//        this.statusPedido = statusPedido;
//        this.itens = itens;
//        this.valorPedido = valorPedido;
//        this.pagamento = pagamento;
//
//    }

}
