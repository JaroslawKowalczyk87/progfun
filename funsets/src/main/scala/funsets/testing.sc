type Set = Int => Boolean

def biggur(elem: Int): Boolean = {
  if (elem > 5) true
  else false
}
def contains(s: Set, elem: Int): Boolean = s(elem)


def singletonSet(elem: Int): Set = set => set==elem

val a = singletonSet(10)
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
def filter(s: Set, p: Int => Boolean): Set = elem => s(elem) && p(elem)
val bound=9

def emptySet: Set = elem => false

def map(s: Set, f: Int => Int): Set = {
  def iter(a: Int,t: Set): Set = {
    if (a>bound) t
    else if (contains(s,a)) iter (a+1,union(t,singletonSet(f(a))))
    else iter (a+1,t)
  }
  iter(1,emptySet)
}

val jeden = singletonSet(1)
val dwa = singletonSet(2)
val razem = union(jeden,dwa)

val dodacdwa = map(razem,i=>i+2)
contains(dodacdwa,1)
contains(dodacdwa,2)
contains(dodacdwa,3)
contains(dodacdwa,4)
contains(dodacdwa,5)
contains(razem,1)

