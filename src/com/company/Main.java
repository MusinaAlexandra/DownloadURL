package com.company;

import java.util.*;
import java.io.*;
import java.net.*;
public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        System.out.println("url");
        String url = scanner.nextLine().trim();
        System.out.println("filename");
        String filename = scanner.nextLine().trim();
        download(url, filename);
    }

    public static void download(String url, String filename) {
        try (BufferedInputStream instr = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fout = new FileOutputStream(filename)) {
            //final int size = instr.available();
            byte data[] = new byte[1024];
            int count;
            int i = 1;
            while((count = instr.read(data,0,1024)) != -1)
            {
                fout.write(data, 0, count);
                System.out.println((i * 1024) + " bytes downloaded");
                i++;
            }
        } catch (Exception e) {
            System.out.println("error of downloading");
        }
    }
}
