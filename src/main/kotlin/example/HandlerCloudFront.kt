package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.CloudFrontEvent

// Handler value: example.HandlerCloudFront
class HandlerCloudFront : RequestHandler<CloudFrontEvent, List<String>> {
    override fun handleRequest(event: CloudFrontEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val urisFound = ArrayList<String>()
        for (record in event.records) {
            val cfBody = record.cf
            urisFound.add(cfBody.request.uri)
        }
        return urisFound
    }
}