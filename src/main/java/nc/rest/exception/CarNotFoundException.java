package nc.rest.exception;

public class CarNotFoundException extends RuntimeException {

    private final int carId;

    public CarNotFoundException(int carId) {
        this.carId = carId;
    }

    @Override
    public String getMessage() {
        return "Profile with id = " + carId + " not found";
    }
}
