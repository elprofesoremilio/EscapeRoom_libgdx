package screens;

import app.Assets;
import app.Config;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import gui.ButtonMenu;

public class MenuScreen extends GameScreen {
    BitmapFont font;
    SpriteBatch batch;
    float zombieTime=0;
    ButtonMenu menu;
    TextureRegion zombieActual;
    public MenuScreen() {
        font = new BitmapFont();
        batch = new SpriteBatch();
        menu = new ButtonMenu(4,
                Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT,
                Assets.idleButton, Assets.activeButton,
                Config.BUTTON_GAP
        );
        menu.setButtonText(0,"Nueva partida");
        menu.setButtonText(1,"Cargar partida");
        menu.setButtonText(2,"Estadísticas");
        menu.setButtonText(3,"Salir");
//        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(float delta) {

        menu.update();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            switch (menu.getSelectedButton()) {
                case 0:
                    System.out.println("Nuevo juego");
                    break;
                case 1:
                    System.out.println("Cargar partida");
                    break;
                case 2:
                    System.out.println("Estadísticas");
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClearColor(.0f,.0f,.0f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        menu.draw(batch);

        zombieActual = Assets.zombieAnimation.getKeyFrame(zombieTime,true);
        batch.draw(zombieActual, Config.SCREEN_WIDTH-zombieActual.getRegionWidth(), 0);

        batch.end();

        zombieTime += delta;
    }

    @Override
    public void dispose() {

    }
}
