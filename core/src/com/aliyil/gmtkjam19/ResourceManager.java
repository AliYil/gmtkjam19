package com.aliyil.gmtkjam19;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public final class ResourceManager {
    //Resources
    public BitmapFont bitmapFont;

    public Texture logo;
    public Texture floor;
    public Texture floor2;
    public Texture wall;
    public Texture ammo;
    public Texture circle;
    public Texture crosshair;
    public TextureAtlas albert;
    public TextureAtlas zombie;
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
        assetManager.load("sprites/zombieframes.atlas", TextureAtlas.class);

        assetManager.load("sprites/logo.png", Texture.class);
        assetManager.load("sprites/floor.png", Texture.class);
        assetManager.load("sprites/floor2.png", Texture.class);
        assetManager.load("sprites/wall.png", Texture.class);
        assetManager.load("sprites/ammo.png", Texture.class);
        assetManager.load("sprites/circle.png", Texture.class);
        assetManager.load("sprites/crosshair.png", Texture.class);
        assetManager.load("sprites/plain.png", Texture.class);
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

        logo = assetManager.get("sprites/logo.png", Texture.class);
        floor = assetManager.get("sprites/floor.png", Texture.class);
        floor2 = assetManager.get("sprites/floor2.png", Texture.class);
        wall = assetManager.get("sprites/wall.png", Texture.class);
        ammo = assetManager.get("sprites/ammo.png", Texture.class);
        circle = assetManager.get("sprites/circle.png", Texture.class);
        crosshair = assetManager.get("sprites/crosshair.png", Texture.class);

        albert = assetManager.get("sprites/albert.atlas", TextureAtlas.class);
        zombie = assetManager.get("sprites/zombieframes.atlas", TextureAtlas.class);

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
