package vaccinationschedule;

import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class InfoClass extends JFrame {
         private JPanel startPanel, panel2, panel3;
    private JLabel lstart ;
    private JButton BCalculation,Bback, ph2;
    private JTextField textField;
    private  JComboBox combo1;
    private ImageIcon Ibackground, phb2, phb3;
    
     
    public InfoClass(){
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
        buildcombo();
        builbuttons();
        buildbutton();
        
     startPanel.setBackground(Color.WHITE);
     panel2.setBackground(Color.WHITE);
     panel3.setBackground(Color.WHITE);
     
        add(startPanel);
        add(panel2);
        add(panel3);
        
        setVisible(true);
    }
    
    
    // build panel title
    private void buildStart(){
        startPanel = new JPanel();
        
        lstart = new JLabel ("Which vaccine information you want to get?");
        lstart.setFont(new Font("Serif", Font.BOLD, 24));
        
     startPanel.add(lstart);
     
     
   }
    
    // build panel combo box
     private void buildcombo(){
         
         panel2 = new JPanel();
          combo1 = new JComboBox();
                combo1.addItem("BCG");
                combo1.addItem("Hepatitis B");
                combo1.addItem("IPV");
                combo1.addItem("DTaP");
                combo1.addItem("Pneumococcal conjugate");
                combo1.addItem("Rota");
                combo1.addItem("OPV");
                combo1.addItem("measles");
                combo1.addItem("MCV4");
                combo1.addItem("MMR");
                combo1.addItem("Varicella");
                combo1.addItem("Hepatitis A");
                combo1.addItem("Hip");
                
                combo1.setFont(new Font("Serif", Font.ITALIC, 18));
                 combo1.setForeground(Color.BLUE);
                panel2.add(combo1);
      
         
     }
     
     // build panel get info button
      private void builbuttons(){
          
          panel3 = new JPanel();
          
        BCalculation = new JButton ("get information");
        BCalculation.addActionListener(new InfoActionListener());
        
        BCalculation.setFont(new Font("Serif", Font.ITALIC, 18));
          
          panel2.add(BCalculation);
          
      }
      
      // build panel backbutton
      private void buildbutton(){
          
          panel3.setLayout(new BorderLayout());
          
           //back button
                Bback = new JButton("Back");
                Bback.addActionListener(new BackListener());
                Bback.setFont(new Font("Serif", Font.ITALIC, 18));
                
                panel3.add(Bback );
                
                /////////////////////
                
                phb2 = new ImageIcon("baby1.jpg");
               JLabel ph2 = new JLabel(phb2);
               panel3.add(ph2, BorderLayout.EAST);
                phb3 = new ImageIcon("baby2.jpg");
               JLabel ph = new JLabel(phb3);
               panel3.add(ph, BorderLayout.WEST);
          
      }
      
      
    //action listener for back button
     private class BackListener implements ActionListener
 {
            public void actionPerformed(ActionEvent e){
                
                ParentPage pp = new ParentPage();
                
            }
         }
     
     //action listener for get info button
      private class InfoActionListener implements ActionListener{
    public void actionPerformed (ActionEvent e){
        if(combo1.getSelectedItem().equals("BCG")){
             JOptionPane.showMessageDialog(null,"The BCG vaccine is the name given "
                     + "to the pulmonary tuberculosis vaccine.\n" +
                     "Tuberculosis is very dangerous in terms of infection, infecting the lungs \n,"
                     + " and parts of the body, such as: bones, kidneys, and joints,"
                     + " and can also cause meningitis.\n" +"\n" +"Categories that need a vaccine:\n" +
                     "*Newborns babies\n" +"\n" +"Vaccine side effects: \n" +"*Swollen lymph nodes.\n" 
                     +" *Appearance of blood in the urine.\n" +" *Pain during urination.\n" +
                     " *Collywobbles.");
    }
        else if (combo1.getSelectedItem().equals("Hepatitis B")){
            JOptionPane.showMessageDialog(null,"Hepatitis B vaccine is a vaccine that"
                    + " prevents hepatitis B infection.\n The vaccine contains one of the "
                    + "virus envelope proteins, the HBsAg antigen on the outside of the virus.\n" +
                    "\n" +"Categories that need a vaccine:\n" +"* newborn babies\n" +
                    "*Children at the age of two months\n" +"*Children at the age of four months\n" +
                    "*Children at the age of six months\n" +"\n" +"Vaccine side effects:\n" +
                    "*redness and swelling of the area.\n" +" *High temperature.");   
        }
        
        else if (combo1.getSelectedItem().equals("IPV")){
            JOptionPane.showMessageDialog(null,"The polio vaccine is a vaccine that is given "
                    + "in the form of oral drops, by using the weakened poliovirus.\n" +"\n" +
                    "Categories that need a vaccine:\n" + "*Children at the age of two months\n" +
                    "*Children at the age of four months\n" +"*Children at the age of six months\n" +
                    "\n" +"Vaccine side effects: \n" +" Side effects are rare\n" +"*hyperthermia.\n" +
                    "*vomiting.\n" +"*diarrhea.\n" + "*allergic reactions."); 
            
        }
        
        else if (combo1.getSelectedItem().equals("DTaP")){
            JOptionPane.showMessageDialog(null,"The DPT vaccine or the diphtheria-pertussis-tetanus"
                    + " vaccine is a type of combination vaccine to immunize \n against a mixture of "
                  + "infectious diseases in humans, namely diphtheria, whooping cough, and tetanus \n."
                    + "  The vaccine components include parts \n of the toxins from the tetanus and "
                    + "diphtheria bacteria as well as the killed pertussis bacteria.\n" +"\n" +
                    "Categories that need a vaccine:\n" +"*Children at the age of two months\n" +
                    "*Children at the age of four months\n" + "*Children at the age of six months\n" +
                    "**Children upon entering primary school\n" +"\n" + "Vaccine side effects: \n" +
                    " *Pain, swelling, or soreness at the injection site\n" +" *Fever\n" +
                    " *nervous and agitated\n" +" *Anorexia\n" +" *vomiting");
            
        }
        else if (combo1.getSelectedItem().equals("Pneumococcal conjugate")){
            JOptionPane.showMessageDialog(null,"Pneumococcal vaccination protects against pneumococcal "
                    + "disease, and this disease is an infection \n caused  by infection with "
                    + "Streptococcus pneumoniae bacteria, and these bacteria can cause a range \n"
                    + " of diseases in humans,including;  Pneumonia, bloodstream infection or"
                    + " bacteremia, meningitis, sinusitis\n, middle ear infection, the different "
                    + "group of diseases caused by Streptococcus \n"
                    + " pneumoniae is referred to as pneumococcal disease.\n" + "\n" +
                    "Categories that need a vaccine:\n" + "*Children at the age of two months\n" +
                    "*Children at the age of four months\n" + "*Children at the age of six months\n" +
                    "*Children at the age of 12 months\n" +"\n" +
                    "Vaccine side effects: \n" + "high body temperature.");
            
        }
        else if (combo1.getSelectedItem().equals("Rota")){
            JOptionPane.showMessageDialog(null,"It is a vaccine used to protect against the risk of"
                    + " rotavirus infection.  These viruses are the main\n cause of severe diarrhea in"
                  + " children.The vaccine prevents 15 to 34% of severe diarrhea in the developing\n"
                    + " world and 37 to 96% of severe diarrhea in the developed world."
                    + " The vaccine has reduced the risk\n of death in children from diarrhea."
                    + "  Immunizing children against the virus reduces the risk of infection \n in the"
                    + "elderly and those who have not previously been vaccinated.\n" +"\n" +
                    "Categories that need a vaccine:\n" +"*Children at the age of two months\n" +
                    "*Children at the age of four months\n" + "\n" +"Vaccine side effects: \n" +
                    "*Fever\n" +"*vomiting");
            
        }
        else if (combo1.getSelectedItem().equals("OPV")){
            JOptionPane.showMessageDialog(null,"The polio vaccine is a vaccine that is given by "
                  + "injection.  It is more effective, this type does\n not have any risk of developing"
                    + " the virus because it is not a live vaccine, and it also causes an\n excellent"
                    + " protective immune response in a person.\n" +"\n" +
                    "Categories that need a vaccine:\n" +"*Children at the age of six months\n" +
                    "*Children at the age of 12 months\n" +
                    "*Children at the age of 18 months\n" +
                    "*Children upon entering primary school\n" +"\n" +"Vaccine side effects: \n" +
                    " Side effects are rare\n" +"*hyperthermia.\n" +"*vimiting.");
            
        }
        else if (combo1.getSelectedItem().equals("measles")){
            JOptionPane.showMessageDialog(null,"Measles vaccine protects against becoming infected with measles."
                   + "Nearly all of \n those who do not develop immunity after a single dose develop it"
                    + " after a second dose.\nWhen rate of vaccination within a population is greater"
                    + " than 92%, outbreaks of measles typically no longer \n occur; however, they"
                    + " may occur again if the rate of vaccination decrease.\n" +
                    "\n" +"Categories that need a vaccine:\n" +
                    "*Children at the age of 9 months\n" +"\n" +"Vaccine side effects: \n" +
                    " Side effects associated with the administration of the\n"
                    + " MMR vaccine include fever, rash, and pain at the injection site.");
            
        }
         else if (combo1.getSelectedItem().equals("MCV4")){
             JOptionPane.showMessageDialog(null,"the vaccine protects children from the meningococcal"
                     + " disease is an \n infection caused by a strain of bacteria called Neisseria "
                     + "meningitidis. This invasive bacteria is one of the\n leading causes of bacterial "
                     + "meningitis in children ages 2 to 18.\n" + "\n" +
                     "Categories that need a vaccine:\n" + "*Children at the age of 9 months\n" +
                     "*Children at the age of 12 months\n" +"\n" + "Vaccine side effects: \n" +
                     "Pain at the injection site and high temperature.");
             
         }
        else if (combo1.getSelectedItem().equals("MMR")){
             JOptionPane.showMessageDialog(null,"The MMR vaccine is a vaccine against measles, mumps,"
                     + " and rubella (German measles), abbreviated as MMR.\n" +"\n" +
                     "Categories that need a vaccine:\n" +
                     "*Children at the age of 12 months\n" +
                     "*Children at the age of 18 months\n" +
                     "*Children upon entering primary school\n" +"\n" +
                     "Vaccine side effects: \n" +"Side effects of immunization"
                     + " are generally mild and resolve without any specific treatment.");
        }
        
        else if (combo1.getSelectedItem().equals("Varicella")){
             JOptionPane.showMessageDialog(null,"The varicella vaccine can prevent varicella. "
                     + "Varicella, also known \n as \"chickenpox\", causes an itchy rash that usually"
                     + " lasts for about a week. It can also cause\n fever, fatigue, loss of appetite"
                     + " and headache. Chickenpox can lead to skin infection,\n pneumonia, vasculitis,"
                     + " swelling of the brain membrane and  /or spinal cord,\n bloodstream, bone or"
                     + " joint infection Some people who get chickenpox\n develop years later a painful"
                     + " rash called shingles (also known as shingles).\n" +"\n" +
                     "Categories that need a vaccine:\n" +"*Children at the age of 18 months\n" +
                     "*Children upon entering primary school\n" +"\n" +"Vaccine side effects: \n" +
                     "Arm pain from the injection, redness or rash at the injection site, "
                     + "or fever may occur\n after receiving the varicella vaccine.");
        }
        else if (combo1.getSelectedItem().equals("Hepatitis A")){
             JOptionPane.showMessageDialog(null,"Hepatitis A vaccine is a vaccine that prevents "
                     + "hepatitis A.Itis\n effective in around 95% of cases and lasts for at"
                     + " least twenty\n years and possiblya person's entire life.\n" +"\n" +
                     "Categories that need a vaccine:\n" +"*Children at the age of 18 months\n" +
                     "*Children at the age of 24 months\n" +
                     "\n" +"Vaccine side effects: \n" +"Sometimes there is pain, redness and"
                     + " swelling at the injection site.\n No serious side effects have been reported.");
        }
        
        else if (combo1.getSelectedItem().equals("Hip")){
             JOptionPane.showMessageDialog(null,"Haemophilus influenzae type b (Hib) vaccine helps"
                     + " prevent bacterial \n infections due to Haemophilus influenzae type b, such as"
                     + " pneumonia\n and meningitis. These infections can be dangerous for children."
                     + " The use of the vaccine has helped reduce\n the incidence of Haemophilus"
                     + " influenzae type b infection.  The risk in children is 99%.\n" +"\n" +
                     "Categories that need a vaccine:\n" +"*Children at the age of two months\n" +
                     "*Children at the age of four months\n" +
                     "*Children at the age of six months\n" +"*Children at the age of 18 months\n" +
                     "\n" +"Vaccine side effects: \n" +
                     "Sometimes, the injection site becomes painful,"
                     + " swollen, and red.\n After the vaccination, children may have"
                     + " a fever, cry, and irritability.");
        }
    }
      
}
}


