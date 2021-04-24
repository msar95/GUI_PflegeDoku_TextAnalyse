package prog2.gui.pflegedoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BausteineHandler implements ActionListener {
	private JTextField textField;
	protected ArrayList<String> dokuListe;
	private JComboBox<String> comboBox;
	private JLabel list;
	private String stringList = "";
	private JButton button1;
	protected String[] massnahmen;

	public BausteineHandler() {
		// Zum Testen erstellt
	}

	public BausteineHandler(JTextField textField, ArrayList<String> dokuListe, JComboBox<String> comboBox, JLabel list,
			String stringList, JButton button, String[] massnahmen) {

		this.comboBox = comboBox;
		this.massnahmen = massnahmen;
		this.textField = textField;
		this.list = list;
		this.dokuListe = dokuListe;
		this.stringList = stringList;
		this.button1 = button;
	}
	// Nicht Testbar, da abhängig von Event
	@Override
	public void actionPerformed(ActionEvent e) {
		// Eingabe über TextField mit Enter oder per Button
		if (e.getSource() == textField || e.getSource() == button1) {
			try {
				checkTextFieldSize();
				dokuListe.add(textField.getText());
				stringList = updateLabel(stringList);
				//JLabel den transfomierten String übergeben
				list.setText(stringList);
			} catch (IllegalArgumentException e2) {
				JOptionPane.showConfirmDialog(textField, e2.getMessage() + "Bitte mindestens 2 Zeichen eingeben!");
			}
			addToComboBox();
		}
		// ComboBox Eingabe
		if (e.getSource() == comboBox) {
			dokuListe.add(comboBox.getSelectedItem().toString());
			stringList = updateLabel(stringList);
			list.setText(stringList);
		}
	}

	// Verpackt dokuListe in einen String mit HTML -> sodass Auflistung resultiert
	protected String updateLabel(String stringList) {
		stringList = "<html>";
		for (int i = 0; i < dokuListe.size(); i++) {
			stringList += "<li>" + dokuListe.get(i) + "</li>";
		}
		stringList += "</html>";
		return stringList;
	}

	// Prüft ob Eingabe größer als 3 Zeichen
	// Nicht Testbar, da abhängig von User Eingabe
	private boolean checkTextFieldSize() {
		if (textField.getText().length() > 1) {
			return true;
		} else
			throw new IllegalArgumentException("Fehler: ");
	}
	//Nicht Testbar, da abhängig von User Eingabe
	private void addToComboBox() {
		try {
			checkForDuplicates();
			checkTextFieldSize(); 
			comboBox.addItem(textField.getText());
			} catch(IllegalArgumentException e2) {
				//keine Implementierung da Dialogfeld nicht notwendig wenn ComboBox schon befüllt wurde
		}
	}
	//Prüft ob textField Text schon in ComboBox als Item existiert! Verhindert Duplikate
	// Nicht Testbar, da abhängig von User Eingabe
	private boolean checkForDuplicates() {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (textField.getText().toString().equals(comboBox.getItemAt(i).toString())) {
				throw new IllegalArgumentException("Fehler: ");
			}
		}
		return true;
	}
}
