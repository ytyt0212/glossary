package main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sample extends JFrame implements ActionListener{
	
 
	  JPanel panel;
	  CardLayout layout;
	  
	  public static void main(String[] args) {
	    sample frame = new sample();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(10, 10, 500, 500);
	    frame.setTitle("My glossary");
	    frame.setVisible(true);
	  }
	  sample(){
	    /* View1 */
	    JPanel card1 = new JPanel();
	   
	    card1.add(new JButton("索引"));

	    /* View2 */
	    JPanel card2 = new JPanel();
	    card2.add(new JLabel("索引"));
	    card2.add(new JCheckBox("checkbox1"));
	    card2.add(new JCheckBox("checkbox2"));
	    
	    /* CardLayout準備 */
	    this.panel = new JPanel();
	    this.layout = new CardLayout();//CardLayoutの作成
	    this.panel.setLayout(this.layout);
	    /* panelにViewを追加 */
	    this.panel.add(card1, "メインページ");
	    this.panel.add(card2, "索引");
	    
	    /* カード移動用ボタン */
	    JButton button1 = new JButton("メインページ");
	    button1.addActionListener(this);
	    button1.setActionCommand("メインページ");

	    JButton button2 = new JButton("索引");
	    button2.addActionListener(this);
	    button2.setActionCommand("索引");

	    JPanel btnPanel1= new JPanel();
	    btnPanel1.add(button1);
	    
	    JPanel btnPanel2 = new JPanel()
	    ;
	    btnPanel2.add(button2);
	    
	

	    getContentPane().add(this.panel, BorderLayout.CENTER);
	  
	    getContentPane().add(btnPanel2,BorderLayout.LINE_END);
	  }
	  public void actionPerformed(ActionEvent e) {
	    // TODO 自動生成されたメソッド・スタブ
	    String cmd = e.getActionCommand();
	    layout.show(this.panel,cmd);
	  }
	}

