package tv.danmaku.bili.push.innerpush;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.bili.BR;

/* compiled from: AppEventUploader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"uploadLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "getUploadLoadScope", "()Lkotlinx/coroutines/CoroutineScope;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppEventUploaderKt {
    private static final CoroutineScope uploadLoadScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    public static final CoroutineScope getUploadLoadScope() {
        return uploadLoadScope;
    }
}