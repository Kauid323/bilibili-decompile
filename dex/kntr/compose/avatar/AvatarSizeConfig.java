package kntr.compose.avatar;

import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Avatar.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0013"}, d2 = {"Lkntr/compose/avatar/AvatarSizeConfig;", "", "minBoxSize", "", "<init>", "(Ljava/lang/String;IF)V", "getMinBoxSize$ui_debug", "()F", "Largest", "Normal", "constraintSize", "Landroidx/compose/ui/unit/Dp;", "avatarState", "Lkntr/compose/avatar/AvatarState;", "constraintSize-u2uoSUM", "(Lkntr/compose/avatar/AvatarState;)F", "normalSize", "constraintSize-5rwHm24", "(F)F", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum AvatarSizeConfig {
    Largest(1.35f),
    Normal(1.0f);
    
    private final float minBoxSize;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AvatarSizeConfig> getEntries() {
        return $ENTRIES;
    }

    AvatarSizeConfig(float minBoxSize) {
        this.minBoxSize = minBoxSize;
    }

    public final float getMinBoxSize$ui_debug() {
        return this.minBoxSize;
    }

    /* renamed from: constraintSize-u2uoSUM  reason: not valid java name */
    public final float m2498constraintSizeu2uoSUM(AvatarState avatarState) {
        Intrinsics.checkNotNullParameter(avatarState, "avatarState");
        float m2500getNormalSizeD9Ej5fM = avatarState.m2500getNormalSizeD9Ej5fM();
        float other$iv = RangesKt.coerceAtLeast(avatarState.getAvatarItem().getOutSize(), this.minBoxSize);
        return Dp.constructor-impl(m2500getNormalSizeD9Ej5fM * other$iv);
    }

    /* renamed from: constraintSize-5rwHm24  reason: not valid java name */
    public final float m2497constraintSize5rwHm24(float f) {
        float other$iv = this.minBoxSize;
        return Dp.constructor-impl(f * other$iv);
    }
}