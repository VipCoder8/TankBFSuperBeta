package bee.corp.Items;

import bee.corp.Entities.Utils.Mesh;
import com.badlogic.gdx.files.FileHandle;

public class Caterpillar extends Item {

    public Mesh caterpillar;

    public Caterpillar(FileHandle path) {
        super(path);
        caterpillar = new Mesh(21, 100);
        caterpillar.setTexture(getItem());
        setItemName("caterpillar");
    }

    public Mesh getCaterpillar() {
        return caterpillar;
    }

}
