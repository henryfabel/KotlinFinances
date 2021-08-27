package model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    //        var totalReceita = BigDecimal.ZERO
//        for (transacao in transacoes) {
//            if (transacao.tipo == Tipo.RECEITA) {
//                totalReceita = totalReceita.plus(transacao.valor)
//            }
//        }
    val receita get() = somaPor(Tipo.RECEITA)

    val despesa get() = somaPor(Tipo.DESPESA)

    val total get() = receita.subtract(despesa)

    private fun somaPor(tipo: Tipo): BigDecimal {
        val somaDeTransacoesPeloTipo = transacoes
            .filter { it.tipo == tipo }
            .sumByDouble { it.valor.toDouble() }
        return BigDecimal(somaDeTransacoesPeloTipo)
    }
}
