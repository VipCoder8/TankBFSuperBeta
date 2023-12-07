package bee.corp.VisualEffects;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BasicParticle {

    private Texture particle;
    private TextureRegion particleRegion;

    public void setParticle(Texture texture) {
        this.particle = texture;
        particleRegion = new TextureRegion(this.particle);
    }

    public void setParticle(FileHandle texture) {
        this.particle = new Texture(texture);
        particleRegion = new TextureRegion(this.particle);
    }

    public Texture getParticle() {
        return particle;
    }

    public TextureRegion getParticleRegion() {
        return particleRegion;
    }
}
