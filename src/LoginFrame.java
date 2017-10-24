import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {

        private JLabel JLID=new JLabel("ID: ");
        private JLabel JLPW=new JLabel("PW: ");
        private JTextField JTID =new JTextField();
        private JPasswordField JTPW =new JPasswordField();
        private JButton JBGO =new JButton("Go");
        private JButton JBExit =new JButton("Exit");
        private Container cp =new Container();
        private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
        private int ScnX=200, ScnY=150, ScnW=dim.width, ScnH=dim.height;
        public LoginFrame(){
            initComp();
        }
        public void initComp(){
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                }
            });
            JBExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            JBGO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(JTID.getText().equals("h304") && new String(JTPW.getPassword()).equals("23323456")){
                        System.out.println("Yes! ");
                        LoginFrame lg = new LoginFrame();
                        lg.setVisible(false);
                        MainFrame mfm =new MainFrame(LoginFrame.this);
                        mfm.setVisible(true);
                    }else{
                        System.out.println("No! ID: " +JTID.getText()+"\tPW: "+new String(JTPW.getPassword()));
                    }
                }
            });
            this.setBounds(ScnW/2-ScnX/2,ScnH/2-ScnY/2,ScnX,ScnY);

            cp=this.getContentPane();
            cp.setLayout(new GridLayout(3,2,3,3));
            cp.add(JLID);
            cp.add(JTID);
            cp.add(JLPW);
            cp.add(JTPW);
            cp.add(JBGO);
            cp.add(JBExit);
            JLID.setHorizontalAlignment(JLabel.RIGHT);
            JLPW.setHorizontalAlignment(JLabel.RIGHT);

        }

}
