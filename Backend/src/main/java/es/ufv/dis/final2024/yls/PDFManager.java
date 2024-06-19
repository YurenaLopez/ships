package es.ufv.dis.final2022.yls;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.ufv.dis.final2024.yls.Ships;

import java.io.FileOutputStream;

public class PDFManager {
    public static void GenerarPDF(Ships shipNuevo, String nombreNave) {
        try {
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("peticiones/" + nombreNave + ".pdf"));
            doc.open();

            // Crear y añadir los párrafos con la información del producto
            String name = "Name: " + shipNuevo.getName();
            String model= "model: " + shipNuevo.getModel();
            String starship_class = "starship_class: " + shipNuevo.getStarship_class();
            String crew = "crew: " + shipNuevo.getCrew();
            String total = "Peliculas en las que aparece: " + shipNuevo.getFilms().length;

            Paragraph pName = new Paragraph(name);
            pName.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(pName);

            Paragraph pModel = new Paragraph(model);
            pModel.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(pModel);

            Paragraph pStarship_class = new Paragraph(starship_class);
            pStarship_class.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(pStarship_class);

            Paragraph pCrew = new Paragraph(crew);
            pCrew.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(pCrew);

            Paragraph pTotal_films = new Paragraph(total);
            pTotal_films.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(pTotal_films);

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
