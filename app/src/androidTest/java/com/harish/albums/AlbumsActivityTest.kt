package com.harish.albums

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.harish.albums.ui.AlbumsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumsActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<AlbumsActivity>()

    @get:Rule
    var activityRule: ActivityScenarioRule<AlbumsActivity>
            = ActivityScenarioRule(AlbumsActivity::class.java)

    @Test
    fun activityStartsSuccessfully() {
        ActivityScenario.launch(AlbumsActivity::class.java)
    }

    @Test
    fun activityShowsTheAlbumTitles() {
        ActivityScenario.launch(AlbumsActivity::class.java)

        composeTestRule.onNode(hasText("aut aut architecto"))
    }

}