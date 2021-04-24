package prog2.gui.pflegedoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import prog2.gui.textanalyse.DialogWindowClosingListener;

public class Pflegedoku {

	int frameSize = 800;
	int imgFileSize = frameSize / 5;

	protected JTextField textField;
	protected ArrayList<String> dokuListe;
	protected String[] massnahmen = { "Waschen", "Blutdruck meﬂen", "Medikamente geben", "Klient nicht angetroffen" };
	protected JComboBox<String> comboBox;
	protected JLabel list;
	// protected JTextArea testArea;
	protected JButton button1;
	protected JButton button2;
	protected String stringList = "";

	public Pflegedoku() {
		comboBox = new JComboBox<String>(massnahmen);

		
		JFrame window = new JFrame("Pflegedoku");
		window.setLayout(null);
		ImageIcon icon = new ImageIcon("cross.png");

		dokuListe = new ArrayList<String>();
		list = new JLabel();

		/**
		 * HEADER
		 */
		JPanel panelHeader = new JPanel();
		ImageIcon file = new ImageIcon("file.png");
		Image img1 = file.getImage();
		Image resizedImage1 = img1.getScaledInstance(imgFileSize, imgFileSize, Image.SCALE_SMOOTH);
		file = new ImageIcon(resizedImage1);
		JLabel header = new JLabel("<html><u>Pflege-Dokumentations-Assistent 1.0</u></html>", file, JLabel.CENTER);
		header.setFont(new Font("MONOSPACED", Font.BOLD, 28));
		header.setForeground(Color.WHITE);
		header.setVerticalAlignment(JLabel.TOP);
		header.setVerticalTextPosition(JLabel.CENTER);
		panelHeader.setBackground(Color.GRAY);
		panelHeader.setBounds(0, 0, 800, 200);
		panelHeader.add(header);

		/**
		 * MAIN-BODY
		 */
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GridLayout(4, 1));
		panelMain.setBackground(Color.lightGray);
		panelMain.setBounds(0, 200, 800, 300);

		JLabel heading = new JLabel("Bitte geben Sie die vollbrachten Maﬂnahmen ein oder w‰hlen Sie eine aus: ",
				JLabel.CENTER);
		heading.setFont(new Font("MONOSPACED", Font.ITALIC, 16));

		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());
		textFieldPanel.setBackground(Color.lightGray);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(350, 30));
		textField.setBackground(Color.WHITE);
		/**
		 * Lambda Ausdruck, welcher den Text, des textFields wieder zur¸ck setzt. Bei Enter-Click
		 */
		textField.addActionListener(e -> textField.setText(""));

		setupTextField();
		setupComboBox();

		// comboBox.addActionListener(this);
		comboBox.setPreferredSize(new Dimension(350, 30));
		comboBox.setBackground(Color.WHITE);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.lightGray);

		button1 = new JButton("Hinzuf¸gen");
		button1.setBackground(Color.WHITE);
		/**
		 * Lambda Ausdruck, welcher den Text, des textFields wieder zur¸ck setzt. Bei Button-Click
		 */
		button1.addActionListener(e -> textField.setText(""));

		setupButton();

		buttonPanel.add(button1);
		// buttonPanel.add(button2);
		panelMain.add(heading);
		textFieldPanel.add(textField);
		textFieldPanel.add(comboBox);
		panelMain.add(textFieldPanel);
		panelMain.add(buttonPanel);

		/**
		 * FOOTER
		 */
		
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new FlowLayout());
		JLabel summary = new JLabel("<html><u>Zusammenfassung der Patienten-Akte:</u></html>");
		summary.setForeground(Color.BLACK);
		summary.setHorizontalAlignment(JLabel.CENTER);
		summary.setFont(new Font("MONOSPACED", Font.BOLD, 22));
		summary.setVerticalAlignment(JLabel.TOP);
		panelFooter.add(summary);

		panelFooter.setBounds(0, 500, 800, 50);

		panelFooter.setBackground(Color.GRAY);

		/**
		 * DOKU-LISTE
		 */
		
		JPanel listPanel = new JPanel();
		listPanel.setBounds(0, 550, 800, 400);
		listPanel.setLayout(new GridLayout(1, 1));

		list.setForeground(Color.WHITE);
		list.setHorizontalAlignment(JLabel.LEFT);
		list.setVerticalAlignment(JLabel.TOP);
		list.setFont(new Font("MONOSPACED", Font.BOLD, 18));
		listPanel.setBackground(new Color(4, 84, 85));
		listPanel.add(list);

		window.setSize(frameSize, frameSize + 150);
		window.setLocation(1000, 600);
		window.setIconImage(icon.getImage());
		window.add(panelHeader);
		window.add(panelMain);
		window.add(panelFooter);
		window.add(listPanel);

		window.setResizable(false);
		window.addWindowListener(new DialogWindowClosingListener());
		window.setVisible(true);
		
	}

	private void setupButton() {
		button1.addActionListener(
				new BausteineHandler(textField, dokuListe, comboBox, list, stringList, button1, massnahmen));
	}

	private void setupTextField() {
		textField.addActionListener(
				new BausteineHandler(textField, dokuListe, comboBox, list, stringList, button1, massnahmen));
	}

	private void setupComboBox() {
		comboBox.addActionListener(
				new BausteineHandler(textField, dokuListe, comboBox, list, stringList, button1, massnahmen));
	}

}
