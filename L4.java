/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
 * @author LEEN
 */
public class L4 extends Application {

    public BorderPane level4Board = CommonElements.buildBoard();
    public Scene level4 = new Scene(level4Board,CommonElements.screenWidth,CommonElements.screenHeight);
    
    public static void main(String[] args){
        launch(args);
    }

    


    @Override
    public void start(Stage primaryStage) {
        Score.currentLevel = 4;
        level4.getStylesheets().add("project/Design.css");
        primaryStage.setScene(level4);
        primaryStage.show();
        primaryStage.setMaximized(true);

        CommonElements.q1.setOnAction(e -> {
            Text p1 = new Text("Like charges ");
            p1.setId("instructions");

            TextField repel = new TextField();
            Text p2 = new Text("and opposite charges");
             p2.setId("instructions");

            TextField attract = new TextField();
            FlowPane flow = new FlowPane(p1, repel, p2, attract);

            Label instruction = new Label("Fill in the blanks with the correct answer \nMake sure to type the answer in lowercase and without any spaces.");
             instruction.setId("instructions");

            CommonElements.createButtons();
            
            GridPane level4q1 = new GridPane();
            BorderPane level4q1b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q1b.setBottom(i);
            level4q1.alignmentProperty().set(Pos.TOP_CENTER);
            level4q1.setVgap(20);
            //level4q1.addRow(0, CommonElements.top);
            level4q1.addRow(1, instruction);
            level4q1.addRow(2, flow);
            level4q1.addRow(3, CommonElements.submit);
            level4q1.addRow(4, CommonElements.check);
            level4q1.addRow(5, CommonElements.another);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q1b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            level4q1b.setCenter(level4q1);
            level4q1b.setBackground(CommonElements.background4);
            
            Scene level4Q1 = new Scene(level4q1b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q1.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q1);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (repel.getText().equals("repel") && attract.getText().equals("attract")) {
                    CommonElements.timeline.stop();
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level4q1.getChildren().remove(CommonElements.another);
                    level4q1.addRow(5, CommonElements.forward);
                    level4Q1.setRoot(Transitions.placeTransitionPane4(level4q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
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

        CommonElements.q2.setOnAction(e -> {

            Label instruction = new Label("Which of the following materials is a conductor?");
            instruction.setId("instructions");
            ComboBox<String> cb = new ComboBox<String>();

            String[] x = {"Rubber", "Copper", "Wool", "Plastic"};
            cb.setValue("Rubber");
            cb.getItems().addAll(x);
            cb.setId("instructions");

            CommonElements.createButtons();
            GridPane level4q2 = new GridPane();
            BorderPane level4q2b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q2b.setBottom(i);
            level4q2.alignmentProperty().set(Pos.TOP_CENTER);
            level4q2.setVgap(20);
            //level4q2.addRow(0, CommonElements.top);
            level4q2.addRow(1, instruction);
            level4q2.addRow(2, cb);
            level4q2.addRow(3, CommonElements.submit);
            level4q2.addRow(4, CommonElements.check);
            level4q2.addRow(5, CommonElements.another);
         
            level4q2b.setCenter(level4q2);
            level4q2b.setBackground(CommonElements.background4);

           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q2b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });

            Scene level4Q2 = new Scene(level4q2b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q2.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q2);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (cb.getValue().equals("Copper")) {
                    CommonElements.timeline.stop();
                    Score.addScore(20);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level4Q2.setRoot(Transitions.placeTransitionPane4(level4q2b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level4q2.getChildren().remove(CommonElements.another);
                    level4q2.addRow(5, CommonElements.forward);
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

        CommonElements.q3.setOnAction(e -> {
            Label instruction = new Label("Which of the following is an arrangment of a circuit? Select all that apply.");
            
             instruction.setId("instructions");
            CheckBox c1 = new CheckBox("A. Series");
             c1.setId("instructions");

            CheckBox c2 = new CheckBox("B. Rectangular");
             c2.setId("instructions");

            CheckBox c3 = new CheckBox("C. Parallel");
             c3.setId("instructions");

            CheckBox c4 = new CheckBox("D.  Perpendicular");
            c4.setId("instructions");
            CommonElements.createButtons();
            
            VBox options = new VBox(10,c1,c2,c3,c4);

            GridPane level4q3 = new GridPane();
            BorderPane level4q3b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q3b.setBottom(i);
            level4q3.alignmentProperty().set(Pos.TOP_CENTER);
            level4q3.setVgap(20);
            //level4q3.add(CommonElements.top,0,0);
            level4q3.add(instruction,0,1);
            level4q3.add(options,0,2);
            level4q3.add( CommonElements.submit,0,3);
            level4q3.add( CommonElements.check,0,4);
            level4q3.add( CommonElements.another,0,5);

            level4q3b.setCenter(level4q3);
            level4q3b.setBackground(CommonElements.background4);

            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q3b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });

            Scene level4Q3 = new Scene(level4q3b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q3.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q3);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (c1.isSelected() && c3.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(30);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level4Q3.setRoot(Transitions.placeTransitionPane4(level4q3b,Transitions.createTransitionPane()));
                    
                    Transitions.increase.play();
                    level4q3.getChildren().remove(CommonElements.another);

                    level4q3.addRow(5, CommonElements.forward);
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
            Label instruction = new Label("Label the following graphs as either ohmic or non-ohmic.");
             instruction.setId("instructions");
            ImageView ohmic = new ImageView("project/ohmic.png");
            ohmic.setFitWidth(200);
            ohmic.setFitHeight(200);
            ImageView nonohmic = new ImageView("project/nonohmic.png");
            nonohmic.setFitWidth(200);
            nonohmic.setFitHeight(200);
            HBox graphs = new HBox(100, ohmic, nonohmic);
            graphs.setPadding(new Insets(10, 10, 10, 10));

            TextField ans1 = new TextField();
            TextField ans2 = new TextField();
            HBox answers = new HBox(140, ans1, ans2);
            answers.setPadding(new Insets(10, 10, 10, 10));
            CommonElements.createButtons();
            GridPane level4q4 = new GridPane();
            BorderPane level4q4b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q4b.setBottom(i);
            level4q4.alignmentProperty().set(Pos.TOP_CENTER);
            level4q4.setVgap(20);
            //level4q4.addRow(0, CommonElements.top);
            level4q4.addRow(1, instruction);
            level4q4.addRow(2, graphs);
            level4q4.addRow(3, answers);
            level4q4.addRow(4, CommonElements.submit);
            level4q4.addRow(5, CommonElements.check);
            level4q4.addRow(6, CommonElements.another);
   
            level4q4b.setCenter(level4q4);
            level4q4b.setBackground(CommonElements.background4);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q4b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });

            Scene level4Q4 = new Scene(level4q4b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q4.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q4);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (ans1.getText().equalsIgnoreCase("ohmic") && ans2.getText().equalsIgnoreCase("non-ohmic")) {
                    CommonElements.timeline.stop();
                    Score.addScore(40);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level4Q4.setRoot(Transitions.placeTransitionPane4(level4q4b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level4q4.getChildren().remove(CommonElements.another);
                    level4q4.addRow(6, CommonElements.forward);
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

        CommonElements.q5.setOnAction(e -> {
            Label instruction = new Label("Match each circuit components to its correct symbol.");
            instruction.setId("instructions");
            ImageView capacitor = new ImageView("project/capacitor.png");
            ImageView diode = new ImageView("project/diode.png");
            ImageView inductor = new ImageView("project/inductor.png");
            ImageView resistor = new ImageView("project/resistor.png");

            VBox symbols = new VBox(30, diode, resistor, inductor, capacitor);

            final Text source1 = new Text(5, 5, "CAPACITOR");
            source1.setId("instructions");
            final Text source2 = new Text(10, 10, "DIODE");
            source2.setId("instructions");
            final Text source3 = new Text(15, 15, "INDUCTOR");
            source3.setId("instructions");
            final Text source4 = new Text(20, 20, "RESISTOR");
            source4.setId("instructions");

            HBox sources = new HBox(20, source1, source2, source3, source4);

            final Text target1 = new Text(250, 100, "DROP HERE");
            target1.setId("instructions");
            final Text target2 = new Text(250, 150, "DROP HERE");
            target2.setId("instructions");
            final Text target3 = new Text(250, 200, "DROP HERE");
            target3.setId("instructions");
            final Text target4 = new Text(250, 250, "DROP HERE");
            target4.setId("instructions");

            VBox targets = new VBox(35, target1, target2, target3, target4);
            HBox ansandq = new HBox(50, symbols, targets);
            CommonElements.createButtons();
            GridPane level4q5 = new GridPane();
            BorderPane level4q5b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q5b.setBottom(i);
            level4q5.alignmentProperty().set(Pos.TOP_CENTER);
            level4q5.setVgap(20);
            //level4q5.addRow(0, CommonElements.top);
            level4q5.addRow(1, instruction);
            level4q5.addRow(2, sources);
            level4q5.addRow(3, ansandq);
            level4q5.addRow(4, CommonElements.submit);
            level4q5.addRow(5, CommonElements.check);
            level4q5.addRow(6, CommonElements.another);
      
            level4q5b.setCenter(level4q5);
            level4q5b.setBackground(CommonElements.background4);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q5b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });

            Scene level4Q5 = new Scene(level4q5b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q5.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q5);
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
                if (target1.getText().equals("DIODE") && target2.getText().equals("RESISTOR") && target3.getText().equals("INDUCTOR") && target4.getText().equals("CAPACITOR")) {
                    CommonElements.timeline.stop();
                    Score.addScore(50);
                    Score.displayScore();
                 level4Q5.setRoot(Transitions.placeTransitionPane4(level4q5b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level4q5.getChildren().remove(CommonElements.another);
                    level4q5.addRow(6, CommonElements.forward);

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

        CommonElements.q6.setOnAction(e -> {
            Label instruction = new Label("Unscramble the following letters to find the three basic electric quantities \n Make sure to type your answer in all lowercase and without any spaces!");
            instruction.setId("instructions");
            Label scramble1 = new Label("g e l v t a o");
            scramble1.setId("instructions");

            TextField ans1 = new TextField("");
            ans1.setPrefSize(50, 50);

            Label scramble2 = new Label("u t r e n r c");
            scramble2.setId("instructions");

            TextField ans2 = new TextField("");
            ans2.setPrefSize(50, 50);

            Label scramble3 = new Label("e s t e s r c a i n");
            scramble3.setId("instructions");

            TextField ans3 = new TextField("");
            ans3.setPrefSize(50, 50);

            VBox word1 = new VBox(20, scramble1, ans1);
            VBox word2 = new VBox(20, scramble2, ans2);
            VBox word3 = new VBox(20, scramble3, ans3);

            CommonElements.createButtons();
            GridPane level4q6 = new GridPane();
            BorderPane level4q6b = new BorderPane();
            ImageView i = new ImageView("project/lightning.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level4q6b.setBottom(i);
            level4q6.alignmentProperty().set(Pos.TOP_CENTER);
            level4q6.setVgap(20);
            //level4q6.addRow(0, CommonElements.top);
            level4q6.addRow(1, instruction);
            level4q6.addRow(2, word1);
            level4q6.addRow(3, word2);
            level4q6.addRow(4, word3);
            level4q6.addRow(5, CommonElements.submit);
            level4q6.addRow(6, CommonElements.check);
            level4q6.addRow(7, CommonElements.another);
       
            level4q6b.setCenter(level4q6);
            level4q6b.setBackground(CommonElements.background4);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level4q6b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level4);
                primaryStage.setMaximized(true);
            });
            Scene level4Q6 = new Scene(level4q6b,CommonElements.screenWidth,CommonElements.screenHeight);
            level4Q6.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level4Q6);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (ans1.getText().equalsIgnoreCase("voltage") && ans2.getText().equalsIgnoreCase("current") && ans3.getText().equalsIgnoreCase("resistance")) {
                    CommonElements.timeline.stop();
                    Score.addScore(60);
                    Score.displayScore();
                    CommonElements.setCorrect();
                 level4Q6.setRoot(Transitions.placeTransitionPane4(level4q6b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level4q6.getChildren().remove(CommonElements.another);

                    level4q6.addRow(7, CommonElements.forward);
                    Score.endLevel(primaryStage);
                    

                } else {
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                     if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                                primaryStage.setMaximized(true);
                               Transitions.startOverAction();
                            }
                }

            });

        });

    }

  

}
