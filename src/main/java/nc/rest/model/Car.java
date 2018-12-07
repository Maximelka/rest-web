package nc.rest.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Car {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String marka;

    @Getter
    @Setter
    private int year;
}
