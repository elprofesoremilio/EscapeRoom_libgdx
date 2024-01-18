/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import config.Config;

/**
 *
 * @author Emilio
 */
public class DesktopLauncher {

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setIdleFPS(Config.FPS);
        config.useVsync(true);
        config.setTitle(Config.TITLE);
        config.setWindowedMode(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        if (Config.FULL_SCREEN) {
            config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        }
        new Lwjgl3Application(new Boot(), config);
    }
    
}
