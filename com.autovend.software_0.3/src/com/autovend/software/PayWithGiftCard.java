package com.autovend.software;

public class PayWithGiftCard {
/*
1. Customer I/O: Signals to System that a gift card payment is to be made, and the amount of this.
2. System:EnablesCardReader.
3. CardReader:Receivesthecard.
4. Bank: If the amount is approved, places a hold on the amount against the available funds for the
account associated with the card.
5. Bank: Signals the hold number to the System.
6. System: Signals to the Bank to complete the transaction, communicating the hold number.
7. Bank: Records the transaction, releasing the hold and reducing the available credit for the account
associated to the card.
8. System: Reduces the remaining amount due by the amount of the transaction.
9. System: Signals to the Card Reader to release the card.
10.Card Reader: Indicates that the card should be removed.
11.Card Reader: Signals to the System that the operation is complete.
12.System: Signals to Customer I/O that the operation is complete and the remaining amount due is
reduced.
13.Continue with super use case.

difference from credit and debit payment:
      - no pin and no verification of pin

 */

}
