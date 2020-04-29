package io.diamondnetwork.task.response;

import java.util.List;

public class ListTokenResponse {

    /**
     * height : 534484
     * result : [{"type":"asset/BaseToken","value":{"name":"abc","symbol":"abc","total_supply":"20000000000","send_lock":"0","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"total_burn":"0","total_mint":"0","is_forbidden":false,"url":"abc.com","description":"a test coin","identity":"4345334"}},{"type":"asset/BaseToken","value":{"name":"CoinEx Chain Native Token","symbol":"cet","total_supply":"586884903761317189","send_lock":"0","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":false,"burnable":true,"addr_forbiddable":false,"token_forbiddable":false,"total_burn":"413115096238682811","total_mint":"0","is_forbidden":false,"url":"www.coinex.org","description":"A public chain built for the decentralized exchange","identity":"552A83BA62F9B1F8"}},{"type":"asset/BaseToken","value":{"name":"VFC Token","symbol":"vfc","total_supply":"50000000000","send_lock":"0","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":false,"burnable":true,"addr_forbiddable":false,"token_forbiddable":false,"total_burn":"0","total_mint":"0","is_forbidden":false,"url":"www.abc.org","description":"token abc is a example token","identity":"string"}}]
     */

    private String height;
    private List<ResultBean> result;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * type : asset/BaseToken
         * value : {"name":"abc","symbol":"abc","total_supply":"20000000000","send_lock":"0","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"total_burn":"0","total_mint":"0","is_forbidden":false,"url":"abc.com","description":"a test coin","identity":"4345334"}
         */

        private String type;
        private ValueBean value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ValueBean getValue() {
            return value;
        }

        public void setValue(ValueBean value) {
            this.value = value;
        }

        public static class ValueBean {
            /**
             * name : abc
             * symbol : abc
             * total_supply : 20000000000
             * send_lock : 0
             * owner : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
             * mintable : true
             * burnable : true
             * addr_forbiddable : true
             * token_forbiddable : true
             * total_burn : 0
             * total_mint : 0
             * is_forbidden : false
             * url : abc.com
             * description : a test coin
             * identity : 4345334
             */

            private String name;
            private String symbol;
            private String total_supply;
            private String send_lock;
            private String owner;
            private boolean mintable;
            private boolean burnable;
            private boolean addr_forbiddable;
            private boolean token_forbiddable;
            private String total_burn;
            private String total_mint;
            private boolean is_forbidden;
            private String url;
            private String description;
            private String identity;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getTotal_supply() {
                return total_supply;
            }

            public void setTotal_supply(String total_supply) {
                this.total_supply = total_supply;
            }

            public String getSend_lock() {
                return send_lock;
            }

            public void setSend_lock(String send_lock) {
                this.send_lock = send_lock;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public boolean isMintable() {
                return mintable;
            }

            public void setMintable(boolean mintable) {
                this.mintable = mintable;
            }

            public boolean isBurnable() {
                return burnable;
            }

            public void setBurnable(boolean burnable) {
                this.burnable = burnable;
            }

            public boolean isAddr_forbiddable() {
                return addr_forbiddable;
            }

            public void setAddr_forbiddable(boolean addr_forbiddable) {
                this.addr_forbiddable = addr_forbiddable;
            }

            public boolean isToken_forbiddable() {
                return token_forbiddable;
            }

            public void setToken_forbiddable(boolean token_forbiddable) {
                this.token_forbiddable = token_forbiddable;
            }

            public String getTotal_burn() {
                return total_burn;
            }

            public void setTotal_burn(String total_burn) {
                this.total_burn = total_burn;
            }

            public String getTotal_mint() {
                return total_mint;
            }

            public void setTotal_mint(String total_mint) {
                this.total_mint = total_mint;
            }

            public boolean isIs_forbidden() {
                return is_forbidden;
            }

            public void setIs_forbidden(boolean is_forbidden) {
                this.is_forbidden = is_forbidden;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIdentity() {
                return identity;
            }

            public void setIdentity(String identity) {
                this.identity = identity;
            }
        }
    }
}
