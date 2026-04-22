package kntr.app.im.chat.sticker.viewModel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerManagerViewModel_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel;", "accountStoreProvider", "Ljavax/inject/Provider;", "Lkntr/base/account/KAccountStore;", "stateMachineProvider", "Lkntr/app/im/chat/sticker/stateMachine/StickerManagerStateMachine;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerViewModel_Factory implements Factory<StickerManagerViewModel> {
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<StickerManagerStateMachine> stateMachineProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public StickerManagerViewModel_Factory(Provider<KAccountStore> provider, Provider<StickerManagerStateMachine> provider2) {
        Intrinsics.checkNotNullParameter(provider, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
        this.accountStoreProvider = provider;
        this.stateMachineProvider = provider2;
    }

    public StickerManagerViewModel get() {
        Companion companion = Companion;
        KAccountStore kAccountStore = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        StickerManagerStateMachine stickerManagerStateMachine = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(stickerManagerStateMachine, "get(...)");
        return companion.newInstance(kAccountStore, stickerManagerStateMachine);
    }

    /* compiled from: StickerManagerViewModel_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel_Factory;", "accountStoreProvider", "Ljavax/inject/Provider;", "Lkntr/base/account/KAccountStore;", "stateMachineProvider", "Lkntr/app/im/chat/sticker/stateMachine/StickerManagerStateMachine;", "newInstance", "Lkntr/app/im/chat/sticker/viewModel/StickerManagerViewModel;", "accountStore", "stateMachine", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StickerManagerViewModel_Factory create(Provider<KAccountStore> provider, Provider<StickerManagerStateMachine> provider2) {
            Intrinsics.checkNotNullParameter(provider, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
            return new StickerManagerViewModel_Factory(provider, provider2);
        }

        @JvmStatic
        public final StickerManagerViewModel newInstance(KAccountStore accountStore, StickerManagerStateMachine stateMachine) {
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            return new StickerManagerViewModel(accountStore, stateMachine);
        }
    }

    @JvmStatic
    public static final StickerManagerViewModel_Factory create(Provider<KAccountStore> provider, Provider<StickerManagerStateMachine> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final StickerManagerViewModel newInstance(KAccountStore accountStore, StickerManagerStateMachine stateMachine) {
        return Companion.newInstance(accountStore, stateMachine);
    }
}