package kntr.app.ad.domain.inspector.model;

import androidx.compose.ui.graphics.ColorKt;
import kntr.app.ad.domain.inspector.core.serializer.StatusSerializer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Status.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lkntr/app/ad/domain/inspector/model/Status;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getColor-0d7_KjU", "()J", "J", "PENDING", "RUNNING", "SUCCESS", "FAILED", "WARNING", "Companion", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable(with = StatusSerializer.class)
public enum Status {
    PENDING("等待中", ColorKt.Color(4285231744L)),
    RUNNING("运行中", ColorKt.Color(4294902015L)),
    SUCCESS("成功", ColorKt.Color(4279286145L)),
    FAILED("失败", ColorKt.Color(4293870660L)),
    WARNING("警告", ColorKt.Color(4294286859L));
    
    private final long color;
    private final String text;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<Status> getEntries() {
        return $ENTRIES;
    }

    /* compiled from: Status.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/inspector/model/Status$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/inspector/model/Status;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Status> serializer() {
            return StatusSerializer.INSTANCE;
        }
    }

    Status(String text, long color) {
        this.text = text;
        this.color = color;
    }

    public final String getText() {
        return this.text;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m325getColor0d7_KjU() {
        return this.color;
    }
}