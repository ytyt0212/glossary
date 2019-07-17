package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sql.Sql;

public class UpdatePage2 extends JPanel {
	JButton btn1 = new JButton("メインページへ");
	JButton btn2 = new JButton("戻る");
	JButton btn3 = new JButton("更新");
	MainPage mf;
	String str;
	JTextArea wordstext;
	JTextField words;
	JComboBox category;
    Sql sql = new Sql();

	public UpdatePage2(MainPage m,String s) {
		mf = m;
		str = s;
		this.setName(s);
    	this.setLayout(null);
    	this.setSize(1000,1000);
		
		JLabel paneltitle = new JLabel("検索結果");
        paneltitle.setBounds(260, 5, 400, 40);
        this.add(paneltitle);
        
        btn1.setBounds(394, 527, 200, 40);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);
            }
        });
        this.add(btn1);
        
       
        btn2.setBounds(195, 527,200, 40);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		pc(mf.PanelNames[5]);
			}


        });
        this.add(btn2);
        
        btn3.setBounds(190,350,200,40);
        btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		
        		int c_id ;
        		c_id = category.getSelectedIndex()+1;
        		StringBuilder u1 = new StringBuilder();
            	u1.append("update glossary set text ='");
                u1.append(wordstext.getText());
                u1.append("',category_id = '");
                u1.append(c_id);
                u1.append("'");
                u1.append(" where words ='");
                u1.append(words.getText());
                u1.append("'");
                String u2 = u1.toString();
                System.out.println(u2);
                sql.sql(u2);
        		
			}


        });
       
        	
        this.add(btn3);
        
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        category = new JComboBox(categorydata);
        category.setBounds(300,100,150,25);
        this.add(category);
        //説明文
        wordstext = new JTextArea(10,20);
        wordstext.setBounds(55,200,450,130);
        wordstext.setLineWrap(true);
        this.add(wordstext);
        //単語
        words = new JTextField(20);
        words.setBounds(130,93,100,40);
        this.add(words);
        
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    
    
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
    
	}
    
    public void search_sql() {
    	//単語参照SQL文
    	StringBuilder s1 = new StringBuilder();
    	s1.append("select words from glossary where words ='");
        s1.append(UpdatePage1.updateWord);
        s1.append("'");
        String s2 = s1.toString();
        
        //単語のセット
        words.setText(sql.sql(s2));
        
        JOptionPane.showMessageDialog(null, "単語が見つかりません","エラー",JOptionPane.ERROR_MESSAGE);

    }
}




