package happy.rabitmq.recv;

import com.rabbitmq.client.*;
import happy.rabitmq.ConnectionUtil;

import java.io.IOException;

public class Recv {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
	    DefaultConsumer consumer = new DefaultConsumer(channel);

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
	        boolean autoAck = false;
	        channel.basicConsume(QUEUE_NAME, autoAck, "test",
			        new DefaultConsumer(channel) {
				        @Override
				        public void handleDelivery(String consumerTag,
				                                   Envelope envelope,
				                                   AMQP.BasicProperties properties,
				                                   byte[] body)
						        throws IOException
				        {
					        String routingKey = envelope.getRoutingKey();
					        String contentType = properties.getContentType();
					        long deliveryTag = envelope.getDeliveryTag();
					        // (process the message components here ...)
					        channel.basicAck(deliveryTag, false);
					        System.out.println(new String(body));
				        }
			        });
        }

    }
}
