package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.google.gson.Gson
import com.google.gson.GsonBuilder

// Handler value: example.HandleKinesis
class HandlerKinesis : RequestHandler<KinesisEvent, List<String>> {
    var gson: Gson = GsonBuilder().setPrettyPrinting().create()

    override fun handleRequest(event: KinesisEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val dataRecords = ArrayList<String>()
        for (record in event.records) {
            dataRecords.add(gson.toJson(record.kinesis.data))
        }
        return dataRecords
    }
}