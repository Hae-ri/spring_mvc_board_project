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
		
		@RequestMapping(value="/write_view") // �۾��� ȭ��
		public String write_view() {
			
			return "write_view";
		} 
		
		@RequestMapping(value="/content_view") // �۳��� ����
		public String content_view(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BContentCommand();
			command.excute(model);
			
			return "content_view";
		} 
		
		@RequestMapping(value="/reply_view") // ���� ���� ȭ��
		public String reply_view() {
			
			return "reply_view";
		} 
		
		@RequestMapping(value="/write") // �۾��� ���
		public String write(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BWriteCommand();
			command.excute(model);
			
			return "redirect:list"; // �۾��� �� list�� ����/@RequestMapping(value="/list")
		} 
		
		@RequestMapping(value="/modify", method=RequestMethod.POST) // �ۼ��� ���
		public String modify(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BModifyCommand();
			command.excute(model);
			
			return "redirect:list"; // �ۼ��� �� list�� ����/@RequestMapping(value="/list")
		}
		
		@RequestMapping(value="/delete") // �ۻ��� ���
		public String delete(HttpServletRequest request, Model model) {
			
			model.addAttribute("request", request);
			
			command = new BDeleteCommand();
			command.excute(model);
			
			return "redirect:list"; // �ۻ��� �� list�� ����/@RequestMapping(value="/list")
		}
		
		@RequestMapping(value="/reply") // ���۾��� ���
		public String reply() {
			
			return "redirect:list"; // ���� �ۼ� �� list�� ����/@RequestMapping(value="/list")
		}
}
