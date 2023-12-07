package bee.corp.Entities.Utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Affine2;

public class Mesh {
    private TextureRegion textureRegion;
    private Texture texture;

    public float X;
    public float Y;
    private float Width;
    private float Height;

    private float originX;
    private float originY;

    private float rotation = 0f;

    public Mesh(float width, float height) {
        setSize(width, height);
        setOriginPos(getWidth() / 2, getHeight() / 2);
    }

    public Mesh(float x, float y, float width, float height, FileHandle path) {
        setPosition(x, y);
        setSize(width, height);
        setTexture(path);
        setOriginPos(getWidth() / 2, getHeight() / 2);
    }

    public Mesh setPosition(float x, float y) {
        this.X = x;
        this.Y = y;
        return this;
    }

    public void setSize(float width, float height) {
        this.Width = width;
        this.Height = height;
    }

    public void setRotation(float r) {
        this.rotation = r;
    }

    public void setOriginPos(float x, float y) {
        this.originX = x;
        this.originY = y;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setTexture(FileHandle path) {
        texture = new Texture(path);
        textureRegion = new TextureRegion(texture);
    }

    public void setTexture(TextureRegion textureRegion) {
        texture = textureRegion.getTexture();
        this.textureRegion = textureRegion;
    }

    public Texture getTexture() {
        return texture;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public float getOriginX() {
        return originX;
    }

    public float getOriginY() {
        return originY;
    }

    public float getWidth() {
        return Width;
    }

    public float getHeight() {
        return Height;
    }

}
