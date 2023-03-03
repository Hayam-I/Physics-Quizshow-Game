/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author LEEN
 */

public class Launch extends Application {
    public static Stage mainStage = new Stage();
    public static WelcomePage welcomePage = WelcomePage.createWelcomePage();
 
    public static StartPage startPage = StartPage.createStartPage();
      public static RegistrationPage regPage = RegistrationPage.createRegPage();
       public static Profile profile = Profile.createProfile();
    public static LevelMap levelMap = LevelMap.createLevelMap();
    public static ScoreHistory scoreH = new ScoreHistory();
    

    
    
     public static void switchToWelcomePage() {
        mainStage.setScene(welcomePage.scene);
    }
    
     
     public static void switchToRegPage() {
           
        mainStage.setScene(regPage.scene);
        
    }
    
      public static void switchToStartPage() {
        mainStage.setScene(startPage.scene);
    }
       public static void switchToProfile() {
              
        mainStage.setScene(profile.scene);
    }
       public static void switchToLevelMap() {
           mainStage.setScene(levelMap.scene);
       }
       
       
       
       
     
       @Override
       public void start(Stage primaryStage) {
           primaryStage = mainStage;
           primaryStage.setScene(welcomePage.scene);
           
           primaryStage.show();
       }
       
       public static void main(String [] args) {
          
           launch(args);
       }
      
}

