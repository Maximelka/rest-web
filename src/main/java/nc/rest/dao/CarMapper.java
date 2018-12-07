package nc.rest.dao;

import nc.rest.model.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        car.setMarka(rs.getString("marka"));
        car.setYear(rs.getInt("year"));
        return car;
    }
}
