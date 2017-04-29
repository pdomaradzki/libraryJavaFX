package sample;

import com.jfoenix.controls.JFXListView;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by jaizm on 29/04/2017.
 */
public class MainController implements Initializable {

    @FXML
    ImageView logo;

    @FXML
    JFXListView list;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        RotateTransition transition = new RotateTransition();
//        transition.setDuration(Duration.seconds(5));
////        transition.setByAngle(360);
//        transition.setCycleCount(10);
//        transition.setAutoReverse(true);
//        transition.setToAngle(60);
//        transition.setFromAngle(-60);
//        transition.setNode(logo);
//        transition.play();
//
//        ScaleTransition scale = new ScaleTransition();
//        scale.setNode(logo);
//        scale.setByX(.5);
//        scale.setByY(.5);
//        scale.setDuration(Duration.seconds(5));
//        scale.setCycleCount(10);
//        scale.play();
//
//        TranslateTransition translateTransition = new TranslateTransition();
//        translateTransition.setNode(logo);
//        translateTransition.setDuration(Duration.seconds(10));
//        translateTransition.setByX(200);
//        translateTransition.setAutoReverse(true);
//        translateTransition.play();

//        FadeTransition fadeTransition = new FadeTransition();
//        fadeTransition.setNode(logo);
//        fadeTransition.setDuration(Duration.seconds(5));
//        fadeTransition.setFromValue(1.0);
//        fadeTransition.setToValue(0.0);
//        fadeTransition.setAutoReverse(true);
//        fadeTransition.setCycleCount(2);
//        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Zakończyłem wykonywanie animacji");
//            }
//        });
//        fadeTransition.play();

        ObservableList<String> items = FXCollections.observableArrayList("Oskar", "Wojtek");
        list.setItems(items);

    }

    private ObservableList<String> loadBooks() {
        ObservableList<String> items = FXCollections.observableArrayList ();
        Statement statement = MySqlConnector.getInstance().getNewStatement();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM book");
            while(resultSet.next()) {
                items.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
