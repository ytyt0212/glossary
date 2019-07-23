package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sql.Sql;
 
public class IndexPage2 extends JPanel {
    JButton btn1,btn2,btn3;
    
    MainPage mf;
    String str;
    JTextArea meantext ;
    public IndexPage2(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("索引検索結果");
        paneltitle.setBounds(250, 5, 400, 40);
        this.add(paneltitle);
        
        //テキストエリア「説明」
        meantext = new JTextArea(20,10);
        meantext.setBounds(100,150,380,200);
        meantext.setLineWrap(true);
        this.add(meantext);
        
        

 
        
      
        
        btn1 = new JButton("単語検索");  
        btn1.setBounds(0, 527,200, 40); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[1]);   
            }
        });
        this.add(btn1);   
        
        btn2 = new JButton("戻る");
        btn2.setBounds(195, 527,200, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[7]);  
            }
        });
        this.add(btn2);
        
        btn3 = new JButton("メインページへ");
        btn3.setBounds(394, 527, 200, 40);
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
    public void select_sql2(){
    	List<String> list = new ArrayList<String>();
        Sql a = new Sql();

        StringBuilder s1 = new StringBuilder();
        s1.append("select words from glossary where words ='");
        s1.append(IndexPage1.text);
        s1.append("'");
        String s2 = s1.toString();
        list.add(a.sql(s2));
        for(int i = 0 ; i < list.size() ; i++ ){
        	meantext.setText(list.get(i)+"\n");
            
        }
    }
    	
}
