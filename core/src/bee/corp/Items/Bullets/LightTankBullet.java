package bee.corp.Items.Bullets;

import bee.corp.Items.Bullet;
import com.badlogic.gdx.files.FileHandle;

public class LightTankBullet extends Bullet {

    public LightTankBullet(FileHandle path) {
        super(path);
        setDamage(10f);
    }
}
