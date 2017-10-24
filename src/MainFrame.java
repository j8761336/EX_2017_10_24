import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private int ScreenW =Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH =Toolkit.getDefaultToolkit().getScreenSize().height;
    private JMenuBar JB = new JMenuBar();
    private JMenu JM1 =new JMenu("File");
    private JMenu JM2 =new JMenu("Set");
    private JMenu JM3 =new JMenu("Game");
    private JMenu JM4 =new JMenu("About");
    private JMenuItem jMenuItemExit =new JMenuItem("Exit");
    private JMenuItem jMenuItemLoto =new JMenuItem("Loto");
    private JDesktopPane jdp =new JDesktopPane();
    private JInternalFrame jInternalFrame =new JInternalFrame();
    private LoginFrame loginFrame ;
    public MainFrame(LoginFrame login){
        loginFrame =login;
        initComp();
    }
    public void initComp(){
        this.setBounds(500,300,ScreenW/2-250,ScreenH/2-150);
        this.setJMenuBar(JB);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
            }
        });
        JB.add(JM1);
        JB.add(JM2);
        JB.add(JM3);
        JB.add(JM4);
        JM3.add(jMenuItemLoto);
        JM1.add(jMenuItemExit);
        jMenuItemLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jdp.add(jInternalFrame);
                jInternalFrame.setVisible(true);
            }
        });
        jInternalFrame.setBounds(0,0,200,80);
        jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jMenuItemLoto.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        this.setContentPane(jdp);
    }
}
