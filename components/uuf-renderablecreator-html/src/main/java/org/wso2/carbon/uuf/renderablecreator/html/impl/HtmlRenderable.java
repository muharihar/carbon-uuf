/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.uuf.renderablecreator.html.impl;

import org.wso2.carbon.uuf.core.API;
import org.wso2.carbon.uuf.core.Lookup;
import org.wso2.carbon.uuf.core.RequestLookup;
import org.wso2.carbon.uuf.spi.Renderable;
import org.wso2.carbon.uuf.spi.model.Model;

import java.nio.file.Path;
import java.util.Objects;

public class HtmlRenderable implements Renderable {
    private final Path absoluteFilePath;
    private final String htmlFileContent;
    private final Path relativeFilePath;

    public HtmlRenderable(Path absoluteFilePath, Path relativeFilePath, String htmlFileContent) {
        this.absoluteFilePath = absoluteFilePath;
        this.relativeFilePath = relativeFilePath;
        this.htmlFileContent = htmlFileContent;
    }

    public Path getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    private Path getRelativeFilePath() {
        return relativeFilePath;
    }

    private String getHtmlFileContent() {
        return htmlFileContent;
    }

    @Override
    public String render(Model model, Lookup lookup, RequestLookup requestLookup, API api) {
        return htmlFileContent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbsoluteFilePath(), getHtmlFileContent());
    }

    @Override
    public String toString() {
        return "{\"path\": {\"absolute\": \"" + getAbsoluteFilePath() + "\", \"relative\": \"" + getRelativeFilePath() +
                "\"}}";
    }
}
