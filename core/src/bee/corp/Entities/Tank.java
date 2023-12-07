package bee.corp.Entities;
import bee.corp.Items.Bullet;
import bee.corp.Items.Bullets.*;
import bee.corp.Items.TankBody;
import bee.corp.Items.TankGun;
import bee.corp.Utils.Sound;
import bee.corp.VisualEffects.Management.ParticleManager;
import bee.corp.VisualEffects.Particle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class Tank extends BasicTank {

//    public TankBody body;
//    public TankGun gun;
    public ParticleManager pManager;
    public Sound sounds;

    float caterpillarAnimationLock = 0.0f;

    public Tank() {
        super(TankType.ARTILLERY_TANK);
        translate(100, 100);

        sounds = new Sound();
        sounds.addSound("Sounds/Tank/tank_moving.mp3");
        sounds.addSound("Sounds/Tank/tank_shot.wav");
        sounds.setVolume(0.15f, 0);
        sounds.setVolume(0.87253f, 1);

//        body.getBody().setPosition(getX(), getY());
//        gun.getGun().setPosition(getX() + 22f, getY() + 25f);
//        gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);

        pManager = new ParticleManager();
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_1.png")), 15, 9));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_2.png")), 15, 18));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_3.png")), 33, 33));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_4.png")), 57, 78));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_5.png")), 57, 75));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_6.png")), 57, 63));
        pManager.getParticles().add(new Particle(new Texture(Gdx.files.internal("Particles/fire_7.png")), 36, 56));
        for(int i = 0; i < pManager.getParticles().size(); i++) {
            pManager.getParticles().get(i).setX((body.getBody().getWidth() / 2f + body.getBody().getX()) - (gun.getGun().getWidth() / 2f - 5f));
            pManager.getParticles().get(i).setY((body.getBody().getHeight() / 2f + body.getBody().getY()) - (gun.getGun().getHeight() / 2f - 100f));
            pManager.getParticles().get(i).setOriginX(gun.getGun().getWidth() / 2f - 5f);
            pManager.getParticles().get(i).setOriginY(gun.getGun().getHeight() / 2f - 100f);
            pManager.getParticles().get(i).setRotation(0);
        }
        pManager.setMainParticle(pManager.getParticles().get(0));
    }

    public void shoot() {
        if(type == TankType.LIGHT_TANK_CHOPPER) {
            if(getCurrentReloadingTime() >= getShootDelay()) {
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    lightTankBullets.add(0, new LightTankBullet(Gdx.files.internal("Guns/Bullet.png")));
                    float cos = MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    float sin = MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    gun.shoot(-cos, -sin);
                    currentReloadingTime = 0.0f;
                    sounds.play(1);
                }
            }
            if(!getBullets().isEmpty()) {
                gun.shoot(lightTankBullets.get(0), pManager.getMainParticle(), this);
            }
        } else if(type == TankType.ARTILLERY_TANK) {
            if(getCurrentReloadingTime() >= getShootDelay()) {
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    sounds.play(1);
                    artilleryTankBullets.add(0, new ArtilleryTankBullet(Gdx.files.internal("Guns/Bullet.png")));
                    float cos = MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    float sin = MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    gun.shoot(-cos, -sin);
                    currentReloadingTime = 0.0f;
                }
            }
            if(!getBullets().isEmpty()) {
                gun.shoot(artilleryTankBullets.get(0), pManager.getMainParticle(), this);
            }
        } else if(type == TankType.MEDIUM_TANK) {
            if(getCurrentReloadingTime() >= getShootDelay()) {
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    sounds.play(1);
                    mediumTankBullets.add(0, new MediumTankBullet(Gdx.files.internal("Guns/Bullet.png")));
                    float cos = MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    float sin = MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    gun.shoot(-cos, -sin);
                    currentReloadingTime = 0.0f;
                }
            }
            if(!getBullets().isEmpty()) {
                gun.shoot(mediumTankBullets.get(0), pManager.getMainParticle(), this);
            }
        } else if(type == TankType.HEAVY_TANK) {
            if(getCurrentReloadingTime() >= getShootDelay()) {
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    sounds.play(1);
                    heavyTankBullets.add(0, new HeavyTankBullet(Gdx.files.internal("Guns/Bullet.png")));
                    float cos = MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    float sin = MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    gun.shoot(-cos, -sin);
                    currentReloadingTime = 0.0f;
                }
            }
            if(!getBullets().isEmpty()) {
                gun.shoot(heavyTankBullets.get(0), pManager.getMainParticle(), this);
            }
        } else if(type == TankType.ANTI_TANK_TANK) {
            if(getCurrentReloadingTime() >= getShootDelay()) {
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    sounds.play(1);
                    antiTankBullets.add(0, new AntiTankBullet(Gdx.files.internal("Guns/Bullet.png")));
                    float cos = MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    float sin = MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() - 90.0f));
                    gun.shoot(-cos, -sin);
                    currentReloadingTime = 0.0f;
                }
            }
            if(!getBullets().isEmpty()) {
                gun.shoot(antiTankBullets.get(0), pManager.getMainParticle(), this);
            }
        }
    }

