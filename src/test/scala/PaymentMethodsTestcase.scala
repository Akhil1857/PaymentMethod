import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PaymentMethodsTestcase extends AnyFlatSpec with Matchers{
  val paymentSystem = new PaymentSystem()

  "PaymentSystem" should "add payment methods" in {
    val creditCard = new CreditCard(Map(
      "cardNumber" -> "1234567812345678",
      "cardholderName" -> "John Doe",
      "expirationDate" -> "12/22",
      "cvv" -> "123"
    ))
    paymentSystem.addPaymentMethod(creditCard)
    paymentSystem.listPaymentMethods should contain(creditCard)
  }

  it should "add payment method of Paypal " in {
    val paypal = new PayPal(Map(
      "email" -> "johndoe@gmail.com",
      "password" -> "mypassword"
    ))
    paymentSystem.addPaymentMethod(paypal)
    paymentSystem.listPaymentMethods should contain(paypal)

  }

  it should "add payment method as a BankTransfer" in {
    val bankTransfer = new BankTransfer(Map(
      "accountNumber" -> "12345678",
      "routingNumber" -> "987654321"
    ))
    paymentSystem.addPaymentMethod(bankTransfer)
    paymentSystem.listPaymentMethods should contain(bankTransfer)

  }

}
