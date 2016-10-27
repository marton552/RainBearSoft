package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {
    public Music music = Assets.manager.get(Assets.MUSIC);
    private MyLabel cim;
    private MyButton playButton;
    private MyButton aboutButton;
    private OneSpriteStaticActor bg;
    private float lepes;

    public MenuStage(Game game) {
        super(game);
    }

    public MenuStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public MenuStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public void init() {

        /*addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MAINAMENU_TEXTURE)){
            @Override
            protected void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());


            }
        });*/

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MAINAMENU_TEXTURE));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg);


        if(Globals.MAINMENU_CREATED == false) {
            bg.setPosition(0, getViewport().getWorldHeight() + bg.getHeight() + 1);
            lepes = bg.getY()/180;
        }

        cim = new MyLabel("Count!");
        addActor(cim);

        playButton = new MyButton("Play");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PlayScreen(game));
                Globals.ROUNDS = 1;
                for (float i = music.getVolume(); music.getVolume() > 0; i = i - 0.01f){
                    music.setVolume(i);
                }
            }
        });


        addActor(playButton);

        aboutButton = new MyButton("About");
        aboutButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new AboutScreen(game));
            }
        });
        addActor(aboutButton);

    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (!music.isPlaying())
        {
            music.play();

        }

        if(Globals.MAINMENU_CREATED == false){

            if((int) bg.getY() != 0) {
                bg.setY(bg.getY() - lepes);
                cim.setPosition(bg.getWidth() / 2 - cim.getWidth() / 2, bg.getY() + bg.getHeight() - cim.getHeight() - 40);
                playButton.setPosition(bg.getWidth() / 2 - playButton.getWidth() / 2, cim.getY() - playButton.getHeight() - 60);
                aboutButton.setPosition(bg.getWidth() / 2 - aboutButton.getWidth() / 2, playButton.getY() - aboutButton.getHeight() - 30);

            }else{
                Globals.MAINMENU_CREATED = true;
            }
        }else{
            cim.setPosition(bg.getWidth() / 2 - cim.getWidth() / 2, bg.getHeight() - cim.getHeight() - 40);
            playButton.setPosition(bg.getWidth() / 2 - playButton.getWidth() / 2, cim.getY() - playButton.getHeight() - 60);
            aboutButton.setPosition(bg.getWidth() / 2 - aboutButton.getWidth() / 2, playButton.getY() - aboutButton.getHeight() - 30);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
