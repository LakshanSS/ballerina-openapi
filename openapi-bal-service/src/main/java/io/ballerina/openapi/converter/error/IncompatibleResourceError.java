/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.openapi.converter.error;

import io.ballerina.tools.diagnostics.DiagnosticSeverity;
import io.ballerina.tools.diagnostics.Location;

/**
 * {@code IncompatibleResourceError} represents the error that OAS not compatible with ballerina implementation.
 *
 * @since 2.0.0
 */
public class IncompatibleResourceError extends OpenAPIConverterError {
    private DiagnosticSeverity diagnosticSeverity;
    private String message;
    private String code;
    private Location location;

    public IncompatibleResourceError(DiagnosticSeverity diagnosticSeverity, String message, String code,
                                     Location location) {

        this.diagnosticSeverity = diagnosticSeverity;
        this.message = message;
        this.code = code;
        this.location = location;
    }

    public DiagnosticSeverity getDiagnosticSeverity() {
        return diagnosticSeverity;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Location getLocation() {
        return location;
    }
}
