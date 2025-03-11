package org.example.vendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private LocalDate dataVenda;
    private String nomeCliente;
    private List<Produto> produtosVendidos;

    public Venda(String nomeCliente, List<Produto> produtosVendidos) {
        this.dataVenda = LocalDate.now();
        this.nomeCliente = nomeCliente;
        this.produtosVendidos = produtosVendidos;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public double calculaValorTotalCarrinho() {
        double total = 0;
        for (Produto produto: produtosVendidos) {
            total += produto.calcularPreco();
        }
        return total;
    }

    public void addProdutoAoCarrinho(Produto produto) {
        this.produtosVendidos.add(produto);
    }
}
