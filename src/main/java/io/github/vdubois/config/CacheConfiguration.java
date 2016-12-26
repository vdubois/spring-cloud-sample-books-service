package io.github.vdubois.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vdubois on 14/12/16.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @ConditionalOnProperty(value = "hazelcast.enabled", havingValue = "true")
    @Bean
    CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }

    @ConditionalOnProperty(value = "hazelcast.enabled", havingValue = "true")
    @Bean
    HazelcastInstance hazelcastInstance() {
        return HazelcastClient.newHazelcastClient();
    }
}
