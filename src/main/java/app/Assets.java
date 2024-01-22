package app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    public static Sprite idleButton;
    public static Sprite activeButton;

    public static void load() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gui/glossyButtons.atlas"));

        idleButton = new Sprite(atlas.findRegion("gris"));
        activeButton = new Sprite(atlas.findRegion("naranja"));
        // Escalar el sprite a la mitad
        idleButton.setScale(Config.BUTTON_SCALE);
        activeButton.setScale(Config.BUTTON_SCALE);

        // Configurar el filtro de textura para mejorar la calidad de escala
        idleButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        activeButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
}
