//======================================================================
// CS II : # <Austin Colby>
// Semester : # <Fall 2014>
//
// # <Austin Colby>
// # <Section 1>
//
// Description:
// Creates a basic web browser
//======================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Browser{
	public static void main(String[] args)
	{
		//exits program and reveals gui
		WebBrowser web = new WebBrowser("Opera of the Fire Chrome Explorer's Safari");
		web.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		web.setVisible(true);
	
	}
}




