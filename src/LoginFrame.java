import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300, frmH = 150, screenW, screenH;
    private Container cp;

    private JLabel jlabID = new JLabel("ID");
    private JLabel jlabPW = new JLabel("Password");
    private JTextField jtxId = new JTextField();
    private JPasswordField jPW = new JPasswordField();
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnLogin = new JButton("Login");
    private String  Name = "h304";
    private String Password = "23323456";
    public LoginFrame(){
        init();
    }
    private void init(){
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,1,1));
        jlabID.setHorizontalAlignment(SwingConstants.RIGHT);
        jlabPW.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(jlabID);
        cp.add(jtxId);
        cp.add(jlabPW);
        cp.add(jPW);
        cp.add(jbtnExit);
        cp.add(jbtnLogin);

        // control
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbtnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtxId.getText().equals(Name) && (new String(jPW.getPassword())).equals(Password)){
                    MainFrame mf = new MainFrame(LoginFrame.this);
                    mf.setVisible(true);
                    LoginFrame.this.setVisible(false);
                    jtxId.setText("");
                    jPW.setText("");

                }else{
                    if(!jtxId.getText().equals(Name)){
                        JOptionPane.showMessageDialog(LoginFrame.this,"your ID is wroong");
                    }else if(!(new String(jPW.getPassword())).equals(Password)){
                        JOptionPane.showMessageDialog(LoginFrame.this,"your password is wrong");
                    }
                }
            }
        });
    }
}
