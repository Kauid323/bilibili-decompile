package io.ktor.util.converters;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversionService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/util/converters/DataConversionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", CrashHianalyticsData.MESSAGE, "<init>", "(Ljava/lang/String;)V", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DataConversionException extends Exception {
    public DataConversionException() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataConversionException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, CrashHianalyticsData.MESSAGE);
    }

    public /* synthetic */ DataConversionException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Invalid data format" : str);
    }
}