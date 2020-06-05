package io.diamondnetwork.task.response;

import io.diamondnetwork.task.response.message.TxMessage;

import java.util.List;

public class TxsResponse {

    /**
     * total_count : 8
     * count : 8
     * page_number : 1
     * page_total : 1
     * limit : 10
     * txs : [{"height":"33731","txhash":"273DDC6767838CEDC536FA11DA6EF06701E4E4D5799AF4C02D07B20ED2E0A96C","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3\"},{\"key\":\"amount\",\"value\":\"900000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"1000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"budvDotQ3ZHE2LoX/HiPVWYbI3pVE/oUep9LJVOuLzoHf+VOsU9AtXyjl73W4ejSS6v2yupVM7N82LmjUuo2qQ=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-17T08:54:13Z","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"33838","txhash":"A20E330357B78CABAE07B3C99883B099AECDC88FA0ECA7DF12D1145140628E5B","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3\"},{\"key\":\"amount\",\"value\":\"10000000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"10000000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24600","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"10000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Pzt3nWvETjQenMN1p+73gUuU+W8sdD7qwiwqN2bxyKJE9vcb1bY9eNDVbI32T7JWDX4MpWlcPKpq9rvzSo5aNw=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-17T08:57:49Z","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"10000000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"33904","txhash":"386529F9D8105E5C74E4D8E9B8AE5A8CB61ECBA6AE18C839F94A6657CACB01D2","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3\"},{\"key\":\"amount\",\"value\":\"5000000000vfc\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"5000000000vfc"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"vfc","amount":"5000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"XKwfbtatlvdXWSztJUuc9Rz5fApFTlza8onNJVeWg+0N9MaObth5aUb1RWyqNhB/6eIO/xcNyllYIY8dtLKJMg=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-17T09:00:01Z","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"5000000000vfc"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"130151","txhash":"D9B62893E694242ED40F1C277A7FA7F2558D624B6FF9F482A19E5D235284F574","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex1yxvguun9jcgyjsuy6250t6959cz4n62704h65r\"},{\"key\":\"amount\",\"value\":\"4900000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1yxvguun9jcgyjsuy6250t6959cz4n62704h65r"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1yxvguun9jcgyjsuy6250t6959cz4n62704h65r","amount":[{"denom":"cet","amount":"5000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"zCjSSVI61jr/pSmgyL1XvUlzgqOol3h0css6jJNXcWEXVXELT2z8jpQWaSBp590oPfo87NiMPzCVOF9idreJUw=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-19T14:46:57Z","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1yxvguun9jcgyjsuy6250t6959cz4n62704h65r"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"160910","txhash":"AF5F0499C84E4052350CDF3F60245EB68278E2CBFBF2F78FD7CE3A590789BFA3","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex1vk7l6lkm0t8xsxr3uwmnwg97nhy0rzlx3gd63z\"},{\"key\":\"amount\",\"value\":\"9900000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1vk7l6lkm0t8xsxr3uwmnwg97nhy0rzlx3gd63z"},{"key":"amount","value":"9900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24600","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1vk7l6lkm0t8xsxr3uwmnwg97nhy0rzlx3gd63z","amount":[{"denom":"cet","amount":"10000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"MPa2PWhnnoxjPzwMvT1nMeyqi8lQNUsME4xMikGuHtt73eGSIvExNH1E9EaIw3aMBzwZsaqxQY8RBBehgPN5Ig=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-20T07:58:26Z","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1vk7l6lkm0t8xsxr3uwmnwg97nhy0rzlx3gd63z"},{"key":"amount","value":"9900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"205011","txhash":"A38A80810315A6282714063E57F395B647B092E002361C995F0A265A46E4D56C","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg\"},{\"key\":\"amount\",\"value\":\"4900000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg","amount":[{"denom":"cet","amount":"5000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"OsDvWt+zsGnRy5Q3PgrRPgyRDNd3wZkvloOHnOjA/Jwyjot8eCqdC6Mm7t9A6zeG7mRnGMcx7vC2MC8GNaknZw=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-21T08:36:50Z","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"242590","txhash":"DFB2E6F622E980B498113F9A8F7C2E2C894A4257B995A33853185B1674B9A328","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg\"},{\"key\":\"amount\",\"value\":\"5000000000cet\"},{\"key\":\"sender\",\"value\":\"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"amount","value":"5000000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg","amount":[{"denom":"cet","amount":"5000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"Krvofb0N2D/wpKID4FVCBSKg0Rc/5lbrqK+S4sgT3hxN97AA62Awp83Aj6HV8VLJw72Ax8TidWk922r+tEEXQg=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-22T05:36:52Z","events":[{"type":"message","attributes":[{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"amount","value":"5000000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]},{"height":"242700","txhash":"D8FEE137CBA8C2766F4F92CF97FED0623F026628507B3DB5607064BCDC32FBB9","raw_log":"[{\"msg_index\":0,\"success\":true,\"log\":\"\",\"events\":[{\"type\":\"message\",\"attributes\":[{\"key\":\"sender\",\"value\":\"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg\"},{\"key\":\"module\",\"value\":\"bankx\"},{\"key\":\"sender\",\"value\":\"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg\"},{\"key\":\"action\",\"value\":\"send\"}]},{\"type\":\"transfer\",\"attributes\":[{\"key\":\"recipient\",\"value\":\"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl\"},{\"key\":\"amount\",\"value\":\"100000000cet\"},{\"key\":\"recipient\",\"value\":\"coinex17krfvmfyt0wxsl5vshsz0d6xs6ffvcu2742cy8\"},{\"key\":\"amount\",\"value\":\"4900000000cet\"},{\"key\":\"sender\",\"value\":\"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg\"}]}]}]","logs":[{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex17krfvmfyt0wxsl5vshsz0d6xs6ffvcu2742cy8"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"}]}]}],"gas_wanted":"100000","gas_used":"24580","tx":{"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg","to_address":"coinex17krfvmfyt0wxsl5vshsz0d6xs6ffvcu2742cy8","amount":[{"denom":"cet","amount":"5000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A+IKEAE3iPiub7HUpbpq35iKW48Bguw39g4Z/DcFggEY"},"signature":"dtS8oGYhn8+/xX7U9gnx06ygUnTxdpKjjtnl38azkAst7pvpxa10SNBAy1eh97/CMLfS/ir9WpLD3rLNKseokQ=="}],"memo":"Sent with example memo"}},"timestamp":"2020-04-22T05:40:33Z","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex17krfvmfyt0wxsl5vshsz0d6xs6ffvcu2742cy8"},{"key":"amount","value":"4900000000cet"},{"key":"sender","value":"coinex14xttnpva6mkw4z3gcxx5fznw53ytdgvulhhzeg"}]}]}]
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
         * height : 33731
         * txhash : 273DDC6767838CEDC536FA11DA6EF06701E4E4D5799AF4C02D07B20ED2E0A96C
         * raw_log : [{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}]
         * logs : [{"msg_index":0,"success":true,"log":"","events":[{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]}]
         * gas_wanted : 100000
         * gas_used : 24580
         * tx : {"type":"cosmos-sdk/StdTx","value":{"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"1000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"budvDotQ3ZHE2LoX/HiPVWYbI3pVE/oUep9LJVOuLzoHf+VOsU9AtXyjl73W4ejSS6v2yupVM7N82LmjUuo2qQ=="}],"memo":"Sent with example memo"}}
         * timestamp : 2020-04-17T08:54:13Z
         * events : [{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]
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
             * value : {"msg":[{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"1000000000"}],"unlock_time":"0"}}],"fee":{"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"},"signatures":[{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"budvDotQ3ZHE2LoX/HiPVWYbI3pVE/oUep9LJVOuLzoHf+VOsU9AtXyjl73W4ejSS6v2yupVM7N82LmjUuo2qQ=="}],"memo":"Sent with example memo"}
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
                 * msg : [{"type":"bankx/MsgSend","value":{"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"1000000000"}],"unlock_time":"0"}}]
                 * fee : {"amount":[{"denom":"cet","amount":"2000000"}],"gas":"100000"}
                 * signatures : [{"pub_key":{"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"},"signature":"budvDotQ3ZHE2LoX/HiPVWYbI3pVE/oUep9LJVOuLzoHf+VOsU9AtXyjl73W4ejSS6v2yupVM7N82LmjUuo2qQ=="}]
                 * memo : Sent with example memo
                 */

