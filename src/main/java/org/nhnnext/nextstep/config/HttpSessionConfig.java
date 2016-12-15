package org.nhnnext.nextstep.config;

@Configuration
@EnableRedisHttpSession 
public class HttpSessionConfig {

        @Bean
        public JedisConnectionFactory connectionFactory() {
                return new JedisConnectionFactory(); 
        }

        @Bean
        public HttpSessionStrategy httpSessionStrategy() {
                return new HeaderHttpSessionStrategy(); 
        }
}