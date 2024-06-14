package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.SNSEvent

// Handler value: example.HandlerSNS
class HandlerSNS : RequestHandler<SNSEvent, List<String>> {
    override fun handleRequest(event: SNSEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val messagesFound = ArrayList<String>()
        for (record in event.records) {
            val message = record.sns
            messagesFound.add(message.message)
        }
        return messagesFound
    }
}