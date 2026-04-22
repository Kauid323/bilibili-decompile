package tv.danmaku.bili.core.test;

import android.content.SharedPreferences;
import android.view.View;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragmentKt;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.清除编辑资料气泡显示$onClick$1", f = "MainTestPageActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.清除编辑资料气泡显示$onClick$1  reason: invalid class name and case insensitive filesystem */
final class C0025$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $v;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0025$onClick$1(View view, Continuation<? super C0025$onClick$1> continuation) {
        super(2, continuation);
        this.$v = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0025$onClick$1(this.$v, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SharedPreferences blkv = BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.$v.getContext());
                Iterable $this$filterTo$iv$iv = blkv.getAll().keySet();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    String it = (String) element$iv$iv;
                    Intrinsics.checkNotNull(it);
                    if (StringsKt.startsWith$default(it, HomeUserCenterFragmentKt.KEY_BUBBLE_SHOWN, false, 2, (Object) null)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable ids = (List) destination$iv$iv;
                Intrinsics.checkNotNull(blkv);
                SharedPreferences.Editor editor$iv = blkv.edit();
                Iterable $this$forEach$iv = ids;
                for (Object element$iv : $this$forEach$iv) {
                    editor$iv.remove((String) element$iv);
                }
                editor$iv.apply();
                String toast = "已删除气泡id：" + CollectionsKt.joinToString$default(ids, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.core.test.清除编辑资料气泡显示$onClick$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        CharSequence invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = C0025$onClick$1.invokeSuspend$lambda$2((String) obj2);
                        return invokeSuspend$lambda$2;
                    }
                }, 31, (Object) null);
                ToastHelper.showToastLong(BiliContext.application(), toast);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$2(String it) {
        Intrinsics.checkNotNull(it);
        return StringsKt.substringAfter$default(it, HomeUserCenterFragmentKt.KEY_BUBBLE_SHOWN, (String) null, 2, (Object) null);
    }
}