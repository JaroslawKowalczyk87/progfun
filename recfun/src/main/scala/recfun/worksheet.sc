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

countChange(12,List(1,2,5))