package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.Game;
import com.aliyil.gmtkjam19.Utilities;
import com.aliyil.gmtkjam19.entity.core.Entity;

public class ScreenShake extends Entity {
    private float life = 0.2f;
    public ScreenShake(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        super.tick();
        getSharedValues().cameraPosSecondary.set(Utilities.RANDOM.nextFloat() * life * 120f, Utilities.RANDOM.nextFloat() * life * 120f);

        life -= dts();
        if(life <= 0){
            kill();
            getSharedValues().cameraPosSecondary.set(0, 0);
        }
    }
}
