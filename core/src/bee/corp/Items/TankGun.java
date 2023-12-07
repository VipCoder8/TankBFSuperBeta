package bee.corp.Items;

import bee.corp.Entities.BasicTank;
import bee.corp.Entities.Utils.Mesh;
import bee.corp.VisualEffects.Management.ParticleManager;
import bee.corp.VisualEffects.Particle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;

public class TankGun extends Item {

    private Mesh gun;

    public float currentAngle = 0.0f;
    public float cos = 0.0f;
    public float sin = 0.0f;
    public boolean rotating = true;

//    public float shootDelay = 140f;
//    public float currentReloadingTime = shootDelay;

    private boolean shooting = false;

    double rad;

    public TankGun(FileHandle path) {
        super(path);
        gun = new Mesh(32, 75);
        gun.setTexture(path);
        setItemName("tank_gun");
    }

    public void rotateGun(TankBody body, ParticleManager pManager) {
        if(rotating) {
            float deltaX = (Gdx.graphics.getWidth() / 2f + body.getBody().getX() + 50) - Gdx.input.getX();
            float deltaY = (Gdx.input.getY() + body.getBody().getY() + 50) - Gdx.graphics.getHeight() / 2f;
            rad = Math.atan2(-deltaY, deltaX);
            float targetAngle = Math.round(rad * (180 / Math.PI));
            float stepSize = 0.5f;
            if(currentAngle < targetAngle) {
                currentAngle += stepSize;
            }
            if(currentAngle > targetAngle + 20) {
                currentAngle -= stepSize;
            }
            getGun().setRotation(-currentAngle + 100.0f);
            pManager.getMainParticle().setRotation(getGun().getRotation());
        }
    }

    public void shoot(float cos, float sin) {
        shooting = true;
        this.cos = cos;
        this.sin = sin;
    }

    public void setShooting(boolean s) {
        this.shooting = s;
    }

    public void shoot(Bullet bullet, Particle particle, BasicTank tank) {
        if (shooting) {
            tank.currentReloadingTime++;
            if (bullet.isMoveable()) {
                bullet.getBullet().setPosition(particle.getX() - 4f, particle.getY());
                bullet.getBullet().setOriginPos(particle.getOriginX(), particle.getOriginY());
                bullet.getBullet().setRotation(particle.getRotation());
                bullet.setMoveable(false);
            }
            bullet.getBullet().X += bullet.getSpeed() * cos;
            bullet.getBullet().Y += bullet.getSpeed() * sin;
        }
    }

//    public float getCurrentReloadingTime() {
//        return currentReloadingTime;
//    }
//
//    public float getShootDelay() {
//        return shootDelay;
//    }

    public Mesh getGun() {
        return gun;
    }

}
