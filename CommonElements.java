/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;

/**
 *
 * @author LEEN
 */
public class CommonElements {

    
    public static HBox top;
    public static HBox h;
    public static Button submit;

    public static Button forward;
   
    public static Button another;
    public static Label check;
    public static GridPane questions;
    public static Button q1;
    public static Button q2;
    public static Button q3;
    public static Button q4;
    public static Button q5;
    public static Button q6;
    public static GridPane board;
    public static int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    public static int screenHeight = (int) Screen.getPrimary().getBounds().getHeight()-90;
   public static Media media = new Media("file:///C://Users//hayam//OneDrive//Documents//NetBeansProjects//Golden_Quest//src//project//videoplayback.mp4");
   public static MediaPlayer mp = new MediaPlayer(media); 
    public static BorderPane borderpane; 
    
    public static ArrayList<Integer> scoreshistory = new ArrayList<>();
    public static String FileScoreHistory;
    
    public static BackgroundFill bg = new BackgroundFill(Color.web("#f0e1cc"),CornerRadii.EMPTY,Insets.EMPTY);
    public static Background background = new Background(bg);
    
    public static BackgroundFill bg2 = new BackgroundFill(Color.web("#f0e1cc"),CornerRadii.EMPTY,Insets.EMPTY);
    public static Background background2 = new Background(bg2);
    
    public static BackgroundFill bg3 = new BackgroundFill(Color.web("#f0e1cc"),CornerRadii.EMPTY,Insets.EMPTY);
    public static Background background3 = new Background(bg3);
    
    public static BackgroundFill bg4 = new BackgroundFill(Color.web("#f0e1cc"),CornerRadii.EMPTY,Insets.EMPTY);
    public static Background background4 = new Background(bg4);
    
    
    
   public static BackgroundFill bg5 = new BackgroundFill(Color.web("#af8062"),new CornerRadii(8),new Insets(0,5,6,7));
    public static Background background5 = new Background(bg5);
    
     public static BackgroundFill bg7 = new BackgroundFill(Color.FIREBRICK,new CornerRadii(8),new Insets(0,5,6,7));
    public static Background background7 = new Background(bg7);
    
    public static BackgroundFill bg6 = new BackgroundFill(Color.web("#f0e1cc"),new CornerRadii(8),new Insets(0,5,6,7));
    public static Background background6 = new Background(bg6);

    public static void ButtonDesign(Button b){
            b.setPadding(new Insets(8,15,15,15));
            b.backgroundProperty().set(CommonElements.background5);
            b.setTextFill(Color.BEIGE);
            
        }
    public static void ButtonDesign2(Button b){
            b.setPadding(new Insets(8,15,15,15));
            b.backgroundProperty().set(CommonElements.background7);
            b.setTextFill(Color.BEIGE);
            
        }
    
     final static  Integer TIME = 31;
     static Timeline timeline;
     public static Label label;
     static Integer timeSeconds = TIME;
     
    public static VBox createTimerLabel(){ 
        timeSeconds = TIME;


        StackPane sp=new StackPane();
        label = new Label();
        Text t = new Text("TICK TOCK");
        t.setFont(Font.font("Cambria",20));
        
        Rectangle rec=new Rectangle(350,90);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        rec.setStroke(Color.web("D2AC47"));
        rec.setStrokeWidth(5);
        rec.setFill(Color.web("#f0e1cc"));

        label.setFont(Font.font("Cambria",40));
        
       sp.setAlignment(Pos.CENTER);
        sp.setPadding(new Insets(10, 10, 10, 10));
 
     
           if (timeline != null) {
                timeline.stop();
    }
   
            timeSeconds = TIME;

            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.seconds(1), (ActionEvent event1) -> {                       
                        timeSeconds--;
                        if (timeSeconds<31 && timeSeconds>=6)
                        
                        label.setText(
                                timeSeconds.toString()+" seconds");

                        if (timeSeconds <=5 && timeSeconds >4){
                            label.setText("FIVE");
                        }
                        if (timeSeconds <=4 && timeSeconds >3){
                            label.setText("FOUR");
                        }
                        if (timeSeconds <=3 && timeSeconds >2){
                            label.setText("THREE");
                        }
                        if (timeSeconds <=2 && timeSeconds >1){
                            label.setText("TWO");
                        }
                        if (timeSeconds <=1 && timeSeconds >0){
                            label.setText("ONE");
                        }
                        if (timeSeconds <= 0) {
                            timeline.stop();
                            label.setText("TIME IS UP");
                             CommonElements.timeUp();
                    Lives.updateLives();
                    submit.setDisable(true);
                    if(Lives.lives==0) {
                               Launch.mainStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                            
                            
                        }
                        
            } 
            ));
            timeline.playFromStart();

   
        VBox vb=new VBox(t,sp);
 
        sp.getChildren().addAll(rec,label);
       
        vb.setAlignment(Pos.CENTER);
        return vb;
 
        
    }
        
 

    

    public static BorderPane buildBoard() {
        
        h = new HBox(30, Score.createScoreLabel(), Lives.createLivesLabel());
        top = new HBox(1080,h);
       
        
        borderpane=new BorderPane();
        
        Score.scoreValue.setText(Integer.toString(Score.totalScore));
        
        questions = new GridPane();
        q1 = new Button("10 pts");
        q1.setId("grid");
        q2 = new Button("20 pts");
        q2.setId("grid");
        q3 = new Button("30 pts");
        q3.setId("grid");
        q4 = new Button("40 pts");
        q4.setId("grid");
        q5 = new Button("50 pts");
        q5.setId("grid");
        q6 = new Button("60 pts");
        q6.setId("grid");
        board = new GridPane();
        questions.addRow(0, q1, q2, q3);
        questions.addRow(1, q4, q5, q6);
        board.setHalignment(questions,HPos.CENTER);
        //board.addRow(0, top);
        board.add(questions, 1, 3);
        board.setVgap(50);
        board.alignmentProperty().set(Pos.CENTER);
        borderpane.setTop(top);
        
        borderpane.setCenter(board);
        borderpane.setBackground(CommonElements.background);
        return borderpane;

    }
    
    public static void createButtons() {
        submit = new Button("Submit");
        submit.setId("buttons");
        check = new Label();
        //check.setId("buttons");
        forward = new Button("Click here to move forward!");
        forward.setId("buttons");
        another = new Button("Click here to try another question!");
        another.setId("buttons");
        another.setVisible(false);
    }
    
    public static void setCorrect() {
        check.setText("Your answer is correct!");
    }
    
    public static void setIncorrect() {
        check.setText("Your answer is incorrect. Try again!");
    }
    
    public static void timeUp() {
        check.setText("Your time is up!");
    }

}
