package days.of.code.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import days.of.code.model.Item;

public class HtmlGenerator implements AutoCloseable {

  private final PrintWriter writer;

  public HtmlGenerator(String fileName) throws FileNotFoundException {
    this.writer = new PrintWriter(fileName);
  }

  private String readFileInResourcesPath(String fileName) throws IOException {
    Path filePath = Path.of("src", "main", "resources", "html", fileName);

    return Files.readString(filePath);
  }

  public void generate(List<Item> Movies) throws IOException {
    String head = readFileInResourcesPath("head.txt");
    String divTemplate = readFileInResourcesPath("divTemplate.txt");

    writer.println(head);
    String cards = "";

    for (Item movie : Movies) {
      String title = movie.getTitle();
      String urlImage = movie.getImage();
      String rating = movie.getImDbRating();
      String year = movie.getYear();

      cards += String.format(divTemplate, urlImage, title, title, rating, year);
    }

    String container = "<div class='container'><div class='row movies'>" + cards + "</div></div>";
    writer.println(container);
  }

  @Override
  public void close() {
    writer.close();
  }
}