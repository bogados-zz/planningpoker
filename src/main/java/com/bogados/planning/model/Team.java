package com.bogados.planning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Team extends BaseBean{

	@Column(unique = true)
	private String identifier;
	@NotNull
	private String name;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Task> tasks;

}


