package kntr.app.cheese.space.aggregate;

import dagger.internal.Factory;
import kntr.app.cheese.space.aggregate.SpaceCheesePageComponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory;", "Ldagger/internal/Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "get", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory implements Factory<String> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory INSTANCE = new SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory();

    public String get() {
        return Companion.provideCurrentPolarisActionId();
    }

    /* compiled from: SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory;", "create", "provideCurrentPolarisActionId", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory create() {
            return SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory.INSTANCE;
        }

        @JvmStatic
        public final String provideCurrentPolarisActionId() {
            return SpaceCheesePageComponent.Impl.INSTANCE.provideCurrentPolarisActionId();
        }
    }

    @JvmStatic
    public static final SpaceCheesePageComponent_Impl_ProvideCurrentPolarisActionIdFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final String provideCurrentPolarisActionId() {
        return Companion.provideCurrentPolarisActionId();
    }
}