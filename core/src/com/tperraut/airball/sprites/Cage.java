package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 27/03/17.
 */

public class Cage extends Item {

    public Cage(int x, int y, float percent) {
        super(new Texture("cage.png"), x, y, percent);
    }

    public Cage(int x, int y) {
        super(new Texture("cage.png"), x, y, 1f);
    }
}
