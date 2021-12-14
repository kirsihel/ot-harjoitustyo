package kanilanastutusohjelma;

import dao.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.Service;

public class App extends Application{
    private Service service;
    
    /**
     *Metodin avulla luodaan UserDao- ja Service-oliot.
     * 
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        UserDao userdao = new UserDao("userfile.txt");
        service = new Service(userdao);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("RabbitPlan");
        
        BorderPane layout = new BorderPane();
        BorderPane sign = new BorderPane();
        
        Button login = new Button("kirjaudu");
        Button newuser = new Button("luo uusi käyttäjä");
        Button back = new Button("Palaa");
        Button logout = new Button("kirjaudu ulos");
        Button create = new Button("Luo");
        
        TextField usernameinput = new TextField();
        TextField rabbitrynameinput = new TextField();
        TextField breederidinput = new TextField();
        TextField nameinput = new TextField();
        
        HBox user = new HBox();
        user.getChildren().add(new Label("käyttäjänimi:    "));
        user.getChildren().add(usernameinput);
        
        HBox button = new HBox();
        button.getChildren().add(new Label("                 "));
        button.getChildren().add(newuser);
        
        HBox username = new HBox();
        username.getChildren().add(new Label("käyttäjänimi:          "));
        username.getChildren().add(nameinput);
        
        HBox rabbitry = new HBox();
        rabbitry.getChildren().add(new Label("kasvattajanimi:       "));
        rabbitry.getChildren().add(rabbitrynameinput);
        
        HBox number = new HBox();
        number.getChildren().add(new Label("kasvattajanumero: "));
        number.getChildren().add(breederidinput);
        
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().add(new Label("                     "));
        buttons.getChildren().add(back);
        buttons.getChildren().add(create);
        
        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().add(username);
        box.getChildren().add(rabbitry);
        box.getChildren().add(number);
        
        layout.setTop(user);
        layout.setRight(login);
        layout.setBottom(button);
        
        sign.setCenter(box);
        sign.setBottom(buttons);
        
        VBox main = new VBox();
        main.setSpacing(10);
        main.getChildren().add(new Label ("Mitä haluat tehdä?"));
        main.getChildren().add(new Button("lisää kani"));
        main.getChildren().add(new Button("valitse kani"));
        main.getChildren().add(new Button("valitse pari"));
        main.getChildren().add(new Button("kirjaa astutus"));
        main.getChildren().add(logout);
        
        
        Scene view = new Scene(layout,230,100);
        Scene signin = new Scene(sign,250,150);
        Scene main_view = new Scene(main,100,200);
        

        newuser.setOnAction((event) -> {
            stage.setScene(signin);
        });
        
        back.setOnAction((event) -> {
            stage.setScene(view);
        });
        
        create.setOnAction((event) -> {
            String usernametext = nameinput.getText();
            String rabbitrynametext = rabbitrynameinput.getText();
            String breederidtext = breederidinput.getText();
            
            if (usernametext.length() < 5) {
                nameinput.setText("liian lyhyt käyttäjänimi");              
            } else if (service.createUser(usernametext, rabbitrynametext, breederidtext)) {
                nameinput.setText("uusi käyttäjä luotu");
            } else {
                nameinput.setText("käyttäjänimi on jo olemassa");        
            }
        });
        
        login.setOnAction((event) -> {
          String name =  usernameinput.getText();
          if(service.logIn(name)) {
              stage.setScene(main_view);
          } else {
              usernameinput.setText("käyttäjänimeä ei löydy");
          }
        });
        
        logout.setOnAction((event) -> {
            stage.setScene(view);
        });
        
        stage.setScene(view);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}