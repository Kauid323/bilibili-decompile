package tv.danmaku.bili.auth.v2;

import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.CardTypeBean;
import tv.danmaku.bili.auth.v2.CertTypePickerDialogFragment;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.ui.widget.AuthBottomSheetDialog;
import tv.danmaku.bili.ui.widget.AuthBottomSheetItem;

/* compiled from: CertTypePickerDialogFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/auth/v2/CertTypePickerDialogFragment;", "", "<init>", "()V", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CertTypePickerDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CertTypePickerDialog";

    /* compiled from: CertTypePickerDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/auth/v2/CertTypePickerDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", ReportEvent.EVENT_TYPE_SHOW, "", ReportEvent.Tag.HOST, "Landroidx/fragment/app/FragmentManager;", "types", "", "Ltv/danmaku/bili/api/bean/CardTypeBean;", "onSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "type", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(FragmentManager host, final List<CardTypeBean> list, final Function1<? super CardTypeBean, Unit> function1) {
            Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
            Intrinsics.checkNotNullParameter(list, "types");
            Intrinsics.checkNotNullParameter(function1, "onSelected");
            List<CardTypeBean> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                CardTypeBean t = (CardTypeBean) item$iv$iv;
                destination$iv$iv.add(new AuthBottomSheetItem(t.getName(), 0, 2, (DefaultConstructorMarker) null));
                $this$map$iv = $this$map$iv;
            }
            List items = (List) destination$iv$iv;
            AuthBottomSheetDialog.Companion.newInstance(new ArrayList(items), new Function1() { // from class: tv.danmaku.bili.auth.v2.CertTypePickerDialogFragment$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit show$lambda$1;
                    show$lambda$1 = CertTypePickerDialogFragment.Companion.show$lambda$1(list, function1, ((Integer) obj).intValue());
                    return show$lambda$1;
                }
            }).show(host, CertTypePickerDialogFragment.TAG);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit show$lambda$1(List $types, Function1 $onSelected, int it) {
            CardTypeBean type = (CardTypeBean) CollectionsKt.getOrNull($types, it);
            if (type != null) {
                $onSelected.invoke(type);
            }
            return Unit.INSTANCE;
        }
    }
}