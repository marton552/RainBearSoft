package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {
    private BadlActor badlActor;
    private CrossActor crossActor;
    private TextButton textButton, textButton2;
    private ExplosionActor explosionActor;
    private StarActor animation;
    private MyLabel cim;

    public MenuStage(Game game) {
        super(game);
    }

    public MenuStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public MenuStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    public void init()
    {
        textButton = new MyButton("Előre");
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new OtherScreen(game));
            }
        });

        cim = new MyLabel("Game");
        cim.setFontScale(0.8f);
        cim.setPosition(getWidth() / 2 - cim.getWidth() / 2, getHeight() - cim.getHeight());
        animation = new StarActor();
        animation.setFps(30);
        animation.setSize(300, 300);
        animation.setPosition(getWidth() / 2 - animation.getWidth() / 2, 0);
        addActor(animation);
        addActor(cim);


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
