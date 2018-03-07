package Classlar;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public class Cisim {
	
	private Point konum;
	private int  hizy;
	Random rnd;
	protected  int puan;
	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	protected boolean canDurumu;
	protected ImageIcon icon;
	protected  Image image;
	public boolean isCanDurumu() {
		return canDurumu;
	}


	public void setCanDurumu(boolean canDurumu) {
		this.canDurumu = canDurumu;
	}


	public int getPuan() {
		return puan;
	}


	public void setPuan(int puan) {
		this.puan = puan;
	}


	public Cisim(){
		rnd=new Random();
		konum=new Point(rnd.nextInt(650)+10,rnd.nextInt(19000)+700);
		hizy=rnd.nextInt(2)+4;
		
	}
		
	
	public Point getKonum(){
		return konum;
	}
	public void setKonum(Point konum){
		this.konum=konum;
	}
	public int getHizy(){
		return hizy;
	}
	public void setHizy(int hizy){
		this.hizy=hizy;
	}
}
	

