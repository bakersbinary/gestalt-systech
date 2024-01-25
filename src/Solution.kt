object Solution {

  fun question1() {
    val pointer = listOf("a. ", "b. ", "c. ", "d. ")
    val cars = mutableListOf("Volvo", "BMW", "Toyota", "Kijang")

    for (i in 0..<cars.size) {
      val selectedPointer = pointer[i]
      if (i == 0) {
        println("$selectedPointer${cars.joinToString()}")
      } else {
        val first = cars[0]
        val last = cars[i]
        if (i < cars.size) {
          cars[0] = last
          cars[i] = first
          println("$selectedPointer${cars.joinToString()}")
        } else {
          println("$selectedPointer${cars.subList(0, cars.size.minus(1)).apply { add(0, last) }.joinToString()}")
        }
      }
    }
  }

  fun question2() {
    var pointer = "0"
    for (i in 1 until 10) {
      if (i == 1) {
        println("- ${pointer}$i")
      }

      pointer += "0"

      when (i) {
        in 1..4 -> println("- ${pointer}${i.plus(1)}")
        in 5..8 -> println("- ${i.plus(1)}${pointer}")
        else -> println("- ${i.plus(1)}${pointer.substring(0, pointer.length.minus(1))}")
      }
    }
  }

  fun question3() {
    val content =
      "Coding merupakan kegiatan yang dimana kamu memberitahukan komputer apa yang harus dia kerjakan untuk kamu. Sebuah kode yang ada pada skrip bisa diibaratkan layaknya bahasa sehari-hari. Setiap kode yang kamu tulis akan membantu komputer untuk mengetahui dan memahami apa yang ingin kamu lakukan pada komputer"
    val cleanOfContent = content
      .lowercase()
      .replace(" ", "")
      .replace(".", "")
      .replace("-", "")

    val numberOfLetters = cleanOfContent.length
    println("Number of Letters: $numberOfLetters")

    val numberOfWords = content.split(" ").count()
    println("Number of Words: $numberOfWords")

    val vocals = "aiueo".toCharArray().toList()
    var numberOfVocals = 0
    vocals.forEach { vocal ->
      numberOfVocals += cleanOfContent.count { it.toString() == vocal.toString() }
    }
    println("Number of Vocals: $numberOfVocals")

    val consonants = "bcdfghjklmnpqrstvwxyz".toCharArray().toList()
    var numberOfConsonants = 0
    consonants.forEach { consonant ->
      numberOfConsonants += cleanOfContent.count { it.toString() == consonant.toString() }
    }
    println("Number of Consonants: $numberOfConsonants")

    val words = content.replace(".", "").split(" ").associate { it.lowercase() to 0 }.toMutableMap()
    words.map {
      val value = words.getValue(it.key).plus(1)
      words[it.key] = value
    }

    val mostWords = words.maxBy { it.key }.key
    println("Most Words: $mostWords")
  }

  fun question4() {
    val kucing = Kucing()
    kucing.bersuara()

    val anjing = Anjing()
    anjing.bersuara()
  }

  fun question5() {
    val datas = listOf(listOf(9, 5, 2), listOf(1, 3, 8), listOf(10, 15, 12), listOf(4, 7, 6), listOf(13, 11, 14))
    println("SORTING")
    datas.forEach {
      println(it.sorted())
    }

    println("\nSUMMATION")
    datas.forEach {
      println(it.calculate())
    }

    println("\nFIND MAX")
    datas.forEach {
      println(it.findMax())
    }
  }

  private fun List<Int>.calculate(): Int {
    var result = 0
    forEach {
      if (it % 2 == 1) result += it
    }
    return result
  }

  private fun List<Int>.findMax(): Int {
    var result = 0
    forEach {
      if (result == 0) {
        result = it
      }

      if (it > result) {
        result = it
      }
    }

    return result
  }
}

abstract class Hewan {

  open fun bersuara() {}
}

class Kucing : Hewan() {

  override fun bersuara() {
    println("Meow")
  }
}

class Anjing : Hewan() {

  override fun bersuara() {
    println("Woof")
  }
}