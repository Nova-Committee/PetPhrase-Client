package committee.nova.petphrase.util

import org.apache.commons.lang3.StringUtils

import scala.annotation.tailrec
import scala.collection.immutable

object StringUtil {
  val punctuations: immutable.Seq[Char] = '!' :: '?' :: '.' :: '(' :: ')' :: '！' :: '？' :: '。' :: '（' :: '）' :: '~' :: '\'' :: '"' :: '”' :: '“' :: Nil

  def getLastPunc(string: String): Int = {
    val length = string.length
    if (length == 1) return if (punctuations.contains(string.last)) -1 else 0

    @tailrec
    def getPunc(string: String, index: Int): Int = if (!punctuations.contains(string.charAt(index))) index else if (index == 0) -1 else getPunc(string, index - 1)

    getPunc(string, length - 1)
  }

  def fillPetPhraseIn(original: String, petPhrase: String): String = {
    val index = getLastPunc(original) + 1
    if (index == 0) return original
    StringUtils.substring(original, 0, index) + petPhrase + StringUtils.substring(original, index)
  }
}
