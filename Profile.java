/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

public class Profile {
    
    public static String newU;
    public static String newP;
    public static String newPhone;
    public static Scene scene;
  public static VBox char1;
  public static VBox char2;
  public static VBox char3;
  public static VBox char4;
  public static Text t3;
  public static Text t2;
  public static TextField t5;
  public static TextField t6;
  public static TextField t7;
  public static Label click;

    public static Profile createProfile() {
       
        Label playerProfile = new Label("Player Profile");
        playerProfile.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        //playerProfile.setId("label");
        Label playerInfo = new Label("Player info");
        playerInfo.setId("project/Design.css");
     
        Button edit = new Button("Edit");
        edit.setPrefWidth(100);
        edit.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
        Button done = new Button("Done");
        done.setPrefWidth(100);
        done.setFont(Font.font("Cambria", FontWeight.BOLD, 15));
        HBox editInfo = new HBox(20, playerInfo);
        playerInfo.setId("label");
        FileChooser chooser = new FileChooser();
        Button upload = new Button("Upload profile picture");
        CommonElements.ButtonDesign2(upload);
        ImageView def = new ImageView("project/user.png");
        def.setFitHeight(100);
        def.setFitWidth(100);
        upload.setFont(Font.font("Cambria", FontWeight.BOLD, 15));

        VBox pic = new VBox(10, def, upload);
        upload.setOnAction(e->{
            File file = chooser.showOpenDialog(Launch.mainStage);
            final InputStream targetStream;
            try {
                targetStream = new DataInputStream(new FileInputStream(file));
                def.setImage(new Image(targetStream));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        Label playerStats = new Label("Player Stats");
        playerStats.setId("label");
        Label level = new Label("Level: ");
        level.setId("label");
        t2 = new Text();
        t2.setId("label");
        HBox levelDisplay = new HBox(30, level, t2);
        Label score = new Label("Total score: ");
        score.setId("label");
         t3 = new Text();
         t3.setId("label");
                
        HBox scoreDisplay = new HBox(30, score, t3);

        Label username = new Label("Username: ");
        username.setId("label");
        t5 = new TextField(Launch.regPage.u);
        t5.setId("textfield");
        t5.setEditable(false);
        HBox usernameField = new HBox(60, username, t5);
        Label password = new Label("Password: ");
        password.setId("label");
        t6 = new TextField(Launch.regPage.p);
        t6.setId("textfield");
        t6.setEditable(false);
        HBox passwordField = new HBox(65, password, t6);
        Label phonenumber = new Label("Phone number: ");
        phonenumber.setId("label");
        t7= new TextField(Launch.regPage.ph);
        t7.setId("textfield");
        t7.setEditable(false);
        
        HBox phoneField = new HBox(50, phonenumber, t7);
        
        edit.setOnMouseClicked(e->{            
            t5.setEditable(true);
            t6.setEditable(true);
            t7.setEditable(true);            
        });
        CommonElements.ButtonDesign2(done);
        CommonElements.ButtonDesign2(edit);
       done.setOnMouseClicked(e->{
           newU=t5.getText();
           newP=t6.getText();
           newPhone = t7.getText();
           
           RegistrationPage.map.put(newU,newP);
           RegistrationPage.map2.put(newU, newPhone);
           RegistrationPage.map.remove(Launch.regPage.u,Launch.regPage.p);
           RegistrationPage.map2.remove(Launch.regPage.u,Launch.regPage.ph);
           
           
           
           //if only the password is edited. old username & phone added then removed then added again
           if(Launch.regPage.u.equals(newU)&&Launch.regPage.ph.equals(newPhone)){
                RegistrationPage.map2.put(newU,newPhone);            
                
           }
           
           //if only the phone number is edited. old username & pass added then removed then added again
           if(Launch.regPage.u.equals(newU)&&Launch.regPage.p.equals(newP)){
                RegistrationPage.map.put(newU,newP);            
                
           }
           //if nothing is edited, username & pass & phone number added then removed then added again
           if(Launch.regPage.u.equals(newU)&&Launch.regPage.p.equals(newP)&&Launch.regPage.ph.equals(newPhone)){
                RegistrationPage.map.put(newU,newP);
                RegistrationPage.map2.put(newU, newPhone);
                
           }
                                         
           //System.out.println(RegistrationPage.map);
           //System.out.println(RegistrationPage.map2);
           t5.setEditable(false);
           t6.setEditable(false);
           t7.setEditable(false);
       });

        HBox editanddone = new HBox(30,edit,done);
        
        Label characters = new Label("Characters Unlocked");
        characters.setId("label");
        ImageView x1 = new ImageView("project/ibtessam.png");
        Label ibtesam = new Label("Mariam Al-Asturlabi");
        ibtesam.setId("name");
         char1 = new VBox(5, x1, ibtesam);
        char1.setVisible(false);
        ImageView x2 = new ImageView("project/ismail.png");
        Label ismail = new Label("Ismail Al-Jazzari");
        ismail.setId("name");
     char2 = new VBox(5, x2, ismail);
        char2.setVisible(false);
        ImageView x3 = new ImageView("project/ibn.png");
        Label ibn = new Label("Ibn Al-Haytham");
        ibn.setId("name");
     char3 = new VBox(5, x3, ibn);
        char3.setVisible(false);
        ImageView x4 = new ImageView("project/hassan.png");
        Label hassan = new Label("Hassan Al-Sabbah");
        hassan.setId("name");
       char4 = new VBox(5, x4, hassan);
        char4.setVisible(false);
        click = new Label("Click on a character to reveal some fun facts!");
        click.setId("label");
        click.setVisible(false);
        click.setId("label");

        HBox charactersLine = new HBox(50, char1, char2, char3, char4);
        VBox chars = new VBox(click,charactersLine);

        x1.setFitWidth(75);
        x1.setFitHeight(75);
   
        x2.setFitWidth(75);
        x2.setFitHeight(75);

        x3.setFitWidth(75);
        x3.setFitHeight(75);

        x4.setFitWidth(75);
        x4.setFitHeight(75);


     Menu h = new Menu();
        h.setStyle("-fx-padding: 5 20 8 20;");
        Label homeButton = new Label("Home");
        h.setGraphic(homeButton);
        homeButton.setId("label");

        homeButton.setTextAlignment(TextAlignment.CENTER);

      
       
   
        
        
        
    
        
        homeButton.setOnMouseClicked(e->{
            Launch.switchToStartPage();
        });
        
        Menu l = new Menu();
         l.setStyle("-fx-padding: 5 20 8 20;");
       Label levelMap = new Label("Level Map");
       l.setGraphic(levelMap);
       levelMap.setId("label");
        levelMap.setOnMouseClicked(e-> {
            Launch.switchToLevelMap();
        });
        
          MenuBar mbar = new MenuBar();
        mbar.getMenus().addAll(h,l);
        mbar.setBackground(Background.EMPTY);
        
        /*Levels ls = new Levels();
        levelMap.setOnMouseEntered(e->{
            try {
                ls.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); */
        
        //HBox corner = new HBox(50, levelMap, homeButton);

        GridPane g = new GridPane();

        g.addRow(0, playerProfile);
        g.setHalignment(playerProfile, HPos.CENTER);
        ColumnConstraints constraints = new ColumnConstraints();
        constraints.setHgrow(Priority.ALWAYS);
        g.getColumnConstraints().add(constraints);
        g.addRow(1, editInfo);
        g.addRow(2, pic);
        g.addRow(4, usernameField);
        g.addRow(5, passwordField);
        g.addRow(6, phoneField);
        g.addRow(7, editanddone);
        g.addRow(8, playerStats);
        g.addRow(9, levelDisplay);
        g.addRow(10, scoreDisplay);
        g.addRow(11, characters);
        g.addRow(12, chars);
        g.add(mbar, 10, 0);

        g.setVgap(5);

        g.setPadding(new Insets(20, 20, 20, 20));
        
        /* create a separate method for this or add it a premade method
        if(Score.totalScore==210) {
            char1.setVisible(true);
        } 
        if(Score.totalScore==420) {
            char2.setVisible(true);
        }
        if(Score.totalScore==630) {
            char3.setVisible(true);
        }
        if(Score.totalScore==840) {
            char4.setVisible(true);
        } */

        x1.setOnMouseClicked(e -> {
            ButtonType y = new ButtonType("Wow!");
            Alert a = new Alert(AlertType.NONE, "Mariam Al-Asturlabi, also known as Al-Ajliya Bint Al-Ajli manufactured astrolabes. \n She took manufacturing astrolabes to the next level. \n Astolabes are devices that measure time and position of sun and stars. ", y);
            a.setTitle("Fun fact!");
            a.show();
            a.setWidth(500);
            a.setHeight(250);

            ImageView bulb = new ImageView("project/bulb.png");
            bulb.setFitWidth(100);
            bulb.setFitHeight(100);
           a.setGraphic(bulb);

        });

        x2.setOnMouseClicked(e -> {
            ButtonType y = new ButtonType("Wow!");
            Alert a = new Alert(AlertType.NONE, "Al-Jazari was a mechanical engineer from Mesopotamia (modern-day Iraq) during the Islamic Golden Age. \n He is credited with describing over 50 mechanical devices and is regarded as the father of robotics. ", y);
            a.setTitle("Fun fact!");
            a.show();
            a.setWidth(500);
            a.setHeight(250);

            
            ImageView bulb = new ImageView("project/bulb.png");
            bulb.setFitWidth(100);
            bulb.setFitHeight(100);
            a.setGraphic(bulb);

        });
        x3.setOnMouseClicked(e -> {
            ButtonType y = new ButtonType("Wow!");
            Alert a = new Alert(AlertType.NONE, "Ibn Al-Haytham was a physicist from Mesopotamia (modern-day Iraq) during the Islamic Golden Age. \n He is regarded as the founding father of optics and has even been desrcibed as the world's first true scientist. ", y);
            a.setTitle("Fun fact!");
            a.show();
            a.setWidth(500);
            a.setHeight(250);
            
            ImageView bulb = new ImageView("project/bulb.png");
            bulb.setFitWidth(100);
            bulb.setFitHeight(100);
           a.setGraphic(bulb);

        });

        x4.setOnMouseClicked(e -> {
            ButtonType y = new ButtonType("Wow!");
            Alert a = new Alert(AlertType.NONE, "Hassan Al-Sabbah was a Lebanese electrical engineer. \n He was the original inventor of the solar cell and one of the pioneers in making electric cars a practical possibility.", y);
            a.setTitle("Fun fact!");
            a.show();
            a.setWidth(500);
            a.setHeight(250);

            
            ImageView bulb = new ImageView("project/bulb.png");
            bulb.setFitWidth(100);
            bulb.setFitHeight(100);
            a.setGraphic(bulb);

        });
        g.setVgap(25);
       g.setBackground(CommonElements.background);
         scene = new Scene(g,CommonElements.screenWidth,CommonElements.screenHeight);
          scene.getStylesheets().addAll("project/Design.css");
         Profile p = new Profile();
        p.scene = scene;
        return p;
        //s.getStylesheets().add("project/newCascadeStyleSheet.css");
        
        
        
        

    }
    
    public static void setUserandPass(String u,String p) {
        t5.setText(u);
        t6.setText(p);
    }
    
    public static void setPhoneNumber(String ph) {
        t7.setText(ph);
        
    }
   




}
