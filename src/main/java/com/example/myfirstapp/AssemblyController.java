package com.example.myfirstapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import ChoiceComponents.ComponentChoice;
import ChoiceComponents.FinalAssembly;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** Класс контролер отвечающий за вывод финальной сборки на экран пользователя  */

public class AssemblyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label blockPowerLabel;

    @FXML
    private Button buttonClose;

    @FXML
    private Label caseLabel;

    @FXML
    private Label coolingLabel;

    @FXML
    private Label cpuLabel;

    @FXML
    private Label gpuLabel;

    @FXML
    private Label hddLabel;

    @FXML
    private Label motherboardLabel;

    @FXML
    private Label ramLabel;

    @FXML
    private Label ssdLabel;

    @FXML
    private Hyperlink storelink;

    @FXML
    private Label blockPowerLabelPrice;

    @FXML
    private Label caseLabelPrice;

    @FXML
    private Label cpuLabelPrice;

    @FXML
    private Label gpuLabelPrice;

    @FXML
    private Label hddLabelPrice;

    @FXML
    private Label motherboardLabelPrice;

    @FXML
    private Label ramLabelPrice;

    @FXML
    private Label ssdLabelPrice;

    @FXML
    private Label coolingLabelPrice;

    @FXML
    private Label finalPriceLabel;

    Scene scene1;

    /** Функция отвечающая за закрытие программы */
    @FXML
    void goClose() {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void goBack() {
        scene1 = HelloApplication.scene1;
        HelloApplication.stage1.setScene(scene1);
        HelloApplication.stage1.show();
        goClose();

    }

    /** Функция отвечающая за открытие ссылки */
    @FXML
    void openStoreLink() {
        String url = "https://r-seven.ru";
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    /** Функция отвечающая за отображение комплектующих */
    @FXML
    void initialize() {
        HelloController helloController = new HelloController();
        BudgetController budgetController = new BudgetController();
        FinalAssembly finalAssembly = new FinalAssembly();
        List<ComponentChoice> list = finalAssembly.assemblyFullName(budgetController.getBudgetPC(), helloController.getTypePc());
        cpuLabel.setText(("CPU: " + list.get(0).getMark() + " " + list.get(0).getModelComponent()).toLowerCase());
        cpuLabelPrice.setText(list.get(0).getPrice() + "rub");
        motherboardLabel.setText(("MotherBoard: " + list.get(1).getMark() + " " + list.get(1).getModelComponent()).toLowerCase());
        motherboardLabelPrice.setText(list.get(1).getPrice() + "rub");
        coolingLabel.setText(("Cooling: " + list.get(2).getMark() + " " + list.get(2).getModelComponent()).toLowerCase());
        coolingLabelPrice.setText(list.get(2).getPrice() + "rub");
        blockPowerLabel.setText(("BlockPower: " +list.get(3).getMark() + " " + list.get(3).getModel() + "W " + list.get(3).getModelComponent()).toLowerCase());
        blockPowerLabelPrice.setText(list.get(3).getPrice() + "rub");
        ssdLabel.setText(("SSD: " +list.get(4).getMark() + " " + list.get(4).getModel() + "GB " + list.get(4).getModelComponent()).toLowerCase());
        ssdLabelPrice.setText(list.get(4).getPrice() + "rub");
        ramLabel.setText(("RAM: " +list.get(5).getMark() + " " + list.get(5).getModel() + "GB " + list.get(5).getModelComponent()).toLowerCase());
        ramLabelPrice.setText(list.get(5).getPrice() + "rub");
        caseLabel.setText(("Case: " +list.get(6).getMark() + " " + list.get(6).getModelComponent()).toLowerCase());
        caseLabelPrice.setText(list.get(6).getPrice() + "rub");
        if (helloController.getTypePc().equals("Game PC")) {
            gpuLabel.setText(("GPU: " +list.get(7).getMark() + " " + list.get(7).getModel() + " " + list.get(7).getModelComponent()).toLowerCase());
            gpuLabelPrice.setText(list.get(7).getPrice() + "rub");
            hddLabel.setText(("HDD: " +list.get(8).getMark() + " " + list.get(8).getModel() + "GB " + list.get(8).getModelComponent()).toLowerCase());
            hddLabelPrice.setText(list.get(8).getPrice() + "rub");
        }
        int fPrice = 0;
        for (int i = 0; i < list.size(); i++){
            fPrice = fPrice + list.get(i).getPrice();
        }
        finalPriceLabel.setText(fPrice + "rub");

    }

}
