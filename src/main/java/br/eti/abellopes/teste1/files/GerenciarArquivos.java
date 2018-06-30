package br.eti.abellopes.teste1.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciarArquivos {
	public static String source = "/home/abell/ler/data";
	public static String target = "/home/abell/ler/out";
	
	 public static List<Path> filePathsList(String directory) throws IOException {
        List<Path> filePaths = new ArrayList<>();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
        for (Path path : directoryStream) {
            filePaths.add(path);
        }
        return filePaths;
    }

    private static List<Path> filter(List<Path> filePaths) {
        List<Path> filteredFilePaths = new ArrayList<>();
        for (Path filePath : filePaths) {
            if (filePath.getFileName().toString().endsWith(".txt")) {
                filteredFilePaths.add(filePath);
            }
        }
        return filteredFilePaths;
    }

    private static Map<Path, List<String>> getContentOfFiles(List<Path> filePaths) throws IOException {
        Map<Path, List<String>> contentOfFiles = new HashMap<>();
        for (Path filePath : filePaths) {
            contentOfFiles.put(filePath, new ArrayList<>());
            Files.readAllLines(filePath).forEach(contentOfFiles.get(filePath)::add);
        }
        return contentOfFiles;
    }

    private static void move(List<Path> filePaths, String target) throws IOException {
        Path targetDir = FileSystems.getDefault().getPath(target);
        if (!Files.isDirectory(targetDir)) {
            targetDir = Files.createDirectories(Paths.get(target));
        }
        for (Path filePath : filePaths) {
            System.out.println("Moving " + filePath.getFileName() + " to " + targetDir.toAbsolutePath());
            Files.move(filePath, Paths.get(target, filePath.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);
        }   
    }

    private static void printToConsole(Map<Path, List<String>> contentOfFiles) {
        System.out.println("Content of files:");
        contentOfFiles.forEach((k,v) -> v.forEach(System.out::println));
    }
    public static void ReadAllLinesFile(Path path) {

        Charset charset = Charset.forName("ISO-8859-1");
        try {
          List<String> lines = Files.readAllLines(path, charset);

          for (String line : lines) {
            System.out.println(line);
          }
        } catch (IOException e) {
          System.out.println(e);
        }

      }
}
