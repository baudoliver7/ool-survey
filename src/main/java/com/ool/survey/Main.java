/*
 * MIT License
 *
 * Copyright (c) 2021 Olivier B. OURA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ool.survey;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Class Entrance.
 *
 * @since 0.1
 * @checkstyle HideUtilityClassConstructorCheck (100 lines)
 */
@SuppressWarnings({"PMD.SystemPrintln", "PMD.UseUtilityClass"})
public final class Main {

    /**
     * Wikipedia page link.
     */
    private static final String WIKI_PAGE =
        "https://en.wikipedia.org/wiki/List_of_programming_languages";

    /**
     * Xpath query for retrieving languages in Wiki page.
     */
    private static final String QUERY_WIKI_PAGE =
        "//div[@id='mw-content-text']/div/div/ul/li/a/text()";

    /**
     * Entrance.
     * @param args Arguments
     * @throws IOException If fails to fetch
     */
    public static void main(final String... args) throws IOException {
        final String html = new JdkRequest(Main.WIKI_PAGE)
            .uri().back()
            .method(Request.GET)
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_HTML)
            .fetch()
            .body();
        final XML xml = new XMLDocument(html);
        final List<String> languages = xml.xpath(Main.QUERY_WIKI_PAGE);
        System.out.println(languages);
        System.out.println(languages.size());
    }
}
