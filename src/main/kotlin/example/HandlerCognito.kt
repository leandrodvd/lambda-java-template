package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.CognitoEvent

// Handler value: example.HandlerCognito
class HandlerCognito : RequestHandler<CognitoEvent, List<String>> {
    override fun handleRequest(event: CognitoEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val operationsFound = ArrayList<String>()
        for (record in event.datasetRecords.values) {
            operationsFound.add(record.op)
        }
        return operationsFound
    }
}