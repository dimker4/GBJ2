package GBJ2.J2.Marathon;

public class Course {
    Obstacle[] obstacles;

    Course (Obstacle ...arr) { // Множественный аргумент
        if (arr.length > 0) {
            obstacles = new Obstacle[arr.length];
            for (int i = 0; i < arr.length; i ++) { // Заполняем массив препятствий
                obstacles[i] = arr[i];
            }
        }
    }

    public void start(Team t) {
        for (int i = 0; i < t.getTeamList().length; i ++) { // Цикл по участникам
            for (int j = 0; j < obstacles.length; j ++) {
                obstacles[j].doIt(t.getTeamList()[i]);
                if (!t.getTeamList()[i].isOnDistance()) break;  // Если кто-то не прошел одно припятсиве, то снимаем с забега
            }
        }
    }
}
