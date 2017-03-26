package com.tperraut.airball.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by tperraut on 25/03/2017.
 */

public class GameStateManager extends Stack<State> {

    public void set(State state) {
        this.pop();
        this.push(state);
    }

    public void update(float dt) {
        this.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        this.peek().render(sb);
    }
}
