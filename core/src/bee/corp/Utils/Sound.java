package bee.corp.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;

public class Sound {

    private ArrayList<Music> musics = new ArrayList<>();

    public Sound() {
    }

    public void addSound(String path) {
        musics.add(Gdx.audio.newMusic(Gdx.files.internal(path)));
    }

    public void play(int index) {
        musics.get(index).play();
    }

    public void loop(int index) {
        musics.get(index).setLooping(true);
        musics.get(index).play();
    }

    public void stop(int index) {
        musics.get(index).stop();
    }

    public void pause(int index) {
        musics.get(index).pause();
    }

    public void setVolume(float value, int index) {
        musics.get(index).setVolume(value);
    }

}
