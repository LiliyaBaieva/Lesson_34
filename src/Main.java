import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
  // Как известно, в США президент выбирается не прямым голосованием, а путем двухуровневого
  // голосования.
  // Сначала проводятся выборы в каждом штате, и определяется победитель выборов в данном штате.
  // Затем проводятся государственные выборы:
  // на этих выборах каждый штат имеет определенное число голосов — число выборщиков от этого штата.
  // На практике, все выборщики от штата голосуют в соответствии с результатами голосования внутри
  // штата, то есть на заключительной стадии выборов в голосовании участвуют штаты,
  // имеющие различное число голосов.

  // В первой строке дано количество записей.
  // Каждая запись содержит фамилию кандидата и число голосов,
  // отданных за него в одном из штатов.
  //
  // Подведите итоги выборов: для каждого из участников голосования
  // определите число отданных за него голосов.

  // Пример ввода:
//5
//McCain 10
//McCain 5
//Obama 9
//Obama 8
//McCain 1

  // Пример вывода:
  // McCain 16
  // Obama 17
  public static void main(String[] args) throws IOException {
    File inputFile = new File("res/in.txt");

    BufferedReader br = new BufferedReader(new FileReader(inputFile));

    Map<String, Integer> result = new HashMap<>();

    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n; ++i){
      String line = br.readLine();
      int spaceIndex = line.indexOf(' ');
      String name = line.substring(0, spaceIndex);
      String voiceString = line.substring(spaceIndex + 1);
      int voice = Integer.parseInt(voiceString);
      if(!result.containsKey(name)){  // создаём счётчик для нового пользователя
        result.put(name, 0);
      }
//      result.put(name, (result.get(name) + 1)); // увеличивает счётчик на 1
      result.put(name, (result.get(name) + voice)); // увеличиваем на количестов голосов
    }
    br.close();

//    for(Map.Entry<String, Integer> entry : result.entrySet()){  // длинная непонятная версия
//      System.out.println(entry.getKey() + " " + entry.getValue());
//    }

    for(String name : result.keySet()){
      System.out.println(name + ' ' + result.get(name));
    }

  }






















}