package bee.corp;

import bee.corp.Entities.Tank;
import bee.corp.Maps.Map;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TanksMain extends ApplicationAdapter implements ApplicationListener {
	SpriteBatch mainRenderer;
	ShapeRenderer sr;

	OrthographicCamera camera;

	Map map;
	Tank player;

	@Override
	public void create () {
		player = new Tank();
		map = new Map("core\\src\\bee\\corp\\Maps\\map1.txt");

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		mainRenderer = new SpriteBatch();
		sr = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(255, 255, 255, 1.0f);

		//Logic
		player.Move();
		player.gun.rotateGun(player.body, player.pManager);
		player.shoot();

		//Rendering
		mainRenderer.begin();
		mainRenderer.setProjectionMatrix(camera.combined);
		for(int i = 0; i < map.maxCol; i++) {
			for(int j = 0; j < map.maxRow; j++) {
				mainRenderer.draw(map.getTiles()[i][j].getTexture(), map.getTiles()[i][j].getX(), map.getTiles()[i][j].getY(), map.getTiles()[i][j].getOriginX(), map.getTiles()[i][j].getOriginY(), map.getTiles()[i][j].getWidth(), map.getTiles()[i][j].getHeight(), 1, 1, map.getTiles()[i][j].getRotation());
			}
		}
		for(int i = 0; i < player.getParts().size(); i++) {
			mainRenderer.draw(player.getParts().get(i).getTextureRegion(), player.getParts().get(i).getX(), player.getParts().get(i).getY(), player.getParts().get(i).getOriginX(), player.getParts().get(i).getOriginY(), player.getParts().get(i).getWidth(), player.getParts().get(i).getHeight(), 1, 1, player.getParts().get(i).getRotation());
		}
//		if(player.pManager.getMainParticle().isDrawing()) {
//			mainRenderer.draw(player.pManager.getMainParticle().getParticleRegion(), player.pManager.getMainParticle().getX(), player.pManager.getMainParticle().getY(), player.pManager.getMainParticle().getOriginX(), player.pManager.getMainParticle().getOriginY(), player.pManager.getMainParticle().getWidth(), player.pManager.getMainParticle().getHeight(), 1, 1, player.pManager.getMainParticle().getRotation());
//		}
		for(int i = 0; i < player.getBullets().size(); i++) {
			mainRenderer.draw(player.getBullets().get(i).getItem(), player.getBullets().get(i).getBullet().getX(), player.getBullets().get(i).getBullet().getY(), player.getBullets().get(i).getBullet().getOriginX(), player.getBullets().get(i).getBullet().getOriginY(), player.getBullets().get(i).getBullet().getWidth(), player.getBullets().get(i).getBullet().getHeight(), 1, 1, player.getBullets().get(i).getBullet().getRotation());
		}
		mainRenderer.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}

	@Override
	public void dispose () {
		mainRenderer.dispose();
	}
}
