def balance(chars: List[Char]): Boolean = {

  def loop(counter: Int, chars: List[Char]): Int = {
    if (chars.isEmpty) counter else
    if (counter == 0 && chars.head == 41) 1 else
    if (chars.head == 40) loop(counter+1,chars.tail) else
    if (counter>0 && chars.head == 41) loop(counter-1,chars.tail) else loop(counter,chars.tail)
  }

  if (loop(0,chars).equals(0)) true else false
}