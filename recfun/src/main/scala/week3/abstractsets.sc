abstract class IntSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet{
  def contains(x:Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  def contains(x:Int): Boolean =
    if (x<elem) left contains x
    else if (x>elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if(x<elem) new NonEmpty(elem, left incl x,right)
    else if(x>elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{"+left+elem+right+"}"
  def union(other: IntSet): IntSet =
    ((left union right)) union other incl elem
}

val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4
val t3 = t2 incl 10
val s1 = new NonEmpty(2, new NonEmpty(1,Empty,Empty),new NonEmpty(20,Empty,Empty))

s1 union t3
