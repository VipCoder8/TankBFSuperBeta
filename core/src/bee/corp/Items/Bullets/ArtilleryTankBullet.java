package bee.corp.Items.Bullets;

import bee.corp.Items.Bullet;
import com.badlogic.gdx.files.FileHandle;

public class ArtilleryTankBullet extends Bullet {

    public ArtilleryTankBullet(FileHandle path) {
        super(path);
        setDamage(100f);
    }
}
