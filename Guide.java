//BONUS HELP PAGE
package project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Guide {
    public static Scene guide;
    public static int counter=1;     
      
    public Scene createGuide() {
         
       
        Font font = Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 35);
        Font font1 = Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 30);
        VBox root = new VBox();
        root.alignmentProperty().set(Pos.CENTER);
        root.setBackground(CommonElements.background2);
        BorderPane border = new BorderPane();
        BorderPane.setAlignment(root, Pos.CENTER);
       
        
        Label l1 = new Label("You have three chances to get through each level!");
        l1.setFont(font);       
        Button next = new Button("Next");
        next.setFont(font1);
        next.setPrefSize(100, 75);
        CommonElements.ButtonDesign2(next);
       
        
        
        
        ImageView i1 = new ImageView("project/pic1_0.png");
        ImageView i2 = new ImageView("project/pic1_1.png");       
        ImageView i3 = new ImageView("project/pic1_2.png");
        ImageView i4 = new ImageView("project/pic1_3.png");
        ImageView i5 = new ImageView("project/pic2.png");
        Media m1 = new Media("file:///C://Users//hayam//OneDrive//Documents//NetBeansProjects//Golden_Quest//src//project//pic3.mp4");
        MediaPlayer mp1 = new MediaPlayer(m1);
        MediaView mv1 = new MediaView(mp1);
        Media m2 = new Media("file:///C://Users//hayam//OneDrive//Documents//NetBeansProjects//Golden_Quest//src//project//pic4.mp4");
        MediaPlayer mp2 = new MediaPlayer(m2);
        MediaView mv2 = new MediaView(mp2);
        ImageView i6 = new ImageView("project/pic5.png");
        ImageView i7 = new ImageView("project/pic6.png");
        Media m3 = new Media("file:///C://Users//hayam//OneDrive//Documents//NetBeansProjects//Golden_Quest//src//project//pic7.mp4");
        MediaPlayer mp3 = new MediaPlayer(m3);
        MediaView mv3 = new MediaView(mp3);
        
        
        root.getChildren().add(i1);
           
        next.setOnAction(e->{ 
           
            counter++;
            //System.out.println(counter);
            if(counter==2){
             
             l1.setText("You also only have 30 seconds to answer each question! Once time is up, you lose a live!");
             root.getChildren().remove(i1);
             root.getChildren().add(i2);  
             BorderPane.setAlignment(root, Pos.CENTER);
            }
            
            if(counter==3){
                l1.setText("Your total score of all the levels will appear in the top left corner!");
                root.getChildren().remove(i2);
                root.getChildren().add(i3);
                BorderPane.setAlignment(root, Pos.CENTER);
               
            }
            if(counter==4){
                l1.setText("For multiple choice questions, choose the answer you see fits best! ");
                root.getChildren().remove(i3);
                root.getChildren().add(i4);
               BorderPane.setAlignment(root, Pos.CENTER);
            }
            if(counter==5){
                l1.setText("For questions with an answer field, just type what you think the best answer is!");
                root.getChildren().remove(i4);
                root.getChildren().add(i5);
                BorderPane.setAlignment(root, Pos.CENTER);
            }
            
             if(counter==6){
                l1.setText("For drag and drop questions, select your answer with your cursor and drag it to the field labeled 'DROP HERE'");
                root.getChildren().remove(i5);
                root.getChildren().add(mv1);
                mp1.play();
               BorderPane.setAlignment(root, Pos.CENTER);
            }
             if(counter==7){
                l1.setText("For questions with a slider, you can drag the pointer or click on the forward keys on your keyboard!");
                mp1.stop();
                root.getChildren().remove(mv1);
                root.getChildren().add(mv2);
                mp2.play();
                BorderPane.setAlignment(root, Pos.CENTER);
            }
             if(counter==8){
                l1.setText("For questions with an instruction of 'Select all that apply', choose as many answers as you see fit!");
                mp2.stop();
                root.getChildren().remove(mv2);
                root.getChildren().add(i6);                
                BorderPane.setAlignment(root, Pos.CENTER);
            }
             if(counter==9){
                l1.setText("For questions with a drop down menu, select the answer you see fits!");               
                root.getChildren().remove(i6);
                root.getChildren().add(mv3);        
                mp3.play();                
               BorderPane.setAlignment(root, Pos.CENTER);
            }
             if(counter==10){
                 l1.setText("You've reached the end! Click next to go back!");
                  
             }
             if(counter==11){
                 Launch.switchToStartPage();
             }
            
        });
        
        
        
        
        border.setBottom(next);
        border.setCenter(root);
        border.setTop(l1);       
        BorderPane.setAlignment(next, Pos.CENTER);
        BorderPane.setAlignment(l1, Pos.CENTER);
        border.setBackground(CommonElements.background2);
         guide = new Scene(border,CommonElements.screenWidth,CommonElements.screenHeight);       
       return guide;
    }

   
    
}
