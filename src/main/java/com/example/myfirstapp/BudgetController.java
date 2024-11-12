package com.example.myfirstapp;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import ChoiceComponents.HierarchyComponentGame;
import ChoiceComponents.HierarchyComponentOffice;
import ChoiceComponents.HierarchyComponentPC;
import ChoiceComponents.MinPriceComponent;
import UpdateDB.Updater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BudgetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonNext;

    @FXML
    private Label labelError;

    @FXML
    private TextField textBudget;

    @FXML
    private ToggleGroup updateVariantGroup;

    @FXML
    private Label lastDateLabel;

    /** поле budgetPC - бюджет, который вбил пользователь*/
    private static int budgetPC;

    HelloController helloController = new HelloController();


    public int getBudgetPC() {
        return budgetPC;
    }

    Scene scene1;

    /** Функция отвечающая за переход на предыдущее окно */
    @FXML
    void goBack() {
        scene1 = HelloApplication.scene1;
        HelloApplication.stage1.setScene(scene1);
        HelloApplication.stage1.show();
        goClose();

    }

    /** Функция отвечающая за закрытие программы */
    @FXML
    void goClose() {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    /** Функция отвечающая за переход к следующему окну */
    @FXML
    void goNext() {
        String total = textBudget.getText();
        HierarchyComponentPC hierarchy;
        int minBudget;
        String lastVariant;
        try {
            if((total != null)) {
                if (helloController.getTypePc().equals("Game PC")) {
                    hierarchy = new HierarchyComponentGame();
                } else {
                    hierarchy = new HierarchyComponentOffice();
                }
                minBudget = hierarchy.minBudget();
                budgetPC = Integer.parseInt(total);
                if(budgetPC < minBudget) {
                    labelError.setText("Budget less than the min price PC");
                } else {
                    RadioButton selectedRadio = (RadioButton) updateVariantGroup.getSelectedToggle();
                    lastVariant = (selectedRadio != null)? selectedRadio.getText() : null;
                    TransitiionButton transitiionButton = new TransitiionButton();

                    if ( lastVariant != null && lastVariant.equals("Yes")) {
                        try {
                            URL url = new URL("https://www.google.ru");
                            URLConnection con = url.openConnection();
                            con.getInputStream();

                            Date date = new Date();
                            newDate(date, helloController.getTypePc());
                            Updater updater = new Updater();
                            String update = updater.update(helloController.getTypePc());
                            if (update.equals("готово")) {
                                transitiionButton.transitiionWithoutEvent(buttonNext, "Assembly.fxml", "Pc collector");
                            }
                        } catch (IOException e) {
                            labelError.setText("No internet connection");
                        }
                    } else {
                        transitiionButton.transitiionWithoutEvent(buttonNext, "Assembly.fxml", "Pc collector");
                    }

                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            labelError.setText("Error, it's not a number");
        }
    }

    /** Функция отвечающая за отображение мин. бюджета и даты последнего обновления цен */
    @FXML void initialize() {
        HierarchyComponentPC hierarchy;
        if (helloController.getTypePc().equals("Game PC")) {
            hierarchy = new HierarchyComponentGame();
        } else {
            hierarchy = new HierarchyComponentOffice();
        }
        textBudget.setPromptText("min. budget: " + Integer.toString(hierarchy.minBudget()));
        String way = helloController.getTypePc().equals("Game PC")? "dataGame.txt" : "dataOffice.txt";
        lastDateLabel.setText(lastDate(way));
    }

    /** Функция отвечающая за запись новой даты */
    private void newDate(Date date, String typePc) {
        String way = typePc.equals("Game PC")? "dataGame.txt" : "dataOffice.txt";
        File file = new File("Storage\\Data\\" + way);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            pw.println(date);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
            pw.close();
        }
    }
    /** Функция отвечающая за получение старой даты */
    protected String lastDate(String file){
        String way = "Storage\\Data\\" + file;
        BufferedReader reader = null;
        String date = null;
        try {
            reader = new BufferedReader(new FileReader(way));
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if ( reader != null )
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return date;

    }

}