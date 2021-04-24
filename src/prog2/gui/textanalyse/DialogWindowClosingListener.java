package prog2.gui.textanalyse;

import java.awt.event.*;
import javax.swing.*;

public class DialogWindowClosingListener extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		int option = JOptionPane.showConfirmDialog(null,"Möchten Sie diese Applikation wirklich beenden?");
		if(option == JOptionPane.OK_OPTION)
			System.exit(0);	
	}
}
