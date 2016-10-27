package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Assets;

public class PencilLabel extends TextButton {
    static TextButton.TextButtonStyle textButtonStyle;
    static
    {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.PENCIL_FONT);
        textButtonStyle.fontColor = Color.BLACK;


        /*Pixmap p = new Pixmap(300, 10, Pixmap.Format.RGBA8888);
        p.setColor(1f, 1f, 1f, 0f);
        p.fill();
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(1f, 1f, 1f, 0f);
        p.fill();
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

        p.setColor(1f, 1f, 1f, 0f);
        p.fill();
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(p)));*/

    }
    public PencilLabel(String text) {
        super(text, textButtonStyle);
        init();
    }


    protected void init()
    {
    }
}