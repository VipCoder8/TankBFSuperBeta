package bee.corp.Maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    private float width;
    private float height;
    private float x;
    private float y;
    private float originX;
    private float originY;
    private float rotation;
    private boolean collidable;

    private TextureRegion texture;

    public Tile() {
        setRotation(0);
    }

    public Tile(float x, float y, float width, float height, int texture) {
        setSize(width, height);
        setLocation(x, y);
        setTexture(texture);
        setRotation(0);
    }

    public void setRotation(float r) {
        this.rotation = r;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setOriginPos(float ox, float oy) {
       this.originX = ox;
       this.originY = oy;
    }

    public void setTexture(int t) {
        if(t == Tiles.GRASS_TILE) {
            this.texture = new TextureRegion(new Texture(Gdx.files.internal("Tiles/grass_tile.png")));
        }
        if(t == Tiles.WATER_TILE) {
            this.texture = new TextureRegion(new Texture(Gdx.files.internal("Tiles/water_tile.png")));
        }
        if(t == Tiles.ICE_TILE) {
            this.texture = new TextureRegion(new Texture(Gdx.files.internal("Tiles/ice_tile.png")));
        }
    }

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }

    public float getRotation() {
        return rotation;
    }

    public float getOriginX() {
        return originX;
    }

    public float getOriginY() {
        return originY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public TextureRegion getTexture() {
        return texture;
    }

}
