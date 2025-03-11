package org.example.relatorios;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.example.vendas.Venda;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class RelatorioPDFSimples implements Relatorio {

    private Venda venda;
    private Document documentoPDF;
    private String caminhoRelatorio = "relatoriosGerados/RelatorioSimplesPDF.pdf";

    public RelatorioPDFSimples(Venda venda) throws FileNotFoundException {
        this.venda = venda;
        this.documentoPDF = new Document();

        PdfWriter.getInstance(this.documentoPDF, new FileOutputStream(caminhoRelatorio));
        documentoPDF.open();
    }

    @Override
    public void gerarCabecalho() {
        Paragraph paragrafoTitulo = new Paragraph();
        paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
        paragrafoTitulo.add(
                new Chunk(
                "RELATORIO DE VENDAS SIMPLES",
                        new Font(Font.HELVETICA, 24)
                )
        );

        this.documentoPDF.add(paragrafoTitulo);
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragrafoData = new Paragraph();
        paragrafoData.setAlignment(Element.ALIGN_CENTER);
        paragrafoData.add(new Chunk(this.venda.getDataVenda().toString()));
        this.documentoPDF.add(paragrafoData);

        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragrafoCliente = new Paragraph();
        paragrafoCliente.setAlignment(Element.ALIGN_CENTER);
        paragrafoCliente.add(
                new Chunk(
                        "Cliente " + this.venda.getNomeCliente(),
                        new Font(Font.BOLD, 16)
                )
        );
        this.documentoPDF.add(new Paragraph(paragrafoCliente));

        Paragraph paragrafoSessao = new Paragraph("--------------------------------------------");
        paragrafoSessao.setAlignment(Element.ALIGN_CENTER);
        this.documentoPDF.add(paragrafoSessao);
        this.documentoPDF.add(new Paragraph(" "));
    }

    @Override
    public void gerarCorpo() {

    }

    @Override
    public void gerarRodape() {

    }

    @Override
    public void imprimir() {
        if (this.documentoPDF != null && this.documentoPDF.isOpen()) {
            this.documentoPDF.close();
        }
    }
}
