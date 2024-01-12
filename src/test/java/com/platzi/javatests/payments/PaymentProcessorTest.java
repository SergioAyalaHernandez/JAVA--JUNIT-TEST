package com.platzi.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    //la etiqueta before, es para que antes de realizar cualquier cosa, junit sepa que debe realizar primero
    @Before
    public void setup(){
        // preparación del escenario que vamos a usar en el test
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //ejecución del metodo
        boolean result = paymentProcessor.makePayment(1000);

        // verificación del resultado
        assertTrue(result);
    }

    @Test
    public void payment_is_wrong() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}