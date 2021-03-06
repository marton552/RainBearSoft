package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by tuskeb on 2016. 10. 01..
 */
public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";
    //public static final BitmapFont FONT_HOBO_STD;
    //public static final BitmapFont CHALK_FONT;
    public static boolean MAINMENU_CREATED = false;
    public static int ROUNDS = 1;
    public static Music music = Assets.manager.get(Assets.MUSIC);
    public static Music gamemusic = Assets.manager.get(Assets.JATEK);

    static {
        music.stop();
        gamemusic.stop();
        /*
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("alegreyaregular.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;
        parameter.characters = CHARS;
        FONT_HOBO_STD = generator.generateFont(parameter);
        FONT_HOBO_STD.setColor(1, 1, 1, 1f);
        generator.dispose();
*/
       // generator = new FreeTypeFontGenerator(Gdx.files.internal("chalk.otf"));
        //parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //parameter.size = 50;
        //parameter.characters = CHARS;
        //CHALK_FONT = generator.generateFont(parameter);
        //CHALK_FONT.setColor(1, 1, 1, 1f);
        //generator.dispose();
    }

    public static void setMusic(int whichmusic){
        if(whichmusic == 1){
            gamemusic.stop();
            gamemusic.setLooping(false);
            music.setLooping(true);
            music.play();
        }else if(whichmusic == 2){
            music.stop();
            music.setLooping(false);
            gamemusic.setLooping(true);
            gamemusic.play();
        }
    }
}
