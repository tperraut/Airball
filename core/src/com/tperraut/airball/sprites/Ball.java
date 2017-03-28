package com.tperraut.airball.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.math.Vector3;
import com.tperraut.airball.states.PlayState;

/**
 * Created by tperraut on 25/03/2017.
 */

public class Ball extends WorldObject {
    private static final float DECEL = 0.1f;
    private static final Vector3 VMIN = new Vector3(PlayState.WORLDRATIO * 0.01f,
            PlayState.WORLDRATIO * 0.01f, 0);
    private static final Vector3 VMAX = new Vector3(PlayState.WORLDRATIO * 0.25f,
            PlayState.WORLDRATIO * 0.25f, 0);
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
            mPosition.set(this.getWidth() / 2, mPosition.y, 0);
            mVelocity.scl(-1, 1, 0);
        }
        if (mPosition.x + this.getWidth() / 2 > Gdx.graphics.getWidth()) {
            mPosition.set(Gdx.graphics.getWidth() - this.getWidth() / 2, mPosition.y, 0);
            mVelocity.scl(-1, 1, 0);
        }
        if (mPosition.y - this.getHeight() / 2 < 0) {
            mPosition.set(mPosition.x, this.getHeight() / 2, 0);
            mVelocity.scl(1, -1, 0);
        }
        if (mPosition.y + this.getHeight() / 2 > Gdx.graphics.getHeight()) {
            mPosition.set(mPosition.x, Gdx.graphics.getHeight() - this.getHeight() / 2, 0);
            mVelocity.scl(1, -1, 0);
        }
        if (this.collision(obj.getBounds())) {
            System.out.println("ça collisionne ça mère !");
            /*
            double atan = Math.atan2(mPosition.y - obj.mPosition.y, mPosition.x - obj.mPosition.x);
            float x = (float)((double)mPosition.x - Math.cos(atan));
            float y = (float)((double)mPosition.y - Math.sin(atan));
            mPosition.set(x, y, 0);
            */
            float dist = (float)(Math.sqrt(Math.pow(mPosition.x - obj.mPosition.x, 2)
                    + Math.pow(mPosition.y - obj.mPosition.y, 2)));
            // Axe de projection
            float px = (mPosition.x - obj.mPosition.x) / dist;
            float py = (mPosition.y - obj.mPosition.y) / dist;
            // Projection de la vitesse courante sur l'axe de projection
            float pvball = px * mVelocity.x + py * mVelocity.y;
            float pvobj = px * obj.mVelocity.x + py * obj.mVelocity.y;
            mVelocity.set(-px * (pvball - pvobj), -py * (pvball - pvobj), 0);
        }
        mAccelerate.set(-mVelocity.x * DECEL, -mVelocity.y * DECEL, 0);
        System.out.println(mVelocity);
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
