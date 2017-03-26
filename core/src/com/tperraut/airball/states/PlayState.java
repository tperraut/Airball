package com.tperraut.airball.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tperraut.airball.sprites.Ball;
import com.tperraut.airball.sprites.Player;

/**
 * Created by tperraut on 25/03/2017.
 */

public class PlayState extends State {
    private Ball mBall;
    private Player mPlayer;
    private Texture mBackground;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mBackground = new Texture("bg_game.jpg");
        mBall = new Ball(50, 50);
        mPlayer = new Player(100, 100);
        cam.setToOrtho(false);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched())
            mPlayer.move(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    @Override
    public void update(float dt) {
        cam.update();
        handleInput();
        mBall.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(mBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(mBall.getTexture(), mBall.getPosition().x, mBall.getPosition().y, mBall.getWidth(),
                mBall.getHeight());
        sb.draw(mPlayer.getTexture(), mPlayer.getPosition().x - mPlayer.getWidth() / 2,
                mPlayer.getPosition().y - mPlayer.getHeight() / 2, mPlayer.getWidth(),
                mPlayer.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        mBall.dispose();
        mPlayer.dispose();
    }
}
