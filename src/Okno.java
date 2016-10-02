import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Okno extends JFrame {
	final static boolean shouldFill = true; 
	static JTextArea workwindoow=new JTextArea();
	//static JButton openpdf=new JButton("open");
	static JButton exit=new JButton("exit");
	ActionListener ALexit=new ALclose();
	ActionListener Opdf=new Openpdf();
	ActionListener Ofile=new Openfile();
	ActionListener NewFile=new NewPDF();
	
	Okno(){
		super("Home");
		
		JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New...");
        JMenuItem open = new JMenuItem("Open...");
        fileMenu.add(newItem);
        fileMenu.add(open);
        menuBar.add(fileMenu);
        open.addActionListener(Ofile);
        newItem.addActionListener(NewFile);
        
        JPanel pane=new JPanel();
        pane.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints(); 
         /*
        if (shouldFill) { 
            // натуральная высота, максимальная ширина 
            c.fill = GridBagConstraints.HORIZONTAL; 
        } 
        */
		//JPanel pane=new JPanel();
		//pane.setLayout(new GridLayout(3,1));
		
		
		
		//pane.add(workwindoow);
		c.fill = GridBagConstraints.BOTH; 
        c.weighty=0.9;
		c.weightx = 1; 
        c.gridx = 0; 
        c.gridy = 0; 
        pane.add(workwindoow, c); 
		//pane.add(openpdf);
        c.fill = GridBagConstraints.BOTH; 
        c.weightx = 1;
        c.weighty=0.1;
        c.gridx = 0; 
        c.gridy = 1; 
        pane.add(exit, c);
		//pane.add(exit);
		exit.addActionListener(ALexit);
		
		setJMenuBar(menuBar);
		setContentPane(pane);
		pack();
		

}
}