package de.adesso.wickedcharts.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.stereotype.Component;

@Component
public class ExampleApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return Homepage.class;
	}

	@Override
	public void init() {
		super.init();
		mountPage("/chart", Homepage.class);
	}
}
