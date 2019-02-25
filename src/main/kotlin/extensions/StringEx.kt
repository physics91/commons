package extensions

fun String.ifEmptyString(): String = if (isEmpty()) "" else this