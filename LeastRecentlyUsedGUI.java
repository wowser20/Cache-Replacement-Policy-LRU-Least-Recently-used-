import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * Cache Replacement Policy: Least Recently Used 
 * - this program can solve and show solution on every page using Least Recently Used Algorithm.
 * 
 * @author Andrea Ella Remoreras
 * 
 * Final Requirement in CS11L (7788) 
 * - Architecture and Organization
 * 
 */

@SuppressWarnings("serial")
public class LeastRecentlyUsedGUI extends JFrame implements ActionListener, MouseListener{
	private JLabel lbl_title1, lbl_blockrqst, lbl_numberframes,lbl_background,lbl_minimize,lbl_exit;
	private JButton btn_find, btn_clear1, btn_clear2, btn_help, btn_about;
	private JTextField txt_blockrqst, txt_numberframes;
	private JTextArea txt_results;
	private JPanel panel_results,panel_background,panel_all,panel_header;
	private JScrollPane scroller;
	
	int xMouse,yMouse;
	
	
LeastRecentlyUsedGUI(){
	Container pane = getContentPane();
	pane.setLayout(null);
	pane.setBackground(new Color(57, 172, 115));
	
	panel_background = new JPanel();
	panel_background.setLayout(null);
	panel_background.setBackground(new Color(0,102,204));
	
	panel_header = new JPanel();
	panel_header.setBackground(Color.WHITE);
	panel_header.setLayout(null);
	
	panel_all = new JPanel();
	panel_all.setLayout(null);
	panel_all.setBackground(Color.WHITE);
	
	lbl_background=new JLabel();
	Image icon1 = new ImageIcon(this.getClass().getResource("/calculator_64.png")).getImage();
	lbl_background.setIcon(new ImageIcon(icon1));

	
	lbl_minimize= new JLabel("");
	Image icon2 = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
	lbl_minimize.setIcon(new ImageIcon(icon2));
	
	
	lbl_exit=new JLabel("");
	Image icon3 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
	lbl_exit.setIcon(new ImageIcon(icon3));
	
	lbl_title1 = new JLabel("Cache Replacement Policy: LRU (Least Recently Used)");
	lbl_title1.setFont(new Font("Dialog",Font.BOLD,22));
	lbl_title1.setForeground(Color.white);
	
	
	lbl_blockrqst = new JLabel("Block request:");
	lbl_blockrqst.setFont(new Font("SansSerif",Font.BOLD,15));
	
	
	lbl_numberframes = new JLabel("Number of frames:");
	lbl_numberframes.setFont(new Font("SansSerif",Font.BOLD,15));
	
	
	txt_blockrqst = new JTextField("");
	txt_blockrqst.setFont(new Font("Dialog",Font.PLAIN,15));
		
	txt_numberframes = new JTextField("");
	txt_numberframes.setFont(new Font("Dialog",Font.PLAIN,15));
	
	txt_results = new JTextArea("");
	txt_results.setEditable(false);
	txt_results.setFont(new Font("Dialog", Font.PLAIN,17));	
	
	btn_find = new JButton("Find");
	btn_find.setBackground(new Color(122, 209, 167));
	btn_find.setFont(new Font("Dialog", Font.BOLD, 15));	
	btn_find.setForeground(Color.white);
	
	btn_clear1 = new JButton("Clear");
	btn_clear1.setBackground(new Color(122, 209, 167));
	btn_clear1.setFont(new Font("Dialog", Font.BOLD, 15));	
	btn_clear1.setForeground(Color.white);
	
	btn_clear2 = new JButton("Clear");
	btn_clear2.setBackground(new Color(122, 209, 167));
	btn_clear2.setFont(new Font("Dialog", Font.BOLD, 15));	
	btn_clear2.setForeground(Color.WHITE);
	
	btn_help = new JButton("Instructions");
	btn_help.setBackground(new Color(122, 209, 167));
	btn_help.setFont(new Font("Dialog", Font.BOLD, 15));	
	btn_help.setForeground(Color.WHITE);
	
	btn_about = new JButton("About");
	btn_about.setBackground(new Color(122, 209, 167));
	btn_about.setFont(new Font("Dialog", Font.BOLD, 15));	
	btn_about.setForeground(Color.WHITE);
	
	panel_results=new JPanel();
	panel_results.setBorder(BorderFactory.createTitledBorder("RESULTS"));
	panel_results.setBackground(Color.WHITE);
	panel_results.setFont(new Font("Dialog", Font.BOLD, 18));	
	
	scroller=new JScrollPane(txt_results);
	scroller.setViewportView(txt_results);
	scroller.setBorder(null);
	
	panel_header.add(lbl_minimize).setBounds(970,0,24,24);
	panel_header.add(lbl_exit).setBounds(1010,0,30,30);
	
	panel_results.add(txt_results);	

	panel_all.add(lbl_numberframes).setBounds(50, 70, 150,25);panel_all.add(txt_numberframes).setBounds(200,70,50,25);
	panel_all.add(lbl_blockrqst).setBounds(50,120,150,25);panel_all.add(txt_blockrqst).setBounds(200,120,400,25);
	panel_all.add(btn_find).setBounds(200,160,70,30);panel_all.add(btn_clear1).setBounds(300,160,90,30);panel_all.add(btn_help).setBounds(50,20,120,20);panel_all.add(btn_about).setBounds(190,20,80,20);
	panel_all.add(panel_results).setBounds(40, 210, 900,300);panel_all.add(btn_clear2).setBounds(410,520,100,30);
	panel_all.add(scroller).setBounds(60,230,875,275);

	pane.add(panel_header).setBounds(0,0,1050,30);
	pane.add(lbl_background).setBounds(30,35,70,70);
	pane.add(lbl_title1).setBounds(110,60,600,40);
	pane.add(panel_all).setBounds(30,115,980,560);
	
	setSize(1040,700);
	setUndecorated(true);
	setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	panel_header.addMouseListener(this);
	lbl_minimize.addMouseListener(this);
	lbl_exit.addMouseListener(this);
	btn_find.addActionListener(this);
	btn_clear1.addActionListener(this);
	btn_clear2.addActionListener(this);
	btn_help.addActionListener(this);
	btn_about.addActionListener(this);
	
}
public static void main (String[]args) throws IOException {
	new LeastRecentlyUsedGUI();
}

// this is where I've placed the functions of every button.
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(btn_find)) {
		String numberframes, solution="",solution1="",solution2="",solution3="",result1,format = "",str_all = "",str_intro = "",table="",format_hit="",format_fault="",conclusion1,conclusion2;
		double hit2, fault2,ref_len2;
		double hit_ratio, fault_ratio;
		
		
		int hit = 0;
		int fault = 0;
		 int ref_len = 0;
		 
		 if(txt_blockrqst.getText().isEmpty()||txt_numberframes.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null,"Please input the missing values to proceed");
		 }
		 else {
			 
		 
		try {{ 
            int frames = 0;
            int pointer = 0;
            Boolean isFull = false;
            String s = "";
            char[] mem;
            ArrayList<Character> stack = new ArrayList<Character>();
            
            String str = txt_blockrqst.getText();
            numberframes=txt_numberframes.getText(); 
            String[] splitArray = str.split(" ");
            
            for (String n:splitArray)
                s+= n;
            char[] refestring = s.toCharArray();
            
            ref_len=refestring.length;
            frames = Integer.parseInt(numberframes);


            mem = new char[frames];
            for(int j = 0; j < frames; j++)
                mem[j] = '*';

            
            for(int i = 0; i < ref_len; i++){
                if(stack.contains(refestring[i])){
                    stack.remove(stack.indexOf(refestring[i]));
                }
                stack.add(refestring[i]);
                int search = -1;
                for(int j = 0; j < frames; j++){
                    if(mem[j] == refestring[i]){

                        search = j;
                        solution="\nSolution Visualization";
                        solution1+="\t\nBlock: "+refestring[i];
                        for(int w = 0; w < frames; w++){
                        format=String.format("%3c ",mem[w]);
                        solution1+="\n"+format;}
                        solution1+=("\nHit"+"\n___________________________\n");
                        solution2+=("\t");
                        
                        break;
                    }
                }
                if(search == -1){
                    if(isFull){
                        int min_loc = ref_len;
                        for(int j = 0; j < frames; j++){     
                            if(stack.contains(mem[j])){ 
                                int temp = stack.indexOf(mem[j]);
                                if(temp < min_loc){

                                    min_loc = temp;
                                    pointer = j;
                                }
                            }
                        }
                    }
                    mem[pointer] = refestring[i];
                    fault++;
                   
                    solution="\nSolution Visualization ";
                    solution1+="\t\nBlock: "+refestring[i];
                    for(int w = 0; w < frames; w++){
                    format=String.format("%3c ",mem[w]);
                    solution1+="\n"+format;}
                    
                    solution1+=("\nFault"+"\n___________________________\n");
                    solution2+=("\t");
             
                    pointer++;
                    if(pointer == frames){
                        pointer = 0;
                        isFull = true;
                        
                        
                    }
                	}
            		}
            
            hit = ref_len - fault;
            
            ref_len2 = Double.valueOf(ref_len);
            fault2 = Double.valueOf(fault);
            
            
            fault_ratio = (fault2/ref_len2)*100;
            
            hit_ratio = (100 - fault_ratio);
            
            format_hit = String.format("%.2f",hit_ratio);
            format_fault = String.format("%.2f", fault_ratio);
            
            
            
            str_intro=("Summary - LRU Algorithm"+
                    "\n\nTotal Frames: "+frames +
                    "\nBlock request length: "+ref_len+
                    "\nBlock request: "+str+
                    "\n___________________________");
                    

            table=str_intro+solution+solution1+solution2;
            conclusion1=("\nConclusion - LRU Algorithm ");
            conclusion2=("\n\nTotal block request: "+ref_len+
            		"\nHits: "+(hit)+
            		"\nFaults: " + fault+
            		"\nHit Rate: "+ hit+"/"+ref_len+" = "+format_hit+"%"+
            		"\nFault Rate: "+ fault+"/"+ref_len+" = "+format_fault+"%"
            		);
            
            txt_results.setText(table+conclusion1+conclusion2);
            scroller.setViewportView(txt_results);
    		scroller.setBorder(null);
        }
		}
	catch(Exception r) {
		JOptionPane.showMessageDialog(null,"Please input the values correctly, make sure the block request are separated by spaces");
	}
	}
	}

	else if(e.getSource().equals(btn_clear1)){
		txt_blockrqst.setText("");
		txt_numberframes.setText("");	
		
	}
	else if(e.getSource().equals(btn_clear2)) {
		txt_results.setText("");
	}
	else if(e.getSource().equals(btn_help)) {
		String instruction ="1. Type the number of frames."+
		"\n2. Type the block request (Make sure the block requests are separated by spaces)."+
		"\n3. Click find.";
		
		JOptionPane.showMessageDialog(null, instruction,"Instruction",JOptionPane.INFORMATION_MESSAGE);
	
	}
	else if(e.getSource().equals(btn_about)) {
		JOptionPane.showMessageDialog(null, "Least Recently Used (LRU) is a common caching strategy."+
		"\nIt defines the policy to evict elements from the cache to make room for new elements when the cache is full, "
		+"\nmeaning it discards the least recently used items first.","About",JOptionPane.INFORMATION_MESSAGE);
	}
	}

@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource().equals(lbl_minimize)) {
		setState(ICONIFIED);
	}
	
	else if(e.getSource().equals(lbl_exit)) {
		dispose();
		System.exit(0);s
	}
}

@Override
public void mousePressed(MouseEvent e) { 
	xMouse = e.getX();
	yMouse = e.getY();
	
}

public void mouseDragged(MouseEvent e) {
	int x = e.getXOnScreen();
	int y = e.getYOnScreen();
	
	setLocation(x - xMouse,y - yMouse);
}
}
