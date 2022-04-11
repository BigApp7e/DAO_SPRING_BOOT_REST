package com.repository;

import com.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface LogRepository extends JpaRepository<LogEntity,Long> {

    @Query(value = "SELECT * FROM LOGS ORDER BY ID DESC LIMIT 4", nativeQuery = true)
    ArrayList<LogEntity> getLastFourLogs();
}
