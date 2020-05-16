package io.diamondnetwork.explorer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfig {
    @Autowired
    RedisConnectionFactory jedisConnectionFactory;

    /**
     * @return RedisCacheTransfer
     */
    @Bean
    public RedisCacheTransfer redisCacheTransfer() {
        return new RedisCacheTransfer(jedisConnectionFactory);
    }

    class RedisCacheTransfer {

        public RedisCacheTransfer(RedisConnectionFactory jedisConnectionFactory) {
           // MybatisRedisCache.setJedisConnectionFactory(jedisConnectionFactory);
        }
    }
}
