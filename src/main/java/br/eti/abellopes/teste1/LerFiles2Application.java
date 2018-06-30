package br.eti.abellopes.teste1;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericApplicationContextExtensionsKt;

import br.eti.abellopes.teste1.files.GerenciarArquivos;

@SpringBootApplication
public class LerFiles2Application {
	
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(LerFiles2Application.class, args);
		try {
			java.util.List<Path> filePaths = GerenciarArquivos.filePathsList(GerenciarArquivos.source);
			filePaths.forEach(item->{
				System.out.println(item);
				GerenciarArquivos.ReadAllLinesFile(item);
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
