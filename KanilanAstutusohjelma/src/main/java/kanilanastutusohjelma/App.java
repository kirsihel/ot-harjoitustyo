package kanilanastutusohjelma;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("RabbitPlan");
        
        BorderPane layout = new BorderPane();
        BorderPane sign = new BorderPane();
        
        Button login = new Button("kirjaudu");
        Button newuser = new Button("luo uusi käyttäjä");
        Button back = new Button("Palaa");
        
        HBox user = new HBox();
        user.getChildren().add(new Label("käyttäjänimi:    "));
        user.getChildren().add(new TextField(""));
        
        HBox button = new HBox();
        button.getChildren().add(new Label("                 "));
        button.getChildren().add(newuser);
        
        HBox username = new HBox();
        username.getChildren().add(new Label("käyttäjänimi:          "));
        username.getChildren().add(new TextField(""));
        
        HBox rabbitry = new HBox();
        rabbitry.getChildren().add(new Label("kasvattajanimi:       "));
        rabbitry.getChildren().add(new TextField(""));
        
        HBox number = new HBox();
        number.getChildren().add(new Label("kasvattajanumero: "));
        number.getChildren().add(new TextField(""));
        
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().add(new Label("                     "));
        buttons.getChildren().add(back);
        buttons.getChildren().add(new Button("Luo"));
        
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
        
        Scene view = new Scene(layout,230,100);
        Scene signin = new Scene(sign,250,150);

        newuser.setOnAction((event) -> {
            stage.setScene(signin);
        });
        back.setOnAction((event) -> {
            stage.setScene(view);
        });
        
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}