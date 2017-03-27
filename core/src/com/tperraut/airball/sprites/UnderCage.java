package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 27/03/17.
 */

public class UnderCage extends Item{

    public UnderCage(int x, int y, float percent) {
        super(new Texture("under_cage.png"), x, y, percent);
    }

    public UnderCage(int x, int y) {
        super(new Texture("under_cage.png"), x, y, 1f);
    }
}
