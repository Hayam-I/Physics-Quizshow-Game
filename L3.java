/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
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
 * @author SIWAR & RAHAF
 */
public class L3 extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public BorderPane level3Board = CommonElements.buildBoard();
    public Scene level3 = new Scene(level3Board,CommonElements.screenWidth,CommonElements.screenHeight);

    

    //could be useful in switching between scenes?
    public void switchToLevel3(Stage stage) {
        stage.setScene(level3);
        start(stage);
    }

    @Override
    public void start(Stage primaryStage) {
     Score.currentLevel = 3;
        level3.getStylesheets().add("project/Design.css");
        primaryStage.setScene(level3);
        primaryStage.show();
        primaryStage.setMaximized(true);

        //answer is ch 1,2,4
        CommonElements.q1.setOnAction(e -> {
           Text instruction = new Text("Optics is the study of the wave properties of light. What are the 3 categories in which wave properties are grouped into?");
           instruction.setId("instructions");
           TextField tf1 = new TextField();
           TextField tf2 = new TextField();
           TextField tf3 = new TextField();
           tf1.setId("instructions");
           tf2.setId("instructions");
           tf3.setId("instructions");
           
           VBox ta = new VBox(10,tf1,tf2,tf3);

            CommonElements.createButtons();
           
            GridPane level3q1 = new GridPane();
            BorderPane level3q1b = new BorderPane();
            ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q1b.setBottom(i);
            level3q1.alignmentProperty().set(Pos.TOP_CENTER);
            level3q1.setVgap(20);
            //level3q1.addRow(0, CommonElements.top);
            level3q1.addRow(1, instruction);
            level3q1.addRow(2, ta);
            level3q1.addRow(3, CommonElements.submit);
            level3q1.addRow(4, CommonElements.check);
            level3q1.addRow(5, CommonElements.another);
    
            level3q1b.setCenter(level3q1);
            level3q1b.setBackground(CommonElements.background3);
            VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q1b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q1 = new Scene(level3q1b, CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q1.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q1);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (tf1.getText().equalsIgnoreCase("interference") && tf2.getText().equalsIgnoreCase("diffraction") && tf3.getText().equalsIgnoreCase("polarization")) {
                    CommonElements.timeline.stop();
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);

                }
                else if (tf1.getText().equalsIgnoreCase("diffraction") && tf2.getText().equalsIgnoreCase("interface") && tf3.getText().equalsIgnoreCase("polarization")){
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);
                }
                
                else if (tf1.getText().equalsIgnoreCase("diffraction") && tf2.getText().equalsIgnoreCase("polarization") && tf3.getText().equalsIgnoreCase("interface")){
                     Score.addScore(10);
                    
                     Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);
                }
                else if (tf1.getText().equalsIgnoreCase("interface") && tf2.getText().equalsIgnoreCase("polarization") && tf3.getText().equalsIgnoreCase("diffraction")){
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);
                }
                else if (tf1.getText().equalsIgnoreCase("polarization") && tf2.getText().equalsIgnoreCase("interface") && tf3.getText().equalsIgnoreCase("diffraction")){
                    Score.addScore(10);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);
                }
                 else if (tf1.getText().equalsIgnoreCase("polarization") && tf2.getText().equalsIgnoreCase("diffraction") && tf3.getText().equalsIgnoreCase("interface")){
                     Score.addScore(10);
                     Score.displayScore();
                    CommonElements.setCorrect();
                    
                    level3q1.getChildren().remove(CommonElements.another);
                    level3q1.addRow(5, CommonElements.forward);
                    level3Q1.setRoot(Transitions.placeTransitionPane3(level3q1b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    Score.endLevel(primaryStage);
                 }

                else {
                   tf1.clear();
                   tf2.clear();
                   tf3.clear();
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
        Text instruction = new Text("What is the correct name for each symbol in the following formula: n=c/v");
        instruction.setId("instructions");
        ComboBox <String> cb = new ComboBox();
        cb.getItems().addAll("Speed of light in vacuum","Speed of light in a medium","Index of refraction");
        ComboBox <String> cb2 = new ComboBox();
        cb2.getItems().addAll("Speed of light in vacuum","Speed of light in a medium","Index of refraction");
        ComboBox <String> cb3 = new ComboBox();
        cb3.getItems().addAll("Speed of light in vacuum","Speed of light in a medium","Index of refraction");
        Label label1 = new Label("  n: ");
        Label label2 = new Label("  c: ");
        Label label3 = new Label("  v: ");
        label1.setId("instructions");
        label2.setId("instructions");
        label3.setId("instructions");
        cb.setId("instructions");
        cb2.setId("instructions");
        cb3.setId("instructions");
        HBox h1 = new HBox(label1,cb);
        HBox h2 = new HBox(label2,cb2);
        HBox h3 = new HBox(label3,cb3);
        VBox v1 = new VBox(h1,h2,h3);


            CommonElements.createButtons();
            GridPane level3q2 = new GridPane();
            BorderPane level3q2b = new BorderPane();
            ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q2b.setBottom(i);
            level3q2.alignmentProperty().set(Pos.TOP_CENTER);
            level3q2.setVgap(20);
            //level3q2.addRow(0, CommonElements.top);
            level3q2.addRow(1, instruction);
            level3q2.addRow(2, v1);
            level3q2.addRow(3, CommonElements.submit);
            level3q2.addRow(4, CommonElements.check);
            level3q2.addRow(5, CommonElements.another);
 
            level3q2b.setCenter(level3q2);
            level3q2b.setBackground(CommonElements.background3);
           VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q2b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q2 = new Scene(level3q2b,CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q2.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q2);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (cb.getValue().equals("Index of refraction")&&cb2.getValue().equals("Speed of light in vacuum") &&cb3.getValue().equals("Speed of light in a medium")) {
                    CommonElements.timeline.stop();
                    Score.addScore(20);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level3Q2.setRoot(Transitions.placeTransitionPane3(level3q2b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level3q2.getChildren().remove(CommonElements.another);
                    level3q2.addRow(5, CommonElements.forward);
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
            Label instruction = new Label("Calculate the index of refraction for a medium in which the speed of light is 2.012x103 m/s.\nThe formula is: n=c/v where c=3x10^8.");
            
            instruction.setId("instructions");
            RadioButton c1 = new RadioButton("n=1.20");
             c1.setId("instructions");

             RadioButton c2= new RadioButton("n=1.49");
             c2.setId("instructions");

            RadioButton c3 = new RadioButton("n=1.39");
             c3.setId("instructions");

            RadioButton c4 = new RadioButton("n=1.15");
            c4.setId("instructions");
            ToggleGroup tg1=new ToggleGroup();
            c1.setToggleGroup(tg1);
            c2.setToggleGroup(tg1);
            c3.setToggleGroup(tg1);
            c4.setToggleGroup(tg1);
            CommonElements.createButtons();
            
            VBox options = new VBox(10,c1,c2,c3,c4);

            GridPane level3q4 = new GridPane();
            BorderPane level3q4b = new BorderPane();
            ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q4b.setBottom(i);
            level3q4.alignmentProperty().set(Pos.TOP_CENTER);
            level3q4.setVgap(20);
            //level3q4.add(CommonElements.top,0,0);
            level3q4.add(instruction,0,1);
            level3q4.add(options,0,2);
            level3q4.add( CommonElements.submit,0,3);
            level3q4.add( CommonElements.check,0,4);
            level3q4.add( CommonElements.another,0,5);

            level3q4b.setCenter(level3q4);
            level3q4b.setBackground(CommonElements.background3);
               VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q4b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q4 = new Scene(level3q4b,CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q4.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q4);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (c2.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(40);
                    Score.displayScore();
                    CommonElements.setCorrect();
                    level3Q4.setRoot(Transitions.placeTransitionPane3(level3q4b,Transitions.createTransitionPane()));
                    
                    Transitions.increase.play();
                    level3q4.getChildren().remove(CommonElements.another);

                    level3q4.addRow(5, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    c1.setSelected(false);
                     c2.setSelected(false);
                      c3.setSelected(false);
                       c4.setSelected(false);
                    CommonElements.setIncorrect();
                    Lives.updateLives();
                            if(Lives.lives==0) {
                                primaryStage.setScene(Transitions.createGameOver());
                               Transitions.startOverAction();
                            }
                    
                }

            });

        });
//ans: false false false true
        CommonElements.q3.setOnAction(e -> {
        final Text source1 = new Text("True");
        final Text source2 = new Text("False");
        final Text source3 = new Text("False");
        final Text source4 = new Text("False");

        final Text target1 = new Text("Drop here");
        final Text target2 = new Text("Drop Here");
        final Text target3 = new Text("Drop Here");
        final Text target4 = new Text("Drop here");

        
         HBox sources = new HBox(90);
         sources.getChildren().addAll(source1, source2, source3, source4);
       
         HBox targets = new HBox(160, target1, target2, target3, target4);
         
         
         ImageView i1 = new ImageView("project/correctAnswer.png");
         ImageView i2 = new ImageView("project/option1.png");
         ImageView i3 = new ImageView("project/option2.png");
         ImageView i4 = new ImageView("project/option3.png");
         
         HBox images = new HBox(30,i3,i4,i2,i1);
         

         
         Label quest1 = new Label("In a vacuum,  a beam of light was directed onto the material at a 30 degree angle from the normal.");
         Label l1 = new Label("Select and drag True or False to assign the correct diagram to the optical description below: ");
         Label l2 = new Label("(blue arrow = light refraction)");
         l2.setTextFill(Color.BLUE);
               
         quest1.setId("instructions");
         l1.setId("instructions");
         l2.setId("instructions");
         
         VBox labels = new VBox();
         labels.getChildren().addAll(quest1,l1,l2);
         
        source1.setId("instructions");
        source2.setId("instructions");
        source3.setId("instructions");
        source4.setId("instructions");
        target1.setId("instructions");
        target2.setId("instructions");
        target3.setId("instructions");
        target4.setId("instructions");
         
         //VBox targets = new VBox(35, target1, target2, target3, target4);
        //VBox symbols = new VBox(30,i1,i2,i3,i4);
         VBox ansandq = new VBox(50, images, targets);
         CommonElements.createButtons();
        GridPane level3q3 = new GridPane();
        BorderPane level3q3b = new BorderPane();
        ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(200);
            i.setFitWidth(200);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q3b.setBottom(i);
        level3q3.alignmentProperty().set(Pos.TOP_CENTER);
        level3q3.setVgap(20);
        //level3q3.addRow(0, CommonElements.top);
        level3q3.addRow(1, labels);
        level3q3.addRow(2, sources);
        level3q3.addRow(3, ansandq);
        level3q3.addRow(4, CommonElements.submit);
        level3q3.addRow(5, CommonElements.check);
        level3q3.addRow(6, CommonElements.another);
        level3q3.setHgap(20);
        level3q3.setVgap(20);

        level3q3b.setCenter(level3q3);
        level3q3b.setBackground(CommonElements.background3);
        level3q3.setAlignment(Pos.CENTER);
         VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q3b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q3 = new Scene(level3q3b,CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q3.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q3);
            primaryStage.setMaximized(true);
         

        source1.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
              
               
                
            
                Dragboard db = source1.startDragAndDrop(TransferMode.ANY);
                
               
                ClipboardContent content = new ClipboardContent();
                content.putString(source1.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        target1.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
            
               
              
                if (event.getGestureSource() != target1 &&
                        event.getDragboard().hasString()) {
                    
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });

        target1.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
               
                
                if (event.getGestureSource() != target1 &&
                        event.getDragboard().hasString()) {
                    target1.setFill(Color.BLUE);
                }
                
                event.consume();
            }
        });

        target1.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
         
                target1.setFill(Color.GRAY);
                
                event.consume();
            }
        });
        
        target1.setOnDragDropped(new EventHandler <DragEvent>() {
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

         source2.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
               
               
                
               
                Dragboard db = source2.startDragAndDrop(TransferMode.ANY);
                
            
                ClipboardContent content = new ClipboardContent();
                content.putString(source2.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        target2.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
          
              
             
                if (event.getGestureSource() != target2 &&
                        event.getDragboard().hasString()) {
                    
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });

        target2.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
           
               
              
                if (event.getGestureSource() != target2 &&
                        event.getDragboard().hasString()) {
                    target2.setFill(Color.BLUE);
                }
                
                event.consume();
            }
        });

        target2.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                target2.setFill(Color.GRAY);
                
                event.consume();
            }
        });
        
        target2.setOnDragDropped(new EventHandler <DragEvent>() {
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
        

        source3.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
              
                Dragboard db = source3.startDragAndDrop(TransferMode.ANY);
                
            
                ClipboardContent content = new ClipboardContent();
                content.putString(source3.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        target3.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
            
                
                
               
                if (event.getGestureSource() != target3 &&
                        event.getDragboard().hasString()) {
                  
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });

        target3.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
              
              
               
                if (event.getGestureSource() != target3 &&
                        event.getDragboard().hasString()) {
                    target3.setFill(Color.BLUE);
                }
                
                event.consume();
            }
        });

        target3.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
             
                target3.setFill(Color.GRAY);
                
                event.consume();
            }
        });
        
        target3.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                
                Dragboard db = event.getDragboard();
                boolean success = false;
                if ( db.hasString()) {
                    target3.setText(db.getString());
                    success = true;
                }
                
                event.setDropCompleted(success);
                
                event.consume();
            }
        });


        source4.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                
              
                
                
                Dragboard db = source4.startDragAndDrop(TransferMode.ANY);
                
                
                ClipboardContent content = new ClipboardContent();
                content.putString(source4.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

        target4.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
               
               
                
            
                if (event.getGestureSource() != target4 &&
                        event.getDragboard().hasString()) {
                    
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });

        target4.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                
               
               
                if (event.getGestureSource() != target4 &&
                        event.getDragboard().hasString()) {
                    target4.setFill(Color.BLUE);
                }
                
                event.consume();
            }
        });

        target4.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                
                target4.setFill(Color.GRAY);
                
                event.consume();
            }
        });
        
        target4.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
              
                
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
                if (target1.getText().equals("False") && target2.getText().equals("False") && target3.getText().equals("False") && target4.getText().equals("True")) {
                    CommonElements.timeline.stop();
                    Score.addScore(30);
                    Score.displayScore();
                 level3Q3.setRoot(Transitions.placeTransitionPane3(level3q3b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level3q3.getChildren().remove(CommonElements.another);
                    level3q3.addRow(6, CommonElements.forward);
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
//correct answer are 1 & 4
        CommonElements.q5.setOnAction(e -> {
            Text instruction =new Text("Snell’s Law concept (Select all that may apply).");
        instruction.setId("instructions");
        CheckBox cb1=new CheckBox (" n1/n2 = sin α2/sin α1");
        CheckBox cb2=new CheckBox ("n=c/v");
        CheckBox cb3=new CheckBox ("A measure of the extent to which a substance slows down light waves passing through it.");
        CheckBox cb4=new CheckBox ("Because the ratio n1/n2 is a constant for any given wavelength of light,\nthe ratio of the two sines is also a constant for any angle. ");
        cb1.setId("instructions");
        cb2.setId("instructions");
        cb3.setId("instructions");
        cb4.setId("instructions");
        VBox v = new VBox(10,cb1,cb2,cb3,cb4);
            CommonElements.createButtons();
            GridPane level3q5 = new GridPane();
            BorderPane level3q5b = new BorderPane();
            ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q5b.setBottom(i);
            level3q5.alignmentProperty().set(Pos.TOP_CENTER);
            level3q5.setVgap(20);
            //level3q5.addRow(0, CommonElements.top);
            level3q5.addRow(1, instruction);
            level3q5.addRow(2, v);
            level3q5.addRow(3, CommonElements.submit);
            level3q5.addRow(4, CommonElements.check);
            level3q5.addRow(5, CommonElements.another);
            
            level3q5b.setCenter(level3q5);
            level3q5b.setBackground(CommonElements.background3);
               VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q5b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q5 = new Scene(level3q5b,CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q5.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q5);
            primaryStage.setMaximized(true);
            
            CommonElements.submit.setOnAction(e3 -> {
                if (cb1.isSelected() && cb4.isSelected()) {
                    CommonElements.timeline.stop();
                    Score.addScore(50);
                    Score.displayScore();
                 level3Q5.setRoot(Transitions.placeTransitionPane3(level3q5b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    CommonElements.setCorrect();
                    level3q5.getChildren().remove(CommonElements.another);
                    level3q5.addRow(6, CommonElements.forward);
                    Score.endLevel(primaryStage);

                } else {
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
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
            Label instruction = new Label("A new material has been discovered! \nWhat is the refractive index when light passes through it at 2x10^7 m/s? \nMake sure your answer is between a 0.1 difference range.");
            instruction.setId("instructions");
             Slider sl = new Slider(); 
             sl.setShowTickLabels(true); 
             sl.setShowTickMarks(true);
             sl.setMin(10);
             sl.setMax(15);
             sl.setMajorTickUnit(1);
             sl.setBlockIncrement(0.1);
             sl.setId("instructions");
             sl.setOrientation(Orientation.HORIZONTAL);
            TextField tf = new TextField();
            tf.setId("instructions");
            sl.valueProperty().addListener( e1 ->{
            double a = sl.getValue();
            boolean b;
            if(a>14 && a<15){
                 b = true;
            }
            else{
                b=false;
            }
            tf.setText(Double.toString(a));
        });
           VBox flow = new VBox(sl, tf);
            CommonElements.createButtons();
            
            GridPane level3q6 = new GridPane();
            BorderPane level3q6b = new BorderPane();
            ImageView i = new ImageView("project/glass.png");
            i.setFitHeight(300);
            i.setFitWidth(300);
            FadeTransition f1 = new FadeTransition(Duration.millis(1000),i);
            f1.setFromValue(0.2);
            f1.setToValue(1.0);
            f1.setCycleCount(INDEFINITE);
            f1.setAutoReverse(true);
            f1.play();
            level3q6b.setBottom(i);
            level3q6.alignmentProperty().set(Pos.TOP_CENTER);
            level3q6.setVgap(20);
            //level3q6.addRow(0, CommonElements.top);
            level3q6.addRow(1, instruction);
            level3q6.addRow(2,flow );
            level3q6.addRow(3, CommonElements.submit);
            level3q6.addRow(4, CommonElements.check);
            level3q6.addRow(5, CommonElements.another);
 
            level3q6b.setCenter(level3q6);
            level3q6b.setBackground(CommonElements.background3);
              VBox timer = new VBox(createTimerLabel());
            top.getChildren().add(timer);
            level3q6b.setTop(top);
            
            CommonElements.forward.setOnAction(e1 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });
            CommonElements.another.setOnAction(e2 -> {
                top.getChildren().remove(timer);
                CommonElements.borderpane.setTop(CommonElements.top);
                primaryStage.setScene(level3);
                primaryStage.setMaximized(true);
            });

            Scene level3Q6 = new Scene(level3q6b,CommonElements.screenWidth,CommonElements.screenHeight);
            level3Q6.getStylesheets().add("project/Design.css");
            primaryStage.setScene(level3Q6);
            primaryStage.setMaximized(true);
            CommonElements.submit.setOnAction(e3 -> {
                if (tf.getText().compareTo("14.5")>=0 &&tf.getText().compareTo("14.6")<0) {
                    CommonElements.timeline.stop();
                    Score.addScore(60);
                    Score.displayScore();
                    CommonElements.setCorrect();
                 level3Q6.setRoot(Transitions.placeTransitionPane3(level3q6b,Transitions.createTransitionPane()));
                    Transitions.increase.play();
                    level3q6.getChildren().remove(CommonElements.another);

                    level3q6.addRow(7, CommonElements.forward);
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

    }

   
}
