import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankServer {
    // Declare SavingsAccount and CreditCardAccount instances
    private static SavingsAccount savingsAccount = new SavingsAccount("Ananya", 1000.0);
    private static CreditCardAccount creditCardAccount = new CreditCardAccount("Ananya", 5000.0);

    public static void main(String[] args) throws IOException {
HttpServer server = HttpServer.create(new java.net.InetSocketAddress("0.0.0.0", 8080), 0);

        // Serve index.html
        server.createContext("/", (exchange) -> {
            Path filePath = Path.of("index.html");
            if (Files.exists(filePath)) {
                byte[] fileBytes = Files.readAllBytes(filePath);
                exchange.getResponseHeaders().add("Content-Type", "text/html"); // Correct MIME type
                exchange.sendResponseHeaders(200, fileBytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(fileBytes);
                os.close();
            } else {
                String response = "404 Not Found";
                exchange.getResponseHeaders().add("Content-Type", "text/plain"); // Plain text for errors
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Savings balance endpoint
        server.createContext("/savings/balance", (exchange) -> {
            String response = "Savings Account Balance: $" + savingsAccount.getBalance();
            sendResponse(exchange, response);
        });

        // Credit card balance endpoint
        server.createContext("/credit/balance", (exchange) -> {
            String response = "Credit Card Balance: $" + creditCardAccount.getBalance();
            sendResponse(exchange, response);
        });

        // Savings deposit endpoint
        server.createContext("/savings/deposit", (exchange) -> {
            try {
                double amount = Double.parseDouble(exchange.getRequestURI().getQuery().split("=")[1]);
                savingsAccount.deposit(amount);
                sendResponse(exchange, "Deposited $" + amount + " into Ananya's Savings Account");
            } catch (Exception e) {
                sendResponse(exchange, "Invalid request: " + e.getMessage());
            }
        });

        // Start the server
        server.setExecutor(null);
        server.start();
        System.out.println("Server is running on SWAGM Financial at http://localhost:8080");
    }

    // Utility method to send HTTP responses
    private static void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        byte[] responseBytes = response.getBytes();
        exchange.sendResponseHeaders(200, responseBytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBytes);
        }
    }
}

