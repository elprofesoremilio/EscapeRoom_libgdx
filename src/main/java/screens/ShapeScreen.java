package screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShapeScreen extends GameScreen {
    ShapeRenderer renderer;
    public ShapeScreen() {
        renderer = new ShapeRenderer();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(float delta) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.rect(350,100,100,200);
        renderer.circle(400,350,50);
        renderer.arc(450,300,100,0,30);
        renderer.setColor(new Color(Color.CORAL));
        renderer.arc(350,300,-100,0,30);
        renderer.setColor(new Color(Color.WHITE));
        renderer.rect(400, 50, 50,50);

        renderer.end();

        renderer.begin(ShapeRenderer.ShapeType.Point);
        renderer.point(100,400,0);
        renderer.end();
    }
    @Override
    public void dispose() {
        renderer.dispose();
    }
}
