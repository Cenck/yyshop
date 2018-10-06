import com.cengel.yyshop.AppApplication;
import com.cengel.yyshop.mqsource.HelloMqSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 12:10
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppApplication.class)
@DirtiesContext
public class MqTest {

	@Autowired
	private HelloMqSource pipe;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void whenSendMessage_thenResponseIsInAOutput() {
		pipe.HelloInChannel().send(MessageBuilder.withPayload("test你妈比").build());
		String string = (String) Objects.requireNonNull(messageCollector.forChannel(pipe.helloOutChannel()).poll()).getPayload();
		System.out.println(string);
	}



}
