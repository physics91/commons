package functions

import java.util.*

/**
 * 정수형 랜덤
 *
 * @return 랜덤 값
 */
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start

/**
 *
 *
 * @param percent 확률
 * @param fail 확률에 걸리지 않았을 경우
 * @param success 확률에 걸렸을 경우
 */
inline fun chanceOf(percent: Double, fail: () -> Unit = {}, success: () -> Unit) {
    val f = Math.random() * 100.00
    if (f <= percent) success()
    else fail()
}