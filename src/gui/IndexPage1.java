package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class IndexPage1 extends JPanel {
    JButton btn1,btn2;
    
    MainPage mf;
    String str;
    public IndexPage1(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("索引");
        paneltitle.setBounds(0, 5, 400, 40);
        this.add(paneltitle);
        
        JLabel paneltext = new JLabel("索引");
        paneltext.setBounds(30,10,400,100);
        this.add(paneltext);
        
        btn1 = new JButton("実行");  
        btn1.setBounds(170, 300,200, 50); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[6]);   
            }
        });
        this.add(btn1);   
        
        btn2 = new JButton("トップへ");
        btn2.setBounds(383, 520, 200, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);  
            }
        });
        this.add(btn2);
       
        
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);  
    }
}
