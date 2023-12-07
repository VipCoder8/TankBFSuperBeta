package bee.corp.VisualEffects;

import com.badlogic.gdx.graphics.Texture;

public class Particle extends BasicParticle {

    private float x;
    private float y;
    private float originX;
    private float originY;
    private float rotation;
    private float width;
    private float height;
    private boolean drawing = true;

    public Particle(float x, float y, float width, float height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public Particle(float x, float y, float width, float height, Texture t) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setParticle(t);
    }

    public Particle(float width, float height) {
        setWidth(width);
        setHeight(height);
    }

    public Particle(Texture t) {
        setParticle(t);
    }

    public Particle(Texture t, float width, float height) {
        setParticle(t);
        setWidth(width);
        setHeight(height);
    }

    public void setDrawing(boolean d) {
        this.drawing = d;
    }

    public boolean isDrawing() {
        return drawing;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getOriginX() {
        return originX;
    }

    public void setOriginX(float originX) {
        this.originX = originX;
    }

    public float getOriginY() {
        return originY;
    }

    public void setOriginY(float originY) {
        this.originY = originY;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
