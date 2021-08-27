package extension

import java.text.SimpleDateFormat
import java.util.Calendar

//extension function
fun Calendar.formataParaBrasileiro(): String {
    //formatador de data
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}