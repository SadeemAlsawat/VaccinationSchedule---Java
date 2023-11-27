package vaccinationschedule;

import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class ParentPage extends JFrame {
    private JPanel startPanel, panel2, panel3;
    private JLabel lstart;
    private JButton Binfo, BReservation, Bback;
    private JTextField textField;
    private ImageIcon Ibackground, phb2, phb3;
  
    
     
    public ParentPage(){
        setTitle("Virtual Vaccine Center");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //image background
      Ibackground = new ImageIcon("background.jpg");
      JLabel Limage = new JLabel(" ",Ibackground, JLabel.CENTER);
      add(Limage);
      
        
      //panels layout
         setLayout (new GridLayout(4,3));
        buildStart();
        buildButton();
        buildButtonsts();
        
 
     startPanel.setBackground(Color.WHITE);
     panel2.setBackground(Color.WHITE);
     panel3.setBackground(Color.WHITE);
     add(startPanel);
     add(panel3);
     add(panel2);
       
        setVisible(true);
    }
    
    //buil panel title
    private void buildStart(){
        startPanel = new JPanel();
        lstart = new JLabel ("What are you looking for?");
      lstart.setFont(new Font("Serif", Font.BOLD, 24)); 
     startPanel.add(lstart);
        
   }
    
  
    //build panel back button
     private void buildButton(){
         panel2 = new JPanel();
         
       panel2.setLayout(new BorderLayout(7,6));
         
      Bback = new JButton("Back");
     Bback.addActionListener(new BackListener());
     
     Bback.setFont(new Font("Serif", Font.ITALIC, 18));
     
     
         panel2.add(Bback, BorderLayout.CENTER);
     
          phb2 = new ImageIcon("baby1.jpg");
               JLabel ph2 = new JLabel(phb2);
            panel2.add(ph2, BorderLayout.EAST);
                
               phb3 = new ImageIcon("baby2.jpg");
               JLabel ph = new JLabel(phb3);
               panel2.add(ph, BorderLayout.WEST);
              
         
     }
     
     //build panel buttons
      private void buildButtonsts(){
          panel3 = new JPanel();
         Binfo = new JButton ("Informations");
        BReservation = new JButton ("Vaccine reservation");
        
        Binfo.setFont(new Font("Serif", Font.ITALIC, 18));  
        BReservation.setFont(new Font("Serif", Font.ITALIC, 18)); 

     Binfo.setToolTipText("Click here for the vaccine information you want to get");
     BReservation.setToolTipText("Click here to book a vaccination appointment");
     
     Binfo.addActionListener(new InfoActionListener());
     
     BReservation.addActionListener(new ReservationActionListener());
     
     panel3.add(Binfo);
     panel3.add(BReservation);
     
       
          
      }
      
      
     //action listener for info button
    private static class InfoActionListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
          InfoClass in = new InfoClass ();
        }
    }

    //action listener for Reservation button
    private class ReservationActionListener implements ActionListener {

         public void actionPerformed (ActionEvent e){
             
             if(e.getSource() == BReservation ){
                 VaccineReservation VR = new VaccineReservation ();
             
         }
             
         }
    }
    
        //action listener for back button
    private class BackListener implements ActionListener
 {
            public void actionPerformed(ActionEvent e){
                
                StartPage sp = new StartPage();
    
}
    }
}
    