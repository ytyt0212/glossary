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

 
public class InsertPage extends JPanel {
    JButton btn = new JButton("メインページへ");  
    JComboBox category2;
    JTextField words = null ;
    JTextArea wordstext = null ;
    
    MainPage mf;
    String str;
    Sql insert = new Sql();
    
    
    public InsertPage(MainPage m,String s){
    	
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("単語登録");
        paneltitle.setBounds(260, 5, 400, 40);
        //テキストボックス横に「単語」表示
        JLabel tango = new JLabel("単語");
        tango.setBounds(70,50,50,40);
        this.add(tango);
        JTextField text1 = new JTextField (20);
        
        //テキストボックス「単語」
        words = new JTextField(20);
        words.setBounds(130,50,100,40);
        this.add(words);
        
        //プルダウンメニュー横に「カテゴリ」表示
        JLabel categorylabel = new JLabel("カテゴリ");
        categorylabel.setBounds(280,50,80,40);
        this.add(categorylabel);
        
        //プルダウンメニュー「カテゴリ」
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        JComboBox category = new JComboBox(categorydata);
        category.setBounds(350,50,100,40);
        this.add(category);
        
        
        //プルダウンメニュー「ア」
        String []  categorydata2= {"ア","カ","サ","タ","ナ","ハ","マ","ヤ","ラ","ワ"};
        category2 = new JComboBox(categorydata2);
        category2.setBounds(400,100,50,40);
        this.add(category2);
        
        //プルダウンメニュー「ア」の横に「行」の表示
        JLabel tango2 = new JLabel("行");
        tango2.setBounds(460,100,50,40);
        this.add(tango2);
        
        
        

        //テキストエリア「説明」
        wordstext = new JTextArea(20,10);
        wordstext.setBounds(100,150,380,200);
        wordstext.setLineWrap(true);
        this.add(wordstext);
        
        //ボタン「登録」
        JButton btn2 = new JButton("登録");
        btn2.setBounds(195,380,200,40);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gojuon ;
				int c_id ;
				gojuon = (String) category2.getSelectedItem();
				c_id = category.getSelectedIndex()+1;
				StringBuilder i1 = new StringBuilder();
				i1.append("insert into glossary(words,text,category_id,50on) values('");
				i1.append(words.getText());
				i1.append("','");
				i1.append(wordstext.getText());
				i1.append("','");
				i1.append(c_id);
				i1.append("','");
				i1.append(gojuon);
				i1.append("')");
				String i2 = i1.toString();
				System.out.println(i2);
				if(words.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "単語を入力してください");
				
				}else {
					insert.sql(i2);
					JOptionPane.showMessageDialog(null, "登録しました");
					pc();
					
				}
       
			}
        });
        this.add(btn2);
        
        
        this.add(text1);
        this.add(paneltitle);
        btn.setBounds(394, 527, 200, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc();
            }
        });
        this.add(btn);
       
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0]);//MainPanel�ɖ߂�
    }
    public void resetText() {
    	words.setText("");
    	wordstext.setText("");
    }
    	
    
}

