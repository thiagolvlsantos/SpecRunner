package example.concordion;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.runner.RunWith;
import org.specrunner.junit.SRRunner;

@RunWith(SRRunner.class)
public class TestVerifyRows2 {

    private List<Result> usernamesInSystem = new LinkedList<Result>();

    public void setUpUser(String first, String last) {
        Result r = new Result();
        r.firstName = first;
        r.lastName = last;
        usernamesInSystem.add(r);
    }

    public Iterable<Result> getSearchResultsFor(String searchString) {
        SortedSet<Result> matches = new TreeSet<Result>();
        for (Result username : usernamesInSystem) {
            if (username.lastName.contains(searchString)) {
                matches.add(username);
            }
        }
        // uncomment to text missing values
        // matches.clear();
        // uncomment to test extra values
        // Result r = new Result();
        // r.firstName = "thiago";
        // r.lastName = "santos";
        // matches.add(r);
        return matches;
    }
}