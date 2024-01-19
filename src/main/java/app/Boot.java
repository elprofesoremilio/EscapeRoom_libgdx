package app;

import com.badlogic.gdx.Game;
import screens.MenuScreen;
import screens.PaintedScreen;

/**
 *
 * @author Emilio
 */
public class Boot extends Game {

    public Boot() {
    }

    @Override
    public void create() {
        // TODO: 1 - load screen
        this.setScreen(new MenuScreen());
    }
    
}
