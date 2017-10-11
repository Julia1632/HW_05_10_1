package com.example.mycalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CalculatorActivityTestUnit {

    private ActivityController<CalculatorActivity> activityController;

    @Before
    public void init(){
        activityController= Robolectric.buildActivity(CalculatorActivity.class);
    }
//TODO please move activity methods in init-method
    @Test
    public void testCalculator() {
        activityController.create();
        activityController.start();
        activityController.resume();


        CalculatorActivity calculatorActivity = activityController.get();

        boolean isCalculateEditTextEnable=calculatorActivity.findViewById(R.id.input_txt_edit_text).isEnabled();
        assertEquals(isCalculateEditTextEnable,true);


        boolean isCalculateButtonEqEnabled = calculatorActivity.findViewById(R.id.button_eq_button).isEnabled();
        assertEquals(isCalculateButtonEqEnabled, false);


        boolean isCalculateButtonPlEnabled = calculatorActivity.findViewById(R.id.button_plus_button).isEnabled();
        assertEquals(isCalculateButtonPlEnabled, false);

        boolean isCalculateButtonMinEnabled = calculatorActivity.findViewById(R.id.button_minus_button).isEnabled();
        assertEquals(isCalculateButtonMinEnabled, false);

        boolean isCalculateButtonMulEnabled = calculatorActivity.findViewById(R.id.button_mult_button).isEnabled();
        assertEquals(isCalculateButtonMulEnabled, false);

        boolean isCalculateButtonDivEnabled = calculatorActivity.findViewById(R.id.button_div_button).isEnabled();
        assertEquals(isCalculateButtonDivEnabled, false);


    }


}
