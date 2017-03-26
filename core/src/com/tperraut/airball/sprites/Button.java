package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 26/03/2017.
 */

public class Button extends Item {

    public Button(Texture t, int x, int y, float percent) {
        super(t, x, y, percent);
    }

    public Button(Texture t, int x, int y) {
        super(t, x, y, 0.8f);
    }
}
