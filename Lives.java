/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author LEEN
 */
public class Lives {

    static public int lives;
    static public ImageView fullheart1;
    static public ImageView fullheart2 ;
    static public ImageView fullheart3;
    static public ImageView emptyheart1 ;
    static public ImageView emptyheart2 ;
    static public ImageView emptyheart3 ;
    static public HBox livesLeft;
    static public Text livesLabel;
    static public Rectangle livesRec;
    public static StackPane livesPane;
    public static VBox livesPANE;


    public static VBox createLivesLabel() {
        //adjusting dimensions
        lives = 3;
        fullheart1 =  new ImageView("project/fullheart.png");
        fullheart2 =  new ImageView("project/fullheart.png");
        fullheart3 =  new ImageView("project/fullheart.png");
        
        emptyheart1 = new ImageView("project/emptyheart.png");
        emptyheart2 = new ImageView("project/emptyheart.png");
        emptyheart3 = new ImageView("project/emptyheart.png");
         
        livesLeft = new HBox(7);
        livesLeft.setPadding(new Insets(10, 10, 10, 10));
        fullheart1.setFitWidth(70);
        fullheart1.setFitHeight(70);

        fullheart2.setFitWidth(70);
        fullheart2.setFitHeight(70);

        fullheart3.setFitWidth(70);
        fullheart3.setFitHeight(70);
        livesLeft.getChildren().addAll(fullheart1, fullheart2, fullheart3); //creating HBox with three full hearts to be displayed initially

        emptyheart1.setFitWidth(70);
        emptyheart1.setFitHeight(70);

        emptyheart2.setFitWidth(70);
        emptyheart2.setFitHeight(70);

        emptyheart3.setFitWidth(70);
        emptyheart3.setFitHeight(70);

        //creating label for lives to be displayed 
        livesLabel = new Text("LIVES");
        livesLabel.setFont(Font.font("Cambria",20));
        livesRec = new Rectangle(5, 5, 240, 90);
        livesRec.setArcWidth(20);
        livesRec.setArcHeight(20);
        livesRec.setStroke(Color.web("D2AC47"));
        livesRec.setStrokeWidth(5);
        livesRec.setFill(Color.web("#f0e1cc"));
        livesPane = new StackPane(livesRec, livesLeft);
        
        
        
        livesPANE = new VBox(livesLabel,livesPane);
        StackPane.setAlignment(livesLabel, Pos.TOP_CENTER);
      StackPane.setAlignment(livesLeft, Pos.BOTTOM_CENTER);
       livesPANE.alignmentProperty().set(Pos.CENTER);
        livesPane.setPadding(new Insets(10, 10, 10, 10));
        return livesPANE;
    }
   

    public static void updateLives() {
        CommonElements.another.setVisible(true);

        if (lives == 3) {
            lives--;
            livesLeft.getChildren().remove(fullheart3);
            livesLeft.getChildren().add(emptyheart3); }
            else if (lives == 2) {
                lives--;
                livesLeft.getChildren().remove(fullheart2);
                livesLeft.getChildren().add(emptyheart2);

            } else if (lives == 1) {
                CommonElements.submit.setDisable(true);
                CommonElements.another.setDisable(true);
                lives--;
                livesLeft.getChildren().remove(fullheart1);
                livesLeft.getChildren().add(emptyheart1);
                CommonElements.scoreshistory.add(Score.totalScore);
                CommonElements.FileScoreHistory=Integer.toString(Score.totalScore);

            }
        }

    }

