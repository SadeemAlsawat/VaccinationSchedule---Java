package vaccinationschedule;



import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class VaccineReservation extends JFrame {

    private JPanel panel, panel2, panel3, panel4;
    private JLabel LchName, LchAge, LchID, LchGender;
    private JLabel Lvacc, Ltime;
    private JTextField Tchinf, TchName, TchAge, TchID, TchGender;
    private JTextField Ttime;
    private JRadioButton Rfemale, Rmale;
    private JComboBox combo1, comboage, jcd, jcm, jcy;
    private JButton Bsave, Bback;
    private ImageIcon Ibackground;

    String[] date = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] year = {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};

    public VaccineReservation() {
        setTitle("Virtual Vaccine Center");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // image background
        Ibackground = new ImageIcon("background.jpg");
        JLabel Limage = new JLabel(" ", Ibackground, JLabel.CENTER);
        add(Limage);

        //panel layout
        setLayout(new GridLayout(5, 6));
        buildPanel();
        buildpaneltwo();
        buildpanelthree();
        buildbuttons();

        panel.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);
        panel4.setBackground(Color.WHITE);
        add(panel);
        add(panel2);
        add(panel3);
        add(panel4);

        setVisible(true);

    }

    //build panel name and id
    private void buildPanel() {

        panel = new JPanel();

        //info child
        LchName = new JLabel("Enter the child's name:");
        LchName.setFont(new Font("Serif", Font.ITALIC, 20));

        TchName = new JTextField(18);
        TchName.setFont(new Font("Serif", Font.ITALIC, 18));

        LchID = new JLabel("Enter the child's ID:");
        LchID.setFont(new Font("Serif", Font.ITALIC, 20));

        TchID = new JTextField(18);
        TchID.setFont(new Font("Serif", Font.ITALIC, 18));

        panel.add(LchName);
        panel.add(TchName);
        panel.add(LchID);
        panel.add(TchID);

    }

    //build panel age and gendrt
    private void buildpaneltwo() {
        panel2 = new JPanel();

        LchAge = new JLabel("              Choose the child's age:          ");
        LchAge.setFont(new Font("Serif", Font.ITALIC, 20));

        comboage = new JComboBox();
        comboage.setFont(new Font("Serif", Font.ITALIC, 18));

        comboage.addItem("At Birth");
        comboage.addItem("2 Months");
        comboage.addItem("2 Months");
        comboage.addItem("4 Months");
        comboage.addItem("6 Months");
        comboage.addItem("9 Months");
        comboage.addItem("12 Months");
        comboage.addItem("18 Months");
        comboage.addItem("24 Months");
        comboage.addItem("7 Years");

        LchGender = new JLabel("             Gender:        ");
        LchGender.setFont(new Font("Serif", Font.ITALIC, 20));

        Rfemale = new JRadioButton("Female");
        Rfemale.setFont(new Font("Serif", Font.ITALIC, 20));

        Rmale = new JRadioButton("Male");
        Rmale.setFont(new Font("Serif", Font.ITALIC, 20));
        Rfemale.setBackground(Color.WHITE);
        Rmale.setBackground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(Rfemale);
        group.add(Rmale);

        panel2.add(LchAge);
        panel2.add(comboage);
        panel2.add(LchGender);
        panel2.add(Rfemale);
        panel2.add(Rmale);

    }

    //build panel vacc and date
    private void buildpanelthree() {
        panel3 = new JPanel();

        //vaac
        Lvacc = new JLabel("            Choose the vaccine      ");
        Lvacc.setFont(new Font("Serif", Font.ITALIC, 20));

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

        panel3.add(Lvacc);
        panel3.add(combo1);

        //time
        Ltime = new JLabel("Choose the date");
        jcd = new JComboBox(date);
        jcm = new JComboBox(month);
        jcy = new JComboBox(year);

        Ltime.setFont(new Font("Serif", Font.ITALIC, 20));
        jcd.setFont(new Font("Serif", Font.ITALIC, 18));
        jcm.setFont(new Font("Serif", Font.ITALIC, 18));
        jcy.setFont(new Font("Serif", Font.ITALIC, 18));

        panel3.add(Ltime);
        panel3.add(jcd);
        panel3.add(jcm);
        panel3.add(jcy);

    }

    //build panel buttons
    private void buildbuttons() {
        panel4 = new JPanel();
        //save button
        Bsave = new JButton("Save");
        Bsave.addActionListener(new SaveListener());
        Bsave.setFont(new Font("Serif", Font.ITALIC, 18));
        panel4.add(Bsave);

        //back button
        Bback = new JButton("Back");
        Bback.addActionListener(new BackListener());
        Bback.setFont(new Font("Serif", Font.ITALIC, 18));
        panel4.add(Bback);

    }

    // action listener for back button
    private class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ParentPage pp = new ParentPage();

        }
    }

    // action listener for save button
  private class SaveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        if(e.getSource()== Bsave){
          
                
            try {
                 String id = TchID.getText();
                if(id.length () == 0||id.length () < 10){
                              JOptionPane.showMessageDialog(null,"Id Field should be filled "
                                      + "\nAlso Id should be 10 digits!");
                }else{
                String gender="";
                if (Rfemale.isSelected()) {
                    gender= "Female";
                } else if (Rmale.isSelected()) {
                    gender= "Male";
                } 
                

                FileOutputStream fs = new FileOutputStream("Reservation.dat", true);
                DataOutputStream ds = new DataOutputStream(fs);
                ObjectOutputStream os = new ObjectOutputStream(ds);

                ReservationModel reservation =
                        new ReservationModel(TchName.getText(), TchID.getText(), 
                                comboage.getSelectedItem().toString(), combo1.getSelectedItem().toString(),
                                jcd.getSelectedItem().toString(), jcm.getSelectedItem().toString(), 
                                jcy.getSelectedItem().toString(),gender);
                os.writeObject(reservation);
                os.close();

               JOptionPane.showMessageDialog(null, "Successfully Saved");
                }
            } catch (IOException e1) {
               JOptionPane.showMessageDialog(null,e1);
            } 
        }

    }
    }
}
