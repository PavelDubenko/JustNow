fun main () {
  val text = agoToText(360000)
  println(text)
}

fun agoToText(seconds: Int): String {
    val text: String
    when {
        seconds <= 60 -> text = "был(а) только что"
        seconds <= 60 * 60 -> text = "был ${minutesToText(seconds / 60)} назад"
        seconds <= 24 * 60 * 60 -> text = "был ${hoursToText(seconds / (60 * 60))} назад"
        seconds <= 2 * 24 * 60 * 60 -> text = "был вчера"
        seconds <= 3 * 24 * 60 * 60 -> text = "был позавчера"
        else -> text = "был давно"
    }
    return text
}

fun minutesToText(minutes: Int): String {
    return when {
        minutes == 1 -> "1 минуту"
        minutes in 2..4 || minutes in 22..24 || minutes in 32..34 || minutes in 42..44 || minutes in 52..54 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText(hours: Int): String {
    return when {
        hours == 1 || hours % 10 == 1 && hours != 11 -> "$hours час"
        hours in 2..4 || hours % 10 in 2..4 && hours !in 12..14 -> "$hours часа"
        else -> "$hours часов"
    }
}
