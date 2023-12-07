package bee.corp.VisualEffects.Management;

import bee.corp.VisualEffects.Particle;

import java.util.ArrayList;

public class ParticleManager {

    private ArrayList<Particle> particles;
    private Particle mainParticle;

    public ParticleManager() {
        particles = new ArrayList<>();
    }

    public void setMainParticle(Particle p) {
        mainParticle = p;
    }

    public Particle getMainParticle() {
        return mainParticle;
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

}
