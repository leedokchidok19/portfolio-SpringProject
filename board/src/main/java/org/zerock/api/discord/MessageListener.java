package org.zerock.api.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter
{
	public static void main(String[] args)throws LoginException
    {
		String bot_token = null;
        JDA jda = JDABuilder.createDefault(bot_token).build();
        jda.addEventListener(new MessageListener());
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {	//봇일 경우 실행을 안 한다.
    	if (event.getAuthor().isBot()) return;
    	
		if (event.getMessage().getContentRaw().startsWith("!ping"))
		{
		 System.out.println("event :"+event.getMessage().getContentRaw());
		 event.getChannel().sendMessage("pong!").queue();
		}
		
    	if (event.getMessage().getContentRaw().equals("!ping"))
    	{	//"!ping"과 정확히 일치할 때 실행한다.
    		System.out.println("event2 :"+event.getMessage().getContentRaw());
    		event.getChannel().sendMessage("pong!").queue();
    	}
		/*
		 * if (event.isFromType(ChannelType.TEXT)) {
		 * System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
		 * event.getChannel().getName(), event.getAuthor(),
		 * event.getMessage().getContentDisplay()); System.out.printf("[채널 : %s]",
		 * event.getChannel()); } else { System.out.printf("[PM] %#s: %s%n",
		 * event.getAuthor(), event.getMessage().getContentDisplay()); }
		 */
    }
}
