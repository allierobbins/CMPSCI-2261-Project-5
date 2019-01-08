import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

	
public class Proj5 extends Application{
	
	public static void main(String[] args) {
		 launch(args);
		 }
	
	public void start(Stage primaryStage) {

		 FlowPane pane = new FlowPane();
		 pane.setHgap(60);
		 pane.setAlignment(Pos.CENTER_LEFT);
		 pane.setVgap(10);
		 pane.setPadding(new Insets(10));
		 pane.setLayoutX(10);
		 TextField moneyUsed = new TextField();
		 TextField years = new TextField();
		 TextField annualInterestRate = new TextField();
		 TextField result = new TextField();
		 result.setEditable(false);

		 moneyUsed.setPrefColumnCount(10);
		 years.setPrefColumnCount(10);
		 annualInterestRate.setPrefColumnCount(10);
		 result.setPrefColumnCount(10);

		 Label label1 = new Label("Money in investment: ");
		 Label label2 = new Label("Years:                          "); 
		 Label label3 = new Label("Annual Interest Rate:  ");
		 Label label4 = new Label("Final financial worth:   ");

		 pane.getChildren().addAll(label1, moneyUsed, label2, years, label3, annualInterestRate, label4, result);

		 HBox hBox = new HBox();
		 Button calculateButton = new Button("Calculate");
		 hBox.setAlignment(Pos.CENTER);
		 hBox.getChildren().addAll(calculateButton);
		 hBox.setSpacing(10);

		 BorderPane borderPane = new BorderPane();
		 borderPane.setCenter(pane);
		 borderPane.setBottom(hBox);
		 BorderPane.setAlignment(hBox,Pos.CENTER);

		 Scene scene = new Scene(borderPane, 350, 400);
		 primaryStage.setTitle("Financial Calculator");
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 
		 calculateButton.setOnAction(e -> {
			 Double interestRateMonth = Double.parseDouble(annualInterestRate.getText()) / 1200;
		 result.setText( Double.parseDouble(moneyUsed.getText()) * Math.pow((1 + interestRateMonth), ((Double.parseDouble(years.getText()) * 12))) + 
				  "");
		 });
		
		 }
		}
