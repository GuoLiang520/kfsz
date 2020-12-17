package com.gl.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * @author 郭亮
 * @date 2020/11/13 10:11 
 **/
@Configuration
public class EhcacheConfig {

    /*@Bean
    public CacheManager ehcacheManager() throws IOException {
        CachingProvider cachingProvider = Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        URI uri = resolver.getResource("ehcache1.xml").getURI();
        CacheManager cacheManager = cachingProvider.getCacheManager(uri, getClass().getClassLoader());
        return cacheManager;
    }

    @Bean
    public org.springframework.cache.CacheManager ehcacheJcache(CacheManager ehcacheManager){
        return new JCacheCacheManager(ehcacheManager);
    }*/

    @Bean
    public EhCacheCacheManager ehcacheJcache(){

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(resolver.getResource("ehcache1.xml"));
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }
}
