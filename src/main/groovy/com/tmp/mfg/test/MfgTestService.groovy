package com.tmp.mfg.test



import com.agorapulse.micronaut.log4aws.LogError

import groovy.transform.CompileStatic

import javax.inject.Singleton

@Singleton
@CompileStatic
class MfgTestService {

    @LogError
    MfgTestResponse handle(MfgTestRequest event) {
        // TODO: implement
        throw new UnsupportedOperationException('TODO: implement')
    }

}