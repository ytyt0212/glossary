package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
 
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
        JLabel paneltitle = new JLabel("50音を入力してください");
        paneltitle.setBounds(220, 5, 400, 40);
        this.add(paneltitle);
        
        JLabel paneltext = new JLabel("索引");
        paneltext.setBounds(180,150,400,100);
        this.add(paneltext);
        
       String[] categorydata = {"ア行","カ行", "サ行","タ行","ナ行","ハ行","マ行","ヤ行","ラ行","ワ行"};
       JComboBox category = new  JComboBox(categorydata);
       category.setBounds(300,170,150,55);
       this.add(category);
        
        btn1 = new JButton("実行");  
        btn1.setBounds(195, 330,200, 40); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[8]);   
            }
        });
        this.add(btn1);   
        
        btn2 = new JButton("メインページへ");
        btn2.setBounds(394, 527, 200, 40);
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
