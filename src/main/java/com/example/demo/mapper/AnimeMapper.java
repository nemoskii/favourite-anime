package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Anime;
import com.example.demo.entity.AnimeCondition;

@Mapper
public interface AnimeMapper {

	/**
	 * 全件検索する
	 * 
	 * @return 検索結果
	 */
	public List<Anime> selectAll();

	/**
	 * 検索条件に該当するリストを検索する
	 * 
	 * @return 検索結果
	 */
	public List<Anime> selectByCondition(AnimeCondition condition);

}
