import java.util.*;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int floor;
        int previousFloor = -1;

        Scanner scanner = new Scanner(System.in);
        int levelInput;
        while (true) {

            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            try {
                levelInput = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Неверный ввод");
                continue;
            }
            if (levelInput == 0) {
                System.out.println("Лифт проследовал по следующим этажам:");
                while (!queue.isEmpty()) {
                    floor = queue.poll();

                    System.out.print("этаж " + floor + (!queue.isEmpty() ? " -> " : " - этаж 0 \n"));

                    if (previousFloor != -1) {
                        totalSeconds += Math.abs(floor - previousFloor) * waitMoveInSeconds;
                        totalSeconds += waitDoorsInSeconds;
                    }
                    previousFloor = floor;
                }
                System.out.println("Время затраченное лифтом на маршрут = " + totalSeconds + " с.");
                break;

            } else if (levelInput < 0 || levelInput > 25) {
                System.out.println("Такого этажа нет в доме");
            } else {
                queue.add(levelInput);
            }
        }
    }
}
