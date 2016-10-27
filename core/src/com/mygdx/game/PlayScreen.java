package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class PlayScreen extends MyScreen {
    protected PlayStage playStage;
    public PlayScreen(Game game) {
        super(game);
        r = 1;
        g = 0.5f;
        b = 0.3f;
        playStage = new PlayStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(playStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        playStage.act(delta);
        playStage.draw();

    }
}
