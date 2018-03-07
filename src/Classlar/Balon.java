package Classlar;

import javax.swing.ImageIcon;

public class Balon extends Cisim {

	public static int puan2=0;
	public Balon() {
		// TODO Auto-generated constructor stub
		icon=new ImageIcon(getClass().getResource("..\\balon.png"));
		image=icon.getImage();
		puan=rnd.nextInt(80)+20;
		
	}
	/*
	public int getPuan() {
		return puan;
	}
	public void setPuan(int puan) {
		this.puan = puan;
	}
	public Balon() {
		puan=rnd.nextInt(20)+80;
	}*/
	
	public int puanHesapla(int puan){
		return puan2=puan2+puan;
	}
}
