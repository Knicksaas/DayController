package android.nte.ch.daycontroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainListElementAdapter extends ArrayAdapter<MainListElement> {

    private static final String TAG = "MainListElementAdapter";
    private Context context;
    private int resource;

    public MainListElementAdapter(Context context, int resource, ArrayList<MainListElement> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String text = getItem(position).getText();
        int id = getItem(position).getId();

        MainListElement element = new MainListElement(text, id);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.main_list_text);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.main_list_img);

        textView.setText(text);
        imageView.setImageResource(id);

        return convertView;
    }
}
