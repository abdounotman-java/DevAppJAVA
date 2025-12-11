
package com.example.grhtd3.applications;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

public class DepartementMathApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProfApplication.class.getResource("../departementmath-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 565, 550);
        stage.setTitle("M36-AD : GRH - Application en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
