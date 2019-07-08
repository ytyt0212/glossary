package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class MainPanel extends JPanel {
    JButton btn,btn2,btn3;
    JLabel paneltitle;
    MainFrame mf;
    String str;
    public MainPanel(MainFrame m,String s){
        mf = m;
        str = s;
        this.setName("mp");
        this.setLayout(null);
        this.setSize(500, 200);
        paneltitle = new JLabel("My Glossary");
        paneltitle.setBounds(180,10, 500, 40);
        this.add(paneltitle);
        btn = new JButton("åüçı");
        btn.setBounds(20, 50,420, 50);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[1]);
            }
        });
        this.add(btn);
        btn2 = new JButton("ìoò^");
        btn2.setBounds(20, 100, 420, 50);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[2]);
            }
        });
        this.add(btn2);
        btn3 = new JButton("çÌèú");
        btn3.setBounds(20, 150, 420, 50);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[3]);
            }
        });
        this.add(btn3);
      //  this.setBackground(Color.getHSBColor(0,255,255));
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);
    }
}



