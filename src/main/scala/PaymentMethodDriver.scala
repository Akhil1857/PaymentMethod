object PaymentMethodDriver extends App {
  private val paymentMethodObject = new PaymentSystem

//Creating different payment methods
  val creditCard = new CreditCard(Map(
    "cardNumber" -> "1554892165465",
    "cardholderName" -> "John",
    "expirationDate" -> "12/22",
    "cvv" -> "073"
  ))
  val payPal = new PayPal(Map(
    "email" -> "Akhiltrivedi85@gmail.com",
    "password" -> "Akhil@2341"
  ))
  val bankTransfer = new BankTransfer(Map(
    "AccountNumber" -> "329465657645",
    "TransactionAmount" -> "210145"
  ))

  println("Please Enter the Amount :")
  private val amountToTransfer = scala.io.StdIn.readInt()
  println(paymentMethodObject.processPayment(amountToTransfer, "Credit"))

  //Adding the different payment method to the list
  paymentMethodObject.addPaymentMethod(creditCard)
  paymentMethodObject.addPaymentMethod(payPal)
  paymentMethodObject.addPaymentMethod(bankTransfer)

  println("Payment Option :") //Display all element in the list
  val paymentMethods = paymentMethodObject.listPaymentMethods()
  paymentMethods.foreach(method => println(method.toString))

}
