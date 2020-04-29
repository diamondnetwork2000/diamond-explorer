package io.diamondnetwork.task.response;

import java.util.List;

public class BlockDetail extends  BaseResponse {


    /**
     * block_meta : {"block_id":{"hash":"9AEC7344C87926681E2B2E9084D967FEF8E69DAE807BD5168A9BD54EE73C8483","parts":{"total":"1","hash":"8B28EEDD766760B1804EC1E88BFBE6F4A9B096C49776044932BB6D8587AEF660"}},"header":{"version":{"block":"10","app":"0"},"chain_id":"coinexdex-test1","height":"373391","time":"2020-04-25T06:41:49.047493686Z","num_txs":"0","total_txs":"21","last_block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"last_commit_hash":"9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491","data_hash":"","validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","next_validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","consensus_hash":"048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F","app_hash":"36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150","last_results_hash":"","evidence_hash":"","proposer_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2"},"BlockSize":"573"}
     * block : {"header":{"version":{"block":"10","app":"0"},"chain_id":"coinexdex-test1","height":"373391","time":"2020-04-25T06:41:49.047493686Z","num_txs":"0","total_txs":"21","last_block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"last_commit_hash":"9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491","data_hash":"","validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","next_validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","consensus_hash":"048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F","app_hash":"36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150","last_results_hash":"","evidence_hash":"","proposer_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2"},"data":{"txs":null},"evidence":{"evidence":null},"last_commit":{"block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"precommits":[{"type":2,"height":"373390","round":"0","block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"timestamp":"2020-04-25T06:41:49.047493686Z","validator_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2","validator_index":"0","signature":"lLmcioecGPOr/x3viWl3ilkxHQi6y8TBSed2M28sS+ZdyE9om07F+zurFomaEB6mEJjBwhb39InBvhGnq0LaDA=="}]}}
     */

    private BlockMetaBean block_meta;
    private BlockBean block;

    public BlockMetaBean getBlock_meta() {
        return block_meta;
    }

    public void setBlock_meta(BlockMetaBean block_meta) {
        this.block_meta = block_meta;
    }

    public BlockBean getBlock() {
        return block;
    }

    public void setBlock(BlockBean block) {
        this.block = block;
    }

    public static class BlockMetaBean {
        /**
         * block_id : {"hash":"9AEC7344C87926681E2B2E9084D967FEF8E69DAE807BD5168A9BD54EE73C8483","parts":{"total":"1","hash":"8B28EEDD766760B1804EC1E88BFBE6F4A9B096C49776044932BB6D8587AEF660"}}
         * header : {"version":{"block":"10","app":"0"},"chain_id":"coinexdex-test1","height":"373391","time":"2020-04-25T06:41:49.047493686Z","num_txs":"0","total_txs":"21","last_block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"last_commit_hash":"9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491","data_hash":"","validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","next_validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","consensus_hash":"048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F","app_hash":"36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150","last_results_hash":"","evidence_hash":"","proposer_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2"}
         * BlockSize : 573
         */

        private BlockIdBean block_id;
        private HeaderBean header;
        private String BlockSize;

        public BlockIdBean getBlock_id() {
            return block_id;
        }

