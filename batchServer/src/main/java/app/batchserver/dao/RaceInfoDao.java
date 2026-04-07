package app.batchserver.dao;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RaceInfoDao {

    private final JdbcTemplate jdbcTemplate;

    public RaceInfoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(String raceName, LocalDate raceDate) {
        String sql = """
                INSERT INTO race_info (race_name, race_date)
                VALUES (?, ?)
                """;

        return jdbcTemplate.update(sql, raceName, Date.valueOf(raceDate));
    }
}