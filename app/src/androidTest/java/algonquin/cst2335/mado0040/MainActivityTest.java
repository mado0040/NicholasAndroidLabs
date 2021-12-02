package algonquin.cst2335.mado0040;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class MainActivityTest<ActivityTestRule> {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is not complex enough!")));
    }

    @Test
    public void testFindMissingUppercase() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("password123#$*"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is not complex enough!")));
    }
    @Test
    public void testFindMissingLowercase() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("PASSWORD123#$*"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is not complex enough!")));
    }
    @Test
    public void testFindMissingNumbers() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("Password#$*"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is not complex enough!")));
    }
    @Test
    public void testFindMissingSpecials() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("Password1"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is not complex enough!")));
    }
    @Test
    public void testFindPerfectPassword() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));

        appCompatEditText.perform(replaceText("Password12345!"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));

        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));

        textView.check(matches(withText("Your password is complex enough.")));
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
