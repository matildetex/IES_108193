package pt.deti.ua;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.Scanner;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    // private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {

        System.out.println("Hello");
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Enter city code");
        // Integer codigo = scan.nextInt(); 
        String codigo= args [0];
        int codigo1 = Integer.parseInt(codigo);
        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        // Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(codigo1);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
                System.out.println("I reached the end");
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}