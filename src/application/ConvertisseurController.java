package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConvertisseurController implements Initializable {

	// Definition des variables (objets) pour l'onglet qui convertit les unites de
	// monnaie.

	@FXML
	private TextField MOtxtU1;// TextField a gauche

	@FXML
	private TextField MOtxtU2;// TextField a droite

	@FXML
	private ComboBox<String> MOcboU1;// ComboBox a gauche

	@FXML
	private ComboBox<String> MOcboU2;// ComboBox a droite

	// Definition des variables (objets) pour l'onglet qui convertit les unites de
	// temps.

	@FXML
	private TextField TtxtU1;// TextField a gauche
	@FXML
	private TextField TtxtU2;// TextField a droite

	@FXML
	private ComboBox<String> TcboU1;// ComboBox a gauche

	@FXML
	private ComboBox<String> TcboU2;// ComboBox a droite

	// Definition des variables (objets) pour l''onglet qui convertit les unites de
	// longueur.
	@FXML
	private TextField LtxtU1;// TextField a gauche

	@FXML
	private TextField LtxtU2;// TextField a droite

	@FXML
	private ComboBox<String> LcboU1;// ComboBox a gauche

	@FXML
	private ComboBox<String> LcboU2;// ComboBox a droite

	// Definition des variables (objets) pour l'onglet qui convertit les unites de
	// masse
	@FXML
	private TextField MtxtU1;// TextField a gauche

	@FXML
	private TextField MtxtU2;// TextField a droite

	@FXML
	private ComboBox<String> McboU1;// ComboBox a gauche

	@FXML
	private ComboBox<String> McboU2;// ComboBox a droite

	// Definition des variables (objets) pour l'onglet qui convertit les unites de
	// quantite de matiere.
	@FXML
	private TextField QtxtU1;// TextField a gauche

	@FXML
	private TextField QtxtU2;// TextField a droite

	@FXML
	private ComboBox<String> QcboU1;// ComboBox a gauche

	@FXML
	private ComboBox<String> QcboU2;// ComboBox a droite

	@FXML
	private Button BbtnQuitter;// Bouton pour quitter l'application

	private ObservableList<String> MOliste = (ObservableList<String>) FXCollections.observableArrayList("CAD", "USD",
			"EUR", "JPY");// Liste de differents unites de monnaie, à afficher comme options dans la
							// ComboBox sur l'onglet pour convertir la monnaie
	private ObservableList<String> Mliste = (ObservableList<String>) FXCollections.observableArrayList("mg", "g", "kg",
			"ton (imperial)", "ton (US)", "lbs", "oz");// Liste de differents unites de masse, à afficher comme options
														// dans la ComboBox sur l'onglet pour convertir la masse
	private ObservableList<String> Qliste = (ObservableList<String>) FXCollections.observableArrayList("entites", "mol",
			"mmol", "pmol", "nmol");// Liste de differents unites de quantnites de matiere, a afficher comme options
									// dans la ComboBox sur l'onglet pour convertir la quantitie de matiere
	private ObservableList<String> Tliste = (ObservableList<String>) FXCollections.observableArrayList("ms", "s", "min",
			"hr", "jour", "annee");// Liste de differents unites de temps, à afficher comme options dans la
									// ComboBox sur l'onglet pour convertir la temps
	private ObservableList<String> Lliste = (ObservableList<String>) FXCollections.observableArrayList("mm", "cm", "m",
			"km", "yrd", "ft", "mi");// Liste de differents unites de longueur, à afficher comme options dans la
										// ComboBox sur l'onglet pour convertir longueur

	// Les facteurs de conversion pour chaque unite.
	double[] MOfacteur = { 1, 1.33333, 1.449275, 1.1865e-2 };// Pour la monnaie
	double[] Mfacteur = { 1, 1e3, 1e6, 9.8421e10, 1.1023e9, 2.2046e6, 3.5274e5 };// Pour la masse
	double[] Qfacteur = { 1, 6.02e23, 6.02e20, 6.02e14, 6.02e11 };// Pour les quantites de matiere
	double[] Tfacteur = { 1, 1e-3, 1.6667e-5, 2.7778e-7, 1.1574e-8, 3.171e-11 };// Pour le temps
	double[] Lfacteur = { 1, 10, 1e3, 1e6, 9.144027578e2, 3.048e2, 1 / 1.609347088e6 };// Pour
																						// la
																						// longueur

	/**
	 * Methode qui ferme le convertisseur
	 */
	@FXML
	private void fermer() {
		System.exit(0);
	}

	/**
	 * Methode pour initializer les differents elements du convertisseur,
	 * specifiquement, les ComboBox sur chaque onglet
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Pour la monnaie :
		MOcboU1.setItems(MOliste);// Mettre les differents unites dans le ComboBox a gauche
		MOcboU2.setItems(MOliste);// Mettre les differents unites dans le ComboBox a droite
		// Pour les deux ComboBox, faire que le selection par defaut soit le premier
		// element dans le liste.
		MOcboU1.getSelectionModel().selectFirst();
		MOcboU2.getSelectionModel().selectFirst();

		// Meme chose pour la masse:
		McboU1.setItems(Mliste);
		McboU2.setItems(Mliste);
		McboU1.getSelectionModel().selectFirst();
		McboU2.getSelectionModel().selectFirst();

		// Meme chose pour le temps:
		TcboU1.setItems(Tliste);
		TcboU2.setItems(Tliste);
		TcboU1.getSelectionModel().selectFirst();
		TcboU2.getSelectionModel().selectFirst();

		// Meme chose pour la longueur:
		LcboU1.setItems(Lliste);
		LcboU2.setItems(Lliste);
		LcboU1.getSelectionModel().selectFirst();
		LcboU2.getSelectionModel().selectFirst();

		// Meme chose pour la quantite de matiere:
		QcboU1.setItems(Qliste);
		QcboU2.setItems(Qliste);
		QcboU1.getSelectionModel().selectFirst();
		QcboU2.getSelectionModel().selectFirst();
	}

	// Methodes de conversions specifiques: deux methode chaque type d'unite (une
	// pour chaque "direction").

	// Methodes de conversion de quantite de matiere

	/**
	 * Methode qui convertit l'unite dans le TextField a gauche et met la valeur
	 * converti dans le TextField a droite.
	 */
	@FXML
	public void QU1U2() {
		Convertir(QtxtU1, QtxtU2, QcboU1, QcboU2, Qfacteur);
	}

	/**
	 * Methode qui convertit l'unite dans le TextField a droite et met la valeur
	 * converti dans le TextField a gauche.
	 */
	@FXML
	public void QU2U1() {
		Convertir(QtxtU2, QtxtU1, QcboU2, QcboU1, Qfacteur);
	}

	// Methodes de conversion de monnaie

	/**
	 * Methode qui convertit l'unite dans le TextField a gauche et met la valeur
	 * converti dans le TextField a droite.
	 */
	@FXML
	public void MOU1U2() {
		Convertir(MOtxtU1, MOtxtU2, MOcboU1, MOcboU2, MOfacteur);
	}

	/**
	 * Methode qui convertit l'unite dans le TextField a droite et met la valeur
	 * converti dans le TextField a gauche.
	 */
	@FXML
	public void MOU2U1() {
		Convertir(MOtxtU2, MOtxtU1, MOcboU2, MOcboU1, MOfacteur);
	}

	// Methodes de conversion de temps

	/**
	 * Methode qui convertit l'unite dans le TextField a gauche et met la valeur
	 * converti dans le TextField a droite.
	 */
	@FXML
	public void TU1U2() {
		Convertir(TtxtU1, TtxtU2, TcboU1, TcboU2, Tfacteur);
	}

	/**
	 * Methode qui convertit l'unite dans le TextField a droite et met la valeur
	 * converti dans le TextField a gauche.
	 */
	@FXML
	public void TU2U1() {
		Convertir(TtxtU2, TtxtU1, TcboU2, TcboU1, Tfacteur);
	}

	// Methodes de conversion de longueur

	/**
	 * Methode qui convertit l'unite dans le TextField a gauche et met la valeur
	 * converti dans le TextField a droite.
	 */
	@FXML
	public void LU1U2() {
		Convertir(LtxtU1, LtxtU2, LcboU1, LcboU2, Lfacteur);
	}

	/**
	 * Methode qui convertit l'unite dans le TextField a droite et met la valeur
	 * converti dans le TextField a gauche.
	 */
	@FXML
	public void LU2U1() {
		Convertir(LtxtU2, LtxtU1, LcboU2, LcboU1, Lfacteur);
	}
	// Methodes de conversion de masse

	/**
	 * Methode qui convertit l'unite dans le TextField a gauche et met la valeur
	 * converti dans le TextField a droite.
	 */
	@FXML
	public void MU1U2() {
		Convertir(MtxtU1, MtxtU2, McboU1, McboU2, Mfacteur);
	}

	/**
	 * Methode qui convertit l'unite dans le TextField a droite et met la valeur
	 * converti dans le TextField a gauche.
	 */
	@FXML
	public void MU2U1() {
		Convertir(MtxtU2, MtxtU1, McboU2, McboU1, Mfacteur);
	}

	/**
	 * Methode qui verifie si le contenu d'un TextField (txt) est valide. Si c'est
	 * vide, un "0" est mis dans le TextField. Si quelque-chose qui n'est pas un
	 * chiffe est mise, c'est enleve.
	 * 
	 * @param txt c'est le TextField en question: on veut valider le text dans le
	 *            TextField txt.
	 */
	@FXML
	public void verifier(TextField txt) {
		if (txt.getText().isEmpty()) {// Si c'est vide
			txt.setText("0");// Mettre "0"
		}
		txt.textProperty().addListener((observable, oldValue, newValue) -> {// Creer un Listener pour le TextField txt
			if (!newValue.matches("^[0-9](\\.[0-9]+)?$+")) {// Si txt contient quelque-chose qui n'est pas un chiffre
				txt.setText(newValue.replaceAll("[^\\d*\\.]", ""));// On enleve (c'est a dire, remplacer pas "") tous
																	// les caracteres qui ne sont pas des chiffres.
			}
		});
	}

	/**
	 * Methode generale pour convertir - la methode convertit la valeur qui se
	 * trouve dans txtU1 (qui est en unite specifie dans le ComboBox cboU1), en
	 * valeur qui est en unite specifie dans le ComboBox cboU2, et met la valeur
	 * converti dans le TextField txtU2.
	 * 
	 * @param txtU1   c'est le premier text field (on extrait la valeur d'ici)
	 * @param txtU2   c'est la deuxieme text field (on met la valeur converti ici)
	 * @param cboU1   c'est le ComboBox qui nous specifie l'unite de la valeur dans
	 *                txtU1
	 * @param cboU2   c'est le ComboBox qui nous specifie l'unite de la valeur dans
	 *                txtU2
	 * @param facteur c'est le tableau contenant les facteurs de conversion pour
	 *                l'unite qu'on convertit.
	 */
	@FXML
	public void Convertir(TextField txtU1, TextField txtU2, ComboBox cboU1, ComboBox cboU2, double facteur[]) {
		verifier(txtU1);// Avant de convertir, s'assurer qu'il y a que des nombres dans le textField
		int item1 = cboU1.getSelectionModel().getSelectedIndex();// Trouver l'indexe de l'unite choisi dans cboU1.
		int item2 = cboU2.getSelectionModel().getSelectedIndex();// Trouver l'indexe de l'unite choisi dans cboU2.
		double taux = facteur[item1] / facteur[item2];// Trouver le taux de conversion a l'aide du tableau facteur
		double res = taux * (Double.parseDouble(txtU1.getText()));// Trouver le resultat
		txtU2.setText(String.format("%.4f", res));// Mettre le resultat dans txtU2, avec 4 chiffres apres le decimal.
	}


}
