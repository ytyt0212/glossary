package gui;


	import java.awt.Font;
import java.awt.event.ActionEvent;
	

	import java.awt.event.ActionListener;
	 
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	 
	public class UpdatePage1 extends JPanel {
	    JButton btn = new JButton("メインページへ");  
	    JButton btn2 = new JButton("検索");
	    MainPage mf;
	    String str;
	    static String updateWord;
	    JTextField words;
	    public UpdatePage1(MainPage m,String s){
	        mf = m;
	        str = s;
	        this.setName(s);
	        this.setLayout(null);
	        this.setSize(1000,1000);
	        
	        //単語更新ラベル
	        JLabel paneltitle = new JLabel("単語更新");
	        paneltitle.setBounds(260, 5, 400, 40);
	        paneltitle.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 20));
	        this.add(paneltitle);
	        
	        //単語ラベル
	        JLabel tango = new JLabel("単語");
	        tango.setBounds(70,50,50,40);
	        this.add(tango);
	        
	        //メインページへボタン
	        btn.setBounds(394, 527, 200, 40);
	        btn.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	//メインページへ戻る
	                pc(mf.PanelNames[0]);
	            }
	        });
	        this.add(btn);
	        
	        //検索ボタン
	        btn2.setBounds(190,200,200,40);
	        btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//検索する単語のセット
					updateWord = words.getText();
					//UpdatePage2へ遷移
	        		pc(mf.PanelNames[6]);
				}


	        });
	        this.add(btn2);
	        //単語のテキストエリア設定
	        words = new JTextField(20);
	        words.setBounds(130,50,100,40);
	        this.add(words);
	        
	        
	    }
	    
	    
	    public void pc(String str){
	        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
	    }
	    public void resetText() {
	    	//テキストエリアリセット
	    	words.setText("");
	    }
	}
	




