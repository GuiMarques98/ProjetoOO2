import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Application{

	
	private JFrame app;

	public Application() {
		
		app = new JFrame();
		app.add(new Map());

		
		app.setSize(Game.getWidth(), Game.getHeight());

		app.setTitle("Space Combat Game");
		app.setResizable(false);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null);

    }
		
	
	public void start() {
		app.setVisible(true);
			
	}
	
	public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application app = new Application();
                app.start();
            }
        });
        Thread game = new Thread(new Sound("Space_Invaders.wav"));
        game.start();
    }


}