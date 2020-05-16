package io.diamondnetwork.explorer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 *  https://spring.io/guides/gs/messaging-stomp-websocket/
 * Created by linmingren on 2017/8/30.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.enableSimpleBroker("/ws/market/candles","/ws/market/time-series",
                "/ws/market/candle_stick","/ws/market/stats-list","/market/stats",
                "/ws/market/open-trade-list","/ws/market/trade-log-list","/ws/market/stats");
        //handle the message send from client
        config.setApplicationDestinationPrefixes("/ws/market");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //use sockjs if client doesn't support websocket
        //setAllowedOrigins is required to avoid 403 error
        registry.addEndpoint("/ws/market").setAllowedOrigins( "*" ).withSockJS();
        //handshake is required otherwise stomp client cannot establish connection
        registry.addEndpoint("/ws/market")
                .setHandshakeHandler(new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy()))
                .setAllowedOrigins("*");
    }
}
