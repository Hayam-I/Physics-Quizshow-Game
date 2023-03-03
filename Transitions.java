/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author LEEN
 */
public class Transitions  {
    //score increase transition;
    public static ImageView smiley;
    public static Label l = new Label("");
    //game over transition
    public static Label gameOver;
    public static ImageView sad;
    public static Path path;
    public static PathTransition increase;
    public static Button startOver;
    public static Scene gameOverScene;
    public static Label success = new Label("");
    public static Scene successScene;
    public static Button successButton;
    public static ImageView happy;
    
   


    public static void createPathTransition() {
        l = new Label("");
        l.setFont(Font.font("Cambria",80));
        smiley = new ImageView("project/smiley2.png");
        smiley.setFitWidth(250);
        smiley.setFitHeight(250);
        path = new Path();
        path.setVisible(false);
        path.getElements().addAll(new MoveTo(50,150),new VLineTo(300));
        l.setGraphic(smiley);
        l.setContentDisplay(ContentDisplay.BOTTOM);
        increase = new PathTransition(Duration.millis(1000),path,l);
        increase.setAutoReverse(true);
        increase.setCycleCount(Timeline.INDEFINITE);
       
        
        
        
                
    }
    
    
    public static Pane createTransitionPane() {
          Pane transition = new Pane();
          transition.getChildren().addAll(Transitions.l,Transitions.path);
          return transition;
                    
    }
    
    public static BorderPane placeTransitionPane1(BorderPane g, Pane p) {
        BorderPane b = new BorderPane();
        b.setTop(CommonElements.top);
        b.setCenter(g);
        b.setRight(p);
        
        b.setBackground(CommonElements.background);
        return b;
    }
    
     public static BorderPane placeTransitionPane2(BorderPane g, Pane p) {
        BorderPane b = new BorderPane();
        b.setTop(CommonElements.top);
        b.setCenter(g);
        b.setRight(p);
        
        b.setBackground(CommonElements.background2);
        return b;
    }
     
      public static BorderPane placeTransitionPane3(BorderPane g, Pane p) {
        BorderPane b = new BorderPane();
        b.setTop(CommonElements.top);
        b.setCenter(g);
        b.setRight(p);
        
        b.setBackground(CommonElements.background3);
        return b;
    }
      
       public static BorderPane placeTransitionPane4(BorderPane g, Pane p) {
        BorderPane b = new BorderPane();
        b.setTop(CommonElements.top);
        b.setCenter(g);
        b.setRight(p);
        
        b.setBackground(CommonElements.background4);
        return b;
    }
   
    /*public static BorderPane placeTransitionPane(GridPane g, Pane p) {
        BorderPane b = new BorderPane();
        b.setTop(CommonElements.top);
        b.setCenter(g);
        b.setRight(p);
        
        b.setBackground(CommonElements.background);
        return b;
    }
  */  
    
    public static Scene createGameOver() {
  
        gameOver = new Label("GAME OVER!");
        gameOver.setFont(Font.font("Cambria",FontWeight.BOLD,150));
        gameOver.setTextFill(Color.web("#3D4851"));
        sad = new ImageView("project/sad.png");
        sad.setFitWidth(250);
        sad.setFitHeight(250);
        gameOver.setGraphic(sad);
        gameOver.setContentDisplay(ContentDisplay.BOTTOM);
        startOver = new Button("Click here to start over!");
        startOver.setId("buttons3");
        startOver.setPrefSize(350,50);
        TranslateTransition t = new TranslateTransition(Duration.millis(1000),gameOver);
        t.setByY(100);
        t.setCycleCount(Timeline.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
        
   
         VBox v = new VBox(100,gameOver,startOver);
        gameOver.setAlignment(Pos.CENTER);
        v.setAlignment(Pos.CENTER);
        BorderPane b = new BorderPane();
        b.setCenter(v);
        v.setBackground(CommonElements.background);
        b.setBackground(CommonElements.background);
            
      

        gameOverScene = new Scene(b,CommonElements.screenWidth,CommonElements.screenHeight);
  
        gameOverScene.getStylesheets().addAll("project/Design.css");
       
        return gameOverScene;
        
    }
    
    public static void startOverAction() {
          startOver.setOnAction(e->{
            if(Score.currentLevel==1) {
                Score.totalScore = 0;
            } else if(Score.currentLevel==2) {
                Score.totalScore = 210; } else if(Score.currentLevel==3) {
                Score.totalScore = 420; }  else if(Score.currentLevel==4) {
                Score.totalScore = 630; }
            Launch.switchToLevelMap();
        });
    }
   
    public static Scene createSuccess() {
        success = new Label("");
        success.setFont(Font.font("Cambria",70));
        success.setTextFill(Color.web("#C9AAF2"));
        happy = new ImageView("project/celeb.png");
        happy.setFitWidth(250);
        happy.setFitHeight(250);
        success.setGraphic(happy);
        success.setContentDisplay(ContentDisplay.BOTTOM);
        successButton = new Button("Click to see your new unlocked character!");
        successButton.setId("buttons4");
        successButton.setPrefSize(500,50);
         TranslateTransition t = new TranslateTransition(Duration.millis(1000),success);
        t.setByY(100);
        t.setCycleCount(Timeline.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
        VBox v = new VBox(100,success,successButton);
       
        BorderPane b = new BorderPane();
         
         v.setAlignment(Pos.CENTER);
        b.setCenter(v);
      
        v.setBackground(CommonElements.background);
        b.setBackground(CommonElements.background);
        successScene = new Scene(b,CommonElements.screenWidth,CommonElements.screenHeight);
        successScene.getStylesheets().addAll("project/Design.css");
        return successScene;
        
        
    }
    
      public static void successAction(Stage s) {
          successButton.setOnAction(e->{
          
            Launch.switchToProfile();
        });
    }


   
    
    
}
