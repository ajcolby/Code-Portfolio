//======================================================================
// CS II : # <Austin Colby>
// Semester : # <FAll 2014>
//
// # <Austin Colby>
// # <Section 1>
//
// Description:
// WebBrowser frame
//======================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class WebBrowser extends JFrame {
	
	public JTextField textField;
	private JTextArea outputField;
	private String line;
	
	public WebBrowser(String title){
	
		//Creates panel, frame and buttons and sets layout
		super(title);
		setSize(1000 , 720);
		
		textField = new JTextField();
		add(textField, BorderLayout.PAGE_START);
		
		outputField = new JTextArea(20,5); 
		JScrollPane scroll = new JScrollPane(outputField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		add(scroll);
		outputField.setEditable(false);
		
		textField.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					outputField.setText("");
					NetworkReader();
				}
			}
		});
	}
	
	public String NetworkReader(){
		
		try {
			Socket socket = new Socket(textField.getText(), 80);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in =	new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.print("GET / HTTP/"+textField.getText()+"\n");
			out.print("host: "+textField.getText()+"+\n\n");
			out.flush();
				while ((line = in.readLine()) != null) {
					outputField.append(line + "\n");
					System.out.println(line);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"This web page is unavailable on this browser.");
				//e.printStackTrace();
			}		
		return null;
	}
	
}