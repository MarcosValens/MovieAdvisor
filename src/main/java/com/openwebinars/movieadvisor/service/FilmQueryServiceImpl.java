package com.openwebinars.movieadvisor.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openwebinars.movieadvisor.dao.FilmDao;
import com.openwebinars.movieadvisor.model.Film;

/**
 * Implementación del servicio de consulta sobre el repositorio.
 * Esta implementación es algo lenta, ya que se basa en el uso
 * del API Stream de Java 8 sobre una lista bastante grande.
 * 
 * Una posible mejora sería utilizar como repositorio una base
 * de datos, y tener una implementación de este servicio que hiciera
 * uso de Criteria API o QueryDSL. 
 * 
 * 
 * @author OpenWebinars
 *
 */
@Service
public class FilmQueryServiceImpl implements FilmQueryService{
	
	@Autowired
	FilmDao dao;

	private Predicate<Film> predicate;
	
	@PostConstruct
	public void init() {
		predicate = null;
	}

	public Collection<Film> exec() {
		
		// @formatter:off
		return dao.findAll()
				.stream()
				.filter(predicate)
				.collect(Collectors.toList()); 
		// @formatter:on

	}

	public FilmQueryServiceImpl anyGenre(String... genres) {
		Predicate<Film> pAnyGenre = (film -> Arrays.stream(genres).anyMatch(film.getGenres()::contains));
		predicate = (predicate == null) ? pAnyGenre : predicate.and(pAnyGenre);
		return this;
	}

	public FilmQueryServiceImpl allGenres(String... genres) {
		Predicate<Film> pAllGenres = (film -> Arrays.stream(genres).allMatch(film.getGenres()::contains));
		predicate = (predicate == null) ? pAllGenres : predicate.and(pAllGenres);
		return this;
	}

	public FilmQueryServiceImpl year(String year) {
		Predicate<Film> pYear = (film -> film.getYear().equalsIgnoreCase(year));
		predicate = (predicate == null) ? pYear : predicate.and(pYear);
		return this;
	}

	public FilmQueryServiceImpl betweenYears(String from, String to) {
		Predicate<Film> pBetweenYears = (film -> {
			LocalDate fromYear = LocalDate.of(Integer.parseInt(from), 1, 1);
			LocalDate toYear = LocalDate.of(Integer.parseInt(to), 1, 3);
			LocalDate filmYear = LocalDate.of(Integer.parseInt(film.getYear()), 1, 2);

			return filmYear.isAfter(fromYear) && filmYear.isBefore(toYear);
		});
		
		predicate = (predicate == null) ? pBetweenYears : predicate.and(pBetweenYears);

		return this;
	}

	public FilmQueryServiceImpl titleContains(String title) {
		Predicate<Film> pTitleContains  = (film -> film.getTitle().toLowerCase().contains(title.toLowerCase()));
		predicate = (predicate == null) ? pTitleContains : predicate.and(pTitleContains);
		
		return this;
	}

}
