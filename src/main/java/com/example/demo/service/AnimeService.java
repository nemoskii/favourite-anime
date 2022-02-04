package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Anime;
import com.example.demo.mapper.AnimeMapper;

@Service // ServiceとしてDIに登録
public class AnimeService {

	@Autowired
	AnimeMapper mapper;

	/**
	 * アニメリストを全件取得する。
	 * 
	 * @return アニメリスト
	 */
	public List<Anime> getAnimeList() {
		return mapper.selectAll();
	}
}