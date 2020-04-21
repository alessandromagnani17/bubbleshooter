package bubbleshooter.controller;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage; 

public class InputController extends Application {

	//POSIZIONI TEMPORANEE
	public static final double CANNON_POSITIONX = 458;
	public static final double CANNON_POSITIONY = 490;
	public static final double SHOOTINGBUBBLE_CENTERX = 498;
	public static final double SHOOTINGBUBBLE_CENTERY = 650;

    private Pane root = new Pane();

    //private Cannon cannon = new Cannon(new Point2D(CANNON_POSITIONX, CANNON_POSITIONY));
    private ImageView cannon = new ImageView(new Image("bubbles/cannon.png"));
    //private ShootingBubble shootingBubble = new ShootingBubble(new Point2D(SHOOTINGBUBBLE_CENTERX, SHOOTINGBUBBLE_CENTERY));

    private Rotate rotation = new Rotate();

    public InputController(final Pane root) {
        this.root = root;
    }

    public final void start(final Stage stage) throws Exception {

        Scene scene = new Scene(root, 960, 700);
        stage.setScene(scene);
        stage.show();

        rotation.setPivotX(SHOOTINGBUBBLE_CENTERX - CANNON_POSITIONX);
        rotation.setPivotY(SHOOTINGBUBBLE_CENTERY - CANNON_POSITIONY);
        cannon.getTransforms().add(rotation);

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

        @Override
        public void handle(final MouseEvent event) {
            rotation.setAngle(calculateAngle(event));
            System.out.println(event.getX() + ",  " + event.getY() + "     " + rotation.getPivotX() 
             					+ ", " + rotation.getPivotY() + "     " + calculateAngle(event));
        }
    });
    }

    public final double calculateAngle(final MouseEvent event) {
        double ipotenuse = Math.sqrt(Math.pow(event.getX() - SHOOTINGBUBBLE_CENTERX, 2) + Math.pow(event.getY() - SHOOTINGBUBBLE_CENTERY, 2));
        return Math.toDegrees(Math.asin((event.getX() - SHOOTINGBUBBLE_CENTERX) / ipotenuse));
    }

    public final void stop() {
        //cannon.setRotate(0);
    }
}