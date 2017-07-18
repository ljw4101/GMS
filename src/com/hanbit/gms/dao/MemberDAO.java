package com.hanbit.gms.dao;

import java.util.List;
import com.hanbit.gms.domain.MemberBean;

public interface MemberDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public String insert(MemberBean member);
	public String update(MemberBean member);	//pw
	public String delete(String id);			//id
	//getter
	public List<MemberBean> selectAll();
	public String count();
	public MemberBean selectByID(String id);
	public List<MemberBean> selectByName(String name);
}
