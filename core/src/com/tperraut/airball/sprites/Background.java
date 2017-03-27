package com.tperraut.airball.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 27/03/17.
 */

public class Background extends Item {
    public Background(int x, int y) {
        super(new Texture("bg_game.jpg"), x, y, 1f);
    }
}
