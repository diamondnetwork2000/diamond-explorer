package io.diamondnetwork.model.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

public enum  TransactionType implements IEnum<Integer> {
   TRANSFER(1, "transfer"),
   CREATE_ORDER(2, "create order"),
   CANCEL_ORDER(3, "cancel order"),
   ISSUE_TOKEN(4, "issue token"),
   CREATE_MARKET(5, "create market"),
   TRANSFER_OWNERSHIP(6, "transfer ownership to new address"),
   MINT_TOKEN(7, "mint token"),
   CANCEL_MARKET(8, "cancel market"),
   MODIFY_MARKET_PRICE(9, "modify market price precision");

   int type;
   String desc;

   TransactionType(int type, String desc) {
      this.type = type;
      this.desc = desc;
   }


   @Override
   public Integer getValue() {
      return type;
   }
}
