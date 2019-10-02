package graphicsLogic;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Display {
    private Pane displayPane;

    public Display(Pane pane) {
        displayPane = pane;
    }


    public void add(Circle circle) {
        displayPane.getChildren().add(circle);
    }


    public void remove(ObjectToDraw entity) {
        displayPane.getChildren().remove(entity);
    }

    public  void remove(Circle circle)  {
        displayPane.getChildren().remove(circle);
    }


    public void clear() {
        displayPane.getChildren().clear();

    }

    public void add(Button restartButton) {
        displayPane.getChildren().add(restartButton);
    }

    public void add(Text text) {
        displayPane.getChildren().add(text);
    }

    public void add(Label label) {
        displayPane.getChildren().add(label);
    }


}
