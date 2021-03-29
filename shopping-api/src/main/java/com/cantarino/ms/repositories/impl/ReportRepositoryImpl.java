package com.cantarino.ms.repositories.impl;

import com.cantarino.ms.dtos.filters.ShopReportDTO;
import com.cantarino.ms.repositories.ReportRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getReportByFilter(Date dataInicio, Date DataFim, Float valorMinimo) {

        StringBuilder _builder = new StringBuilder();

        _builder.append("SELECT S");
        _builder.append(" FROM SHOP S");
        _builder.append(" WHERE s.date >= :dataInicio ");

        if(DataFim != null)
            _builder.append(" WHERE s.date <= :DataFim");

        if(valorMinimo != null)
            _builder.append(" WHERE s.total <= :valorMinimo");


        Query query = entityManager.createQuery(_builder.toString());
        query.setParameter("dataInicio",  dataInicio);
        if(DataFim != null) query.setParameter("dataFim",  DataFim);
        if(valorMinimo != null)  query.setParameter("valorMinimo",  valorMinimo);

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date DataFim) {

        StringBuilder _builder = new StringBuilder();
        _builder.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        _builder.append("from shopping.shop sp ");
        _builder.append("where  sp.date >= :dataInicio ");
        _builder.append("and sp.date <= :dataFim ");

        Query query = entityManager.createQuery(_builder.toString());
        query.setParameter("dataInicio",  dataInicio);
        query.setParameter("dataFim",  DataFim);

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setCount(((BigInteger) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);


        return shopReportDTO;
    }
}
