import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {
        String url = "https://example.com"; // Ваш URL для парсингу

        try {
            // Виконуємо HTTP запит і отримуємо HTML документ
            Document doc = Jsoup.connect(url).get();

            // Приклади вибору елементів за тегами
            Elements headers = doc.select("h1, h2, h3");
            Elements paragraphs = doc.select("p");
            Elements images = doc.select("img");

            // Виводимо знайдені елементи
            System.out.println("Headers:");
            for (Element header : headers) {
                System.out.println(header.text());
            }

            System.out.println("\nParagraphs:");
            for (Element paragraph : paragraphs) {
                System.out.println(paragraph.text());
            }

            System.out.println("\nImages:");
            for (Element image : images) {
                System.out.println(image.attr("src"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}