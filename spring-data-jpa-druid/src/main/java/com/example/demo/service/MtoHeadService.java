package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MtoHeadRepository;
import com.example.demo.entity.MtoHead;

@Service
@Transactional
public class MtoHeadService {
	@Autowired
	private MtoHeadRepository mtoHeadRepository;
	/**
	 * 保存
	 * @param mtoHead
	 */
	public void save(MtoHead mtoHead) {
		mtoHeadRepository.save(mtoHead);
	}
	/**
	 * 按id查找
	 */
	public MtoHead findById(String id) {
		Optional<MtoHead> mtoHead = mtoHeadRepository.findById(id);
		return mtoHead.get();
	}
}
