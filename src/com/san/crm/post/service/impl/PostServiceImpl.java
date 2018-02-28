package com.san.crm.post.service.impl;

import java.util.List;

import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.post.dao.PostDao;
import com.san.crm.post.domain.CrmPost;
import com.san.crm.post.service.PostService;

public class PostServiceImpl implements PostService {
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	public List<CrmPost> findAll(CrmDepartment crmDepartment) {
		
		return postDao.findAll(crmDepartment);
	}

}
