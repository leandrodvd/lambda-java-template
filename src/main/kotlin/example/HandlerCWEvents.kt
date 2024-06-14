package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent

// Handler value: example.HandlerCWEvents
class HandlerCWEvents : RequestHandler<ScheduledEvent, List<String>> {
    override fun handleRequest(event: ScheduledEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val resourcesFound = ArrayList<String>()
        for (resource in event.resources) {
            resourcesFound.add(resource)
        }
        return resourcesFound
    }
}