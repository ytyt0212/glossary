package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame {
	public String[] PanelNames = { "mp", "Sub1", "Sub2", "Sub3", "Sub4", "Sub5", "Sub6", "Sub7", "Sub8" };
	MainPanel main = new MainPanel(this, PanelNames[0]);
	SearchPage1 sp = new SearchPage1(this, PanelNames[1]);
	InsertPage sp2 = new InsertPage(this, PanelNames[2]);
	DeleatePage sp3 = new DeleatePage(this, PanelNames[3]);
	SearchPage2 sp4 = new SearchPage2(this, PanelNames[4]);
	UpdatePage1 sp5 = new UpdatePage1(this, PanelNames[5]);
	UpdatePage2 sp6 = new UpdatePage2(this, PanelNames[6]);
	IndexPage1 sp7 = new IndexPage1(this, PanelNames[7]);
	IndexPage2 sp8 = new IndexPage2(this, PanelNames[8]);

	public MainPage() {
		this.add(main);
		main.setVisible(true);
		this.add(sp);
		sp.setVisible(false);
		this.add(sp2);
		sp2.setVisible(false);
		this.add(sp3);
		sp3.setVisible(false);
		this.add(sp4);
		sp4.setVisible(false);
		this.add(sp5);
		sp5.setVisible(false);
		this.add(sp6);
		sp6.setVisible(false);
		this.add(sp7);
		sp7.setVisible(false);
		this.add(sp8);
		sp8.setVisible(false);

		this.setBounds(00, 00, 600, 600);
	}

	public static void main(String[] args) {
		MainPage mf = new MainPage();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setResizable(false);
		mf.setVisible(true);
	}

	public void PanelChange(JPanel jp, String str) {

		System.out.println(jp.getName());
		String name = jp.getName();
		if (name == PanelNames[0]) {
			main = (MainPanel) jp;
			main.setVisible(false);
		} else if (name == PanelNames[1]) {
			sp = (SearchPage1) jp;
			sp.setVisible(false);
		} else if (name == PanelNames[2]) {
			sp2 = (InsertPage) jp;
			sp2.setVisible(false);
		} else if (name == PanelNames[3]) {
			sp3 = (DeleatePage) jp;
			sp3.setVisible(false);
		} else if (name == PanelNames[4]) {
			sp4 = (SearchPage2) jp;
			sp4.setVisible(false);
		} else if (name == PanelNames[5]) {
			sp5 = (UpdatePage1) jp;
			sp5.setVisible(false);
		} else if (name == PanelNames[6]) {
			sp6 = (UpdatePage2) jp;
			sp6.setVisible(false);
	    } else if (name == PanelNames[7]) {
			 sp7 = (IndexPage1) jp;
			 sp7.setVisible(false);
		} else if (name == PanelNames[8]) {
			 sp8 = (IndexPage2) jp;
			 sp8.setVisible(false);
		}

		if (str == PanelNames[0]) {
			main.setVisible(true);
		} else if (str == PanelNames[1]) {
			sp.setVisible(true);
		} else if (str == PanelNames[2]) {
			sp2.setVisible(true);
		} else if (str == PanelNames[3]) {
			sp3.setVisible(true);
		} else if (str == PanelNames[4]) {
			sp4.setVisible(true);
		} else if (str == PanelNames[5]) {
			sp5.setVisible(true);
		} else if (str == PanelNames[6]) {
			sp6.setVisible(true);
		} else if (str == PanelNames[7]) {
			 sp7.setVisible(true);
		}else if (str == PanelNames[8]) {
			sp8.setVisible(true);
		}
	}
}	

