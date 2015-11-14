package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import pathfinding.FindPath;

import map.Cell;
import map.Grid;

@SuppressWarnings("serial")
public class MapDisplay extends JPanel implements MouseListener, MouseMotionListener {

	protected static Grid data;
	protected static int currentCellEdit = Cell.Obstacle;
	public static final int drawingScale = 10;

	public MapDisplay() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {

		for (int x = 0; x < data.getWidth(); x++) {
			for (int y = 0; y < data.getHeight(); y++) {
				if (Grid.getCellValue(x, y) == Cell.Free) {
					g.setColor(Color.white);
					g.fillRect(x * drawingScale, y * drawingScale, drawingScale, drawingScale);

				} else if (Grid.getCellValue(x, y) == Cell.Path) {
					g.setColor(Color.red);
					g.fillRect(x * drawingScale, y * drawingScale, drawingScale, drawingScale);
				} else {
					g.setColor(Color.black);
					g.fillRect(x * drawingScale, y * drawingScale, drawingScale, drawingScale);
				}
			}
		}

		g.setColor(Color.gray);
		for (int x = 0; x < data.getWidth(); x++) {
			for (int y = 0; y < data.getHeight(); y++) {
				g.drawRect(x * drawingScale, y * drawingScale, drawingScale, drawingScale);
			}
		}

	}

	public void updateMap(Grid data) {
		MapDisplay.data = data;
		this.repaint();
	}

	public void findPath() {
		Grid.clearPathCells();
		new FindPath(0, 0, 99, 99, data);
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (arg0.getButton() == 1) {
			currentCellEdit = Cell.Obstacle;
		} else {
			currentCellEdit = Cell.Free;
		}

		Grid.setCellValue(arg0.getX() / drawingScale, arg0.getY() / drawingScale, currentCellEdit);
		this.repaint();
		System.out.println(arg0.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if (arg0.getButton() == 3) {
			currentCellEdit = Cell.Free;
		} else if (arg0.getButton() == 1) {
			currentCellEdit = Cell.Obstacle;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getButton() == 3) {
			currentCellEdit = Cell.Obstacle;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

		Grid.setCellValue(arg0.getX() / drawingScale, arg0.getY() / drawingScale, currentCellEdit);
		this.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public int getDrawingScale() {
		return drawingScale;
	}

}
