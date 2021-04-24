package prog2.gui.textanalyse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

import javax.swing.JOptionPane;

public class ClickButtonListener implements ActionListener {
	private String index;


	public ClickButtonListener(int i) {
		// Index des foor Loops wird übergeben. Umwandlung in String.
		index = String.valueOf(i);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.addNumbers(index);
		} catch (IllegalArgumentException e1) {
			int option = JOptionPane.showConfirmDialog(null, e1.getMessage() + "Ziffernfolge darf nicht größer als 21 sein!");
			if(option == JOptionPane.OK_OPTION)
				TextAnalyse.result.setText("");
				TextAnalyse.nums = "";
		}
 }

	protected String addNumbers(String index) {
		if (TextAnalyse.nums.length() < TextAnalyse.maxLength) {
			TextAnalyse.nums = TextAnalyse.nums + index;
			TextAnalyse.result.setText(TextAnalyse.nums);
		} else {
			throw new IllegalArgumentException("Fehler: ");
		}
	return TextAnalyse.nums;
	}

	public String getIndex() {
		return index;
	}
	
}
