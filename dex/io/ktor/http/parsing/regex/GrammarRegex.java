package io.ktor.http.parsing.regex;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegexParserGenerator.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/http/parsing/regex/GrammarRegex;", "", "", "regexRaw", "", "groupsCountRaw", "", "group", "<init>", "(Ljava/lang/String;IZ)V", "regex", "Ljava/lang/String;", "getRegex", "()Ljava/lang/String;", "groupsCount", "I", "getGroupsCount", "()I", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GrammarRegex {
    private final int groupsCount;
    private final String regex;

    public GrammarRegex(String regexRaw, int groupsCountRaw, boolean group) {
        Intrinsics.checkNotNullParameter(regexRaw, "regexRaw");
        this.regex = group ? '(' + regexRaw + ')' : regexRaw;
        this.groupsCount = group ? groupsCountRaw + 1 : groupsCountRaw;
    }

    public /* synthetic */ GrammarRegex(String str, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }

    public final String getRegex() {
        return this.regex;
    }

    public final int getGroupsCount() {
        return this.groupsCount;
    }
}