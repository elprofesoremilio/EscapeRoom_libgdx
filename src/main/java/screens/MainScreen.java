package screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainScreen implements Screen {
    ShapeRenderer renderer;
    public MainScreen() {
        renderer = new ShapeRenderer();
    }
    @Override
    public void render(float delta) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.rect(350,100,100,200);
        renderer.circle(400,350,50);
        renderer.arc(450,300,100,0,30);
        renderer.setColor(new Color(Color.CORAL));
        renderer.arc(350,300,-100,0,30);
        renderer.setColor(new Color(Color.WHITE));
        renderer.rect(400, 50, 50,50);

        renderer.end();
    }
    @Override
    public void show() {

    }
    @Override
    public void resize(int i, int i1) {

    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {
        renderer.dispose();
    }
}
