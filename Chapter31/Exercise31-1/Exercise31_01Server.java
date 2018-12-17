// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;import java.net.*;
import java.io.*;


public class Exercise31_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
    
    new Thread(() -> {
      try {
        ServerSocket serverSocket = new ServerSocket(5000);
        Platform.runLater(() -> ta.appendText("Server started at " + new Date() + '\n'));
        
        Socket socket = serverSocket.accept();
        
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
        
        while (true) {
          double interest = inputFromClient.readDouble();
          int years = inputFromClient.readInt();
          double amount = inputFromClient.readDouble();
          
          Loan loan = new Loan(interest, years, amount);
          
          outputToClient.writeDouble(loan.getMonthlyPayment());
          outputToClient.writeDouble(loan.getTotalPayment());
        }
      }
      catch (IOException e) {
        System.out.println("ERROR");
      }
    }).start();
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
    
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
