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
import com.jcabi.log.Logger;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        Logger.info(Main.class, "------ Start-up of the Survey ------ ");
        Logger.info(
            Main.class, "Loading Wikipedia HTML page at link : %s",
            Main.WIKI_PAGE
        );
        final String html = new JdkRequest(Main.WIKI_PAGE)
            .uri().back()
            .method(Request.GET)
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_HTML)
            .fetch()
            .body();
        Logger.info(Main.class, "Extracting languages from Wiki page");
        final XML xml = new XMLDocument(html);
        final List<String> languages = xml.xpath(Main.QUERY_WIKI_PAGE);
        Logger.info(
            Main.class, "The number of languages extracted : %s",
            languages.size()
        );
        Logger.info(Main.class, "Building csv file");
        final List<String[]> lines = new LinkedList<>();
        for (String lg : languages) {
            final String[] line = new String[8];
            line[0] = lg;
            line[1] = "";
            line[2] = "";
            line[3] = "";
            line[4] = "";
            line[5] = "";
            line[6] = "";
            line[7] = "";
            lines.add(line);
        }
        final File csv = new File("survey.csv");
        try (PrintWriter pw = new PrintWriter(csv, "UTF-8")) {
            lines.stream()
                .map(line -> Stream.of(line).collect(Collectors.joining(",")))
                .forEach(pw::println);
        }
        Logger.info(Main.class, "------ End of the Survey ------ ");
    }
}
