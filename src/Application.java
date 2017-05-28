import java.awt.EventQueue;
import javax.swing.JFrame;


public class Application extends JFrame {

	private static final long serialVersionUID = -2517616123689799182L;

	public Application() {

        add(new Map());

        setSize(Game.getWidth(), Game.getHeight());

        setTitle("Space Combat Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application app = new Application();
                app.setVisible(true);
            }
        });
    }
}