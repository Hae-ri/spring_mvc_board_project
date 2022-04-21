package com.javatest.MVCboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javatest.MVCboard.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap(); // model 안의 객체를 뽑아 쓰는 방법
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bid");
		String bName = request.getParameter("bname");
		String bTitle = request.getParameter("btitle");
		String bContent = request.getParameter("bcontent");
		String bGroup = request.getParameter("bgroup");
		String bStep = request.getParameter("bstep");
		String bIndent = request.getParameter("bindent");
				
		BDao dao = new BDao();
		
		dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);		
	}

}
