import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private LoginFrame lgfm;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 500, frmH = 400, screenW, screenH;
    private JTextField jtx = new JTextField();
    private JButton jbtn[] = new JButton[10];
    private JButton jbtnClear = new JButton("Clear");
    private JButton jbtnExit = new JButton("Go back");
    private JPanel jpn = new JPanel(new GridLayout(4, 3, 1, 1));
    private Container cp;

    public MainFrame(LoginFrame lg) {
        lgfm = lg;
        init();
    }

    private void init() {
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW / 2 - frmW / 2, screenH / 2 - frmH / 2, frmW, frmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lgfm.setVisible(true);
                dispose();
            }
        });
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        cp.add(jtx, BorderLayout.NORTH);
        cp.add(jpn, BorderLayout.CENTER);
        jtx.setEditable(false);
        for (int i = 0; i < 10; i++) {
            jbtn[i] = new JButton();
            jpn.add(jbtn[i]);
            int x = new Random().nextInt(10);
            jbtn[i].setText(Integer.toString(x));

            //control
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton) e.getSource();
                    jtx.setText(jtx.getText() + tmp.getText());
                }
            });

        }
        jpn.add(jbtnExit);
        jpn.add(jbtnClear);
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgfm.setVisible(true);
                dispose();
            }
        });
        jbtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtx.setText(" ");
            }
        });
    }
}


