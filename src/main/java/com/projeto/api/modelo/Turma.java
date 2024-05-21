package com.projeto.api.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Turma {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idturma;
  private Time horario;
  private int duracao;
  private Date dataInicio;
  private Date dataFim;

  public int getIdturma() {
    return idturma;
  }

  public Time getHorario() {
    return horario;
  }

  public int getDuracao() {
    return duracao;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setIdturma(int idturma) {
    this.idturma = idturma;
  }

  public void setHorario(Time horario) {
    this.horario = horario;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  @ManyToOne
  @JoinColumn(name = "idinstrutor")
  private Instrutor instrutor;

  public Instrutor getInstrutor() {
    return instrutor;
  }

  public void setInstrutor(Instrutor instrutor) {
    this.instrutor = instrutor;
  } 
}
