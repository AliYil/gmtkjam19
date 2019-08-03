package com.aliyil.gmtkjam19;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public final class ResourceManager {
    //Resources
    public BitmapFont bitmapFont;

//    public Texture t;
    public TextureAtlas albert;
//
    public Sound shotgun;
    public Sound reload;
    public Sound noAmmo;

    private Game gameInstance;
    private AssetManager assetManager;

    ResourceManager(Game gameInstance) {
        this.gameInstance = gameInstance;

        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);

    }

    void loadResources() {
        assetManager.load("fonts/font.fnt", BitmapFont.class);

        assetManager.load("sprites/albert.atlas", TextureAtlas.class);

//        assetManager.load("textures/.png", Texture.class);
//
        assetManager.load("sounds/shotgun.wav", Sound.class);
        assetManager.load("sounds/reload.ogg", Sound.class);
        assetManager.load("sounds/noammo.wav", Sound.class);

        gameInstance.getParticleEffectManager().loadResources();
    }

    public float getProgress() {
        return assetManager.getProgress();
    }

    public void finishLoading() {
        bitmapFont = assetManager.get("fonts/font.fnt", BitmapFont.class);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

//        t = assetManager.get("textures/.png", Texture.class);
        albert = assetManager.get("sprites/albert.atlas", TextureAtlas.class);

        shotgun = assetManager.get("sounds/shotgun.wav", Sound.class);
        reload = assetManager.get("sounds/reload.ogg", Sound.class);
        noAmmo = assetManager.get("sounds/noammo.wav", Sound.class);
    }

    void dispose() {
        assetManager.dispose();
        gameInstance.getParticleEffectManager().releaseResources();
    }

    public boolean isLoaded() {
        return assetManager.update();
    }
}
