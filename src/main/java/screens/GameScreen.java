package screens;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;

public abstract class GameScreen extends InputAdapter implements Screen {
    @Override
    public void show() {}
    @Override
    public void resize(int x, int y) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}

    @Override
    public void render(float delta) {
        update(delta);
        draw(delta);
    }

    public abstract void update(float delta);
    public abstract void draw(float delta);


}
