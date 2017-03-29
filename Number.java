import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Number extends Application {
	public void start(Stage primaryStage) {
		// Javafx for the input dialog
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Label label = new Label("Enter a number");
		grid.add(label, 0, 6);
		TextField textfield = new TextField();
		grid.add(textfield, 0, 7);
		Text scenetitle = new Text("Enter A Number to find it's Factorial and sum of odd numbers");
		scenetitle.setFont(Font.font("Times new Roman", 14));
		grid.add(scenetitle, 0, 3);
		Button okbutton = new Button("OK");
		// "OK" button's action after clicking
		okbutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String input = textfield.getText();
				int number = Integer.parseInt(input);
				int y = 1;
				int odd = 0;
				for (; number >= 1;) {
					if (number % 2 == 1) {
						odd = 1 * odd + number;
					}
					y = y * number;
					number--;
				}
				// javafx for the factorial output dialog
				GridPane grid = new GridPane();
				grid.setAlignment(Pos.CENTER);
				grid.setPadding(new Insets(25, 25, 25, 25));
				grid.setVgap(10);
				Text resulttitle = new Text("The factorial of " + input + " is " + y);
				resulttitle.setFont(Font.font("Times new Roman", 14));
				grid.add(resulttitle, 0, 0);
				Button exitbutton = new Button("OK");
				grid.add(exitbutton, 0, 1);
				final Integer SUM = new Integer(odd);
				// "OK" button's action after clicking
				exitbutton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						// closes fatorial output dialog
						primaryStage.close();
						// javafx for sum of odd numbers dialog
						GridPane grid2 = new GridPane();
						grid2.setAlignment(Pos.CENTER);
						grid2.setPadding(new Insets(25, 25, 25, 25));
						grid2.setVgap(10);
						Text resulttitle2 = new Text("The sum of first " + input + " odd numebers is " + SUM);
						resulttitle2.setFont(Font.font("Times new Roman", 14));
						grid2.add(resulttitle2, 0, 0);
						Button exitbutton2 = new Button("OK");
						grid2.add(exitbutton2, 0, 1);
						exitbutton2.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								// closes the sum of odd number dialog
								primaryStage.close();
							}
						});
						// shows the sum of odd numbers dialog
						Scene scene2 = new Scene(grid2, 300, 300);
						primaryStage.setTitle("Sum of Odd numbers");
						primaryStage.setScene(scene2);
						primaryStage.sizeToScene();
						primaryStage.show();

					}
				});
				// shows the factorial calculator dialog
				Scene scene3 = new Scene(grid, 200, 200);
				primaryStage.setTitle("Factorial Calculator");
				primaryStage.setScene(scene3);
				primaryStage.sizeToScene();
				primaryStage.show();
			}

		});
		// shows the input dialog to take value from user
		grid.add(okbutton, 0, 8);
		Scene scene = new Scene(grid, 400, 250);
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.setTitle("Factorial Calculator");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

	}
}
