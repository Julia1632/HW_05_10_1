package com.example.mycalculator;


import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CalculatorActivityTest {

    private ActivityTestRule<CalculatorActivity> calculatorActivity = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void testActivityRun() {
        calculatorActivity.launchActivity(new Intent());

        ViewInteraction calculateButtonEq = onView(withId(R.id.button_eq_button));
        calculateButtonEq.check(matches(isDisplayed()));

        ViewInteraction calculateButtonPl = onView(withId(R.id.button_plus_button));
        calculateButtonPl.check(matches(isDisplayed()));

        onView(withId(R.id.input_txt_edit_text)).perform(typeText("1"));

        calculateButtonPl.perform(click());
        onView(withId(R.id.input_txt_edit_text)).perform(typeText("3"));
        calculateButtonEq.perform(click());

        onView(withId(R.id.output_text_text_view)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if(!((TextView)view).getText().toString().equals("4")) {
                    throw new IllegalStateException("Result wrong. Expected 4");
                }
            }
        });
    }
}
