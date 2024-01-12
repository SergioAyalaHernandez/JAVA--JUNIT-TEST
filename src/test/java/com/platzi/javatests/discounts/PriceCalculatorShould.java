package com.platzi.javatests.discounts;

import com.platzi.javatests.payments.PaymentGateway;
import com.platzi.javatests.payments.PaymentProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PriceCalculatorShould {
    PriceCalculator calculator = new PriceCalculator();
    @Before
    public void setup(){
        // preparación del escenario que vamos a usar en el test
        calculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_prices() {

        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {

        calculator.addPrice(10.0);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(), is(25.5));
    }

    @Test
    public void apply_discount_to_prices() {
        calculator.addPrice(150);
        calculator.addPrice(50);
        calculator.setDiscount(25);
        assertThat(calculator.getTotal(), is(150.0));
    }
}