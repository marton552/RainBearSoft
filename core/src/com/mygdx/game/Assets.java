//https://github.com/tuskeb/mester
package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;


	//https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "alegreyaregular.otf";
		fontParameter.fontParameters.size = 35;
		fontParameter.fontParameters.characters = Globals.CHARS;
	}

	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>("alegreyaregular.otf", BitmapFont.class, fontParameter);

	public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE
			= new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
	public static final AssetDescriptor<Texture> TABLE_TEXTURE
			= new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);

	public static final AssetDescriptor<Texture> CURSOR_TEXTURE
			= new AssetDescriptor<Texture>("cursor.png", Texture.class);
	public static final AssetDescriptor<Texture> TEXTBOX_TEXTURE
			= new AssetDescriptor<Texture>("textbox.png", Texture.class);

	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("explosion.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> STAR_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("mosoly.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> LOADING_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("loading.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> ELTALALTAD_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("eltalaltad.atlas", TextureAtlas.class);

	/*
    public static final AssetDescriptor<Music> MUSIC
            = new AssetDescriptor<Music>("***.mp3", Music.class);
*/
    public static final AssetDescriptor<Sound> STAR_SOUND
            = new AssetDescriptor<Sound>("star.wav", Sound.class);



    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {

		//https://github.com/libgdx/libgdx/wiki/Managing-your-assets
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(BADLOGIC_TEXTURE);
		manager.load(TABLE_TEXTURE);
		manager.load(TEXTBOX_TEXTURE);
		manager.load(CURSOR_TEXTURE);

		manager.load(EXPLOSION_TEXTUREATLAS);
		manager.load(STAR_TEXTUREATLAS);
		manager.load(LOADING_TEXTUREATLAS);
		manager.load(ELTALALTAD_TEXTUREATLAS);

		manager.load(STAR_SOUND);

		manager.load(ALEGREYAREGULAR_FONT);

		/*
        manager.load(MUSIC);
        */

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
