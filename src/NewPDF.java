import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;


public class NewPDF implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	    BaseFont bf = null;
		try {
			bf = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //подключаем файл шрифта, который поддерживает кириллицу
	    Font font = new Font(bf, 14, Font.BOLD,	new CMYKColor(255, 0, 0, 0));
//	    document.add(new Paragraph("буковки", font));
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/anton/ITextTest.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				document.open();
				Anchor anchorTarget = new Anchor("Первая страница", font);
			      anchorTarget.setName("BackToTop");
			      Paragraph paragraph1 = new Paragraph();

			      paragraph1.setSpacingBefore(50);

			      paragraph1.add(anchorTarget);
			      try {
					document.add(paragraph1);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			try {
				document.add(new Paragraph("Здесь? будет текст/ проверка кодировки ___1234567890+-/* qwerty",
						font));
						//FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document.close();
	}

}
