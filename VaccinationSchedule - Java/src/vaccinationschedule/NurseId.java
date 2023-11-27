package vaccinationschedule;
import java.awt.*;
import static java.awt.SystemColor.menu;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class NurseId extends JFrame {
         private JPanel pnl;
    private JLabel lbl;
    private JButton btn;
    private JTextField txt;
    public NurseId() {
        
        setTitle("Vaccination Schedule");
        setSize(100,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildpnl();
        add(pnl);
        setVisible(true);
   
}

    private void buildpnl() {
         pnl = new JPanel();
        lbl = new JLabel ("Enter password:");
        txt = new JTextField(10);
        btn = new JButton ("enter");
        btn.addActionListener(new bAction());
        pnl.add(lbl);
        pnl.add(txt);
        pnl.add(btn);
    }
      private class bAction implements ActionListener{
    public void actionPerformed (ActionEvent e){
         if(txt.getText().equals("56nrs65")){
             JOptionPane.showMessageDialog(null,"LoginSuccesful");
                        NursePage n =new NursePage();
    }else{
             JOptionPane.showMessageDialog(null, "Login Failuare");
         }
      }
    }
}