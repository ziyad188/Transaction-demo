package ziyad.com.springboottransactiondemo.Exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }
}
