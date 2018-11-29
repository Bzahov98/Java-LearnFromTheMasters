package com.musala.javacourse181112.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExample {
    private static final String PATH = "src";
    private static final String NEW_DIR = "newDir";
    private static final String NEW_FILE1 = "file1.txt";
    private static final String NEW_FILE2 = "file2.txt";

    public static void main(String[] args) {

        createSingleFile(PATH,false);
        createMultipyFiles();
        listDir(PATH);

    }

    private static void listDir(String path) {
        try {
            Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createMultipyFiles() {
        String pathname = PATH + "/" + NEW_DIR;
        File dir = new File(pathname);
        if (dir.mkdir()) {
            createSingleFile(pathname + "/"+ NEW_FILE1,false);
            createSingleFile(pathname + "/"+ NEW_FILE2,true);
        }
    }

    private static void createSingleFile(String path,boolean deleteOnExit) {
        File file = new File(path);
        try {
            if (deleteOnExit){
                file.deleteOnExit();
            }
            if ((file.exists()) && file.isFile() || file.createNewFile()) {
                System.out.println(file.exists());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.canExecute())
        System.out.println(file.exists());
        System.out.println(file.exists());
    }
}
