package app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Assets {
    public static Sprite idleButton;
    public static Sprite activeButton;

    public static Animation<TextureAtlas.AtlasRegion> zombieAnimation;

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

        atlas = new TextureAtlas(Gdx.files.internal("npc/Zombie.atlas"));

        Array<TextureAtlas.AtlasRegion> zombieFrames = new Array<>();

        for (int i=1; i<=10; i++) {
            zombieFrames.add(atlas.findRegion("go",i));
        }

        zombieAnimation = new Animation<>(0.1f, zombieFrames);

    }

}
