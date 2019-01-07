import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;import java.io.*;
import java.net.*;


public class Exercise31_09Client extends Application {
  private TextArea taHistoryServer = new TextArea();
  private TextArea taClient = new TextArea();
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taHistoryServer.setWrapText(true);
    taClient.setWrapText(true);
    //taServer.setDisable(true);
    
    Button btSubmit = new Button("Submit");

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taHistoryServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2, btSubmit);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    btSubmit.setOnAction(e -> {
        System.out.println(taClient.getText());
        try {
          toServer.writeUTF(taClient.getText().trim());
          taHistoryServer.appendText("C: " + taClient.getText() + "\n");
          toServer.flush();
          taClient.setText("");
        } catch(IOException exe) {
          System.out.println("METHOD ERROR");
        }
    });
    
    new Thread(() -> {
      try {
        Socket socket = new Socket("localhost", 5000);
        toServer = new DataOutputStream(socket.getOutputStream());
        fromServer = new DataInputStream(socket.getInputStream());
        
        while (true) {
          taHistoryServer.appendText("S: " + fromServer.readUTF() + "\n");
        }
      } catch (IOException e) {
        System.out.println("Error in output or input stream");
      }
    }).start();
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
