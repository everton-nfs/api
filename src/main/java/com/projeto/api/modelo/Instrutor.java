package com.projeto.api.modelo;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Instrutor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idinstrutor;
  private int RG;
  private String nome;
  private Date nascimento;
  private int titulacao;

  public int getIdinstrutor() {
    return idinstrutor;
  }

  public void setIdinstrutor(int idinstrutor) {
    this.idinstrutor = idinstrutor;
  }

  public int getRG() {
    return RG;
  }

  public void setRG(int RG) {
    this.RG = RG;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public int getTitulacao() {
    return titulacao;
  }

  public void setTitulacao(int titulacao) {
    this.titulacao = titulacao;
  }

  @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
  private List<Turma> turmas;

  public List<Turma> getTurmas() {
    return turmas;
  }

  public void setTurmas(List<Turma> turmas) {
    this.turmas = turmas;
  }

}
