package view;

import control.MainController;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;



/**
 *
 * @author Daniel Vilar
 */
public class MainFrame extends JFrame {
    
        private MainController c;
        
        private Grapher gra; 
        private Grid gri; 
        private JDesktopPane internal;  //InternalFrames

	private int h = 800;
        private int w = 1200;
        
 
   	public MainFrame() {
            
            super();
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            setContentPane(new JLayeredPane());
            setLayout( new OverlayLayout(this.getContentPane()));
            
            setSize(w, h);
            setTitle("Electric Charge Calculator");
            setLocationRelativeTo(null);
            setResizable(false);    

	}
    	

        public void addController(MainController c){
            
            this.c = c;
        }
        
        
        public void create(){	
            
            JMenuBar menuBar;
            JMenu fileMenu;
            JMenu toolMenu;
            JMenuItem menuItem;
                  
            menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            
            //Menu is added
            fileMenu = new JMenu("File");
            fileMenu.setMnemonic(KeyEvent.VK_F);
            
            //Submenu 1
            menuItem = new JMenuItem("New Charge",
                                   KeyEvent.VK_N);
            menuItem.getAccessibleContext().setAccessibleDescription(
                  "New Charge");
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_NEW);
            fileMenu.add(menuItem);
            

            //Submenu 2
            menuItem = new JMenuItem("Add...",
                                     KeyEvent.VK_A);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Add"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_ADD);
            fileMenu.add(menuItem);
            
            //Submenu 3
            menuItem = new JMenuItem("Load...",
                                     KeyEvent.VK_L);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Load"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_LOAD);
            fileMenu.add(menuItem);
                   
            //Submenu 4
            menuItem = new JMenuItem("Save...",
                                     KeyEvent.VK_S);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Save"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_SAVE);
            fileMenu.add(menuItem);
                   
            //Submenu 5
            menuItem = new JMenuItem("Remove Charges",
                                     KeyEvent.VK_R);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Remove"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_WIPE);
            fileMenu.add(menuItem);
            
            //Menu is finally added to Panel
            menuBar.add(fileMenu); 
            
            
            //Menu2 is added
            toolMenu = new JMenu("Tools");
            toolMenu.setMnemonic(KeyEvent.VK_T);
            
            
            //Submenu 1
            menuItem = new JMenuItem("Calculate",
                                   KeyEvent.VK_C);
            menuItem.getAccessibleContext().setAccessibleDescription(
                  "Calculate");
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_CALC);
            toolMenu.add(menuItem);
            

            //Submenu 2
            menuItem = new JMenuItem("Help",
                                     KeyEvent.VK_H);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Help"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_HELP);
            toolMenu.add(menuItem);
            
            //Submenu 3
            menuItem = new JMenuItem("Zoom In",
                                     KeyEvent.VK_I);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Zoom In"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_ZI);
            toolMenu.add(menuItem);
            
            //Submenu 3
            menuItem = new JMenuItem("Zoom Out",
                                     KeyEvent.VK_O);
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Zoom Out"); 
            menuItem.addActionListener(c);
            menuItem.setActionCommand(MainController.C_ZO);
            toolMenu.add(menuItem);
            
            
            menuBar.add(toolMenu);
           

            gra = new Grapher(this);
            this.getContentPane().add(gra,new Integer(3));

            
            gri = new Grid(this);
            this.getContentPane().add(gri,new Integer(2));
            
            internal = new JDesktopPane();
            internal.setOpaque(false);
            this.getContentPane().add(internal, new Integer(4));
           
            setIcon();
            
            setVisible(true);
            
            
        }
        
        
        
        private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/chargeLogo.png")));       
            
        }
        

        
        public int getH(){
            
            return h;
        }
        
        public int getW(){
            
            return w;
        }

        public Grapher getGrapher(){
            
            return gra;
        }
        
        public Grid getGrid(){
            
            return gri;
        }
        
        
        /*This method is the ONLY one that might be used to add a JInternalFrame,
        any other method will cause the program not to function as desired*/ 
        public void addFrame(JInternalFrame i){
        
            this.getContentPane().remove(internal);
            
            internal.removeAll();
            i.setVisible(true);
            internal.add(i);  
            
            this.getContentPane().add(internal, new Integer (4));
            
            setVisible(true);
        
        }
        
        public boolean internalIsEmpty() {
            
            return internal == null;
        }
        
        public JDesktopPane getDesktop(){
            
            return (JDesktopPane)getContentPane();
        }

    public void addFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
