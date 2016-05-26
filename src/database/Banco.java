package database;

import models.*;

import java.util.ArrayList;

public class Banco {

public ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
public int lastInsertPessoa;
public ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
public int lastInsertAutomovel;
public ArrayList<Posto> postos = new ArrayList<Posto>();
public int lastInsertPosto;
public ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
public int lastInsertLocacao;
public ArrayList<Venda> vendas = new ArrayList<Venda>();
public int lastInsertVenda;
public ArrayList<PlanoLocacao> planosLocacoes= new ArrayList<PlanoLocacao>();
public int lastInsertPlanoLocacao;
public ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
public int lastInsertFeedback;

public Banco() {
    //iniciando o "banco"
    this.pessoas.add(new Funcionario(1, "Marino", "marino@brasilcars.com", "lalala", 0));
    this.pessoas.add(new Funcionario(2, "Bruno", "bcamera@brasilcars.com", "senhafacil", 1));
    this.pessoas.add(new Funcionario(3, "Romilson", "romilson@brasilcars.com", "tesourasemponta123", 2));
    this.pessoas.add(new Cliente(4, "Jonh Doe", "iammyown@grandfather.com", "grandfatherparadox"));
    this.pessoas.add(new Cliente(5, "Acerto", "mizeravi@qtensino.com", "apredeascontaponcotom"));
    this.pessoas.add(new Cliente(6, "fagner", "b@hotmail.com", "123456"));
    this.lastInsertPessoa=6;
    this.automoveis.add(new Automovel(1, "Fiat Uno", "Casual", (byte) 2, 2015, "S"));
    this.automoveis.add(new Automovel(2, "Camaro", "Esportivo", (byte) 2, 2015, "S"));
    this.lastInsertAutomovel=2;
    this.postos.add(new Posto(1, "Unidade Central", "Ondina", "24 horas"));
    this.lastInsertPosto=1;
    this.lastInsertFeedback=0;
    this.lastInsertLocacao=0;
    this.lastInsertPlanoLocacao=0;
    this.lastInsertVenda=0;
}

public ArrayList<Pessoa> getPessoas() {
    return pessoas;
}

public void setPessoas(ArrayList<Pessoa> pessoas) {
    this.pessoas = pessoas;
}

public ArrayList<Automovel> getAutomoveis() {
    return automoveis;
}

public void setAutomoveis(ArrayList<Automovel> automoveis) {
    this.automoveis = automoveis;
}

public ArrayList<Posto> getPostos() {
    return postos;
}

public void setPostos(ArrayList<Posto> postos) {
    this.postos = postos;
}

public ArrayList<Locacao> getLocacoes() {
    return locacoes;
}

public void setLocacoes(ArrayList<Locacao> locacoes) {
    this.locacoes = locacoes;
}

public ArrayList<Venda> getVendas() { return vendas; }

public void setVendas(ArrayList<Venda> vendas) { this.vendas = vendas; }

public ArrayList<PlanoLocacao> getPlanosLocacoes() {
    return planosLocacoes;
}

public void setPlanosLocacoes(ArrayList<PlanoLocacao> planosLocacoes) {
    this.planosLocacoes = planosLocacoes;
}

public ArrayList<Feedback> getFeedbacks() {
    return feedbacks;
}

public void setFeedbacks(ArrayList<Feedback> feedbacks) {
    this.feedbacks = feedbacks;
}

public int getLastInsertPessoa() { return lastInsertPessoa; }

public int getLastInsertAutomovel() { return lastInsertAutomovel; }

public int getLastInsertPosto() { return lastInsertPosto; }

public int getLastInsertLocacao() { return lastInsertLocacao; }

public int getLastInsertVenda() { return lastInsertVenda; }

public int getLastInsertPlanoLocacao() { return lastInsertPlanoLocacao; }

public int getLastInsertFeedback() { return lastInsertFeedback; }

public void incLastInsertPessoa() {this.lastInsertPessoa++; }

public void incLastInsertAutomovel() {this.lastInsertAutomovel++; }

public void incLastInsertPosto() {this.lastInsertPosto++; }

public void incLastInsertLocacao() {this.lastInsertLocacao++; }

public void incLastInsertVenda() {this.lastInsertVenda++; }

public void incLastInsertPlanoLocacao() {this.lastInsertPlanoLocacao++; }

public void incLastInsertFeedback() {this.lastInsertFeedback++; }

}
