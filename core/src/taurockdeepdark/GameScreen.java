package taurockdeepdark;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;


/**
 * Created by Matthew Brock on 30/10/2014.
 */
//http://obviam.net/index.php/getting-started-in-android-game-development-with-libgdx-create-a-working-prototype-in-a-day-tutorial-part-1/
public class GameScreen extends Game {
    OrthographicCamera camera;
    MainCharacter mainCharacter;
    Controls controls;
    int nNumberOfMaps = 2;
    Map[] armMaps;


    @Override
    public void render() {
        armMaps[mainCharacter.nCurrentMap].render();
        mainCharacter.render();
        controls.render();
    }





    @Override
    public void create() {
        camera = new OrthographicCamera();
        mainCharacter = new MainCharacter();
        armMaps = new Map[nNumberOfMaps];//Building the array of maps and passing the camera via the constructor
        for (int i = 0; i < nNumberOfMaps; i++) {
            armMaps[i] = new Map(i, camera);
            armMaps[i].create();
        }
        controls = new Controls();
        controls.setMainCharacter(mainCharacter);
        mainCharacter.setMaps(armMaps);
        mainCharacter.setCamera(camera);
        mainCharacter.create();
        controls.create();
    }
}
