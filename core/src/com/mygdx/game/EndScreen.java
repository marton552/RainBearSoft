package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by tuskeb on 2016. 10. 01..
 */
public class EndScreen extends MyScreen {

    MyStage myStage;

    public EndScreen(Game game) {
        super(game);

        //Ha nem akarunk annyi fájlt, akkor lehet egy anonim osztály is.
        myStage = new MyStage(viewport, spriteBatch, game)
        {
            private String random()
            {
                return String.valueOf((int)(Math.random()*10));
            }

            //Itt a MyStage osztályt folytatjuk. Referenciaként a myStage változó lesz, amiből például a render is dolgozik.
            private Table table;

            private MyLabel cim;
            private TextBoxLabel alcim;
            private int round;


            protected void init() {
                setBackGroundColor(0f,0.2f,0.4f);
                round = Globals.ROUNDS - 1;
                addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TABLE_TEXTURE)){
                    @Override
                    protected void init() {
                        super.init();
                        setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
                    }
                });

                cim = new MyLabel("Game Over");
                cim.setPosition(getViewport().getScreenWidth() / 2 - cim.getWidth() / 2, getViewport().getWorldHeight() - cim.getHeight() - 30);
                addActor(cim);

                alcim = new TextBoxLabel("Összesen " + round + " feleadatot\n sikerült megoldanod.");
                alcim.setPosition(getViewport().getWorldWidth() / 2 - alcim.getWidth() / 2, cim.getY() - cim.getHeight() - 50);

                addActor(alcim);

                addActor(new MyButton("Vissza a menübe"){
                    @Override
                    protected void init() {
                        setPosition(getViewport().getScreenWidth() / 2 - getWidth() / 2, 30);

                        addListener(new ClickListener(){
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                super.clicked(event, x, y);
                                game.setScreen(new MenuScreen(game));
                            }
                        });
                    }
                });

            }
        };
        Gdx.input.setInputProcessor(myStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        myStage.act(delta);
        myStage.draw();

    }

    @Override
    public void dispose() {
        super.dispose();
        myStage.dispose();
    }

}
