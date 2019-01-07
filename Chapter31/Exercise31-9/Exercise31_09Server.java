import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import java.util.*;


public class Exercise31_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taClient.setDisable(true);
    
    Button btSubmit = new Button("Submit");

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2, btSubmit);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    new Thread(() -> {
      try {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
        
        Platform.runLater(() -> taServer.appendText("Server started at " + new Date() + '\n'));
        
        while (true) {
          btSubmit.setOnAction(e -> {
            try {
              outputToClient.writeUTF(taClient.getText().trim());
              outputToClient.flush();
              taServer.appendText("S: " + taClient.getText() + "\n");
              taClient.setText("");
            } catch (IOException ex) {
                System.out.println("Error in Button Submit");
              }
          });
          taServer.appendText("C: " + inputFromClient.readUTF() + "\n");
        }
        } catch (IOException exe) {
        System.out.println("Server Error");
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
