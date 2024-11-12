package net.tp3.videoservice.exceptions;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Collections;
import java.util.Map;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return env.getField().getSourceLocation() != null ?
                        Collections.singletonList(env.getField().getSourceLocation()) :
                        null;
            }

            @Override
            public ErrorClassification getErrorType() {
                return ErrorType.DataFetchingException;
            }

            @Override
            public Map<String, Object> getExtensions() {
                return Map.of("path", env.getExecutionStepInfo().getPath().toString());
            }
        };
    }
}
