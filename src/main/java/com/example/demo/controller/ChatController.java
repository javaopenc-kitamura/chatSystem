package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ChatDao;
import com.example.demo.entity.EntForm;

@Controller
public class ChatController {

	//@RequestMapping("/room")
	//public String room(Model model) {//Controllerからviewに渡すためのオブジェクト
	//model.addAttribute("title", "チャットルーム");
	//return "form/chat";
	//}

	@RequestMapping("/first") //1番最初に表示される画面
	public String first(Model model) {
		model.addAttribute("title", "チャットルーム");
		return "form/index";
	}

	@RequestMapping("/start") //チャットルームへのページの移動
	public String start(Model model) {
		model.addAttribute("title", "チャットルームを始めよう");
		return "form/view";
	}

	private final ChatDao chatdao;
	public ChatController(ChatDao chatdao) {
		this.chatdao = chatdao;
	}

	@RequestMapping("/complete")
	public String complete(Chat chat, Model model) {
		model.addAttribute("title", "チャットルームを始めよう");
		EntForm entform = new EntForm();
		entform.setName(chat.getName());
		entform.setComment(chat.getComment());
		
		chatdao.insertDb(entform);
		System.out.println(chat.getName());
		return "form/view";
	}
}