package extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun BigDecimal.formataParaBrasileiro() : String{
    //Formatando para moeda Brasileira
    val formatoBrasileiro = DecimalFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatoBrasileiro
        .format(this)
        .replace("R$", "R$ ")
        .replace("-R$ ", "R$ -")
}

