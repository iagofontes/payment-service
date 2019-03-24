package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.model.Order;
import br.com.fiap.orderservice.repository.OrderRepository;
import com.sun.xml.internal.ws.api.message.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class OrderServiceController {

    @Autowired
    private OrderRepository orderRepository;
    private Order order;

    @GetMapping("/teste")
    public ResponseEntity teste() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/orders/{idPedido}")
    public ResponseEntity findById(@PathVariable(value="idPedido", required = true) Long idPedido) {

        order = this.orderRepository.findById(idPedido);

        System.out.printf("idPedido %s", order.getIdPedido());

        return new ResponseEntity(order, HttpStatus.OK);
    }

    @PostMapping(path="/orders", consumes = "application/json", produces = "application/json")
    public ResponseEntity save(@RequestBody Order order) {

        try {
            if(this.orderRepository.saveOrder(order)) {
                Map<String, Object> message = new HashMap<>();

                message.put("severity", "info");
                message.put("location", "/");
                message.put("summary", "Authenticated successfully.");
                message.put("code", 200);
                message.put("href", "http://localhost:8080/orders/"+order.getIdPedido().toString());

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("message", message);

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                headers.add("order_link", "http://localhost:8080/orders/"+order.getIdPedido().toString());

                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/orders/{idPedido}", consumes = "application/json", produces = "application/json")
    public ResponseEntity update(
            @PathVariable(value="idPedido", required = true) Long idPedido,
            @RequestBody Order order) {

        try {
            order.setIdPedido(idPedido);
            if(this.orderRepository.updateOrder(order)) {
                System.out.printf("idPedido %s", order.getIdPedido());
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/orders/{idPedido}")
    public ResponseEntity deleteOrder(@PathVariable(value="idPedido", required = true) Long idPedido) {
        try {
            if(this.orderRepository.removeOrder(idPedido)) {
                System.out.printf("idPedido %s", order.getIdPedido());
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
