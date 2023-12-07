package bee.corp.Items;

import bee.corp.Entities.Utils.Mesh;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bullet extends Item {

    private Mesh bullet;
    private boolean moveable = true;
    private float speed = 50f;
    private float damage = 30f;

    public Bullet(FileHandle path) {
        super(path);
        bullet = new Mesh(8, 16);
        bullet.setTexture(getItem());
        setItemName("bullet");
    }

    public float getSpeed() {
        return speed;
    }

    public void setDamage(float d) {
        this.damage = d;
    }

    public float getDamage() {
        return damage;
    }

    public void setMoveable(boolean m) {
        this.moveable = m;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public Mesh getBullet() {
        return bullet;
    }

}
