package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class MenuStage extends MyStage {
    public Music music = Assets.manager.get(Assets.MUSIC);
    private MyLabel cim;
    private MyButton playButton;
    private MyButton aboutButton;

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

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MAINAMENU_TEXTURE)){
            @Override
            protected void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
            }
        });
        cim = new MyLabel("Game");
        cim.setPosition(getViewport().getWorldWidth() / 2 - cim.getWidth() / 2, getViewport().getWorldHeight() - cim.getHeight() - 40);
        addActor(cim);

        playButton = new MyButton("Játék");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game));
                for (float i = music.getVolume(); music.getVolume() > 0; i = i - 0.01f){
                    music.setVolume(i);
                }
            }
        });

        playButton.setPosition(getViewport().getWorldWidth() / 2 - playButton.getWidth() / 2, cim.getY() - playButton.getHeight() - 60);
        addActor(playButton);

        aboutButton = new MyButton("Segítség");
        aboutButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game));
            }
        });
        aboutButton.setPosition(getViewport().getWorldWidth() / 2 - aboutButton.getWidth() / 2, playButton.getY() - aboutButton.getHeight() - 30);
        addActor(aboutButton);

    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (!music.isPlaying())
        {
            music.play();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
