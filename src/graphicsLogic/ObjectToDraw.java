package graphicsLogic;

import javafx.scene.image.ImageView;
import com.sun.javafx.geom.Vec2d;



public class ObjectToDraw extends ImageView {

    public Vec2d getPosition() {
        return new Vec2d(getX(), getY());
    }

    public void destroy(){

    }

    public void setPosition(Vec2d pos) {
        setX(pos.x);
        setY(pos.y);
    }
}
