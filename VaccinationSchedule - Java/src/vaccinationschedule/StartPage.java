package vaccinationschedule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class StartPage extends JFrame{
 private JPanel  panel, panel2, panel3;
	private JLabel lblrole;
        private JRadioButton parent,nurse;
        private ButtonGroup Selection; 
        private JButton Bback; 
        private ImageIcon Ibackground;
        
 
 public StartPage(){
  setTitle("Virtual Vaccine Center");
    setSize(600, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    //image background
    Ibackground = new ImageIcon ("background.jpg");
    JLabel Limage = new JLabel(" ",Ibackground, JLabel.CENTER);
    add(Limage);
      
    //layout panels
    setLayout (new GridLayout(4,3));
    buildPanel();
    buildRbuttons();
    buildbutton();
    
    panel.setBackground(Color.WHITE);
     panel2.setBackground(Color.WHITE);
     panel3.setBackground(Color.WHITE);
    add(panel);
    add(panel2);
    add(panel3);
    setVisible(true);
	}
	
 
        //build panel title
	private void buildPanel()
	{
		panel = new JPanel();
		lblrole = new JLabel("What's your role?  ");
                lblrole.setFont(new Font("Serif", Font.BOLD, 24));
		panel.add(lblrole);
              
                
	}
        
        
        // build panel radio buttons
       private void  buildRbuttons(){
           
           panel2 = new JPanel();
            parent = new JRadioButton("parent");
                nurse = new JRadioButton("nurse");
                
                parent.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
                nurse.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
                
                parent.setBackground(Color.WHITE);
                nurse.setBackground(Color.WHITE);
                
                Selection = new ButtonGroup();
                Selection.add(parent);
                Selection.add(nurse);

                 parent.addActionListener(new RadioButtonListener());
                 nurse.addActionListener(new RadioButtonListener());
                 
                 panel2.add(parent);
                panel2.add(nurse);
            
        }
       
       // build panel buttons
       private void buildbutton(){
           panel3 = new JPanel();
           
                //back button
                Bback = new JButton("Back");
                Bback.setFont(new Font("Serif", Font.ITALIC, 18));
                Bback.addActionListener(new BackListener());
		panel3.add(Bback);
    
}
       
       
	
        // action listener for radio button
        private class RadioButtonListener implements ActionListener
 {
            public void actionPerformed(ActionEvent e)
 {
     if(e.getSource()== parent){
                        ParentPage pp =new ParentPage();
                    }else if(e.getSource()== nurse){
                        NurseId n =new  NurseId();
                    }
 }
 }
        
        // action listener for back button
         private class BackListener implements ActionListener
 {
            public void actionPerformed(ActionEvent e){
                
                VaccinationSchedule VS = new VaccinationSchedule();
                
            }
         }
}