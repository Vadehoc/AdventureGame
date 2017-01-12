package adventureGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
// Objekte
	MenuBar kontrollleiste = new MenuBar();
	
	Menu speichern = new Menu("Speichern");
	Menu einstellungen = new Menu("Einstellungen");
	Menu schliessen = new Menu("Schließen");
	
	Region platzhalterKontrollleiste = new Region();
	
	Button pfeilOben = new Button(">");
	Button pfeilRechts = new Button(">");
	Button pfeilUnten = new Button(">");
	Button pfeilLinks = new Button(">");
	
	Label ortsAngabe = new Label("[Ort]");
	Label objekteImOrt = new Label("Objekte im Ort");
	
	GridPane objektTabelle = new GridPane();
	Pane mainPane = new Pane();
	
	Text inventar = new Text("Inventar");
	Text notizen = new Text("Notizen");
	Text spielText = new Text("Text");

// Container
	HBox infoLeisteOben = new HBox();
	HBox pfeilObenLeiste = new HBox();
	HBox pfeilUntenLeiste = new HBox();
	HBox textFelder = new HBox();
	HBox untenGesamt = new HBox();
	HBox textMitPfeilen = new HBox();
	HBox inventarFeld = new HBox();
	HBox notizenFeld = new HBox();
	
	VBox pfeilLinksLeiste = new VBox();
	VBox spielTextFeld = new VBox();
	VBox pfeilRechtsLeiste = new VBox();
	VBox objekteImOrtFeld = new VBox();
	VBox linksGesamt = new VBox();
	VBox gesamt = new VBox();
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) {
//		kontrollleiste.getStyleClass().add("kontrollleiste");
//		speichern.getStyleClass().add("speichern");
//		einstellungen.getStyleClass().add("einstellungen");
//		schliessen.getStyleClass().add("schliessen");
//		pfeilOben.getStyleClass().add("pfeilOben");
//		pfeilRechts.getStyleClass().add("pfeilRechts");
//		pfeilUnten.getStyleClass().add("pfeilUnten");
//		pfeilLinks.getStyleClass().add("pfeilLinks");
//		ortsAngabe.getStyleClass().add("ortsAngabe");
//		objekteImOrt.getStyleClass().add("objekteImOrt");
//		objektTabelle.getStyleClass().add("objektTabelle");
//		mainPane.getStyleClass().add("mainPane");
//		inventar.getStyleClass().add("inventar");
//		notizen.getStyleClass().add("notizen");
//		spielText.getStyleClass().add("spielText");
//		infoLeisteOben.getStyleClass().add("infoLeisteOben");
//		pfeilObenLeiste.getStyleClass().add("pfeilObenLeiste");
//		pfeilUntenLeiste.getStyleClass().add("pfeilUntenLeiste");
//		textFelder.getStyleClass().add("textFelder");
//		untenGesamt.getStyleClass().add("untenGesamt");
//		textMitPfeilen.getStyleClass().add("textMitPfeilen");
//		inventarFeld.getStyleClass().add("inventarFeld");
//		notizenFeld.getStyleClass().add("notizenFeld");
//		pfeilLinksLeiste.getStyleClass().add("pfeilLinksLeiste");
//		spielTextFeld.getStyleClass().add("spielTextFeld");
//		pfeilRechtsLeiste.getStyleClass().add("pfeilRechtsLeiste");
//		objekteImOrtFeld.getStyleClass().add("objekteImOrtFeld");
//		linksGesamt.getStyleClass().add("linksGesamt");
//		gesamt.getStyleClass().add("gesamt");
		
		
		
		
//		objektTabelle.getChildren().addAll(objekteImOrt);
		kontrollleiste.getMenus().addAll(speichern, einstellungen, schliessen);
//		
		infoLeisteOben.getChildren().addAll(ortsAngabe, platzhalterKontrollleiste, kontrollleiste);
		HBox.setHgrow(platzhalterKontrollleiste, Priority.ALWAYS);
//		textFelder.getChildren().addAll(inventarFeld, notizenFeld);
//		spielTextFeld.getChildren().addAll(spielText);
//		inventarFeld.getChildren().addAll(inventar);
//		notizenFeld.getChildren().addAll(notizen);
//		
//		pfeilUntenLeiste.getChildren().addAll(pfeilUnten);
//		pfeilObenLeiste.getChildren().addAll(pfeilOben);
//		pfeilLinksLeiste.getChildren().addAll(pfeilLinks);
//		pfeilRechtsLeiste.getChildren().addAll(pfeilRechts);
//		
//		objekteImOrtFeld.getChildren().addAll(objektTabelle);
//		textMitPfeilen.getChildren().addAll(pfeilLinksLeiste, spielTextFeld, pfeilRechtsLeiste);
//		linksGesamt.getChildren().addAll(pfeilObenLeiste, textMitPfeilen, pfeilUntenLeiste, textFelder);
//		untenGesamt.getChildren().addAll(linksGesamt, objekteImOrtFeld);
//		gesamt.getChildren().addAll(infoLeisteOben, untenGesamt);
//		
//		HBox.setHgrow(infoLeisteOben, Priority.SOMETIMES);
		
		mainPane.getChildren().addAll(infoLeisteOben);
		
		Scene scene = new Scene(mainPane, 800, 800);
//		scene.getStylesheets().add("style.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Adventure Game");
		primaryStage.show();
	}
}
