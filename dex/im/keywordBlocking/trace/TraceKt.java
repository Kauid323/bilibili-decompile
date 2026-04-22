package im.keywordBlocking.trace;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.tencent.tauth.AuthActivity;
import im.keywordBlocking.KBAction;
import im.keywordBlocking.KBPageData;
import java.util.Map;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Trace.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\t\u001a\u00020\u0001H\u0002\u001a\b\u0010\n\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"bindTrace", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lim/keywordBlocking/KBPageData;", "Lim/keywordBlocking/KBAction;", "handleAddClick", "handleInputBoxShow", "handleInputBoxConfirmClick", "handleListItemClick", "handleDropListShow", "handleDropListClick", "handleDeleteAlertShow", "handleDeleteAlertClick", AuthActivity.ACTION_KEY, "", "keyword-blocking_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TraceKt {
    public static final void bindTrace(InStateBuilderBlock<KBPageData, KBPageData, KBAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new TraceKt$bindTrace$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(KBAction.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAddClick() {
        IPlatformNeuron.-CC.reportClick$default(KNeuron.INSTANCE, false, "im.im-setting-blacklist-words.add.0.click", (Map) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleInputBoxShow() {
        KNeuron.INSTANCE.reportExposure(false, "im.im-setting-blacklist-words.inputdialog.all.show", MapsKt.mapOf(TuplesKt.to("dialog_type", "add")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleInputBoxConfirmClick() {
        KNeuron.INSTANCE.reportClick(false, "im.im-setting-blacklist-words.inputdialog.button.click", MapsKt.mapOf(TuplesKt.to("button_type", "add")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleListItemClick() {
        IPlatformNeuron.-CC.reportClick$default(KNeuron.INSTANCE, false, "im.im-setting-blacklist-words.words.all.click", (Map) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDropListShow() {
        IPlatformNeuron.-CC.reportExposure$default(KNeuron.INSTANCE, false, "im.im-setting-blacklist-words.operationdialog.all.show", (Map) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDropListClick() {
        KNeuron.INSTANCE.reportClick(false, "im.im-setting-blacklist-words.operationdialog.button.click", MapsKt.mapOf(TuplesKt.to("button_type", "delete")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDeleteAlertShow() {
        IPlatformNeuron.-CC.reportExposure$default(KNeuron.INSTANCE, false, "im.im-setting-blacklist-words.deletedialog.all.show", (Map) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDeleteAlertClick(String action) {
        KNeuron.INSTANCE.reportClick(false, "im.im-setting-blacklist-words.deletedialog.button.click", MapsKt.mapOf(TuplesKt.to("button_type", action)));
    }
}