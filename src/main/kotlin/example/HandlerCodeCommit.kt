package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.CodeCommitEvent

// Handler value: example.HandlerCodeCommit
class HandlerCodeCommit : RequestHandler<CodeCommitEvent, List<String>> {
    override fun handleRequest(event: CodeCommitEvent, context: Context): List<String> {
        val logger = context.logger
        logger.log("EVENT TYPE: " + event.javaClass.toString())
        val commitsFound = ArrayList<String>()
        for (record in event.records) {
            val commit = record.codeCommit
            for (reference in commit.references) {
                commitsFound.add(reference.commit)
            }
        }
        return commitsFound
    }
}