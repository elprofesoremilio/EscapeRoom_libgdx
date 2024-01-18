package app;

import com.badlogic.gdx.Game;
import screens.MainScreen;

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
        this.setScreen(new MainScreen());
    }
    
}
