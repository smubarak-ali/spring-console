package com.bigledger.emp_to_db.util;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.util.StringUtils;

public class ExtendedBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {
	
	 //Contains valid true values
    public static final List<String> TRUE_SET = new ArrayList<String>(Arrays.asList("y", "yes", "true"));
    public static final List<String> FALSE_SET = new ArrayList<String>(Arrays.asList("n", "no", "false"));

    public ExtendedBeanPropertyRowMapper(Class<T> clazz) {
        super(clazz);
    }

    @Override
    /**
     * Override <code>getColumnValue</code> to add ability to map 'Y','N' type columns to
     * boolean properties.
     * 
     * @param rs is the ResultSet holding the data
     * @param index is the column index
     * @param pd the bean property that each result object is expected to match
     * (or <code>null</code> if none specified)
     * @return the Object value
     * @throws SQLException in case of extraction failure
     * @see org.springframework.jdbc.core.BeanPropertyRowMapper#getColumnValue(java.sql.ResultSet, int, PropertyDescriptor) 
     */
    protected Object getColumnValue( ResultSet rs, int index, PropertyDescriptor pd) throws SQLException {
    	
        Class<?> requiredType = pd.getPropertyType();
        
        if (boolean.class.equals(requiredType) || Boolean.class.equals(requiredType)) {
        	
            String stringValue = rs.getString(index);
            if( stringValue != null ) {
            	
            	if(!StringUtils.isEmpty(stringValue) && TRUE_SET.contains(stringValue.toLowerCase())){
                    return true;
                }
            	else if(!StringUtils.isEmpty(stringValue) && FALSE_SET.contains(stringValue.toLowerCase())) {
            		return false;
            	}
            }
            else { 
            	
            	return false; 
            }
        }       
        return super.getColumnValue(rs, index, pd);
    }

}
