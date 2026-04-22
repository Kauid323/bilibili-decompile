package kntr.watch.later.watchlater.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: TranslateApi.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0080@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"TRANSLATE_STATE_UNKNOWN", "", "TRANSLATE_STATE_ORIGIN", "TRANSLATE_STATE_TRANSLATED", "TRANSLATE_STATE_TRANSLATING", "isTranslated", "", "Lkntr/watch/later/watchlater/api/TranslatableData;", "(Lkntr/watch/later/watchlater/api/TranslatableData;)Z", "isTranslating", "translateArcTitle", "", "data", "(Lkntr/watch/later/watchlater/api/TranslatableData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TranslateApiKt {
    public static final int TRANSLATE_STATE_ORIGIN = 1;
    public static final int TRANSLATE_STATE_TRANSLATED = 2;
    public static final int TRANSLATE_STATE_TRANSLATING = 10;
    public static final int TRANSLATE_STATE_UNKNOWN = 0;

    public static final boolean isTranslated(TranslatableData $this$isTranslated) {
        Intrinsics.checkNotNullParameter($this$isTranslated, "<this>");
        return $this$isTranslated.getTranslateStatus() == 2;
    }

    public static final boolean isTranslating(TranslatableData $this$isTranslating) {
        Intrinsics.checkNotNullParameter($this$isTranslating, "<this>");
        return $this$isTranslating.getTranslateStatus() == 10;
    }

    public static final Object translateArcTitle(TranslatableData data, Continuation<? super String> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new TranslateApiKt$translateArcTitle$2(data, null), continuation);
    }
}