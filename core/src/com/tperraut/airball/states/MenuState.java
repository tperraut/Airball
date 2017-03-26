package com.tperraut.airball.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tperraut.airball.sprites.Button;

/**
 * Created by tperraut on 25/03/2017.
 */

public class MenuState extends State{
    private Texture mBackground;
    private Button mPlayBtn;
    private Button mExitBtn;
    private static final int PADDING = 20;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        mBackground = new Texture("bg_menu.png");
        mPlayBtn = new Button(new Texture("start.png"), Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2);
        mExitBtn = new Button(new Texture("exit.png"), Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2, 0.6f);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(mBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        sb.draw(mPlayBtn.getTexture(),
                mPlayBtn.getPosition().x - mPlayBtn.getWidth() / 2,
                mPlayBtn.getPosition().y, mPlayBtn.getWidth(), mPlayBtn.getHeight());
        sb.draw(mExitBtn.getTexture(),
                mExitBtn.getPosition().x - mExitBtn.getWidth() / 2,
                mExitBtn.getPosition().y - mExitBtn.getHeight() - PADDING,
                mExitBtn.getWidth(), mExitBtn.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        mBackground.dispose();
        mPlayBtn.dispose();
        mExitBtn.dispose();
    }
}
