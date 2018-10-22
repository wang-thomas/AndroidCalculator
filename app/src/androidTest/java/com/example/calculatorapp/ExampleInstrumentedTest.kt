package com.example.calculatorapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun firstState() {
        // Context of the app under test.
        onView(withId(R.id.firstLine)).check(matches(withText("0.0")))
        onView(withId(R.id.secondLine)).check(matches(withText("0")))
    }

    @Test
    fun testMidClick() {
        // Context of the app under test.
        onView(withText("2")).perform(click())
        onView(withId(R.id.secondLine)).check(matches(withText("2")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.secondLine)).check(matches(withText("2+")))
    }

    @Test
    fun simplyOperation() {
        // Context of the app under test.
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("2")).perform(click())
        onView(withId(R.id.firstLine)).check(matches(withText("4.0")))
    }

    @Test
    fun testPointClick() {
        // Context of the app under test.
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("7")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText(".")).perform(click())
        onView(withId(R.id.firstLine)).check(matches(withText("4.7")))
    }

    @Test
    fun testEquals() {
        // Context of the app under test.
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("7")).perform(click())
        onView(withText("=")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("7")).perform(click())
        onView(withText("=")).perform(click())
        onView(withId(R.id.secondLine)).check(matches(withText("7.4")))
    }

    @Test
    fun testMultipleSigns() {
        // Context of the app under test.
        onView(withText("2")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText("-")).perform(click())
        onView(withText("2")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("7")).perform(click())
        onView(withText("+")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("5")).perform(click())
        onView(withText(".")).perform(click())
        onView(withText("3")).perform(click())
        onView(withText("=")).perform(click())
        onView(withId(R.id.secondLine)).check(matches(withText("10.0")))
        onView(withId(R.id.firstLine)).check(matches(withText("10.0")))
    }
}
