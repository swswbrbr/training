import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GoogleConnTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.google.com");
		URLConnection uConn = url.openConnection();
		HttpURLConnection hConn = null;
		if(uConn instanceof HttpURLConnection){
			hConn = (HttpURLConnection)uConn;
		} else{
			System.out.println("http connection이 아닙니다.");
		}
		
		//hConn inputstream -> local outputstream
		
		InputStreamReader in = new InputStreamReader(hConn.getInputStream());
		BufferedReader bin = new BufferedReader(in);
		String urlString = "";
		String current = "";
		while((current = bin.readLine()) != null){
			urlString += current;
		}
		System.out.println(urlString);
	}

}
