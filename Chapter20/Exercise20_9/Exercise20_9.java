import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.PriorityQueue;
import java.util.*;

public class Exercise20_9 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color: yellow");
		
		Button btAdd = new Button("+");
		Button btSubtract = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btAdd, btSubtract);
		hBox.setAlignment(Pos.CENTER);
		
		btAdd.setOnAction(e -> ballPane.add());
		btSubtract.setOnAction(e -> ballPane.subtract());
		
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(100);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);
		
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("MultipleBounceBall");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class MultipleBallPane extends Pane {
		private Timeline animation;
		
		public MultipleBallPane() {
			animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
		
		public void add() {
			double rand = (double)Math.random() * 20 + 2;
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			
			Ball ball = new Ball(30, 30, rand, color);
			getChildren().add(ball);
		}
		
		public void subtract() {
			if (getChildren().size() > 0) {
				Ball ball = (Ball)(getChildren().get(0));
				for (Node node: this.getChildren()) {
					if (((Ball)node).getRadius() > ball.getRadius()) {
						ball = (Ball)node;
					}
				}
				getChildren().remove(ball);
			}
		}
		
		public void play() {
			animation.play();
		}
		
		public void pause() {
			animation.pause();
		}
		
		public void increaseSpeed() {
			animation.setRate(animation.getRate() + .1);
		}
		
		public void decreseSpeed() {
			animation.setRate(animation.getRate() - .1);
		}
		
		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}
		
		public void moveBall() {
			for (Node node: this.getChildren()) {
				Ball ball = (Ball)node;
				
				if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1;
				}
				if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1;
				}
				
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
		}
	}
	
	class Ball extends Circle implements Comparable<Ball> {
		private double dx = 1, dy = 1;
		double radius;
		
		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color);
		}
		
		@Override
		public int compareTo(Ball ball) {
			return Integer.compare((int)this.radius, (int)ball.radius);
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}