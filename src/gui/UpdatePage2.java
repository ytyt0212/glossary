package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdatePage2 extends JPanel {
	JButton btn1 = new JButton("メインページへ");
	JButton btn2 = new JButton("戻る");
	JButton btn3 = new JButton("更新");
	MainPage mf;
	String str;
	
	public UpdatePage2(MainPage m,String s) {
		mf = m;
		str = s;
		this.setName(s);
    	this.setLayout(null);
    	this.setSize(1000,1000);
		
		JLabel paneltitle = new JLabel("検索結果");
        paneltitle.setBounds(250, 5, 200, 100);
        this.add(paneltitle);
        
        btn1.setBounds(360, 500, 200, 40);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);
            }
        });
        this.add(btn1);
        
       
        btn2.setBounds(100, 500, 200, 40);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		pc(mf.PanelNames[5]);
			}


        });
        this.add(btn2);
        
        btn3.setBounds(400,350,200,40);
        
        this.add(btn3);
        
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        JComboBox category = new JComboBox(categorydata);
        category.setBounds(300,100,150,25);
        this.add(category);
        
        JTextField wordstext = new JTextField(200);
        wordstext.setBounds(55,200,450,130);
        this.add(wordstext);
        
        JTextField words = new JTextField(20);
        words.setBounds(100,100,150,25);
        this.add(words);
        
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    
    
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
    
	}
}