                private FeeBean fee;
                private String memo;
                private List<TxMessage> msg;
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

                public List<TxMessage> getMsg() {
                    return msg;
                }

                public void setMsg(List<TxMessage> msg) {
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
                     * type : bankx/MsgSend
                     * value : {"from_address":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7","to_address":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3","amount":[{"denom":"cet","amount":"1000000000"}],"unlock_time":"0"}
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
                         * from_address : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
                         * to_address : coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3
                         * amount : [{"denom":"cet","amount":"1000000000"}]
                         * unlock_time : 0
                         */

                        private String from_address;
                        private String to_address;
                        private String unlock_time;
                        private List<AmountBeanX> amount;

                        public String getFrom_address() {
                            return from_address;
                        }

                        public void setFrom_address(String from_address) {
                            this.from_address = from_address;
                        }

                        public String getTo_address() {
                            return to_address;
                        }

                        public void setTo_address(String to_address) {
                            this.to_address = to_address;
                        }

                        public String getUnlock_time() {
                            return unlock_time;
                        }

                        public void setUnlock_time(String unlock_time) {
                            this.unlock_time = unlock_time;
                        }

                        public List<AmountBeanX> getAmount() {
                            return amount;
                        }

                        public void setAmount(List<AmountBeanX> amount) {
                            this.amount = amount;
                        }

                        public static class AmountBeanX {
                            /**
                             * denom : cet
                             * amount : 1000000000
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

                public static class SignaturesBean {
                    /**
                     * pub_key : {"type":"tendermint/PubKeySecp256k1","value":"A2aMWR1KJ7uK68gH4d4aJos8A3IK2y85AoNMj+7cny5N"}
                     * signature : budvDotQ3ZHE2LoX/HiPVWYbI3pVE/oUep9LJVOuLzoHf+VOsU9AtXyjl73W4ejSS6v2yupVM7N82LmjUuo2qQ==
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
             * events : [{"type":"message","attributes":[{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]},{"type":"transfer","attributes":[{"key":"recipient","value":"coinex17xpfvakm2amg962yls6f84z3kell8c5lm7j9tl"},{"key":"amount","value":"100000000cet"},{"key":"recipient","value":"coinex1t9z04y5v9uks7yf49mygsuasetdt69cth7qle3"},{"key":"amount","value":"900000000cet"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"}]}]
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
                 * type : message
                 * attributes : [{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]
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
                     * key : sender
                     * value : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
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
             * type : message
             * attributes : [{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"module","value":"bankx"},{"key":"sender","value":"coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7"},{"key":"action","value":"send"}]
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
                 * key : sender
                 * value : coinex1u096km7ce7pct7wqw6q5p7haf2m32ndm43vwg7
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
