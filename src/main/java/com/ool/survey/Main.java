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
import java.io.IOException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Class Entrance.
 *
 * @since 0.1
 * @todo #1:30min Extract languages from loaded wiki page.
 *  We have loaded the entire page of wiki. Now, we want to extract
 *  all languages present in its content.
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
        System.out.println(html);
    }
}
