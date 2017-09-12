package com.quangleeit.itsecuritylearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.quangleeit.itsecuritylearning.courses.CoursesListFragment;
import com.quangleeit.itsecuritylearning.favorite.FavoriteFragment;
import com.quangleeit.itsecuritylearning.interview.InterviewFragment;
import com.quangleeit.itsecuritylearning.question.ContentQuestionActivity;
import com.quangleeit.itsecuritylearning.question.QuestionListFragment;
import com.quangleeit.itsecuritylearning.quiz.QuizListFragment;
import com.quangleeit.itsecuritylearning.teacher.TeachersFragment;
import com.quangleeit.itsecuritylearning.test.CateActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private NavigationView navigationView;

    private TextView txtUserName, txtEmail;

    private ImageView imgProfile;

    //private FirebaseAuth mAuth;
//
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // initFirebase();
        initCom();

        //Google logout

    }

    public void initCom() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
//        txtUserName = (TextView) header.findViewById(R.id.txtUsername);
//        txtEmail = (TextView) header.findViewById(R.id.txtEmail);
//        imgProfile = (ImageView) header.findViewById(R.id.imgProfile);

//        txtUserName.setText(user.getDisplayName().toString());
//        txtEmail.setText(user.getEmail().toString());
//        txtUserName.setText("Quang Lee");
//        txtEmail.setText("quanglee.it@gmail.com");


    }

//    public void initFirebase() {
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                if (firebaseAuth.getCurrentUser() == null) {
//                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                }
//            }
//        };
//
//        user = FirebaseAuth.getInstance().getCurrentUser();
//    }

    @Override
    protected void onStart() {
        super.onStart();
        startFragment(new CoursesListFragment());
        drawer.closeDrawers();
        //mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_course) {
            startFragment(new CoursesListFragment());
            //Toast.makeText(this, "FUCK YOU", Toast.LENGTH_SHORT).show();
            drawer.closeDrawers();

        }

        else if (id == R.id.nav_interview) {
            startFragment(new TeachersFragment());
            drawer.closeDrawers();

        }
//        else if (id == R.id.nav_quiz) {
//            Intent i = new Intent(MainActivity.this, CateActivity.class);
//            startActivity(i);
//
////            startFragment(new QuizListFragment());
//            drawer.closeDrawers();
//
//        }
//        else if (id == R.id.nav_favorite) {
//            startFragment(new FavoriteFragment());
//            drawer.closeDrawers();
        //}
        else if (id == R.id.nav_score) {


        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_signout) {
//            mAuth.signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void startFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        String fragmentTag = backStateName;

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.nav_contentframe, fragment, fragmentTag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


}
