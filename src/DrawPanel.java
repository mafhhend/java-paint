import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JComponent implements MouseMotionListener, MouseListener {
    private InfoPanel info;
    private PENS PPP[] = new PENS[100];
    private int cPPP=0;
    private int ShapeType = ShapeTools.Line;
    private gLine lines[]=new gLine[1000];
    private int cLinesAll = 0;
    private int cLines=0;
    private int x1, y1;

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

        for (int i = 0; i < cLines; i++) {
            g.setColor(lines[i].color);
            if (lines[i].ShapeType == ShapeTools.Line)
                g.drawLine(lines[i].x1, lines[i].y1, lines[i].x2, lines[i].y2);

            if (lines[i].ShapeType == ShapeTools.Rect)
                g.fillRect(lines[i].x1, lines[i].y1, lines[i].x2 - lines[i].x1, lines[i].y2 - lines[i].y1);

            if (lines[i].ShapeType == ShapeTools.Oval)
                g.fillOval(lines[i].x1, lines[i].y1, lines[i].x2 - lines[i].x1, lines[i].y2 - lines[i].y1);

        }
        for(int k=0;k<cPPP;k++){

            for (int i = 0; i < PPP[k].cPENS -1; i++) {
                g.drawLine(PPP[k].PENS[i].x, PPP[k].PENS[i].y, PPP[k].PENS[i + 1].x, PPP[k].PENS[i + 1].y);
            }
        }
    }

    public void SetShapeTools(int tNo) {
        this.ShapeType = tNo;
    }

    public void Clear() {
        cLines = 0;
        repaint();
    }

    public void ClearLast() {
        if (cLines > 0) cLines--;
        repaint();
    }

    public void UndoClear() {
        cLines = cLinesAll;
        repaint();
    }

    public void UndoLast() {
        if (cLines < cLinesAll) cLines++;
        repaint();
    }


    private void gInitialize(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);

        g.setColor(Color.red);
        g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        info.setInfo("(x,y) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 0);


        if (ShapeType == ShapeTools.Pencil) {
            PPP[cPPP].PENS[PPP[cPPP].cPENS++] = new Point(mouseEvent.getX(), mouseEvent.getY());
        }
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        info.setInfo("(x,y) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 0);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        info.setInfo("(x1,y1) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 1);
        x1 = mouseEvent.getX();
        y1 = mouseEvent.getY();

        if (ShapeType == ShapeTools.Pencil) {
            PPP[cPPP]=new PENS();
            PPP[cPPP].cPENS = 0;
            PPP[cPPP].PENS[PPP[cPPP].cPENS++] = new Point(x1, y1);
            cPPP++;
        }
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        info.setInfo("(x2,y2) : (" + mouseEvent.getX() + "," + mouseEvent.getY() + ")", 2);
        gLine a = new gLine();
        a.x1 = x1;
        a.y1 = y1;
        a.x2 = mouseEvent.getX();
        a.y2 = mouseEvent.getY();
        a.color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        a.ShapeType = this.ShapeType;
        lines[cLines++] = a;
        cLinesAll++;
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
