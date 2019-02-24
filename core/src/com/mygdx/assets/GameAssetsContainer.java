package com.mygdx.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameAssetsContainer {

    private static GameAssetsContainer instance;

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private Texture loadingTexture;
    private Camera camera;

    protected GameAssetsContainer() {}

    public static GameAssetsContainer getInstance() {
        if(instance == null) {
            instance = new GameAssetsContainer();
            instance.setup();
        }

        return instance;
    }

    protected void setup() {
        this.assetManager = createAssetManager();
        this.spriteBatch = createSpriteBatch();
        this.font = this.createFont();
        this.loadingTexture = createLoadingTexture();
        this.camera = createCamera(getWidth(), getHeight());

        setupCamera();
        setupSpriteBatch();
    }

    public void load(AssetConfiguration assetConfiguration) {

        Set<String> loadedAssets = new HashSet<String>(Arrays.asList(assetManager.getAssetNames().items));

        Set<String> texturesToLoad = getAssetsToLoad(assetConfiguration.getTextures(), loadedAssets);
        Set<String> texturesToUnload = getAssetsToUnload(assetConfiguration.getTextures(), loadedAssets);

        for(String textureToUnload : texturesToUnload) {
            Texture texture = assetManager.get(textureToUnload, Texture.class);
            if(texture != null) {
                texture.dispose();
            }
        }

        for(String textureToLoad : texturesToLoad) {
            assetManager.load(textureToLoad, Texture.class);
        }

        assetManager.finishLoading();
    }

    protected Set<String> getAssetsToLoad(Set<TextureDefinition> incomingFiles, Set<String> alreadyLoaded) {
        Set<String> thingsToLoad = new HashSet<String>();
        for(TextureDefinition definition : incomingFiles) {
            String filename = definition.getPath();
            if(filename != null && !alreadyLoaded.contains(filename)) {
                thingsToLoad.add(filename);
            }
        }

        return thingsToLoad;
    }

    protected Set<String> getAssetsToUnload(Set<TextureDefinition> incomingDefinitions, Set<String> alreadyLoaded) {

        Set<String> incomingFiles = new HashSet<String>();
        for(TextureDefinition textureDefinition : incomingDefinitions) {
            incomingFiles.add(textureDefinition.getPath());
        }

        Set<String> thingsToUnload = new HashSet<String>();
        for(String filename : alreadyLoaded) {
            if(filename != null && !incomingFiles.contains(filename)) {
                thingsToUnload.add(filename);
            }
        }

        return thingsToUnload;
    }

    protected void setupSpriteBatch() {
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    protected void setupCamera() {
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
    }

    protected SpriteBatch createSpriteBatch(){
        return new SpriteBatch();
    }

    protected AssetManager createAssetManager(){
        return new AssetManager();
    }

    protected BitmapFont createFont() {
        return new BitmapFont();
    }

    protected Texture createLoadingTexture() {
        return new Texture(TextureDefinition.LOADING_SCREEN.getPath());
    }

    protected Camera createCamera(int w, int h) {
        return new OrthographicCamera(w, h);
    }

    protected int getWidth() {
        return Gdx.graphics.getWidth();
    }

    protected int getHeight() {
        return Gdx.graphics.getHeight();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Texture getTexture(TextureDefinition textureDefinition) {
        return assetManager.get(textureDefinition.getPath(), Texture.class);
    }

    public Texture getLoadingTexture(){
        return this.loadingTexture;
    }

    public void dispose() {
        assetManager.dispose();
        spriteBatch.dispose();
        font.dispose();
        loadingTexture.dispose();
    }
}
