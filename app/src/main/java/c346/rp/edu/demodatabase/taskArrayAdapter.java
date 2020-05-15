package c346.rp.edu.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class taskArrayAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvDisplayid;
    private TextView tvDisplayDesc;
    private TextView tvDisplayDate;

    public taskArrayAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        task = objects;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvDisplayid = (TextView)rowView.findViewById(R.id.tvId);
        tvDisplayDesc = (TextView)rowView.findViewById(R.id.tvDesc);
        tvDisplayDate = (TextView) rowView.findViewById(R.id.tvDate);

        Task tasks = task.get(position);

        tvDisplayid.setText(tasks.get_id() + "");
        tvDisplayDesc.setText(tasks.getDescription());
        tvDisplayDate.setText(tasks.getDate() + "");

        return rowView;

    }
}
