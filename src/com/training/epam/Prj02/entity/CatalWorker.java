package com.training.epam.Prj02.entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CatalWorker {

	Queue<File> fileTree = new PriorityQueue<>();
	List<File> result = new ArrayList<>();
	List<File> resultMP3 = new ArrayList<>();
	// List<File> listOfFiles = new ArrayList<>();
	Queue<File> listOfFiles = new PriorityQueue<>();
	Song song = new Song();
	List<Song> songMP3 = new ArrayList<>();

	public void doFolderExist(File folder) {
		if (folder.exists()) {
			System.out.println("Yes, this file exists! ");
		} else {
			System.out.println("No, this file don't exist! ");
		}
	}

	public void doFolderFileOrDirectory(File folder) {
		if (folder.isFile()) {
			System.out.println("It is a file!");
		} else if (folder.isDirectory()) {
			System.out.println("It is a directory!");
		}
	}

	public List<File> readCatalogue(File folder) {
		Collections.addAll(fileTree, folder.listFiles());

		while (!fileTree.isEmpty()) {
			File currentFile = fileTree.remove();
			if (currentFile.isDirectory()) {
				Collections.addAll(fileTree, currentFile.listFiles());
			} else {
				result.add(currentFile);
			}
		}
		return result;
	}

	public void printCatalogue(List<File> result) {
		for (File entry : result) {
			System.out.println(entry);
		}
	}

	public List<Song> findMP3(List<File> result) {
		String extension = "";
		String mp3 = new String("mp3");
		int x;
		int y;
		for (File entry : result) {
			x = entry.toString().lastIndexOf('.');
			y = Math.max(entry.toString().lastIndexOf('/'), entry.toString().lastIndexOf('_'));
			if (x > y) {
				extension = entry.toString().substring(x + 1);
				if (extension.equals(mp3)) {
					song.setLink(entry.getAbsolutePath());
					String[] add = song.toString().split("_");
					song.setNameAlbom(add[0]);
					song.setNameSinger(add[1]);
					song.setNameSong(add[2]);
					song.setTimeLasting(add[3]);
					resultMP3.add(entry);
					songMP3.add(song);
				} else {
					System.out.println("File doesn't have required extension!");
				}
			}
			// printCatalogue(resultMP3);
		}
		return songMP3;
	}

	public void printCatalogueMP3(List<Song> songMP3) {
		for (Song entry : songMP3) {
			System.out.println(entry);
		}
	}

	// создание html документа
	public void writeHTMLCatalogue(List<Song> findMP3) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter("C:/test.html"));
			pw.println("<TABLE BORDER><TR><TH>Name<TH>Playing time<TH>Link</TR>");

			for (Song entry : songMP3) {
				pw.println("<TR><TD>" + song.getNameSong() + "<TD>" + song.getTimeLasting() + "<TD>" + song.getLink());
			}

			pw.println("</TABLE>");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public List<File> findMP3(List<File> result) {
	// String extension = "";
	// String mp3 = new String("mp3");
	// int x;
	// int y;
	// for (File entry : result) {
	// x = entry.toString().lastIndexOf('.');
	// y = Math.max(entry.toString().lastIndexOf('/'),
	// entry.toString().lastIndexOf('_'));
	// if (x > y) {
	// extension = entry.toString().substring(x + 1);
	// if (extension.equals(mp3)) {
	// resultMP3.add(entry);
	// } else {
	// System.out.println("File doesn't have required extension!");
	// }
	// }
	//// printCatalogue(resultMP3);
	// }
	// return resultMP3;
	// }

}
