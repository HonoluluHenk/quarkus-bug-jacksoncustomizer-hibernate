package org.acme;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SomeEntity {

	@Id
	private String id;

	private String foo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}
}
