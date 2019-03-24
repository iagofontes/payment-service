package br.com.fiap.paymentservice.controller;

import br.com.fiap.paymentservice.model.Payment;
import br.com.fiap.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class PaymentServiceController {

    @Autowired
    private PaymentRepository paymentRepository;
    private Payment payment;

    @GetMapping("/teste")
    public ResponseEntity teste() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/findById/{idTransacao}")
    public ResponseEntity findById(@PathVariable(value="idTransacao", required = true) Long idTransacao) {

        payment = this.paymentRepository.findById(idTransacao);

        System.out.printf("idTransacao %s", payment.getIdTransacao());

        return new ResponseEntity(payment, HttpStatus.OK);
    }

    @PostMapping(path="/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity save(@RequestBody Payment payment2) {

        try {
            if(this.paymentRepository.savePayment(payment2)) {
                Map<String, Object> message = new HashMap<>();
                message.put("severity", "info");
                message.put("location", "http://localhost:8080/findById/"+payment2.getIdTransacao().toString());
                message.put("summary", "Created successfully.");
                message.put("code", 201);

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("message", message);

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");

                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.CREATED));
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="/update/{idTransacao}", consumes = "application/json", produces = "application/json")
    public ResponseEntity update(
            @PathVariable(value="idTransacao", required = true) Long idTransacao,
            @RequestBody Payment payment2) {

        try {
            payment.setIdTransacao(idTransacao);
            if(this.paymentRepository.updatePayment(payment2)) {
                Map<String, Object> message = new HashMap<>();
                message.put("severity", "info");
                message.put("location", "http://localhost:8080/findById/"+payment2.getIdTransacao().toString());
                message.put("summary", "Updated successfully.");
                message.put("code", 200);

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("message", message);

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idTransacao}")
    public ResponseEntity deletePayment(@PathVariable(value="idTransacao", required = true) Long idTransacao) {
        try {
            if(this.paymentRepository.removePayment(idTransacao)) {
                Map<String, Object> message = new HashMap<>();
                message.put("severity", "info");
                message.put("summary", "Removed successfully.");
                message.put("code", 200);

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("message", message);

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
