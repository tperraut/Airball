package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 26/03/2017.
 */

public abstract class WorldObject extends Item {
    private int mMasse;

    protected Vector3 mVelocity;

    public WorldObject(Texture t, int x, int y, int m, float percent) {
        super(t, x, y, percent);
        mMasse = m;
        mVelocity = new Vector3(0, 0, 0);
    }

    public abstract void update(float dt);
}
