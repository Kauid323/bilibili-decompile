package kntr.app.deepsearch.base.model.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;

/* compiled from: DeepSearchToast.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", RoomRecommendViewModel.EMPTY_CURSOR, "content", RoomRecommendViewModel.EMPTY_CURSOR, "ts", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;J)V", "getContent$annotations", "()V", "getContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchToast {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final long ts;

    private final long component2() {
        return this.ts;
    }

    public static /* synthetic */ DeepSearchToast copy$default(DeepSearchToast deepSearchToast, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepSearchToast.content;
        }
        if ((i & 2) != 0) {
            j2 = deepSearchToast.ts;
        }
        return deepSearchToast.copy(str, j2);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final String component1() {
        return this.content;
    }

    public final DeepSearchToast copy(String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new DeepSearchToast(str, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchToast) {
            DeepSearchToast deepSearchToast = (DeepSearchToast) obj;
            return Intrinsics.areEqual(this.content, deepSearchToast.content) && this.ts == deepSearchToast.ts;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ts);
    }

    public String toString() {
        String str = this.content;
        return "DeepSearchToast(content=" + str + ", ts=" + this.ts + ")";
    }

    public DeepSearchToast(String content, long ts) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.ts = ts;
    }

    public final String getContent() {
        return this.content;
    }

    /* compiled from: DeepSearchToast.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchToast$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", "error", RoomRecommendViewModel.EMPTY_CURSOR, "default", RoomRecommendViewModel.EMPTY_CURSOR, "content", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeepSearchToast create$default(Companion companion, Throwable th, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            return companion.create(th, str);
        }

        public final DeepSearchToast create(Throwable error, String str) {
            String msg;
            Intrinsics.checkNotNullParameter(str, "default");
            if (error == null || (msg = DeepSearchToastKt.toDisplayString(error, str)) == null) {
                msg = str;
            }
            if (StringsKt.isBlank(msg)) {
                return null;
            }
            return new DeepSearchToast(msg, Clock.System.INSTANCE.now().toEpochMilliseconds());
        }

        public final DeepSearchToast create(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (content.length() == 0) {
                return null;
            }
            return new DeepSearchToast(content, Clock.System.INSTANCE.now().toEpochMilliseconds());
        }
    }
}