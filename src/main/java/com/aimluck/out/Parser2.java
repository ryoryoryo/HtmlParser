package com.aimluck.out;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.sun.org.apache.xpath.internal.XPathAPI;
import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Parser2 {
    public static void main(String args[]) {
        try {
                URL url = new URL("C:\\maventest\\excelfunctions.html");
                URLConnection connection = url.openConnection();
                // BufferedReader bs = new BufferedReader(new InputStreamReader(
                // connection.getInputStream()));

                InputStream stream = connection.getInputStream();

                try {
                        DOMParser parser = new DOMParser();
                        InputSource source = new InputSource(stream);
                        parser.parse(source);
                        Document doc = parser.getDocument();
                        NodeList nodelist = XPathAPI.selectNodeList(doc, "/HTML/BODY/DIV/DIV/TABLE/TBODY/TR/TD");
                        int length = nodelist.getLength();
                        for (int i = 0; i < length; i++) {
                                Node item = nodelist.item(i);
                                System.out.println(item.getTextContent() + ";");
                        }
                } catch (Exception e) {
                        // TODO: handle exception
                } finally {
                        stream.close();
                }

                System.out.println();
        } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
        }
}}