        public void setBlock_id(BlockIdBean block_id) {
            this.block_id = block_id;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public String getBlockSize() {
            return BlockSize;
        }

        public void setBlockSize(String BlockSize) {
            this.BlockSize = BlockSize;
        }

        public static class BlockIdBean {
            /**
             * hash : 9AEC7344C87926681E2B2E9084D967FEF8E69DAE807BD5168A9BD54EE73C8483
             * parts : {"total":"1","hash":"8B28EEDD766760B1804EC1E88BFBE6F4A9B096C49776044932BB6D8587AEF660"}
             */

            private String hash;
            private PartsBean parts;

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public PartsBean getParts() {
                return parts;
            }

            public void setParts(PartsBean parts) {
                this.parts = parts;
            }

            public static class PartsBean {
                /**
                 * total : 1
                 * hash : 8B28EEDD766760B1804EC1E88BFBE6F4A9B096C49776044932BB6D8587AEF660
                 */

                private String total;
                private String hash;

                public String getTotal() {
                    return total;
                }

                public void setTotal(String total) {
                    this.total = total;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }
            }
        }

        public static class HeaderBean {
            /**
             * version : {"block":"10","app":"0"}
             * chain_id : coinexdex-test1
             * height : 373391
             * time : 2020-04-25T06:41:49.047493686Z
             * num_txs : 0
             * total_txs : 21
             * last_block_id : {"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}}
             * last_commit_hash : 9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491
             * data_hash :
             * validators_hash : 88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E
             * next_validators_hash : 88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E
             * consensus_hash : 048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F
             * app_hash : 36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150
             * last_results_hash :
             * evidence_hash :
             * proposer_address : 81360DD1EC7B5930565C59B8EDBE09CB02D785B2
             */

            private VersionBean version;
            private String chain_id;
            private Integer height;
            private String time;
            private String num_txs;
            private String total_txs;
            private LastBlockIdBean last_block_id;
            private String last_commit_hash;
            private String data_hash;
            private String validators_hash;
            private String next_validators_hash;
            private String consensus_hash;
            private String app_hash;
            private String last_results_hash;
            private String evidence_hash;
            private String proposer_address;

            public VersionBean getVersion() {
                return version;
            }

            public void setVersion(VersionBean version) {
                this.version = version;
            }

            public String getChain_id() {
                return chain_id;
            }

            public void setChain_id(String chain_id) {
                this.chain_id = chain_id;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getNum_txs() {
                return num_txs;
            }

            public void setNum_txs(String num_txs) {
                this.num_txs = num_txs;
            }

            public String getTotal_txs() {
                return total_txs;
            }

            public void setTotal_txs(String total_txs) {
                this.total_txs = total_txs;
            }

            public LastBlockIdBean getLast_block_id() {
                return last_block_id;
            }

            public void setLast_block_id(LastBlockIdBean last_block_id) {
                this.last_block_id = last_block_id;
            }

            public String getLast_commit_hash() {
                return last_commit_hash;
            }

            public void setLast_commit_hash(String last_commit_hash) {
                this.last_commit_hash = last_commit_hash;
            }

            public String getData_hash() {
                return data_hash;
            }

            public void setData_hash(String data_hash) {
                this.data_hash = data_hash;
            }

            public String getValidators_hash() {
                return validators_hash;
            }

            public void setValidators_hash(String validators_hash) {
                this.validators_hash = validators_hash;
            }

            public String getNext_validators_hash() {
                return next_validators_hash;
            }

            public void setNext_validators_hash(String next_validators_hash) {
                this.next_validators_hash = next_validators_hash;
            }

            public String getConsensus_hash() {
                return consensus_hash;
            }

            public void setConsensus_hash(String consensus_hash) {
                this.consensus_hash = consensus_hash;
            }

            public String getApp_hash() {
                return app_hash;
            }

            public void setApp_hash(String app_hash) {
                this.app_hash = app_hash;
            }

            public String getLast_results_hash() {
                return last_results_hash;
            }

            public void setLast_results_hash(String last_results_hash) {
                this.last_results_hash = last_results_hash;
            }

            public String getEvidence_hash() {
                return evidence_hash;
            }

            public void setEvidence_hash(String evidence_hash) {
                this.evidence_hash = evidence_hash;
            }

            public String getProposer_address() {
                return proposer_address;
            }

            public void setProposer_address(String proposer_address) {
                this.proposer_address = proposer_address;
            }

            public static class VersionBean {
                /**
                 * block : 10
                 * app : 0
                 */

                private String block;
                private String app;

                public String getBlock() {
                    return block;
                }

                public void setBlock(String block) {
                    this.block = block;
                }

                public String getApp() {
                    return app;
                }

                public void setApp(String app) {
                    this.app = app;
                }
            }

            public static class LastBlockIdBean {
                /**
                 * hash : F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0
                 * parts : {"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}
                 */

                private String hash;
                private PartsBeanX parts;

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public PartsBeanX getParts() {
                    return parts;
                }

                public void setParts(PartsBeanX parts) {
                    this.parts = parts;
                }

                public static class PartsBeanX {
                    /**
                     * total : 1
                     * hash : 69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3
                     */

                    private String total;
                    private String hash;

                    public String getTotal() {
                        return total;
                    }

                    public void setTotal(String total) {
                        this.total = total;
                    }

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }
                }
            }
        }
    }

