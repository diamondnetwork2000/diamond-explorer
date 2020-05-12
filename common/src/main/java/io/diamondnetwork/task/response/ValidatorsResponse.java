package io.diamondnetwork.task.response;

import java.util.List;

public class ValidatorsResponse {

    /**
     * height : 79672
     * result : [{"operator_address":"dkdvaloper1009xrk0arzqtd0g9pmn2gw6nd2k5zhkvytyn4j","consensus_pubkey":"dkdvalconspub1zcjduepqp25nn4nzz2fqksc2f20r5wc846lvjgcy9hctc8c9c2yeez5fr6gs78c3aj","jailed":false,"status":2,"tokens":"1000000000000000","delegator_shares":"1000000000000000.000000000000000000","description":{"moniker":"moniker0","identity":"","website":"","details":""},"unbonding_height":"0","unbonding_time":"1970-01-01T00:00:00Z","commission":{"commission_rates":{"rate":"0.100000000000000000","max_rate":"0.200000000000000000","max_change_rate":"0.010000000000000000"},"update_time":"2020-05-09T06:23:56.754424714Z"},"min_self_delegation":"1000000000000000"}]
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
         * operator_address : dkdvaloper1009xrk0arzqtd0g9pmn2gw6nd2k5zhkvytyn4j
         * consensus_pubkey : dkdvalconspub1zcjduepqp25nn4nzz2fqksc2f20r5wc846lvjgcy9hctc8c9c2yeez5fr6gs78c3aj
         * jailed : false
         * status : 2
         * tokens : 1000000000000000
         * delegator_shares : 1000000000000000.000000000000000000
         * description : {"moniker":"moniker0","identity":"","website":"","details":""}
         * unbonding_height : 0
         * unbonding_time : 1970-01-01T00:00:00Z
         * commission : {"commission_rates":{"rate":"0.100000000000000000","max_rate":"0.200000000000000000","max_change_rate":"0.010000000000000000"},"update_time":"2020-05-09T06:23:56.754424714Z"}
         * min_self_delegation : 1000000000000000
         */

        private String operator_address;
        private String consensus_pubkey;
        private boolean jailed;
        private int status;
        private String tokens;
        private String delegator_shares;
        private DescriptionBean description;
        private String unbonding_height;
        private String unbonding_time;
        private CommissionBean commission;
        private String min_self_delegation;

        public String getOperator_address() {
            return operator_address;
        }

        public void setOperator_address(String operator_address) {
            this.operator_address = operator_address;
        }

        public String getConsensus_pubkey() {
            return consensus_pubkey;
        }

        public void setConsensus_pubkey(String consensus_pubkey) {
            this.consensus_pubkey = consensus_pubkey;
        }

        public boolean isJailed() {
            return jailed;
        }

        public void setJailed(boolean jailed) {
            this.jailed = jailed;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTokens() {
            return tokens;
        }

        public void setTokens(String tokens) {
            this.tokens = tokens;
        }

        public String getDelegator_shares() {
            return delegator_shares;
        }

        public void setDelegator_shares(String delegator_shares) {
            this.delegator_shares = delegator_shares;
        }

        public DescriptionBean getDescription() {
            return description;
        }

        public void setDescription(DescriptionBean description) {
            this.description = description;
        }

        public String getUnbonding_height() {
            return unbonding_height;
        }

        public void setUnbonding_height(String unbonding_height) {
            this.unbonding_height = unbonding_height;
        }

        public String getUnbonding_time() {
            return unbonding_time;
        }

        public void setUnbonding_time(String unbonding_time) {
            this.unbonding_time = unbonding_time;
        }

        public CommissionBean getCommission() {
            return commission;
        }

        public void setCommission(CommissionBean commission) {
            this.commission = commission;
        }

        public String getMin_self_delegation() {
            return min_self_delegation;
        }

        public void setMin_self_delegation(String min_self_delegation) {
            this.min_self_delegation = min_self_delegation;
        }

        public static class DescriptionBean {
            /**
             * moniker : moniker0
             * identity :
             * website :
             * details :
             */

            private String moniker;
            private String identity;
            private String website;
            private String details;

            public String getMoniker() {
                return moniker;
            }

            public void setMoniker(String moniker) {
                this.moniker = moniker;
            }

            public String getIdentity() {
                return identity;
            }

            public void setIdentity(String identity) {
                this.identity = identity;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }
        }

        public static class CommissionBean {
            /**
             * commission_rates : {"rate":"0.100000000000000000","max_rate":"0.200000000000000000","max_change_rate":"0.010000000000000000"}
             * update_time : 2020-05-09T06:23:56.754424714Z
             */

            private CommissionRatesBean commission_rates;
            private String update_time;

            public CommissionRatesBean getCommission_rates() {
                return commission_rates;
            }

            public void setCommission_rates(CommissionRatesBean commission_rates) {
                this.commission_rates = commission_rates;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public static class CommissionRatesBean {
                /**
                 * rate : 0.100000000000000000
                 * max_rate : 0.200000000000000000
                 * max_change_rate : 0.010000000000000000
                 */

                private String rate;
                private String max_rate;
                private String max_change_rate;

                public String getRate() {
                    return rate;
                }

                public void setRate(String rate) {
                    this.rate = rate;
                }

                public String getMax_rate() {
                    return max_rate;
                }

                public void setMax_rate(String max_rate) {
                    this.max_rate = max_rate;
                }

                public String getMax_change_rate() {
                    return max_change_rate;
                }

                public void setMax_change_rate(String max_change_rate) {
                    this.max_change_rate = max_change_rate;
                }
            }
        }
    }
}
