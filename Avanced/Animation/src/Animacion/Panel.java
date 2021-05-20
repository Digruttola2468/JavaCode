package Animacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{

	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	
	Image enemy;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 5;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	Panel(){
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.BLACK);
		
		enemy = new ImageIcon("src/Animacion/Pelota.png").getImage();
		timer = new Timer(10, this);
		timer.start();
		
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics g2D = (Graphics) g;
		g2D.drawImage( enemy, x, y , null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			//		Ejemplo de moverce por X
		if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		repaint();
		
		
		if(y>=PANEL_WIDTH-enemy.getHeight(null) || y<0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		repaint();
	}
	
}
