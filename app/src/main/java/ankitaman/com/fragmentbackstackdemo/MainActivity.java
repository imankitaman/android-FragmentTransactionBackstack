package ankitaman.com.fragmentbackstackdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by ankit on 03/08/16.
 */
public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{


    private static final String FIRST_TAG = "fragA";
    private static final String SECOND_TAG = "fragB";
    private static final String THIRD_TAG = "fragC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FirstFragment firstFragment = new FirstFragment();
            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager.addOnBackStackChangedListener(this);
            fragmentManager.beginTransaction().replace(R.id.mainContainer, firstFragment).addToBackStack(FIRST_TAG).commit();
        }
    }

    public void addSecondFrag(View view) {
        SecondFragment secondFragment = new SecondFragment();
        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.addOnBackStackChangedListener(this);
        fragmentManager.beginTransaction().replace(R.id.mainContainer, secondFragment, SECOND_TAG).addToBackStack(SECOND_TAG).commit();
    }

    public void addThirdFrag(View view) {
        ThirdFragment thirdFragment = new ThirdFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, thirdFragment, THIRD_TAG).addToBackStack(THIRD_TAG).commit();
    }

    public void gotoFirstFrag(View view) {
        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.popBackStack(FIRST_TAG, 0);
//        fragmentManager.popBackStack(FIRST_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.popBackStackImmediate(FIRST_TAG,0);
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 1) {
            Log.e("back stack entry", fm.getBackStackEntryCount() + "");
            fm.popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void onBackStackChanged() {

    }
//    }


        /**
         * direct clean all and goto first fragment
         */
//        final FragmentManager fragmentManager = getFragmentManager();
//        while (fragmentManager.getBackStackEntryCount() != 1) {
//            fragmentManager.popBackStackImmediate();
//        }
//    }
}
