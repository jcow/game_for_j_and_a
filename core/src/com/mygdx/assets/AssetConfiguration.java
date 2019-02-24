package com.mygdx.assets;

import java.util.Set;

public class AssetConfiguration {

    private Set<TextureDefinition> textures;

    public AssetConfiguration(Set<TextureDefinition> textures) {
        this.textures = textures;
    }

    public Set<TextureDefinition> getTextures() {
        return textures;
    }

}
