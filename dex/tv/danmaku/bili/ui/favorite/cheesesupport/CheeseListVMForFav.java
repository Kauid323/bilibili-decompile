package tv.danmaku.bili.ui.favorite.cheesesupport;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.ogv.infra.account.BiliAccountsKt;
import com.bilibili.okretro.call.rxjava.DisposableHelperKt;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CheeseListVM.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVMForFav;", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVM;", "<init>", "()V", "doRequest", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CheeseListVMForFav extends CheeseListVM {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Override // tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListVM
    public void doRequest() {
        String accessKey = BiliAccountsKt.getBiliAccounts().getAccessKey();
        Intrinsics.checkNotNull(accessKey);
        Disposable subscribe = CheeseApiManagerKt.getMyFavCheeseList(accessKey, getPage()).subscribe(new Consumer() { // from class: tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListVMForFav$doRequest$1
            public final void accept(CheeseList it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CheeseListVMForFav.this.onRequestSuccess(it);
            }
        }, new Consumer() { // from class: tv.danmaku.bili.ui.favorite.cheesesupport.CheeseListVMForFav$doRequest$2
            public final void accept(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CheeseListVMForFav.this.onRequestError(it);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        DisposableHelperKt.addToDisposableHelper(subscribe, getDisposableHelper());
    }

    /* compiled from: CheeseListVM.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVMForFav$Companion;", "", "<init>", "()V", "getViewModel", "Ltv/danmaku/bili/ui/favorite/cheesesupport/CheeseListVMForFav;", "fragment", "Landroidx/fragment/app/Fragment;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CheeseListVMForFav getViewModel(Fragment fragment) {
            if (fragment == null) {
                return null;
            }
            return (CheeseListVMForFav) new ViewModelProvider((ViewModelStoreOwner) fragment).get(CheeseListVMForFav.class);
        }
    }

    @JvmStatic
    public static final CheeseListVMForFav getViewModel(Fragment fragment) {
        return Companion.getViewModel(fragment);
    }
}