package gui;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPage1 extends JPanel {
	static JButton btn1 = new JButton("メインページへ");
	static JButton btn2 = new JButton("検索");
	MainPage mf;
	String str;
	JTextField wordstext;
	static String searchWord;

	public SearchPage1(MainPage m, String s) {
		mf = m;
		str = s;
		this.setName(s);
		this.setLayout(null);
		this.setSize(1000, 1000);

		// 単語検索タイトル表示
		JLabel paneltitle = new JLabel("単語検索");
		paneltitle.setBounds(268, 5, 400, 40);
		this.add(paneltitle);

		// テキストボックス横に「単語」表示
		JLabel wordslabel = new JLabel("単語");
		wordslabel.setBounds(200, 100, 50, 40);
		this.add(wordslabel);

		// テキストボックス「単語」
		wordstext = new JTextField(1);
		wordstext.setBounds(330, 100, 100, 40);
		this.add(wordstext);

		// プルダウンメニュー横に「カテゴリ」表示
		JLabel categorylabel = new JLabel("カテゴリ");
		categorylabel.setBounds(180, 200, 80, 40);
		this.add(categorylabel);

		// プルダウンメニュー「カテゴリ」
		String[] categorydata = { "テクノロジ", "マネジメント", "ストラテジ" };
		JComboBox category = new JComboBox(categorydata);
		category.setBounds(330, 200, 100, 40);
		this.add(category);

		// 検索画面遷移
		btn2.setBounds(195, 320, 200, 40);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchWord = wordstext.getText();
				pc_result();
			}
		});
		this.add(btn2);

		// メインページ画面遷移
		btn1.setBounds(394, 527, 200, 40);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc_main();
			}
		});
		this.add(btn1);

		}

	public void pc_main() {
		mf.PanelChange((JPanel) this, mf.PanelNames[0]);// メインページへ戻る
	}

	public void pc_result() {
		mf.PanelChange((JPanel) this, mf.PanelNames[4]);// SearchPage2へ遷移
	}

	public void resetText() {
		//テキストエリアのリセット
		wordstext.setText("");
	}
}