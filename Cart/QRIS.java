package Cart;
public class QRIS implements PaymentStrategy {
    public boolean pay(AppContext app) {
        String temp = ("=========================================\n");
        temp += ("                 qris                    \n");
        temp += ("     NADI - GPN - PRIMA - BERSAMA        \n");
        temp += ("=========================================\n");
        temp += ("           MERCHANT MOCKUP ID            \n");

        // Pola QR Code Manual (Menggunakan karakter unicode block '██' dan ' ')
        // Ini adalah pola dummy yang menyerupai bentuk QR Code (terdapat tiga kotak
        // besar di sudut)
        String[] qrPattern = {
                "  ██████████  ██      ████  ██████████  ",
                "  ██      ██    ████    ██  ██      ██  ",
                "  ██  ██  ██  ████  ██      ██  ██  ██  ",
                "  ██  ██  ██    ██  ██████  ██  ██  ██  ",
                "  ██      ██  ██    ██      ██      ██  ",
                "  ██████████  ██  ██  ████  ██████████  ",
                "              ████████                  ",
                "  ██████  ██      ████  ████  ██    ██  ",
                "    ██      ████    ██████      ████    ",
                "  ████████  ██  ██      ████  ████████  ",
                "              ██  ████████  ██          ",
                "  ██████████  ████    ██      ████████  ",
                "  ██      ██    ██████████  ██      ██  ",
                "  ██  ██  ██  ██    ██  ██  ██  ██  ██  ",
                "  ██  ██  ██  ████      ██  ██  ██  ██  ",
                "  ██      ██    ████  ████  ██      ██  ",
                "  ██████████  ██  ████  ██  ██████████  "
        };

        // Print pola QR
        for (String line : qrPattern) {
            temp += (line);
        }

        // Footer ala QRIS
        temp += ("=========================================\n");
        temp += ("             NYAMEN (MANUAL)             \n");
        temp += ("         Aman, Nyaman, & Praktis         \n");
        temp += ("=========================================\n");
        System.out.println(temp);

        app.getInput().nextLine();
        return true;
    }
}
