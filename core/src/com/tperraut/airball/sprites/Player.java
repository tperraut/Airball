package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Player extends WorldObject {
    private Vector3 mOldPosition;

    public Player(int x, int y) {
        super(new Texture("player.png"), x, y, 20, 0.15f);
        mOldPosition = new Vector3(0, 0, 0);
    }

    public Player(int x, int y, float percent) {
        super(new Texture("player.png"), x, y, 20, percent);
        mOldPosition = new Vector3(0, 0, 0);
    }

    @Override
    public void update(float dt, WorldObject obj) {
        mVelocity.set(mPosition.x - mOldPosition.x, mPosition.y - mOldPosition.y, 0);
        mVelocity.scl(1f / dt);
    }

    public void update(float dt) {
        update(dt, null);
    }

    public void move(int x, int y) {
        mOldPosition.set(mPosition.x, mPosition.y, 0);
        mPosition.set(x, y, 0);
    }
}
