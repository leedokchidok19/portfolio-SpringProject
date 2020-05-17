package org.zerock.api.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class DiscordBot implements EventListener{

	public static void main(String[] args)
			throws LoginException, InterruptedException
	{
		String bot_token = null;
		// Note: It is important to register your ReadyListener before building
		JDA jda = new JDABuilder(bot_token)
					.addEventListeners(new DiscordBot())
					.build();

		// optionally block until JDA is ready
		jda.awaitReady();
	}

	@Override
	public void onEvent(GenericEvent event)
	{
		if (event instanceof ReadyEvent)
			System.out.println("API is ready!");
	}
}
