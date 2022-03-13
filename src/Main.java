import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static final int width=800;
    public static final int height=600;
    private ToolBox tools;
    private InfoPanel info;
    private DrawPanel draw;

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 100, width, height);
        this.setTitle("Paint");
        this.setLayout(new FlowLayout());

        tools=new ToolBox();
        info=new InfoPanel();
        draw=new DrawPanel(info);

        this.add(tools);
        this.add(draw);
        this.add(info);

        setVisible(true);
    }
    public static void main(String[] args) {
    new Main();
    }
}
