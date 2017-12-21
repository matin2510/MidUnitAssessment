package nyc.c4q.mustafizurmatin.midunitassessment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "onCretae";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, mainFragment);
        fragmentTransaction.commit();

        JSONObject newJsonWeAreMaking = new JSONObject();
        try {
            newJsonWeAreMaking.put("books", new JSONArray()
                    .put(new JSONObject()
                            .put("title", "Northanger Abbey")
                            .put("author", "Austen, Jane")
                            .put("year", 1814))
                    .put(new JSONObject()
                            .put("title", "War and Peace")
                            .put("author", "Tolstoy, Leo")
                            .put("year", 1865))
                    .put(new JSONObject()
                            .put("title", "Anna Karenina")
                            .put("author", "Tolstoy, Leo")
                            .put("year", 1875))
                    .put(new JSONObject()
                            .put("title", "Mrs. Dalloway")
                            .put("author", "Woolf, Virginia")
                            .put("year", 1925))
                    .put(new JSONObject()
                            .put("title", "The Hours")
                            .put("author", "Cunnningham, Michael")
                            .put("year", 1999))
                    .put(new JSONObject()
                            .put("title", "Huckleberry Finn")
                            .put("author", "Twain, Mark")
                            .put("year", 1865))
                    .put(new JSONObject()
                            .put("title", "Bleak House")
                            .put("author", "Dickens, Charles")
                            .put("year", 1870))

                    .put(new JSONObject()
                            .put("title", "Tom Sawyer")
                            .put("author", "Twain, Mark")
                            .put("year", 1862))


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonString = newJsonWeAreMaking.toString();

        Log.d(TAG, "onCreate: " + jsonString);
        try {
            JSONObject oldJsonWeAreParsing = new JSONObject(jsonString);
            JSONArray booksArrayList = oldJsonWeAreParsing.getJSONArray("family_members");
            List<Books> booksList = new ArrayList<>();

            for (int i = 0; i < booksArrayList.length(); i++) {
                Books books = new Books();


                books.setTitle((String) booksArrayList.getJSONObject(i).get("title"));
                books.setAuthor((String) booksArrayList.getJSONObject(i).get("author"));
                books.setYear((Integer) booksArrayList.getJSONObject(i).get("year"));
                booksList.add(books);
            }

            for (Books books : booksList) {
                Log.d(TAG, "onCreate: " +
                        "\nTitle - " + books.getTitle() +
                        "\nAuthor - " + books.getAuthor() +
                        "\nYear - " + books.getYear());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
