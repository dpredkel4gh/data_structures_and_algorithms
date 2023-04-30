package org.example.structures.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// RandomAccessFile can be used to write at a specific position in the file given the offset
// — from the beginning of the file — in bytes.
public class FileReadWrite {

    private static final String str = "Hello World";

    public static void main(String[] args) throws Exception {
        writeIntoFile();
        readSmallFile();
        readLargeFile();
        readWithStreams();
    }

    //    jdk 7
    public static void writeIntoFile() throws IOException {
        Path path = Paths.get("src/main/resources/file.txt");
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);

        assert str.equals(read);
    }


    //    jdk 7
    public static void readSmallFile() throws IOException {
        Path path = Paths.get("src/main/resources/file.txt");

        String read = Files.readAllLines(path).get(0);

        assert str.equals(read);
    }

    //    jdk 7
    public static void readLargeFile() throws IOException {
        Path path = Paths.get("src/main/resources/file.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();

            assert str.equals(line);
        }
    }

    //    jdk 8
    public static void readWithStreams() throws URISyntaxException, IOException {
        Path path = Paths.get(FileReadWrite.class.getClassLoader()
                .getResource("file.txt").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        assert str.equals(data);
    }
}
