package bee.corp.Items.Bullets;

import bee.corp.Items.Bullet;
import com.badlogic.gdx.files.FileHandle;

public class MediumTankBullet extends Bullet {

    public MediumTankBullet(FileHandle path) {
        super(path);
        setDamage(50f);
    }
}
