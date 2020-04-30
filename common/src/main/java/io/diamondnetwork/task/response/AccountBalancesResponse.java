package io.diamondnetwork.task.response;

import java.util.List;

public class AccountBalancesResponse {

    /**
     * height : 584435
     * result : {"coins":[{"denom":"abc","amount":"19999999900"},{"denom":"cet","amount":"98999753962000000"},{"denom":"vfc","amount":"45000000000"}],"locked_coins":null,"frozen_coins":[]}
     */

    private String height;
    private ResultBean result;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * coins : [{"denom":"abc","amount":"19999999900"},{"denom":"cet","amount":"98999753962000000"},{"denom":"vfc","amount":"45000000000"}]
         * locked_coins : null
         * frozen_coins : []
         */

        private Object locked_coins;
        private List<CoinsBean> coins;
        private List<CoinsBean> frozen_coins;

        public Object getLocked_coins() {
            return locked_coins;
        }

        public void setLocked_coins(Object locked_coins) {
            this.locked_coins = locked_coins;
        }

        public List<CoinsBean> getCoins() {
            return coins;
        }

        public void setCoins(List<CoinsBean> coins) {
            this.coins = coins;
        }

        public List<CoinsBean> getFrozen_coins() {
            return frozen_coins;
        }

        public void setFrozen_coins(List<CoinsBean> frozen_coins) {
            this.frozen_coins = frozen_coins;
        }

        public static class CoinsBean {
            /**
             * denom : abc
             * amount : 19999999900
             */

            private String denom;
            private String amount;

            public String getDenom() {
                return denom;
            }

            public void setDenom(String denom) {
                this.denom = denom;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }
        }
    }
}
