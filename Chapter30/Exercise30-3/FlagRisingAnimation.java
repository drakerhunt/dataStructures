import javafx.animation.PathTransition; 
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
	PathTransition pt;
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		// Create a pane
		Pane pane = new Pane();
		
		// Add an image view and add it to pane
		ImageView imageView = new ImageView("image/us.gif");
		pane.getChildren().add(imageView);
		
		// Create a path transition
		pt = new PathTransition(Duration.millis(5000), new Line(100, 200, 100, 0), imageView); 
		pt.setCycleCount(5);
		
		Thread thread = new Thread(new RunClass(pt));
		thread.start();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
class RunClass implements Runnable {
	PathTransition pt;
		public RunClass(PathTransition pt) {
			this.pt = pt;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(10);
				pt.play();
			} catch (InterruptedException e) {
				System.out.print("EX");	
			}
		}
	}