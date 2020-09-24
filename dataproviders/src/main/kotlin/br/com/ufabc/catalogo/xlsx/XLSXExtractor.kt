package br.com.ufabc.catalogo.xlsx

import br.com.ufabc.catalogo.model.Materia
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.io.FileInputStream

abstract class XLSXExtractor {
    companion object {
        fun read(path: String): List<Materia> {
            var materiaLista = mutableListOf<Materia>()
            val inputStream = FileInputStream(File(path).absolutePath)
            var xlWb = WorkbookFactory.create(inputStream)

            val sheet = xlWb.getSheetAt(0)

            val rowIterator = sheet.iterator()
            while (rowIterator.hasNext()) {
                val row = rowIterator.next()
                val celliterator = row.cellIterator()
                var  materia = Materia()
                materiaLista.add(materia)

                while (celliterator.hasNext()) {
                    val cell = celliterator.next()

                    when (cell.columnIndex) {
                        0 -> materia.sigla = cell.stringCellValue
                        1 -> materia.disciplina = cell.stringCellValue
                        2 -> materia.tpi = cell.stringCellValue
                        3 -> materia.recomendacao = cell.stringCellValue
                        4 -> materia.objetivos = cell.stringCellValue
                        5 -> materia.ementa = cell.stringCellValue
                        6 -> materia.bibliografiaBasica = cell.stringCellValue
                        7 -> materia.bibliografiaComplementar = cell.stringCellValue

                    }
                }
            }
            inputStream.close()
            materiaLista.map {
                Materia(
                        it.sigla,
                        it.disciplina,
                        it.tpi,
                        it.recomendacao,
                        it.objetivos,
                        it.ementa,
                        it.bibliografiaBasica,
                        it.bibliografiaComplementar
                )


            }
            return materiaLista
        }
    }
}