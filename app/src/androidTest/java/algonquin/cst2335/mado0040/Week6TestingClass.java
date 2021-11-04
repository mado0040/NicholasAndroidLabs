package algonquin.cst2335.mado0040;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Week6TestingClass {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    // Unit test:
    @Test
    public void week6TestingClass() {

        // Finding an object on screen:            // Find the view:
        ViewInteraction appCompatEditText = onView(withId(R.id.editText) );

        // Replacing with "12345" on the editText.
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        // Finding a new view:
        ViewInteraction materialButton = onView(withId(R.id.button));

        // Clicking the mouse on view R.id.button:
        materialButton.perform(click());

        // Click back on the editText
        appCompatEditText.perform(click());

        // Typing in new text:
        appCompatEditText.perform(replaceText("123"));

        appCompatEditText.perform(closeSoftKeyboard());

        ViewInteraction textView = onView(withId(R.id.textView));

        // Assertion:
        textView.check(matches(withText("Type in your password:")));

        // Change to check that same of "Login":
        ViewInteraction button = onView(withId(R.id.button));
        button.check(matches(withText("Login")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
