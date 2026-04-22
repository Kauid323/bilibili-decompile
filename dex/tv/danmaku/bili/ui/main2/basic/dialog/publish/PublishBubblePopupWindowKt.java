package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: PublishBubblePopupWindow.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\"\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"value", "Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "showingPopupItem", "getShowingPopupItem", "()Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "showTime", "", "getShowTime", "()J", "showTime$delegate", "Lkotlin/Lazy;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PublishBubblePopupWindowKt {
    private static final Lazy showTime$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindowKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            long showTime_delegate$lambda$0;
            showTime_delegate$lambda$0 = PublishBubblePopupWindowKt.showTime_delegate$lambda$0();
            return Long.valueOf(showTime_delegate$lambda$0);
        }
    });
    private static UpperCenterPlusBubbleService.BubbleInfo showingPopupItem;

    public static final /* synthetic */ void access$setShowingPopupItem$p(UpperCenterPlusBubbleService.BubbleInfo bubbleInfo) {
        showingPopupItem = bubbleInfo;
    }

    public static final UpperCenterPlusBubbleService.BubbleInfo getShowingPopupItem() {
        return showingPopupItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getShowTime() {
        return ((Number) showTime$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long showTime_delegate$lambda$0() {
        Long longOrNull;
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "main.publish_bubble_show_millis", (Object) null, 2, (Object) null);
        if (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) {
            return 5000L;
        }
        return longOrNull.longValue();
    }
}