    public static class BlockBean {
        /**
         * header : {"version":{"block":"10","app":"0"},"chain_id":"coinexdex-test1","height":"373391","time":"2020-04-25T06:41:49.047493686Z","num_txs":"0","total_txs":"21","last_block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"last_commit_hash":"9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491","data_hash":"","validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","next_validators_hash":"88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E","consensus_hash":"048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F","app_hash":"36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150","last_results_hash":"","evidence_hash":"","proposer_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2"}
         * data : {"txs":null}
         * evidence : {"evidence":null}
         * last_commit : {"block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"precommits":[{"type":2,"height":"373390","round":"0","block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"timestamp":"2020-04-25T06:41:49.047493686Z","validator_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2","validator_index":"0","signature":"lLmcioecGPOr/x3viWl3ilkxHQi6y8TBSed2M28sS+ZdyE9om07F+zurFomaEB6mEJjBwhb39InBvhGnq0LaDA=="}]}
         */

        private HeaderBeanX header;
        private DataBean data;
        private EvidenceBean evidence;
        private LastCommitBean last_commit;

        public HeaderBeanX getHeader() {
            return header;
        }

        public void setHeader(HeaderBeanX header) {
            this.header = header;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public EvidenceBean getEvidence() {
            return evidence;
        }

        public void setEvidence(EvidenceBean evidence) {
            this.evidence = evidence;
        }

        public LastCommitBean getLast_commit() {
            return last_commit;
        }

        public void setLast_commit(LastCommitBean last_commit) {
            this.last_commit = last_commit;
        }

        public static class HeaderBeanX {
            /**
             * version : {"block":"10","app":"0"}
             * chain_id : coinexdex-test1
             * height : 373391
             * time : 2020-04-25T06:41:49.047493686Z
             * num_txs : 0
             * total_txs : 21
             * last_block_id : {"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}}
             * last_commit_hash : 9F7F434EE27FAC2927C54D6DDC07A5A389BABB9EDD4A321A71A59D9ADDE87491
             * data_hash :
             * validators_hash : 88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E
             * next_validators_hash : 88A6C296E8F307C07102529660992567D12DD7AD977D164FE110166545AECC2E
             * consensus_hash : 048091BC7DDC283F77BFBF91D73C44DA58C3DF8A9CBC867405D8B7F3DAADA22F
             * app_hash : 36C4D45CF1E3E5BAAFA3DEA3227BB45CE8A34B41BB0490DC8B7894C82E477150
             * last_results_hash :
             * evidence_hash :
             * proposer_address : 81360DD1EC7B5930565C59B8EDBE09CB02D785B2
             */

            private VersionBeanX version;
            private String chain_id;
            private String height;
            private String time;
            private String num_txs;
            private String total_txs;
            private LastBlockIdBeanX last_block_id;
            private String last_commit_hash;
            private String data_hash;
            private String validators_hash;
            private String next_validators_hash;
            private String consensus_hash;
            private String app_hash;
            private String last_results_hash;
            private String evidence_hash;
            private String proposer_address;

            public VersionBeanX getVersion() {
                return version;
            }

            public void setVersion(VersionBeanX version) {
                this.version = version;
            }

            public String getChain_id() {
                return chain_id;
            }

            public void setChain_id(String chain_id) {
                this.chain_id = chain_id;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getNum_txs() {
                return num_txs;
            }

            public void setNum_txs(String num_txs) {
                this.num_txs = num_txs;
            }

            public String getTotal_txs() {
                return total_txs;
            }

            public void setTotal_txs(String total_txs) {
                this.total_txs = total_txs;
            }

            public LastBlockIdBeanX getLast_block_id() {
                return last_block_id;
            }

            public void setLast_block_id(LastBlockIdBeanX last_block_id) {
                this.last_block_id = last_block_id;
            }

            public String getLast_commit_hash() {
                return last_commit_hash;
            }

            public void setLast_commit_hash(String last_commit_hash) {
                this.last_commit_hash = last_commit_hash;
            }

            public String getData_hash() {
                return data_hash;
            }

            public void setData_hash(String data_hash) {
                this.data_hash = data_hash;
            }

            public String getValidators_hash() {
                return validators_hash;
            }

            public void setValidators_hash(String validators_hash) {
                this.validators_hash = validators_hash;
            }

            public String getNext_validators_hash() {
                return next_validators_hash;
            }

            public void setNext_validators_hash(String next_validators_hash) {
                this.next_validators_hash = next_validators_hash;
            }

            public String getConsensus_hash() {
                return consensus_hash;
            }

            public void setConsensus_hash(String consensus_hash) {
                this.consensus_hash = consensus_hash;
            }

            public String getApp_hash() {
                return app_hash;
            }

            public void setApp_hash(String app_hash) {
                this.app_hash = app_hash;
            }

            public String getLast_results_hash() {
                return last_results_hash;
            }

            public void setLast_results_hash(String last_results_hash) {
                this.last_results_hash = last_results_hash;
            }

            public String getEvidence_hash() {
                return evidence_hash;
            }

            public void setEvidence_hash(String evidence_hash) {
                this.evidence_hash = evidence_hash;
            }

            public String getProposer_address() {
                return proposer_address;
            }

            public void setProposer_address(String proposer_address) {
                this.proposer_address = proposer_address;
            }

            public static class VersionBeanX {
                /**
                 * block : 10
                 * app : 0
                 */

                private String block;
                private String app;

                public String getBlock() {
                    return block;
                }

                public void setBlock(String block) {
                    this.block = block;
                }

                public String getApp() {
                    return app;
                }

                public void setApp(String app) {
                    this.app = app;
                }
            }

            public static class LastBlockIdBeanX {
                /**
                 * hash : F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0
                 * parts : {"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}
                 */

                private String hash;
                private PartsBeanXX parts;

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public PartsBeanXX getParts() {
                    return parts;
                }

                public void setParts(PartsBeanXX parts) {
                    this.parts = parts;
                }

                public static class PartsBeanXX {
                    /**
                     * total : 1
                     * hash : 69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3
                     */

                    private String total;
                    private String hash;

                    public String getTotal() {
                        return total;
                    }

                    public void setTotal(String total) {
                        this.total = total;
                    }

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }
                }
            }
        }

        public static class DataBean {
            /**
             * txs : null
             */

            private Object txs;

            public Object getTxs() {
                return txs;
            }

            public void setTxs(Object txs) {
                this.txs = txs;
            }
        }

        public static class EvidenceBean {
            /**
             * evidence : null
             */

            private Object evidence;

            public Object getEvidence() {
                return evidence;
            }

            public void setEvidence(Object evidence) {
                this.evidence = evidence;
            }
        }

        public static class LastCommitBean {
            /**
             * block_id : {"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}}
             * precommits : [{"type":2,"height":"373390","round":"0","block_id":{"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}},"timestamp":"2020-04-25T06:41:49.047493686Z","validator_address":"81360DD1EC7B5930565C59B8EDBE09CB02D785B2","validator_index":"0","signature":"lLmcioecGPOr/x3viWl3ilkxHQi6y8TBSed2M28sS+ZdyE9om07F+zurFomaEB6mEJjBwhb39InBvhGnq0LaDA=="}]
             */

            private BlockIdBeanX block_id;
            private List<PrecommitsBean> precommits;

            public BlockIdBeanX getBlock_id() {
                return block_id;
            }

            public void setBlock_id(BlockIdBeanX block_id) {
                this.block_id = block_id;
            }

            public List<PrecommitsBean> getPrecommits() {
                return precommits;
            }

            public void setPrecommits(List<PrecommitsBean> precommits) {
                this.precommits = precommits;
            }

            public static class BlockIdBeanX {
                /**
                 * hash : F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0
                 * parts : {"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}
                 */

                private String hash;
                private PartsBeanXXX parts;

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public PartsBeanXXX getParts() {
                    return parts;
                }

                public void setParts(PartsBeanXXX parts) {
                    this.parts = parts;
                }

                public static class PartsBeanXXX {
                    /**
                     * total : 1
                     * hash : 69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3
                     */

                    private String total;
                    private String hash;

                    public String getTotal() {
                        return total;
                    }

                    public void setTotal(String total) {
                        this.total = total;
                    }

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }
                }
            }

            public static class PrecommitsBean {
                /**
                 * type : 2
                 * height : 373390
                 * round : 0
                 * block_id : {"hash":"F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0","parts":{"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}}
                 * timestamp : 2020-04-25T06:41:49.047493686Z
                 * validator_address : 81360DD1EC7B5930565C59B8EDBE09CB02D785B2
                 * validator_index : 0
                 * signature : lLmcioecGPOr/x3viWl3ilkxHQi6y8TBSed2M28sS+ZdyE9om07F+zurFomaEB6mEJjBwhb39InBvhGnq0LaDA==
                 */

                private int type;
                private String height;
                private String round;
                private BlockIdBeanXX block_id;
                private String timestamp;
                private String validator_address;
                private String validator_index;
                private String signature;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getRound() {
                    return round;
                }

                public void setRound(String round) {
                    this.round = round;
                }

                public BlockIdBeanXX getBlock_id() {
                    return block_id;
                }

                public void setBlock_id(BlockIdBeanXX block_id) {
                    this.block_id = block_id;
                }

                public String getTimestamp() {
                    return timestamp;
                }

                public void setTimestamp(String timestamp) {
                    this.timestamp = timestamp;
                }

                public String getValidator_address() {
                    return validator_address;
                }

                public void setValidator_address(String validator_address) {
                    this.validator_address = validator_address;
                }

                public String getValidator_index() {
                    return validator_index;
                }

                public void setValidator_index(String validator_index) {
                    this.validator_index = validator_index;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public static class BlockIdBeanXX {
                    /**
                     * hash : F68EE28F0282F0D944B09E6F4F0F15EB18A4B60CAF0760BC9B54FFAC1E3E7AB0
                     * parts : {"total":"1","hash":"69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3"}
                     */

                    private String hash;
                    private PartsBeanXXXX parts;

                    public String getHash() {
                        return hash;
                    }

                    public void setHash(String hash) {
                        this.hash = hash;
                    }

                    public PartsBeanXXXX getParts() {
                        return parts;
                    }

                    public void setParts(PartsBeanXXXX parts) {
                        this.parts = parts;
                    }

                    public static class PartsBeanXXXX {
                        /**
                         * total : 1
                         * hash : 69775D197DB6256A77C9354107765E17AB9E5F08C087E4E09CD397113C6D99C3
                         */

                        private String total;
                        private String hash;

                        public String getTotal() {
                            return total;
                        }

                        public void setTotal(String total) {
                            this.total = total;
                        }

                        public String getHash() {
                            return hash;
                        }

                        public void setHash(String hash) {
                            this.hash = hash;
                        }
                    }
                }
            }
        }
    }
}
