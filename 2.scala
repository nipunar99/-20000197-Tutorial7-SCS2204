object main extends App{
    val x = new Rational(3,4)
    val y = new Rational(5,8)
    val z = new Rational(2,7)

    println(x-y-z)
}

class Rational(n:Int,d:Int){
    require(d>0)
    def numer = n //numerator
    def denom = d //denominator

    def neg = new Rational(-this.numer,this.denom)
    def -(r:Rational) = new Rational(this.numer*r.denom + r.neg.numer*this.denom,this.denom*r.denom)

    //def show = println(this.numer.toString()+"/"+this.denom.toString())
    override def toString():String = this.numer.toString+"/"+this.denom.toString
}