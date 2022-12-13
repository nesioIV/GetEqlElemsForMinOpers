import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @author NesioIV
 * @version 1.0
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
class GetEqlElemsForMinOpers {
   /*
      метод расчета минимального количества шагов для
      обеспечения равенства всех элементов исходного массива
   */
   static int CalcEqlElemsForMinOpers(ArrayList numArrList, int elemIndex) {
      /* @param numArrList - исходный массив чисел для перестроения
       * @param elemIndex - индекс переставляемого элемента массива (отсчитывается от 1)
       * @return numOfSteps - минимальное количество шагов перестроения */

      if (numArrList.size() > 0 & (elemIndex > 0 & elemIndex <= numArrList.size())) {
         int i, j;
         j = numArrList.size();
         // проверить равенство всех элементов массива с индексами >= elemIndex
         for (i = elemIndex; i < j; i++) {
            if (numArrList.get(Math.min(i, j)) != numArrList.get(i - 1)) {
               return -1;  // равенство не соблюдается, построение массива невозможно
            }
         }
         // рассчитать минимально необходимое количество шагов перестроения массива,
         // проверяя уже выстроенные элементы массива с идексами <= elemIndex
         j = 0;
         for (i = elemIndex; i > 1; i--) {
            if (numArrList.get(Math.max(0, i - 2)) != numArrList.get(i - 1)) {
               j = i - 1;
               i = 0;  // результирующее количество шагов определено
            }
         }
         return j;
      }
      else {
         return -1;
      }
   }

   /*
      главный метод класса
      - реализует консольный интерфейс с пользователем
      - принимает ввод исходных данных, контролирует ограничения
        вводимых данных на допустимость
      - вызывает метод расчета минимального количества шагов
      - выводит результаты работы приложения в консоль
      - использует класс java.util.Scanner
    */
   public static void main(String[] args) {

      System.out.println("\n" + "МИНИМАЛЬНОЕ ЧИСЛО ШАГОВ ДЛЯ ОБЕСПЕЧЕНИЯ РАВЕНСТВА ВСЕХ ЭЛЕМЕНТОВ МАССИВА, NesioIV, 2022" + "\n");

      List<Integer> numArrList = new ArrayList<>();  // массив целых чисел для ввода с консоли
      char flag;  // признак продолжения ввода массива
      int nextInt = 0; // следующий элемент массива
      boolean correctInt = false; // признак корректности ввода значения int

      while (true) {  // цикл ввода массива целых чисел
         flag = '?';
         while (flag == '?') {
            Scanner scan = new Scanner(System.in);
            System.out.println("Текущее состояние массива: " + numArrList);
            System.out.println("Добавить элемент массива (Y - да / N - нет)?");
            try {
               flag = scan.next().charAt(0);
               if ( flag != 'N' & flag != 'n' & flag != 'Y' & flag != 'y') {
                  System.err.println("Ввод некорректен.");
                  flag = '?';
               }
            } catch (InputMismatchException e) {
               System.err.println("Ввод некорректен.");
               flag = '?';
            }
         }
         if (flag == 'Y' | flag == 'y') {
            correctInt = false;
            while (!correctInt) {  // ввод очередного элемента массива
               Scanner scan = new Scanner(System.in);
               System.out.println("Введите элемент массива (целое число -2147483648 <= A <= 2147483647): ");
               try {
                  nextInt = scan.nextInt();
                  correctInt = true;
               } catch (InputMismatchException e) {
                  System.err.println("Ввод некорректен.");
               }
               if (correctInt) numArrList.add(nextInt);
            }
         }
         if (flag == 'N' | flag == 'n') {
            break;
         }
      }
      if (correctInt) {  // массив исходных данных уже задан
         correctInt = false;
         nextInt = 0;
         while (!correctInt) {  // цикл ввода номера элемента массива
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите номер переставляемого элемента массива (целое число 1 <= K <= " + numArrList.size() + ")");
            try {
               nextInt = scan.nextInt();
               if (0 < nextInt & nextInt <= numArrList.size()) {
                  correctInt = true;
               }
            } catch (InputMismatchException e) {
               System.err.println("Ввод некорректен. \n");
            }
         }
      }
      if (numArrList.size() > 0) {
         System.out.println("\nВЫПОЛНЯЕТСЯ РАСЧЕТ минимального количества шагов для обеспечения равенства всех элементов массива...");
         System.out.println("Исходное состояние массива: " + numArrList);
         System.out.println("Номер переставляемого элемента массива: " + nextInt);
         Instant startTime = Instant.now();
         System.out.println();
         System.out.println("ОТВЕТ: " + CalcEqlElemsForMinOpers((ArrayList) numArrList, nextInt) + "     // расшифровка: -1 (перестроение невозможно); 0 (перестроение не требуется); N (требуется N шагов перестроения). \n");
         Instant stopTime = Instant.now();
         System.out.println("Время выполнения, мс: " + Duration.between(startTime, stopTime).toMillis());
         System.out.println();
      }
      System.out.println("= Выполнение приложения завершено =");
   }
}


