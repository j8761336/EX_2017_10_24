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

    private JPanel JPanel1 = new JPanel(new GridLayout(2,3,5,5));
    private JLabel jlbFontFamily =new JLabel("Family");
    private JLabel jlbFontStyle =new JLabel("Style");
    private JLabel jlbFontSize =new JLabel("Size");
    private TextField jtfFamily =new TextField("Time new Roman");
    private TextField jtfSize =new TextField("24");
    private String[] options ={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcbFstyle= new JComboBox(options);

    private JMenuItem jMenuItemExit =new JMenuItem("Exit");
    private JMenuItem jMenuItemLoto =new JMenuItem("Loto");
    private JMenuItem jMenuItemFont =new JMenuItem("Font");

    private JDesktopPane jdp =new JDesktopPane();
    private JInternalFrame jInternalFrame =new JInternalFrame();

//    ---------------------------------------------------------
    private JInternalFrame jIFAddCategory =new JInternalFrame();
    private Container jIFAddCategoryCP;
    private JMenuBar jIFAddCategoryJmb = new JMenuBar();
    private JMenuItem jmiDataLoad =new JMenuItem("Load");
    private JMenuItem jmiDataNew =new JMenuItem("New");
    private JMenuItem jmiDataClose =new JMenuItem("Close");
    private JMenuItem jmiAddCategory =new JMenuItem("Category");
    private JScrollPane jsp1 =new JScrollPane();
    private JInternalFrame jmData =new JInternalFrame();


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
        JM2.add(jMenuItemFont);
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

        JPanel1.add(jlbFontFamily);
        JPanel1.add(jlbFontStyle);
        JPanel1.add(jlbFontSize);
        JPanel1.add(jtfFamily);
        JPanel1.add(jtfSize);
        JPanel1.add(jcbFstyle);



        jMenuItemFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    int result =JOptionPane.showConfirmDialog(MainFrame.this,JPanel1,"Font Setting",JOptionPane.OK_CANCEL_OPTION);
                    int fontStyle=0;
                    switch(jcbFstyle.getSelectedIndex()) {
                        case 0:
                            fontStyle = Font.PLAIN;
                            break;
                        case 1:
                            fontStyle = Font.BOLD;
                            break;
                        case 2:
                            fontStyle = Font.ITALIC;
                            break;
                        case 3:
                            fontStyle = Font.BOLD + Font.ITALIC;
                            break;
                    }
            if(result == JOptionPane.OK_CANCEL_OPTION){
                        UIManager.put("Menu.font",new Font(jtfFamily.getText(),fontStyle,Integer.parseInt(jtfSize.getText())));
            }
            }
        });
//        --------------------------------
            jmiAddCategory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    jIFAddCategory.setVisible(true);
                }
            });

            jIFAddCategoryCP =jIFAddCategory.getContentPane();
            jIFAddCategoryCP.setLayout(new BorderLayout(5,5));
            jIFAddCategoryCP.add(jsp1,BorderLayout.CENTER);
            jIFAddCategory.setJMenuBar(jIFAddCategoryJmb);
            jIFAddCategory.setBounds(0,0,500,500);
            jIFAddCategory.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jIFAddCategoryJmb.add(jmData);
            jmData.add(jmiDataLoad);
            jmData.add(jmiDataNew);
            jmData.add(jmiDataClose);
            jdp.add(jIFAddCategory);
//            jmiDataLoad.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent actionEvent) {
//                    if(jfc.showOpenDiaLog(null)==JFileChooser.APPROVE_OPTION){
//                        try(File inFile =jfc.getSelectedFile();)
//                    }
//                }
//            });

    }
}
