package br.com.ufabc.catalogo

import br.com.ufabc.catalogo.model.Materia
import br.com.ufabc.catalogo.xlsx.XLSXExtractor
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream

class XLSXExtractorTest {

    @Test
    fun `teste de abertura de arquivo`(){
        val fileName = "/home/danilo/teste.xlsx"
        var planilha = XLSXExtractor.read(fileName)
        println(planilha[1211])

    }


}