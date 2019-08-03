package com.aliyil.gmtkjam19.entity.gmtkjam19;

import com.aliyil.gmtkjam19.entity.core.GameObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface Collideable {
    boolean isStatic();
    Rectangle getBoundingRectangle();
    Vector2 getPosVector();
    Vector2 getSpeedVector();
    void onCollide(GameObject entity);
}
