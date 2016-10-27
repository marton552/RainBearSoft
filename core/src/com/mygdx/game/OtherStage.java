package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OtherStage extends MyStage {
    private TextButton textButton;
    public Music jatek1 = Assets.manager.get(Assets.JATEK1);
    public Music jatek2 = Assets.manager.get(Assets.JATEK2);
    public Music jatek3 = Assets.manager.get(Assets.JATEK3);
    int zene = 0;
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
        zene();
    }
    
    public void zene() {
        if (zene == 0 && !(jatek1.isPlaying()))  {
            zene = 1;
            jatek2.play();
        } else {
            if (zene == 1 && !(jatek2.isPlaying()))  {
                 zene = 2;
                 jatek3.play();
            } else {
                 if (zene == 2 && !(jatek3.isPlaying())) {
                      zene = 0;
                      jatek1.play();
                } 
            }
        }
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
