package com.example.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import com.example.financask.R
import extension.formataParaBrasileiro
import kotlinx.android.synthetic.main.resumo_card.view.*
import model.Resumo
import model.Transacao
import java.math.BigDecimal

class ResumoView(context: Context,
                private val view: View,
                transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun atualiza(){
        adicionaDespesa()
        adicionaReceita()
        adicionaTotal()
    }

    private fun adicionaReceita() {
        val totalReceita = resumo.receita
            with(view.resumo_card_receita) {
                setTextColor(corReceita)
                text = totalReceita.formataParaBrasileiro()
            }
    }

    private fun adicionaDespesa() {
        val totalDespesa = resumo.despesa
            with(view.resumo_card_despesa) {
                setTextColor(corDespesa)
                text = totalDespesa.formataParaBrasileiro()
            }
    }

    private fun adicionaTotal() {
        val total = resumo.total
        val cor = corPor(total)
            with(view.resumo_card_total) {
                setTextColor(cor)
                text = total.formataParaBrasileiro()
            }
    }

    private fun corPor(valor: BigDecimal): Int {
    //Early Return
        if (valor >= BigDecimal.ZERO) {
            return corReceita
        } else {
            return corDespesa
        }
    }
}