package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuFilterChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuFilterChange {

    /* compiled from: DanmakuFilterChange.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR(\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR(\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR(\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010(\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00101\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R(\u00104\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b5\u0010-\"\u0004\b6\u0010/R\"\u00107\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\"\u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\"\u0010=\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\"\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR\"\u0010C\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\t¨\u0006G"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request;", "", "<init>", "()V", "blockColor", "", "getBlockColor", "()Ljava/lang/Boolean;", "setBlockColor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "blockTop", "getBlockTop$annotations", "getBlockTop", "setBlockTop", "blockBottom", "getBlockBottom$annotations", "getBlockBottom", "setBlockBottom", "blockScroll", "getBlockScroll$annotations", "getBlockScroll", "setBlockScroll", "blockSpecial", "getBlockSpecial", "setBlockSpecial", "blockRepeat", "getBlockRepeat", "setBlockRepeat", "blockEnable", "getBlockEnable$annotations", "getBlockEnable", "setBlockEnable", "aiLevel", "", "getAiLevel$annotations", "getAiLevel", "()Ljava/lang/Integer;", "setAiLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userHashBlockList", "", "", "getUserHashBlockList", "()[Ljava/lang/String;", "setUserHashBlockList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "regexBlockList", "getRegexBlockList", "setRegexBlockList", "contentBlockList", "getContentBlockList", "setContentBlockList", "seniorMode", "getSeniorMode", "setSeniorMode", "blockFixed", "getBlockFixed", "setBlockFixed", "blockFold", "getBlockFold", "setBlockFold", "blockBottomArea", "getBlockBottomArea", "setBlockBottomArea", "blockMask", "getBlockMask", "setBlockMask", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @RequestDefine(method = "OnDanmakuFilterChanged")
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        public static final Companion Companion = new Companion(null);
        public static final String TAG = "DanmakuFilterChange.Request";
        @JSONField(name = "ai_level")
        private Integer aiLevel;
        @JSONField(name = "block_bottom")
        private Boolean blockBottom;
        @JSONField(name = "block_bottom_area")
        private Boolean blockBottomArea;
        @JSONField(name = "block_colorful")
        private Boolean blockColor;
        @JSONField(name = "blocker_enabled")
        private Boolean blockEnable;
        @JSONField(name = "block_fixed")
        private Boolean blockFixed;
        @JSONField(name = "block_fold")
        private Boolean blockFold;
        @JSONField(name = "block_mask")
        private Boolean blockMask;
        @JSONField(name = "block_repeat")
        private Boolean blockRepeat;
        @JSONField(name = "block_scroll")
        private Boolean blockScroll;
        @JSONField(name = "block_special")
        private Boolean blockSpecial;
        @JSONField(name = "block_top")
        private Boolean blockTop;
        @JSONField(name = "content_block_list")
        private String[] contentBlockList;
        @JSONField(name = "regex_block_list")
        private String[] regexBlockList;
        @JSONField(name = "senior_mode")
        private Integer seniorMode;
        @JSONField(name = "user_hash_block_list")
        private String[] userHashBlockList;

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getAiLevel$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockBottom$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockEnable$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockScroll$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockTop$annotations() {
        }

        public final Boolean getBlockColor() {
            return this.blockColor;
        }

        public final void setBlockColor(Boolean bool) {
            this.blockColor = bool;
        }

        public final Boolean getBlockTop() {
            return this.blockTop;
        }

        public final void setBlockTop(Boolean bool) {
            this.blockTop = bool;
        }

        public final Boolean getBlockBottom() {
            return this.blockBottom;
        }

        public final void setBlockBottom(Boolean bool) {
            this.blockBottom = bool;
        }

        public final Boolean getBlockScroll() {
            return this.blockScroll;
        }

        public final void setBlockScroll(Boolean bool) {
            this.blockScroll = bool;
        }

        public final Boolean getBlockSpecial() {
            return this.blockSpecial;
        }

        public final void setBlockSpecial(Boolean bool) {
            this.blockSpecial = bool;
        }

        public final Boolean getBlockRepeat() {
            return this.blockRepeat;
        }

        public final void setBlockRepeat(Boolean bool) {
            this.blockRepeat = bool;
        }

        public final Boolean getBlockEnable() {
            return this.blockEnable;
        }

        public final void setBlockEnable(Boolean bool) {
            this.blockEnable = bool;
        }

        public final Integer getAiLevel() {
            return this.aiLevel;
        }

        public final void setAiLevel(Integer num) {
            this.aiLevel = num;
        }

        public final String[] getUserHashBlockList() {
            return this.userHashBlockList;
        }

        public final void setUserHashBlockList(String[] strArr) {
            this.userHashBlockList = strArr;
        }

        public final String[] getRegexBlockList() {
            return this.regexBlockList;
        }

        public final void setRegexBlockList(String[] strArr) {
            this.regexBlockList = strArr;
        }

        public final String[] getContentBlockList() {
            return this.contentBlockList;
        }

        public final void setContentBlockList(String[] strArr) {
            this.contentBlockList = strArr;
        }

        public final Integer getSeniorMode() {
            return this.seniorMode;
        }

        public final void setSeniorMode(Integer num) {
            this.seniorMode = num;
        }

        public final Boolean getBlockFixed() {
            return this.blockFixed;
        }

        public final void setBlockFixed(Boolean bool) {
            this.blockFixed = bool;
        }

        public final Boolean getBlockFold() {
            return this.blockFold;
        }

        public final void setBlockFold(Boolean bool) {
            this.blockFold = bool;
        }

        public final Boolean getBlockBottomArea() {
            return this.blockBottomArea;
        }

        public final void setBlockBottomArea(Boolean bool) {
            this.blockBottomArea = bool;
        }

        public final Boolean getBlockMask() {
            return this.blockMask;
        }

        public final void setBlockMask(Boolean bool) {
            this.blockMask = bool;
        }

        /* compiled from: DanmakuFilterChange.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0006¢\u0006\u0002\u0010\nJ\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request;", "T", "key", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "value", "(Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;Ljava/lang/Object;)Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {

            /* compiled from: DanmakuFilterChange.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DanmakuConfig.DanmakuOptionName.values().length];
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DANMAKU_SENIOR_MODE.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DANMAKU_RECOMMAND.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_SCROLL.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_TOP.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_BOTTOM.ordinal()] = 5;
                    } catch (NoSuchFieldError e5) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_SPECIAL.ordinal()] = 6;
                    } catch (NoSuchFieldError e6) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_COLORFUL.ordinal()] = 7;
                    } catch (NoSuchFieldError e7) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DUPLICATE_MERGING.ordinal()] = 8;
                    } catch (NoSuchFieldError e8) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.BLOCK_FIXED.ordinal()] = 9;
                    } catch (NoSuchFieldError e9) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DANMUKU_FOLD.ordinal()] = 10;
                    } catch (NoSuchFieldError e10) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.AVOID_SCRIPT.ordinal()] = 11;
                    } catch (NoSuchFieldError e11) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.AVOID_FIGURE.ordinal()] = 12;
                    } catch (NoSuchFieldError e12) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <T> Request create(DanmakuConfig.DanmakuOptionName key, T t) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (WhenMappings.$EnumSwitchMapping$0[key.ordinal()] == 1) {
                    Request $this$create_u24lambda_u240 = new Request();
                    Integer num = t instanceof Integer ? (Integer) t : null;
                    if (num != null) {
                        int it = num.intValue();
                        $this$create_u24lambda_u240.setSeniorMode(Integer.valueOf(it));
                    }
                    return $this$create_u24lambda_u240;
                }
                return null;
            }

            public final Request create(DanmakuConfig.DanmakuOptionName key, DanmakuParams params) {
                int i;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(params, "params");
                Request filter = new Request();
                boolean findFilter = true;
                switch (WhenMappings.$EnumSwitchMapping$0[key.ordinal()]) {
                    case 1:
                        DmViewReply dmViewReply = params.getDmViewReply();
                        DanmuPlayerViewConfig config = dmViewReply != null ? dmViewReply.getPlayerConfig() : null;
                        if (config != null && config.hasDanmukuPlayerConfig()) {
                            i = Integer.valueOf(config.getDanmukuPlayerConfig().getPlayerDanmakuSeniorModeSwitch());
                        } else {
                            i = 0;
                        }
                        filter.setSeniorMode(i);
                        break;
                    case 2:
                        filter.setAiLevel(-1);
                        if (params.isDanmakuRecommandEnable()) {
                            filter.setAiLevel(Integer.valueOf(params.getDanmakuBlockLevel()));
                            BLog.d("block_level_error", "send to chronos: " + filter.getAiLevel());
                            break;
                        }
                        break;
                    case 3:
                        filter.setBlockScroll(Boolean.valueOf(params.isDanmakuBlockScroll()));
                        BLog.d("danmaku filter sync", "block scroll send to chronos[onParamChanged]=" + filter.getBlockScroll());
                        break;
                    case 4:
                        filter.setBlockTop(Boolean.valueOf(params.isDanmakuBlockTop()));
                        break;
                    case 5:
                        filter.setBlockBottom(Boolean.valueOf(params.isDanmakuBlockBottom()));
                        break;
                    case 6:
                        filter.setBlockSpecial(Boolean.valueOf(params.isDanmakuBlockSpecial()));
                        break;
                    case 7:
                        filter.setBlockColor(Boolean.valueOf(params.isDanmakuBlockColorful()));
                        break;
                    case 8:
                        filter.setBlockRepeat(Boolean.valueOf(params.isDanmakuDuplicateMerging()));
                        break;
                    case 9:
                        filter.setBlockFixed(Boolean.valueOf(params.getDanmakuBlockFixed()));
                        BLog.d(Request.TAG, "blockFixed: " + filter.getBlockFixed());
                        break;
                    case 10:
                        filter.setBlockFold(Boolean.valueOf(!params.getEnableDanmakuFold()));
                        BLog.d(Request.TAG, "blockFold: " + filter.getBlockFold());
                        break;
                    case 11:
                        filter.setBlockBottomArea(Boolean.valueOf(params.getDanmakuAvoidScript()));
                        BLog.d(Request.TAG, "blockBottomArea: " + filter.getBlockBottomArea());
                        break;
                    case 12:
                        filter.setBlockMask(Boolean.valueOf(!params.getDanmakuAvoidFigure()));
                        BLog.d(Request.TAG, "blockMask: " + filter.getBlockMask());
                        break;
                    default:
                        findFilter = false;
                        break;
                }
                if (findFilter) {
                    return filter;
                }
                return null;
            }

            public final Request create(DanmakuParams params) {
                int i;
                Intrinsics.checkNotNullParameter(params, "params");
                Request filter = new Request();
                if (params.isDanmakuRecommandEnable()) {
                    i = Integer.valueOf(params.getDanmakuBlockLevel());
                } else {
                    i = -1;
                }
                filter.setAiLevel(i);
                filter.setBlockScroll(Boolean.valueOf(params.isDanmakuBlockScroll()));
                BLog.d("danmaku filter sync", "block scroll send to chronos[updateDanmakuParam]=" + filter.getBlockScroll());
                filter.setBlockTop(Boolean.valueOf(params.isDanmakuBlockTop()));
                filter.setBlockBottom(Boolean.valueOf(params.isDanmakuBlockBottom()));
                filter.setBlockSpecial(Boolean.valueOf(params.isDanmakuBlockSpecial()));
                filter.setBlockColor(Boolean.valueOf(params.isDanmakuBlockColorful()));
                filter.setBlockRepeat(Boolean.valueOf(params.isDanmakuDuplicateMerging()));
                return filter;
            }
        }
    }
}