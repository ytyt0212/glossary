package gui;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	 
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	 
	public class UpdatePage1 extends JPanel {
	    JButton btn = new JButton("トップに戻る");  
	    JButton btn2 = new JButton("検索");
	    MainPage mf;
	    String str;
	    public UpdatePage1(MainPage m,String s){
	        mf = m;
	        str = s;
	        this.setName(s);
	        this.setLayout(null);
	        this.setSize(400, 400);
	        
	        JLabel paneltitle = new JLabel("更新");
	        paneltitle.setBounds(0, 5, 400, 40);
	        this.add(paneltitle);
	        
	        btn.setBounds(150, 50, 200, 40);
	        btn.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	                pc(mf.PanelNames[0]);
	            }
	        });
	        this.add(btn);
	        
	       
	        btn2.setBounds(170, 300, 200, 50);
	        btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	        		pc(mf.PanelNames[6]);
				}


	        });
	        this.add(btn2);
	        //Float f = (float) Math.random();
	        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
	    }
	    
	    
	    public void pc(String str){
	        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
	    }
	}
	




