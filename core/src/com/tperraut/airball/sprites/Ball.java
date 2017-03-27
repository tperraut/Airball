package com.tperraut.airball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Ball extends WorldObject {

    public Ball(int x, int y) {
        super(new Texture("ball.png"), x, y, 20, 0.1f);
    }

    public Ball(int x, int y, float percent) {
        super(new Texture("ball.png"), x, y, 20, percent);
    }

    @Override
    public void update(float dt) {
        mVelocity.scl(dt);
        mPosition.add(mVelocity);
        if (mPosition.x - this.getWidth() / 2 < 0
                || mPosition.x + this.getWidth() / 2 > Gdx.graphics.getWidth())
            mVelocity.scl(-1, 1, 0);
        if (mPosition.y < 0 || mPosition.y + this.getHeight() > Gdx.graphics.getHeight())
            mVelocity.scl(1, -1, 0);
        mVelocity.scl(1/dt);
        mBounds.setPosition(mPosition.x + this.getWidth() / 2, mPosition.y + this.getHeight() / 2);
    }

    public void update(float dt, WorldObject o) {
        double atan = Math.atan2(o.getPosition().y - mPosition.y, o.getPosition().x - mPosition.x);
        float x = 1.05f * (float)((double)mPosition.x - Math.cos(atan));
        float y = 1.05f * (float)((double)mPosition.y - Math.sin(atan));
        mPosition.set(x, y, 0);
        mBounds.setPosition(mPosition.x + this.getWidth() / 2, mPosition.y + this.getHeight() / 2);
        float mass_ratio = o.getMass() / this.getMass();
        float dx = o.getPosition().x - mPosition.x;
        float dy = o.getPosition().y - mPosition.y;
        float dvx = o.mVelocity.x - mVelocity.x;
        float dvy = o.mVelocity.y - mVelocity.y;
        float a = dy / ((dx != 0) ? dx : 0.00000000000001f);
        float derive = -2 * (dvx + a * dvy) / ((1 + a * a) * (1 + mass_ratio));
        mVelocity.set(mVelocity.x - mass_ratio * derive, mVelocity.y - a * mass_ratio * derive, 0);
        if (mPosition.x - this.getWidth() / 2 < 0
                || mPosition.x + this.getWidth() / 2 > Gdx.graphics.getWidth())
            mVelocity.scl(-1, 1, 0);
        if (mPosition.y < 0 || mPosition.y + this.getHeight() > Gdx.graphics.getHeight())
            mVelocity.scl(1, -1, 0);
    }
}
