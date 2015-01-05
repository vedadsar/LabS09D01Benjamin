
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.awt.RepaintArea;

import com.sun.net.ssl.internal.www.protocol.https.Handler;


public class GUIBinaryGame extends JFrame {
	//Dodao sam staticke metoda da ih mogu koristiti u citavoj klasi
	private static JButton lower;
	private static JButton correct;
	private static JButton higher;
	private static JTextField text;
	private static JLabel textCounter;
	private static int [] array = new int [10000];
	private static int startPosition;
	private static int endPosition;
	private static int middleIndex;
	private static int counter;
	private static JFrame window;
	private static JButton restart;
	
	
	
	/**
	 * Main metoda u kojoj iscrtavamo nas okvir, dugmad i tekst.
	 * @param args
	 */
	public static void main(String[] args) {
	 window = new JFrame("Guess game");
	
	for(int i=0;i< 10000; i++){
		array[i]=i+1;
	}
	
	counter = 1; //Brojac pokusaja
	startPosition = 0;	//Postavljamo pocetnu poziciju na pocetku
	endPosition = array.length - 1;	//Postavljamo krajnju poziciju na pocetku
	middleIndex = (startPosition + endPosition) / 2;	//Srednji clan niza
	
		
	lower = new JButton("Lower");			//Lower dugme, klikamo ukoliko je nas broj manji od pokusaja racunara
	correct = new JButton("Correct");		// Ukoliko je racunar pogodio nas broj
	higher = new JButton("Higher");		//Higher dugme klikamo ukoliko je nas broj veci od pokusjaa racunara
	restart = new JButton("Restart");
	
	textCounter = new JLabel("Guesses: " +counter);
	textCounter.setFont(new Font("Arial", Font.ITALIC, 28));
	

	
	text = new JTextField("Is this your number " +middleIndex +"? ");		//Postavljamo text 
	text.setEnabled(false);					//Stavljamo da se tekst ne moze editovati od korisnika
	text.setHorizontalAlignment(JTextField.CENTER);
	text.setBackground(Color.darkGray);
	text.setFont(new Font("Arial", Font.BOLD,35));
	
	
	
	window.setLayout(new FlowLayout());	
	window.add(text);
	window.add(lower);
	window.add(higher);
	window.add(correct);
	window.add(restart);
	window.add(textCounter);
	
	window.setSize(450, 150);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setLocation(500, 500);
	window.setVisible(true);

	
	ButtonHandler  handler = new ButtonHandler(); 	//Kreiramo novi Buttonhandler.
	//Dodajemo actionListenere ( Handlere)
	lower.addActionListener(handler);				
	correct.addActionListener(handler);
	higher.addActionListener(handler);
	restart.addActionListener(handler);
	

	
}
		
	public static void restart(){
		window.dispose();
		main(null);
		
		
	}
	
	
	/**
	 * Staticka klasa ButtonHandler preko koje cemo kontrolisati akcije koje uslijede nakon klika misem. 
	 * Naslijedjuje ActionListener
	 * @author vedadzornic
	 *
	 */
	public static class ButtonHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Uslov ukoliko je kliknuto dugme lower
			if(e.getSource().equals(lower)){
				counter++;
				endPosition = middleIndex - 1;
				middleIndex = (startPosition + endPosition) / 2;
			    text.setText("Is this your number " +middleIndex +"?" );
			    textCounter.setText("Guesses " +counter);
									
			}
			//Uslov ukoliko je kliknuto dugme higher
			if(e.getSource().equals(higher)){
				counter++;
				startPosition = middleIndex + 1;
				middleIndex = (startPosition + endPosition) / 2;
			    text.setText("Is this your number " +middleIndex +"? ");
			    textCounter.setText("Guesses " +counter);
									
			}
			//Ukoliko je kliknuto dugme correct.
			if(e.getSource() == correct){
			text.setText("Thats the number :)");
			
			
			
			}
			
			//Ukoliko je kliknuto dugme correct.
			if(e.getSource() == restart){
			text.setText("Restarting...");
				restart();
			}
		}
	}
	
}



