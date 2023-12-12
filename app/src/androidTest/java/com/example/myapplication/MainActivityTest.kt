package com.example.myapplication

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityTest = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAuth() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.login)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.login)).perform(ViewActions.typeText("login"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.password)).perform(ViewActions.typeText("12345"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.result)).check(matches(ViewMatchers.withText("Success!")))
    }
}