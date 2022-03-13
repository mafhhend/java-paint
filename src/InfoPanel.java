import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel infos[];

    public InfoPanel(){
        super();
        setOpaque(true);
        setBackground(Color.green);
        setPreferredSize(new Dimension(150, Main.height - 20));

        infos = new JLabel[10];
        for(int i=0;i<10;i++)
        {
            infos[i]=new JLabel();
            infos[i].setFont(new Font("tahoma", 1, 12));
            infos[i].setPreferredSize(new Dimension(145,30));
            infos[i].setOpaque(true);
            infos[i].setBackground(Color.red);
            add(infos[i]);
        }
    }

    public void setInfo(String s,int i){
        infos[i].setText(s);

    }

}
