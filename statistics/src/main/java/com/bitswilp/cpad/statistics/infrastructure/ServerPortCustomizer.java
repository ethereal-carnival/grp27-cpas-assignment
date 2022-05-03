package com.bitswilp.cpad.statistics.infrastructure;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.STATISTICS_PORT;

@Component
public class ServerPortCustomizer
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(STATISTICS_PORT);
    }
}