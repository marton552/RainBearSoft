package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.math.Matrix4;


/**
 * Created by tuskeb on 2016. 10. 01..
 */
public class TimerLabel extends Label {
    float elapsedtime =0;
    public static com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle style;
    public static com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle cstyle;
    private int szamol = 0;
    static
    {
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.CHALK_FONT);
        style.fontColor = Color.WHITE;
        Pixmap p = new Pixmap(1,1, Pixmap.Format.RGBA8888);
        p.setColor(1f, 1f, 1f, 1f);
        p.fill();


    }

    public TimerLabel(String text) {
        super(text, style);
        setAlignment(Align.center);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        szamol++;
        elapsedtime += delta;
        setFontScale(Math.abs((float)Math.sin(elapsedtime*2f))/2f+0.3f);

        if(szamol%29 == 0){
            cstyle = getStyle();
            cstyle.fontColor = Color.RED;
            setStyle(cstyle);
        }else if(szamol%61 == 0){
            cstyle = getStyle();
            cstyle.fontColor = Color.WHITE;
            setStyle(cstyle);
        }


    }

}
