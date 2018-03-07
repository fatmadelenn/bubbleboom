package TestClass;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Classlar.Balon;
import Classlar.Cizdir;
import Classlar.StartFrame;

public class TestClass extends JFrame{
	ImageIcon icon;
	Cizdir ciz;
	JLabel lbl;
	JPanel bgpanel;
	JLabel sure,canLabel;
	Timer kronometre;
	public static int sayac=60;
	public static int level=1;
	CizimPanel C =new CizimPanel();
	public TestClass() {
		
		setTitle("Baloncuk Patlat");
		setSize(800, 600);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		sure=new JLabel("");
		sure.setBounds(350, 10, 250, 25);
		canLabel=new JLabel("Can Durumu: ");
		canLabel.setBounds(550, 10, 200, 25);
		C.setBounds(0, 0,800, 600);
		C.add(sure);
		C.add(canLabel);
		setLocationRelativeTo(null);
		setResizable(false);
		add(C);
		setVisible(true);
		geriSayim();
		
	}
	private void geriSayim() {
		kronometre=new Timer();
		TimerTask gorev=new TimerTask() {
			
			
			@Override
			public void run() {
				sayac--;
				if (sayac==0) {
					sayac=60;
				kronometre.cancel();
				if (Balon.puan2>2500) {
					
				if (Balon.puan2>5000) {
						level=3;
						dispose();
						new TestClass();
				}
				else {
					level=2;
					dispose();
					new TestClass();
				}
					
				}
				
				}
				sure.setText(String.valueOf("Kalan Süreniz: "+sayac));
			}
		};
		kronometre.schedule(gorev, 0,1000);

	}
	
	
       public static void main(String[] args) {
	
      	new  TestClass();
     }
}
