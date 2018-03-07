package Classlar;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.ws.handler.MessageContext;

import TestClass.CizimPanel;

public class Cizdir  {
	//--------------------------------------------------------------------------------------------------
	ArrayList<Cisim> cisimler=new ArrayList<>();
	ArrayList<Can>canlar=new ArrayList<Can>();
	int level;
	Timer xKonumDegis;
	Rectangle rFare,rCisimler;
	Balon bln=new Balon();
	Can canResim;
	Random rnd=new Random();
	Timer timer=new Timer();
	Rectangle farex,rcisim;
	int x1,y1;
	int balonlar []={200,260,320,380,440,500};
	int y=0;
	public int puan=0;
	int silCan=2;
	//--------------------------------------------------------------------------------------------------
	public boolean durum=true;
	
		public Cizdir(int level) {
			
			
			// TODO Auto-generated constructor stub
			this.level=level;
			if (level==1) {
				
					ekle(500);
					konumDegis();
				
				
			}
			else if (level==2) {
				zamanlama();
			}
			else if (level==3) {
				
			}
			
			xKonumDegis=new Timer();
		
		}
		//--------------------------------------------------------------------------------------------------
		public void cizim(Graphics g) {
			
			for (int i = 0; i < cisimler.size(); i++) {
				if (level==1) {
					cisimler.get(i).getKonum().y-=cisimler.get(i).getHizy();
				}
				
				//g.drawOval( cisimler.get(i).getKonum().x, cisimler.get(i).getKonum().y,60,60);
				g.drawImage(cisimler.get(i).getImage(), cisimler.get(i).getKonum().x, cisimler.get(i).getKonum().y,70,70,null);
			}
			for (int i = 0; i < canlar.size(); i++) {
				g.drawImage(canlar.get(i).getImage(), canlar.get(i).getKonum().x, canlar.get(i).getKonum().y,30,30,null);
			}
			
		
		}
		//--------------------------------------------------------------------------------------------------
		public void kesisim(int mx, int my) {
			
			rFare=new Rectangle(mx,my,5,5);
			for (int i = 0; i < cisimler.size(); i++) {
				rCisimler=new Rectangle(cisimler.get(i).getKonum().x,cisimler.get(i).getKonum().y,60,60);
				if (rFare.intersects(rCisimler)) {
					
					if (!cisimler.get(i).canDurumu&&cisimler.get(i).getPuan()==0) {
						canlar.get(silCan).setImage(null);
						silCan--;
					}
					if (cisimler.get(i).canDurumu&&silCan<2) {
						silCan++;
						canResim=new Can();
						canlar.get(silCan).setImage(canResim.getImage());
						
					}
					int sayi=cisimler.get(i).getPuan();
					puan+=bln.puanHesapla(sayi);
					cisimler.remove(i);
					CizimPanel.mx=5000;
					CizimPanel.my=5000;
					
				}
				
			}

		}
		//--------------------------------------------------------------------------------------------------
		private void konumDegis() {
			xKonumDegis=new Timer();
			Random rnd=new Random();
			TimerTask gorev=new TimerTask() {
				
				@Override
				public void run() {
					for (int i = 0; i < cisimler.size(); i++) {
						cisimler.get(i).getKonum().x+=rnd.nextInt(60)-30;
					}
					
				}
			};
			xKonumDegis.schedule(gorev, 0,500);
		}	
		//--------------------------------------------------------------------------------------------------
		private void zamanlama() {
			
			
			TimerTask gorev=new TimerTask() {
				int rastgele;
				@Override
				
				public void run() {
					
					cisimler.clear();
					ekle(36);
					y=120;
					rnd=new Random();
					int indis=0;
					for (int satir = 0; satir < 5; satir++) {
						for (int sutun = 0; sutun < balonlar.length; sutun++) {
							cisimler.get(indis).getKonum().x=balonlar[sutun];
							cisimler.get(indis).getKonum().y=y;
							indis++;
							
						}
						y+=60;
						
					}
					
				}
			};
			timer.schedule(gorev, 0, 450);}
		//--------------------------------------------------------------------------------------------------
		private void ekle(int size) {
			int sayi=0;
			for(int j = 0; j <size; j++) {
				
				sayi=rnd.nextInt(30);
				if (sayi<15) {
					cisimler.add(new Balon());
				}
				else if (sayi>15&&sayi<18) {
					cisimler.add(new Can());
				}
				else if (sayi>26) {
					cisimler.add(new Canavar());
				}
				
				else {
					cisimler.add(new Balon());
				}
			}
			
			for (int i = 0; i <3; i++) {
				canlar.add(new Can());
			}
			int konumDuzenle=630;
			for (int i = 0; i < canlar.size(); i++) {
				
				canlar.get(i).getKonum().x=konumDuzenle;
				canlar.get(i).getKonum().y=10;
				konumDuzenle+=30;
			}

		}

}
