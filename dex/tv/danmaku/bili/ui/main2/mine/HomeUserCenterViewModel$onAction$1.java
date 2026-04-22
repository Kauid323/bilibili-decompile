package tv.danmaku.bili.ui.main2.mine;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.lib.ui.garb.Garb;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterViewModel$onAction$1", f = "HomeUserCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeUserCenterAction $action;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeUserCenterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterViewModel$onAction$1(HomeUserCenterAction homeUserCenterAction, HomeUserCenterViewModel homeUserCenterViewModel, Continuation<? super HomeUserCenterViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = homeUserCenterAction;
        this.this$0 = homeUserCenterViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> homeUserCenterViewModel$onAction$1 = new HomeUserCenterViewModel$onAction$1(this.$action, this.this$0, continuation);
        homeUserCenterViewModel$onAction$1.L$0 = obj;
        return homeUserCenterViewModel$onAction$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        GarbEnum newGarbEnum;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Application application;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableStateFlow mutableStateFlow7;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                HomeUserCenterViewModelKt.mineLog("onAction: " + this.$action);
                HomeUserCenterAction homeUserCenterAction = this.$action;
                if (homeUserCenterAction instanceof HomeUserCenterAction.ClearForLogStatusChanged) {
                    mutableStateFlow6 = this.this$0._mineData;
                    mutableStateFlow7 = this.this$0._mineData;
                    mutableStateFlow6.setValue(AccountMineData.next$default((AccountMineData) mutableStateFlow7.getValue(), false, null, false, null, 8, null));
                } else if (homeUserCenterAction instanceof HomeUserCenterAction.Update) {
                    mutableStateFlow4 = this.this$0._mineData;
                    mutableStateFlow5 = this.this$0._mineData;
                    mutableStateFlow4.setValue(AccountMineData.next$default((AccountMineData) mutableStateFlow5.getValue(), false, ((HomeUserCenterAction.Update) this.$action).getAccountMine(), ((HomeUserCenterAction.Update) this.$action).getFromCache(), null, 8, null));
                } else if (homeUserCenterAction instanceof HomeUserCenterAction.Init) {
                    AccountMineInfoManager accountMineInfoManager = AccountMineInfoManager.getInstance();
                    application = this.this$0.app;
                    Context baseContext = application.getBaseContext();
                    final HomeUserCenterViewModel homeUserCenterViewModel = this.this$0;
                    accountMineInfoManager.getLocalMineInfo(baseContext, new AccountMineInfoManager.LocalMineInfoLoadListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterViewModel$onAction$1$$ExternalSyntheticLambda0
                        @Override // tv.danmaku.bili.ui.main2.AccountMineInfoManager.LocalMineInfoLoadListener
                        public final void onLoadMineInfoLoaded(AccountMine accountMine) {
                            HomeUserCenterViewModel$onAction$1.invokeSuspend$lambda$0(HomeUserCenterViewModel.this, accountMine);
                        }
                    });
                } else if (homeUserCenterAction instanceof HomeUserCenterAction.OnSkinChanged) {
                    HomeUserCenterAction.OnSkinChanged onSkinChanged = (HomeUserCenterAction.OnSkinChanged) this.$action;
                    Garb garb = onSkinChanged.getGarb();
                    if (onSkinChanged.getGarb().isPure()) {
                        if (garb.isWhite()) {
                            newGarbEnum = GarbEnum.PURE_WHITE;
                        } else if (garb.isNight()) {
                            newGarbEnum = GarbEnum.PURE_NIGHT;
                        } else {
                            newGarbEnum = GarbEnum.PURE_COLOR;
                        }
                    } else if (garb.isNight()) {
                        if (garb.isDarkMode()) {
                            newGarbEnum = GarbEnum.LIGHT_GARB_NIGHT;
                        } else {
                            newGarbEnum = GarbEnum.DARK_GARB_NIGHT;
                        }
                    } else if (garb.isDarkMode()) {
                        newGarbEnum = GarbEnum.LIGHT_GARB_DAY;
                    } else {
                        newGarbEnum = GarbEnum.DARK_GARB_DAY;
                    }
                    mutableStateFlow2 = this.this$0._mineData;
                    mutableStateFlow3 = this.this$0._mineData;
                    mutableStateFlow2.setValue(AccountMineData.next$default((AccountMineData) mutableStateFlow3.getValue(), false, null, false, newGarbEnum, 7, null));
                } else if (homeUserCenterAction instanceof HomeUserCenterAction.PageVisibilityChange) {
                    mutableStateFlow = this.this$0._visibility;
                    mutableStateFlow.setValue(Boxing.boxBoolean(((HomeUserCenterAction.PageVisibilityChange) this.$action).getVisible()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(HomeUserCenterViewModel this$0, AccountMine mineInfo) {
        AccountMine.SeniorStatus seniorStatus;
        if (mineInfo != null && (seniorStatus = mineInfo.seniorStatus) != null) {
            seniorStatus.bubble = null;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this$0), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterViewModel$onAction$1$1$2(this$0, mineInfo, null), 3, (Object) null);
    }
}