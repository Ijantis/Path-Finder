package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * 
 * @author philip
 * 
 *         Button Area at the bottom with start stop of simulation. Label/input
 *         data area on the right for changing enviroment variables and
 *         outputting data.
 * 
 */
public class ArrangeGui {

	JPanel mainPanel;
	JSplitPane splitPane;

	protected ArrangeGui(GuiMain guiMain) {

		mainPanel = new JPanel(new GridLayout(20, 1));
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.add(mainPanel);
		guiMain.add(splitPane);

		createMapArea();
		createResetButton();
		createFindPathButton();

	}

	private void createFindPathButton() {

		JButton findPath = new JButton("Find Path");
		findPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiMain.mapDisplay.findPath();
			}
		});

		mainPanel.add(findPath);

	}

	private void createResetButton() {

		JButton resetButton = new JButton("Reset");

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MapDisplay.data.reset();
				GuiMain.mapDisplay.repaint();

			}
		});

		mainPanel.add(resetButton);

	}

	private void createMapArea() {
		splitPane.add(GuiMain.mapDisplay);

	}

	@SuppressWarnings({ "unused" })
	private ArrangeGui() {

	}

}
