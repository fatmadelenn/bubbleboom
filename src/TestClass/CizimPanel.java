package TestClass;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Classlar.Balon;
import Classlar.Cizdir;
import Classlar.StartFrame;

public class CizimPanel extends JPanel implements MouseListener {
	public static int mx,my;
		Cizdir ciz =new Cizdir(TestClass.level);
		JLabel sure,puan=new JLabel();
		Timer kronometre;
		JLabel lb;
		ImageIcon icon;
		TestClass t; CizimPanel() {
			addMouseListener(this);
			setLayout(null);
			setBounds(0,0,800,600);
			icon=new ImageIcon("..\\deneme.jpg");
			lb=new JLabel(icon);
			lb.setBounds(0, 0, 800, 600);
			add(lb);
			puan.setText(String.valueOf(ciz.puan));
			puan.setBounds(100, 10, 250, 25);
			add(puan);
			
			setVisible(true);	
		}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ciz.cizim(g);
		ciz.kesisim(mx,my);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		puan.setText(String.valueOf("Puanýnýz: "+Balon.puan2));
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mx=e.getX();
		my=e.getY();
	}
	
}
