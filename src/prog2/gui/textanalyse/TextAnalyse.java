package prog2.gui.textanalyse;

import javax.swing.*;


import java.awt.*;


public class TextAnalyse {

	protected JButton[] buttons = new JButton[10];
	protected static JLabel result;
	protected static String nums = "";
	protected static int maxLength = 21;

	public TextAnalyse() {

		createWindow();

	}

	private void createWindow() {
		String eingabe = "Eingabefolge";
		// Grafischen Rahmen erzeugen
		JFrame window = new JFrame("Text Analyse");
		JPanel panel = new JPanel();
		ImageIcon icon = new ImageIcon("calc.png");
		ImageIcon sum = new ImageIcon("sum.png");
		ImageIcon arrow = new ImageIcon("arrow.png");
		JMenuBar menu = new JMenuBar();
		JMenu dateiMenu = new JMenu("File");
		JMenu dateiMenu2 = new JMenu("Edit");
		JMenu dateiMenu3 = new JMenu("Source");
		JMenuItem oeffnen = new JMenu("Öffnen");
		JMenuItem undo = new JMenu("Undo");

		window.setJMenuBar(menu);
		dateiMenu.add(oeffnen);
		dateiMenu2.add(undo);
		menu.add(dateiMenu);
		menu.add(dateiMenu2);
		menu.add(dateiMenu3);

		window.setIconImage(icon.getImage());
		window.add(panel);
		window.setSize(630, 900);

		window.setLocation(1000, 600);
		window.setLayout(null);//damit Panel Layout beschrieben werden kann
		// GUI Komponente instanzieren

		// resizing
		Image img1 = sum.getImage();
		Image resizedImage = img1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		Image img2 = arrow.getImage();
		Image resizedImage2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		sum = new ImageIcon(resizedImage);
		arrow = new ImageIcon(resizedImage2);
		// Eingabe Label erstellen
		JLabel label = new JLabel(eingabe, sum, JLabel.LEFT);
		result = new JLabel(nums, arrow, JLabel.CENTER);
		result.setVerticalTextPosition(JLabel.BOTTOM);
		result.setFont(new Font("MV Boli", Font.BOLD, 15));
		result.setForeground(Color.RED);
		// Eingabefolge wird relativ zum img an den bottom gesetzt

		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("MV Boli", Font.BOLD, 25));

		panel.setLayout(new GridLayout(0, 1));
		panel.setBackground(new Color(200, 255, 255));
		panel.add(label);
		panel.add(result);
		// Panel Container Start-Koordinaten im Window Container + Größe
		panel.setBounds(50, 50, 500, 700);
		panel.setBorder(BorderFactory.createBevelBorder(0));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(i + "");
			buttons[i].setBackground(Color.GRAY);
			buttons[i].setForeground(Color.YELLOW);

			panel.add(buttons[i]);
			// Übergabe des Index-Wertes an ClickButtonListener
			buttons[i].addActionListener(new ClickButtonListener(i));
		}

		// Fügt dem window einen addWindowListener hinzu.... eigene Klasse mit
		// Dialogfenster
		window.addWindowListener(new DialogWindowClosingListener());

		window.setVisible(true);

	}

}