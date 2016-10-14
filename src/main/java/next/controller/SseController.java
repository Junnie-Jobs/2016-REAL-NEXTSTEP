package next.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import next.dao.DiscussionRepository;
import next.dao.ReplyRepository;
import next.model.Discussion;
import next.model.Reply;

@RestController
public class SseController {

	private final List<SseEmitter> emitters = new ArrayList<>();
	
	@Autowired
	private DiscussionRepository discussionRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	@RequestMapping(path = "/stream", method = RequestMethod.GET)
	public SseEmitter stream() throws IOException {
		
		SseEmitter emitter = new SseEmitter();
		emitters.add(emitter);
		emitter.onCompletion(() -> emitters.remove(emitter));
		return emitter;
	}

	@RequestMapping(path = "/chat", method = RequestMethod.POST)
	public Discussion sendMessage(@RequestParam String message) {
		
		Discussion discussion = new Discussion(message);		
		discussionRepository.save(discussion);

		emitters.forEach((SseEmitter emitter) -> {
			try {
				emitter.send(discussion, MediaType.APPLICATION_JSON);
			} catch (IOException e) {
				emitter.complete();
				emitters.remove(emitter);
				e.printStackTrace();
			}
		});
		return discussion;
	}
	
	@RequestMapping(path = "/reply", method = RequestMethod.POST)
	public Reply sendReply(@RequestParam Long id, @RequestParam String content) {
		
		Discussion discussion = discussionRepository.findOne(id);
		Reply reply = new Reply(content, discussion);
		replyRepository.save(reply);
		
		emitters.forEach((SseEmitter emitter) -> {
			try {
				
				emitter.send(SseEmitter.event().name("replyEvent").data(reply));				
//				emitter.send(reply, MediaType.APPLICATION_JSON);

			} catch (IOException e) {
				emitter.complete();
				emitters.remove(emitter);
				e.printStackTrace();
			}
		});
		return reply;
	}
}
