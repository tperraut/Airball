package com.tperraut.airball.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tperraut.airball.sprites.Background;
import com.tperraut.airball.sprites.Ball;
import com.tperraut.airball.sprites.Cage;
import com.tperraut.airball.sprites.Player;

/**
 * Created by tperraut on 25/03/2017.
 */

public class PlayState extends State {
    private Ball mBall;
    private Player mPlayer;
    private Cage mCage;
    private Background mBackground;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mBackground = new Background(0, 0);
        mCage = new Cage(Gdx.graphics.getWidth() / 2, 0);
        mPlayer = new Player(Gdx.graphics.getWidth() / 2, mCage.getHeight() + MenuState.PADDING);
        mBall = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched())
            mPlayer.move(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    @Override
    public void update(float dt) {
        handleInput();
        mPlayer.update(dt);
        if (mBall.collision(mPlayer.getBounds()))
            mBall.update(dt, mPlayer);
        else
            mBall.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(mBackground.getTexture(), mBackground.getPosition().x, mBackground.getPosition().y,
                mBackground.getWidth(), mBackground.getHeight());
        sb.draw(mBall.getTexture(), mBall.getPosition().x - mBall.getWidth() / 2, mBall.getPosition().y,
                mBall.getWidth(), mBall.getHeight());
        sb.draw(mPlayer.getTexture(), mPlayer.getPosition().x - mPlayer.getWidth() / 2,
                mPlayer.getPosition().y - mPlayer.getHeight() / 2, mPlayer.getWidth(),
                mPlayer.getHeight());
        sb.draw(mCage.getTexture(), mCage.getPosition().x - mCage.getWidth() / 2,
                mCage.getPosition().y, mCage.getWidth(), mCage.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        mBall.dispose();
        mPlayer.dispose();
        mCage.dispose();
        mBackground.dispose();
    }
}
