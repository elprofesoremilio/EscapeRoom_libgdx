package app;

import com.badlogic.gdx.Game;
import screens.MenuScreen;

/**
 *
 * @author Emilio
 */
public class Boot extends Game {

    public Boot() {
    }

    @Override
    public void create() {
        Assets.load();
        this.setScreen(new MenuScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}
