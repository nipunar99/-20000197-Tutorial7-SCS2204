object Bank extends App{
    var accountList:List[Account] = List()

    def addAccount(uid:String, accId:Int):Unit = {
        val account = new Account(uid,accId)
        accountList = accountList ::: account :: Nil
        println(accountList)
    }

    val find = (acc:Int,accList:List[Account]) => accList.filter(account => account.accId.equals(acc))

    val negativeAccs = (accList:List[Account])=>accList.filter(account => account.balance<0.0)
    val totalAccBalance = (accList:List[Account])=>accList.foldLeft(0.0)((x,y)=>x+y.balance)
    val interests = (accList:List[Account])=>accList.map(account => if(account.balance>0) account.balance*0.05 else account.balance*0.1)

    addAccount("1",100)
    addAccount("2",200)

    find(100,accountList)(0).deposit(5000);
    println(find(100,accountList))

    find(200,accountList)(0).withdraw(100)
    println(accountList)

    println(negativeAccs(accountList))
    println(totalAccBalance(accountList))
    println (interests(accountList))
}

class Account(val uid:String,val accId:Int,var balance:Double =0.0){
    def deposit(amount:Double):Unit= {
        this.balance = this.balance + amount
    }

    def withdraw(amount:Double):Unit= {
        this.balance = this.balance - amount 
    }

    def transfer(account:Int, amount:Double):Unit={
        val reciever = Bank.find(account, Bank.accountList)
        this.withdraw(amount)
        reciever(0).deposit(amount)
        
    }

    override def toString: String = "[uid:"+this.uid+" |accId:"+this.accId.toString()+" |Balance:"+this.balance.toString+"]"

}