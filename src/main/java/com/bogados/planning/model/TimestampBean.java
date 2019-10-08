package com.bogados.planning.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class TimestampBean {
	@NotNull
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
