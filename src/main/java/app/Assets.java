package app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Array;

public class Assets {
    public static TextureRegion idleButton, activeButton;
    public static Animation<TextureAtlas.AtlasRegion> zombieAnimation;
    public static final BitmapFont FONT = new BitmapFont();
    private static final GlyphLayout glyphLayout = new GlyphLayout();

    public static void load() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gui/buttons.atlas"));

        idleButton = atlas.findRegion("azul-claro");
        activeButton = atlas.findRegion("granate");

        atlas = new TextureAtlas(Gdx.files.internal("npc/zombie.atlas"));

        Array<TextureAtlas.AtlasRegion> zombieFrames = new Array<>();

        for (int i=1; i<=10; i++) {
            zombieFrames.add(atlas.findRegion("go",i));
        }

        zombieAnimation = new Animation<>(0.1f, zombieFrames);

    }
    public static void dispose() {
        FONT.dispose();
    }

    public static float getTextWidth(String text) {
        glyphLayout.setText(FONT,text);
        return glyphLayout.width;
    }

    public static float getTextHeight(String text) {
        glyphLayout.setText(FONT,text);
        return glyphLayout.height;
    }
}
