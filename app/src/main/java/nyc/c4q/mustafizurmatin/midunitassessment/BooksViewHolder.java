package nyc.c4q.mustafizurmatin.midunitassessment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 12/20/17.
 */

public class BooksViewHolder  extends   RecyclerView.ViewHolder{
    TextView title;
    TextView year;

    public BooksViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.article_title);
        year=(TextView) itemView.findViewById(R.id.article_date);

    }


    public void onBind(Books books) {
    }
}
