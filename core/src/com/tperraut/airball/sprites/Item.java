package com.tperraut.airball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 26/03/2017.
 */

public abstract class Item {

    private int mHeight;
    private int mWidth;
    private Texture mTexture;

    protected Vector3 mPosition;

    public Item(Texture t, int x, int y, float percent) {
        mPosition = new Vector3(x, y, 0);
        mTexture = t;
        float ratio = t.getHeight() * 1f / t.getWidth() * 1f;
        mWidth = (int) (Gdx.graphics.getWidth() * percent);
        mHeight = (int) (mWidth * ratio);
    }

    public Vector3 getPosition() {
        return mPosition;
    }

    public Texture getTexture() {
        return mTexture;
    }

    public void dispose() {
        mTexture.dispose();
    }

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

}
