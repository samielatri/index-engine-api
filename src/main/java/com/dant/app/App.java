package com.dant.app;

import com.dant.exception.mapper.RuntimeExceptionMapper;
import com.dant.filter.GsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("")
public class App extends Application {

	@Override
	public Set<Object> getSingletons() {
		Set<Object> sets = new HashSet<>(1);
		sets.add(new TableEndpoint());
		sets.add(new IndexEndPoint());
		sets.add(new IndexerEndPoint());
		sets.add(new FileEndPoint());
		return sets;
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> sets = new HashSet<>(1);
		sets.add(GsonProvider.class);
		sets.add(RuntimeExceptionMapper.class);
		return sets;
	}
}
