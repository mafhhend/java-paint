import javax.swing.*;
import java.awt.*;

public class ToolBox extends JPanel {
    JButton btns[]=new JButton[100];
    public ToolBox() {
        super();
        setOpaque(true);
        setBackground(Color.yellow);
        setPreferredSize(new Dimension(100, Main.height));


        for(int i=0;i<10;i++)
        {
            btns[i]=new JButton();
            btns[i].setFont(new Font("tahoma", 1, 12));
            btns[i].setPreferredSize(new Dimension(95,30));
            btns[i].setOpaque(true);
            btns[i].setBackground(Color.red);
        }
        btns[0].setText("Line");
        this.add(btns[0]);

        btns[1].setText("React");
        this.add(btns[1]);

    }
}
