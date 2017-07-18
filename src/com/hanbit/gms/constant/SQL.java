package com.hanbit.gms.constant;

public class SQL {
	public static final String MEMBER_INSERT = String.format("insert into %s(%s, %s, %s, %s, %s)values(?, ?, ?, ?, SYSDATE)", DB.TABLE_MEMBER, DB.MEM_ID, DB.MEM_NAME, DB.MEM_PW, DB.MEM_SSN, DB.MEM_REGDATE);
	public static final String MEMBER_UPDATE = String.format("update %s set %s=?, %s=?, %s=?, %s=SYSDATE where %s = ?", DB.TABLE_MEMBER, DB.MEM_NAME, DB.MEM_PW, DB.MEM_SSN, DB.MEM_REGDATE, DB.MEM_ID);
	public static final String MEMBER_DELETE = String.format("delete from %s where %s = ?", DB.TABLE_MEMBER, DB.MEM_ID);
	public static final String MEMBER_LIST = String.format("select * from %s", DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME = String.format("select * from %s where %s = ?", DB.TABLE_MEMBER, DB.MEM_NAME);
	public static final String MEMBER_FINDBYID = String.format("select * from %s where %s = ?", DB.TABLE_MEMBER, DB.MEM_ID);
	public static final String MEMBER_COUNT = String.format("select count(*) as cnt from %s", DB.TABLE_MEMBER);
	
	public static final String ARTICLE_INSERT = String.format("insert into %s(%s, %s, %s, %s, %s, %s)values(article_seq.nextval, ?, ?, ?, ?, SYSDATE)", DB.TABLE_BOARD, DB.BO_SEQ, DB.BO_ID, DB.BO_TITLE, DB.BO_CONTENT, DB.BO_HITCOUNT, DB.BO_REGDATE);
	public static final String ARTICLE_UPDATE = String.format("update %s set %s=?, %s=?, %s=SYSDATE where %s=? and %s=?", DB.TABLE_BOARD, DB.BO_TITLE, DB.BO_CONTENT, DB.BO_REGDATE, DB.BO_SEQ, DB.BO_ID);
	public static final String ARTICLE_DELETE = String.format("delete from %s where %s=?", DB.TABLE_BOARD, DB.BO_SEQ);
	public static final String ARTICLE_LIST = String.format("select * from %s", DB.TABLE_BOARD);
	public static final String ARTICLE_FINDBYSEQ = String.format("select * from %s where %s=?", DB.TABLE_BOARD, DB.BO_SEQ);
	public static final String ARTICLE_FINDBYID = String.format("select * from %s where %s=?", DB.TABLE_BOARD, DB.BO_ID);
	public static final String ARTICLE_COUNT = String.format("select count(*) as cnt from %s", DB.TABLE_BOARD);
}
