package com.tmp.mfg.test



import spock.lang.AutoCleanup
import spock.lang.Specification

class MfgTestHandlerSpec extends Specification {

    MfgTestService service = Mock(MfgTestService)

    @AutoCleanup MfgTestHandler handler = new MfgTestHandler()

    void setup() {
        handler.mfgTestService = service
    }

    void 'handle event'() {
        given:
            MfgTestRequest event = new MfgTestRequest()
            MfgTestResponse expectedOutput = new MfgTestResponse()
        when:
            MfgTestResponse output = handler.apply(event)
        then:
            output.is expectedOutput

            1 * service.handle(event) >> expectedOutput
    }

}