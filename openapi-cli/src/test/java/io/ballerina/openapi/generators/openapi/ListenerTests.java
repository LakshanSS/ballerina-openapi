/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerina.openapi.generators.openapi;

import io.ballerina.openapi.converter.OpenApiConverterException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This Tests class for storing all the endpoint related tests
 * {@link io.ballerina.openapi.converter.service.OpenAPIEndpointMapper}.
 */
public class ListenerTests {
    private static final Path RES_DIR = Paths.get("src/test/resources/ballerina-to-openapi/").toAbsolutePath();
    private Path tempDir;

    @BeforeMethod
    public void setup() throws IOException {
        this.tempDir = Files.createTempDirectory("bal-to-openapi-test-out-" + System.nanoTime());
    }
    //Listeners
    @Test(description = "Generate OpenAPI spec for single listener")
    public void testListeners01() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario01.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario01.yaml");
    }

    @Test(description = "Generate OpenAPI spec for listner only have port")
    public void testListeners02() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario02.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario02.yaml");
    }

    @Test(description = "Generate OpenAPI spec for multiple listners")
    public void testListeners03() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario03.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario03.yaml");
    }

    @Test(description = "Generate OpenAPI spec for ExplicitNewExpressionNode listeners")
    public void testListeners04() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario04.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario04.yaml");
    }

    @Test(description = "Generate OpenAPI spec for multiple listeners")
    public void testListeners05() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario05.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario05.yaml");
    }

    @Test(description = "When given ballerina file contain some compilation issue.",
            expectedExceptions = OpenApiConverterException.class,
            expectedExceptionsMessageRegExp = "Given ballerina file has syntax/compilation error.")
    public void testListeners06() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_scenario06.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/listener_scenario06.yaml");
    }

    @Test(description = "Generate OpenAPI spec for http load balancer listeners")
    public void testListeners07() throws OpenApiConverterException, IOException {
        Path ballerinaFilePath = RES_DIR.resolve("listeners/listener_http_load_balancer.bal");
        new TestUtils().compareWithGeneratedFile(ballerinaFilePath, "listeners/with_check_key_word.yaml");
    }

    @AfterMethod
    public void cleanUp() {
        TestUtils.deleteDirectory(this.tempDir);
    }

    @AfterTest
    public void clean() {
        System.setErr(null);
        System.setOut(null);
    }

}
