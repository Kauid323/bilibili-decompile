package io.ktor.client.request.forms;

import faceverify.q;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: formDsl.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0005\u0010\f\u001a]\u0010\u0015\u001a\u00020\t*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0019\b\u0004\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a_\u0010\u0015\u001a\u00020\t*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0004\b\u0015\u0010\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"", "Lio/ktor/client/request/forms/FormPart;", "values", "", "Lio/ktor/http/content/PartData;", "formData", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", q.KEY_RES_9_KEY, "Lio/ktor/http/Headers;", "headers", "", ContentDisposition.Parameters.Size, "Lkotlinx/io/Sink;", "bodyBuilder", "append", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "filename", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FormDslKt {
    public static final List<PartData> formData(FormPart<?>... formPartArr) {
        PartData binaryChannelItem;
        Intrinsics.checkNotNullParameter(formPartArr, "values");
        List result = new ArrayList();
        int length = formPartArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            FormPart<?> formPart = formPartArr[i3];
            String key = formPart.component1();
            final Object value = formPart.component2();
            Headers headers = formPart.component3();
            HeadersBuilder $this$formData_u24lambda_u249_u24lambda_u240 = new HeadersBuilder(i2, 1, null);
            $this$formData_u24lambda_u249_u24lambda_u240.append(HttpHeaders.INSTANCE.getContentDisposition(), "form-data; name=" + HeaderValueWithParametersKt.escapeIfNeeded(key));
            $this$formData_u24lambda_u249_u24lambda_u240.appendAll(headers);
            if (value instanceof String) {
                binaryChannelItem = new PartData.FormItem((String) value, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof Number) {
                binaryChannelItem = new PartData.FormItem(value.toString(), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof Boolean) {
                binaryChannelItem = new PartData.FormItem(String.valueOf(((Boolean) value).booleanValue()), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof byte[]) {
                $this$formData_u24lambda_u249_u24lambda_u240.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(((byte[]) value).length));
                binaryChannelItem = new PartData.BinaryItem(new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Source formData$lambda$9$lambda$4;
                        formData$lambda$9$lambda$4 = FormDslKt.formData$lambda$9$lambda$4(value);
                        return formData$lambda$9$lambda$4;
                    }
                }, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof Source) {
                $this$formData_u24lambda_u249_u24lambda_u240.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(ByteReadPacketKt.getRemaining((Source) value)));
                binaryChannelItem = new PartData.BinaryItem(new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Source formData$lambda$9$lambda$6;
                        formData$lambda$9$lambda$6 = FormDslKt.formData$lambda$9$lambda$6(value);
                        return formData$lambda$9$lambda$6;
                    }
                }, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit formData$lambda$9$lambda$7;
                        formData$lambda$9$lambda$7 = FormDslKt.formData$lambda$9$lambda$7(value);
                        return formData$lambda$9$lambda$7;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof InputProvider) {
                Long size = ((InputProvider) value).getSize();
                if (size != null) {
                    $this$formData_u24lambda_u249_u24lambda_u240.append(HttpHeaders.INSTANCE.getContentLength(), size.toString());
                }
                binaryChannelItem = new PartData.BinaryItem(((InputProvider) value).getBlock(), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else if (value instanceof ChannelProvider) {
                Long size2 = ((ChannelProvider) value).getSize();
                if (size2 != null) {
                    $this$formData_u24lambda_u249_u24lambda_u240.append(HttpHeaders.INSTANCE.getContentLength(), size2.toString());
                }
                binaryChannelItem = new PartData.BinaryChannelItem(((ChannelProvider) value).getBlock(), $this$formData_u24lambda_u249_u24lambda_u240.m3526build());
            } else {
                throw new IllegalStateException(("Unknown form content type: " + value).toString());
            }
            PartData part = binaryChannelItem;
            result.add(part);
            i3++;
            i2 = 0;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$9$lambda$4(Object $value) {
        return ByteReadPacketKt.ByteReadPacket$default((byte[]) $value, 0, 0, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$9$lambda$6(Object $value) {
        return ByteReadPacketKt.copy((Source) $value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit formData$lambda$9$lambda$7(Object $value) {
        ((Source) $value).close();
        return Unit.INSTANCE;
    }

    public static final List<PartData> formData(Function1<? super FormBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        FormBuilder formBuilder = new FormBuilder();
        function1.invoke(formBuilder);
        Collection $this$toTypedArray$iv = formBuilder.build$ktor_client_core();
        FormPart[] formPartArr = (FormPart[]) $this$toTypedArray$iv.toArray(new FormPart[0]);
        return formData((FormPart[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }

    public static /* synthetic */ void append$default(FormBuilder $this$append_u24default, String key, Headers headers, Long size, Function1 bodyBuilder, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            headers = Headers.Companion.getEmpty();
        }
        if ((i2 & 4) != 0) {
            size = null;
        }
        Intrinsics.checkNotNullParameter($this$append_u24default, "<this>");
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        $this$append_u24default.append(new FormPart(key, new InputProvider(size, new FormDslKt$append$1(bodyBuilder)), headers));
    }

    public static final void append(FormBuilder $this$append, String key, Headers headers, Long size, Function1<? super Sink, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(function1, "bodyBuilder");
        $this$append.append(new FormPart(key, new InputProvider(size, new FormDslKt$append$1(function1)), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1 function1, int i2, Object obj) {
        ContentType contentType2;
        Long l2;
        if ((i2 & 4) == 0) {
            contentType2 = contentType;
        } else {
            contentType2 = null;
        }
        if ((i2 & 8) == 0) {
            l2 = l;
        } else {
            l2 = null;
        }
        append(formBuilder, str, str2, contentType2, l2, function1);
    }

    public static final void append(FormBuilder $this$append, String key, String filename, ContentType contentType, Long size, Function1<? super Sink, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(function1, "bodyBuilder");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.set(HttpHeaders.INSTANCE.getContentDisposition(), "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(filename));
        if (contentType != null) {
            headersBuilder.set(HttpHeaders.INSTANCE.getContentType(), contentType.toString());
        }
        Headers headers = headersBuilder.m3526build();
        $this$append.append(new FormPart(key, new InputProvider(size, new FormDslKt$append$1(function1)), headers));
    }
}