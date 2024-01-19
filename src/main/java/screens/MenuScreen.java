package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.Config;

public class MenuScreen extends GameScreen {
    ShapeRenderer renderer;
    BitmapFont font;
    SpriteBatch batch;
    int selectedButton = 0;

    public MenuScreen() {
        renderer = new ShapeRenderer();
        font = new BitmapFont();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (selectedButton>0) selectedButton--;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (selectedButton<2) selectedButton++;
        }

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(.0f,.0f,.0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        if (selectedButton==0) {
            renderer.setColor(Color.CYAN);
        } else {
            renderer.setColor(Color.WHITE);
        }

        renderer.rect(
                Config.SCREEN_WIDTH/2f - Config.BUTTON_WIDTH/2f,
                Config.SCREEN_HEIGHT/2f - Config.BUTTON_HEIGHT/2f + Config.BUTTON_HEIGHT*2f + Config.BUTTON_GAP,
                Config.BUTTON_WIDTH,Config.BUTTON_HEIGHT
        );



        if (selectedButton==1) {
            renderer.setColor(Color.CYAN);
        } else {
            renderer.setColor(Color.WHITE);
        }
        renderer.rect(
                Config.SCREEN_WIDTH/2f - Config.BUTTON_WIDTH/2f,
                Config.SCREEN_HEIGHT/2f - Config.BUTTON_HEIGHT/2f + Config.BUTTON_HEIGHT,
                Config.BUTTON_WIDTH,Config.BUTTON_HEIGHT
        );

        if (selectedButton==2) {
            renderer.setColor(Color.CYAN);
        } else {
            renderer.setColor(Color.WHITE);
        }
        renderer.rect(
                Config.SCREEN_WIDTH/2f - Config.BUTTON_WIDTH/2f,
                Config.SCREEN_HEIGHT/2f - Config.BUTTON_HEIGHT/2f - Config.BUTTON_GAP,
                Config.BUTTON_WIDTH,Config.BUTTON_HEIGHT
        );

        renderer.end();

        batch.begin();
        font.setColor(Color.BLUE);
        font.draw(batch, "Juego nuevo", 350, 370);
        font.draw(batch, "Estadísticas", 350, 300);
        font.draw(batch, "Salir", 350, 230);
        batch.end();

    }

    @Override
    public void dispose() {

    }
}
