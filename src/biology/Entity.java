package biology;

import com.sun.javafx.geom.Vec2d;

import javax.swing.text.Element;
import javafx.scene.image.ImageView;

public class Entity extends ImageView {


    public Entity() {
    }

//    public void destroy() {
//        Globals.getInstance().display.remove(this);
//    }
//
    public Vec2d getPosition() {
        return new Vec2d(getX(), getY());
    }

    public void setPosition(Vec2d pos) {
        setX(pos.x);
        setY(pos.y);
    }
//
//    public boolean isOutOfBounds() {
//        if (getX() > Globals.WINDOW_WIDTH - 30 || getX() < 0 ||
//                getY() > Globals.WINDOW_HEIGHT - 30 || getY() < 0) {
//            return true;
//        }
//        return false;
//    }
}
