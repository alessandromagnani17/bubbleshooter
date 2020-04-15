package bubbleshooter.model.gameobject;

import javafx.geometry.Point2D;

public class GameObjectFactory {

    public final GameObject createBasicBubble(final Point2D position) {
        return new BasicBubble(position); 
    }
    public final GameObject createShootingBubble(final Point2D position) {
        return new ShootingBubble(position); 

    }

}
