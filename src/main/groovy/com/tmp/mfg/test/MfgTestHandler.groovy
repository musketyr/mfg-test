package com.tmp.mfg.test



import groovy.transform.CompileStatic
import groovy.transform.InheritConstructors
import io.micronaut.function.executor.FunctionInitializer
import io.micronaut.function.FunctionBean

import javax.inject.Inject
import java.util.function.Function

@CompileStatic
@FunctionBean(
        value = 'mfg-test',
        method = 'apply'
)
@InheritConstructors
class MfgTestHandler extends FunctionInitializer implements Function<MfgTestRequest, MfgTestResponse> {

    @Inject MfgTestService mfgTestService

    @Override
    MfgTestResponse apply(MfgTestRequest event) {
         return mfgTestService.handle(event)
    }

    /**
     * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar
     * where the argument to echo is the JSON to be parsed.
     */
    static void main(String...args) throws IOException {
        MfgTestHandler function = new MfgTestHandler()
        function.run(args, { context -> function.apply(context.get(MfgTestRequest.class)) })
    }
}