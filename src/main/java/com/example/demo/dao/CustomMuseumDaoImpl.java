package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.Granularity;
import com.example.demo.model.dto.VisitorCount;

@Repository
public class CustomMuseumDaoImpl implements CustomMuseumDao{

	@Autowired
	private EntityManager entity;

	@SuppressWarnings("unchecked")
	@Override
	public List<VisitorCount> findVisitorsByDateAndGranurity(LocalDateTime fromTimeStamp,
			LocalDateTime toTimeStamp, String eventType, Granularity granularity) {

		Query query  = entity.createQuery(getQuery(granularity));
		query.setParameter("eventType", eventType);
		query.setParameter("fromTimeStamp", fromTimeStamp);
		query.setParameter("toTimeStamp", toTimeStamp);
		
		return query.getResultList();
	}

	
	/*
	 * private String getQuery(String eventType, Granularity granularity) {
	 * StringBuilder sqlQuery = new StringBuilder();
	 * sqlQuery.append("FROM Ticket "); sqlQuery.
	 * append("WHERE eventType = :eventType and timeStamp BETWEEN (:fromTimeStamp) AND (:toTimeStamp)"
	 * ); return sqlQuery.toString(); }
	 */
	
	private String getQuery(Granularity granularity) {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT timeStamp as time, COUNT(*) as count FROM Ticket ");
		sqlQuery.append("WHERE eventType = :eventType ");
		sqlQuery.append("GROUP BY " + granularity.name()+ "(timeStamp) ");
		sqlQuery.append("HAVING timeStamp between (:fromTimeStamp) AND (:toTimeStamp)");

		return sqlQuery.toString();
	}

	
	
	/*sqlQuery.append("SELECT " + eventType + "_date as time, COUNT(*) as count");
		sqlQuery.append(" FROM ticket GROUP BY " + granularity.name()+ "("+eventType+"_date) ");
		sqlQuery.append("HAVING " + eventType + "_date between ('");
		sqlQuery.append(fromTimeStamp);
		sqlQuery.append("' AND '");
		sqlQuery.append(toTimeStamp);
		sqlQuery.append("')");
		return sqlQuery.toString();
	 */
}
