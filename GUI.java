package game;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GUI extends JFrame implements ActionListener {
	
	JButton Bestätigen; 	//Zug ausführen
	JButton Neu;			//neues Spiel
	JLabel GewinnerLabel;
	JLabel Anweisung;       //drückt aus was zu tun ist
	JLabel WerIstDran;
	JTextField Eingabe; 	//Angabe des Zugs (in welches Feld gestzt wird)
	JTextArea Spiel;
	JPanel HilfsPanel;
	
	
	public GUI() {
		
		this.setTitle("TicTacToe");
		this.setSize(1920, 1080);
		Font Schrift = new Font("etwas", 5, 25);
		Font ÜberSchrift = new Font("etwas", 2, 30);
		Font SiegesSchrift = new Font("etwas", 3, 25);
		
		JPanel Panel = new JPanel();
		
		Spiel = new JTextArea();
		Spiel.setFont(Schrift);
		JLabel Beschreibung = new JLabel();
		Anweisung = new JLabel("Gib das Feld an in das du setzen möchtest(1-9): ");
		GewinnerLabel = new JLabel();
		WerIstDran = new JLabel();
		WerIstDran.setText(Backend.getPlayer());
		WerIstDran.setForeground(Color.red);
		
		Eingabe = new JTextField(10);
		
		Bestätigen = new JButton("Bestätigen");
		Neu = new JButton("Neues Spiel");
		
		Bestätigen.addActionListener(this);
		Neu.addActionListener(this);
		
		Beschreibung.setText("<html><body><center>Dies ist das klassische Spiel TicTacToe. <br>Nacheinander wählt ihr das Feld (1-9) aus in das ihr euer Zeichen setzen möchtet <br>"
				+ "wer horizontal, vertikal oder diagonal drei seiner Zeichen in eine Reihe bringen kann hat gewonnen. <br>Um zu beginnen auf \"Neues Spiel\" drücken <br>"
				+ "ein Feld auswählen (eine Zahl zwischen 1 und 9 schreiben) und danach auf \"Bestätigen\" drücken.</center></body></html>");
		
		Beschreibung.setFont(ÜberSchrift);
		Anweisung.setFont(Schrift);
		GewinnerLabel.setFont(SiegesSchrift);
		GewinnerLabel.setForeground(Color.MAGENTA);
		Bestätigen.setFont(Schrift);
		Neu.setFont(Schrift);
		Eingabe.setFont(Schrift);
		WerIstDran.setFont(Schrift);
		
		Panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.EAST;
		
		c.gridx = 1;
		c.gridy = 0;
		Panel.add(Beschreibung, c);
		
		c.gridx = 1;
		c.gridy = 1;
//		JLabel LückenBüßer = new JLabel();
//		LückenBüßer.setText("<html><body><br><br></body></html>");
		Panel.add(new JLabel("<html><body><br><br></body></html>"), c);
		
		c.gridx = 1;
		c.gridy = 2;
		Panel.add(WerIstDran,c);
		
		c.gridx = 1;
		c.gridy = 3;
		Panel.add(Anweisung,c);
		
		HilfsPanel = new JPanel();
		//HilfsPanel.add(Anweisung);
		HilfsPanel.add(Eingabe);
		HilfsPanel.add(Bestätigen);
		
		c.gridx = 1;
		c.gridy = 4;
		Panel.add(HilfsPanel, c);
		Panel.add(GewinnerLabel,c);
		
		c.gridx = 1;
		c.gridy = 5;
		Panel.add(Spiel, c);
		
		c.gridx = 1;
		c.gridy = 6;
		Panel.add(Neu, c);
		
		this.add(Panel);
		pack();
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Bestätigen) {
			try {
				int Feld = Integer.parseInt(Eingabe.getText());
				if(Feld > 0 && Feld <10) {
					if(Backend.prüfeGültigkeit(Feld)) {
						Backend.setzen(Feld);
						Spiel.setText("");
						Spiel.setText(Backend.zeigen());
						if(Backend.getWin()) {
							if(Backend.getWinner() == 'X') {
								GewinnerLabel.setText("Spieler 2 (X) hat gewonnen");
								HilfsPanel.setVisible(false);
								WerIstDran.setVisible(false);
								GewinnerLabel.setVisible(true);
							}else if(Backend.getWinner() == 'O') {
								GewinnerLabel.setText("Spieler 1 (O) hat gewonnen");
								WerIstDran.setVisible(false);
								HilfsPanel.setVisible(false);
								GewinnerLabel.setVisible(true);
							}else if(Backend.getWinner() == 'U') {
								GewinnerLabel.setText("Unentschieden");
								WerIstDran.setVisible(false);
								HilfsPanel.setVisible(false);
								GewinnerLabel.setVisible(true);
							}
						}//Ende if getWin()
						Backend.setRunde();
						WerIstDran.setText(Backend.getPlayer());
					}//Ende innere Bedingung
				}//Ende äußere Bedingung	
			}//Ende try
			catch(Exception e){
				Eingabe.setText("Falsche Eingabe");
			}
			
		}else if (ae.getSource() == Neu) {
			Backend.parametrieren();
			Backend.kopieren();
			Spiel.setText("");
			GewinnerLabel.setVisible(false);
			WerIstDran.setVisible(true);
			HilfsPanel.setVisible(true);
			Backend.setRundeToBegin();
			
		}
		
	}
	
	
}
