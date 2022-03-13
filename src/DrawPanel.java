import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JComponent implements MouseMotionListener, MouseListener {
    private InfoPanel info;
    private gLine[] lines = new gLine[100];
    private int cLines=0;
    private int x1,y1;

    public DrawPanel(InfoPanel info) {
        super();
        setPreferredSize(new Dimension(Main.width - 270, Main.height - 20));
        this.info = info;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        gInitialize(g);

        for(int i=0;i<cLines;i++){
            g.setColor(lines[i].color);
            g.drawLine(lines[i].x1,lines[i].y1,lines[i].x2,lines[i].y2);
        }
    }

    private void gInitialize(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);

        g.setColor(Color.red);
        g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        info.setInfo("(x,y) : ("+mouseEvent.getX()+","+mouseEvent.getY()+")",0);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        info.setInfo("(x,y) : ("+mouseEvent.getX()+","+mouseEvent.getY()+")",0);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        info.setInfo("(x1,y1) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 1);
        x1=mouseEvent.getX();
        y1 = mouseEvent.getY();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        info.setInfo("(x2,y2) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 2);
        gLine a =new gLine();
        a.x1=x1;
        a.y1 = y1;
        a.x2= mouseEvent.getX();
        a.y2 = mouseEvent.getY();
        a.color=new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
        lines[cLines++] = a;

        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
