package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 26/03/2017.
 */

public abstract class WorldObject extends Item {
    private final int mMass;
    protected Circle mBounds;

    protected Vector3 mVelocity;

    public WorldObject(Texture t, int x, int y, int m, float percent) {
        super(t, x, y, percent);
        mMass = m;
        mVelocity = new Vector3(0, 0, 0);
        mBounds = new Circle(mPosition.x + this.getWidth() / 2, mPosition.y + this.getHeight() / 2,
                (this.getWidth() / 2) * 0.8f);
    }

    public Circle getBounds() {
        return mBounds;
    }

    public boolean collision(Circle o) {
        return mBounds.overlaps(o);
    }

    public int getMass() {
        return mMass;
    }

    public abstract void update(float dt);
}
