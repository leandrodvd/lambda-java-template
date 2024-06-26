package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent

// Handler value: example.Handler
class HandlerApiGatewayV1 : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    override fun handleRequest(event: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val response = APIGatewayProxyResponseEvent()
        response.isBase64Encoded = false
        response.statusCode = 200
        val headers = HashMap<String, String>()
        headers["Content-Type"] = "text/html"
        response.headers = headers
        val body = if (event.body != null) event.body else "Empty body"
        response.body = "<!DOCTYPE html><html><head><title>" + body + "</title></head><body>" +
                "<h1>Welcome</h1><p>Page generated by a Lambda function.</p>" + "</body></html>"
        return response
    }
}