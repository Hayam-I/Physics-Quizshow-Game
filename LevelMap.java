package project;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class LevelMap  {
    static public Button startButton;
    static public Button level2Button;
    static public Button level3Button;
    static public Button level4Button;
   
  

    int score = 0;
    public static Scene scene;
    
  
  
  
public static LevelMap createLevelMap() {
    
   
    
   
    GridPane layout = new GridPane();
    layout.setBackground(CommonElements.background6);
    layout.setHgap(100);

    
    Label levels = new Label("Level 1");
    levels.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.ITALIC,50));
    
    Font font = Font.font("Cambria",FontWeight.BOLD, FontPosture.ITALIC,25);
    
 
    scene = new Scene(layout,CommonElements.screenWidth,CommonElements.screenHeight);
 
    startButton = new Button("Start Level 1");
    CommonElements.ButtonDesign2(startButton);
    startButton.setFont(font);
    
    
    level2Button = new Button("Start Level 2");
    level2Button.setDisable(true);
     level2Button.setFont(font);
     CommonElements.ButtonDesign2(level2Button);
    
    
    level3Button = new Button("Start Level 3");
    level3Button.setDisable(true);
    level3Button.setFont(font);
    CommonElements.ButtonDesign2(level3Button);
    
    
    level4Button = new Button("Start Level 4");
    level4Button.setDisable(true);
    level4Button.setFont(font);
     CommonElements.ButtonDesign2(level4Button);
   
 
    //level1 animation:
     ImageView astro = new ImageView("project/sun.png");
     astro.setFitHeight(200);
     astro.setFitWidth(190);
    
     //astro.setY(score);
     RotateTransition r0 = new RotateTransition(Duration.millis(1000),astro);
     r0.setFromAngle(0);
     r0.setToAngle(90);
     r0.setCycleCount(INDEFINITE);
     r0.setAutoReverse(true);
     r0.play();
        
// level2 animation:
      ImageView mechanics = new ImageView("project/gear.png");
      mechanics.setFitHeight(175);
     mechanics.setFitWidth(225);
    
      RotateTransition r1 = new RotateTransition(Duration.millis(1000),mechanics);
      r1.setFromAngle(0);
      r1.setToAngle(180);
      r1.setCycleCount(INDEFINITE);
      r1.setAutoReverse(false);
      r1.play();
      
 //level3 animation:
    ImageView optics = new ImageView("project/lightprism.png");
     optics.setFitHeight(200);
     optics.setFitWidth(210);
     
     
     FadeTransition f1 = new FadeTransition(Duration.millis(1000),optics);
     f1.setFromValue(0.2);
     f1.setToValue(1.0);
     f1.setCycleCount(INDEFINITE);
     f1.setAutoReverse(true);
     f1.play();
 //level4 animation:
    ImageView electricity = new ImageView("project/lightbulb.png");
    electricity.setFitHeight(170);
    electricity.setFitWidth(210);
   TranslateTransition t = new TranslateTransition(Duration.millis(1000),electricity);
        t.setByY(10);
        t.setCycleCount(Timeline.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
 //final 
 /*
    ImageView congrats = new ImageView("project/fireworks.png");
    congrats.setFitHeight(350);
    congrats.setFitWidth(370);
    congrats.setTranslateX(800);
    congrats.setTranslateY(-90);
    Path p3 = new Path();
    p3.getElements().addAll(new MoveTo(-90,-197), new VLineTo(200)); //-90,-120
    PathTransition p4 = new PathTransition();
    p4.setNode(congrats);
    p4.setPath(p3);
    p4.setDuration(Duration.millis(3000));
    p4.setAutoReverse(true);
    p3.setVisible(false);
    p4.setCycleCount(2);
    */


    startButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        //startButton.setStyle("-fx-base: forestgreen;");
        L1 level1 = new L1();
        level1.start(Launch.mainStage);
        Score.displayLevel();
       
        
    }  
    });
    
    /*
    if(level1.score==210){
            level2Button.setDisable(false);
            startButton.setDisable(true);
            startButton.setText("Level 1 Completed!");
            
        } 
*/
    
   
    

    level2Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
         
         
        //level2Button.setStyle("-fx-base: forestgreen;");
 L2 level2 = new L2();
        level2.start(Launch.mainStage);
        Score.displayLevel();

        
        
        
     
      }    
        
    }
);
    
    
   //L3 level3 = new L3();
    level3Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        //level3Button.setStyle("-fx-base: forestgreen;");
   L3 level3 = new L3();
        level3.start(Launch.mainStage);
     Score.displayLevel();
        
      }
    });

    
   // L4 level4 = new L4();
    level4Button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
       //level4Button.setStyle("-fx-base: forestgreen;");
         L4 level4 = new L4();
        level4.start(Launch.mainStage);
        Score.displayLevel();
 
      }
    
    });
    

VBox v1 = new VBox(startButton,astro);
VBox v2 = new VBox(level2Button,mechanics);
VBox v3 = new VBox(level3Button,optics);
VBox v4 = new VBox(level4Button,electricity);
   
/*
layout.add(v1, 0, 0);
layout.add(v2, 1, 1);
layout.add(v3, 2, 2);
layout.add(v4, 3, 3);
        */
layout.addRow(2, v1,v2,v3,v4);
    //layout.setVgap(60);
    //layout.setHgap(60);
    layout.setAlignment(Pos.CENTER);
    
 LevelMap l = new LevelMap();
        l.scene = scene;
        return l;
            
  
  }

  
 


              
}