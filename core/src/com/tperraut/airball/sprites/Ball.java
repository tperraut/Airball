package com.tperraut.airball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Ball extends WorldObject {
    private float mDecel = 1.4f;
    private Vector3 mAccelerate;

    public Ball(int x, int y) {
        super(new Texture("ball.png"), x, y, 20, 0.1f);
        mAccelerate = new Vector3(0, 0, 0);
    }

    public Ball(int x, int y, float percent) {
        super(new Texture("ball.png"), x, y, 20, percent);
    }

    public void update(float dt, WorldObject obj) {
        //Check Wall
        mVelocity.set(mVelocity.x + mAccelerate.x * dt, mVelocity.y + mAccelerate.y * dt, 0);
        mPosition.set(mPosition.x  + mVelocity.x * dt, mPosition.y + mVelocity.y * dt, 0);
        if (mPosition.x - this.getWidth() / 2 < 0) {
            mPosition.set(1f + this.getWidth() / 2, mPosition.y, 0);
            mVelocity.scl(-1, 1, 0);
        }
        if (mPosition.x + this.getWidth() / 2 > Gdx.graphics.getWidth()) {
            mPosition.set(Gdx.graphics.getWidth() - (1f + this.getWidth() / 2), mPosition.y, 0);
            mVelocity.scl(-1, 1, 0);
        }
        if (mPosition.y - this.getHeight() / 2 < 0) {
            mPosition.set(mPosition.x, 1f + this.getHeight() / 2, 0);
            mVelocity.scl(1, -1, 0);
        }
        if (mPosition.y + this.getHeight() / 2 > Gdx.graphics.getHeight()) {
            mPosition.set(mPosition.x, Gdx.graphics.getHeight() - (1f + this.getHeight() / 2), 0);
            mVelocity.scl(1, -1, 0);
        }
        //Check collision avec un objet
        if (this.collision(obj.getBounds())) {
            float dx, dy, dist, px, py, pvball, pvobj, d, ratio;
            dx = mPosition.x - obj.mPosition.x;
            dy = mPosition.y - obj.mPosition.y;

            dist = (float)(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
            // Axe de projection
            px = dx / dist;
            py = dy / dist;
            // Projection de la vitesse courante sur l'axe de projection
            pvball = px * mVelocity.x + py * mVelocity.y;
            pvobj = px * obj.mVelocity.x + py * obj.mVelocity.y;
            mVelocity.set(-px * (pvball - pvobj), -py * (pvball - pvobj), 0);
            mVelocity.scl(2.2f);
            /*
            d = obj.getWidth() / 2 + this.getWidth() / 2 - dist;
            ratio = d / ((float)(Math.sqrt(Math.pow(mVelocity.x, 2) + Math.pow(mVelocity.y, 2))) - 5f);
            if (ratio > 1f)
                mVelocity.scl(ratio);
            */
        }
        mAccelerate.set(-mVelocity.x * mDecel, -mVelocity.y * mDecel, 0);
    }

    /*
    public void updateWithCollision(float dt, WorldObject o) {
        double atan = Math.atan2(o.getPosition().y - mPosition.y, o.getPosition().x - mPosition.x);
        float x = (float)((double)mPosition.x - Math.cos(atan));
        float y = (float)((double)mPosition.y - Math.sin(atan));
        mPosition.set(x, y, 0);
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
        if (mPosition.y < 0 - this.getHeight() / 2
                || mPosition.y + this.getHeight() / 2 > Gdx.graphics.getHeight())
            mVelocity.scl(1, -1, 0);

    }
    */
}
