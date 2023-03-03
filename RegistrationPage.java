package project;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;


/**
 *
 * @author hayam
 */
public class RegistrationPage   {
    public static Scene scene;
    
    
    
    static HashMap<String, String> map = new HashMap<>();
    static HashMap <String, String> map2 = new HashMap<>();
    
    static String m1="";
    static String m2="";
    static String m3="";
    static String m4="";
    public static String u="";
    public static String p="";
    public static String ph="";
    
    public static boolean login(String uname, String pword){
   
        
        u=uname;
        p=pword;  
        ph=map2.get(uname);
        Launch.profile.setUserandPass(u,p);
        Launch.profile.setPhoneNumber(ph);
        
        
        if(map.containsKey(uname) && map.containsValue(pword)){
            m3="Successful Login!";
            return true;
        }
        
        else if(!map.containsKey(uname)|| !map.containsValue(pword)){
            m4="Invalid username or password";
            return false;
        }
        return false;
    }
    
    

    public static boolean signup(String uname,String pword,String pnumber) throws FileNotFoundException, IOException{ 
        if(map.containsKey(uname)){
            m2 = "Username already taken! Choose another one!";
            return false;
            
        }
        
        else if(!map.containsKey(uname)&& !map.containsValue(pword)){
            m1="Successful Sign Up!";
            u=uname;
            p=pword;
            ph=pnumber;
            map.put(uname, pword);
            map2.put(uname, pnumber);
               
               Launch.profile.setUserandPass(u,p);
               Launch.profile.setPhoneNumber(ph);
               
            
            return true;
        }
        return false;
    }
    

    

    public static RegistrationPage createRegPage(){
        Font font = Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 35);
        
        FlowPane pane = new FlowPane();
        pane.alignmentProperty().set(Pos.CENTER);
        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);
        
        ImageView create = new ImageView("project/create.png");
        Path path = new Path();
        path.getElements().addAll(new MoveTo(400,0),new VLineTo(100));
        PathTransition pt = new PathTransition(Duration.millis(2000),path,create);
        pt.play();
        ImageView create2 = new ImageView("project/create2.png");
        Path path2 = new Path();
        path2.getElements().addAll(new MoveTo(450,0),new VLineTo(60));
        PathTransition pt2 = new PathTransition(Duration.millis(1500),path2,create2);
        TextField tf1 = new TextField();
        tf1.setPromptText("Username");
        tf1.requestFocus();
        TextField tf2 = new TextField();
        tf2.setPromptText("Password");
        TextField phonenumber = new TextField();
        phonenumber.setPromptText("Phone number");
        
        TextField tf3 = new TextField();
        tf3.setPromptText("Username");
        tf3.requestFocus();
        TextField tf4 = new TextField();
        tf4.setPromptText("Password");
        
        
       
        
        //LOGIC FOR SIGNING UP!!
       
        vbox1.alignmentProperty().set(Pos.CENTER);
        Text t1 = new Text("Please enter a username and password and your phone number!");
        t1.setFont(font);
        t1.setFill(Color.web("#9F3E00"));
        t1.setStroke(Color.BEIGE);
        Button b1 = new Button("Submit");
        b1.setFont(font);
        CommonElements.ButtonDesign(b1);
        Text t2 = new Text("Already have an account?");
        t2.setFont(font);
        t2.setFill(Color.web("#9F3E00"));
        t2.setStroke(Color.BEIGE);
        Button b2 = new Button("Log in!");
        b2.setFont(font);
        CommonElements.ButtonDesign(b2);
        //b2.setStroke(Color.WHITE);
        Alert alert1 = new Alert(AlertType.INFORMATION);
        alert1.setTitle("Thank you!");
        alert1.setHeaderText(null);
        
        Alert alert2 = new Alert(AlertType.ERROR);
        alert2.setTitle("Careful");
        alert2.setHeaderText(null);
        
        b1.setOnMouseClicked(e->{
            boolean register=false;
            try {
                register = signup(tf1.getText(),tf2.getText(),phonenumber.getText());
                
            } catch (IOException ex) {
                Logger.getLogger(RegistrationPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (register==true){
                alert1.setContentText(m1);
                alert1.showAndWait();
                Launch.switchToStartPage();
            }
            if(register==false){
                alert2.setContentText(m2);
                alert2.showAndWait();
            }
        });
        
        b2.setOnAction(e->{
         pane.getChildren().remove(vbox1);
         pane.getChildren().add(vbox2);
         tf3.clear();
         tf4.clear(); 
         pt2.play();
         
         
        });
        vbox1.getChildren().addAll(create,t1,tf1,tf2,phonenumber,b1,t2,b2);
        
        //LOGIC FOR LOGGING IN!!
        
       
        vbox2.alignmentProperty().set(Pos.CENTER);
        Text t3 = new Text("Please enter your username and password!");
        t3.setFont(font);
        t3.setFill(Color.web("#9F3E00"));
        t3.setStroke(Color.BEIGE);
        
        Button b3 = new Button("Log In");
        b3.setFont(font);
        CommonElements.ButtonDesign(b3);
        Text t4 = new Text("Don't have an account?");
        t4.setFont(font);
        t4.setFill(Color.web("#9F3E00"));
        t4.setStroke(Color.BEIGE);
        Button b4 = new Button("Sign up!");
        b4.setFont(font);
        CommonElements.ButtonDesign(b4);
        Alert alert3 = new Alert(AlertType.INFORMATION);
        alert3.setTitle("Thank you!");
        alert3.setHeaderText(null);
        
        Alert alert4 = new Alert(AlertType.ERROR);
        alert4.setTitle("Careful!");
        alert4.setHeaderText(null);
        
        
        b3.setOnMouseClicked(e->{
            boolean login = login(tf3.getText(),tf4.getText());
            if (login==true){
                alert3.setContentText(m3);
                alert3.showAndWait();
                Launch.switchToStartPage();
                    
            }
            
            if(login==false){
                alert4.setContentText(m4);
                alert4.showAndWait();
            }
        });
        
        b4.setOnAction(e->{
         pane.getChildren().remove(vbox2);
         pane.getChildren().add(vbox1);
         tf1.clear();
         tf2.clear();
         phonenumber.clear();
         pt.play();
         
        });
        vbox2.getChildren().addAll(create2,t3,tf3,tf4,b3,t4,b4);
        
        
        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight()-90;
        pane.getChildren().add(vbox1);
        ImageView bg = new ImageView("project/RegistrationPageBG.png");
        bg.setFitHeight(CommonElements.screenHeight);
        bg.setFitWidth(CommonElements.screenWidth);
        StackPane stack = new StackPane(bg,pane);
        scene = new Scene(stack,screenWidth,screenHeight);
          
        RegistrationPage r = new RegistrationPage();
        r.scene = scene;
        return r;
    }
    
}
