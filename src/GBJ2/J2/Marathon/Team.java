package GBJ2.J2.Marathon;

public class Team {
    String name;
    Competitor[] competitors;

    Team (String name, Competitor ...arr) {
        if (arr.length > 0 & !name.isEmpty()) {
            this.name = name;
            competitors = new Competitor[arr.length];
            for (int i = 0; i < competitors.length; i ++) {
                competitors[i] = arr[i];
            }
        }
    }


}
