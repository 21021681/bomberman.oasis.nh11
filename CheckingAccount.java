public class CheckingAccount extends Account {
  public CheckingAccount(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  /** doDepositing. */
  public void deposit(double amount) {
    if (amount < 0) {
      System.out.println("Số tiền không hợp lệ");
    } else {
      try {
        doDepositing(amount);
        transactionList.add(
            new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount, balance - amount, balance));
      } catch (InvalidFundingAmountException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /** doWithdrawing. */
  public void withdraw(double amount)
      throws InvalidFundingAmountException, InsufficientFundsException {
    if (amount < 0) {
      throw new InvalidFundingAmountException(amount);
    } else if (amount > balance) {
      throw new InsufficientFundsException(amount);
    } else {
      try {
        doWithdrawing(amount);
        transactionList.add(
            new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount, balance + amount, balance));
      } catch (InvalidFundingAmountException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
