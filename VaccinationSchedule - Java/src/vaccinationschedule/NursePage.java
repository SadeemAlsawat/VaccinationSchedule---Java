package vaccinationschedule;

import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class NursePage extends JFrame {

    private JPanel panel, panelch;
    private JLabel LSe, Lch, id;
    private JTextField tv;
    private JButton BSearch;
    private JTextArea textarea;
    private JTextField TchID;
    private JButton Bback, save;
    private JCheckBox chatt, chnoatt;
    private ImageIcon Ibackground;
    private JScrollPane scroll;

    public NursePage() {
        setTitle("Virtual Vaccine Center");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        buildpanel();
        checkpanel();
        

        //image background
        Ibackground = new ImageIcon("background.jpg");
        JLabel Limage = new JLabel(" ", Ibackground, JLabel.CENTER);
        add(Limage);

        //panels layout
        setLayout(new GridLayout(3, 3));

        panel.setBackground(Color.WHITE);
        panelch.setBackground(Color.WHITE);
       
        add(panel);
        add(panelch);

        setVisible(true);
    }

    // build panel title
    private void buildpanel() {
        panel = new JPanel();
        LSe = new JLabel("Click print to view reservations");
        LSe.setFont(new Font("Serif", Font.ITALIC, 18));
        panel.add(LSe);
        
        BSearch = new JButton("Print Reservations");
        BSearch.addActionListener(new SearchListener());
        BSearch.setFont(new Font("Serif", Font.ITALIC, 18));
        panel.add(BSearch);
        textarea = new JTextArea(20, 30);
        textarea.setBackground(Color.lightGray);
        scroll = new JScrollPane(textarea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
        
    

    }


    //build panel check box
   private void checkpanel() {
        panelch = new JPanel();
        id = new JLabel("Enter The child's ID: ");
        id.setFont(new Font("Serif", Font.ITALIC, 18));

        TchID = new JTextField(16);
        TchID.setFont(new Font("Serif", Font.ITALIC, 18));

        Lch = new JLabel("Did the child attend the appointment or not?");
        Lch.setFont(new Font("Serif", Font.ITALIC, 18));

        chatt = new JCheckBox("Attended");
        chnoatt = new JCheckBox("Did not attend");
        chatt.setFont(new Font("Serif", Font.ITALIC, 18));
        chnoatt.setFont(new Font("Serif", Font.ITALIC, 18));

        chatt.addItemListener(new CheckBoxListener());
        chnoatt.addItemListener(new CheckBoxListener());

        chatt.setBackground(Color.WHITE);
        chnoatt.setBackground(Color.WHITE);

        panelch.add(id);
        panelch.add(TchID);
        panelch.add(Lch);
        panelch.add(chatt);
        panelch.add(chnoatt);
        
        

        //save button
        save = new JButton("Save");
        save.addActionListener(new SaveListener());
        save.setFont(new Font("Serif", Font.ITALIC, 18));

        //back button
        Bback = new JButton("Back");
        Bback.addActionListener(new BackListener());
        Bback.setFont(new Font("Serif", Font.ITALIC, 18));

        panelch.add(save);
        panelch.add(Bback);

    }


    //action listener for save button
    private class SaveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                FileOutputStream fs = new FileOutputStream("Attend.dat");
                DataOutputStream ds = new DataOutputStream(fs);
                ObjectOutputStream os = new ObjectOutputStream(ds);

                os.writeUTF(TchID.getText());
                os.writeUTF(chatt.getText());
                os.writeUTF(chnoatt.getText());
                
              JOptionPane.showMessageDialog(null, "Successfully Saved");

                os.close();
                
            } catch (Exception e1) {
                System.out.println(e1);
            }

        }

    }

    //action listener for check box
    private class CheckBoxListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

        }
    }

    //action listener for back button
    private class BackListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            StartPage sp = new StartPage();

        }
    }

    //action listener for search button
    private class SearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                FileInputStream fin = new FileInputStream("Reservation.dat");
                while (true) {

                    try {
                        ObjectInputStream oin = new ObjectInputStream(fin);
                        ReservationModel reservation = (ReservationModel) oin.readObject();
                        textarea.append(reservation.toString());
                        System.out.println(reservation);
                       
                    } catch (EOFException exp) {
                        break;
                    }
                }
                fin.close();
                textarea.requestFocus();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }

    }
}
