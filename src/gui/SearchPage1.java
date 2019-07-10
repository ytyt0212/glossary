package gui;


//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class SearchPage1 extends JPanel {
    JButton btn1 = new JButton("メインページへ");
    JButton btn2 = new JButton("検索");
    MainPage mf;
    String str;
    public SearchPage1(MainPage m,String s) {
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        
        //単語検索タイトル表示
        JLabel paneltitle = new JLabel("単語検索");
        paneltitle.setBounds(260, 5, 400, 40);
        this.add(paneltitle);
        
        //テキストボックス横に「単語」表示
        JLabel wordslabel = new JLabel("単語");
        wordslabel.setBounds(200,50,50,40);
        this.add(wordslabel);
        
        //テキストボックス「単語」
        JTextField wordstext = new JTextField(1);
        wordstext.setBounds(250,50,100,40);
        this.add(wordstext);
        
        //プルダウンメニュー横に「カテゴリ」表示
        JLabel categorylabel = new JLabel("カテゴリ");
        categorylabel.setBounds(180,150,80,40);
        this.add(categorylabel);
        
        //プルダウンメニュー「カテゴリ」
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        JComboBox category = new JComboBox(categorydata);
        category.setBounds(250,150,100,40);
        this.add(category);
        		
        
        //検索画面遷移
        btn2.setBounds(195, 527,200, 40);       
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc_result();
            }
        });
        this.add(btn2);
        
        //メインページ画面遷移
        btn1.setBounds(394, 527, 200, 40);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc_main();
            }
        });
        this.add(btn1);
       
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    
  
    public void pc_main(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0]);//MainPanel�ɖ߂�
    }
    public void pc_result(){
        mf.PanelChange((JPanel)this, mf.PanelNames[4]);//MainPanel�ɖ߂�
    }
}