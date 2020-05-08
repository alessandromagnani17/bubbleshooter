package bubbleshooter.view.cannon;

import bubbleshooter.controller.input.HandlerAdapterMouseMoved;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class DrawCannon {

    private static final Point2D CANNON_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() / 1.31);
    private static final Point2D SHOOTING_BUBBLE_POSITION = new Point2D(Settings.getGuiWidth() / 2, Settings.getGuiHeigth() - Bubble.WIDTH);

    private AnchorPane pane = new AnchorPane();
    private Rotate rotation = new Rotate();
    private Cannon cannon;
    private HandlerAdapterMouseMoved handlerAdapterMouseMoved;

    public DrawCannon(final AnchorPane pane, final Cannon cannon) {
        this.pane = pane;
        this.cannon = cannon;
        this.editCannon();
        this.setRotation();
        this.pane.getChildren().add(this.cannon.getCannon());
    }

    public final double getAngle() {
        return handlerAdapterMouseMoved.getRotationAngle();
    }

    private void editCannon() {
        this.cannon.getCannon().setLayoutX(CANNON_POSITION.getX() - this.cannon.getCannon().getImage().getWidth() / 2);
        this.cannon.getCannon().setLayoutY(CANNON_POSITION.getY());
    }

    private void setRotation() {
        this.rotation.setPivotX(SHOOTING_BUBBLE_POSITION.getX() - CANNON_POSITION.getX() + this.cannon.getCannon().getImage().getWidth() / 2);
        this.rotation.setPivotY(SHOOTING_BUBBLE_POSITION.getY() - CANNON_POSITION.getY());
        this.cannon.getCannon().getTransforms().add(rotation);
    }

    public final Rotate getRotation() {
        return this.rotation;
    }
}
