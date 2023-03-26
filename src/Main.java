import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Введите исходное время [HH:MM]: ");
    String time = br.readLine();
    Timestamp timestamp1 = new Timestamp(time);
    Timestamp timestamp2 = new Timestamp(time);
    System.out.println();

    System.out.println("Первое значение времени: " + timestamp1);
    System.out.print("Введите количество добавляемых мимнут: ");
    int addMinutes = Integer.parseInt(br.readLine());
    timestamp1.increaseOnMinutes(addMinutes);
    System.out.println("Результат: " + timestamp1);
    System.out.println();

    System.out.println("Второе значение времени: " + timestamp2);
    System.out.print("Введите количество добавляемых часов: ");
    int addHour = Integer.parseInt(br.readLine());
    timestamp2.increaseOnHour(addHour);
    System.out.println("Результат: " + timestamp2);
    System.out.println();

    List<Timestamp> listTime = new ArrayList<>();
    listTime.add(timestamp1);
    listTime.add(timestamp2);

    Collections.sort(listTime);
    for (Timestamp timestamp : listTime) {
      System.out.println(timestamp);
    }


  }
}