package com.cantarino.ms.repositories;

import com.cantarino.ms.dtos.filters.ShopReportDTO;
import com.cantarino.ms.models.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {
    List<Shop> getReportByFilter(Date dataInicio, Date DataFim , Float valorMinimo);
    ShopReportDTO getReportByDate(Date dataInicio, Date DataFim);
}
