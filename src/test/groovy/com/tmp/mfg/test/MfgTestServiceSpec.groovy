package com.tmp.mfg.test



import io.micronaut.context.ApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Specification

class MfgTestServiceSpec extends Specification {

    @AutoCleanup ApplicationContext context

    MfgTestService service

    void setup() {
        context = ApplicationContext.build('test').build()
        // TODO: register mock collaborators
        // context.registerSingleton(Foo, fooMock)
        context.start()

        service = context.getBean(MfgTestService)
    }

    void 'handle event'() {
        given:
            MfgTestRequest event = new MfgTestRequest()
            MfgTestResponse expectedOutput = new MfgTestResponse()
        when:
            MfgTestResponse output = service.handle(event)
        then:
            thrown UnsupportedOperationException

            // TODO: verify output
            // output == expectedOutput
    }

}