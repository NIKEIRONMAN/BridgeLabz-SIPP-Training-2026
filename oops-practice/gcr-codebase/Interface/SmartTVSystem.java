interface StreamingService {
    void streamContent();

    default void showSubscriptionDetails() {
        System.out.println("StreamingService subscription: premium streaming access.");
    }
}

interface GamingService {
    void playGames();

    default void showSubscriptionDetails() {
        System.out.println("GamingService subscription: gaming access enabled.");
    }
}

class SmartTV implements StreamingService, GamingService {
    private final String[] movies;
    private final String[] games;

    SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamContent() {
        System.out.println("Movies available:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
    }

    @Override
    public void playGames() {
        System.out.println("Games available:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("SmartTV subscription conflict resolved using an override.");
    }
}

public class SmartTVSystem {
    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "The Dark Knight"};
        String[] games = {"Racing Rush", "Space Quest", "Puzzle World"};
        SmartTV tv = new SmartTV(movies, games);

        tv.showSubscriptionDetails();
        tv.streamContent();
        tv.playGames();
    }
}
