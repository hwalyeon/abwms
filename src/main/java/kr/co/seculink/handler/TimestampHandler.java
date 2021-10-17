package kr.co.seculink.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class TimestampHandler extends BaseTypeHandler<String> {

	SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Override
	public String getNullableResult(ResultSet rs, String parameter) throws SQLException {
		
		Timestamp col = rs.getTimestamp(parameter);
		
		String ret = null;
		
		if (null != col) {
		
			ret = defaultFormat.format(col);
		
		}
		
		return ret;
	}

	@Override
	public String getNullableResult(ResultSet rs, int idx) throws SQLException {
		
		Timestamp col = rs.getTimestamp(idx);
		
		String ret = null;
		
		if (null != col) {
		
			ret = defaultFormat.format(col);
		
		}
		
		return ret;
	}

	@Override
	public String getNullableResult(CallableStatement cs, int idx) throws SQLException {
		
		Timestamp col = cs.getTimestamp(idx);
		
		String ret = null;
		
		if (null != col) {
		
			ret = defaultFormat.format(col);
		
		}
		
		return ret;
		
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int idx, String parameter, JdbcType type) throws SQLException {

		if (null == parameter || parameter.isEmpty() == true) {
			return;
		}
		
		Date parsedDate = null;
		try {
			parsedDate = defaultFormat.parse(parameter);
		} catch (ParseException e) {
			throw new SQLException("Timestamp format error " + parameter);
		}
	    Timestamp timestamp = new Timestamp(parsedDate.getTime());

		ps.setTimestamp(idx, timestamp);
	}

}
