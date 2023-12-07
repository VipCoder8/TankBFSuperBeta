package bee.corp.Maps;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map extends BasicMap {

    public Map(String path) {
        setupTiles();
        readMap(path);
    }

    public void setupTiles() {
        tileNum = new int[maxCol];
        tiles = new Tile[maxCol][maxRow];
        for(int i = 0; i < maxCol; i++) {
            for(int j = 0; j < maxRow; j++) {
                tiles[i][j] = new Tile();
                tiles[i][j].setSize(32, 32);
                tiles[i][j].setLocation((tiles[i][j].getWidth() * j) - 1000, tiles[i][j].getHeight() * i - 510);
                tiles[i][j].setOriginPos(tiles[i][j].getWidth() / 2f, tiles[i][j].getHeight() / 2f);
            }
        }
    }

    public void readMap(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while((line = br.readLine()) != null) {
                for(int i = 0; i < maxCol; i++) {
                    for(int j = 0; j < maxRow; j++) {
                        tileNum[i] = Integer.parseInt(line.split(" ")[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {throw new RuntimeException(e);} catch (IOException e) {throw new RuntimeException(e);}
        for(int i = 0; i < maxCol; i++) {
            for(int j = 0; j < maxRow; j++) {
                tiles[i][j].setTexture(tileNum[i]);
            }
        }
    }

}
