package com.aimluck.out;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.transform.TransformerException;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.XPathAPI;

public class Parser {
//	public static final String RESULT_PATH_PC_ADMIN_ACCOUNT_COMPANY = "C:\\maventest\\excelfunctions.html";
//	public static final String RESULT_XPATH_ALL = "/HTML/BODY/DIV/DIV/TABLE/TBODY/TR/TD";
	public static final String RESULT_PATH_PC_ADMIN_ACCOUNT_COMPANY = "C:\\excelfunction\\item.xml";
	public static final String RESULT_XPATH_ALL = "//SURFACE";

	public static void result() throws SAXException, IOException,
			TransformerException {
		HashMap<String, String> map = new HashMap<String, String>();
		InputStream inStream = null;
		inStream = new BufferedInputStream(new FileInputStream(
				RESULT_PATH_PC_ADMIN_ACCOUNT_COMPANY));
		InputSource source = new InputSource(inStream);

		DOMParser parser = new DOMParser();

		parser.parse(source);
		Document doc = parser.getDocument();
		NodeList testlist;
		testlist = XPathAPI.selectNodeList(doc, RESULT_XPATH_ALL);

		int length = testlist.getLength();

//		for (int i = 0; i < length; i++) {
//			Node item = testlist.item(i);
//			NamedNodeMap attrs = item.getAttributes();
//			Node attr = attrs.getNamedItem("class");
//			map.put(item.getTextContent(), attr.getNodeValue());
//		}

		for (int i = 0; i < length; i++) {
			Node item = testlist.item(i);
			System.out.println(item.getTextContent() + "; "
					+ map.get(item.getTextContent()));
		}

//		for (int i = 0; i < length; i = i+3) {
//			if(i+3 < length)
//				System.out.println(testlist.item(i).getTextContent() + "; "+testlist.item(i+1).getTextContent() + "; "+testlist.item(i+2).getTextContent() + "; ");
//
//		}
	}
}
