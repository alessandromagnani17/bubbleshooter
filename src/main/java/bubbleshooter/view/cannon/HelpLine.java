package bubbleshooter.view.cannon;

import bubbleshooter.utility.Settings;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Class used to set the property of the line used in the game.
 */
public class HelpLine {

    public static final double DASH_SIZE = Settings.getGuiHeigth() / 70;
    public static final double DASH_WIDTH = Settings.getGuiHeigth() / 200;

    private Line line;

    /**
     * Constructor for a new Line passing the start and end point.
     * 
     * @param startPoint the start point.
     * @param endPoint   the end point.
     */
    public HelpLine(final Point2D startPoint, final Point2D endPoint) {
        this.line = new Line();
        this.line.setStartX(startPoint.getX());
        this.line.setStartY(startPoint.getY());
        this.line.setEndX(endPoint.getX());
        this.line.setEndY(endPoint.getY());
        this.editLine();
        this.setInvisible();
    }

    /**
     * Private method that make invisible the line.
     */
    private void setInvisible() {
        this.line.setVisible(false);
        this.line.setMouseTransparent(true);
    }

    /**
     * Private method used for edit the line.
     */
    private void editLine() {
        line.setStroke(Color.RED);
        line.setStrokeWidth(DASH_WIDTH);
        line.getStrokeDashArray().add(DASH_SIZE);
    }

    /**
     * @return the line.
     */
    public final Line getLine() {
        return this.line;
    }

}
