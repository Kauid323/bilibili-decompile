package kntr.app.tribee.publish.service.impl;

import dagger.internal.Factory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TribeeContentConverterImpl_Factory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl;", "<init>", "()V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeContentConverterImpl_Factory implements Factory<TribeeContentConverterImpl> {
    public static final Companion Companion = new Companion(null);
    private static final TribeeContentConverterImpl_Factory INSTANCE = new TribeeContentConverterImpl_Factory();

    public TribeeContentConverterImpl get() {
        return Companion.newInstance();
    }

    /* compiled from: TribeeContentConverterImpl_Factory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl_Factory$Companion;", "", "<init>", "()V", "INSTANCE", "Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl_Factory;", "create", "newInstance", "Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeContentConverterImpl_Factory create() {
            return TribeeContentConverterImpl_Factory.INSTANCE;
        }

        @JvmStatic
        public final TribeeContentConverterImpl newInstance() {
            return new TribeeContentConverterImpl();
        }
    }

    @JvmStatic
    public static final TribeeContentConverterImpl_Factory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final TribeeContentConverterImpl newInstance() {
        return Companion.newInstance();
    }
}