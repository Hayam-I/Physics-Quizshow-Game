/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hayam
 */



import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


/**
 *
 * @author hayam
 */
public class StartPage  {
   
    public static Scene scene;

    public static StartPage createStartPage(){
       
        BorderPane grid = new BorderPane();
        ImageView bg = new ImageView("project/start.png");
        ImageView title = new ImageView("project/newTitle2.png");
   
        bg.setFitWidth(CommonElements.screenWidth);
        bg.setFitHeight(CommonElements.screenHeight);
        
        Font font = Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 35);
        
        Menu musicON = new Menu();
        musicON.setStyle("-fx-padding: 5 20 8 0;");
        Label i1 = new Label("Music Settings");
        i1.setFont(font);
        i1.setTextAlignment(TextAlignment.CENTER);
        i1.setTextFill(Color.web("#d5b161"));
        musicON.setGraphic(i1);
       
        i1.setOnMouseClicked(e->{
            if(CommonElements.mp.getStatus().equals(Status.PLAYING)){
                CommonElements.mp.pause();
            }
            else if(!CommonElements.mp.getStatus().equals(Status.PLAYING)){
                 CommonElements.mp.play();
            }
            
             
            
        }); 
  
        
        Menu pp = new Menu();
        pp.setStyle("-fx-padding: 5 20 8 20;");
        Label i2 = new Label("Go to Profile");
        i2.setFont(font);
        i2.setTextAlignment(TextAlignment.CENTER);
        i2.setTextFill(Color.web("#d5b161"));
        pp.setGraphic(i2);
              
     
        i2.setOnMouseClicked(e->{                        
           Launch.switchToProfile();
        });
        
        
        Menu h = new Menu();
        h.setStyle("-fx-padding: 5 20 8 20;");
        Label i3 = new Label("Help");
        i3.setFont(font);
        i3.setTextFill(Color.web("#d5b161"));
        i3.setTextAlignment(TextAlignment.CENTER);
        h.setGraphic(i3);
        
        //BONUS PART, HELP PAGE.
        
        i3.setOnMouseClicked(e->{
           Guide g = new Guide();          
           Launch.mainStage.setScene(g.createGuide());
            
        });
       
        
        Button start = new Button("Start");
        CommonElements.ButtonDesign(start);
        start.setFont(font);
        
        
        
        start.setOnMouseClicked(e->{
            Launch.switchToLevelMap();           
        });
        
        Button scorehistory = new Button("Score History");
        CommonElements.ButtonDesign(scorehistory);
        scorehistory.setFont(font);
        
        scorehistory.setOnMouseClicked(e->{
            ScoreHistory s = new ScoreHistory();          
            Launch.mainStage.setScene(s.createScoreHistory());
            
            
        });
        
        Button exit = new Button("Exit");
        CommonElements.ButtonDesign(exit);
        exit.setFont(font);
        
        exit.setOnMouseClicked(e->{
            Alert alert = new Alert(AlertType.CONFIRMATION); 
            alert.setHeaderText("Careful!");
            alert.setContentText("Are you sure you want to exit?"); 
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                 System.exit(0);
            }
            //alert.show(); 
            
        });
        
        Button logOut = new Button("Log out");
        CommonElements.ButtonDesign(logOut);
        logOut.setFont(font);
        
        RegistrationPage lOut = new RegistrationPage();
        logOut.setOnMouseClicked(e->{
             Alert alert = new Alert(AlertType.CONFIRMATION); 
            
            alert.setContentText("Are you sure you want to log out?"); 
            alert.setHeaderText("Careful!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Launch.mainStage.setScene(lOut.createRegPage().scene);
            }
            //alert.show(); 
           
        });
        
        MenuBar mbar = new MenuBar();
        mbar.getMenus().addAll(musicON,pp,h);
        mbar.setBackground(Background.EMPTY);
        
        
        
        
        VBox vbox = new VBox(25);
        VBox vbox2 = new VBox(300);
        vbox.alignmentProperty().set(Pos.CENTER);
        vbox2.alignmentProperty().set(Pos.CENTER);

        vbox.getChildren().addAll(start,scorehistory,logOut,exit);
        vbox2.getChildren().addAll(title,vbox);
        
        
        
     
       
        
       
       
        
        
    
        
        
        
      
       grid.setTop(mbar);
       grid.setCenter(vbox2);
       StackPane stack = new StackPane(bg,grid);
       scene = new Scene(stack,CommonElements.screenWidth,CommonElements.screenHeight);
       StartPage s = new StartPage();
        s.scene = scene;
        return s;
      
        
    }
    
}

