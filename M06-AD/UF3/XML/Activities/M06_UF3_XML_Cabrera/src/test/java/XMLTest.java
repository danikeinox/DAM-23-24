import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLTest {
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 Document document = builder.parse(new File("C:\\Users\\K3IN0X\\Documents\\GitHub\\DAM-23-24\\M06-AD\\UF3\\XML\\Activities\\M06_UF3_XML_Cabrera\\src\\test\\resources\\tienda.xml"));
		 //document.getDocumentElement().normalize();
		 Element root = document.getDocumentElement();
		 System.out.println(root.getNodeName());
		 
		 
		 
		 NodeList nList = document.getElementsByTagName("computadora");
		 System.out.println("============================");
		 
		 for (int temp = 0; temp < nList.getLength(); temp++)
		 {
		  Node node = nList.item(temp);
		  
		  if (node.getNodeType() == Node.ELEMENT_NODE)
		  {
		  
		     Element eElement = (Element) node;
		     System.out.println("ID : "    + eElement.getAttribute("id"));
		     System.out.println("Nom : "  + eElement.getElementsByTagName("nom").item(0).getTextContent());
		     System.out.println("PVP : "   + eElement.getElementsByTagName("preu").item(0).getTextContent());
		     System.out.println();
		     
		  }
		 
		 
		 
		 
		 
	 }
	
	
	
	 }
}