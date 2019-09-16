package cursoRestAssured;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class TESTES {

	public static void main(String[] args) throws IOException {
//		List<String[]> list = new ArrayList<String[]>();
//		
//		list.add(new String[] {"oi", "ola"});
//		list.add(new String[] {"oi2", "ola2"});
//		System.out.println(list[0]);
//		for(String[] x: list) {
//			for(int i= 0; i < list.size(); i++) {
//				
//				System.out.println(x[i]);
//			}
//		}
////		System.out.println(list.iterator());
//
//	        String[] cabecalho = {"nome", "idade", "telefone"};
//
//	        List<String[]> linhas = new ArrayList<>();
//	        linhas.add(new String[]{"Joao","35","joao@dicasdejava.com.br"});
//	        linhas.add(new String[]{"Maria","23","maria@dicasdeprogramacao.com.br"});
//	        linhas.add(new String[]{"Ana","25","ana@dicasdejava.com.br"});
//
//	        Writer writer = Files.newBufferedWriter(Paths.get("pessoas.csv"));
//	        CSVWriter csvWriter = new CSVWriter(writer);
//
//	        csvWriter.writeNext(cabecalho);
//	        csvWriter.writeAll(linhas);
//
//	        csvWriter.flush();
//	        writer.close();
//	        
//
//
	        Reader reader = Files.newBufferedReader(Paths.get("contas.csv"));
	        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

	        List<String[]> pessoas = csvReader.readAll();
	        for (String[] pessoa : pessoas)
	            System.out.println(pessoa[0]);

	    }
	            

	

}
