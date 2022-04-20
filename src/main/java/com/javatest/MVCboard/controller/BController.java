package com.javatest.MVCboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatest.MVCboard.command.BCommand;
import com.javatest.MVCboard.command.BListCommand;

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
		public String content_view() {
			
			return "content_view";
		} 
		
		@RequestMapping(value="/reply_view") // ���� ���� ȭ��
		public String reply_view() {
			
			return "reply_view";
		} 
		
		@RequestMapping(value="/write") // �۾��� ���
		public String write() {
			
			return "redirect:list"; // �۾��� �� list�� ����
		} 
		
		@RequestMapping(value="/modify") // �ۼ��� ���
		public String modify() {
			
			return "redirect:list"; // �ۼ��� �� list�� ����
		}
		
		@RequestMapping(value="/delete") // �ۻ��� ���
		public String delete() {
			
			return "redirect:list"; // �ۻ��� �� list�� ����
		}
		
		@RequestMapping(value="/reply") // ���۾��� ���
		public String reply() {
			
			return "redirect:list"; // ���� �ۼ� �� list�� ����
		}
}
