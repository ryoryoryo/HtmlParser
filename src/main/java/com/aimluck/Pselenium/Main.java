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
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}
}
