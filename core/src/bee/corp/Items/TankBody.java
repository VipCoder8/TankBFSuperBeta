package bee.corp.Items;

import bee.corp.Entities.Utils.Mesh;
import com.badlogic.gdx.files.FileHandle;

public class TankBody extends Item {

    private Mesh body;

    public TankBody(FileHandle path) {
        super(path);
        body = new Mesh(75, 90);
        body.setTexture(getItem());
        setItemName("tank_body");
    }

    public Mesh getBody() {
        return body;
    }

}
