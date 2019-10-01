package graphicsLogic;

import java.util.ArrayList;
import java.util.List;

import biology.Entity;
import biology.Species1;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Display {
    private Pane displayPane;
    private List<Entity> gameObjects = new ArrayList<>();

    public Display(Pane pane) {
        displayPane = pane;
    }

    public void add(Entity entity) {
        displayPane.getChildren().add(entity);
        gameObjects.add(entity);
    }

    public void remove(ObjectToDraw entity) {
        displayPane.getChildren().remove(entity);
        gameObjects.remove(entity);
    }

//    public List<ObjectToDraw> getGameObjects() {
//        return gameObjects;


    public void clear() {
        displayPane.getChildren().clear();
//        gameObjects.clear();
    }

    public void add(Button restartButton) {
        displayPane.getChildren().add(restartButton);
    }

    public void add(Text text) {
        displayPane.getChildren().add(text);
    }

    public void add(Label label){
        displayPane.getChildren().add(label);
    }
}
