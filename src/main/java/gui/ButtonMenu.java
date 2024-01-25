package gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ButtonMenu {
    Array<Button> buttons;
    int selectedButton=0;

    public ButtonMenu(int numButtons, int width, int height, TextureRegion idle, TextureRegion active, float buttonGap) {
        buttons = new Array<>();
        float x, y;
        x = width/2f - idle.getRegionWidth()/2f;
        y = height/2f - idle.getRegionHeight()/2f + (idle.getRegionHeight()*(numButtons-1))/2f + buttonGap*(numButtons-1)/2f;

        for (int i = 0; i < numButtons; i++) {
            buttons.add(new Button(x,y-(i*(idle.getRegionHeight()+buttonGap)),idle,active));
        }
        buttons.get(0).switchImage();
    }

    public void setButtonText(int buttonIndex, String text) {
        buttons.get(buttonIndex).setText(text);
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            buttons.get(selectedButton).switchImage();
            if (selectedButton<buttons.size-1) {
                selectedButton++;
            } else {
                selectedButton=0;
            }
            buttons.get(selectedButton).switchImage();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            buttons.get(selectedButton).switchImage();
            if (selectedButton>0) {
                selectedButton--;
            } else {
                selectedButton=buttons.size-1;
            }
            buttons.get(selectedButton).switchImage();
        }
    }
    public void draw(SpriteBatch batch) {
        for (Button button : buttons) {
            button.draw(batch);
        }
    }

    public int getSelectedButton() {
        return selectedButton;
    }
}
