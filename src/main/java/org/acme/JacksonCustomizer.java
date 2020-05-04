package org.acme;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EntityType;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;

/**
 * See <a href="https://quarkus.io/guides/rest-json#jackson">Quarkus Jackson Customization</a>
 */
@Singleton
public class JacksonCustomizer implements ObjectMapperCustomizer {
	private final EntityManagerFactory emf;

	@Inject
	public JacksonCustomizer(
			EntityManagerFactory emf
	) {
		this.emf = emf;
	}

	@Override
	public void customize(ObjectMapper mapper) {
		Set<EntityType<?>> entities = emf.getMetamodel().getEntities();

		String actual = String.valueOf(entities);
		String expected = "[SomeEntity]";

		if (!actual.equals(expected)) {
			throw new IllegalStateException("failure");
		}

	}

}
