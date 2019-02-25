package utils

object StringUtils {
    fun ifEmptyString(s: String): String = if (s.isEmpty()) "" else s
}