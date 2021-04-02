package td.nhan.lab01_exe02_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import td.nhan.lab01_exe02_listview.model.Job;

public class JobAdapter extends ArrayAdapter {
    private final List<Job> jobList;

    public JobAdapter(@NonNull Context context, List<Job> jobList, int textViewResourceId) {
        super(context, textViewResourceId, jobList);
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Job job = jobList.get(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        ImageView imageView = convertView.findViewById(R.id.item_img);
        TextView name = convertView.findViewById(R.id.item_name);
        TextView dateCreated = convertView.findViewById(R.id.item_dateCreate);
        Button button = convertView.findViewById(R.id.item_delete);
        button.setOnClickListener(v -> {
            jobList.remove(position);
            notifyDataSetChanged();
        });

        imageView.setImageResource(job.getResImg());
        name.setText(job.getName());
        dateCreated.setText(job.getDateCreated());

        return convertView;
    }

}
