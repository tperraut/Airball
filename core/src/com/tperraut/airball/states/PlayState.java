package com.tperraut.airball.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tperraut.airball.sprites.Background;
import com.tperraut.airball.sprites.Ball;
import com.tperraut.airball.sprites.Cage;
import com.tperraut.airball.sprites.Player;
import com.tperraut.airball.sprites.UnderCage;

/**
 * Created by tperraut on 25/03/2017.
 */

public class PlayState extends State {
    private Ball mBall;
    private Player mPlayer;
    private UnderCage mUnderCage;
    private Cage mCage;
    private Background mBackground;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mBackground = new Background(0, 0);
        mBall = new Ball(50, 50);
        mPlayer = new Player(100, 100);
        mUnderCage = new UnderCage(0, 0);
        mCage = new Cage(Gdx.graphics.getWidth() / 2, 0);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched())
            mPlayer.move(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    @Override
    public void update(float dt) {
        handleInput();
        mBall.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(mBackground.getTexture(), mBackground.getPosition().x, mBackground.getPosition().y,
                mBackground.getWidth(), mBackground.getHeight());
        sb.draw(mUnderCage.getTexture(), mUnderCage.getPosition().x, mUnderCage.getPosition().y,
                mUnderCage.getWidth(), mUnderCage.getHeight());
        sb.draw(mBall.getTexture(), mBall.getPosition().x, mBall.getPosition().y, mBall.getWidth(),
                mBall.getHeight());
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
        mUnderCage.dispose();
        mCage.dispose();
        mBackground.dispose();
    }
}
