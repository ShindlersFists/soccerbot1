package soccer.soccerbot1;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter
{
    public static void main( String[] args ) throws Exception
    {
      JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
      jda.addEventListener(new App());
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent evt)
    {
    	//obj
    	User objUser = evt.getAuthor();
    	MessageChannel objMsgCh= evt.getChannel();
    	Message objMsg = evt.getMessage();
    	
    	//commands
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping"))
    	{
    		objMsgCh.sendMessage(objUser.getAsMention() + " Pong!").queue();
    	}
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"shmoke?"))
    	{
    		double rand = Math.random();
    		if(rand > 0.8) {
    			objMsgCh.sendMessage(objUser.getAsMention() + " Take a rip!").queue();
    		}
    		else if(rand > 0.5) {
    			objMsgCh.sendMessage(" Go for it!").queue();
    		}
    		else if(rand > 0.1) {
    			objMsgCh.sendMessage(objUser.getAsMention() + " I'll allow it.").queue();
    		}
    		else {
    			objMsgCh.sendMessage(" No. Very Unlucky. Try againg later.").queue();
    		}
    		
    	}
    }
}
