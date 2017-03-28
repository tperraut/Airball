package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 26/03/2017.
 */

public abstract class WorldObject extends Item {
    private final int mMass;
    private Circle mBounds;

    protected Vector3 mVelocity;

    public WorldObject(Texture t, int x, int y, int m, float percent) {
        super(t, x, y, percent);
        mMass = m;
        mVelocity = new Vector3(0, 0, 0);
        mBounds = new Circle(x, y, this.getWidth() / 2);
    }

    public Circle getBounds() {
        return (new Circle(mPosition.x , mPosition.y, this.getWidth() / 2));
    }

    public boolean collision(Circle o) {
        mBounds.setPosition(mPosition.x, mPosition.y);
        return mBounds.overlaps(o);
    }

    public int getMass() {
        return mMass;
    }

    public abstract void update(float dt, WorldObject obj);
}
