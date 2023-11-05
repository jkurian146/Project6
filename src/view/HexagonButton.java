package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class HexagonButton extends JButton {
  private Path2D hexagonShape;

  public HexagonButton() {
    setOpaque(false); // Make sure the button does not paint its background
    setBorderPainted(false);
    setContentAreaFilled(false);
    setFocusPainted(false);
    setPreferredSize(new Dimension(60, 60));
    hexagonShape = new Path2D.Float();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int[] xPoints = new int[6];
    int[] yPoints = new int[6];

    int size = Math.min(getWidth(), getHeight()) / 2;

    for (int i = 0; i < 6; i++) {
      xPoints[i] = (int) (getWidth() / 2 + size * Math.cos(Math.toRadians(i * 60 + 30)));
      yPoints[i] = (int) (getHeight() / 2 + size * Math.sin(Math.toRadians(i * 60 + 30)));
    }

    Polygon hexagon = new Polygon(xPoints, yPoints, 6);

    g.setColor(getBackground());
    g.fillPolygon(hexagon);
  }

  {
    setContentAreaFilled(false);
    setOpaque(false);
    setBorderPainted(false);
  }

  @Override
  public boolean contains(int x, int y) {
    return hexagonShape.contains(x, y);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Hexagon Buttons");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    for (int i = 0; i < 5; i++) {
      HexagonButton button = new HexagonButton();
      button.setBackground(Color.RED);
      frame.add(button);
    }

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
