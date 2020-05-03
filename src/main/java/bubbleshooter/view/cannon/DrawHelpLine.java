package bubbleshooter.view.cannon;

import bubbleshooter.model.gameobject.Bubble;
import bubbleshooter.utility.Settings;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class DrawHelpLine {
	
	private AnchorPane pane = new AnchorPane();
	private static final double LINE_X = Settings.getGuiWidth() / 2;
    private static final double LINE_Y = Settings.getGuiHeigth() - Bubble.getWidth();
    public static final double DASH_SIZE = Settings.getGuiHeigth()/70;
    public static final double DASH_WIDTH = Settings.getGuiHeigth()/200;
	private Line helpLine = new Line(LINE_X, LINE_Y, LINE_X, 0);
	private Line borderRight = new Line(Settings.getGuiWidth(), 0, Settings.getGuiWidth(), Settings.getGuiHeigth());
    private Line borderLeft = new Line(0, 0, 0, Settings.getGuiHeigth());
    private Line boundsLine = new Line(0,0,0,0);
	private static final double X_BUBBLE = 352.5;
	private static final double Y_BUBBLE = 600.0;
	private Rotate rotation = new Rotate();

	public DrawHelpLine(AnchorPane pane) {
		this.pane = pane;
		this.editLine(this.helpLine);
		this.editLine(this.boundsLine);
		this.setRotation();
		this.setInvisibleLine();
		this.helpLine.setMouseTransparent(true);
		this.pane.getChildren().add(helpLine);
		this.pane.getChildren().add(borderRight);
		this.pane.getChildren().add(borderLeft);
		this.pane.getChildren().add(boundsLine);
	}

	private void setInvisibleLine() {
		this.helpLine.setVisible(false);
		this.borderRight.setVisible(false);
		this.borderLeft.setVisible(false);
		this.boundsLine.setVisible(false);
	}

	private void editLine(Line line) {
		line.setStroke(Color.RED);
		line.setStrokeWidth(DASH_WIDTH);
		line.getStrokeDashArray().add(DASH_SIZE);
	}

	private void setRotation() {
		this.rotation.setPivotX(LINE_X);
		this.rotation.setPivotY(LINE_Y);
		this.helpLine.getTransforms().add(this.rotation);
	}
	
	public Line getHelpLine() {
		return this.helpLine;
	}

	public void drawLine() {
		this.helpLine.setVisible(true);
	}

	public void deleteLine() {
		this.helpLine.setVisible(false);
	}

	public Rotate getRotation() {
		return this.rotation;
	}

	public static void drawBounds(MouseEvent event) {
	}

}
