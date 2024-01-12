package com.platzi.javatests.player;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.*;

public class playerTest {

    @Test
    public void loose_when_dice_number_is_too_low() {

        //Dice dice = new Dice(6);
        //dado simulado con mook de mokito
        Dice dice = Mockito.mock(Dice.class);
        //basicamente, quema el valor de acuerdo a nuestra necesidad
        Mockito.when(dice.roll()).thenReturn(3);
        Player player =  new Player(dice,3);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        Player player =  new Player(dice,3);
        assertTrue(player.play());
    }
}