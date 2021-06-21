package h10005821.Topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = Arrays.asList(new Topic("one", "java", "javabrains"),
			new Topic("two", "mysql", "javabrains"), new Topic("three", "nodejs", "javabrains"));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
}
