/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hayam
 */


package project;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;
/**
 *
 * @author layan
 */
public class WelcomePage  {
    
    public static Scene scene;
   public static WelcomePage createWelcomePage() {
        
         
       StackPane stack = new StackPane();
       Pane pane = new Pane();
       
       
       CommonElements.mp.play();
       
       ImageView bg = new ImageView("project/WelcomePageBG.png");
       bg.setFitHeight(CommonElements.screenHeight);
       bg.setFitWidth(CommonElements.screenWidth);
       
       
       ImageView title = new ImageView("project/newTitle.png");
       ImageView catchphrase = new ImageView("project/newcatchpraseWelcome.png");
       ImageView startphrase = new ImageView("project/newStart.png");
       
       title.setX(300);
       title.setY(400);
       title.setFitHeight(380);
       title.setFitWidth(1500);
       
       Path path = new Path();
       path.getElements().addAll(new MoveTo(CommonElements.screenWidth/2,CommonElements.screenHeight),new VLineTo(175));
       pane.getChildren().addAll(title);
       PathTransition pt = new PathTransition(Duration.millis(10000),path,title);
       pt.setCycleCount(1);
       pt.setAutoReverse(false);
       pt.play();
       
       FadeTransition fade = new FadeTransition();
       FadeTransition fade2 = new FadeTransition();
       
       pt.setOnFinished(e->{
       fade.setNode(catchphrase);
       fade.setDuration(Duration.millis(500));
       fade.setCycleCount(1);
       fade.setInterpolator(Interpolator.LINEAR);
       fade.setFromValue(0);
       fade.setToValue(1);
       catchphrase.setX(300);
       catchphrase.setY(630);
       
       
       
       startphrase.setX(700);
       startphrase.setY(700);
       startphrase.setFitHeight(100);
       startphrase.setFitWidth(550);
       
       fade2.setNode(startphrase);
       fade2.setDuration(Duration.millis(500));
       fade2.setCycleCount(1);
       fade2.setInterpolator(Interpolator.LINEAR);
       fade2.setFromValue(0);
       fade2.setToValue(1);
       catchphrase.setX(300);
       catchphrase.setY(630);
       
       fade.play();
       fade2.play();
       pane.getChildren().addAll(catchphrase,startphrase);
       });
       
       
           
       
      
       stack.getChildren().addAll(bg,pane);
       
        scene = new Scene(stack,CommonElements.screenWidth,CommonElements.screenHeight);
       
       
        
        stack.setOnMouseClicked((MouseEvent e)->{
          Launch.switchToRegPage();
            
        });
        
        WelcomePage w = new WelcomePage();
        w.scene = scene;
        return w;
       
        
    }

   
}

