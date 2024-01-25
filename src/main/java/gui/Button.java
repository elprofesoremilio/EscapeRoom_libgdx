package gui;

import app.Assets;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Button {
    TextureRegion active, idle, actualImg;
    Vector2 position;
    String text;

    public Button(float x, float y, TextureRegion idle, TextureRegion active) {
        this.position = new Vector2(x,y);
        this.active = active;
        this.idle = idle;
        actualImg = idle;
    }

    public void switchImage() {
        if (actualImg == idle) {
            actualImg = active;
        } else {
            actualImg = idle;
        }
    }

    public void draw(SpriteBatch batch) {
        float textX, textY;
        textX = position.x + idle.getRegionWidth()/2f - Assets.getTextWidth(text)/2f;
        textY = position.y + idle.getRegionHeight()/2f + Assets.getTextHeight(text)/2f;
        batch.draw(actualImg,position.x,position.y);
        Assets.FONT.draw(batch,text,textX,textY);
    }

    public void setText(String text) {
        this.text = text;
    }
}
