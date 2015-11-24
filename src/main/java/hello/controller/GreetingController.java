package hello.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import hello.vo.Greeting;
import hello.vo.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
	Thread.sleep(3000); // simulated delay
	return new Greeting("Hello, " + message.getName() + "!");
    }

}