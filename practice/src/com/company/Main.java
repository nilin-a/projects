package com.company;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("1 - ArrayList \n2 - ArrayDeque \n3 - LinkedList \n4 - HashSet \n0 - exit");
        int option = in.nextInt();
        while (option != 0) {
            switch (option) {
                case (1):
                    ArrayList<String> weekDaysInRussian = new ArrayList<>(7);
                    weekDaysInRussian.add("Понедельник");
                    weekDaysInRussian.add(1, "Вторник");
                    weekDaysInRussian.add("Среда");
                    weekDaysInRussian.add("Пятница");
                    weekDaysInRussian.add("Четверг");
                    weekDaysInRussian.add("Суббота");
                    weekDaysInRussian.add("Воскресенье");
                    System.out.println(weekDaysInRussian + " - size: " + weekDaysInRussian.size());
                    System.out.println(weekDaysInRussian.get(2));
                    for (String day: weekDaysInRussian) {
                        System.out.println(day);
                    }
                    if (weekDaysInRussian.contains("Пятница")) {
                        System.out.println(weekDaysInRussian.remove(weekDaysInRussian.indexOf("Пятница")) +  " was removed");
                    }
                    Collections.sort(weekDaysInRussian);
                    System.out.println(weekDaysInRussian);
                    Collections.reverse(weekDaysInRussian);
                    System.out.println(weekDaysInRussian + " - size: " + weekDaysInRussian.size());
                    Collections.shuffle(weekDaysInRussian);
                    System.out.println(weekDaysInRussian);
                    if (!weekDaysInRussian.contains("Пятница")) {
                        weekDaysInRussian.add("Пятница");
                    }
                    List<String> fixedWeekDays = Collections.unmodifiableList(weekDaysInRussian);
                    try {
                        fixedWeekDays.add("Понедельник1");
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(fixedWeekDays);
                    Collections.swap(weekDaysInRussian, weekDaysInRussian.indexOf("Вторник"), weekDaysInRussian.indexOf("Понедельник"));
                    System.out.println(weekDaysInRussian);
                    System.out.println("Коллекции уникальные? - " + Collections.disjoint(weekDaysInRussian, fixedWeekDays));

                    System.out.println("1 - ArrayList \n2 - ArrayDeque \n3 - LinkedList \n4 - HashSet \n0 - exit");
                    option = in.nextInt();
                    break;
                case (2):
                    ArrayDeque<String> months = new ArrayDeque<>(12);
                    months.addFirst("Январь");
                    months.addLast("Февраль");
                    months.add("Май");
                    months.offerFirst("Март");
                    months.offerLast("Июнь");
                    months.offer("Сентябрь");
                    System.out.println(months);
                    try {
                        System.out.println("Первый элемент: " + months.getFirst() + "\nПоследний элемент: " + months.getLast());
                        months.pop();
                        months.removeFirst();
                        months.removeLast();
                        System.out.println(months);
                    } catch (NoSuchElementException e) {
                        e.getMessage();
                    }
                    if (months.peekFirst() != null && months.peekLast() != null) {
                        System.out.println("Первый элемент: " + months.peekFirst() + "\nПоследний элемент: " + months.peekLast());
                        months.pollFirst();
                        months.pollLast();
                        System.out.println(months);
                    } else {
                        System.out.println("Коллекция пустая!");
                    }
                    months.push("Август");
                    months.push("Декабрь");
                    months.push("Август");

                    System.out.println(months);
                    System.out.println(months.removeLastOccurrence("Август"));
                    System.out.println(months);

                    while (months.peek() != null) {
                        System.out.println(months.pollLast());
                    }

                    System.out.println("1 - ArrayList \n2 - ArrayDeque \n3 - LinkedList \n4 - HashSet \n0 - exit");
                    option = in.nextInt();
                    break;
                case (3):
                    LinkedList<String> colours = new LinkedList<>();
                    colours.add("Красный");
                    colours.add("Зеленый");
                    colours.addFirst("Черный");
                    colours.addLast("Розовый");
                    System.out.println(colours + " - size: " + colours.size());
                    colours.set(2, "Белый");
                    for (String colour : colours) {
                        System.out.println(colour);
                    }
                    colours.remove("Розовый");
                    System.out.println("Первый цвет: " + colours.getFirst() + "\nПоследний цвет: " + colours.getLast());
                    colours.removeFirst();
                    colours.removeLast();
                    System.out.println(colours);

                    System.out.println("1 - ArrayList \n2 - ArrayDeque \n3 - LinkedList \n4 - HashSet \n0 - exit");
                    option = in.nextInt();
                    break;
                case (4):
                    HashSet<String> animals = new HashSet<>();


                    System.out.println("1 - ArrayList \n2 - ArrayDeque \n3 - LinkedList \n4 - HashSet \n0 - exit");
                    break;
                case (0):
                    System.out.println("Goodbye!");
            }

         */

        /*
        double[] d = {2, 1, 4, 2, 3};
        double[] r = task(d);
        for(
                double x :r)

        {
            System.out.println(x);
        }

         */


        List<OrderService.OrderData> list = new ArrayList<>();
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "EUR", 2000l));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "USD", 15l));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "RUB", 200l));
        list.add(new OrderService.OrderData(OrderService.Type.PICKUP, "RUB", 1250l));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "USD", 35l));
        list.add(new OrderService.OrderData(OrderService.Type.PICKUP, "USD", 55l));
        list.add(new OrderService.OrderData(OrderService.Type.DELIVERY, "RUB", 100l));

        Map<String, Double> difference = OrderService.getMaxMinusMinDeliveryMapByCurrency(list);

        System.out.println(difference);
    }
    /*
    public static double[] task(double[] a) {
        if (Arrays.stream(a).anyMatch(x -> x < 0)) {
            throw new IllegalArgumentException("The number is less than zero");
        }
        return Arrays.stream(a).reverse().distinct().reverse().toArray();
    }
     */

    /*
    /**
* @param a – массив чисел, длина массива может быть больше 10млн.
* @return массив чисел, в которых нeту дубликатов. Порядок чисел в оригинальном массиве должен быть сохранён.
Из дубликатов нужно оставлять последний элемент, например, для {2,1,4,2,3} правильное решение - {1,4,2,3}, а не {2,1,4,3}

В случае, если во входном массиве есть элемент меньше 0, то нужно выдавать ошибку.
Например, для {2,3,-1,5} обработка должна закончиться ошибкой.
     */
}








