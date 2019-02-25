package utils

import functions.nullTry

/**
 * 한글을 다루는 데 필요한 기능들
 *
 *
 * @author kimjaeyeong
 */
object HangulUtils {

    val CHO_SUNG =
        charArrayOf('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
    val JOONG_SUNG =
        charArrayOf('ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ')
    val JONG_SUNG = charArrayOf(
        'ㄱ',
        'ㄲ',
        'ㄳ',
        'ㄴ',
        'ㄵ',
        'ㄶ',
        'ㄷ',
        'ㄹ',
        'ㄺ',
        'ㄻ',
        'ㄼ',
        'ㄽ',
        'ㄾ',
        'ㄿ',
        'ㅀ',
        'ㅁ',
        'ㅂ',
        'ㅄ',
        'ㅅ',
        'ㅆ',
        'ㅇ',
        'ㅈ',
        'ㅊ',
        'ㅋ',
        'ㅌ',
        'ㅍ',
        'ㅎ'
    )
    private const val FIRST_CODE = 44032 // Char 타입으로 '가'를 의미함
    private const val FACTOR1 = 21 * 28
    private const val FACTOR2 = 28

    /**
     * 한글 글자의 초성을 가져온다.
     *
     * @param char 한글자
     * @return 초성 반환이나 한글이 아닐 경우 null을 반환
     */
    fun getChoSung(char: Char): Char? {
        return nullTry {
            CHO_SUNG[(char.toInt() - FIRST_CODE) / FACTOR1]
        }
    }

    /**
     * 한글 글자의 중성을 가져온다.
     *
     * @param char 한글자
     * @return 중성 반환이나 한글이 아닐 경우 null을 반환
     */
    fun getJoongSung(char: Char): Char? {
        return nullTry {
            JOONG_SUNG[(char.toInt() - FIRST_CODE) % FACTOR1 / FACTOR2]
        }
    }

    /**
     * 한글 글자의 종성을 가져온다.
     *
     * @param char 한글자
     * @return 종성 반환이나 한글이 아닐 경우 null을 반환
     */
    fun getJongSung(char: Char): Char? {
        return nullTry {
            JONG_SUNG[(char.toInt() - FIRST_CODE) % FACTOR1 % FACTOR2]
        }
    }

    /**
     * 한글자가 한글인지 판독
     *
     * @param char 판독하고 싶은 글자
     * @return 한글이면 true
     */
    fun isHangul(char: Char): Boolean {
        return !(char < 0xAC00.toChar() || char > 0xD7A3.toChar())
    }

    /**
     * 문자열이 전부 한글인지 판독
     * 길이가 0인 문자열이 들어오면 한글로 판독 안함
     *
     * @param s 문자열
     * @return 전부 한글이면 true
     */
    fun isHangul(s: String): Boolean {
        if (s.isEmpty()) return false
        s.forEach {
            if (!isHangul(it)) return false
        }
        return true
    }
}