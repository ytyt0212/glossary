package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	   
	    card1.add(new JLabel("メインページ"));
	   
	    /* View2 */
	    JPanel card2 = new JPanel();
	    card2.add(new JLabel("索引"));
	    card2.add(new JTextArea("checkbox1"));
	    card2.add(new JCheckBox("checkbox2"));
	   
	    
	    /* View3 */
	    JPanel card3 = new JPanel();
	    card3.add(new JLabel("単語登録"));
	    
	    /* View4 */
	    JPanel card4 = new JPanel();
	    card4.add(new JLabel("単語更新"));
	    
	    /* View5 */
	    JPanel card5 = new JPanel();
	    card5.add(new JLabel("単語削除"));
	    
	    
	    /* CardLayout準備 */
	    this.panel = new JPanel();
	    this.layout = new CardLayout();//CardLayoutの作成
	    this.panel.setLayout(this.layout);
	    /* panelにViewを追加 */
	    this.panel.add(card1, "メインページ");
	    this.panel.add(card2, "索引");
	    this.panel.add(card3,"単語登録");
	    this.panel.add(card4,"単語更新");
	    this.panel.add(card5,"単語削除");
	    
	    /* カード移動用ボタン */
	    JButton button1 = new JButton("メインページ");
	    button1.addActionListener(this);
	    button1.setActionCommand("メインページ");

	    JButton button2 = new JButton("索引");
	    button2.addActionListener(this);
	    button2.setActionCommand("索引");
	    
	    JButton button3 = new JButton("単語登録");
	    button3.addActionListener(this);
	    button3.setActionCommand("単語登録");

	    JButton button4 = new JButton("単語更新");
	    button4.addActionListener(this);
	    button4.setActionCommand("単語更新");
	    
	    JButton button5 = new JButton("単語削除");
	    button5.addActionListener(this);
	    button5.setActionCommand("単語削除");
	    
	    JPanel btnPanel1= new JPanel();
	    btnPanel1.add(button2);
	    btnPanel1.add(button3);
	    btnPanel1.add(button4);
	    btnPanel1.add(button5);
	    
	    
	    JPanel btnPanel2 = new JPanel();
	    btnPanel2.add(button1);
	    
	    
	

	    getContentPane().add(this.panel, BorderLayout.NORTH);
	    getContentPane().add(btnPanel1, BorderLayout.CENTER);
	    getContentPane().add(btnPanel2,BorderLayout.AFTER_LAST_LINE);
	  }
	  public void actionPerformed(ActionEvent e) {
	    // TODO 自動生成されたメソッド・スタブ
	    String cmd = e.getActionCommand();
	    layout.show(this.panel,cmd);
	    
	  }
	}

