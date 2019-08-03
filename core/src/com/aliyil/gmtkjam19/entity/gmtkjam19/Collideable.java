package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.badlogic.gdx.math.Rectangle;

public interface Collideable {
    boolean isStatic();
    Rectangle getBoundingRectangle();
}
