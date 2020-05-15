package com.devepos.adt.abaptags;

/**
 * Search Scope for tags
 * 
 * @author stockbal
 */
public enum TagSearchScope {
	ALL,
	GLOBAL,
	USER;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
