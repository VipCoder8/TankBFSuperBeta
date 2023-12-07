package bee.corp.Items.Bullets;

import bee.corp.Items.Bullet;
import com.badlogic.gdx.files.FileHandle;

public class HeavyTankBullet extends Bullet {

    public HeavyTankBullet(FileHandle path) {
        super(path);
        setDamage(75f);
    }
}
