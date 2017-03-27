package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Player extends WorldObject {

    public Player(int x, int y) {
        super(new Texture("player.png"), x, y, 20, 0.2f);
    }

    public Player(int x, int y, float percent) {
        super(new Texture("player.png"), x, y, 20, percent);
    }

    @Override
    public void update(float dt) {
        mVelocity.scl(dt);
        //TODO: ball
        mVelocity.scl(1 / dt);
    }

    public void move(int x, int y) {
        mPosition.x = x;
        mPosition.y = y;
    }
}
