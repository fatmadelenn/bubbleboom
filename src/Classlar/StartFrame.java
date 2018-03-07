package Classlar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import TestClass.*;



public class StartFrame extends JFrame{
   JButton buton;
   CizimPanel p;
	public StartFrame() {
			// TODO Auto-generated constructor stub

			setSize(500,500);
			setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
			buton=new JButton("Basla");
			add(buton);	
			buton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new TestClass();
					dispose();
				}
			});
		}
}