//    public void applyFire(int index) {
//        pManager.setMainParticle(pManager.getParticles().get(index));
////        shootAnimationLock++;
////        if (shootAnimationLock >= 3.4f) {
////            shootAnimationLock = 0;
////            index++;
////            if (index == pManager.getParticles().size()) {
////                index = 0;
////                pManager.getMainParticle().setDrawing(false);
////            }
////            pManager.setMainParticle(pManager.getParticles().get(index));
////        }
//    }

    public void Move() {
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            sounds.play(0);
            caterpillarAnimationLock++;
            if(caterpillarAnimationLock >= 8.4f) {
                caterpillarAnimationLock = 0.0f;
                if(body.getItemName().equals("tank_body")) {
                    body.setItemName("tank_body2");
                    getParts().get(0).setTexture(new TextureRegion(new Texture(Gdx.files.internal("Entities/TankBody2.png"))));
                } else if(body.getItemName().equals("tank_body2")) {
                    body.setItemName("tank_body");
                    getParts().get(0).setTexture(new TextureRegion(new Texture(Gdx.files.internal("Entities/TankBody.png"))));
                }
            }
        } else {
            sounds.stop(0);
        }

        if(type != TankType.ARTILLERY_TANK) {
            if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                translate(getX() - getSpeed(), getY());
                getParts().get(0).setRotation(270);
                getParts().get(0).setPosition(getParts().get(0).getX() - getSpeed(), getParts().get(0).getY());

                getParts().get(1).setPosition(getParts().get(1).getX() - getSpeed(), getParts().get(1).getY());

                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setX(pManager.getParticles().get(i).getX() - getSpeed());
                }
            } else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                translate(getX() + getSpeed(), getY());
                getParts().get(0).setRotation(90);
                getParts().get(0).setPosition(getParts().get(0).getX() + getSpeed(), getParts().get(0).getY());

                getParts().get(1).setPosition(getParts().get(1).getX() + getSpeed(), getParts().get(1).getY());

                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setX(pManager.getParticles().get(i).getX() + getSpeed());
                }
            } else if(Gdx.input.isKeyPressed(Input.Keys.W)) {
                translate(getX() - getSpeed(), getY());
                getParts().get(0).setRotation(180);
                getParts().get(0).setPosition(getParts().get(0).getX(), getParts().get(0).getY() + getSpeed());

                getParts().get(1).setPosition(getParts().get(1).getX(), getParts().get(1).getY() + getSpeed());

                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setY(pManager.getParticles().get(i).getY() + getSpeed());
                }
            } else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
                translate(getX() + getSpeed(), getY());
                getParts().get(0).setRotation(0);
                getParts().get(0).setPosition(getParts().get(0).getX(), getParts().get(0).getY() - getSpeed());

                getParts().get(1).setPosition(getParts().get(1).getX(), getParts().get(1).getY() - getSpeed());

                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setY(pManager.getParticles().get(i).getY() - getSpeed());
                }
            }
        } else {
            if(Gdx.input.isKeyPressed(Input.Keys.A)) {
                body.getBody().setRotation(body.getBody().getRotation() + 1f);
                gun.getGun().setRotation(body.getBody().getRotation());
                pManager.getMainParticle().setRotation(body.getBody().getRotation());
                direction.set((float)Math.cos(Math.toRadians(gun.getGun().getRotation() + 90.0f)), (float)Math.sin(Math.toRadians(gun.getGun().getRotation() + 90.0f)));
            } else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                body.getBody().setRotation(body.getBody().getRotation() - 1f);
                gun.getGun().setRotation(body.getBody().getRotation());
                pManager.getMainParticle().setRotation(body.getBody().getRotation());
                direction.set(MathUtils.cos((float)Math.toRadians(gun.getGun().getRotation() + 90.0f)), MathUtils.sin((float)Math.toRadians(gun.getGun().getRotation() + 90.0f)));
            }
            if(Gdx.input.isKeyPressed(Input.Keys.W)) {
                translate(getX() + getSpeed() * direction.x, getY() + getSpeed() * direction.y);
                getParts().get(0).setPosition(getParts().get(0).getX() + getSpeed() * direction.x, getParts().get(0).getY() + getSpeed() * direction.y);
                getParts().get(1).setPosition(getParts().get(1).getX() + getSpeed() * direction.x, getParts().get(1).getY() + getSpeed() * direction.y);
                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setX(pManager.getParticles().get(i).getX() + getSpeed() * direction.x);
                    pManager.getParticles().get(i).setY(pManager.getParticles().get(i).getY() + getSpeed() * direction.y);
                }
            } else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
                translate(getX() + getSpeed() * -direction.x, getY() + getSpeed() * -direction.y);
                getParts().get(0).setPosition(getParts().get(0).getX() + getSpeed() * -direction.x, getParts().get(0).getY() + getSpeed() * -direction.y);
                getParts().get(1).setPosition(getParts().get(1).getX() + getSpeed() * -direction.x, getParts().get(1).getY() + getSpeed() * -direction.y);
                for(int i = 0; i < pManager.getParticles().size(); i++) {
                    pManager.getParticles().get(i).setX(pManager.getParticles().get(i).getX() + getSpeed() * -direction.x);
                    pManager.getParticles().get(i).setY(pManager.getParticles().get(i).getY() + getSpeed() * -direction.y);
                }
            }
        }
    }

}
