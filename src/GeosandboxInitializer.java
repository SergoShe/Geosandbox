public class GeosandboxInitializer {
    public static void main(String[] args) {
        try {
            Geosandbox geosandbox = new Geosandbox();
            geosandbox.start();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect symbol. Choose the number");
        }
    }
}