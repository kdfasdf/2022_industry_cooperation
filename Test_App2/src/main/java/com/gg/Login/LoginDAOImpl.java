package com.gg.Login;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{
	@Override
	public List<LoginDTO> userList(SqlSessionTemplate session, int user_code) {
		// login�õ��� ������ user_codeȮ��
		if(user_code == 0) {	// ����ȸ���� ���
			return session.selectList("UserMapper.loginIndv");	// ���� table select
		}
		else if(user_code == 1){	// ���ȸ���� ���
			return session.selectList("UserMapper.loginComp");	// ��� table select
		}
		else {
			return null;	// �� ���� ���� �����̹Ƿ� null ��ȯ
		}
	}
}
