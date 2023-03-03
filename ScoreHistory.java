/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author hayam
 */
public class ScoreHistory{
    
      public static Scene historyScene;       
      
    public static Scene createScoreHistory( ) {
        
      
        Font font = Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 35);
        VBox root = new VBox();
        
        if(!CommonElements.scoreshistory.isEmpty()){
       
       
        Label l = new Label("Highest Score");
        l.setFont(font);
        l.setTextFill(Color.web("#04215b"));       
        Integer max = Collections.max(CommonElements.scoreshistory);
        Label l2 = new Label();
        l2.setText(max.toString());
        l2.setFont(font);
        l2.setTextFill(Color.web("#04215b"));
         Label l3 = new Label("Previous Scores:");        
        l3.setFont(font);
        l3.setTextFill(Color.web("#04215b"));
         Button go = new Button("Go to Profile");
        root.getChildren().addAll(l,l2,l3);
        for(int i=0; i<CommonElements.scoreshistory.size();i++){
               Label l4 = new Label();
               l4.setText(CommonElements.scoreshistory.get(i).toString());
               l4.setFont(font);
               l4.setTextFill(Color.web("#04215b"));
               root.getChildren().add(l4);
               
           }
        
       
        go.setFont(font);
        go.setTextFill(Color.web("#04215b"));
        CommonElements.ButtonDesign(go);
         go.setOnAction(e->{
                  Launch.switchToProfile();
              });
         root.getChildren().addAll(go);
         
        }
        
         if(CommonElements.scoreshistory.isEmpty()){
             Label l = new Label("No scorers to show!");
             Button l2 = new Button("Play the game to see your history!");
              l.setFont(font);
              l.setTextFill(Color.web("#04215b"));
              l2.setFont(font);
              l2.setTextFill(Color.web("#04215b"));
              CommonElements.ButtonDesign(l2);
              
              l2.setOnAction(e->{
                  Launch.switchToStartPage();
              });
              
             root.getChildren().addAll(l,l2);
         }
        
       
       
        root.setAlignment(Pos.CENTER);
        root.setBackground(CommonElements.background);
         historyScene = new Scene(root,CommonElements.screenWidth,CommonElements.screenHeight);
        
        return historyScene;
    }
    
     //BONUS PART, USING I/O STREAM TO SAVE SCORE HISTORY.    
    public void fileHistory() throws FileNotFoundException{
           
      FileOutputStream out = new FileOutputStream("ScoreHistory.txt");  
      PrintWriter pw = new PrintWriter(out); 
      pw.println(CommonElements.FileScoreHistory); 
      pw.close();
      
    }

    
   
    
    
}
