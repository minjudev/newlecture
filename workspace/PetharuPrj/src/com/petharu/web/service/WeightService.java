package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Weight;

public interface WeightService {
	List<Weight> getList(int memberid);
	Weight get(int id); //id�� �ش� ������ ������
	int insert(Weight weight);
	int update(Weight weight);
	int delete(int id);
}
