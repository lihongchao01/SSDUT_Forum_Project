package cn.com.ssdut.forum.service.impl;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.ssdut.forum.dao.SimpleDao;
import cn.com.ssdut.forum.service.AdminService;

@Repository
public class AdminServiceImpl implements AdminService{

	@Autowired
	private @Setter
	SimpleDao adminDao;
	public SimpleDao getAdminDao(){
		return adminDao;
	}
	public void  setAdminDao(SimpleDao adminDao){
		this.adminDao = adminDao;
	}

}
