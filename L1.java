package project;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static project.CommonElements.createTimerLabel;
import static project.CommonElements.top;

/**
 *
 * @author REEMA
 */
public class L1 extends Application {
    public static void main(String[] args){
        launch(args);
    }
   
    public Boolean[] allPlaced = {false,false,false,false};
    public BorderPane level1Board = CommonElements.buildBoard();
    
    
    
    public Scene level1 = new Scene(level1Board, CommonElements.screenWidth,CommonElements.screenHeight);
    //level1Board.setBackground(CommonElements.background5);

    


    

  

    @Override
    public void start(Stage primaryStage) {
        

        Score.currentLevel = 1;
        level1.getStylesheets().add("project/Design.css");
        primaryStage.setScene(level1);
        primaryStage.show();
        primaryStage.setMaximized(true);

        CommonElements.q1.setOnAction(e -> {
           

            Label instruction = new Label("Which of the following is the largest planet in the solar system?");
            instruction.setId("instructions");
            RadioButton option1=new RadioButton("Mars");
            RadioButton option2= new RadioButton("Earth");
            RadioButton option3= new RadioButton("Jupiter");
            RadioButton option4= new RadioButton("Uranus");				
                //Creating Toggle to select only one option
            ToggleGroup mcq1= new ToggleGroup();				
		//adding radio buttons to toggle group
            option1.setToggleGroup(mcq1);
            option2.setToggleGroup(mcq1);
            option3.setToggleGroup(mcq1);
            option4.setToggleGroup(mcq1);
            
            option1.setId("instructions");
            option2.setId("instructions");
            option3.setId("instructions");
            option4.setId("instructions");
            VBox options = new VBox(10,option1,option2,option3,option4);
            		
				
             
            CommonElements.createButtons();
            GridPane level1q1 = new GridPane();
            BorderPane level1q1b = new BorderPane();
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q1b.setBottom(i);
          
            level1q1.alignmentProperty().set(Pos.TOP_CENTER);
            level1q1.setVgap(20);
            //level1q1.addRow(0, CommonElements.top);
            level1q1.addRow(1, instruction);
            level1q1.addRow(2, options);
            level1q1.addRow(3, CommonElements.submit);
            level1q1.addRow(4, CommonElements.check);
            level1q1.addRow(5, CommonElements.another);
            level1q1b.setCenter(level1q1);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q1b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            
           

            Scene level1Q1 = new Scene(level1q1b,CommonElements.screenWidth,CommonElements.screenHeight);
           
            level1Q1.getStylesheets().add("project/Design.css");
            
            level1q1b.setBackground(CommonElements.background);
            
            primaryStage.setScene(level1Q1);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (option3.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
              
                    level1q1.getChildren().remove(CommonElements.another);
                    level1q1.addRow(5, CommonElements.forward);
                    level1Q1.setRoot(Transitions.placeTransitionPane1(level1q1b,Transitions.createTransitionPane()));
                    
                    
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);

                }  
                   
                    
                    
                else {
                    option1.setSelected(false);
                    option2.setSelected(false);
                    option3.setSelected(false);
                    option4.setSelected(false);
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

            Label instruction = new Label("What is the brightest star in the solar system?");
            instruction.setId("instructions");
            RadioButton option1=new RadioButton("Sirius");
            RadioButton option2= new RadioButton("Alpha Centauri A");
            RadioButton option3= new RadioButton("The sun");
            RadioButton option4= new RadioButton("Proxima Centauri");				
                //Creating Toggle to select only one option
            ToggleGroup mcq1= new ToggleGroup();				
		//adding radio buttons to toggle group
            option1.setToggleGroup(mcq1);
            option2.setToggleGroup(mcq1);
            option3.setToggleGroup(mcq1);
            option4.setToggleGroup(mcq1);
            
            VBox options = new VBox(10,option1,option2,option3,option4);
            option1.setId("instructions");
            option2.setId("instructions");
            option3.setId("instructions");
            option4.setId("instructions");
            CommonElements.createButtons();
            GridPane level1q4 = new GridPane();
            BorderPane level1q4b = new BorderPane();
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q4b.setBottom(i);
            level1q4.alignmentProperty().set(Pos.TOP_CENTER);
            level1q4.setVgap(20);
            //level1q4.setBackground(CommonElements.background);
            //level1q4.addRow(0, CommonElements.top);
            level1q4.addRow(1, instruction);
            level1q4.addRow(2, options);
            level1q4.addRow(3, CommonElements.submit);
            level1q4.addRow(4, CommonElements.check);
            level1q4.addRow(5, CommonElements.another);
            level1q4b.setCenter(level1q4);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q4b.setTop(CommonElements.top);
            level1q4b.setBackground(CommonElements.background);
            CommonElements.forward.setOnAction(e1 -> {
                CommonElements.top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                CommonElements.top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });

            Scene level1Q4 = new Scene(level1q4b,CommonElements.screenWidth,CommonElements.screenHeight);
            level1Q4.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level1Q4);
            primaryStage.setMaximized(true);          
            CommonElements.submit.setOnAction(e3 -> {
                if (option1.isSelected()) {
                    CommonElements.timeline.pause();
                    Score.addScore(40);
                  Score.displayScore();
                    CommonElements.setCorrect();
                    level1Q4.setRoot(Transitions.placeTransitionPane1(level1q4b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level1q4.getChildren().remove(CommonElements.another);
                    level1q4.addRow(5, CommonElements.forward);
                    Score.endLevel(primaryStage);
                } else {
                    option2.setSelected(false);
                    option3.setSelected(false);
                    option4.setSelected(false);
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
            Label instruction = new Label("What is the radius of Earth in km, knowing that its circumference is 40,075 km? \nConsider π as 3.14.\nRound your answer to the nearest integer.");           
            instruction.setId("instructions");
            TextField tf1 = new TextField();
            
            tf1.setMaxSize(250, 75);
            CommonElements.createButtons();
            GridPane level1q2 = new GridPane();
            BorderPane level1q2b = new BorderPane();
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q2b.setBottom(i);
             
            level1q2.alignmentProperty().set(Pos.TOP_CENTER);
            //level1q2.setBackground(CommonElements.background);
            level1q2.setVgap(20);
            //level1q2.add(CommonElements.top,0,0);
            level1q2.add(instruction,0,1);
            level1q2.add(tf1,0,2);
            level1q2.add( CommonElements.submit,0,3);
            level1q2.add( CommonElements.check,0,4);
            level1q2.add( CommonElements.another,0,5);
            level1q2b.setCenter(level1q2);

            level1q2b.setBackground(CommonElements.background);

           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q2b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });

            Scene level1Q2 = new Scene(level1q2b,CommonElements.screenWidth,CommonElements.screenHeight);
            level1Q2.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level1Q2);
            primaryStage.setMaximized(true);
           
            CommonElements.submit.setOnAction(e3 -> {
                if (tf1.getText().equals("6381") ||tf1.getText().equals("6,381") ) {
                    CommonElements.timeline.stop()
                    Score.addScore(20);
                   Score.displayScore();
                    CommonElements.setCorrect();
                    level1Q2.setRoot(Transitions.placeTransitionPane1(level1q2b,Transitions.createTransitionPane()));
                    
                    Transitions.increase.play();
                    level1q2.getChildren().remove(CommonElements.another);

                    level1q2.addRow(5, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    tf1.clear();
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
            Label instruction = new Label("Calculate the distance between two planets. Given the following: \nThe mass of the first planet is: 6x10^24 kg.\nThe mass of the second planet is: 2x10^30 kg.\nThe gravitational force between the planets is: 56N.\nRound your answer to the nearest hundredth.\nGiven the following formula:\n\n\n");
            instruction.setId("instructions");
            ImageView formula = new ImageView("project/formula.png");
            formula.setFitHeight(75);
             formula.setFitWidth(300);
            VBox v = new VBox(10,instruction,formula);
            
            TextField tf = new TextField();
            CommonElements.createButtons();
            GridPane level1q5 = new GridPane();
            BorderPane level1q5b = new BorderPane();
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q5b.setBottom(i);
            level1q5.alignmentProperty().set(Pos.TOP_CENTER);
           //level1q5.setBackground(CommonElements.background);
            level1q5.setVgap(20);
            //level1q5.addRow(0, CommonElements.top);
            level1q5.addRow(1, v);
            level1q5.addRow(2, tf);
            level1q5.addRow(3, CommonElements.submit);
            level1q5.addRow(4, CommonElements.check);
            level1q5.addRow(5, CommonElements.another);
            level1q5b.setCenter(level1q5);
            level1q5b.setBackground(CommonElements.background);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q5b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });

            Scene level1Q5 = new Scene(level1q5b,CommonElements.screenWidth,CommonElements.screenHeight);
            level1Q5.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level1Q5);
            primaryStage.setMaximized(true);
            
            CommonElements.submit.setOnAction(e3 -> {
                if (tf.getText().equals("1.43x10^43") || tf.getText().equals("1.43 x 10^43") || tf.getText().equals("1.43*10^43")||tf.getText().equals("1.43 * 10^43")) {
                     CommonElements.timeline.stop();
                    Score.addScore(50);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level1Q5.setRoot(Transitions.placeTransitionPane1(level1q5b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level1q5.getChildren().remove(CommonElements.another);
                    level1q5.addRow(6, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    tf.clear();
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
            Label instruction = new Label("Arrange the first four planets of the solar system in the correct order.");
            instruction.setId("instructions");
            Text sun = new Text("Sun");
          sun.setId("instructions");

            final Text source3 = new Text(5, 5, "Mercury");
            source3.setId("instructions");
            final Text source4 = new Text(10, 10, "Venus");
            source4.setId("instructions");
            final Text source1 = new Text(15, 15, "Earth");
            source1.setId("instructions");
            final Text source2 = new Text(20, 20, "Mars");
            source2.setId("instructions");
           
             

            HBox sources = new HBox(20,source1, source2, source3, source4);

            final Text target1 = new Text(250, 100, "DROP HERE");
            target1.setId("instructions");
            final Text target2 = new Text(250, 150, "DROP HERE");
            target2.setId("instructions");
            final Text target3 = new Text(250, 200, "DROP HERE");
            target3.setId("instructions");
            final Text target4 = new Text(250, 250, "DROP HERE");
            target4.setId("instructions");
           
            
            
            

            HBox targets = new HBox(35, sun,target1, target2, target3, target4);
            HBox ansandq = new HBox(50, targets);
            CommonElements.createButtons();
            GridPane level1q3 = new GridPane();
            BorderPane level1q3b = new BorderPane();
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q3b.setBottom(i);
           level1q3.alignmentProperty().set(Pos.TOP_CENTER);
            level1q3.setVgap(20);
            //level1q3.setBackground(CommonElements.background);

            //level1q3.addRow(0, CommonElements.top);
            level1q3.addRow(1, instruction);
            level1q3.addRow(2, sources);
            level1q3.addRow(3, ansandq);
            level1q3.addRow(4, CommonElements.submit);
            level1q3.addRow(5, CommonElements.check);
            level1q3.addRow(6, CommonElements.another);
          
            level1q3b.setCenter(level1q3);
            level1q3b.setBackground(CommonElements.background);
            
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q3b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });

            Scene level1Q3 = new Scene(level1q3b,CommonElements.screenWidth,CommonElements.screenHeight);
            level1Q3.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level1Q3);
            primaryStage.setMaximized(true);
            source1.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source1.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source1.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target1
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target1.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target1
                            && event.getDragboard().hasString()) {
                        target1.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target1.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target1.setFill(Color.BLACK);
                    

                    event.consume();
                }
            });

            target1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target1.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            source2.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source2.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source2.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target2
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target2.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target2
                            && event.getDragboard().hasString()) {
                        target2.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target2.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target2.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target2.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            source3.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source3.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source3.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target3
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target3.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target3
                            && event.getDragboard().hasString()) {
                        target3.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target3.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target3.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target3.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });

            source4.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source4.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source4.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target4
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target4.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target4
                            && event.getDragboard().hasString()) {
                        target4.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target4.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    /* mouse moved away, remove the graphical cues */
                    target4.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target4.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            
            CommonElements.submit.setOnAction(e3 -> {
                if (target1.getText().equals("Mercury") && target2.getText().equals("Venus") && target3.getText().equals("Earth") && target4.getText().equals("Mars") ) {
                    CommonElements.timeline.stop();
                    Score.addScore(30);
                    Score.displayScore();
                 level1Q3.setRoot(Transitions.placeTransitionPane1(level1q3b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level1q3.getChildren().remove(CommonElements.another);
                    level1q3.addRow(6, CommonElements.forward);
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
       
//ANSWER: Leo,orion,ursa,cass
         CommonElements.q6.setOnAction(e -> {
            Label instruction = new Label("Match each name to its constellation.");
            instruction.setId("instructions");
            
            ImageView leo = new ImageView("project/leo.png");
            ImageView orion = new ImageView("project/orino.png");
            ImageView ursa = new ImageView("project/usra.png");
            ImageView cass = new ImageView("project/cassiopeia.png");

            HBox symbols = new HBox(30, leo, orion, ursa, cass);

            final Text source1 = new Text(5, 5, "Ursa Major");
            source1.setId("instructions");
            final Text source2 = new Text(10, 10, "Leo Major");
            source2.setId("instructions");
            final Text source3 = new Text(15, 15, "Cassiopeia");
            source3.setId("instructions");
            final Text source4 = new Text(20, 20, "Orion");
            source4.setId("instructions");

            HBox sources = new HBox(80, source1, source2, source3, source4);

            final Text target1 = new Text(250, 100, "DROP HERE");
            target1.setId("instructions");
            final Text target2 = new Text(250, 150, "DROP HERE");
            target2.setId("instructions");
            final Text target3 = new Text(250, 200, "DROP HERE");
            target3.setId("instructions");
            final Text target4 = new Text(250, 250, "DROP HERE");
            target4.setId("instructions");

            HBox targets = new HBox(70, target1, target2, target3, target4);
            VBox ansandq = new VBox(50, symbols, targets);
            CommonElements.createButtons();
            GridPane level1q6 = new GridPane();
            BorderPane level1q6b = new BorderPane();
            //level1q6.setBackground(CommonElements.background);
            ImageView i = new ImageView("project/solar.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
             RotateTransition r0 = new RotateTransition(Duration.millis(2000),i);
             r0.setFromAngle(0);
             r0.setToAngle(360);
             r0.setCycleCount(INDEFINITE);
             r0.setAutoReverse(false);
             r0.play();
             level1q6b.setBottom(i);

            level1q6.alignmentProperty().set(Pos.TOP_CENTER);
            level1q6.setVgap(20);
            //level1q6.addRow(0, CommonElements.top);
            level1q6.addRow(1, instruction);
            level1q6.addRow(2, sources);
            level1q6.addRow(3, ansandq);
            level1q6.addRow(4, CommonElements.submit);
            level1q6.addRow(5, CommonElements.check);
            level1q6.addRow(6, CommonElements.another);
         
            level1q6b.setCenter(level1q6);
            level1q6b.setBackground(CommonElements.background);
            
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level1q6b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level1);
                primaryStage.setMaximized(true);
            });

            Scene level1Q6 = new Scene(level1q6b,CommonElements.screenWidth,CommonElements.screenHeight);
            level1Q6.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level1Q6);
            primaryStage.setMaximized(true);
            source1.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source1.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source1.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target1
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target1.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target1
                            && event.getDragboard().hasString()) {
                        target1.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target1.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target1.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target1.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            source2.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source2.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source2.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target2
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target2.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target2
                            && event.getDragboard().hasString()) {
                        target2.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target2.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target2.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target2.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            source3.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source3.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source3.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target3
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target3.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target3
                            && event.getDragboard().hasString()) {
                        target3.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target3.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    target3.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target3.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });

            source4.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    Dragboard db = source4.startDragAndDrop(TransferMode.ANY);

                    ClipboardContent content = new ClipboardContent();
                    content.putString(source4.getText());
                    db.setContent(content);

                    event.consume();
                }
            });

            target4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target4
                            && event.getDragboard().hasString()) {

                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
            });

            target4.setOnDragEntered(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    if (event.getGestureSource() != target4
                            && event.getDragboard().hasString()) {
                        target4.setFill(Color.RED);
                    }

                    event.consume();
                }
            });

            target4.setOnDragExited(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    /* mouse moved away, remove the graphical cues */
                    target4.setFill(Color.BLACK);

                    event.consume();
                }
            });

            target4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        target4.setText(db.getString());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    event.consume();
                }
            });
            
            CommonElements.submit.setOnAction(e3 -> {
                if (target1.getText().equals("Leo Major") && target2.getText().equals("Orion") && target3.getText().equals("Ursa Major") && target4.getText().equals("Cassiopeia")) {
                    CommonElements.timeline.stop();
                    Score.addScore(60);
                    Score.displayScore();
                 level1Q6.setRoot(Transitions.placeTransitionPane1(level1q6b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level1q6.getChildren().remove(CommonElements.another);
                    level1q6.addRow(6, CommonElements.forward);
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
