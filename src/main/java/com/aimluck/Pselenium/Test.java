package com.aimluck.Pselenium;

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

public class Test {
	public static void main(String args[]) throws SAXException, IOException,
			TransformerException {
		InputStream inStream = null;
		inStream = new BufferedInputStream(
				new FileInputStream(
						"C:\\maventest\\selenium-ext-htmlsuite-1.1\\result\\googlechrome\\TestSuite_acccessctl_result.html"));
		InputSource source = new InputSource(inStream);

		DOMParser parser = new DOMParser();

		parser.parse(source);
		Document doc = parser.getDocument();
		NodeList testlist;
		NodeList testlist2;
		testlist = XPathAPI.selectNodeList(doc,
				"/HTML/BODY/TABLE/TBODY/TR/TD/A");
		testlist2 = XPathAPI.selectNodeList(doc,
				"/HTML/BODY/TABLE/TBODY/TR/TD/TABLE/TBODY/TR");

		// ここまでで値とってきた。testlistに値が入っている。/TABLE[@ID='suiteTable']
		// /HTML/BODY/TABLE/TBODY/TR/TD /DIV/TABLE/THEAD/TR/TD

		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();

		int length = testlist.getLength();
		int length2 = testlist2.getLength();

		for (int i = 0; i < length; i++) {
			Node item = testlist.item(i);
			map.put(item.getTextContent(), "true"); // define true or false
		}

		// 出力
		System.out.println("reault:");
		for (int i = 0; i < length; i++) {
			Node item = testlist.item(i);
			System.out.println(item.getTextContent() + ", "
					+ map.get(item.getTextContent()));
		}

		System.out.println("\nhtml:");
		for (int i = 0; i < length2; i++) {
			Node item2 = testlist2.item(i);
			NamedNodeMap attrs = item2.getAttributes();
			Node attr = attrs.getNamedItem("class");
			System.out.println(item2.getTextContent() + ", "
					+ attr.getNodeValue());
		}
		System.out.println("end");

	}
}
