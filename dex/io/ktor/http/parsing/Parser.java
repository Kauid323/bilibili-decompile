package io.ktor.http.parsing;

import kotlin.Metadata;

/* compiled from: Parser.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/Parser;", "", "", "input", "Lio/ktor/http/parsing/ParseResult;", "parse", "(Ljava/lang/String;)Lio/ktor/http/parsing/ParseResult;", "", "match", "(Ljava/lang/String;)Z", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Parser {
    boolean match(String str);

    ParseResult parse(String str);
}