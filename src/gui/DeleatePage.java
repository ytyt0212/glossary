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
    JTextField words = new JTextField(20);
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
        
        
        words.setBounds(130,50,100,40);
        
        
        
        btn.setBounds(394, 527, 200, 40);
        btn2.setBounds(190,200,200,40);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		
        		
        		StringBuilder d1 = new StringBuilder();
            	d1.append("delete from glossary where words ='");
            	d1.append(words.getText());
            	d1.append("'");
                String d2 = d1.toString();
                System.out.println(d2);
                
                StringBuilder s1 = new StringBuilder();
            	s1.append("select words from glossary where words ='");
            	s1.append(words.getText());
            	s1.append("'");
                String s2 = s1.toString();
                System.out.println(s2);
                
                
                if(sql.sql(s2) == null) {
                	JOptionPane.showMessageDialog(null, "削除できませんでした");
                	resetText();
                }else {
                	JOptionPane.showMessageDialog(null, "削除しました");
                	sql.sql(d2);
                	pc();
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
        this.add(words);
        
              
       
    }
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0]);//MainPanel�ɖ߂�
    }
    public void resetText() {
    	words.setText("");
    }
}

