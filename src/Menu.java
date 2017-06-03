import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	JButton buttonOut, buttonStart, buttonScore;
	LayoutManager grid = new GridLayout(3,1);
	public Menu() {
		this.setLayout(grid);
		buttonOut = new JButton("Out");
		buttonStart = new JButton("Start");
		buttonScore = new JButton("Score");
		add(buttonStart);
		add(buttonScore);
		add(buttonOut);

	}
}
