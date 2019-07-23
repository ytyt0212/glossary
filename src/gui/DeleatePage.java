package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sql.Sql;
 
public class DeleatePage extends JPanel {
    JButton btn = new JButton("メインページへ"); 
    JButton btn2 = new JButton("削除"); 
    JTextField text1 = new JTextField(20);
    MainPage mf;
    String str;
    Sql sql = new Sql();
    public DeleatePage(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("単語削除");
        paneltitle.setBounds(260, 5, 400, 40);
        this.add(paneltitle);
        
        
        JLabel paneltext = new JLabel("単語");
        paneltext.setBounds(70,50,50,40);
        this.add(paneltext);
        
        
        text1.setBounds(130,50,100,40);
        
        
        
        btn.setBounds(394, 527, 200, 40);
        btn2.setBounds(190,200,200,40);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		
        		
        		StringBuilder d1 = new StringBuilder();
            	d1.append("delete from glossary where words ='");
            	d1.append(text1.getText());
            	d1.append("'");
                String d2 = d1.toString();
                System.out.println(d2);
                sql.sql(d2);
                if(sql.sql(d2) == "削除しました") {
                JOptionPane.showMessageDialog(null, "削除しました");
                pc();
                }else {
                	JOptionPane.showMessageDialog(null, "削除できませんでした");
                }
			}
        });
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
                pc();
            }
        });
        this.add(btn);
        this.add(btn2);
        this.add(text1);
        
              
       
    }
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0]);//MainPanel�ɖ߂�
    }
}

