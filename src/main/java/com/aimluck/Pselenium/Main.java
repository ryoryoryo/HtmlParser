package com.aimluck.Pselenium;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.aimluck.out.Parser;

public class Main {
	public static void main(String args[]) {
			try {
				Parser.result();
			} catch (SAXException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			}
	}
}
