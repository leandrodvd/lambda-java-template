package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.S3Event

// Handler value: example.Handler
class HandlerS3 : RequestHandler<S3Event, String> {
    override fun handleRequest(event: S3Event, context: Context): String {
        val logger = context.logger
        val record = event.records[0]
        val srcBucket = record.s3.bucket.name
        // Object key may have spaces or unicode non-ASCII characters.
        val srcKey = record.s3.getObject().urlDecodedKey
        logger.log("RECORD: $record")
        logger.log("SOURCE BUCKET: $srcBucket")
        logger.log("SOURCE KEY: $srcKey")
        // log execution details
        return "$srcBucket/$srcKey"
    }
}