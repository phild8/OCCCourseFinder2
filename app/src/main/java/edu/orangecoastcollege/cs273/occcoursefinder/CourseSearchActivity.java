package edu.orangecoastcollege.cs273.occcoursefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CourseSearchActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Instructor> allInstructorsList;
    private List<Course> allCoursesList;
    private List<Offering> allOfferingsList;
    private List<Offering> filteredOfferingsList;

    private EditText courseTitleEditText;
    private Spinner instructorSpinner;
    private ListView offeringsListView;

    private OfferingListAdapter offeringListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_search);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importCoursesFromCSV("courses.csv");
        db.importInstructorsFromCSV("instructors.csv");
        db.importOfferingsFromCSV("offerings.csv");

        allOfferingsList = db.getAllOfferings();
        filteredOfferingsList = new ArrayList<>(allOfferingsList);
        allInstructorsList = db.getAllInstructors();
        allCoursesList = db.getAllCourses();

        courseTitleEditText = (EditText) findViewById(R.id.courseTitleEditText);
        instructorSpinner = (Spinner) findViewById(R.id.instructorSpinner);


        offeringsListView = (ListView) findViewById(R.id.offeringsListView);
        offeringListAdapter =
                new OfferingListAdapter(this, R.layout.offering_list_item, filteredOfferingsList);
        offeringsListView.setAdapter(offeringListAdapter);


        //TODO (1): Construct instructorSpinnerAdapter using the method getInstructorNames()
        //TODO: to populate the spinner.


    }

    //TODO (2): Create a method getInstructorNames that returns a String[] containing the entry
    //TODO: "[SELECT INSTRUCTOR]" at position 0, followed by all the full instructor names in the
    //TODO: allInstructorsList


    //TODO (3): Create a void method named reset that sets the test of the edit text back to an
    //TODO: empty string, sets the selection of the Spinner to 0 and clears out the offeringListAdapter,
    //TODO: then rebuild it with the allOfferingsList



    //TODO (4): Create a TextWatcher named courseTitleTextWatcher that will implement the onTextChanged method.
    //TODO: In this method, set the selection of the instructorSpinner to 0, then
    //TODO: Clear the offeringListAdapter
    //TODO: If the entry is an empty String "", the offeringListAdapter should addAll from the allOfferingsList
    //TODO: Else, the offeringListAdapter should add each Offering whose course title starts with the entry.



    //TODO (5): Create an AdapterView.OnItemSelectedListener named instructorSpinnerListener and implement
    //TODO: the onItemSelected method to do the following:
    //TODO: If the selectedInstructorName != "[Select Instructor]", clear the offeringListAdapter,
    //TODO: then rebuild it with every Offering that has an instructor whose full name equals the one selected.
}
