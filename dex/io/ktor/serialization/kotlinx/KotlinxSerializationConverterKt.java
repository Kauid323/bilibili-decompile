package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lio/ktor/http/ContentType;", "contentType", "Lkotlinx/serialization/BinaryFormat;", "format", "", "serialization", "(Lio/ktor/serialization/Configuration;Lio/ktor/http/ContentType;Lkotlinx/serialization/BinaryFormat;)V", "Lkotlinx/serialization/StringFormat;", "(Lio/ktor/serialization/Configuration;Lio/ktor/http/ContentType;Lkotlinx/serialization/StringFormat;)V", "ktor-serialization-kotlinx"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationConverterKt {
    public static final void serialization(Configuration $this$serialization, ContentType contentType, BinaryFormat format) {
        Intrinsics.checkNotNullParameter($this$serialization, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(format, "format");
        Configuration.DefaultImpls.register$default($this$serialization, contentType, new KotlinxSerializationConverter((SerialFormat) format), null, 4, null);
    }

    public static final void serialization(Configuration $this$serialization, ContentType contentType, StringFormat format) {
        Intrinsics.checkNotNullParameter($this$serialization, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(format, "format");
        Configuration.DefaultImpls.register$default($this$serialization, contentType, new KotlinxSerializationConverter((SerialFormat) format), null, 4, null);
    }
}