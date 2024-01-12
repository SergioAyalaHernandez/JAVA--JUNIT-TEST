package com.platzi.javatests.player;

import java.util.Random;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll(){
        int resultado = new Random().nextInt(sides) + 1;
        System.out.println(resultado);
        return resultado;
    }

}
