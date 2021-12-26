package kanilanastutusohjelma;

import dao.BreedingDao;
import dao.RabbitDao;
import dao.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rabbitry.Breeding;
import rabbitry.Rabbit;
import service.Service;

public class App extends Application{
    private Service service;
    private VBox breedingnodes;
    private String usertext;
    
    /**
     *Metodin avulla luodaan UserDao- ja Service-oliot.
     * 
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        UserDao userdao = new UserDao("userfile.txt");
        RabbitDao rabbitdao = new RabbitDao("rabbitfile.txt", userdao);
        BreedingDao breedingdao = new BreedingDao("breedingfile.txt", userdao, rabbitdao);
        service = new Service(userdao, rabbitdao, breedingdao);
    }
    
    public Node createBreedingNode(Breeding breeding) {
        HBox box = new HBox();
        box.setSpacing(10);
        Label label  = new Label(breeding.getDoe().getName() + ";" + breeding.getBuck().getName() + ";" + breeding.getDate().toString());
        label.setMinHeight(28);
        Button button = new Button("astutettu");
        button.setOnAction(e->{
            service.markDone(breeding.getId());
            redrawBreedinglist();
        });
                
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.setPadding(new Insets(0,5,0,5));
        
        box.getChildren().addAll(label, spacer, button);
        return box;
    }
    
    public void redrawBreedinglist() {
        breedingnodes.getChildren().clear();     

        List<Breeding> undonebreedings = service.getUndone();
        undonebreedings.forEach(breeding->{
            breedingnodes.getChildren().add(createBreedingNode(breeding));
        });     
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("RabbitPlan");
        
        BorderPane layout = new BorderPane();
        BorderPane sign = new BorderPane();
        BorderPane pairs = new BorderPane();
        BorderPane possible = new BorderPane();
        
        Button login = new Button("kirjaudu");
        Button newuser = new Button("luo uusi käyttäjä");
        Button back = new Button("Palaa");
        Button logout = new Button("kirjaudu ulos");
        Button create = new Button("Luo");
        Button choose = new Button("valitse kani");
        Button pair = new Button("valitse pari");
        Button returnback = new Button("Palaa");
        Button backreturn = new Button("Palaa");
        Button add = new Button("lisää");
        Button returback = new Button("Palaa");
        Button addrabbit = new Button("lisää kani");
        Button backtomain = new Button("Palaa");
        Button check = new Button("tarkista");
        Button look = new Button("tarkista");
        Button breedingadd = new Button("kirjaa astutus");
        
        TextField usernameinput = new TextField();
        TextField rabbitrynameinput = new TextField();
        TextField breederidinput = new TextField();
        TextField nameinput = new TextField();
        TextField doeinput = new TextField();
        TextField buckinput = new TextField();
        TextField rabbitinput = new TextField();
        TextField rabbitoutput = new TextField();
        TextField rabbitnameinput = new TextField();
        TextField breedinput = new TextField();
        TextField sexinput = new TextField();
        TextField birthdateinput = new TextField();
        TextField fatherinput = new TextField();
        TextField motherinput = new TextField();
        TextField fathersfatherinput = new TextField();
        TextField fathersmotherinput = new TextField();
        TextField mothersfatherinput = new TextField();
        TextField mothersmotherinput = new TextField();
        TextField output = new TextField();
        
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
        main.getChildren().add(addrabbit);
        main.getChildren().add(choose);
        main.getChildren().add(pair);
        main.getChildren().add(breedingadd);
        main.getChildren().add(logout);
        
        HBox doe = new HBox();
        doe.getChildren().add(new Label("naaras: "));
        doe.getChildren().add(doeinput);
        
        HBox buck = new HBox();
        buck.getChildren().add(new Label("uros:    "));
        buck.getChildren().add(buckinput);
        
        VBox rabbits = new VBox();
        rabbits.setSpacing(10);
        rabbits.getChildren().add(doe);
        rabbits.getChildren().add(buck);
        rabbits.getChildren().add(new Label ("Sopiiko astutus?"));
        rabbits.getChildren().add(output);
        rabbits.getChildren().add(check);
        
        
        HBox retback = new HBox();
        retback.setSpacing(10);
        retback.getChildren().add(new Label("                                                     "));
        retback.getChildren().add(returnback);
        
        pairs.setTop(retback);
        pairs.setCenter(rabbits);
        
        VBox possibilities = new VBox();
        possibilities.setSpacing(10);
        possibilities.getChildren().add(new Label ("valitse kani"));
        possibilities.getChildren().add(rabbitinput);
        possibilities.getChildren().add(new Label ("mahdolliset parit"));
        rabbitoutput.setMinHeight(100);
        possibilities.getChildren().add(rabbitoutput);
        possibilities.getChildren().add(look);
        
        HBox backret = new HBox();
        backret.setSpacing(10);
        backret.getChildren().add(new Label("                                                     "));
        backret.getChildren().add(backreturn);
        
        possible.setTop(backret);
        possible.setCenter(possibilities);
        
        HBox rabbitsname = new HBox();
        rabbitsname.setSpacing(10);
        rabbitsname.getChildren().add(new Label("kanin nimi:    "));
        rabbitsname.getChildren().add(rabbitnameinput);
        
        HBox breed = new HBox();
        breed.setSpacing(10);
        breed.getChildren().add(new Label("kanin rotu:    "));
        breed.getChildren().add(breedinput);
        
        HBox sex = new HBox();
        sex.setSpacing(10);
        sex.getChildren().add(new Label("sukupuoli:     "));
        sex.getChildren().add(sexinput);
        
        HBox birthdate = new HBox();
        birthdate.setSpacing(10);
        birthdate.getChildren().add(new Label("syntymäaika: "));
        birthdate.getChildren().add(birthdateinput);
        
        HBox father = new HBox();
        father.setSpacing(10);
        father.getChildren().add(new Label("isä:                "));
        father.getChildren().add(fatherinput);
        
        HBox mother = new HBox();
        mother.setSpacing(10);
        mother.getChildren().add(new Label("emä:              "));
        mother.getChildren().add(motherinput);
        
        HBox fathersfather = new HBox();
        fathersfather.setSpacing(10);
        fathersfather.getChildren().add(new Label("isänisä:          "));
        fathersfather.getChildren().add(fathersfatherinput);
        
        HBox fathersmother = new HBox();
        fathersmother.setSpacing(10);
        fathersmother.getChildren().add(new Label("isänemä:       "));
        fathersmother.getChildren().add(fathersmotherinput);
        
        HBox mothersfather = new HBox();
        mothersfather.setSpacing(10);
        mothersfather.getChildren().add(new Label("emänisä:       "));
        mothersfather.getChildren().add(mothersfatherinput);
        
        HBox mothersmother = new HBox();
        mothersmother.setSpacing(10);
        mothersmother.getChildren().add(new Label("emänemä:     "));
        mothersmother.getChildren().add(mothersmotherinput);
        
        HBox reback = new HBox();
        reback.setSpacing(10);
        reback.getChildren().add(new Label("                                                     "));
        reback.getChildren().add(returback);
        
        VBox rabbit = new VBox();
        rabbit.setSpacing(10);
        rabbit.getChildren().add(reback);
        rabbit.getChildren().add(rabbitsname);
        rabbit.getChildren().add(breed);
        rabbit.getChildren().add(sex);
        rabbit.getChildren().add(birthdate);
        rabbit.getChildren().add(father);
        rabbit.getChildren().add(mother);
        rabbit.getChildren().add(fathersfather);
        rabbit.getChildren().add(fathersmother);
        rabbit.getChildren().add(mothersfather);
        rabbit.getChildren().add(mothersmother);
        rabbit.getChildren().add(add);
        
        ScrollPane breedings = new ScrollPane();
        BorderPane breeding = new BorderPane(breedings);
        HBox createform = new HBox();
        createform.setSpacing(10);
        Button addbreeding = new Button("lisää");
        TextField breedinginput = new TextField();
        breedinginput.setMinWidth(300);
        createform.getChildren().add(breedinginput);
        createform.getChildren().add(addbreeding);
        
        breedingnodes = new VBox();
        breedingnodes.setSpacing(10);
        breedingnodes.setMaxWidth(400);
        breedingnodes.setMinWidth(400);
        redrawBreedinglist();
        
        HBox tomain = new HBox();
        tomain.setSpacing(10);
        tomain.getChildren().add(new Label("                                                     "));
        tomain.getChildren().add(backtomain);
        
        breedings.setContent(breedingnodes);
        breeding.setBottom(createform);
        breeding.setTop(tomain);
        
        addbreeding.setOnAction(e->{
            service.createBreeding(breedinginput.getText());
            breedinginput.setText("");       
            redrawBreedinglist();
        });
        
        Scene view = new Scene(layout,230,100);
        Scene signin = new Scene(sign,250,150);
        Scene main_view = new Scene(main,230,200);
        Scene pairview = new Scene(pairs,230,200);
        Scene possibleview = new Scene(possible,230,250);
        Scene rabbitview = new Scene(rabbit,230,410);
        Scene breedingview = new Scene(breeding, 400, 200);
        

        newuser.setOnAction((event) -> {
            stage.setScene(signin);
        });
        
        back.setOnAction((event) -> {
            stage.setScene(view);
        });
        
        create.setOnAction((event) -> {
            String name = nameinput.getText();
            String rabbitrynametext = rabbitrynameinput.getText();
            String breederidtext = breederidinput.getText();
            
            if (name.length() < 5) {
                nameinput.setText("liian lyhyt käyttäjänimi");              
            } else if (service.createUser(name, rabbitrynametext, breederidtext)) {
                nameinput.setText("uusi käyttäjä luotu");
            } else {
                nameinput.setText("käyttäjänimi on jo olemassa");        
            }
        });
        
        login.setOnAction((event) -> {
          usertext =  usernameinput.getText();
          if(service.logIn(usertext)) {
              stage.setScene(main_view);
          } else {
              usernameinput.setText("käyttäjänimeä ei löydy");
          }
        });
        
        pair.setOnAction((event) -> {
            stage.setScene(pairview);
        });
        
        choose.setOnAction((event) -> {
            stage.setScene(possibleview);
        });
        
        addrabbit.setOnAction((event) -> {
            stage.setScene(rabbitview);
        });

        add.setOnAction((event) -> {
            String nametext = rabbitnameinput.getText();
            String breedtext = breedinput.getText();
            String sextext = sexinput.getText();
            String birthdatetext = birthdateinput.getText();
            String fathertext = fatherinput.getText();
            String mothertext = motherinput.getText();
            String fathersfathertext = fathersfatherinput.getText();
            String fathersmothertext = fathersmotherinput.getText();
            String mothersfathertext = mothersfatherinput.getText();
            String mothersmothertext = mothersmotherinput.getText();
            if(service.createRabbit(nametext, breedtext, sextext, LocalDate.parse(birthdatetext), fathertext, mothertext, fathersfathertext, fathersmothertext, mothersfathertext, mothersmothertext, service.getUser(usertext))) {
                rabbitnameinput.setText("kani lisätty");
                rabbitnameinput.setText("");
                breedinput.setText("");
                sexinput.setText("");
                birthdateinput.setText("");
                fatherinput.setText("");
                motherinput.setText("");
                fathersfatherinput.setText("");
                fathersmotherinput.setText("");
                mothersfatherinput.setText("");
                mothersmotherinput.setText("");
            } else {
                rabbitnameinput.setText("kani on jo olemassa");
            }
        });
        
        returnback.setOnAction((event) -> {
            stage.setScene(main_view);
        });
        
        backreturn.setOnAction((event) -> {
            stage.setScene(main_view);
        });
        
        returback.setOnAction((event) -> {
            stage.setScene(main_view);
        });
        
        logout.setOnAction((event) -> {
            usernameinput.setText("");
            stage.setScene(view);
        });
        
        look.setOnAction((event) -> {
            String rabbittext = rabbitinput.getText();
            Rabbit bunny = service.getRabbit(rabbittext);
            List<Rabbit> bunnies = service.getRabbits();
            List<Rabbit> possiblepairs = new ArrayList<>();
            for(Rabbit r: bunnies) {
                if(!r.getName().equals(bunny.getName()) && !r.isRelated(bunny) && !r.getSex().equals(bunny.getSex()) &&
                bunny.getBreed().equals(r.getBreed()) && (r.getAge().getMonths()>=6 || r.getAge().getYears()>=1)) {
                    possiblepairs.add(r);
                }
            }
            String text = "";
            for(Rabbit r: possiblepairs) {
                text = text + r.getName() + ", ";
            }
            rabbitoutput.setText(text);
        });
        
        check.setOnAction((event) -> {
            Rabbit doebunny = service.getRabbit(doeinput.getText());
            Rabbit buckbunny = service.getRabbit(buckinput.getText());
            if (!doebunny.isRelated(buckbunny) && !doebunny.getSex().equals(buckbunny.getSex()) &&
                doebunny.getBreed().equals(buckbunny.getBreed()) && (doebunny.getAge().getMonths()>=6 || doebunny.getAge().getYears()>=1) &&
                (buckbunny.getAge().getMonths()>=6 || buckbunny.getAge().getYears()>=1)) {
                output.setText("astutus onnistuu!");
            } else {
                output.setText("astutus ei onnistu!");
            }
        });
        
        breedingadd.setOnAction((event) -> {
            stage.setScene(breedingview);
            redrawBreedinglist();
        });
        
        backtomain.setOnAction((event) -> {
            stage.setScene(main_view);
        });
        
        stage.setScene(view);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}