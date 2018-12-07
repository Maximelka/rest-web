package nc.rest.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarRequest {

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @NotNull
    private String marka;

    @Getter
    @Setter
    @NotNull
    @Min(1)
    private Integer year;
}
