object main extends App{
    val num = new Rational(1,2)
    num.show
    val negative = num.neg
    negative.show
}

class Rational(n:Int,d:Int){
    require(d>0)
    def numer = n //numerator
    def denom = d //denominator

    def neg = new Rational(-this.numer,this.denom)
    def show = println(this.numer.toString()+"/"+this.denom.toString())

}