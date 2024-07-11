import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class IslandPerimeter {

    public static void main(String [] args) {
        System.out.printf("Hello Island Perimeter Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java IslandPerimeter%n");
            return;
        }

        List<List<Integer>> island = new ArrayList<>();

        int [] row1 = new int [] {0, 1, 0, 0};
        List<Integer> list1 = Arrays.stream(row1).boxed().collect(Collectors.toList());
        island.add(list1);


        int [] row2 = new int [] {1, 1, 1, 0};
        List<Integer> list2 = Arrays.stream(row2).boxed().collect(Collectors.toList());
        island.add(list2);


        int [] row3 = new int [] {0, 1, 0, 0};
        List<Integer> list3 = Arrays.stream(row3).boxed().collect(Collectors.toList());
        island.add(list3);


        int [] row4 = new int [] {1, 1, 0, 0};
        List<Integer> list4 = Arrays.stream(row4).boxed().collect(Collectors.toList());
        island.add(list4);

        IslandPerimeter islandPerimeter = new IslandPerimeter();

        int result = islandPerimeter.calculatePerimeter(island);

        System.out.printf("the perimeter of the island is %d%n", result);

    }

    private static final int MAX_POSSIBLE_EDGES = 4;

    public int calculatePerimeter(List<List<Integer>> island) {

        if (island == null) return -1;
        if (island.size() == 0) return -1;
        if (island.get(0) == null) return -1;
        if (island.get(0).size() == 0) return -1;

        int m = island.size(); // number of rows, top to bottom
        int n = island.get(0).size(); // length of a given row, expect same length
        int perimeter = 0;

        for (int i = 0; i < m; i++) {

            // for the next row
            List<Integer> nextRow = island.get(i);

            for (int j = 0; j < n; j++) {

                // for the next cell in the next row
                int position = nextRow.get(j);

                // if it is water at this position then continue
                if (position == 0) continue;

                // otherwise, count edges to add to perimeter
                int edges = MAX_POSSIBLE_EDGES;

                // look left
                if (j > 0) {
                    if (island.get(i).get(j - 1) == 1) edges--;
                }

                // look right
                if (j < n - 1) {
                    if (island.get(i).get(j + 1) == 1) edges--; 
                }

                // look up
                if (i > 0) {
                    if (island.get(i - 1).get(j) == 1) edges--;
                }

                // look down
                if (i < m - 1) {
                    if (island.get(i + 1).get(j) == 1) edges--;
                }

                perimeter += edges;

            }

        }

        return perimeter;

    }

}
