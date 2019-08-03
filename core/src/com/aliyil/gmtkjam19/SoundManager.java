package com.aliyil.gmtkjam19;

import com.badlogic.gdx.audio.Sound;

public final class SoundManager {
    private Game gameInstance;

    SoundManager(Game gameInstance) {
        this.gameInstance = gameInstance;
    }

    public void shotgun() {
        float vol = 1f;
        Sound s = gameInstance.getResourceManager().shotgun;
        s.play(vol, 0.8f + Utilities.RANDOM.nextFloat() * 0.4f, 0);
    }
    public void reload() {
        float vol = 1f;
        Sound s = gameInstance.getResourceManager().reload;
        s.play(vol, 1f, 0);
    }
    public void noAmmo() {
        float vol = 1f;
        Sound s = gameInstance.getResourceManager().noAmmo;
        s.play(vol, 1f, 0);
    }

//    public void startBackground() {
//        float vol = 1f;
//        Sound s = gameInstance.getResourceManager().backgroundSound;
//        s.loop(vol);
//    }
//
//    public void stopBackground() {
//        Sound s = gameInstance.getResourceManager().backgroundSound;
//        s.stop();
//    }
}
