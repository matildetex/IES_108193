package pt.deti.ua;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {
  private static final Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
  public void run() {
    //fazer arraylist com ids globais-> connecção à outra
    // lista
    List<Integer> cityIdsList = List.of(1010500, 1020500, 1030300, 1040200, 1050200, 1060300, 1070500, 1080500, 1081505, 1090700, 1100900, 1110600, 1121400, 1131200, 1141600, 1160900, 1171400, 1182300);
    // //escolher random
    Random random = new Random();
    int indiceAleatorio = random.nextInt(cityIdsList.size());
    Integer elementoAleatorio = cityIdsList.get(indiceAleatorio);
    String[] argumento = {String.valueOf(elementoAleatorio)};
     logger.debug("City code: "+ elementoAleatorio);
     WeatherStarter.main(argumento);
   
    logger.info("City Temperature for " + elementoAleatorio + "verified");
  }
}

public class Classe {
    private static final Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
    public static void  main(String[] args ) {
        logger.info("Application started");
        Timer myTimer = new Timer();
        MyTimerTask myTask = new MyTimerTask();
        myTimer.schedule(myTask, 1000, 20000); // delay inicial de 1 segundo, mas depois tem counter de 20 segundos
    
}
}
