package io.diamondnetwork.model.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

public enum  TransactionType implements IEnum<Integer> {
   TRANSFER(1, "转账（包括内置货币和代币的转账）"),
   CREATE_ORDER(2, "创建订单"),
   CANCEL_ORDER(3, "取消订单"),
   ISSUE_TOKEN(4, "发行代币"),
   CREATE_MARKET(5, "创建市场");

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
