package com.gerimedica.fetcher.repository;

import com.gerimedica.fetcher.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FetcherRepository extends JpaRepository<Record, Long> {
}
