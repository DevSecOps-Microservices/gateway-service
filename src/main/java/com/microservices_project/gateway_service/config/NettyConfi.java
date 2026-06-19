package com.microservices_project.gateway_service.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfi {

    @Bean
    public WebServerFactoryCustomizer<NettyReactiveWebServerFactory> nettyCustomizer() {
        return factory -> factory.addServerCustomizers(
                httpServer -> httpServer.httpRequestDecoder(
                        spec -> spec.maxInitialLineLength(65536)
                                .maxHeaderSize(65536)
                                .maxChunkSize(52428800) // 50MB chunks
                )
        );
    }
}
