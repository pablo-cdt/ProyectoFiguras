import services.CalculosFiguraService;
import services.GenerarMenuService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Thread t1 = new Thread(new GenerarMenuService());
        t1.start();

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepad Calculos\\2022-04-01\\1.txt");
    }
}