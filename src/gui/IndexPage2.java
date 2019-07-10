package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class IndexPage2 extends JPanel {
    JButton btn1,btn2,btn3;
    
    MainPage mf;
    String str;
    public IndexPage2(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("索引検索結果");
        paneltitle.setBounds(200, 5, 400, 40);
        this.add(paneltitle);
        
  
        
      
        
        btn1 = new JButton("単語検索");  
        btn1.setBounds(0, 520,200, 40); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[1]);   
            }
        });
        this.add(btn1);   
        
        btn2 = new JButton("戻る");
        btn2.setBounds(195, 520, 200, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[5]);  
            }
        });
        this.add(btn2);
        
        btn3 = new JButton("メインページへ");
        btn3.setBounds(386, 520, 200, 40);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);  
            }
        });
        this.add(btn3);
       
        
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);  
    }
}


