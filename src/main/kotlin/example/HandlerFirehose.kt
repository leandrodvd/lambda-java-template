package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.KinesisFirehoseEvent

// Handler value: example.HandlerFirehose
class HandlerFirehose : RequestHandler<KinesisFirehoseEvent, List<String>> {
    override fun handleRequest(event: KinesisFirehoseEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val recordIds = ArrayList<String>()
        for (record in event.records) {
            recordIds.add(record.recordId)
        }
        return recordIds
    }
}