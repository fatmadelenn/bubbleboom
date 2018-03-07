package Classlar;

import javax.swing.ImageIcon;

public class Can extends Cisim {
		public Can() {
			icon=new ImageIcon(getClass().getResource("..\\can.png"));
			image=icon.getImage();
			canDurumu=true;
		}
}
