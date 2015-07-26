package plist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class CreatePlist {

	public static void CreateThePlist(ArrayList<Character> genderList, ArrayList<Integer> ageList,
			ArrayList<String> ethnicityList, ArrayList<Location> locationList)
			throws ParserConfigurationException, TransformerException,
			IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation di = builder.getDOMImplementation();
		DocumentType dt = di.createDocumentType("plist",
				"-//Apple//DTD PLIST 1.0//EN",
				"http://www.apple.com/DTDs/PropertyList-1.0.dtd");
		Document doc = di.createDocument("", "plist", dt);
		doc.setXmlStandalone(true);

		appendTheElements(doc, genderList, ageList, ethnicityList, locationList);

		DOMSource domSource = new DOMSource(doc);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, dt.getPublicId());
		t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dt.getSystemId());
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		StringWriter stringWriter = new StringWriter();
		StreamResult streamResult = new StreamResult(stringWriter);
		t.transform(domSource, streamResult);
		String xml = stringWriter.toString();
		System.out.println(xml); // Optionally output to standard output.
		OutputStream stream = new FileOutputStream("example.plist");
		Writer writer = new OutputStreamWriter(stream, "UTF-16");
		writer.write(xml);
		writer.close();

	}

	private static void appendTheElements(Document doc,
			ArrayList<Character> genderList, ArrayList<Integer> ageList, ArrayList<String> ethnicityList, ArrayList<Location> locationList) {

		Element root = doc.getDocumentElement();
		root.setAttribute("version", "1.0");

		Element rootArray = doc.createElement("array");
		root.appendChild(rootArray);

		for (int i = 0; i <= genderList.size() -1; i++) {
			Element dict = doc.createElement("dict");
			rootArray.appendChild(dict);

			Element genderKey = doc.createElement("key");
			genderKey.setTextContent("gender");
			dict.appendChild(genderKey);

			Element genderValue = doc.createElement("string");
			genderValue.setTextContent(genderList.get(i).toString());
			dict.appendChild(genderValue);
			
			Element ageKey = doc.createElement("key");
			ageKey.setTextContent("age");
			dict.appendChild(ageKey);

			Element ageValue = doc.createElement("integer");
			ageValue.setTextContent(ageList.get(i).toString());
			dict.appendChild(ageValue);


			Element ethnicityKey = doc.createElement("key");
			ethnicityKey.setTextContent("ethnicity");
			dict.appendChild(ethnicityKey);

			Element ethnicityValue = doc.createElement("string");
			ethnicityValue.setTextContent(ethnicityList.get(i));
			dict.appendChild(ethnicityValue);
			
			Element latitudeKey = doc.createElement("key");
			latitudeKey.setTextContent("latitude");
			dict.appendChild(latitudeKey);

			Element latitudeValue = doc.createElement("real");
			latitudeValue.setTextContent(locationList.get(i).latitude);
			dict.appendChild(latitudeValue);
			
			Element longitudeKey = doc.createElement("key");
			longitudeKey.setTextContent("longitude");
			dict.appendChild(longitudeKey);

			Element longitudeValue = doc.createElement("real");
			longitudeValue.setTextContent(locationList.get(i).longitude);
			dict.appendChild(longitudeValue);
		}
	}
}
