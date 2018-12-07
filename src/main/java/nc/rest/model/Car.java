package nc.rest.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Car {

    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String marka;

    @Setter
    @Getter
    private int year;
}
