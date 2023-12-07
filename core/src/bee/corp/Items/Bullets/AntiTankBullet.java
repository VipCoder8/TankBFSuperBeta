package bee.corp.Items.Bullets;

import bee.corp.Items.Bullet;
import com.badlogic.gdx.files.FileHandle;

public class AntiTankBullet extends Bullet {

    public AntiTankBullet(FileHandle path) {
        super(path);
        setDamage(150f);
    }
}
