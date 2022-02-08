package org.example;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {


        Path p2 = Paths.get("Temario,","java.txt");
        System.out.println((p2.toAbsolutePath().toString()));





    }
    
}
