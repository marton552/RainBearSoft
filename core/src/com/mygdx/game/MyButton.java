package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MyButton extends TextButton{
    static TextButton.TextButtonStyle textButtonStyle;
    static{
        refresh();
    }


    public static void refresh()
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);


        Pixmap p = new Pixmap(300, 10, Pixmap.Format.RGBA8888);
        p.setColor(1f, 1f, 1f, 0.3f);
        p.fill();
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(1f, 1f, 1f, 0.4f);
        p.fill();
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(1f, 1f, 1f, 0.5f);
        p.fill();
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

    }
    public MyButton(String text) {
        super(text, textButtonStyle);
        init();
    }


    protected void init()
    {
    }
}
