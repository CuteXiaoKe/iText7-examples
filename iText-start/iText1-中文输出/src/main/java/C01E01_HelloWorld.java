/*
 * This example is part of the iText 7 tutorial.
 */

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.File;
import java.io.IOException;

import static com.itextpdf.kernel.pdf.PdfName.BaseFont;

/**
 * Simple Hello World example.
 */
public class C01E01_HelloWorld {

    public static final String DEST = "results/chapter01/hello_world.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();             //创建目录
        new C01E01_HelloWorld().createPdf(DEST);        //生成文件
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        PdfFont f2 = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H",true);
       PdfFont f3 = PdfFontFactory.createFont("C:/Windows/Fonts/simhei.ttf", PdfEncodings.IDENTITY_H,true);
        //Add paragraph to the document
        document.add(new Paragraph("hellos你好").setFont(f2));
       document.add(new Paragraph("hellos你好").setFont(f3));


        //Close document
        document.close();
    }
}