package br.com.mateus.portfolio.model;

/** Dados de cada projeto apresentado na página. */
public record Projeto(String numero, String titulo, String descricao,
                      String categoria, String tecnologias, String url) { }
