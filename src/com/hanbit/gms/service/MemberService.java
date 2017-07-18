package com.hanbit.gms.service;

import java.util.List;
import com.hanbit.gms.domain.MemberBean;

public interface MemberService {
	//setter void-> String : 사용자에게 결과후 성공여부 message 반환
	public String addMember(MemberBean member);
	public String modifyPw(MemberBean member);
	public String removeMember(String id);
	//getter
	public List<MemberBean> getMembers();	//목록: MemberBean을 배열로 담음
	public int countMembers();
	public MemberBean findByID(String id);
	public List<MemberBean> findByName(String name);
}
