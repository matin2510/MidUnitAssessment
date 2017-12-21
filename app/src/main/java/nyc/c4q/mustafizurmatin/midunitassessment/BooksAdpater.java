package nyc.c4q.mustafizurmatin.midunitassessment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by c4q on 12/20/17.
 */

public class BooksAdpater extends RecyclerView.Adapter<BooksViewHolder>  {
    private  List<Books> booksList;
    private Context context;

    public BooksAdpater(List<Books> booksList, Context context) {
        this.booksList = booksList;
        this.context = context;
    }


        @Override

        public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
            return new BooksViewHolder(view);
        }

    @Override
    public void onBindViewHolder(BooksViewHolder holder, int position) {
        ((BooksViewHolder) holder).onBind(booksList.get(position));
    }



        @Override
        public int getItemCount() {
            return booksList.size();
        }

    }

