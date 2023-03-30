import scala.collection.mutable.ListBuffer

// Payment Methods used for payment
trait PaymentMethod

// Credit card class takes details of the credit card
class CreditCard(details: Map[String, String]) extends PaymentMethod {
  val cardNumber = details.getOrElse("cardNumber", "")
  val cardHolderName = details.getOrElse("cardHolderName", "")
  val expirationDate: String = details.getOrElse("expirationDate", "")
  val cvv = details.getOrElse("cvv", "")
}

// Paypal details
class PayPal(details: Map[String, String]) extends PaymentMethod {
  val email = details.getOrElse("email", "")
  val password = details.getOrElse("password", "")

}

//BankTransfer details
class BankTransfer(details: Map[String, String]) extends PaymentMethod {
  val accountNumber: String = details.getOrElse("AccountNumber", "")
  val transactionNumber: String = details.getOrElse("TransactionNumber", "")

}

class PaymentSystem {
  private val paymentMethods: ListBuffer[PaymentMethod] = ListBuffer.empty[PaymentMethod]

  // addPaymentMethod add the different payment method into the list
  def addPaymentMethod(paymentMethod: PaymentMethod): Unit = {
    paymentMethods += paymentMethod
  }

  //Performs the transaction
  def processPayment(amount: Double, transactionType: String): String = {
    transactionType match {
      case "Credit" => s"The payment of $amount has been Credited Successfully"
      case "Debit" => s"The payment of $amount has been Transferred Successfully"
      case _ => throw new IllegalArgumentException()
    }
  }

  //returns the list of all the payment type
  def listPaymentMethods(): ListBuffer[PaymentMethod] = {
    paymentMethods
  }

}