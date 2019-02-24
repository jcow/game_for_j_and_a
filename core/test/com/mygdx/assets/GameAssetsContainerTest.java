package com.mygdx.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.HashSet;
import java.util.Set;

public class GameAssetsContainerTest {

    @Test
    public void loadTest() {

        Array<String> loadedTextures = new Array();
        loadedTextures.add("a");
        loadedTextures.add("b");
        loadedTextures.add("c");

        Set<String> textures = new HashSet<String>();
        textures.add("c");
        textures.add("d");

        AssetConfiguration assetConfiguration = new AssetConfiguration(textures);

        AssetManager assetManager = Mockito.mock(AssetManager.class);
        Mockito.when(assetManager.getAssetNames()).thenReturn(loadedTextures);

        GameAssetsContainer gameAssetsContainer = new GameAssetsContainer();
        Whitebox.setInternalState(gameAssetsContainer, "assetManager", assetManager);

        gameAssetsContainer.load(assetConfiguration);

        Mockito.verify(assetManager, Mockito.times(2)).get(Mockito.anyString(), Mockito.any(Class.class));
        Mockito.verify(assetManager, Mockito.times(1)).load(Mockito.anyString(), Mockito.any(Class.class));

    }

}
