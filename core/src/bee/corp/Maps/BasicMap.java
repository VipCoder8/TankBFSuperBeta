package bee.corp.Maps;

public class BasicMap {
    public int maxRow = 64;
    public int maxCol = 32;
    int[] tileNum;
    protected Tile[][] tiles;
    public Tile[][] getTiles() {
        return tiles;
    }
}
