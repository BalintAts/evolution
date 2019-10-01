package app;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle {

    Pane container;

    public MyCircle(double radius, Pane container) {
        super(radius);
        this.container = container;


    }

    public void destroy(){
        container.getChildren().remove(this);
    }
}
