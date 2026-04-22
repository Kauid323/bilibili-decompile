package kntr.common.share.common.ui.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareChannelList;
import kntr.common.share.common.ui.ShareKt;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewAction;
import kntr.common.share.common.ui.ShareMenuViewState;
import kntr.common.share.domain.model.ChannelItem;
import kntr.common.share.domain.model.ShareChannels;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: ShareMenuProcessor.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"LOG_TAG", "", "FORBIDDEN_CHANNELS_KEY", "processAction", "", "Lkntr/common/share/common/ui/ShareMenuVM;", "action", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "reportShow", "toList", "Lkntr/common/share/common/ui/ShareChannelList;", "Lkntr/common/share/domain/model/ShareChannels;", "isSupport", "", "Lkntr/common/share/common/ShareTarget;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuProcessorKt {
    private static final String FORBIDDEN_CHANNELS_KEY = "share.forbidden_channels";
    private static final String LOG_TAG = "MenuViewModel";

    public static final void processAction(final ShareMenuVM $this$processAction, ShareMenuViewAction action) {
        Object prevValue$iv;
        Object nextValue$iv;
        Object prevValue$iv2;
        ShareMenuViewState it;
        Object prevValue$iv3;
        Object nextValue$iv2;
        Intrinsics.checkNotNullParameter($this$processAction, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        ShareMenuViewState currentState = (ShareMenuViewState) $this$processAction.getMState$common_ui_debug().getValue();
        if (action instanceof ShareMenuViewAction.LoadChannelList) {
            if (currentState.isLoadedChannelList()) {
                ShareLog.Companion.i(LOG_TAG, "already loaded channels.");
            } else if (currentState.isLoading()) {
                ShareLog.Companion.i(LOG_TAG, "loading...");
            } else {
                ShareLog.Companion.i(LOG_TAG, "start load channels...");
                Function1 handler = new Function1() { // from class: kntr.common.share.common.ui.internal.ShareMenuProcessorKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ShareChannelList processAction$lambda$0;
                        processAction$lambda$0 = ShareMenuProcessorKt.processAction$lambda$0(ShareMenuVM.this, (ShareChannelList) obj);
                        return processAction$lambda$0;
                    }
                };
                if (((ShareMenuViewAction.LoadChannelList) action).getLocal() != null && !((ShareMenuViewAction.LoadChannelList) action).getLocal().isEmpty()) {
                    ShareLog.Companion.i(LOG_TAG, "load local channels.");
                    MutableStateFlow $this$update$iv = $this$processAction.getMState$common_ui_debug();
                    do {
                        prevValue$iv3 = $this$update$iv.getValue();
                        ShareMenuViewState it2 = (ShareMenuViewState) prevValue$iv3;
                        nextValue$iv2 = ShareMenuViewState.copy$default(it2, false, false, true, (ShareChannelList) handler.invoke(((ShareMenuViewAction.LoadChannelList) action).getLocal()), null, null, null, 115, null);
                    } while (!$this$update$iv.compareAndSet(prevValue$iv3, nextValue$iv2));
                    return;
                }
                MutableStateFlow $this$update$iv2 = $this$processAction.getMState$common_ui_debug();
                do {
                    prevValue$iv2 = $this$update$iv2.getValue();
                    it = (ShareMenuViewState) prevValue$iv2;
                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, ShareMenuViewState.copy$default(it, false, true, false, null, null, null, null, 125, null)));
                BuildersKt.launch$default($this$processAction.getCoroutineScope$common_ui_debug(), (CoroutineContext) null, (CoroutineStart) null, new ShareMenuProcessorKt$processAction$3($this$processAction, handler, null), 3, (Object) null);
            }
        } else if (Intrinsics.areEqual(action, ShareMenuViewAction.Show.INSTANCE)) {
            if (!currentState.isLoadedChannelList() || currentState.getChannels().isEmpty()) {
                ShareLog.Companion.e(LOG_TAG, "can not show because has not loaded channels!");
            } else if (currentState.isVisible()) {
                ShareLog.Companion.i(LOG_TAG, "already shown");
            } else {
                MutableStateFlow $this$update$iv3 = $this$processAction.getMState$common_ui_debug();
                do {
                    prevValue$iv = $this$update$iv3.getValue();
                    ShareMenuViewState it3 = (ShareMenuViewState) prevValue$iv;
                    nextValue$iv = ShareMenuViewState.copy$default(it3, true, false, false, null, null, null, null, 14, null);
                } while (!$this$update$iv3.compareAndSet(prevValue$iv, nextValue$iv));
                reportShow($this$processAction);
                ShareLog.Companion.i(LOG_TAG, "ShareMenuView Show");
            }
        } else if (action instanceof ShareMenuViewAction.Click) {
            ShareTarget target = ((ShareMenuViewAction.Click) action).getTarget();
            ShareLog.Companion.i(LOG_TAG, "did click " + target.getName() + ".");
            if (currentState.isLoading()) {
                ShareLog.Companion.i(LOG_TAG, "loading...");
                return;
            }
            MutableStateFlow $this$update$iv4 = $this$processAction.getMState$common_ui_debug();
            while (true) {
                Object prevValue$iv4 = $this$update$iv4.getValue();
                ShareMenuViewState it4 = (ShareMenuViewState) prevValue$iv4;
                Object nextValue$iv3 = ShareMenuViewState.copy$default(it4, false, false, false, null, target, null, null, 111, null);
                if ($this$update$iv4.compareAndSet(prevValue$iv4, nextValue$iv3)) {
                    break;
                }
            }
            if (!((Boolean) $this$processAction.getClickHandler$common_ui_debug().invoke(target)).booleanValue()) {
                ShareLog.Companion.i(LOG_TAG, target.getName() + " is not allowed to share.");
            } else if (target instanceof ShareTarget.Custom) {
                ShareLog.Companion.i(LOG_TAG, "custom target " + target.getName() + " is not allowed to share.");
                $this$processAction.getReporter$common_ui_debug().reportClickChannel($this$processAction.getSession(), target, null, $this$processAction.getExtraReportFields$common_ui_debug());
            } else {
                BuildersKt.launch$default($this$processAction.getCoroutineScope$common_ui_debug(), (CoroutineContext) null, (CoroutineStart) null, new ShareMenuProcessorKt$processAction$6(target, $this$processAction, action, null), 3, (Object) null);
            }
        } else if (!Intrinsics.areEqual(action, ShareMenuViewAction.Hidden.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            $this$processAction.getMState$common_ui_debug().setValue(new ShareMenuViewState(false, false, false, null, null, null, null, 127, null));
            if (currentState.isVisible() && currentState.getSelectedChannel() == null) {
                $this$processAction.getReporter$common_ui_debug().reportClickChannel($this$processAction.getSession(), ShareTarget.Cancel.INSTANCE, null, $this$processAction.getExtraReportFields$common_ui_debug());
            }
            ShareLog.Companion.i(LOG_TAG, "ShareMenuView Hidden");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareChannelList processAction$lambda$0(ShareMenuVM $this_processAction, ShareChannelList list) {
        Intrinsics.checkNotNullParameter(list, "list");
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, FORBIDDEN_CHANNELS_KEY, null, 2, null);
        if (config$default == null) {
            config$default = "";
        }
        Set forbidden = CollectionsKt.toSet(StringsKt.split$default(config$default, new String[]{","}, false, 0, 6, (Object) null));
        Iterable $this$map$iv = list.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Iterable row = (List) item$iv$iv;
            Iterable $this$filter$iv = row;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                ShareChannelList.Item it = (ShareChannelList.Item) element$iv$iv;
                Iterable $this$map$iv2 = $this$map$iv;
                if (!forbidden.contains(it.getTarget().getName()) && isSupport(it.getTarget())) {
                    destination$iv$iv2.add(element$iv$iv);
                }
                $this$map$iv = $this$map$iv2;
            }
            destination$iv$iv.add((List) destination$iv$iv2);
        }
        Iterable $this$filter$iv2 = (List) destination$iv$iv;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            if (!((List) element$iv$iv2).isEmpty()) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        List filteredItems = (List) destination$iv$iv3;
        return (ShareChannelList) $this_processAction.getCustomizeChannelList$common_ui_debug().invoke(new ShareChannelList(filteredItems));
    }

    private static final void reportShow(ShareMenuVM $this$reportShow) {
        Iterable $this$forEach$iv;
        List channelListNames = new ArrayList();
        Map channelCornerMap = new LinkedHashMap();
        Iterable $this$forEach$iv2 = ((ShareMenuViewState) $this$reportShow.getMState$common_ui_debug().getValue()).getChannels().getItems();
        for (Object element$iv : $this$forEach$iv2) {
            Iterable list = (List) element$iv;
            for (Object element$iv2 : list) {
                ShareChannelList.Item item = (ShareChannelList.Item) element$iv2;
                channelListNames.add(item.getTarget().getName());
                String it = item.getCornerText();
                if (it != null) {
                    $this$forEach$iv = $this$forEach$iv2;
                    channelCornerMap.put(item.getTarget().getName(), it);
                } else {
                    $this$forEach$iv = $this$forEach$iv2;
                }
                $this$forEach$iv2 = $this$forEach$iv;
            }
        }
        Map $this$reportShow_u24lambda_u241 = MapsKt.createMapBuilder();
        Map<String, String> extraFields = $this$reportShow.getParams$common_ui_debug().getPageInfo().getExtraFields();
        if (extraFields == null) {
            extraFields = MapsKt.emptyMap();
        }
        $this$reportShow_u24lambda_u241.putAll(extraFields);
        $this$reportShow_u24lambda_u241.put("share_channel_list", UitsKt.toJsonSafely(channelListNames));
        Map it2 = !channelCornerMap.isEmpty() ? channelCornerMap : null;
        if (it2 != null) {
            $this$reportShow_u24lambda_u241.put("corner_mark_list", UitsKt.toJsonSafely(it2));
        }
        Map extraFields2 = MapsKt.build($this$reportShow_u24lambda_u241);
        $this$reportShow.setExtraReportFields$common_ui_debug(MapsKt.mapOf(TuplesKt.to("object_extra_fields", UitsKt.toJsonSafely(extraFields2))));
        $this$reportShow.getReporter$common_ui_debug().reportChannelsShow($this$reportShow.getSession(), $this$reportShow.getExtraReportFields$common_ui_debug());
    }

    private static final List<ShareChannelList.Item> toList$toItemList(List<ChannelItem> list) {
        ShareChannelList.Item item;
        ShareTarget target;
        Iterable $this$mapNotNull$iv = list == null ? CollectionsKt.emptyList() : list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            ChannelItem item2 = (ChannelItem) element$iv$iv$iv;
            if (item2.getCategory() == null && item2.getStatusList() == null) {
                String it = item2.getShareChannel();
                if (it == null || (target = ShareTarget.Companion.fromName(it)) == null) {
                    item = null;
                } else {
                    String name = item2.getName();
                    if (name == null) {
                        name = "";
                    }
                    item = new ShareChannelList.Item(target, name, null, item2.getPicture(), Intrinsics.areEqual(item2.getTag(), "last_share") ? item2.getTitle() : null, 4, null);
                }
            } else {
                item = null;
            }
            if (item != null) {
                destination$iv$iv.add(item);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareChannelList toList(ShareChannels $this$toList) {
        return new ShareChannelList(CollectionsKt.listOf(new List[]{toList$toItemList($this$toList.getAboveChannels()), toList$toItemList($this$toList.getBelowChannels()), toList$toItemList($this$toList.getSystemChannels())}));
    }

    private static final boolean isSupport(ShareTarget $this$isSupport) {
        if (Intrinsics.areEqual($this$isSupport, ShareTarget.WeChat.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.WeChatMoment.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.QQ.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.QZone.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.WeiBo.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.Facebook.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.Twitter.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.WhatsApp.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.Messenger.INSTANCE) || Intrinsics.areEqual($this$isSupport, ShareTarget.Line.INSTANCE)) {
            return ShareKt.gShare().isSupport($this$isSupport);
        }
        return true;
    }
}