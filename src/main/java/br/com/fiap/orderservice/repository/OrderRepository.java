package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.model.Item;
import br.com.fiap.orderservice.model.Order;
import br.com.fiap.orderservice.model.Pagamento;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//@Repository
@Component
public class OrderRepository {

    public ArrayList<Order> orders = new ArrayList<Order>();
    public ArrayList<Item> itens = new ArrayList<Item>();

    @Autowired
    public Order pedido;

    @Autowired
    public Item item;
    @Autowired
    public Order order;
    @Autowired
    public Pagamento pagamento;

//    @PostConstruct
//    public void init() throws Exception {
//        item.setNome("Lanche");
//        item.setDescricao("lanche legal");
//        item.setValor(10.00);
//        this.itens.add(item);
//
//        pagamento.setIdTransacao(Long.parseLong("10213201"));
//        pagamento.setBandeira("MasterCard");
//        pagamento.setNumeroCartao("5896125478541254");
//        pagamento.setValidadeCartao(new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-23"));
//
//        order.setIdPedido(Long.parseLong("1020300"));
//        order.setEmail("contato@fiap.com.br");
//        order.setNomeCompleto("Contato da Silva");
//        order.setShippingAddress("Rua das Camélias, 245 - São Paulo");
//        order.setFormaPagamento("DEBITO");
//        order.setDataPedido(new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-23"));
//        order.setStatusPedido("EM ANDAMENTO");
//        order.setItens(itens);
//        order.setValorPedido(10.00);
//        order.setPagamento(pagamento);
//        this.orders.add(order);
//
//    }

    public Order findById(Long idPedido) {

        try {
            this.limparPedido();
            if (this.orders.size() > 0) {
                this.orders.forEach((element) -> {
                    if (element.getIdPedido().equals(idPedido)) {
                        pedido = element;
                    }
                });

                if (pedido.getIdPedido() <= 0)
                    pedido = new Order();
            }
            return pedido;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Order order) {
        this.orders.add(order);
        return true;
    }

    public boolean updateOrder(Order order) {
        for(int i = 0; i<=this.orders.size(); i++) {
            if(this.orders.get(i).getIdPedido().equals(order.getIdPedido())) {
                this.orders.set(i, order);
                return true;
            }
        }
        return false;
    }

    public boolean removeOrder(Long idPedido) {
        for(int i = 0; i<=this.orders.size(); i++) {
            if(this.orders.get(i).getIdPedido().equals(idPedido)) {
                this.orders.remove(i);
                return true;
            }
        }
        return false;
    }

    private void limparPedido(){

        try{
            pedido.setIdPedido(Long.parseLong("0"));
            pedido.setEmail("");
            pedido.setNomeCompleto("");
            pedido.setShippingAddress("");
            pedido.setFormaPagamento("");
            pedido.setDataPedido(new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-23"));
            pedido.setStatusPedido("");
            pedido.setItens(null);
            pedido.setValorPedido(0.0);
            pedido.setPagamento(null);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

}
