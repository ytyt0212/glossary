package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdatePage2 extends JPanel {
	JButton btn1 = new JButton("トップ");
	JButton btn2 = new JButton("戻る");
	JButton btn3 = new JButton("更新");
	MainPage mf;
	String str;
	
	public UpdatePage2(MainPage m,String s) {
		mf = m;
		str = s;
		
		JLabel paneltitle = new JLabel("検索結果");
        paneltitle.setBounds(5, 0, 400, 40);
        this.add(paneltitle);
        
        btn1.setBounds(150, 50, 200, 40);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);
            }
        });
        this.add(btn1);
        
       
        btn2.setBounds(170, 300, 200, 50);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		pc(mf.PanelNames[4]);
			}


        });
        this.add(btn2);
        
        btn3.setBounds(190,320,200,50);
        
        this.add(btn3);
        
        String []  categorydata = {"テクノロジ","マネジメント","ストラテジ"};
        JComboBox category = new JComboBox(categorydata);
        category.setBounds(400,50,150,55);
        this.add(category);
        
        JTextField wordstext = new JTextField(200);
        wordstext.setBounds(150,50,100,40);
        this.add(wordstext);
        
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    
    
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);//MainPanelに戻る
    
	}
}




