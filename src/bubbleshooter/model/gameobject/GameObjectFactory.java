package bubbleshooter.model.gameobject;
import javafx.geometry.Point2D;

public class GameObjectFactory {
    
  
    public GameObject createBasicBubble(Point2D position) {
        return new BasicBubble(position);
    }

    public GameObject createShootingBubble(Point2D position) {
        return new ShootingBubble(position);
    }

}
