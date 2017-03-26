package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Ball extends WorldObject {

    public Ball(int x, int y) {
        super(new Texture("ball.png"), x, y, 10, 0.1f);
    }

    @Override
    public void update(float dt) {

    }
}
