package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent

// Handler value: example.HandlerDynamoDB
class HandlerDynamoDB : RequestHandler<DynamodbEvent, List<String>> {
    override fun handleRequest(event: DynamodbEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val operationsFound = ArrayList<String>()
        for (record in event.records) {
            operationsFound.add(record.eventName)
        }
        return operationsFound
    }
}