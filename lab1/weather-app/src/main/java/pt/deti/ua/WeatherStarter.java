package pt.deti.ua;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    // private static final int CITY_ID_AVEIRO = 1010500;
    private static final Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
    public static void  main(String[] args ) {
        logger.info("Application started");
        String codigo = args[0];
        int codigo1 = Integer.parseInt(codigo);
        logger.debug("City code: " + codigo1); // que faz?

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.ipma.pt/open-data/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            IpmaService service = retrofit.create(IpmaService.class);
            Call<IpmaCityForecast> callSync = service.getForecastForACity(codigo1);
            logger.info("API call prepared");

            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();
                logger.info("Forecast received for date: " + firstDay.getForecastDate());
                System.out.printf("Max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
            } else {
                logger.warn("No results for this request!");
            }
        } catch (Exception ex) {
            logger.error("An error occurred", ex);
        }

        logger.info("Application ended");
    }
}