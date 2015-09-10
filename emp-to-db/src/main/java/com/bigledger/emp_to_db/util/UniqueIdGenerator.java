package com.bigledger.emp_to_db.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UniqueIdGenerator {

	
	public static String generateGuid() {
		return UUID.randomUUID().toString().toUpperCase();
	}
	
	public static List<String> generateGuid( Integer maxNumber ) {
		
		List<String> guidList = new ArrayList<String>();
		for( int i=0; i < maxNumber; i++ ) {
			
			String guid = UUID.randomUUID().toString().toUpperCase();
			guidList.add( guid );
		}
		return guidList;
		
	}
	
}
