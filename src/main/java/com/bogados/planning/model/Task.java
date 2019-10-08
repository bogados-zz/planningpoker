package com.bogados.planning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseBean {

	@NotNull
	@NotEmpty
	private String name;
	private String description;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Vote> votes;
	@ManyToOne
	private User createdBy;

}
