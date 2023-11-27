package vaccinationschedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class VaccinationSchedule extends JFrame {
    private JPanel panel, Mpanel, panel2,panel3;
    
   // create menu
    private JMenuBar menuBar;
    private JMenu MFile, MEdit, MUs;
    private JMenu usItem, Muse, Mcont ;
    private JMenuItem IExit, Mabus, MuseItem, contE, contPH,Mabus2, Mabus3, couTW, MuseItem2;
    private JCheckBoxMenuItem dark; 
     
    //create panels
    private JLabel Lname, Lid, Lemail, Lpass, Lgender, LWelcome;
    private JTextField Tname, Tid, Temail, Tpass;
    private JRadioButton Rfemale, Rmale;
    private JButton Blogin;
    private ImageIcon  Ibackground;
    
    
    public VaccinationSchedule(){
        
         setTitle("Virtual Vaccine Center");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
      //image back ground   
     Ibackground = new ImageIcon("FFF.jpg");
      JLabel Limage = new JLabel(" ",Ibackground, JLabel.CENTER);
      add(Limage);
      
        
        //Menu Bar
        menuBar = new JMenuBar();
        MFile = new JMenu ("File");
        MEdit = new JMenu ("Edit");
        MUs = new JMenu ("About us");
        menuBar.add(MFile);
        menuBar.add(MEdit);
        menuBar.add(MUs);
        
        // File menu
        IExit = new JMenuItem("Exit");
        IExit.setMnemonic(KeyEvent.VK_X);
        IExit.addActionListener(new ExitListener());
        MFile.add(IExit);
        
        //Edit menu
        dark = new JCheckBoxMenuItem("Dark Mode");
        dark.addItemListener(new CheckBoxListener());
        MEdit.add(dark);
        
        
        //about us menu
        usItem = new JMenu("About the center");
     Mabus  = new JMenuItem("The app allows parents to easily book their children’s vaccinations");
    Mabus2 = new JMenuItem ("with the center, as well as easy to search for information about ");
    Mabus3 = new JMenuItem ("each vaccine and the age group in which the child should take the vaccine.");
        usItem.add(Mabus);
        usItem.add(Mabus2);
        usItem.add(Mabus3);
        
        // how use menu
        Muse = new JMenu("How to use it");
        MuseItem  = new JMenuItem("At first login to the system \n"
                +"As a parent you can choose a date so that you child can get vaccinated");
        MuseItem2 = new JMenuItem("As a nurse you can check on to days reservations and "
                + "choose which vaccines will be required for it.");
        Muse.add(MuseItem);
        Muse.add(MuseItem2);
        
        //contact menu
        Mcont = new JMenu("Contact with us by");
        contE  = new JMenuItem("Email: VaccinationSchedule_98@gmail.com");
        Mcont.addSeparator();
        contPH = new JMenuItem("Phone: +966 5876765");
        couTW = new JMenuItem("Twitter: @VaccinationSchedule_98");
        
        Mcont.add(contE);
        Mcont.add(contPH);
        Mcont.add(couTW);
        MUs.add(usItem);
        MUs.add(Muse);
        MUs.add(Mcont); 
        setJMenuBar(menuBar);
        
        // layout panels
        setLayout (new GridLayout(4,3));
        buildPanel();
        buildlog();
        buildbutton();
       
     panel.setBackground(Color.WHITE);
     panel2.setBackground(Color.WHITE);
     panel3.setBackground(Color.WHITE);
        add(panel);
        add(panel2);
        add(panel3);
        setVisible(true);
        
    }
    
    //  build panel title
     private void buildPanel () {
        LWelcome = new JLabel ("**Welcome To The Virtual Vaccine Center**");
      
        LWelcome.setFont(new Font("Serif", Font.BOLD, 24));
       
       panel = new JPanel();
       panel.add(LWelcome);
         
     }
     
     // build panel email and pass
     public void buildlog(){
         panel2 = new JPanel();
         
        Lemail = new JLabel ("Please enter your email:");
        Temail = new JTextField (16);
        
        Lpass = new JLabel ("Please enter your password:");
        Tpass = new JTextField (16);
        
        Lemail.setFont(new Font("Serif", Font.ITALIC, 18));
        Temail.setFont(new Font("Serif", Font.ITALIC, 18));
        Lpass.setFont(new Font("Serif", Font.ITALIC, 18));
        Tpass.setFont(new Font("Serif", Font.ITALIC, 18));
        
        panel2.add(Lemail);
        panel2.add(Temail);
        panel2.add(Lpass);
        panel2.add(Tpass);
         
     }
     
     // build panel button
     public void buildbutton(){
         panel3 = new JPanel();
         
        Blogin = new JButton ("LogIn");
        Blogin.addActionListener(new ActionContinue());
        
        Blogin.setFont(new Font("Serif", Font.ITALIC, 18));
         
        panel3.add(Blogin);
     }

      // // action listener for login button
        private class ActionContinue implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
                    String email = Temail.getText();
                    String pass = Tpass.getText();
                    String emailForm="[A-Za-z0+_.-]+@(.+)$";
                    boolean EmailMatch=Temail.getText().matches(emailForm);
                    if(e.getSource()== Blogin){
                      try{
                          if(pass.length () == 0||email.length () == 0){
                              JOptionPane.showMessageDialog(null,"Fields should be filled");
                          }else if(EmailMatch==false){
                              JOptionPane.showMessageDialog(null,"Email must cintain '@',please enter correct Email!");
                          }else{
                              StartPage SB = new StartPage();}
                          }catch(Exception e2){
                                  JOptionPane.showMessageDialog(null,e2);
                                  }
                      }
                      
                }
        }
        
        // actionListener to exit "menu item"
        private class ExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
        
         // actionListener to exit "menu checkbox"
     private class CheckBoxListener implements ItemListener{
         public void itemStateChanged(ItemEvent e)
{

 if (e.getSource() == dark)
 {
if (dark.isSelected()) {

 
 panel.setBackground(Color.BLACK);
 panel2.setBackground(Color.BLACK);
 panel3.setBackground(Color.BLACK);
 LWelcome.setForeground(Color.WHITE);
 Lemail.setForeground(Color.WHITE);
 Lpass.setForeground(Color.WHITE);
 
 
 
 
 }else
{
 // The yellow check box was deselected. Set
 panel.setBackground(Color.WHITE);
 panel2.setBackground(Color.WHITE);
 panel3.setBackground(Color.WHITE);
 LWelcome.setForeground(Color.BLACK);
 Lemail.setForeground(Color.BLACK);
 Lpass.setForeground(Color.BLACK);
 
}
}
}
     }
     
    public static void main(String[] args) {
        VaccinationSchedule VS = new VaccinationSchedule();
    }
    
}