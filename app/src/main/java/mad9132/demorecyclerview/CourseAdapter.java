package mad9132.demorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mad9132.demorecyclerview.model.CoursePOJO;

// TODO #7 - add Adapter class
/**
 * CourseAdapter. A specialized Recycler.Adapter
 *
 * The adapter provides access to the items in your data set (Courses in this example), creates views
 * for items, and replaces the content of some views with new data items when the original item is
 * no longer visible.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context          mContext;
    private List<CoursePOJO> mCourses;

    /**
     * Constructor.
     *
     * @param context - the context of this adapter
     * @param courses - the list of courses managed by this adapter
     */
    public CourseAdapter(Context context, List<CoursePOJO> courses) {
        this.mContext = context;
        this.mCourses = courses;
    }

    /**
     * Create new ViewHolder of a Course. Invoked by the Layout Manger.
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View planetView = inflater.inflate(R.layout.course_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(planetView);
        return viewHolder;
    }

    /**
     * Replace the contents of a ViewHolder. Invoked by the Layout Manager.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CourseAdapter.ViewHolder holder, final int position) {
        final CoursePOJO aCourse = mCourses.get(position);

        holder.tvCode.setText(aCourse.getCode());
        holder.tvName.setText(aCourse.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Selected Course: " + aCourse.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Return the size of the dataset. Invoked by the Layout Manager.
     * @return
     */
    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    /**
     * Provide a reference to the view for each data item (a Course)
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View     mView;
        public TextView tvCode;
        public TextView tvName;

        public ViewHolder(View courseView) {
            super(courseView);

            mView = courseView;

            tvCode = (TextView) courseView.findViewById(R.id.courseCodeText);
            tvName = (TextView) courseView.findViewById(R.id.courseNameText);
        }
    }
}
