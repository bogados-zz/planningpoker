package com.bogados.planning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Team extends BaseBean{

	private Long id;
	@Column(unique = true)
	private String identifier;
	private String name;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Task> tasks;

}


