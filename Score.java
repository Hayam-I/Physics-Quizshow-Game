/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author LEEN
 */
public class Score {
     public static Scene scene;
    public static int currentLevel;
    public static int totalScore = 0;
    public static Text scoreLabel;
    public static Rectangle scoreRec;
    public static Text scoreValue;
    public static StackPane scoresPane;
    public static VBox scoresPANE;
    
    
    
  
    
    public static VBox createScoreLabel() {
        scoreLabel = new Text("SCORE");
        scoreLabel.setFont(Font.font("Cambria",20));
        scoreRec = new Rectangle(5, 5, 140, 90);
        scoreRec.setArcWidth(20);
        scoreRec.setArcHeight(20);
        scoreRec.setStroke(Color.web("D2AC47"));
        scoreRec.setStrokeWidth(5);
        scoreRec.setFill(Color.web("#f0e1cc"));
        scoreValue = new Text(Integer.toString(totalScore));
        scoreValue.setFont(Font.font(40));
        scoreValue.setStrokeWidth(5);
        scoresPane = new StackPane(scoreRec, scoreValue);
        StackPane.setAlignment(scoreLabel, Pos.TOP_CENTER);
        StackPane.setAlignment(scoreValue, Pos.CENTER);
        scoresPANE=new VBox(scoreLabel,scoresPane);
        scoresPANE.setAlignment(Pos.CENTER);
        scoresPane.setPadding(new Insets(10, 10, 10, 10));
        return scoresPANE;
    }

    public static void addScore(int n) {
        CommonElements.submit.setDisable(true);
        CommonElements.another.setVisible(false);

        if (n == 10) {
            totalScore += 10;
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+10 pts!");
            CommonElements.q1.setText("SUCCESS!");
            CommonElements.q1.setStyle("-fx-background-color: darkgreen"); //CSS SHEET
            CommonElements.q1.setDisable(true);
        } else if (n == 20) {
            totalScore += 20;
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+20 pts!");
            CommonElements.q2.setText("SUCCESS!");
            CommonElements.q2.setStyle("-fx-background-color:darkgreen"); //CSS SHEET
            CommonElements.q2.setDisable(true);
        } else if (n == 30) {
            totalScore += 30;
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+30 pts!");
            CommonElements.q3.setText("SUCCESS!");
            CommonElements.q3.setStyle("-fx-background-color: darkgreen"); //CSS SHEET
            CommonElements.q3.setDisable(true);
        } else if (n == 40) {
            totalScore += 40;
            scoreValue.setText(Integer.toString(totalScore));
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+40 pts!");
            CommonElements.q4.setText("SUCCESS!");
            CommonElements.q4.setStyle("-fx-background-color: darkgreen"); //CSS SHEET
            CommonElements.q4.setDisable(true);
        } else if (n == 50) {
            totalScore += 50;
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+50 pts!");
            CommonElements.q5.setText("SUCCESS!");
            CommonElements.q5.setStyle("-fx-background-color: darkgreen"); //CSS SHEET
            CommonElements.q5.setDisable(true);
        } else if (n == 60) {
            totalScore += 60;
            scoreValue.setText(Integer.toString(totalScore));
            Transitions.createPathTransition();
            Transitions.l.setText("+60 pts!");
            CommonElements.q6.setText("SUCCESS!");
            CommonElements.q6.setStyle("-fx-background-color: darkgreen"); //CSS SHEET
            CommonElements.q6.setDisable(true);
        }

    }
    
   public static void endLevel(Stage s ) {
     
       if(totalScore == 210) {
          
                       Launch.profile.char1.setVisible(true);
                       Launch.profile.click.setVisible(true);
                       
                       s.setScene(Transitions.createSuccess());
                             Transitions.success.setText("Congratulations! \n You have successfully completed level 1!");
                        Transitions.successAction(s);
                        s.setMaximized(true);
                         Launch.levelMap.startButton.setDisable(true);
           Launch.levelMap.startButton.setText("Level 1 Complete");
          Launch.levelMap.level2Button.setDisable(false);
      
                    }
       else if(totalScore == 420) {
            
             Launch.profile.char2.setVisible(true);
           s.setScene(Transitions.createSuccess());
            Transitions.success.setText("Congratulations! \n You have successfully completed level 2!");
                        Transitions.successAction(s);
                        s.setMaximized(true);
                        Launch.levelMap.startButton.setDisable(true);
           Launch.levelMap.level2Button.setDisable(true);
           Launch.levelMap.level3Button.setDisable(false);
            Launch.levelMap.level2Button.setText("Level 2 Completed!");
       } else if (totalScore ==630) {
           
               Launch.profile.char3.setVisible(true);
           
           s.setScene(Transitions.createSuccess());
           Transitions.success.setText("Congratulations! \n You have successfully completed level 3!");
                        Transitions.successAction(s);
                        s.setMaximized(true);
                        Launch.levelMap.startButton.setDisable(true);
            Launch.levelMap.level2Button.setDisable(true);
            Launch.levelMap.level3Button.setDisable(true);
            Launch.levelMap.level4Button.setDisable(false);
            Launch.levelMap.level3Button.setText("Level 3 Completed!");
       } else if(totalScore==840) {
           CommonElements.scoreshistory.add(Score.totalScore);
           CommonElements.FileScoreHistory=Integer.toString(totalScore);
             Launch.profile.char4.setVisible(true);
           s.setScene(Transitions.createSuccess());
              Transitions.success.setText("Congratulations! \n You have successfully completed level 4!");
                        Transitions.successAction(s);
                        s.setMaximized(true);
       }
   }
   
   public static void displayLevel() {
       Launch.profile.t2.setText(Integer.toString(currentLevel));
       
   }
   
   public static void displayScore() {
        Launch.profile.t3.setText(Integer.toString(totalScore));
   }
   
   
}
