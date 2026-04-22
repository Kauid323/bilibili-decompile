package kntr.app.ad.common.utils;

import android.net.Uri;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringExt.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¨\u0006\u0003"}, d2 = {"urlEncode", RoomRecommendViewModel.EMPTY_CURSOR, "urlDecode", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringExt_androidKt {
    public static final String urlEncode(String $this$urlEncode) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$urlEncode, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.encode($this$urlEncode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final String urlDecode(String $this$urlDecode) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$urlDecode, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.decode($this$urlDecode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }
}