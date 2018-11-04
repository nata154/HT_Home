package com.training.epam.Prj02.entity;

//from Maven
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TikaTry {
	public static void main(String[] args) {

		File folder = new File("e:/Слушать/bi-2_-_ona_(zvukoff.ru).mp3");
		// public List<File> readCatalogue(File folder) {
		Queue<File> fileTree = new PriorityQueue<File>();
		List<File> result = new ArrayList<File>();

		Collections.addAll(fileTree, folder.listFiles());

		while (!fileTree.isEmpty()) {
			File currentFile = fileTree.remove();
			if (currentFile.isDirectory()) {
				Collections.addAll(fileTree, currentFile.listFiles());
			} else {
				result.add(currentFile);
			}
		}

		try {
			String fileLocation = null;
			InputStream input = new FileInputStream(fileLocation);
			ContentHandler handler = new DefaultHandler();
			Metadata metadata = new Metadata();
			Parser parser = new Mp3Parser();
			ParseContext parseCtx = new ParseContext();

			// public void printCatalogue(List<File> result) {
			for (File entry : result) {
				fileLocation = result.toString();
				parser.parse(input, handler, metadata, parseCtx);
			}
			input.close();

			// List all metadata
			String[] metadataNames = metadata.names();

			for (String name : metadataNames) {
				System.out.println(name + ": " + metadata.get(name));
			}

			// Retrieve the necessary info from metadata
			// Names - title, xmpDM:artist etc. - mentioned below may differ based
			System.out.println("----------------------------------------------");
			System.out.println("Album : " + metadata.get("xmpDM:album"));
			System.out.println("Title: " + metadata.get("title"));
			System.out.println("Artists: " + metadata.get("xmpDM:artist"));
			System.out.println("Composer : " + metadata.get("xmpDM:composer"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} finally {
			System.out.println("The end");
		}
	}
}

