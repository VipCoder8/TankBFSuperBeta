package bee.corp.Entities;

import bee.corp.Entities.Utils.Mesh;
import bee.corp.Items.Bullet;
import bee.corp.Items.Bullets.*;
import bee.corp.Items.TankBody;
import bee.corp.Items.TankGun;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class BasicTank {
    //Assets
    private Texture texture;
    private ArrayList<Mesh> parts = new ArrayList<>();

    //Characteristics
    protected float X;
    protected float Y;
    protected float Width;
    protected float Height;
    protected float Speed = 2f;
    public float shootDelay = 140f;
    public float currentReloadingTime = shootDelay;
    protected float hp;

    protected ArrayList<? extends Bullet> bullets = new ArrayList<>();
    protected ArrayList<LightTankBullet> lightTankBullets = new ArrayList<>();
    protected ArrayList<AntiTankBullet> antiTankBullets = new ArrayList<>();
    protected ArrayList<ArtilleryTankBullet> artilleryTankBullets = new ArrayList<>();
    protected ArrayList<MediumTankBullet> mediumTankBullets = new ArrayList<>();
    protected ArrayList<HeavyTankBullet> heavyTankBullets = new ArrayList<>();

    protected int type;

    public TankBody body;
    public TankGun gun;

    Vector2 direction;

    protected BasicTank(int type) {
        direction = new Vector2();
        bullets = new ArrayList<>();
        this.type = type;
        applyType(this.type);
    }

    protected BasicTank(float x, float y, float width, float height, int type) {
        X = x;
        Y = y;
        Width = width;
        Height = height;
        this.type = type;
        applyType(this.type);
    }

    protected BasicTank(float x, float y, float width, float height, Texture texture, int type) {
        X = x;
        Y = y;
        Width = width;
        Height = height;
        this.texture = texture;
        this.type = type;
        applyType(this.type);
    }

    private void applyType(int type) {
        if (type == TankType.LIGHT_TANK_CHOPPER) {
            body = new TankBody(Gdx.files.internal("Entities/TankBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/TankGun.png"));
            gun.getGun().setPosition(getX() + 22f, getY() + 25f);
            gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);
            gun.rotating = true;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            bullets = lightTankBullets;
            shootDelay = 50;
            currentReloadingTime = shootDelay;
            Speed = 5.5f;
            hp = 300;
        } else if (type == TankType.LIGHT_TANK_FLAMETHROWER) {
            body = new TankBody(Gdx.files.internal("Entities/TankBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/TankGun.png"));
            gun.getGun().setPosition(getX() + 22f, getY() + 25f);
            gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);
            gun.rotating = true;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            //Bullet.damage = 5f;
            shootDelay = 20;
            currentReloadingTime = shootDelay;
            Speed = 5f;
            hp = 300;
        } else if (type == TankType.ANTI_TANK_TANK) {
            body = new TankBody(Gdx.files.internal("Entities/TankBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/TankGun.png"));
            gun.getGun().setPosition(getX() + 22f, getY() + 25f);
            gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);
            gun.rotating = true;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            bullets = antiTankBullets;
            shootDelay = 400;
            currentReloadingTime = shootDelay;
            Speed = 1.8f;
            hp = 250;
        } else if (type == TankType.ARTILLERY_TANK) {
            body = new TankBody(Gdx.files.internal("Entities/ArtilleryBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/ArtilleryGun.png"));
            gun.getGun().setSize(36, 95);
            body.getBody().setPosition(getX(), getY());
            gun.getGun().setPosition(getX() + 20f, getY() + 9f);
            gun.getGun().setOriginPos((gun.getGun().getWidth() / 2f), (gun.getGun().getHeight() / 2f) - 11.7f);
            gun.rotating = false;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            bullets = artilleryTankBullets;
            shootDelay = 500;
            currentReloadingTime = shootDelay;
            Speed = 1.5f;
            hp = 250;
        } else if (type == TankType.MEDIUM_TANK) {
            body = new TankBody(Gdx.files.internal("Entities/TankBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/TankGun.png"));
            gun.getGun().setPosition(getX() + 22f, getY() + 25f);
            gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);
            gun.rotating = true;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            bullets = mediumTankBullets;
            shootDelay = 200;
            currentReloadingTime = shootDelay;
            Speed = 3f;
            hp = 400;
        } else if (type == TankType.HEAVY_TANK) {
            body = new TankBody(Gdx.files.internal("Entities/TankBody.png"));
            gun = new TankGun(Gdx.files.internal("Guns/TankGun.png"));
            gun.getGun().setPosition(getX() + 22f, getY() + 25f);
            gun.getGun().setOriginPos(gun.getGun().getWidth() / 2f, (gun.getGun().getHeight() / 2f) - 20f);
            gun.rotating = true;
            addMesh(body.getBody());
            addMesh(gun.getGun());
            bullets = heavyTankBullets;
            shootDelay = 300;
            currentReloadingTime = shootDelay;
            Speed = 2f;
            hp = 500;
        }
    }

    public void translate(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    public void setSize(float width, float height) {
        this.Width = width;
        this.Height = height;
    }

    public void setTexture(FileHandle path) {
        texture = new Texture(path);
    }

    public void addMesh(Mesh mesh) {
        parts.add(mesh);
    }

    public Texture getTexture() {
        return this.texture;
    }

    public ArrayList<Mesh> getParts() {
        return parts;
    }

    public ArrayList<? extends Bullet> getBullets() {
        return bullets;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public float getWidth() {
        return Width;
    }

    public float getHeight() {
        return Height;
    }

    public float getSpeed() {
        return Speed;
    }

    public float getCurrentReloadingTime() {
        return currentReloadingTime;
    }

    public float getShootDelay() {
        return shootDelay;
    }

    public interface TankType {
        int LIGHT_TANK_CHOPPER = 1;
        int LIGHT_TANK_FLAMETHROWER = 2;
        int ANTI_TANK_TANK = 3;
        int ARTILLERY_TANK = 4;
        int MEDIUM_TANK = 5;
        int HEAVY_TANK = 6;
    }

}
