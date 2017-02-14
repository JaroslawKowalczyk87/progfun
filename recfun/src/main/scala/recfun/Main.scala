package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c==0 || r==c) 1
      else pascal(c-1, r-1) +  pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def loop(counter: Int, chars: List[Char]): Int = {
        // Ascii: 40 == ), 41 == (
        if (chars.isEmpty) counter else
        if (counter == 0 && chars.head == 41) 1 else
        if (chars.head == 40) loop(counter+1,chars.tail) else
        if (counter>0 && chars.head == 41) loop(counter-1,chars.tail) else loop(counter,chars.tail)
      }

      if (loop(0,chars).equals(0)) true else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money==0) 1 else
      if (coins.isEmpty || money<coins.sorted.head) 0
      else {
        def loop(moneyloop: Int, agg: Int, coins: List[Int]): Int =
          if (moneyloop == 0) 1
          else agg * countChange(moneyloop - coins.head, coins)

        loop(money, 1, coins)  + countChange(money, coins.tail)
      }
    }
  }
