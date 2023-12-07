package bee.corp.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Item {
    TextureRegion item;
    String itemName;

    public Item(String path) {
        item = new TextureRegion(new Texture(path));
    }

    public Item(FileHandle path) {
        item = new TextureRegion(new Texture(path));
    }

    public void setItem(TextureRegion newTexture) {
        this.item = newTexture;
    }

    public TextureRegion getItem() {
        return item;
    }

    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }

    public String getItemName() {
        return itemName;
    }

}
