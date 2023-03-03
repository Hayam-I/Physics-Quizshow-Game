package project;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import static project.CommonElements.createTimerLabel;
import static project.CommonElements.top;

/**
 *
 * @author HAYAM & LAYAN
 */
public class L2 extends Application {

    public BorderPane level2Board = CommonElements.buildBoard();    
    public Scene level2 = new Scene(level2Board,CommonElements.screenWidth,CommonElements.screenHeight);
    
public static void main(String[] args){
    launch(args);
}
    

 

    @Override
    public void start(Stage primaryStage) {
        
        Score.currentLevel = 2;
   
        level2.getStylesheets().add("project/Design.css");
        primaryStage.setScene(level2);
        primaryStage.show();
        primaryStage.setMaximized(true);

        CommonElements.q1.setOnAction(e -> {
          Slider slider = new Slider(0,5,0);
          slider.setBlockIncrement(0.1);
          slider.setPrefSize(50, 50);
          slider.setOrientation(Orientation.HORIZONTAL);
          slider.setShowTickLabels(true);
          slider.setShowTickMarks(true);
          slider.setMajorTickUnit(0.5);
          TextField t1 = new TextField();
          t1.setFocusTraversable(false);
          t1.setEditable(false);
          slider.valueProperty().addListener( e1 ->{
            double a = slider.getValue();
            boolean b;
            if(a>2.899999 && a<2.3){
                 b = true;
            }
            else{
                b=false;
            }
            t1.setText(Double.toString(a));
        });
            slider.setId("instructions");

            
             t1.setId("instructions");

            
            VBox flow = new VBox(slider, t1);

            Label instruction = new Label("Complete the following statement: \n The speed of light in vacuum is _____ x 10^8. \n Make sure your answer is in a 0.1 difference range");
             instruction.setId("instructions");

            CommonElements.createButtons();
            GridPane level2q1 = new GridPane();
            BorderPane level2q1b = new BorderPane();
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(150);
            i.setFitWidth(150);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q1b.setBottom(i);
            level2q1.alignmentProperty().set(Pos.TOP_CENTER);
            level2q1.setVgap(20);
            //level2q1.addRow(0, CommonElements.top);
            level2q1.addRow(1, instruction);
            level2q1.addRow(2, flow);
            level2q1.addRow(3, CommonElements.submit);
            level2q1.addRow(4, CommonElements.check);
            level2q1.addRow(5, CommonElements.another);
        
            level2q1b.setCenter(level2q1);
           
            
             VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q1b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });

            Scene level2Q1 = new Scene(level2q1b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q1.getStylesheets().add("project/Design.css");
            level2q1b.setBackground(CommonElements.background2);
            primaryStage.setScene(level2Q1);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (t1.getText().compareTo("2.9")>0 &&t1.getText().compareTo("3.0")<0) {
                    CommonElements.timeline.stop();
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level2q1.getChildren().remove(CommonElements.another);
                    level2q1.addRow(5, CommonElements.forward);
                    level2Q1.setRoot(Transitions.placeTransitionPane2(level2q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);


                } else {
                    t1.clear();
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

        CommonElements.q2.setOnAction(e -> {

            Label instruction = new Label("Which of the following forces are acting on the object sliding down the inclined plane? Select all that apply.");
             instruction.setId("instructions");
            ImageView inclinedplane = new ImageView("project/inclinedplane.png");
            inclinedplane.setFitHeight(200);
            inclinedplane.setFitWidth(300);
            inclinedplane.setId("instructions");
            //correct answers are ch1 and ch5 and ch6
            CheckBox ch1 = new CheckBox("Normal Force perpendicular to surface exerting the force.");           
           
            CheckBox ch4 = new CheckBox("Gravitational force parallel to the surface of incline ONLY.");
            CheckBox ch5 = new CheckBox("Gravitational force perpendicular AND parallel to the surface of incline.");
            CheckBox ch6 = new CheckBox("Kinetic Friction force.");
            
            ch1.setId("instructions");
           
            ch4.setId("instructions");
            ch5.setId("instructions");
            ch6.setId("instructions");
            
            VBox sources = new VBox(10,ch1,ch4,ch5,ch6);
            VBox v = new VBox(15,inclinedplane,sources);
            CommonElements.createButtons();
            GridPane level2q2 = new GridPane();
            BorderPane level2q2b = new BorderPane();
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(150);
            i.setFitWidth(150);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q2b.setBottom(i);
            level2q2b.setBackground(CommonElements.background2);
            level2q2.alignmentProperty().set(Pos.TOP_CENTER);
            level2q2.setVgap(20);
            //level2q2.addRow(0, CommonElements.top);
            level2q2.addRow(1, instruction);
            level2q2.addRow(2, v);
            level2q2.addRow(3, CommonElements.submit);
            level2q2.addRow(4, CommonElements.check);
            level2q2.addRow(5, CommonElements.another);
            level2q2b.setCenter(level2q2);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q2b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });

            Scene level2Q2 = new Scene(level2q2b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q2.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level2Q2);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (ch1.isSelected() && ch5.isSelected() && ch6.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(20);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level2Q2.setRoot(Transitions.placeTransitionPane2(level2q2b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level2q2.getChildren().remove(CommonElements.another);
                    level2q2.addRow(5, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    ch1.setSelected(false);
                    //ch2.setSelected(false);
                    //ch3.setSelected(false);
                    ch4.setSelected(false);
                    ch5.setSelected(false);
                    ch6.setSelected(false);
                    //ch7.setSelected(false);
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

        CommonElements.q3.setOnAction(e -> {
            Label instruction = new Label("Which of the following waves has the longest wavelengh?");
            
            instruction.setId("instructions");
            ImageView wave = new ImageView("project/waves2.png");
            wave.setFitHeight(300);
            wave.setFitWidth(300);
            ListView<String> lv = new ListView<>(FXCollections.observableArrayList());
            lv.setOrientation(Orientation.HORIZONTAL);
           
           
            lv.getItems().addAll("A","B","C");
           lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
           //lv.setMaxSize(150, 600);
           lv.setPrefSize(25, 100);
           lv.setMaxWidth(200);
           wave.setId("instructions");
           lv.setId("instructions");
            CommonElements.createButtons();
            VBox v = new VBox(10,wave,lv);
            GridPane level2q3 = new GridPane();
            BorderPane level2q3b = new BorderPane();
            
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(150);
            i.setFitWidth(150);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q3b.setBottom(i);
                    
            level2q3.alignmentProperty().set(Pos.TOP_CENTER);
            level2q3.setVgap(20);
            //level2q3.add(CommonElements.top,0,0);
            level2q3.add(instruction,0,1);
            level2q3.add(v,0,2);
            level2q3.add( CommonElements.submit,0,3);
            level2q3.add(CommonElements.check,0,4);
            level2q3.add( CommonElements.another,0,5);
         
            level2q3b.setCenter(level2q3);
            level2q3b.setBackground(CommonElements.background2);
 VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q3b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });

            Scene level2Q3 = new Scene(level2q3b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q3.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level2Q3);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (lv.getSelectionModel().getSelectedIndex()==1) {
                    CommonElements.timeline.stop();
                    Score.addScore(30);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level2Q3.setRoot(Transitions.placeTransitionPane2(level2q3b,Transitions.createTransitionPane()));
                    
                    Transitions.increase.play();
                    level2q3.getChildren().remove(CommonElements.another);

                    level2q3.addRow(5, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                   CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

        CommonElements.q4.setOnAction(e -> {
            Label instruction = new Label("What is the gravitational force on an object whose mass is 500 g? Let gravity be 9.8N. \nMake sure your answer is within a 0.1 difference range.");
            instruction.setId("instructions");
            Slider slider = new Slider(0,5,0);
          slider.setBlockIncrement(0.1);
          slider.setOrientation(Orientation.HORIZONTAL);
          slider.setShowTickLabels(true);
          slider.setShowTickMarks(true);
          slider.setMajorTickUnit(0.5);
          TextField t4 = new TextField();
          t4.setFocusTraversable(false);
          t4.setEditable(false);
          slider.setId("instructions");
          t4.setId("instructions");
          slider.valueProperty().addListener( e1 ->{
            double a = slider.getValue();
            boolean b;
            if(a>4.899999 && a<5.0){
                 b = true;
            }
            else{
                b=false;
            }
            t4.setText(Double.toString(a));
        });
           VBox flow = new VBox(slider, t4);
            CommonElements.createButtons();
            
            GridPane level2q4 = new GridPane();
            BorderPane level2q4b = new BorderPane();
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q4b.setBottom(i);
            level2q4b.setBackground(CommonElements.background2);
            level2q4.alignmentProperty().set(Pos.TOP_CENTER);
            level2q4.setVgap(20);
            //level2q4.addRow(0, CommonElements.top);
            level2q4.addRow(1, instruction);
            level2q4.addRow(2,flow );
            level2q4.addRow(3, CommonElements.submit);
            level2q4.addRow(4, CommonElements.check);
            level2q4.addRow(5, CommonElements.another);

            level2q4b.setCenter(level2q4);
          VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q4b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });

            Scene level2Q4 = new Scene(level2q4b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q4.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level2Q4);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (t4.getText().compareTo("4.9")>=0 &&t4.getText().compareTo("5.0")<0) {
                    CommonElements.timeline.stop();
                    Score.addScore(40);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level2Q4.setRoot(Transitions.placeTransitionPane2(level2q4b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level2q4.getChildren().remove(CommonElements.another);
                    level2q4.addRow(6, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    t4.clear();
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

        CommonElements.q5.setOnAction(e -> {
            Label instruction = new Label("Which of the following are forces?");
            Label i2 = new Label(" (A)Muscular Force\n (B)Magnetic force\n (C)Frictional force\n (D)Gravitational force\n (E)Electrostatic force");
            i2.setId("instructions");
            instruction.setId("instructions");
            CheckBox ch1 = new CheckBox("B and E only");
            CheckBox ch2 = new CheckBox("A,B and D only");
            CheckBox ch3 = new CheckBox("B,D and E only");
            CheckBox ch4 = new CheckBox("B,C,D and E");
            CheckBox ch5 = new CheckBox("None of the above");
            ch1.setId("instructions");
            ch2.setId("instructions");
            ch3.setId("instructions");
            ch4.setId("instructions");
            ch5.setId("instructions");

            VBox symbols = new VBox(15, ch1, ch2, ch3, ch4,ch5);

           
            CommonElements.createButtons();
            GridPane level2q5 = new GridPane();
            BorderPane level2q5b = new BorderPane();
            /*
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(50);
            i.setFitWidth(50);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q5b.setBottom(i);
                    */
            level2q5.setVgap(20);
            level2q5.alignmentProperty().set(Pos.TOP_CENTER);
            //level2q5.addRow(0, CommonElements.top);
            level2q5.addRow(1, instruction);
            level2q5.addRow(2, i2);
            level2q5.addRow(3, symbols);
            level2q5.addRow(4, CommonElements.submit);
            level2q5.addRow(5, CommonElements.check);
            level2q5.addRow(6, CommonElements.another);
            level2q5b.setCenter(level2q5);
       
            level2q5b.setBackground(CommonElements.background2);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q5b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            Scene level2Q5 = new Scene(level2q5b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q5.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level2Q5);
            primaryStage.setMaximized(true);
            
            CommonElements.submit.setOnAction(e3 -> {
                if (ch3.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(50);
                    Score.displayScore();
                 level2Q5.setRoot(Transitions.placeTransitionPane2(level2q5b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level2q5.getChildren().remove(CommonElements.another);
                    level2q5.addRow(6, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    ch1.setSelected(false);
                    ch2.setSelected(false);
                    ch3.setSelected(false);
                    ch4.setSelected(false);
                    ch5.setSelected(false);
CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

        CommonElements.q6.setOnAction(e -> {
            Label instruction = new Label("The formula to calculate the speed of a wave is:");
            instruction.setId("instructions");
            ImageView wave = new ImageView("project/wave.png");
            wave.setFitHeight(200);
            wave.setFitWidth(400);
            wave.setId("instructions");
            ListView<String> lv = new ListView<>(FXCollections.observableArrayList());
            lv.setOrientation(Orientation.HORIZONTAL);

            lv.setId("instructions");
            lv.getItems().addAll("v=λ/f","v=T/λ","v=λf","v=λT");
           lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
           lv.setPrefHeight(75);
           lv.setMaxWidth(500);
           VBox vbox = new VBox(15,wave,lv);
           
            CommonElements.createButtons();
            
            GridPane level2q6 = new GridPane();
            BorderPane level2q6b = new BorderPane();
            ImageView i = new ImageView("project/settings.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level2q6b.setBottom(i);
            level2q6.setVgap(20);
            level2q6.alignmentProperty().set(Pos.TOP_CENTER);
            //level2q6.addRow(0, CommonElements.top);
            level2q6.addRow(1, instruction);
            level2q6.addRow(2, vbox);
            level2q6.addRow(3, CommonElements.submit);
            level2q6.addRow(4, CommonElements.check);
            level2q6.addRow(5, CommonElements.another);
         
            level2q6b.setCenter(level2q6);
            level2q6b.setBackground(CommonElements.background2);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level2q6b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level2);
                primaryStage.setMaximized(true);
            });

            Scene level2Q6 = new Scene(level2q6b,CommonElements.screenWidth,CommonElements.screenHeight);
            level2Q6.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level2Q6);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (lv.getSelectionModel().getSelectedIndex()==2) {
                    CommonElements.timeline.stop();
                    Score.addScore(60);
                    Score.displayScore();
                    CommonElements.setCorrect();
                 level2Q6.setRoot(Transitions.placeTransitionPane2(level2q6b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level2q6.getChildren().remove(CommonElements.another);

                    level2q6.addRow(7, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                }

            });

        });

    }


}

