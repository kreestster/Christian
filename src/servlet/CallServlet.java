package servlet;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class CallServlet {
	/**
	 * @param strings
	 */
	public static void main(String...strings) {
		Parameters parameters = new Parameters();
		
		parameters.addParam("TEST", "VALUE");
		
		URL servlet = null;
		try {
			servlet = new URL("http://127.0.0.1:8080/servlet/LoginOperatore?RGICommand=logout&RGIResponseOk=/login/Login.html");
			
			HttpURLConnection servletConn = (HttpURLConnection) servlet.openConnection();
			servletConn.setRequestMethod("GET");
			servletConn.setDoOutput(true);
			servletConn.setDoInput(true);
			servletConn.setRequestProperty("RGI_username", "ag1008");
			servletConn.setRequestProperty("RGI_password", "AX");
			ObjectOutputStream objOut = new ObjectOutputStream(servletConn.getOutputStream());
		        objOut.writeObject(parameters);
		    InputStream response = servletConn.getInputStream();
		    java.io.BufferedInputStream r = new BufferedInputStream(response);
		    
		    byte[] contents = new byte[response.available()];

		    int bytesRead = 0;
		    String strFileContents = ""; 
		    while((bytesRead = r.read(contents)) != -1) { 
		        strFileContents += new String(contents, 0, bytesRead);              
		    }
		    System.out.println(strFileContents);
		    Map<String, List<String>> cookies =  servletConn.getHeaderFields();
		        objOut.flush();
		        objOut.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
}
