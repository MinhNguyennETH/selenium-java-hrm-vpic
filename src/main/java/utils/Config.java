package ultils;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static final String url_Vpic = dotenv.get("url_Vpic");
    public static final String username_Vpic = dotenv.get("username_Vpic");
    public static final String pasword_Vpic = dotenv.get("pasword_Vpic");
}
