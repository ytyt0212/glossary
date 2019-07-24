package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
 

public class IndexPage1 extends JPanel {
    JButton btn1,btn2;
    
    MainPage mf;
    String str;
    static String text;
    
    public IndexPage1(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(1000, 1000);
        
        //50音ラベル
        JLabel paneltitle = new JLabel("50音を入力してください");
        paneltitle.setBounds(220, 5, 400, 40);
        this.add(paneltitle);
        
        //索引ラベル
        JLabel paneltext = new JLabel("索引");
        paneltext.setBounds(180,150,400,100);
        this.add(paneltext);
        
        //50音プルダウンメニュー
       String[] categorydata2 = {"ア","カ", "サ","タ","ナ","ハ","マ","ヤ","ラ","ワ"};
       JComboBox category = new  JComboBox(categorydata2);
       category.setBounds(310,180,50,40);
       this.add(category);
       
      
       
       
       //プルダウンメニュー「ア」の横に「行」の表示
       JLabel category2 = new JLabel("行");
       category2.setBounds(380,180,50,40);
		this.add(category2);
        
		//実行ボタン
        btn1 = new JButton("実行");  
        btn1.setBounds(195, 330,200, 40); 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	//選択した50音の内容を変数に入れる
            	text=(String) category.getSelectedItem();
            	//IndexPage2へ遷移
                pc(mf.PanelNames[8]);   
            }
        });
        this.add(btn1);   
        
        //メインページへ戻る
        btn2 = new JButton("メインページへ");
        btn2.setBounds(394, 527, 200, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	//メインページへ戻る
                pc(mf.PanelNames[0]);  
            }
        });
        this.add(btn2);
       
        
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);  
    }
}
