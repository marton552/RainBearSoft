package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class PlayStage extends MyStage {
    //private TextButton textButton;
    private OneSpriteStaticActor paper;
    private PencilLabel hely1;
    private PencilLabel hely2;
    private PencilLabel hely3;
    private MyLabel sorozat;
    private OneSpriteStaticActor circle1;
    private OneSpriteStaticActor circle2;
    private OneSpriteStaticActor circle3;
    private int helyeshely = 0;
    private Core c;
    private Random rand;
    private ArrayList<Integer> csz;
    private ArrayList<Integer> szamok;
    private PencilLabel roundlabel;
    private int animate;
    private float lepes;
    private int tick;
    private int timedown = 60;
    private boolean timerRunning = true;
    private Timer timer;
    private TimerLabel timerl;

    //public Music jatekmusic = Assets.manager.get(Assets.JATEK);
    public PlayStage(Game game) {
        super(game);
    }

    public PlayStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public PlayStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    public void act() {
        super.act();
    }

    protected void init() {
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TABLE_TEXTURE)){
            @Override
            protected void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
            }
        });

        paper = new OneSpriteStaticActor(Assets.manager.get(Assets.PAPER_TEXTURE));
        paper.setWidth(getViewport().getWorldWidth());
        paper.setY(paper.getY() - 400);

        addActor(paper);

        /*textButton = new MyButton("Vissza");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new EndScreen(game));
            }
        });
        addActor(textButton);*/

        sorozat = new MyLabel("");
        addActor(sorozat);

        roundlabel = new PencilLabel("");
        addActor(roundlabel);

        hely1 = new PencilLabel("");
        hely2 = new PencilLabel("");
        hely3 = new PencilLabel("");

        circle1 = new OneSpriteStaticActor(Assets.manager.get(Assets.CIRCLE_TEXTURE));
        circle2 = new OneSpriteStaticActor(Assets.manager.get(Assets.CIRCLE_TEXTURE));
        circle3 = new OneSpriteStaticActor(Assets.manager.get(Assets.CIRCLE_TEXTURE));
        circle1.setVisible(false);
        circle2.setVisible(false);
        circle3.setVisible(false);


        addActor(circle1);
        addActor(circle2);
        addActor(circle3);

        timerl = new TimerLabel(""+timedown);
        timerl.setPosition(20, getViewport().getWorldHeight() - timerl.getHeight() - 10);
        timerl.setFontScale(1);
        addActor(timerl);

        hely1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(helyeshely == 0) {
                    circle1.setVisible(true);
                    Globals.ROUNDS = Globals.ROUNDS + 1;
                    //kiirasok();
                    animate = 1;
                }else{
                    game.setScreen(new EndScreen(game));
                }


            }
        });

        hely2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(helyeshely == 1) {
                    circle2.setVisible(true);
                    Globals.ROUNDS = Globals.ROUNDS + 1;
                    //kiirasok();
                    animate = 1;
                }else{
                    game.setScreen(new EndScreen(game));
                }


            }
        });

        hely3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(helyeshely == 2) {
                    circle3.setVisible(true);
                    Globals.ROUNDS = Globals.ROUNDS + 1;
                    //kiirasok();
                    animate = 1;
                }else{
                    game.setScreen(new EndScreen(game));
                }


            }
        });

        addActor(hely1);
        addActor(hely2);
        addActor(hely3);

        //System.out.println(c.getSzamok());
        kiirasok();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        tick++;
        if(animate == 1) {

            if(paper.getX() < 0 - paper.getWidth()) {
                paper.setX(getViewport().getWorldWidth() + paper.getWidth() + 1);
                lepes = paper.getX()/200;
                kiirasok();
                animate = 2;
            }else{
                paper.setX(paper.getX() - 20);
            }

        }

        if(animate == 2){

            if((int)paper.getX() != 0){
                paper.setX(paper.getX() - lepes);
            }else{
                animate = 0;
            }
        }

        if(tick%60 == 0){
            if(timerRunning){
                timedown--;
                System.out.println(timedown);
                timerl.setText(""+timedown);
            }
            tick = 0;
        }
        //System.out.println(animate);

        hely2.setPosition(paper.getX() + paper.getWidth() / 2, 30);
        hely1.setPosition(hely2.getX() - hely2.getWidth() / 2 - hely1.getWidth() - getViewport().getWorldWidth() / 5, 30);
        hely3.setPosition(hely2.getX() + hely2.getWidth() / 2 + hely3.getWidth() + getViewport().getWorldWidth() / 5, 30);
        roundlabel.setPosition(hely1.getX() - 30, 90);

        circle1.setPosition(hely2.getX() - hely2.getWidth() / 2 - hely1.getWidth() - (paper.getX() + paper.getWidth()) / 5 - circle1.getWidth() / 2, hely1.getY() - (circle1.getHeight() / 2) / 2);
        circle2.setPosition(hely2.getX() - circle2.getWidth() / 2, hely2.getY() - (circle2.getHeight() / 2) / 2);
        circle3.setPosition(hely3.getX() - circle3.getWidth() / 2, hely3.getY() - (circle3.getHeight() / 2) / 2);
    }


    private void kiirasok(){

        c = new Core(3, 5);

        csz = new ArrayList<Integer>();
        szamok = new ArrayList<Integer>();

        rand = new Random();

        System.out.println(c.getSzamok());

        csz.addAll(c.getSzamok());

        szamok.add(csz.get(5));
        szamok.add(csz.get(5) - rand.nextInt(56) + 1);
        szamok.add(csz.get(5) + rand.nextInt(16) + 1);

        helyeshely = rand.nextInt(3);

        sorozat.setText("");

        for(int i = 0; i < csz.size() - 2; i++){
            sorozat.setText(sorozat.getText() + "" + csz.get(i) + ", ");
        }
        sorozat.setText(sorozat.getText() + "" + csz.get(4) + ", ?");
        sorozat.setFontScale(0.6f);

        sorozat.setPosition(getViewport().getWorldWidth() / 2, getViewport().getWorldHeight() / 1.5f + 30);

        if(helyeshely == 0) {
            hely1.setText("" + szamok.get(0));
            hely2.setText("" + szamok.get(1));
            hely3.setText("" + szamok.get(2));
        }else if(helyeshely == 1){
            hely1.setText("" + szamok.get(1));
            hely2.setText("" + szamok.get(0));
            hely3.setText("" + szamok.get(2));
        }else if(helyeshely == 2){
            hely1.setText("" + szamok.get(2));
            hely2.setText("" + szamok.get(1));
            hely3.setText("" + szamok.get(0));
        }

        roundlabel.setText(""+Globals.ROUNDS+". feladat.");
        roundlabel.getLabel().setAlignment(Align.left);

        circle1.setSize(120, 70);
        circle1.setVisible(false);

        circle2.setSize(120, 70);
        circle2.setVisible(false);

        circle3.setSize(120, 70);
        circle3.setVisible(false);
    }
    @Override
    public void draw() {
        super.draw();

    }
}
