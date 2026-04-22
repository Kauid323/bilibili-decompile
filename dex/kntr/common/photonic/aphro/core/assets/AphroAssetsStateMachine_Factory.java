package kntr.common.photonic.aphro.core.assets;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroAssetsStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine_Factory;", "", "<init>", "()V", "get", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine;", "init", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroAssetsStateMachine_Factory {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    public final AphroAssetsStateMachine get(AphroAssetsState.Init init) {
        Intrinsics.checkNotNullParameter(init, "init");
        return Companion.newInstance(init);
    }

    /* compiled from: AphroAssetsStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine_Factory;", "newInstance", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine;", "init", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AphroAssetsStateMachine_Factory create() {
            return new AphroAssetsStateMachine_Factory();
        }

        @JvmStatic
        public final AphroAssetsStateMachine newInstance(AphroAssetsState.Init init) {
            Intrinsics.checkNotNullParameter(init, "init");
            return new AphroAssetsStateMachine(init);
        }
    }

    @JvmStatic
    public static final AphroAssetsStateMachine_Factory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final AphroAssetsStateMachine newInstance(AphroAssetsState.Init init) {
        return Companion.newInstance(init);
    }
}