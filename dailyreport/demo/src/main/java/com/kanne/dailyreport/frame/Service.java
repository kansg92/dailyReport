package com.kanne.dailyreport.frame;

import java.util.List;

public interface Service<V,K> {
	public void register(V v) throws Exception;
	public void remove(V v) throws Exception;
	public void modify(V v) throws Exception;
	
	public V get(K k) throws Exception;
	public List<V>get() throws Exception;
}
