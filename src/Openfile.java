import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;


public class Openfile implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String soder=null;
		JFileChooser fileopen = new JFileChooser();    
		FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf", "document");
		fileopen.setFileFilter(filter);
		int ret = fileopen.showDialog(null, "Открыть файл!");
		
		
		FileWriter out = null;
	
		String filename=fileopen.getSelectedFile().getName();
		String path=fileopen.getSelectedFile().getAbsolutePath();
		File fileout=new File("output"+filename+".txt");
		int page=0;
		PdfReader reader;
		try {
			out = new FileWriter(fileout, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			reader = new PdfReader(path, new byte[0]);
			int pages = reader.getNumberOfPages();
			page=pages;
			  PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		        TextExtractionStrategy strategy;
		        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
		            
		            soder=strategy.getResultantText();
		            out.write(soder);
		           // System.out.println(soder);
		        }
		     reader.close();
		     out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (page!=0){
			Okno.workwindoow.setBackground(new Color(50, 200, 50));
			Okno.workwindoow.append("Файл "+path+" успешно распознан, count of pages= "+page);
		}
		else
		{
			Okno.workwindoow.setBackground(new Color(200, 0, 50));
			Okno.workwindoow.append("Ошибка");	
		}
		
		


      
    }
		
	}

