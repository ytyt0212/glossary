package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	public String[] PanelNames = {"mp","Sub1","Sub2","Sub3"};
    MainPage main = new MainPage(this,PanelNames[0]);
    SearchPage1 sp = new SearchPage1(this,PanelNames[1]);
    InsertPage sp2 = new InsertPage(this,PanelNames[2]);
    UpdatePage sp3 = new UpdatePage(this,PanelNames[3]);
     
    public MainFrame(){
        this.add(main);main.setVisible(true);
        this.add(sp);sp.setVisible(false);
        this.add(sp2);sp2.setVisible(false);
        this.add(sp3);sp3.setVisible(false);
        this.setBounds(00, 00, 600, 600);
    }
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
    public void PanelChange(JPanel jp, String str){
       
        System.out.println(jp.getName());
        String name = jp.getName();
        if(name==PanelNames[0]){
            main = (MainPage)jp;
            main.setVisible(false);
        }else if(name==PanelNames[1]){
            sp = (SearchPage1)jp;
            sp.setVisible(false);
        }else if(name==PanelNames[2]){
            sp2 = (InsertPage)jp;
            sp2.setVisible(false);
        }else if(name==PanelNames[3]){
            sp3 = (UpdatePage
            		)jp;
            sp3.setVisible(false);
        }
        if(str==PanelNames[0]){
            main.setVisible(true);
        }else if(str==PanelNames[1]){
            sp.setVisible(true);
        }else if(str==PanelNames[2]){
            sp2.setVisible(true);
        }else if(str==PanelNames[3]){
           sp3.setVisible(true);
        }
    }
}


