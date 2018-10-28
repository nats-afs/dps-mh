package com.afs.nats.dpsmh.model;

import java.util.ArrayList;
import java.util.List;

public enum DocumentType {
	DNI, RUC;
	
	public static final List<DocumentType> getValues(){
		List<DocumentType> docs = new ArrayList<>();
		docs.add(DNI);
		docs.add(RUC);
		return docs;
	}
}