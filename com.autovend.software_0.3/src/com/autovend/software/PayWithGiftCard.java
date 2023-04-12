package com.autovend.software;

import com.autovend.Card;
import com.autovend.GiftCard;
import com.autovend.devices.AbstractDevice;
import com.autovend.devices.CardReader;
import com.autovend.devices.SelfCheckoutStation;
import com.autovend.devices.SimulationException;
import com.autovend.devices.observers.AbstractDeviceObserver;
import com.autovend.devices.observers.CardReaderObserver;
import com.autovend.external.CardIssuer;

import java.math.BigDecimal;

public class PayWithGiftCard extends Pay implements CardReaderObserver{
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
      - only insert

 */
    private BigDecimal amountToPay;
    private GiftCard giftCard;
    private CardIssuer cardIssuer;
    public PayWithGiftCard(SelfCheckoutStation station, GiftCard giftCard) {

        super(station;
        /*if(giftCard == null){
            throw new SimulationException(new NullPointerException("No arguments may be null."));
        }

        if (amountToPay.compareTo(super.getAmountDue().subtract(PurchasedItems.getAmountPaid())) > 0) {
            this.amountToPay = super.getAmountDue().subtract(PurchasedItems.getAmountPaid());
        } else this.amountToPay = amountToPay;
        this.giftCard = giftCard;*/
    }

    @Override
    public void reactToEnabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {

    }

    @Override
    public void reactToDisabledEvent(AbstractDevice<? extends AbstractDeviceObserver> device) {

    }

    @Override
    public void reactToCardInsertedEvent(CardReader reader) {

    }

    @Override
    public void reactToCardRemovedEvent(CardReader reader) {

    }

    @Override
    public void reactToCardTappedEvent(CardReader reader) {

    }

    @Override
    public void reactToCardSwipedEvent(CardReader reader) {

    }

    @Override
    public void reactToCardDataReadEvent(CardReader reader, Card.CardData data) {
        int holdNumber = cardIssuer.authorizeHold(data.getNumber(), PurchasedItems.getAmountLeftToPay()); 						  	// Contact card issuer and attempt to place a hold
        if (holdNumber == -1) return; 																		// Return if hold is unable to be placed
        boolean transactionPosted = cardIssuer.postTransaction(data.getNumber(), holdNumber, PurchasedItems.getAmountLeftToPay()); 	// Contact card issuer to attempt to post transaction
        if (transactionPosted) super.pay(PurchasedItems.getAmountLeftToPay());
    }

}
