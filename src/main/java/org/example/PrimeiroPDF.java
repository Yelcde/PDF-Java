package org.example;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PrimeiroPDF {

    public PrimeiroPDF(String fraseAImprimir) throws FileNotFoundException {

        Document documentPDF = new Document();

        PdfWriter.getInstance(documentPDF, new FileOutputStream("Relatório1.pdf"));

        documentPDF.open();

        Paragraph paragrafoTeste = new Paragraph(fraseAImprimir);

        documentPDF.add(paragrafoTeste);

        documentPDF.close();

    }
}
