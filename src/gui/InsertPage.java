package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 
public class InsertPage extends JPanel {
    JButton btn = new JButton("メインページへ");  
    MainPage mf;
    String str;
    
    
    public InsertPage(MainPage m,String s){
    	
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        JLabel paneltitle = new JLabel("単語登録");
        paneltitle.setBounds(0, 5, 400, 40);
        //テキストボックス横に「単語」表示
        JLabel tango = new JLabel("単語");
        tango.setBounds(100,50,50,40);
        this.add(tango);
        JTextField text1 = new JTextField (20);
        
        //テキストボックス「単語」
        JTextField wordstext = new JTextField(20);
        wordstext.setBounds(150,50,100,40);
        this.add(wordstext);
        
        //プルダウンメニュー横に「カテゴリ」表示
        JLabel categorylabel = new JLabel("カテゴリ");
        categorylabel.setBounds(300,50,100,40);
        this.add(categorylabel);
        
        //プルダウンメニュー「カテゴリ」
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        JComboBox category = new JComboBox(categorydata);
        category.setBounds(400,50,100,40);
        this.add(category);
        

        //テキストボックス「説明」
        JTextField meantext = new JTextField(200);
        meantext.setBounds(150,150,300,150);
        this.add(meantext);
        
        //ボタン「登録」
        JButton btn2 = new JButton("登録");
        btn2.setBounds(195,330,200,40);
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
}

