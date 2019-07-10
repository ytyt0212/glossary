package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	JButton btn, btn2, btn3, btn4,btn5;
	JLabel paneltitle;
	MainPage mf;
	String str;

	public MainPanel(MainPage m, String s) {
		mf = m;
		str = s;
		this.setName("mp");
		this.setLayout(null);
		this.setSize(1000, 1000);
		paneltitle = new JLabel("My Glossary");
		paneltitle.setBounds(180, 10, 500, 40);
		this.add(paneltitle);

		btn = new JButton("単語検索");
		btn.setBounds(20, 50, 420, 50);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[1]);
			}
		});
		this.add(btn);

		btn2 = new JButton("単語登録");
		btn2.setBounds(20, 100, 420, 50);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[2]);
			}
		});
		this.add(btn2);

		btn3 = new JButton("単語削除");
		btn3.setBounds(20, 150, 420, 50);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[3]);
			}
		});
		this.add(btn3);

		btn4 = new JButton("単語更新");
		btn4.setBounds(20, 200, 420, 50);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[5]);
			}
		});
		this.add(btn4);
		
		btn5 = new JButton("索引");
		btn5.setBounds(20, 250, 420, 50);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc(mf.PanelNames[7]);
			}
		});
		this.add(btn5);
	}

	public void pc(String str) {
		mf.PanelChange((JPanel) this, str);
	}
}
