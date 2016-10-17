package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

public class Core {
    public void generalas(){
        ArrayList<Integer> szamok = new ArrayList();
        ArrayList<Integer> muveletek = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            szamok.add(random.nextInt(9) + 1);
        }
        for (int i = 0; i < 4; i++) {
            muveletek.add(random.nextInt(3));
        }
    }
}