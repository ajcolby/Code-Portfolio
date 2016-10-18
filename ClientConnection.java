//CSII
//Austin Colby
//Fall 2014
// Client for server

import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.nio.file.Files;

public class ClientConnection implements Runnable {
	private Socket socket;
		public ClientConnection(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			try {
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = in.readLine() ;
				String inputFile = line.substring(5, line.length()-9);
				String path = inputFile;
				File file = new File(inputFile);
				File index = new File("index.html");
				//bad request handler
				if(!line.startsWith("GET") || !line.endsWith("HTTP/1.1")) {
						out.print("<html>\n\r <body>\n\r<h1>500 Internal Server Error</h1>\n\r</body></html>\r\n\r\n");
						out.flush();
						out.close();
					} else {
						out.print("HTTP/1.1 200 OK\r\n");
						out.print("Content-type:" + contentType(path) + "\r\n\r\n");
						//loads index.html if no file is given 
						if(inputFile.length() == 0){
							BufferedReader indexFile = new BufferedReader(new FileReader(index));
							String indexLine = null;
							while((indexLine = indexFile.readLine()) != null){
								out.print(indexLine);
								out.flush();
								out.close();
							}
							//test if file exist and returns a file not found error 
						}else if(!file.exists()){
							out.print("<html>\n\r <body>\n\r<h1>404 File Not Found</h1>\n\r</body></html>\r\n\r\n");
							out.flush();
						//loads html text files
						} else if(path.endsWith(".html") || path.endsWith(".htm")) {
							BufferedReader inFile = new BufferedReader(new FileReader(file));
							String fileLine = null;
							while((fileLine = inFile.readLine()) != null){
								out.print(fileLine);
								out.flush();
								out.close();
							}
							System.out.println(inputFile);
						//loads images 
						} else if(path.endsWith(".jpg") || path.endsWith(".jpeg")){
							BufferedImage image = ImageIO.read(new File(inputFile));
							OutputStream out2 = socket.getOutputStream();
							ImageIO.write(image, "jpg",out2); 
							out2.close();
							System.out.println(inputFile);
						}
					//Error if you try to access forbidden regions
					if (inputFile.endsWith("..") == true) {
						out.print("<html>\n\r <body>\n\r<h1>403 Forbidden</h1>\n\r</body></html>\r\n\r\n");
						out.flush();
						out.close();
					}
				}
			} catch (NullPointerException thread){
				 
			} catch (IOException e) {
					e.printStackTrace();
			}
	}
	//content type method 
	public static String contentType(String path){
		if (path.endsWith(".html") || path.endsWith(".htm")){ 
			return "text/html";
		}else if (path.endsWith(".jpg") || path.endsWith(".jpeg")){
			return "image/jpeg";
		}
			return "text/html";
    }
}