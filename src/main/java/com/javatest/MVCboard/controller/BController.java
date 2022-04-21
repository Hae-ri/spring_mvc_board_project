package com.javatest.MVCboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatest.MVCboard.command.*;

@Controller
public class BController {
	
		BCommand command = null;
	
		@RequestMapping(value="/list")
		public String list(Model model) {
			
			command = new BListCommand();
			command.excute(model);
			
			return "list";
		} 
		
		@RequestMapping(value="/write_view") // 글쓰기 화면
		public String write_view() {
			
			return "write_view";
		} 
		
		@RequestMapping(value="/content_view") // 글내용 보기
		public String content_view(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BContentCommand();
			command.excute(model);
			
			return "content_view";
		} 
		
		@RequestMapping(value="/reply_view") // 덧글 쓰기 화면
		public String reply_view() {
			
			return "reply_view";
		} 
		
		@RequestMapping(value="/write") // 글쓰기 기능
		public String write(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BWriteCommand();
			command.excute(model);
			
			return "redirect:list"; // 글쓰기 후 list로 보냄/@RequestMapping(value="/list")
		} 
		
		@RequestMapping(value="/modify", method=RequestMethod.POST) // 글수정 기능
		public String modify(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BModifyCommand();
			command.excute(model);
			
			return "redirect:list"; // 글수정 후 list로 보냄/@RequestMapping(value="/list")
		}
		
		@RequestMapping(value="/delete") // 글삭제 기능
		public String delete(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BDeleteCommand();
			command.excute(model);
			
			return "redirect:list"; // 글삭제 후 list로 보냄/@RequestMapping(value="/list")
		}
		
		@RequestMapping(value="/reply") // 덧글쓰기 기능
		public String reply() {
			
			return "redirect:list"; // 덧글 작성 후 list로 보냄/@RequestMapping(value="/list")
		}
}
