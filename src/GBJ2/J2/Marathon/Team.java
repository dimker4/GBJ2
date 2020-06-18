package GBJ2.J2.Marathon;

public class Team {
    private String name;
    private Competitor[] teammates;

    Team (String name, Competitor ...arr) { // Конструтор с множественными параметрами
        if (arr.length > 0 & !name.isEmpty()) {
            this.name = name;
            teammates = new Competitor[arr.length];
            for (int i = 0; i < teammates.length; i ++) {
                teammates[i] = arr[i];
            }
        }
    }

    public void getTeamMembers () {
        System.out.println("Состав команды " + this.name + ": ");
        for (int i = 0; i < teammates.length; i ++) {
            teammates[i].info();
        }
    }

    public void getTeamSuccessfulMembers () {
        System.out.println("Участники, прошедшие всю полосу препятствий: ");
        for (int i = 0; i < teammates.length; i ++) {
            if (teammates[i].isOnDistance()) teammates[i].info();
        }
    }

    public Competitor[] getTeamList() { // Так как массив competitors приватный, то переопределим и вернем новый
        Competitor[] arr = new Competitor[teammates.length];
        for (int i = 0; i < teammates.length; i ++) {
            arr[i] = teammates[i];
        }
        return arr;
    }

}
