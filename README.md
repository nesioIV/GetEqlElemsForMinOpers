GetEqlElemsForMinOpers

# Решение задачи программирования на тему "Минимальное число шагов для обеспечения равенства всех элементов массива" на языке Java

**ФОРМУЛИРОВКА ЗАДАЧИ:**

Дан массив целых чисел длины N и целое число K. Разрешена операция удаления первого элемента массива с записью в его конец K-го элемента. Какое минимальное число шагов потребуется для того, чтобы сделать все элементы массива одинаковыми? -1, если это невозможно.

**ПРОГРАММНЫЙ КОД:**

Исходный программный код содержится в файле с именем *GetEqlElemsForMinOpers.java*.

**НАЗНАЧЕНИЕ:**

Класс GetEqlElemsForMinOpers реализует  
- метод CalcEqlElemsForMinOpers, который решает следующую задачу: "Дан массив целых чисел длины N и целое число K.  Разрешена операция удаления первого элемента массива с записью в его конец K-го элемента. Какое минимальное число шагов потребуется для того, чтобы сделать все элементы массива одинаковыми? -1, если это невозможно.";
- метод main, обеспечивающий консольный интерфейс    взаимодействия с пользователем, контроль корректности вводимых пользователем данных, вызов метода CalcEqlElemsForMinOpers, вывод результатов работы приложения в консоль.

**АЛГОРИТМ:**

Необходимо проверить равенство всех элементов массива с индексами >= K. Если равенство не выполняется, то  перестроение требуемого массива невозможно. Если выполняется, то необходимо рассчитать минимально необходимое количество шагов перестроения массива, проверяя уже выстроенные и еще не выстроенные элементы массива с индексами < K.

**СЛОЖНОСТЬ:**

В приложении реализован алгоритм с линейной временной сложностью O(n), определяемой размером n входного массива данных.

**РЕАЛИЗАЦИЯ:**

Java version "11.0.1", использованы стандартные возможности JDK.

**ОГРАНИЧЕНИЯ:**

Приложение допускает ввод и обработку чисел типа Integer, которые могут быть заданы во входном массиве.

**ТЕСТИРОВАНИЕ:**

Количество шагов перестроения тестовых массивов с N элементами для различных номеров K переставляемых элементов в массиве представлены  в таблице:

массив N|   K = 1 |  K = 2  |   K = 3
--------|:-------:|:-------:|:---------:
0       |    0    |         |
0 1     |   -1    |    1    | 
1 1     |    0    |    0    |
0 0 1   |   -1    |   -1    |    2
0 1 0   |   -1    |   -1    |    2
0 1 1   |   -1    |    1    |    1
1 1 1   |    0    |    0    |    0

**КОНТРОЛЬНЫЙ ПРИМЕР выполнения приложения**:

МИНИМАЛЬНОЕ ЧИСЛО ШАГОВ ДЛЯ ОБЕСПЕЧЕНИЯ РАВЕНСТВА ВСЕХ ЭЛЕМЕНТОВ МАССИВА, NesioIV, 2022
Текущее состояние массива: [ ]
Добавить элемент массива (Y - да / N - нет)? Y
Введите элемент массива (целое число -2147483648 <= A <= 2147483647):  -2
Текущее состояние массива: [-2]
Добавить элемент массива (Y - да / N - нет)? Y
Введите элемент массива (целое число -2147483648 <= A <= 2147483647):  -1
 Текущее состояние массива: [-2, -1]
 Добавить элемент массива (Y - да / N - нет)? Y
 Введите элемент массива (целое число -2147483648 <= A <= 2147483647):  0
 Текущее состояние массива: [-2, -1, 0]
 Добавить элемент массива (Y - да / N - нет)?  Y
 Введите элемент массива (целое число -2147483648 <= A <= 2147483647):  1
 Текущее состояние массива: [-2, -1, 0, 1]
 Добавить элемент массива (Y - да / N - нет)?  N

 Введите номер переставляемого элемента массива (целое число 1 <= K <= 4):  4

 ВЫПОЛНЯЕТСЯ РАСЧЕТ минимального количества шагов для обеспечения равенства всех элементов массива...
 Исходное состояние массива: [-2, -1, 0, 1]
 Номер переставляемого элемента массива: 4

 **ОТВЕТ: 3**     
 // расшифровка: -1 (перестроение невозможно); 0 (перестроение не требуется); N (требуется N шагов перестроения).

Время выполнения, мс: 0

= Выполнение приложения завершено =

Process finished with exit code 0
