package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPage2 extends JPanel {
	JButton btn1 = new JButton("メインページへ");
	JButton btn2 = new JButton("戻る");
	JButton btn3 = new JButton("単語更新");
	MainPage mf;
    String str;
    
    public SearchPage2(MainPage m,String s) {
    	mf = m;
    	str = s;
    	this.setName(s);
    	this.setLayout(null);
    	this.setSize(1000,1000);
    	
    	//単語検索結果タイトル表示
    	 JLabel paneltitle = new JLabel("単語検索結果");
         paneltitle.setBounds(250, 5, 400, 40);
         this.add(paneltitle);
         
         //「単語」表示
         JLabel wordslabel = new JLabel("単語");
         wordslabel.setBounds(30,50,50,40);
         this.add(wordslabel);
         
         //テキストボックス単語
         JTextField wordstext = new JTextField(1);
         wordstext.setBounds(80,50,100,40);
         this.add(wordstext);
         
       //「カテゴリ」表示
         JLabel categorylabel = new JLabel("カテゴリ");
         categorylabel.setBounds(240,50,80,40);
         this.add(categorylabel);
         
         //テキストボックスカテゴリ
         JTextField category = new JTextField(1);
         category.setBounds(320,50,100,40);
         this.add(category);
         
         //単語説明
         JTextField setumei = new JTextField(5);
         setumei.setBounds(120,100,250,200);
         this.add(setumei);
         
         
         //戻る画面遷移
         btn2.setBounds(195, 527,200, 40);
         btn2.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 pc_search1();
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
         
         
    }
    public void pc_search1() {
    	 mf.PanelChange((JPanel)this, mf.PanelNames[1]);
    }
    public void pc_main() {
    	mf.PanelChange((JPanel)this, mf.PanelNames[0]);
   }
}
