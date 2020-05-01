package io.diamondnetwork.task.response;

import java.util.List;

public class TokenResponse {
    /**
     * total_count : 2
     * count : 2
     * page_number : 1
     * page_total : 1
     * limit : 10
     * txs : [{"height":"23675","txhash":"20D4232107A740E1BC913189FA799011F1DF74CB4840A0259C9EEB9E96E43DB7","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"issue_token\",\"attributes\":[{\"key\":\"symbol\",\"value\":\"abc\"},{\"key\":\"owner\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]},{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"sender\",\"value\":\"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk\"},{\"key\":\"module\",\"value\":\"asset\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"issue_token\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"amount\",\"value\":\"20000000000abc\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]}],"gas_wanted":"200000","gas_used":"24520","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"asset/MsgIssueToken","value":{"name":"abc","symbol":"abc","total_supply":"20000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"url":"abc.com","description":"a test coin","identity":"4345334"}}],"fee":{"amount":[{"denom":"cet","amount":"4000000"}],"gas":"200000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Vd5w+rPc8l0rsOS4I48UAXdUAKU1NskP+QUjr4fYOe4Htfdw3FzH8gO/vquRXId3xwqJtOYzkOZxgupsd6hO0Q=="}],"memo":""}},"timestamp":"2020-04-17T03:17:05Z","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]},{"height":"32317","txhash":"E60A342DECA507F6E1486EF118A24E75A7454213BC79E88175442AAF6AAF64D3","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"issue_token\",\"attributes\":[{\"key\":\"symbol\",\"value\":\"vfc\"},{\"key\":\"owner\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]},{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"sender\",\"value\":\"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk\"},{\"key\":\"module\",\"value\":\"asset\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"issue_token\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"amount\",\"value\":\"50000000000vfc\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"vfc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"50000000000vfc"}]}]}],"gas_wanted":"200000","gas_used":"25400","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"asset/MsgIssueToken","value":{"name":"VFC Token","symbol":"vfc","total_supply":"50000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":false,"burnable":true,"addr_forbiddable":false,"token_forbiddable":false,"url":"www.abc.org","description":"token abc is a example token","identity":"string"}}],"fee":{"amount":[{"denom":"cet","amount":"4000000"}],"gas":"200000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"1c03NDbB1aKsg6JDqDRKy/lrwwwtbCrTPIK9Aq9iIYJZ5y+T4rz2aeQw4NuBFlMR2/p6wqFzU3MRbGmhPnXIpw=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-17T08:06:47Z","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"vfc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"50000000000vfc"}]}]}]
     */

    private String total_count;
    private String count;
    private String page_number;
    private String page_total;
    private String limit;
    private List<TxsBean> txs;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPage_number() {
        return page_number;
    }

    public void setPage_number(String page_number) {
        this.page_number = page_number;
    }

    public String getPage_total() {
        return page_total;
    }

