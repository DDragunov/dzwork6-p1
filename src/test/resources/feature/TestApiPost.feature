#language:ru

@TEST
Функция: Изучение API - отправка данных на сервер
  Сценарий: Считываем данные из файла и меняем данные внутри. Далее отправляем данные на сервер. Проверяем полученные данные и статус выполнения.
    Дано структурированные данные в файле
    Тогда изменяем и дополняем данные
    Затем отправляем запрос c данными на сервер и проверяем статус запроса и полученные данные