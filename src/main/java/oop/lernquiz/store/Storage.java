package oop.lernquiz.store;

import oop.lernquiz.model.Thema;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {
	private static Storage instance;
	private Path storageFile;

	private Storage() {
		storageFile = Paths.get("data.txt");
		if (!Files.exists(storageFile)) {
			try {
				Files.createFile(storageFile);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void write() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(storageFile.toString());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(ThemaStore.getInstance().getThemen());

			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (Exception ex) {
		}
	}

	public ArrayList<Thema> read() {
		try {
			FileInputStream fileInputStream = new FileInputStream(storageFile.toString());
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			var data = (ArrayList<Thema>) objectInputStream.readObject();

			objectInputStream.close();

			return data;
		}
		catch (EOFException ex) {
			return new ArrayList<>();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}
}
