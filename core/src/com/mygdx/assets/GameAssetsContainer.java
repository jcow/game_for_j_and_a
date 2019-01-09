package com.mygdx.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.config.TextureDefinition;

import java.util.HashMap;
import java.util.Map;

public class GameAssetsContainer {

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private Map<TextureDefinition, Texture> textures;

    public GameAssetsContainer() {
        assetManager = new AssetManager();
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        textures = new HashMap<TextureDefinition, Texture>();

        textures.put(TextureDefinition.SPRITE_SHEET, new Texture(TextureDefinition.SPRITE_SHEET.getPath()));
        textures.put(TextureDefinition.MAIN_MENU, new Texture(TextureDefinition.MAIN_MENU.getPath()));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Map<TextureDefinition, Texture> getTextures() {
        return textures;
    }

    public void dispose() {
        assetManager.dispose();
        spriteBatch.dispose();
        font.dispose();
        for(TextureDefinition textureDefinition : textures.keySet()) {
            textures.get(textureDefinition).dispose();
        }
    }
}
