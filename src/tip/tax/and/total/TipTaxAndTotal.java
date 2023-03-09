/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

package tip.tax.and.total;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author stipanmadzar
 */

public class TipTaxAndTotal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        
        Label label1 = new Label("Meal Charge:");
        label1.setMinSize(50, 50);
        TextField txt = new TextField();
        
        gp.setHgap(10);
        gp.add(label1, 1, 0);
        gp.add(txt, 2, 0);
        bp.setTop(gp);
        bp.setMargin(gp, new Insets(5, 0, 0, 0));
        
        VBox box1 = new VBox(-15);
        Label label2 = new Label("Tip (18%):");
        Label label3 = new Label("Tax (7%):");
        Label label4 = new Label("Total:");
        label2.setMinSize(50, 50);
        label3.setMinSize(50, 50);
        label4.setMinSize(50, 50);
        box1.getChildren().addAll(label2, label3,label4);
        
        Button btn = new Button("Calculate");
        btn.setPrefHeight(28);
        btn.setPrefWidth(75);
        
        VBox box2 = new VBox(btn);
        box2.setPadding(new Insets(-3, 0, 0, 104));
        
        VBox box3 = new VBox(0);
        box3.getChildren().addAll(box1, box2);
        
        bp.setLeft(box3);
        bp.setAlignment(box3, Pos.TOP_LEFT);
        bp.setMargin(box3, new Insets(-15, 0, 0, 10));
        
        
        btn.setOnAction(e ->
        {
            
            try {
                
                
                double input = Double.parseDouble(txt.getText());
                if(input > 0) {
                    
                
                double tip = input * 0.18;
                double tax = input * 0.07; 
                double total = input + tip + tax;
                label2.setText("Tip (18%):   \t" + String.format("%.2f", tip));
                label3.setText("Tax (7%):   \t" + String.format("%.2f", tax));
                label4.setText("Total:   \t" + String.format("%.2f", total));
                }
                else {
                label2.setText("Tip (18%):   \t0.00");
                label3.setText("Tax (7%):   \t0.00");
                label4.setText("Total:   \t0.00");
                }
                
            }
            
            catch(NumberFormatException e2) {
                
                label2.setText("Tip (18%):   \t0.00");
                label3.setText("Tax (7%):   \t0.00");
                label4.setText("Total:   \t0.00");
                
            }   
        });
        
        Scene scene = new Scene(bp, 300, 200);
        primaryStage.setTitle("Cost Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
            
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
