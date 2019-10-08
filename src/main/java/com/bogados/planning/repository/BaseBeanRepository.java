package com.bogados.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseBeanRepository<T> extends JpaRepository<T, Long> {
}
