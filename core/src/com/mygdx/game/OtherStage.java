package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class OtherStage extends MyStage {
    private TextButton textButton;
    public Music jatekmusic = Assets.manager.get(Assets.JATEK);
    public OtherStage(Game game) {
        super(game);
    }

    public OtherStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
    }

    public OtherStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    @Override
    public void act() {
        super.act();
    }

    protected void init() {
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GAME_TEXTURE)){
            @Override
            protected void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
            }
        });

        textButton = new MyButton("Vissza");
        Core c = new Core(3, 6);
        textButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }

        });

        addActor(textButton);

    }
}
