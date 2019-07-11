/**
 * 
 */
package com.csf.whoami.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.server.i18n.LocaleContextResolver;

/**
 * @author TuanDQ
 *
 */
@Configuration
public class LocaleSupportConfig extends DelegatingWebFluxConfiguration {

	@Override
	protected LocaleContextResolver createLocaleContextResolver() {
		return new RequestParamLocaleContextResolver();
	}
}
