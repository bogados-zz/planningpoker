package com.bogados.planning.repository;

import com.bogados.planning.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseBeanRepository<T extends BaseBean> extends JpaRepository<T, Long> {
}
