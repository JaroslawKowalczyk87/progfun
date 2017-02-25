type Set = Int => Boolean

def biggur(elem: Int): Boolean = {
  if (elem > 2) true
  else false
}
def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = set => set==elem

val a = singletonSet(3)
val b = singletonSet(2)
def union(s: Set, t: Set): Set = elem => s(elem) || t(elem)

val c = union(a,b)

def intersect(s: Set, t: Set): Set = elem => s(elem) && t(elem)
contains(c,4)
val d = intersect(a,c)
contains(d,3)
def diff(s: Set, t: Set): Set = elem => s(elem) && !t(elem)
val e = diff(c,a)
contains(e,2)
def filter(s: Set, p: Int => Boolean): Set = elem => s(elem) && (p(elem) == true)
def f = filter(c, biggur)
contains(f,2)
contains(f,3)
contains(f,4)
