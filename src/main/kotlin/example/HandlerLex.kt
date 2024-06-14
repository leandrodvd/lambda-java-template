package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.LexEvent

// Handler value: example.HandlerLex
class HandlerLex : RequestHandler<LexEvent, String> {
    override fun handleRequest(event: LexEvent, context: Context): String {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        return event.currentIntent.name
    }
}