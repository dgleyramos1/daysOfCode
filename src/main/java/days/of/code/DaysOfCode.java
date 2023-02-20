/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package days.of.code;

import java.util.List;

import days.of.code.model.Item;
import days.of.code.service.Service;

/**
 *
 * @author dgley
 */
public class DaysOfCode {

    public static void main(String[] args) throws Exception {

        Service service = new Service("https://imdb-api.com/en/API/Top250Movies/k_014r9k2h");

        List<Item> movies = service.searcheMovies();
        System.out.println(movies.get(0));

    }
}
