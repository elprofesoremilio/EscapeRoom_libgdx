package screens;

import app.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import app.Config;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuScreen extends GameScreen {
    BitmapFont font;
    SpriteBatch batch;
    int selectedButton = 0;
    Sprite actualImg;

    float zombieTime=0;
    TextureRegion zombieActual;
    public MenuScreen() {
        font = new BitmapFont();
        batch = new SpriteBatch();
//        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (selectedButton>0) selectedButton--;
            else selectedButton=2;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (selectedButton<2) selectedButton++;
            else selectedButton=0;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            switch (selectedButton) {
                case 0:
                    System.out.println("Nuevo juego");
                    break;
                case 1:
                    System.out.println("Estadísticas");
                    break;
                case 2:
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

        int offset=-Config.BUTTON_GAP;

        if (selectedButton==0) {
            actualImg = Assets.activeButton;
        } else {
            actualImg = Assets.idleButton;
        }

        actualImg.setX(Config.SCREEN_WIDTH/2f - actualImg.getRegionWidth()/2f);
        actualImg.setY(Config.SCREEN_HEIGHT/2f + actualImg.getRegionHeight()/2f + offset);
        actualImg.draw(batch);

        if (selectedButton==1) {
            actualImg = Assets.activeButton;
        } else {
            actualImg = Assets.idleButton;
        }

        actualImg.setX(Config.SCREEN_WIDTH/2f - actualImg.getRegionWidth()/2f);
        actualImg.setY(Config.SCREEN_HEIGHT/2f + offset);
        actualImg.draw(batch);

        if (selectedButton==2) {
            actualImg = Assets.activeButton;
        } else {
            actualImg = Assets.idleButton;
        }

        actualImg.setX(Config.SCREEN_WIDTH/2f - actualImg.getRegionWidth()/2f);
        actualImg.setY(Config.SCREEN_HEIGHT/2f - actualImg.getRegionHeight()/2f + offset);
        actualImg.draw(batch);

        font.setColor(Color.BLUE);
        font.draw(batch, "Juego nuevo", 350, 370);
        font.draw(batch, "Estadísticas", 350, 290);
        font.draw(batch, "Salir", 350, 210);


        zombieActual = Assets.zombieAnimation.getKeyFrame(zombieTime,true);
        batch.draw(zombieActual, Config.SCREEN_WIDTH-zombieActual.getRegionWidth(), 0);

        batch.end();

        zombieTime += delta;
    }

    @Override
    public void dispose() {

    }
}
