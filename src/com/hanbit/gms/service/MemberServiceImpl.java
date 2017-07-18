package com.hanbit.gms.service;

import java.util.ArrayList;
import java.util.List;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	//public static MemberServiceImpl instance = new MemberServiceImpl();	
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl(){}
	
	@Override
	public String addMember(MemberBean member) {
		int rs = MemberDAOImpl.getInstance().insert(member);
		String msg = (rs==1)?"insert 성공":"insert 실패";
		
		return msg;
	}

	@Override
	public List<MemberBean> getMembers() {
		return MemberDAOImpl.getInstance().selectAll();
	}

	@Override
	public int countMembers() {
		return MemberDAOImpl.getInstance().count();
	}

	@Override
	public MemberBean findByID(String id) {
		MemberBean member = new MemberBean();
		member = MemberDAOImpl.getInstance().selectByID(id);
		
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modifyPw(MemberBean bean) {

		String msg="";
		MemberBean member = new MemberBean();
		int rs = MemberDAOImpl.getInstance().update(bean);
		msg = (rs==1)?"update 성공":"update 실패";
		
		return msg;
	}

	@Override
	public String removeMember(String id) {
		String msg="";
		int rs = MemberDAOImpl.getInstance().delete(id);
		msg = (rs==1)?"delete 성공":"delete 실패";
		
		return msg;
	}
}
