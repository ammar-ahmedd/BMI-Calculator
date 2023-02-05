import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BMI CALCULATOR");

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        TextField textField = new TextField();
        Label label = new Label("NAME");
        gridPane.add(textField, 1, 0);
        gridPane.add(label, 0, 0);
        Label label1 = new Label("GENDER");
        gridPane.add(label1, 0, 1);
        ToggleGroup tg = new ToggleGroup();
        RadioButton radioButton = new RadioButton("MALE");
        radioButton.setToggleGroup(tg);
        gridPane.add(radioButton, 1, 1);
        RadioButton radioButton1 = new RadioButton("FEMALE");
        gridPane.add(radioButton1, 1, 2);
        radioButton1.setToggleGroup(tg);
        Label label2 = new Label("DOB");
        gridPane.add(label2, 0, 3);
        DatePicker d = new DatePicker();
        gridPane.add(d, 1, 3);
        Label label3 = new Label("HEIGHT(cm)");
        gridPane.add(label3, 0, 4);
        Slider slider = new Slider();
        gridPane.add(slider, 1, 4);
        Label label4 = new Label("WEIGHT(kg)");
        gridPane.add(label4, 0, 5);
        Slider slider1 = new Slider();
        gridPane.add(slider1, 1, 5);
        slider.setMajorTickUnit(10);
        slider.setMin(0);
        slider.setMax(160);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider1.setMin(0);
        slider1.setMax(160);
        slider1.setMajorTickUnit(10);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        Button button = new Button("CALCULATE");
        gridPane.add(button, 0, 6);
        TextField textField1 = new TextField();
        gridPane.add(textField1, 1, 6);
        TextField textField2 = new TextField();
        gridPane.add(textField2,1,7);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField1.setText(BMI(Double.toString(slider.getValue()),Double.toString(slider1.getValue())));
                if(Double.parseDouble(BMI(Double.toString(slider.getValue()),Double.toString(slider1.getValue())))<=18.5){
                    textField2.setText("Ustaad Roti Khaya kar!");
                } else if (Double.parseDouble(BMI(Double.toString(slider.getValue()),Double.toString(slider1.getValue())))>18.5
                        &&Double.parseDouble(BMI(Double.toString(slider.getValue()),Double.toString(slider1.getValue())))<=24.5) {
                    textField2.setText("Laga reh");
                }
                else{
                    textField2.setText("Ustaad Roti Katt karde!");
                }
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        stage.show();

    }

    public static String BMI(String HEIGHT, String WEIGHT) {
        double height=Double.parseDouble(HEIGHT);
        double Weight=Double.parseDouble(WEIGHT);

        return Double.toString(Weight/Math.pow(height/100,2));

    }

}

