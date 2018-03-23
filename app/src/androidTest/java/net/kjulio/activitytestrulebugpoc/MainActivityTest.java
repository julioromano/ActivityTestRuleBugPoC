package net.kjulio.activitytestrulebugpoc;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    private static final String TEST_STRING = "123abc";

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void finishWithResult() throws Exception {
        onView(withId(R.id.editText)).perform(typeText(TEST_STRING));
        onView(withId(R.id.button)).perform(click());
        final Instrumentation.ActivityResult result = rule.getActivityResult();
        assertEquals(Activity.RESULT_OK, result.getResultCode());
        assertEquals(TEST_STRING, MainActivity.extractExtraFromResultIntent(result.getResultData()));
    }

    @Test
    public void rotateAndFinishWithResult() throws Exception {
        rule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        rule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withId(R.id.editText)).perform(typeText(TEST_STRING));
        onView(withId(R.id.button)).perform(click());
        final Instrumentation.ActivityResult result = rule.getActivityResult();
        assertEquals(Activity.RESULT_OK, result.getResultCode());
        assertEquals(TEST_STRING, MainActivity.extractExtraFromResultIntent(result.getResultData()));
    }

}
