
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.java2d.pipe.DrawImage;

public class Map extends JPanel implements ActionListener {
	
	private static final int EASY = 3;
	private static final int MEDIUM = 5;
	private static final int HARD = 10;
	private static final int DELAY = 20;
	private int delay=0;

	private static final long serialVersionUID = -512764079348436390L;
	private final int SPACESHIP_X = 220;
    private final int SPACESHIP_Y = 430;
    private final Timer timer_map;

    private final Image background;
    private final Spaceship spaceship;
    private ArrayList<Alien> alien;
    private int difficulty;

    public Map() {
        
        addKeyListener(new KeyListerner());
        
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon image = new ImageIcon("images/space.jpg");
        
        this.background = image.getImage();
        
        difficulty = EASY;

        spaceship = new Spaceship(SPACESHIP_X, SPACESHIP_Y);
        alien = new ArrayList<Alien>();
        

        timer_map = new Timer(Game.getDelay(), this);
        timer_map.start();
                            
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        g.drawImage(this.background, 0, 0, null);
        
        drawSpaceship(g);
        
        drawAlien(g);
        

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawAlien(Graphics g) {
		
		for(Alien alien : alien){
			g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
		}
	}

	private void drawSpaceship(Graphics g) {
               
        // Draw spaceship
        g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);
        for(Missile mis: spaceship.getMissile()){
        	g.drawImage(mis.getImage(), mis.getX(), mis.getY(), this);
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	spaceshipColide();
    	alienColide();
    	
        updateSpaceship();
        updateAlien();

        if(delay==DELAY){
        	generateAlien();        	
            delay=0;
        }
        else{	
        	++delay;
        }
        
        
        repaint();
    }
    

	private synchronized void spaceshipColide() {
		Rectangle spaceShip = spaceship.getBounds();
		for(int i=0;i<alien.size();++i){
			Rectangle mob = alien.get(i).getBounds();
			if(spaceShip.intersects(mob))
				alien.get(i).setVisible(false);
		}
			
	}

	private synchronized void alienColide() {
		ArrayList<Missile> missile = spaceship.getMissile();
		for(int i=0;i<alien.size();++i){
			Rectangle mob = alien.get(i).getBounds();
			for(int j=0; j< missile.size();++j){
				Rectangle mis = missile.get(j).getBounds();
				if(mob.intersects(mis)){
					alien.get(i).setVisible(false);
					missile.get(j).setVisible(false);
				}
			}
		}
		spaceship.removeMissile();
		
	}

	private synchronized void updateAlien() {
		
		
		for(int i=0;i<alien.size();++i){
			
			if(alien.get(i).getY() >Game.getHeight() || !alien.get(i).isVisible()){
				alien.remove(i);
			}
			else
				alien.get(i).update();
		}
	}

	private synchronized void generateAlien() {
		Random randomAlien = new Random();
		int[] aliensXPosition = new int[difficulty];
		
		for(int i=0;i<difficulty;++i){
			int mableX = randomAlien.nextInt(Game.getWidth());
			for(int j=0; j<i;++j){
				if(mableX == aliensXPosition[j]) {//need to change
					mableX = randomAlien.nextInt(Game.getWidth());
					j=-1;
				}
			}
			aliensXPosition[i]=mableX;
		}
		
		for (int i = 0; i < aliensXPosition.length; i++) {
			alien.add(new Alien(aliensXPosition[i], 0));
		}

	}

	private void dranMissionAccomplished(Graphics g) {

        String message = "MISSION ACCOMPLISHED";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Game.getWidth() - metric.stringWidth(message)) / 2, Game.getHeight() / 2);
    }
    
    private void drawGameOver(Graphics g) {

        String message = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metric = getFontMetrics(font);

        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(message, (Game.getWidth() - metric.stringWidth(message)) / 2, Game.getHeight() / 2);
    }
    
    private synchronized void updateSpaceship() {
        spaceship.move();
        spaceship.updateMissile();
    }
  

    private class KeyListerner extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        
    }
}