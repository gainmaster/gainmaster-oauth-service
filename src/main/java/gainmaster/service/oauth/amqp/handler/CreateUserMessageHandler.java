package gainmaster.service.oauth.amqp.handler;

/**
 * Created by lorre on 4/14/15.
 */
public class CreateUserMessageHandler {

    public String handleMessage(String message){
        //TODO: Process messages
        System.out.println("RABBITMQ: Received " + message);
        String reply = "gainmaster-oauth-service: Creating information about user " + message;
        System.out.println("RABBITMQ: Sending reply " + reply);
        return reply;
    }
}
