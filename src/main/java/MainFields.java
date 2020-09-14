public class MainFields {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainFields that = (MainFields) o;

        if (Double.compare(that.temp, temp) != 0) return false;
        if (Double.compare(that.feels_like, feels_like) != 0) return false;
        if (Double.compare(that.temp_min, temp_min) != 0) return false;
        if (Double.compare(that.temp_max, temp_max) != 0) return false;
        if (pressure != that.pressure) return false;
        return humidity == that.humidity;
    }

    @Override
    public int hashCode() {
        int result;
        long temp1;
        temp1 = Double.doubleToLongBits(temp);
        result = (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(feels_like);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(temp_min);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(temp_max);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        result = 31 * result + pressure;
        result = 31 * result + humidity;
        return result;
    }

    @Override
    public String toString() {
        return "MainFields{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
    void tempFtoC () {
        this.temp = Math.round((this.temp - 32) / 1.8);
        this.temp_max = (this.temp - 32) / 1.8;
        this.temp_min = (this.temp - 32) / 1.8;
        this.feels_like = (this.temp - 32) / 1.8;
    }
}
