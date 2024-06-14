package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.ConfigEvent

// Handler value: example.HandlerConfig
class HandlerConfig : RequestHandler<ConfigEvent, String> {
    override fun handleRequest(event: ConfigEvent, context: Context): String {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        return event.configRuleArn
    }
}