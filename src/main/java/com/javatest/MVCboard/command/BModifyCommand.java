package com.javatest.MVCboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javatest.MVCboard.dao.BDao;
import com.javatest.MVCboard.dto.BDto;

public class BModifyCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap(); // model 안의 객체를 뽑아 쓰는 방법
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String BId = request.getParameter("bid");
		String bName = request.getParameter("bname");
		String bTitle = request.getParameter("btitle");
		String bContent = request.getParameter("bcontent");
		
		BDao dao = new BDao();
		
		dao.modify(BId,bName,bTitle,bContent);
	}

}
