package io.diamondnetwork.task.response;

import java.util.List;

public class OrderTxResponse {

    /**
     * total_count : 4
     * count : 1
     * page_number : 1
     * page_total : 4
     * limit : 1
     * txs : [{"height":"41279","txhash":"F5EB3A05463749D8B687648D459E3D8AE51117313584A9941115A9D57894B34F","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"create_market\",\"attributes\":[{\"key\":\"trading_pair\",\"value\":\"abc/cet\"},{\"key\":\"stock\",\"value\":\"abc\"},{\"key\":\"money\",\"value\":\"cet\"},{\"key\":\"price_precision\",\"value\":\"4\"},{\"key\":\"last_execute_price\",\"value\":\"0.000000000000000000\"}]},{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"module\",\"value\":\"market\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"create_market_info\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"10000000000cet\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]}],"gas_wanted":"100000","gas_used":"24000","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"market/MsgCreateTradingPair","value":{"stock":"abc","money":"cet","creator":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","price_precision":4,"order_precision":0}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"eoA6epnDkqQSncQQktYHR6tUW5grRLP8bjrvoxnM1JpAk6XLhpRuPIURaF1JbNmXFv//zy8mCrvQkyPcDEw58A=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-17T13:07:15Z","events":[{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]}]
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
         * height : 41279
         * txhash : F5EB3A05463749D8B687648D459E3D8AE51117313584A9941115A9D57894B34F
         * raw_log : [{"msg_index":0,"success":true,"log":"","events":[{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]}]
         * logs : [{"msg_index":0,"success":true,"log":"","events":[{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]}]
         * gas_wanted : 100000
         * gas_used : 24000
         * tx : {"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"market/MsgCreateTradingPair","value":{"stock":"abc","money":"cet","creator":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","price_precision":4,"order_precision":0}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"eoA6epnDkqQSncQQktYHR6tUW5grRLP8bjrvoxnM1JpAk6XLhpRuPIURaF1JbNmXFv//zy8mCrvQkyPcDEw58A=="}],"memo":"Sent with example memo"}}
         * timestamp : 2020-04-17T13:07:15Z
         * events : [{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]
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
             * value : {"msg":[{"type":"market/MsgCreateTradingPair","value":{"stock":"abc","money":"cet","creator":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","price_precision":4,"order_precision":0}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"eoA6epnDkqQSncQQktYHR6tUW5grRLP8bjrvoxnM1JpAk6XLhpRuPIURaF1JbNmXFv//zy8mCrvQkyPcDEw58A=="}],"memo":"Sent with example memo"}
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
                 * msg : [{"type":"market/MsgCreateTradingPair","value":{"stock":"abc","money":"cet","creator":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","price_precision":4,"order_precision":0}}]
                 * fee : {"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"}
                 * signatures : [{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"eoA6epnDkqQSncQQktYHR6tUW5grRLP8bjrvoxnM1JpAk6XLhpRuPIURaF1JbNmXFv//zy8mCrvQkyPcDEw58A=="}]
                 * memo : Sent with example memo
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
                     * amount : [{"denom":"cet","amount":"2000000"}]
                     * gas : 100000
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
                         * amount : 2000000
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
                     * type : market/MsgCreateTradingPair
                     * value : {"stock":"abc","money":"cet","creator":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","price_precision":4,"order_precision":0}
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
                         * stock : abc
                         * money : cet
                         * creator : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
                         * price_precision : 4
                         * order_precision : 0
                         */

                        private String stock;
                        private String money;
                        private String creator;
                        private int price_precision;
                        private int order_precision;

                        public String getStock() {
                            return stock;
                        }

                        public void setStock(String stock) {
                            this.stock = stock;
                        }

                        public String getMoney() {
                            return money;
                        }

                        public void setMoney(String money) {
                            this.money = money;
                        }

                        public String getCreator() {
                            return creator;
                        }

                        public void setCreator(String creator) {
                            this.creator = creator;
                        }

                        public int getPrice_precision() {
                            return price_precision;
                        }

                        public void setPrice_precision(int price_precision) {
                            this.price_precision = price_precision;
                        }

                        public int getOrder_precision() {
                            return order_precision;
                        }

                        public void setOrder_precision(int order_precision) {
                            this.order_precision = order_precision;
                        }
                    }
                }

                public static class SignaturesBean {
                    /**
                     * pub_key : {"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"}
                     * signature : eoA6epnDkqQSncQQktYHR6tUW5grRLP8bjrvoxnM1JpAk6XLhpRuPIURaF1JbNmXFv//zy8mCrvQkyPcDEw58A==
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
             * events : [{"type":"create_market","attributes":[{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]},{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"market"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"create_market_info"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"10000000000cet"}]}]
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
                 * type : create_market
                 * attributes : [{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]
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
                     * key : trading_pair
                     * value : abc/cet
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
             * type : create_market
             * attributes : [{"key":"trading_pair","value":"abc/cet"},{"key":"stock","value":"abc"},{"key":"money","value":"cet"},{"key":"price_precision","value":"4"},{"key":"last_execute_price","value":"0.000000000000000000"}]
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
                 * key : trading_pair
                 * value : abc/cet
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
