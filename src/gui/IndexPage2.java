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
    JTextArea words ;
    JTextArea category;
    public static List<String> listWord = new ArrayList<String>();;
	public static List<String> listCategory = new ArrayList<String>();;
    public IndexPage2(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        
        //索引検索結果ラベル
        JLabel paneltitle = new JLabel("索引検索結果");
        paneltitle.setBounds(250, 5, 400, 40);
        this.add(paneltitle);
        
        //テキストエリア「説明」
        words = new JTextArea(20,10);
        words.setBounds(50,50,500,400);
        words.setLineWrap(true);
        this.add(words);      
      
        //単語検索ボタン
        btn1 = new JButton("単語検索");  
        btn1.setBounds(0, 527,200, 40); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
                pc(mf.PanelNames[1]);   
            }
        });
        this.add(btn1);   
        
        //戻るボタン
        btn2 = new JButton("戻る");
        btn2.setBounds(195, 527,200, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	//IndexPage1へ遷移
                pc(mf.PanelNames[7]);  
            }
        });
        this.add(btn2);
        
        //メインページへ戻るボタン
        btn3 = new JButton("メインページへ");
        btn3.setBounds(394, 527, 200, 40);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	//メインページへ戻る
                pc(mf.PanelNames[0]);  
            }
        });
        this.add(btn3);
       
        
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);  
    }
    //索引検索SQL
    public void select_sql2(){
    	listWord = new ArrayList<String>();
    	listCategory = new ArrayList<String>(); 	
        Sql sql = new Sql();

        StringBuilder s1 = new StringBuilder();
        s1.append("select words from glossary where 50on ='");
        s1.append(IndexPage1.text);
        s1.append("'");
        String s2 = s1.toString();
        
        StringBuilder c1 = new StringBuilder();
        c1.append("select category_name from glossary,category where "
        		+ "glossary.category_id = category.category_id and 50on='");
        c1.append(IndexPage1.text);
        c1.append("'");
        String c2 = c1.toString();
        
        //SQLの起動
        listWord.add(sql.sql(s2));
        listCategory.add(sql.sql(c2));
        
        //結果のセット
        for(int i = 0 ; i < listWord.size()-1 && i < 30; i++ ){
        	words.append(listWord.get(i)+"\t"+listCategory.get(i)+"\n");	
        }
        
    }
    public void resetText() {
    	//テキストエリアのリセット
    	words.setText("");
    }
    	
}
