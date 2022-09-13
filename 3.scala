object Bank extends App{
    var accountList:List[Account] = List()

    def addAccount(uid:String, accId:Int):Unit = {
        val account = new Account(uid,accId)
        accountList = accountList ::: account :: Nil
        println(accountList)
    }

    val find = (acc:Int,accList:List[Account]) => accList.filter(account => account.accId.equals(acc))

    addAccount("1",100)
    addAccount("2",200)

    find(100,accountList)(0).deposit(5000);
    println(find(100,accountList))

    find(100,accountList)(0).transfer(200,1000)
    println(accountList)
}

class Account(val uid:String,val accId:Int,var balance:Double =0.0){
    def deposit(amount:Double):Unit= {
        this.balance = this.balance + amount
    }

    def withdraw(amount:Double):Unit= {
        if(this.balance<amount){
            println("Insufficient funds")
        }
        else{
            this.balance = this.balance - amount
        }
        
        
    }

    def transfer(account:Int, amount:Double):Unit={
        val reciever = Bank.find(account, Bank.accountList)
        if(this.balance<amount){
            println("Insufficient funds")
        }
        else{
            this.withdraw(amount)
            reciever(0).deposit(amount)
        }
    }

    override def toString: String = "[uid:"+this.uid+" |accId:"+this.accId.toString()+" |Balance:"+this.balance.toString+"]"

}