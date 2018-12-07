package nc.rest.dao;

import nc.rest.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarDaoImpl implements CarDao {

    private static final String SQL_GET_CAR_BY_ID =
            "select id, name, marka, year from cars where id = :id";

    private static final String SQL_INSERT_CAR=
            "insert into cars (name, marka, year) values (:name, :marka, :year)";

    private static final String SQL_UPDATE_CAR =
            "update cars set name = :name, marka = :marka, year = :year where id = :id";

    private static final String SQL_DELETE_PROFILE =
            "delete from cars where id = :id";

    private final CarMapper carMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(
            CarMapper carMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.carMapper = carMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Car> getCarById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            SQL_GET_CAR_BY_ID,
                            params,
                            carMapper
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insertCar(String name, String marka, int year) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("marka", marka);
        params.addValue("year", year);
        jdbcTemplate.update(SQL_INSERT_CAR, params);
    }

    @Override
    public void updateCar(String name, String marka, int year, int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("marka", marka);
        params.addValue("year", year);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_CAR, params);
    }

    @Override
    public void deleteCarById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_PROFILE, params);
    }
}
