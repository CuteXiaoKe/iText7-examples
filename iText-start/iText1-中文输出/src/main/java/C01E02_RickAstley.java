/**
 * Created by CuteKe on 2017/7/10.
 */
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;

/**
 * Simple List example.
 */
public class C01E02_RickAstley {
    public static final String DEST = "results/chapter01/rick_astley.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();   //创建目录
        new C01E02_RickAstley().createPdf(DEST);   //生成文件
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        // Create a PdfFont
        PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);
        // Add a Paragraph
        document.add(new Paragraph("iText is:").setFont(font));
        // Create a List
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        // Add ListItem objects
        list.add(new ListItem("Never gonna give you up呵呵"))
                .add(new ListItem("Never gonna let you down是的"))
                .add(new ListItem("Never gonna run around and 你desert you"))
                .add(new ListItem("Never gonna make 好you cry"))
                .add(new ListItem("Never gonna say 哟goodbye"))
                .add(new ListItem("Never gonna tell a 嗨lie and hurt you"));
        // Add the list
        document.add(list);

        //Close document
        document.close();
    }
}