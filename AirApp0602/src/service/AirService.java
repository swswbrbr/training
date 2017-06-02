package service;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName=서울&pageNo=1&numOfRows=10&ServiceKey=서비스키&ver=1.3
 * 
 */

public class AirService {
	
	public List<Item> getItemList(String sidoName) throws IOException, ParserConfigurationException, SAXException{
		List list = new ArrayList<Item>();
		String xml = this.xmlDownload(sidoName);
		//String -> parsing list
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder builder = factory.newDocumentBuilder();
	     InputSource is = new InputSource(new StringReader(xml.toString()));
	     Document doc =  builder.parse(is);
	     NodeList nodeList = doc.getElementsByTagName("item");
	     for(int i=0; i<nodeList.getLength(); i++){
	    	 Item item = new Item();
	    	 Node node = nodeList.item(i);
	    	 Element e = (Element)node;
	    	 item.setDataTime(e.getElementsByTagName("dataTime").item(0).getTextContent());
	    	 item.setStationName(e.getElementsByTagName("cityName").item(0).getTextContent());
	    	 item.setSo2Value(e.getElementsByTagName("so2Value").item(0).getTextContent());
	    	 item.setCoValue(e.getElementsByTagName("coValue").item(0).getTextContent());
	    	 item.setO3Value(e.getElementsByTagName("o3Value").item(0).getTextContent());
	    	 item.setPm10Value(e.getElementsByTagName("pm10Value").item(0).getTextContent());
	    	 item.setPm25Value(e.getElementsByTagName("pm25Value").item(0).getTextContent());
	    	 list.add(item);
	    	
	     }
		return list;
	}
	
	private String xmlDownload(String sidoName) throws IOException{
		String host = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst";
		 StringBuilder urlBuilder = new StringBuilder(host); /*URL*/
	         /*Service Key*/
		 
		 	
	        urlBuilder.append("?" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode(sidoName, "UTF-8")); /*파라미터설명*/
	        urlBuilder.append("&" + URLEncoder.encode("searchCondition","UTF-8") + "=" + URLEncoder.encode("DAILY", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=eOiULzhgqWaYk9TD9F7LwEYmTa5pwuleK6fyoJ9u%2BbJUq6raOo51WOHpkyef3Jee%2B8PIP3BmulsnuDwIgr5UDQ%3D%3D");
	        //urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.3", "UTF-8"));
	        
	        //urlBuilder.append("?" + URLEncoder.encode("tmX","UTF-8") + "=" + URLEncoder.encode("244148.546388", "UTF-8"));
	        //urlBuilder.append("&" + URLEncoder.encode("tmY","UTF-8") + "=" + URLEncoder.encode("412423.75772", "UTF-8"));
	        //urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
	        //urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
	        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=eOiULzhgqWaYk9TD9F7LwEYmTa5pwuleK6fyoJ9u%2BbJUq6raOo51WOHpkyef3Jee%2B8PIP3BmulsnuDwIgr5UDQ%3D%3D");
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        //System.out.println(sb.toString());
			return sb.toString();
	}
	/*
	public static void main(String[] args) throws IOException{
		AirService as = new AirService();
		String returnXml = as.xmlDownload(sidoName);
		System.out.println(returnXml);
	}
*/
}
