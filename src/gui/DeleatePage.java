package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class DeleatePage extends JPanel {
    JButton btn = new JButton("�g�b�v�ɖ߂�");  
    MainPage mf;
    String str;
    public DeleatePage(MainPage m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(400, 200);
        JLabel paneltitle = new JLabel("�P��폜���");
        paneltitle.setBounds(0, 5, 400, 40);
        this.add(paneltitle);
        btn.setBounds(150, 50, 200, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc();
            }
        });
        this.add(btn);
       
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0]);//MainPanel�ɖ߂�
    }
}


