package org.example;

import org.example.relatorios.Relatorio;
import org.example.relatorios.RelatorioPDFSimples;
import org.example.vendas.Produto;
import org.example.vendas.Venda;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        Venda venda = new Venda("Johnner Yelcde", produtos);

        venda.addProdutoAoCarrinho(new Produto("Celular", 1, 1000));
        venda.addProdutoAoCarrinho(new Produto("Fone de Ouvido", 2, 300));
        venda.addProdutoAoCarrinho(new Produto("Bag de NoteBook", 1, 100));

        Relatorio relatorioSimples = new RelatorioPDFSimples(venda);
        relatorioSimples.gerarCabecalho();
        relatorioSimples.gerarCorpo();
        relatorioSimples.gerarRodape();
        relatorioSimples.imprimir();
    }
}