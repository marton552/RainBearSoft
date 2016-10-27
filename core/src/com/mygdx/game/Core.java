package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

public class Core {
    private ArrayList<Integer> muveletek = new ArrayList<Integer>();
    private ArrayList<Integer> muveletszamok = new ArrayList<Integer>();
    private ArrayList<Integer> szamok = new ArrayList<Integer>();

    private ArrayList<Integer> memsz = new ArrayList<Integer>();
    private ArrayList<Integer> mem = new ArrayList<Integer>();

    private int utolsoszam;
    private int elso;
    private int masodik;
    private boolean beallitva = false;
    private int randomSzam = 0;

    private Random r = new Random();

    public Core(int szammennyiseg, int elsoszam){

        memsz = new ArrayList<Integer>(); //Mentett Művelet Számok
        mem = new ArrayList<Integer>(); //Mentett Műveletek

        utolsoszam = elsoszam;
        szamok.add(utolsoszam);

        memsz.add(utolsoszam);
        mem.add(r.nextInt(3));

        for (int i = 0; i < szammennyiseg; i++) {
            memsz.add(r.nextInt(9) + 1);

            if (i != szammennyiseg - 1) {
                if(beallitva){
                    mem.add(r.nextInt(2));
                }else{
                    randomSzam = r.nextInt(3);
                    if(randomSzam == 2) {
                        beallitva = true;
                    }else {
                        mem.add(randomSzam);
                    }
                }


            }
        }

        for(int j = 0; j < 5; j++) {
            szamolas();
        }

    }

    public ArrayList<Integer> getSzamok(){
        return szamok;
    }

    public void generalas(int szammennyiseg, int elsoszam){
        muveletek.clear();
        muveletszamok.clear();
        mem.clear();
        memsz.clear();

        utolsoszam = elsoszam;
        szamok.add(utolsoszam);

        memsz.add(utolsoszam);
        mem.add(r.nextInt(3));

        for (int i = 0; i < szammennyiseg; i++) {
            memsz.add(r.nextInt(9) + 1);

            if (i != szammennyiseg - 1) {
                if(beallitva){
                    mem.add(r.nextInt(2));
                }else{
                    randomSzam = r.nextInt(3);
                    if(randomSzam == 2) {
                        beallitva = true;
                    }else {
                        mem.add(randomSzam);
                    }
                }


            }
        }

        for(int j = 0; j < 5; j++) {
            szamolas();
        }

    }

    private void szamolas(){
        /*System.out.println("==");
        System.out.println(mem);
        System.out.println(memsz);
        System.out.println(muveletek);
        System.out.println(muveletszamok);
        System.out.println("==");*/
        muveletszamok.clear();
        muveletszamok.addAll(memsz);
        muveletek.clear();
        muveletek.addAll(mem);
        /*System.out.println("==");
        System.out.println(mem);
        System.out.println(memsz);
        System.out.println(muveletek);
        System.out.println(muveletszamok);*/
            for (int i = 0; i < muveletek.size(); i++) {
                if (muveletek.get(i) == 2) { //2-es a szorzás
                    elso = muveletszamok.get(i);
                    masodik = muveletszamok.get(i + 1);
                    muveletszamok.remove(i + 1);
                    muveletek.remove(i);

                    muveletszamok.set(i, elso * masodik);

                    i--;

                    //System.out.println(muveletek + " - szoroztam");
                    //System.out.println(muveletszamok);
                }
            }


            for (int i = 0; i < muveletek.size(); i++) {
                elso = muveletszamok.get(i);
                masodik = muveletszamok.get(i + 1);
                muveletszamok.remove(i + 1);

                if (muveletek.get(i) == 0) { //összeadás
                    muveletszamok.set(i, elso + masodik);

                } else { //kivonás
                    muveletszamok.set(i, elso - masodik);
                }
                muveletek.remove(i);
                i--;
            
                //System.out.println(muveletek + " - összeadás/kivonás");
                //System.out.println(muveletszamok);
            }

            utolsoszam = muveletszamok.get(0);
            memsz.set(0, utolsoszam);
            szamok.add(utolsoszam);


    }


}
