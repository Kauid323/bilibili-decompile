package io.ktor.client.request.forms;

import faceverify.q;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.Source;

/* compiled from: formDsl.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\rJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u000fJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0013J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0015J=\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00192\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u001eJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010!J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\"2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010#J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020$2\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010%J%\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0004\b\u000b\u0010(J\u0019\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0)H\u0000¢\u0006\u0004\b*\u0010+R\u001e\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Lio/ktor/client/request/forms/FormBuilder;", "", "<init>", "()V", "T", "", q.KEY_RES_9_KEY, "value", "Lio/ktor/http/Headers;", "headers", "", "append", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)V", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;Ljava/lang/Number;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;ZLio/ktor/http/Headers;)V", "", "(Ljava/lang/String;[BLio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/InputProvider;", "(Ljava/lang/String;Lio/ktor/client/request/forms/InputProvider;Lio/ktor/http/Headers;)V", "", ContentDisposition.Parameters.Size, "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "block", "appendInput", "(Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;Lkotlinx/io/Source;Lio/ktor/http/Headers;)V", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;Lio/ktor/http/Headers;)V", "", "(Ljava/lang/String;[Ljava/lang/String;Lio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/ChannelProvider;", "(Ljava/lang/String;Lio/ktor/client/request/forms/ChannelProvider;Lio/ktor/http/Headers;)V", "Lio/ktor/client/request/forms/FormPart;", "part", "(Lio/ktor/client/request/forms/FormPart;)V", "", "build$ktor_client_core", "()Ljava/util/List;", "build", "", "parts", "Ljava/util/List;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FormBuilder {
    private final List<FormPart<?>> parts = new ArrayList();

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Object obj, Headers headers, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, (String) obj, headers);
    }

    @InternalAPI
    public final <T> void append(String key, T t, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, t, headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, str2, headers);
    }

    public final void append(String key, String value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Number number, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, number, headers);
    }

    public final void append(String key, Number value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, boolean z, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, z, headers);
    }

    public final void append(String key, boolean value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, Boolean.valueOf(value), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, byte[] bArr, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, bArr, headers);
    }

    public final void append(String key, byte[] value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, InputProvider inputProvider, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, inputProvider, headers);
    }

    public final void append(String key, InputProvider value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public static /* synthetic */ void appendInput$default(FormBuilder formBuilder, String str, Headers headers, Long l, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        if ((i2 & 4) != 0) {
            l = null;
        }
        formBuilder.appendInput(str, headers, l, function0);
    }

    public final void appendInput(String key, Headers headers, Long size, Function0<? extends Source> function0) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.parts.add(new FormPart<>(key, new InputProvider(size, function0), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Source source, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, source, headers);
    }

    public final void append(String key, Source value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, Iterable iterable, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, (Iterable<String>) iterable, headers);
    }

    public final void append(String key, Iterable<String> iterable, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(iterable, "values");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!StringsKt.endsWith$default(key, "[]", false, 2, (Object) null)) {
            throw new IllegalArgumentException(("Array parameter must be suffixed with square brackets ie `" + key + "[]`").toString());
        }
        for (Object element$iv : iterable) {
            String value = (String) element$iv;
            this.parts.add(new FormPart<>(key, value, headers));
        }
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String[] strArr, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, strArr, headers);
    }

    public final void append(String key, String[] values, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(headers, "headers");
        append(key, ArraysKt.asIterable(values), headers);
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, ChannelProvider channelProvider, Headers headers, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        formBuilder.append(str, channelProvider, headers);
    }

    public final void append(String key, ChannelProvider value, Headers headers) {
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.parts.add(new FormPart<>(key, value, headers));
    }

    public final <T> void append(FormPart<T> formPart) {
        Intrinsics.checkNotNullParameter(formPart, "part");
        this.parts.add(formPart);
    }

    public final List<FormPart<?>> build$ktor_client_core() {
        return this.parts;
    }
}