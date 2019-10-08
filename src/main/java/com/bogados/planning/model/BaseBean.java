package com.bogados.planning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseBean extends TimestampBean{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true)
	private String uuid;

}