    public void setPage_total(String page_total) {
        this.page_total = page_total;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public List<TxsBean> getTxs() {
        return txs;
    }

    public void setTxs(List<TxsBean> txs) {
        this.txs = txs;
    }

    public static class TxsBean {
        /**
         * height : 23675
         * txhash : 20D4232107A740E1BC913189FA799011F1DF74CB4840A0259C9EEB9E96E43DB7
         * raw_log : [{"msg_index":0,"success":true,"log":"","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]}]
         * logs : [{"msg_index":0,"success":true,"log":"","events":[{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]}]
         * gas_wanted : 200000
         * gas_used : 24520
         * tx : {"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"asset/MsgIssueToken","value":{"name":"abc","symbol":"abc","total_supply":"20000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"url":"abc.com","description":"a test coin","identity":"4345334"}}],"fee":{"amount":[{"denom":"cet","amount":"4000000"}],"gas":"200000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Vd5w+rPc8l0rsOS4I48UAXdUAKU1NskP+QUjr4fYOe4Htfdw3FzH8gO/vquRXId3xwqJtOYzkOZxgupsd6hO0Q=="}],"memo":""}}
         * timestamp : 2020-04-17T03:17:05Z
         * events : [{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]
         */

        private String height;
        private String txhash;
        private String raw_log;
        private String gas_wanted;
        private String gas_used;
        private TxBean tx;
        private String timestamp;
        private List<LogsBean> logs;
        private List<EventsBeanX> events;

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getTxhash() {
            return txhash;
        }

        public void setTxhash(String txhash) {
            this.txhash = txhash;
        }

        public String getRaw_log() {
            return raw_log;
        }

        public void setRaw_log(String raw_log) {
            this.raw_log = raw_log;
        }

        public String getGas_wanted() {
            return gas_wanted;
        }

        public void setGas_wanted(String gas_wanted) {
            this.gas_wanted = gas_wanted;
        }

        public String getGas_used() {
            return gas_used;
        }

        public void setGas_used(String gas_used) {
            this.gas_used = gas_used;
        }

        public TxBean getTx() {
            return tx;
        }

        public void setTx(TxBean tx) {
            this.tx = tx;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public List<LogsBean> getLogs() {
            return logs;
        }

        public void setLogs(List<LogsBean> logs) {
            this.logs = logs;
        }

        public List<EventsBeanX> getEvents() {
            return events;
        }

        public void setEvents(List<EventsBeanX> events) {
            this.events = events;
        }

        public static class TxBean {
            /**
             * type : cosmos-sdk/StdTx
             * value : {"msg":[{"type":"asset/MsgIssueToken","value":{"name":"abc","symbol":"abc","total_supply":"20000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"url":"abc.com","description":"a test coin","identity":"4345334"}}],"fee":{"amount":[{"denom":"cet","amount":"4000000"}],"gas":"200000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Vd5w+rPc8l0rsOS4I48UAXdUAKU1NskP+QUjr4fYOe4Htfdw3FzH8gO/vquRXId3xwqJtOYzkOZxgupsd6hO0Q=="}],"memo":""}
             */

            private String type;
            private ValueBeanX value;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ValueBeanX getValue() {
                return value;
            }

            public void setValue(ValueBeanX value) {
                this.value = value;
            }

            public static class ValueBeanX {
                /**
                 * msg : [{"type":"asset/MsgIssueToken","value":{"name":"abc","symbol":"abc","total_supply":"20000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"url":"abc.com","description":"a test coin","identity":"4345334"}}]
                 * fee : {"amount":[{"denom":"cet","amount":"4000000"}],"gas":"200000"}
                 * signatures : [{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Vd5w+rPc8l0rsOS4I48UAXdUAKU1NskP+QUjr4fYOe4Htfdw3FzH8gO/vquRXId3xwqJtOYzkOZxgupsd6hO0Q=="}]
                 * memo :
                 */

                private FeeBean fee;
                private String memo;
                private List<MsgBean> msg;
                private List<SignaturesBean> signatures;

                public FeeBean getFee() {
                    return fee;
                }

                public void setFee(FeeBean fee) {
                    this.fee = fee;
                }

                public String getMemo() {
                    return memo;
                }

                public void setMemo(String memo) {
                    this.memo = memo;
                }

                public List<MsgBean> getMsg() {
                    return msg;
                }

                public void setMsg(List<MsgBean> msg) {
                    this.msg = msg;
                }

                public List<SignaturesBean> getSignatures() {
                    return signatures;
                }

                public void setSignatures(List<SignaturesBean> signatures) {
                    this.signatures = signatures;
                }

                public static class FeeBean {
                    /**
                     * amount : [{"denom":"cet","amount":"4000000"}]
                     * gas : 200000
                     */

                    private String gas;
                    private List<AmountBean> amount;

                    public String getGas() {
                        return gas;
                    }

                    public void setGas(String gas) {
                        this.gas = gas;
                    }

                    public List<AmountBean> getAmount() {
                        return amount;
                    }

                    public void setAmount(List<AmountBean> amount) {
                        this.amount = amount;
                    }

                    public static class AmountBean {
                        /**
                         * denom : cet
                         * amount : 4000000
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

                public static class MsgBean {
                    /**
                     * type : asset/MsgIssueToken
                     * value : {"name":"abc","symbol":"abc","total_supply":"20000000000","owner":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","mintable":true,"burnable":true,"addr_forbiddable":true,"token_forbiddable":true,"url":"abc.com","description":"a test coin","identity":"4345334"}
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
                         * owner : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
                         * mintable : true
                         * burnable : true
                         * addr_forbiddable : true
                         * token_forbiddable : true
                         * url : abc.com
                         * description : a test coin
                         * identity : 4345334
                         */

                        private String name;
                        private String symbol;
                        private String total_supply;
                        private String owner;
                        private boolean mintable;
                        private boolean burnable;
                        private boolean addr_forbiddable;
                        private boolean token_forbiddable;
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

                public static class SignaturesBean {
                    /**
                     * pub_key : {"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"}
                     * signature : Vd5w+rPc8l0rsOS4I48UAXdUAKU1NskP+QUjr4fYOe4Htfdw3FzH8gO/vquRXId3xwqJtOYzkOZxgupsd6hO0Q==
                     */

                    private PubKeyBean pub_key;
                    private String signature;

                    public PubKeyBean getPub_key() {
                        return pub_key;
                    }

                    public void setPub_key(PubKeyBean pub_key) {
                        this.pub_key = pub_key;
                    }

                    public String getSignature() {
                        return signature;
                    }

                    public void setSignature(String signature) {
                        this.signature = signature;
                    }

                    public static class PubKeyBean {
                        /**
                         * type : tendermint/PubKeySecp256k1
                         * value : A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N
                         */

                        private String type;
                        private String value;

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }
        }

        public static class LogsBean {
            /**
             * msg_index : 0
             * success : true
             * log :
             * events : [{"type":"issue_token","attributes":[{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"sender","value":"coinex16kfcdc9wgd0zjta7p67dh92twhk4lvujls8lmk"},{"key":"module","value":"asset"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"issue_token"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000000cet"},{"key":"recipient","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"amount","value":"20000000000abc"}]}]
             */

            private int msg_index;
            private boolean success;
            private String log;
            private List<EventsBean> events;

            public int getMsg_index() {
                return msg_index;
            }

            public void setMsg_index(int msg_index) {
                this.msg_index = msg_index;
            }

            public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public String getLog() {
                return log;
            }

            public void setLog(String log) {
                this.log = log;
            }

            public List<EventsBean> getEvents() {
                return events;
            }

            public void setEvents(List<EventsBean> events) {
                this.events = events;
            }

            public static class EventsBean {
                /**
                 * type : issue_token
                 * attributes : [{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]
                 */

                private String type;
                private List<AttributesBean> attributes;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<AttributesBean> getAttributes() {
                    return attributes;
                }

                public void setAttributes(List<AttributesBean> attributes) {
                    this.attributes = attributes;
                }

                public static class AttributesBean {
                    /**
                     * key : symbol
                     * value : abc
                     */

                    private String key;
                    private String value;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }
        }

        public static class EventsBeanX {
            /**
             * type : issue_token
             * attributes : [{"key":"symbol","value":"abc"},{"key":"owner","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]
             */

            private String type;
            private List<AttributesBeanX> attributes;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<AttributesBeanX> getAttributes() {
                return attributes;
            }

            public void setAttributes(List<AttributesBeanX> attributes) {
                this.attributes = attributes;
            }

            public static class AttributesBeanX {
                /**
                 * key : symbol
                 * value : abc
                 */

                private String key;
                private String value;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
