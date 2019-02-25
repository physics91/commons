package functions

/**
 * 간소화한 예외처리 구문
 *
 * @param block
 * @return 성공시 타입 인스턴스 실패 시 null
 */
inline fun <T> nullTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
    null
}

/**
 * 디버그 널
 *
 * @param block
 * @return 성공시 타입 인스턴스 실패 시 null
 */
inline fun <T> debugNullTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
    e.printStackTrace()
    null
}

/**
 * 빈 예외처리
 *
 * @param block
 * @return
 */
inline fun <T> emptyTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
}

/**
 * 디버그용
 *
 * @param block
 */
inline fun <T> debugTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
    e.printStackTrace()
}