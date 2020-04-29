package io.diamondnetwork.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public  interface TransactionType {

   static final Logger logger = LoggerFactory.getLogger(TransactionType.class);

   static final Map<Byte, Map<Byte, TransactionType>> TRANSACTION_TYPES = new HashMap<>();

   static final byte TYPE_PAYMENT = 0;
   static final byte TYPE_MESSAGING = 1;
   static final byte TYPE_COLORED_COINS = 2;
   static final byte TYPE_DIGITAL_GOODS = 3;
   static final byte TYPE_ACCOUNT_CONTROL = 4;
   static final byte TYPE_BURST_MINING = 20; // jump some for easier nxt updating
   static final byte TYPE_ADVANCED_PAYMENT = 21;
   static final byte TYPE_AUTOMATED_TRANSACTIONS = 22;

   static final byte SUBTYPE_PAYMENT_ORDINARY_PAYMENT = 0;
   static final byte SUBTYPE_PAYMENT_ORDINARY_PAYMENT_MULTI_OUT = 1;
   static final byte SUBTYPE_PAYMENT_ORDINARY_PAYMENT_MULTI_SAME_OUT = 2;

   static final byte SUBTYPE_MESSAGING_ARBITRARY_MESSAGE = 0;
   static final byte SUBTYPE_MESSAGING_ALIAS_ASSIGNMENT = 1;
   static final byte SUBTYPE_MESSAGING_ACCOUNT_INFO = 5;
   static final byte SUBTYPE_MESSAGING_ALIAS_SELL = 6;
   static final byte SUBTYPE_MESSAGING_ALIAS_BUY = 7;

   static final byte SUBTYPE_COLORED_COINS_ASSET_ISSUANCE = 0;
   static final byte SUBTYPE_COLORED_COINS_ASSET_TRANSFER = 1;
   static final byte SUBTYPE_COLORED_COINS_ASK_ORDER_PLACEMENT = 2;
   static final byte SUBTYPE_COLORED_COINS_BID_ORDER_PLACEMENT = 3;
   static final byte SUBTYPE_COLORED_COINS_ASK_ORDER_CANCELLATION = 4;
   static final byte SUBTYPE_COLORED_COINS_BID_ORDER_CANCELLATION = 5;

   static final byte SUBTYPE_DIGITAL_GOODS_LISTING = 0;
   static final byte SUBTYPE_DIGITAL_GOODS_DELISTING = 1;
   static final byte SUBTYPE_DIGITAL_GOODS_PRICE_CHANGE = 2;
   static final byte SUBTYPE_DIGITAL_GOODS_QUANTITY_CHANGE = 3;
   static final byte SUBTYPE_DIGITAL_GOODS_PURCHASE = 4;
   static final byte SUBTYPE_DIGITAL_GOODS_DELIVERY = 5;
   static final byte SUBTYPE_DIGITAL_GOODS_FEEDBACK = 6;
   static final byte SUBTYPE_DIGITAL_GOODS_REFUND = 7;

   static final byte SUBTYPE_AT_CREATION = 0;
   static final byte SUBTYPE_AT_NXT_PAYMENT = 1;

   static final byte SUBTYPE_ACCOUNT_CONTROL_EFFECTIVE_BALANCE_LEASING = 0;

   static final byte SUBTYPE_BURST_MINING_REWARD_RECIPIENT_ASSIGNMENT = 0;

   static final byte SUBTYPE_ADVANCED_PAYMENT_ESCROW_CREATION = 0;
   static final byte SUBTYPE_ADVANCED_PAYMENT_ESCROW_SIGN = 1;
   static final byte SUBTYPE_ADVANCED_PAYMENT_ESCROW_RESULT = 2;
   static final byte SUBTYPE_ADVANCED_PAYMENT_SUBSCRIPTION_SUBSCRIBE = 3;
   static final byte SUBTYPE_ADVANCED_PAYMENT_SUBSCRIPTION_CANCEL = 4;
   static final byte SUBTYPE_ADVANCED_PAYMENT_SUBSCRIPTION_PAYMENT = 5;



}
