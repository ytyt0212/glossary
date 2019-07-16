package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sql.Sql;

public class SearchPage2 extends JPanel {
	JButton btn1 = new JButton("メインページへ");
	JButton btn2 = new JButton("戻る");
	JButton btn3 = new JButton("単語更新");
	MainPage mf;
    String str;
    JTextField wordstext;
    JTextField setumei;
    JTextField category;
    Sql search = new Sql();
    
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
         wordslabel.setBounds(70,50,50,40);
         this.add(wordslabel);
         
         //テキストボックス単語        
         wordstext = new JTextField(1);        
         wordstext.setBounds(130,50,100,40);
      
         this.add(wordstext);
         
       //「カテゴリ」表示
         JLabel categorylabel = new JLabel("カテゴリ");
         categorylabel.setBounds(280,50,80,40);
         this.add(categorylabel);
         
         //テキストボックスカテゴリ
         category = new JTextField(1);
         category.setBounds(350,50,100,40);
         this.add(category);
         
         //単語説明
         setumei = new JTextField(5);
         setumei.setBounds(100,150,380,200);
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
    public void select_sql() {
    	//単語の参照SQL文
    	StringBuilder s1 = new StringBuilder();
        s1.append("select words from glossary where words ='");
        s1.append(SearchPage1.searchWord);
        s1.append("'");
        String s2 = s1.toString();
        
        //単語の説明SQL文
        StringBuilder t1 = new StringBuilder();
        t1.append("select text from glossary where words ='");
        t1.append(SearchPage1.searchWord);
        t1.append("'");
        String t2 = t1.toString();
        
        //カテゴリの参照SQL文
        StringBuilder c1 = new StringBuilder();
        c1.append("select category_name from glossary,category where "
        		+ "glossary.category_id = category.category_id and words ='");
        c1.append(SearchPage1.searchWord);
        c1.append("'");
        String c2 = c1.toString();
        
        
        //参照結果のセット
        wordstext.setText(search.sql(s2)); 
        setumei.setText(search.sql(t2));
        category.setText(search.sql(c2));
        
        System.out.println(search.sql(s2));
        System.out.println(search.sql(t2));
        System.out.println(c2);
       
       
        	
        
   
    }
}
