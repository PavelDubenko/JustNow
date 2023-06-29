fun main () {
  val secondsAgo = 3660
  val text = agoToText(secondsAgo)
  println(text)
}

fun agoToText(seconds: Int): String {
    return when {
        seconds <= 60 -> "был(а) только что"
        seconds <= 60 * 60 -> "был ${minutesToText(seconds / 60)} назад"
        seconds <= 24 * 60 * 60 -> "был ${hoursToText(seconds / (60 * 60))} назад"
        seconds <= 2 * 24 * 60 * 60 -> "был вчера"
        seconds <= 3 * 24 * 60 * 60 -> "был позавчера"
        else -> "был давно"
    }
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
