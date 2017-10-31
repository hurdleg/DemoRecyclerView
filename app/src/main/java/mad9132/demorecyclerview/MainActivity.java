package mad9132.demorecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mad9132.demorecyclerview.model.CoursePOJO;

// TODO #8 - change MainActivity
/**
 * Demonstrate Android's RecyclerView.
 *
 * The activity_main.xml (res > layout) features a <RecyclerView> widget.
 *
 * A RecyclerView is a container for displaying large data sets that can be scrolled very efficiently
 * my maintaining a limited number of views. Use the RecyclerView widget when you have data
 * collections whose elements change at runtime based on user action or network events.
 *
 * The RecyclerView class simplifies the data and handling of large data sets by providing a layout
 * managers for positioning items.
 *
 * To use the RecyclerView widget, you have to specify an adapter and layout manager. To create an
 * adapter, extend the RecyclerView.Adapter class. See class CourseAdapter.java
 *
 * See activity_main.xml for the layout manager.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class MainActivity extends Activity {

    private CourseAdapter mAdapter;
    private RecyclerView  mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // collection of course objects; use an ArrayList, with each element of type CoursePOJO
        ArrayList<CoursePOJO> courseArrayList = new ArrayList<>();

        // instantiate a new CoursePOJO object
        CoursePOJO aCourse = new CoursePOJO();
        // set properties of course
        aCourse.setCourseId(1);
        aCourse.setCode("MAD9014");
        aCourse.setName("Cross-Platform Application Development I");
        aCourse.setDescription("Let's learn JavaScript!");
        aCourse.setLevel(1);
        // add course to collection
        courseArrayList.add(aCourse);

        aCourse = new CoursePOJO();
        aCourse.setCourseId(2);
        aCourse.setCode("MAD9021");
        aCourse.setName("Intro to Object-Oriented Programming");
        aCourse.setDescription("Let's learn OO!");
        aCourse.setLevel(2);
        courseArrayList.add(aCourse);

        aCourse = new CoursePOJO();
        aCourse.setCourseId(3);
        aCourse.setCode("MAD9132");
        aCourse.setName("Android Application Development");
        aCourse.setDescription("Let's write native Android apps with Java!");
        aCourse.setLevel(3);
        courseArrayList.add(aCourse);

        aCourse = new CoursePOJO();
        aCourse.setCourseId(4);
        aCourse.setCode("MAD9145");
        aCourse.setName("Applied Project");
        aCourse.setDescription("It's Go time!");
        aCourse.setLevel(4);
        courseArrayList.add(aCourse);

        // reference the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rvCourses);

        // instantiate the Adapter
        // pass in this Activity's Context, and the collection of CoursePOJO objects
        mAdapter = new CourseAdapter(this, courseArrayList);

        // replace the RecyclerView's adapter with ours
        mRecyclerView.setAdapter(mAdapter);
    }
}
