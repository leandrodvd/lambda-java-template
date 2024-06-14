package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.SQSEvent

// Handler value: example.HandlerSQS
class HandlerSQS : RequestHandler<SQSEvent, List<String>> {
    override fun handleRequest(event: SQSEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val messagesFound = ArrayList<String>()
        for (msg in event.records) {
            messagesFound.add(msg.body)
        }
        return messagesFound
    }
}
