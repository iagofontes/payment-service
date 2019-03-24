package br.com.fiap.paymentservice.repository;

import br.com.fiap.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Component
public class PaymentRepository {

    public ArrayList<Payment> payments = new ArrayList<Payment>();

    @Autowired
    public Payment pagamento;

    public Payment findById(Long idTransacao) {

        try {
            this.limparPegamento();
            if (this.payments.size() > 0) {
                this.payments.forEach((element) -> {
                    if (element.getIdTransacao().equals(idTransacao)) {
                        pagamento = element;
                    }
                });

                if (pagamento.getIdTransacao() <= 0)
                    this.limparPegamento();
            }
            return pagamento;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean savePayment(Payment payment) {
        this.payments.add(payment);
        return true;
    }

    public boolean updatePayment(Payment payment) {
        for(int i = 0; i<=this.payments.size(); i++) {
            if(this.payments.get(i).getIdTransacao().equals(payment.getIdTransacao())) {
                this.payments.set(i, payment);
                return true;
            }
        }
        return false;
    }

    public boolean removePayment(Long idTransacao) {
        for(int i = 0; i<=this.payments.size(); i++) {
            if(this.payments.get(i).getIdTransacao().equals(idTransacao)) {
                this.payments.remove(i);
                return true;
            }
        }
        return false;
    }

    private void limparPegamento(){
        try{
            pagamento.setIdTransacao(Long.parseLong("0"));
            pagamento.setBandeiraCartao("");
            pagamento.setNumeroCartao("");
            pagamento.setValidadeCartao("03/2019");
            pagamento.setValorCompra(new BigDecimal(0));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
