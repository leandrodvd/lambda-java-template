package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.CloudWatchLogsEvent
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.zip.GZIPInputStream

// Handler value: example.HandlerCWLogs
class HandlerCWLogs : RequestHandler<CloudWatchLogsEvent, String> {
    override fun handleRequest(event: CloudWatchLogsEvent, context: Context): String {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val decoder = Base64.getDecoder()
        val decodedEvent = decoder.decode(event.awsLogs.data)
        val output = StringBuilder()
        try {
            val inputStream = GZIPInputStream(ByteArrayInputStream(decodedEvent))
            val inputStreamReader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
            val bufferedReader = BufferedReader(inputStreamReader)
            bufferedReader.lines().forEach { line: String? ->
                output.append(line)
            }
            // logger.info(output.toString());
        } catch (e: IOException) {
            logger.log("ERROR: $e")
        }
        return output.toString()
    }
}
