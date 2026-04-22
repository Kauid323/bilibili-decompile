package io.ktor.http;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\r\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\r\u0010\u000bJ,\u0010\u0011\u001a\u00020\u00022\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Lio/ktor/http/StringLexer;", "", "", SocialConstants.PARAM_SOURCE, "<init>", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "", "predicate", "test", "(Lkotlin/jvm/functions/Function1;)Z", "accept", "acceptWhile", "", "Lkotlin/ExtensionFunctionType;", "block", "capture", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "getHasRemaining", "()Z", "hasRemaining", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StringLexer {
    private int index;
    private final String source;

    public StringLexer(String source) {
        Intrinsics.checkNotNullParameter(source, SocialConstants.PARAM_SOURCE);
        this.source = source;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final boolean getHasRemaining() {
        return this.index < this.source.length();
    }

    public final boolean test(Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return this.index < this.source.length() && ((Boolean) function1.invoke(Character.valueOf(this.source.charAt(this.index)))).booleanValue();
    }

    public final boolean accept(Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean it = test(function1);
        if (it) {
            this.index++;
        }
        return it;
    }

    public final boolean acceptWhile(Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (test(function1)) {
            while (test(function1)) {
                this.index++;
            }
            return true;
        }
        return false;
    }

    public final String capture(Function1<? super StringLexer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int start = getIndex();
        function1.invoke(this);
        String substring = getSource().substring(start, getIndex());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}