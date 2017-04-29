package sample;

import javafx.scene.control.Alert;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jaizm on 26/04/2017.
 */
public class Utils {
    public static void openDialog(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public  static  String hashPassword(String password) {
        String hash = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashArray = digest.digest(password.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(hashArray);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
