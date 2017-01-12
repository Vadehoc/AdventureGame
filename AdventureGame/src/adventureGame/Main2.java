package adventureGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main2 extends Application {

	public static void main(String[] args) {
		launch();
	}
	
// ========================== Variablen anlegen =========================================
	private double initMousePos;
	private double initSize;
	private double initSize2;
// =====================================================================================
	
// ========================== Objekte anlegen ===========================================
// -------------------------- Bilder ----------------------------------------------------
	private Image icon = new Image("Diamonds-Symbol.png");
// -------------------------- Menüs -----------------------------------------------------
	private MenuBar menuBar = new MenuBar();
	private Menu einstellungen = new Menu("Einstellungen");
	private Menu spiel = new Menu("Spiel");
	private MenuItem einstellungenTest = new MenuItem("Irgendwas");
	private MenuItem einstellungenTest2 = new MenuItem("Anderes");
	private MenuItem speichern = new MenuItem("speichern");
// -------------------------- Texte -----------------------------------------------------
	private Label ortsangabe = new Label("[Ortsangabe]");
	private Label objekteImOrtLabel = new Label("Objekte im Ort");
	private Label inventarLabel = new Label("Inventar");
	private Label notizenLabel = new Label("Notizen");
	private Text spieltext = new Text("\nHier wird der interessante Text stehen.\n"
									+ "Alle tollen Informationen über die Orte\n"
									+ "oder vielleicht auch Fragen oder Ähnliches.");
	private TextArea notizenFeld = new TextArea();
// -------------------------- Tipps -----------------------------------------------------
	private Tooltip tipOrt = new Tooltip("Hier befindest Du dich gerade.");
	private Tooltip tipPfeil = new Tooltip("Klicke, um in diesen Raum zu gehen.");
	private Tooltip tipNotizen = new Tooltip("Hier kannst Du dir Notizen machen.\nDiese werden beim Schließen mit abgespeichert.");
// -------------------------- Buttons ---------------------------------------------------
	private Button pfeilOben = new Button(">");
	private Button pfeilUnten = new Button(">");
	private Button pfeilLinks = new Button(">");
	private Button pfeilRechts = new Button(">");
	private Button brille= new Button("Brille deiner Mutter");
	private Button schluessel = new Button("Schlüssel");
// -------------------------- Sonstiges -------------------------------------------------
	private Separator separator = new Separator();
	private Region platzhalter = new Region();
	private Region resizeRechts = new Region();
	private Region resizeUnten = new Region();
	private Region resizeInventar = new Region();
// -------------------------- Container -------------------------------------------------
	private HBox infoBar = new HBox();
	private HBox inventarUndNotizen = new HBox();
	private HBox pfeilObenLeiste = new HBox();
	private HBox pfeilRechtsLeiste = new HBox();
	private VBox objekteImOrt = new VBox();
	private VBox notizen = new VBox();
	private VBox pfeilLinksLeiste = new VBox();
	private VBox pfeilUntenLeiste = new VBox();
// -------------------------- Panes -----------------------------------------------------
	private BorderPane mainPane = new BorderPane();
	private BorderPane mainArea = new BorderPane();
	private Pane spieltextanzeige = new Pane();
	private GridPane inventar = new GridPane();
// ======================================================================================
	
	@Override
	public void start(Stage primaryStage) {
// ========================== CSS-Einrichtung ===========================================
		menuBar.getStyleClass().add("menuBar");
		einstellungen.getStyleClass().add("einstellungen");
		spiel.getStyleClass().add("speichern");
		ortsangabe.getStyleClass().add("ortsangabe");
		objekteImOrtLabel.getStyleClass().add("objekteImOrtLabel");
		inventarLabel.getStyleClass().add("inventarLabel");
		notizenLabel.getStyleClass().add("notizenLabel");
		separator.getStyleClass().add("separator");
		resizeRechts.getStyleClass().add("resizeRechts");
		resizeUnten.getStyleClass().add("resizeUnten");
		resizeInventar.getStyleClass().add("resizeInventar");
		pfeilOben.getStyleClass().add("pfeilOben");
		pfeilUnten.getStyleClass().add("pfeilUnten");
		pfeilLinks.getStyleClass().add("pfeilLinks");
		pfeilRechts.getStyleClass().add("pfeilRechts");
		brille.getStyleClass().add("objekt");
		schluessel.getStyleClass().add("objekt");
		spieltext.getStyleClass().add("spieltext");
		infoBar.getStyleClass().add("infoBar");
		inventarUndNotizen.getStyleClass().add("inventarUndNotizen");
		pfeilObenLeiste.getStyleClass().add("pfeilObenLeiste");
		pfeilUntenLeiste.getStyleClass().add("pfeilUntenLeiste");
		pfeilLinksLeiste.getStyleClass().add("pfeilLinksLeiste");
		pfeilRechtsLeiste.getStyleClass().add("pfeilRechtsLeiste");
		spieltextanzeige.getStyleClass().add("spieltextanzeige");
		objekteImOrt.getStyleClass().add("objekteImOrt");
		notizenFeld.getStyleClass().add("notizenFeld");
		mainPane.getStyleClass().add("mainPane");
		mainArea.getStyleClass().add("mainArea");
		inventar.getStyleClass().add("inventar");
// ======================================================================================
		
// ========================== Struktur aufbauen =========================================
	// ---------------------- Top -------------------------------------------------------
		infoBar.getChildren().addAll(ortsangabe, platzhalter, menuBar);
		HBox.setHgrow(platzhalter, Priority.SOMETIMES);
		ortsangabe.setTooltip(tipOrt);
		menuBar.getMenus().addAll(einstellungen, spiel);
		spiel.getItems().addAll(speichern);
		einstellungen.getItems().addAll(einstellungenTest, einstellungenTest2);
		
	// ---------------------- Right -----------------------------------------------------
		objekteImOrt.getChildren().addAll(objekteImOrtLabel /*, separator */, brille, schluessel);
		separator.setOrientation(Orientation.HORIZONTAL);
		
	// ---------------------- Center ----------------------------------------------------
		pfeilObenLeiste.getChildren().addAll(pfeilOben);
		pfeilUntenLeiste.getChildren().addAll(pfeilUnten, resizeUnten);
		pfeilLinksLeiste.getChildren().addAll(pfeilLinks);
		pfeilRechtsLeiste.getChildren().addAll(pfeilRechts, resizeRechts);
		spieltextanzeige.getChildren().addAll(spieltext);
		pfeilOben.setTooltip(tipPfeil);
		pfeilUnten.setTooltip(tipPfeil);
		pfeilLinks.setTooltip(tipPfeil);
		pfeilRechts.setTooltip(tipPfeil);
		mainArea.setTop(pfeilObenLeiste);
		mainArea.setBottom(pfeilUntenLeiste);
		mainArea.setLeft(pfeilLinksLeiste);
		mainArea.setRight(pfeilRechtsLeiste);
		mainArea.setCenter(spieltextanzeige);
		mainArea.setAlignment(pfeilLinksLeiste, Pos.CENTER);
		mainArea.setAlignment(pfeilObenLeiste, Pos.CENTER);
		mainArea.setAlignment(pfeilRechtsLeiste, Pos.CENTER);
		mainArea.setAlignment(pfeilUntenLeiste, Pos.CENTER);
		mainArea.setAlignment(spieltextanzeige, Pos.TOP_LEFT);
	// ---------------------- Bottom ----------------------------------------------------
		inventarUndNotizen.getChildren().addAll(inventar, resizeInventar, notizen);
		notizen.getChildren().addAll(notizenLabel, notizenFeld);
		notizenFeld.setTooltip(tipNotizen);
		notizenLabel.setTooltip(tipNotizen);
		inventar.add(inventarLabel, 0, 0);
		
	// ---------------------- main Pane -------------------------------------------------
		mainPane.setTop(infoBar);
		mainPane.setRight(objekteImOrt);
		mainPane.setCenter(mainArea);
		mainPane.setBottom(inventarUndNotizen);
// ======================================================================================
		
// ========================== Aktionen festlegen ========================================
		resizeRechtsSetting();
		resizeUntenSetting();
		resizeInventarSetting();
// ======================================================================================
		
// ========================== Fenster einstellen ========================================
		Scene scene = new Scene(mainPane, 800, 500);
		scene.getStylesheets().add("style2.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Adventure Game");
		primaryStage.getIcons().add(icon);
		primaryStage.setMinHeight(scene.getHeight());
		primaryStage.setMinWidth(scene.getWidth());
		primaryStage.show();
	}
	
// ========================== Methoden ==================================================
	private void resizeRechtsSetting() {
		resizeRechts.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent MouseEvent) {
				resizeRechts.setCursor(Cursor.E_RESIZE);
			}
		});
		resizeRechts.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				initMousePos = mouseEvent.getScreenX();
				initSize = objekteImOrt.getWidth();
			}
		});
		resizeRechts.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				objekteImOrt.setPrefWidth(initSize - (mouseEvent.getScreenX() - initMousePos));
			}
		});
	}
	private void resizeUntenSetting() {
		resizeUnten.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent MouseEvent) {
				resizeUnten.setCursor(Cursor.S_RESIZE);
			}
		});
		resizeUnten.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				initMousePos = mouseEvent.getScreenY();
				initSize = inventarUndNotizen.getHeight();
			}
		});
		resizeUnten.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				inventarUndNotizen.setPrefHeight(initSize - (mouseEvent.getScreenY() - initMousePos));
				notizenFeld.setPrefHeight(initSize - (mouseEvent.getScreenY() - initMousePos));
			}
		});
	}
	private void resizeInventarSetting() {
		resizeInventar.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent MouseEvent) {
				resizeInventar.setCursor(Cursor.E_RESIZE);
			}
		});
		resizeInventar.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				initMousePos = mouseEvent.getScreenX();
				initSize = inventar.getWidth();
				initSize2 = notizenFeld.getWidth();
			}
		});
		resizeInventar.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				inventar.setPrefWidth(initSize + (mouseEvent.getScreenX() - initMousePos));
				notizenFeld.setPrefWidth(Math.max((initSize2 - (mouseEvent.getScreenX() - initMousePos)), 0));
			}
		});
	}
}
