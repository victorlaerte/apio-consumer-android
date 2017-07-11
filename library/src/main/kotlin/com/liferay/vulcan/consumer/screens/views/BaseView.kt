package com.liferay.vulcan.consumer.screens.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.liferay.vulcan.consumer.model.Thing
import com.liferay.vulcan.consumer.screens.Event
import com.liferay.vulcan.consumer.screens.ThingScreenlet
import com.liferay.vulcan.consumer.screens.ViewModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * @author Alejandro Hernández
 */
abstract class BaseView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs), ViewModel, AnkoLogger {

    var screenlet: ThingScreenlet? = null

    fun <T> sendEvent(event: Event<T>): T? = screenlet?.onEventFor(event)

    override var thing: Thing? = null

    override fun showError(message: String?) {
        error { "Error loading the thing " + message }
    }

}