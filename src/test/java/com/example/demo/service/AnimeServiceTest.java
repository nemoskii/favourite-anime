package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Anime;
import com.example.demo.entity.AnimeCondition;

@SpringBootTest
public class AnimeServiceTest {

	@Autowired
	AnimeService target;

	@Test
	void 全件検索できること_正常終了() {
		List<Anime> animeList = target.getAnimeList();

		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);

		// 検索結果の1件目の結果を確認する
		Anime maoyu = animeList.get(0);
		assertThat(maoyu.getTitleNo()).isEqualTo(1);
		assertThat(maoyu.getTitle()).isEqualTo("まおゆう");

	}

	@Test
	void 前方一致テスト_検索条件に転を指定して検索できること() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle("転");
		List<Anime> animeList = target.searchAnimeListByCondition(condition);

		// 検索結果が1件あること
		assertThat(animeList.size()).isEqualTo(1);

		// 検索結果の1件目の結果を確認する
		Anime tensura = animeList.get(0);
		assertThat(tensura.getTitleNo()).isEqualTo(2);
		assertThat(tensura.getTitle()).isEqualTo("転スラ");

	}

	@Test
	void 前方一致テスト_検索条件なしで検索できること_null() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle(null);
		List<Anime> animeList = target.searchAnimeListByCondition(condition);

		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);

	}

	@Test
	void 前方一致テスト_検索条件なしで検索できること_空文字() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle("");
		List<Anime> animeList = target.searchAnimeListByCondition(condition);

		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);

	}

}
