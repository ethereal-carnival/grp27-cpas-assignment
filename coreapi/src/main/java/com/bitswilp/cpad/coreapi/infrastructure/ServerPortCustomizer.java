package com.bitswilp.cpad.coreapi.infrastructure;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.CORE_API_PORT;

@Component
public class ServerPortCustomizer
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(CORE_API_PORT);
    }
}