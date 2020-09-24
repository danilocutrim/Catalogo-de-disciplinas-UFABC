package br.com.ufabc.catalogo.model

data class Materia (
        var sigla: String?=null,
        var disciplina: String?=null,
        var tpi: String?=null,
        var recomendacao: String?=null,
        var objetivos: String?=null,
        var ementa: String?=null,
        var bibliografiaBasica: String?=null,
        var bibliografiaComplementar: String?=null
)
