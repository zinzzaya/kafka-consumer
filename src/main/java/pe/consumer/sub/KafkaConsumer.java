package pe.consumer.sub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import pe.consumer.sub.dto.MessageDTO;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

  @KafkaListener(topics = "${kafka.test.topic.name}",
      groupId = "${kafka.test.topic.group.id}",
      containerFactory = "testListenerContainerFactory")
  public void consumer(MessageDTO messageDto, Acknowledgment ack) {

    //메세지 수신 후 비즈니스 로직 처리
    log.info("[consumer rev] 메세지 수신완료 -> {}, {}" + messageDto.getTitle(), messageDto.getContents());
    ack.acknowledge();
  }
}
