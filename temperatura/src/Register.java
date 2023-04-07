import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Register implements Serializable {

    private static final long serialVersionUID = -523473646071633694L;
    double temperature;
    LocalDateTime time;
    Register (double temperature){
        this.temperature = temperature;
        this.time = LocalDateTime.now();
    }

    Register (double temperature, LocalDateTime time){
        this.temperature = temperature;
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT).
                withLocale(Locale.getDefault());
        return "Registro {" + "temperature = "+temperature +
                ", date and time = "+f.format(time) + " } \n";
    }

    public double getTemperature() {
        return temperature;
    }
}
