package gui;


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
	    public UpdatePage1(MainPage m,String s){
	        mf = m;
	        str = s;
	        this.setName(s);
	        this.setLayout(null);
	        this.setSize(1000,1000);
	        
	        JLabel paneltitle = new JLabel("単語更新");
	        paneltitle.setBounds(260, 5, 400, 40);
	        this.add(paneltitle);
	        
	        JLabel tango = new JLabel("単語");
	        tango.setBounds(70,50,50,40);
	        this.add(tango);
	        
	        btn.setBounds(394, 527, 200, 40);
	        btn.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	                pc(mf.PanelNames[0]);
	            }
	        });
	        this.add(btn);
	        
	       
	        btn2.setBounds(190,200,200,40);
	        btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	        		pc(mf.PanelNames[6]);
				}


	        });
	        this.add(btn2);
	        
	        JTextField words = new JTextField(20);
	        words.setBounds(130,50,100,40);
	        this.add(words);
	        
	        
	    }
	    
	    
	    public void pc(String str){
	        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
	    }
	}
	




