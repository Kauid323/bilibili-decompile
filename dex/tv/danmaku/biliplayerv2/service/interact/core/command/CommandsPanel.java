package tv.danmaku.biliplayerv2.service.interact.core.command;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommandsPanel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "", "<init>", "()V", "tips", "", "getTips", "()Ljava/lang/String;", "setTips", "(Ljava/lang/String;)V", "panels", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel;", "Lkotlin/collections/ArrayList;", "getPanels", "()Ljava/util/ArrayList;", "setPanels", "(Ljava/util/ArrayList;)V", "Panel", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CommandsPanel {
    @JSONField(name = "panels")
    private ArrayList<Panel> panels;
    @JSONField(name = "tips")
    private String tips = "";

    public final String getTips() {
        return this.tips;
    }

    public final void setTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tips = str;
    }

    public final ArrayList<Panel> getPanels() {
        return this.panels;
    }

    public final void setPanels(ArrayList<Panel> arrayList) {
        this.panels = arrayList;
    }

    /* compiled from: CommandsPanel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0004+,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR2\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R2\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006/"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel;", "", "<init>", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "type", "", "getType", "()I", "setType", "(I)V", "tips", "getTips", "setTips", "tipsBelow", "getTipsBelow", "setTipsBelow", "defTxt", "getDefTxt", "setDefTxt", "form", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Form;", "Lkotlin/collections/ArrayList;", "getForm", "()Ljava/util/ArrayList;", "setForm", "(Ljava/util/ArrayList;)V", "drop", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Drop;", "getDrop", "setDrop", "extra", "getExtra", "setExtra", "Form", "Drop", "DropItem", "Extra", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Panel {
        @JSONField(name = "default_text")
        private String defTxt;
        @JSONField(name = "drop")
        private ArrayList<Drop> drop;
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = "form")
        private ArrayList<Form> form;
        @JSONField(name = "tips")
        private String tips;
        @JSONField(name = "tips_below")
        private String tipsBelow;
        @JSONField(name = "type")
        private int type;
        @JSONField(name = "icon")
        private String icon = "";
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title = "";

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final String getTips() {
            return this.tips;
        }

        public final void setTips(String str) {
            this.tips = str;
        }

        public final String getTipsBelow() {
            return this.tipsBelow;
        }

        public final void setTipsBelow(String str) {
            this.tipsBelow = str;
        }

        public final String getDefTxt() {
            return this.defTxt;
        }

        public final void setDefTxt(String str) {
            this.defTxt = str;
        }

        public final ArrayList<Form> getForm() {
            return this.form;
        }

        public final void setForm(ArrayList<Form> arrayList) {
            this.form = arrayList;
        }

        public final ArrayList<Drop> getDrop() {
            return this.drop;
        }

        public final void setDrop(ArrayList<Drop> arrayList) {
            this.drop = arrayList;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }

        /* compiled from: CommandsPanel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\t¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Form;", "", "<init>", "()V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "placeholder", "getPlaceholder", "setPlaceholder", "limit", "", "getLimit", "()I", "setLimit", "(I)V", "hide", "", "getHide", "()Ljava/lang/Boolean;", "setHide", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "tips", "getTips", "setTips", "default", "getDefault", "setDefault", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Form {
            @JSONField(name = "hide")
            private Boolean hide;
            @JSONField(name = "limit")
            private int limit;
            @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
            private String title = "";
            @JSONField(name = "key")
            private String key = "";
            @JSONField(name = "placeholder")
            private String placeholder = "";
            private String tips = "";

            /* renamed from: default  reason: not valid java name */
            private String f0default = "";

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final String getKey() {
                return this.key;
            }

            public final void setKey(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.key = str;
            }

            public final String getPlaceholder() {
                return this.placeholder;
            }

            public final void setPlaceholder(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.placeholder = str;
            }

            public final int getLimit() {
                return this.limit;
            }

            public final void setLimit(int i) {
                this.limit = i;
            }

            public final Boolean getHide() {
                return this.hide;
            }

            public final void setHide(Boolean bool) {
                this.hide = bool;
            }

            public final String getTips() {
                return this.tips;
            }

            public final void setTips(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.tips = str;
            }

            public final String getDefault() {
                return this.f0default;
            }

            public final void setDefault(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.f0default = str;
            }
        }

        /* compiled from: CommandsPanel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR2\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Drop;", "", "<init>", "()V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "list", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$DropItem;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Drop {
            @JSONField(name = "list")
            private ArrayList<DropItem> list;
            @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
            private String title = "";
            @JSONField(name = "key")
            private String key = "";

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final String getKey() {
                return this.key;
            }

            public final void setKey(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.key = str;
            }

            public final ArrayList<DropItem> getList() {
                return this.list;
            }

            public final void setList(ArrayList<DropItem> arrayList) {
                this.list = arrayList;
            }
        }

        /* compiled from: CommandsPanel.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$DropItem;", "", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "resource", "getResource", "setResource", "extra1", "getExtra1", "setExtra1", "extra2", "getExtra2", "setExtra2", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class DropItem {
            @JSONField(name = "id")
            private int id;
            @JSONField(name = "content")
            private String content = "";
            @JSONField(name = "resource")
            private String resource = "";
            @JSONField(name = "extra1")
            private String extra1 = "";
            @JSONField(name = "extra2")
            private String extra2 = "";

            public final int getId() {
                return this.id;
            }

            public final void setId(int i) {
                this.id = i;
            }

            public final String getContent() {
                return this.content;
            }

            public final void setContent(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.content = str;
            }

            public final String getResource() {
                return this.resource;
            }

            public final void setResource(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.resource = str;
            }

            public final String getExtra1() {
                return this.extra1;
            }

            public final void setExtra1(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.extra1 = str;
            }

            public final String getExtra2() {
                return this.extra2;
            }

            public final void setExtra2(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.extra2 = str;
            }
        }

        /* compiled from: CommandsPanel.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Extra;", "", "<init>", "()V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "limit", "getLimit", "setLimit", "defaultKeyword", "", "getDefaultKeyword", "()Ljava/lang/String;", "setDefaultKeyword", "(Ljava/lang/String;)V", "cmtimeType", "getCmtimeType", "setCmtimeType", "cmtimeGuideList", "", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Extra$GuideMaterial;", "getCmtimeGuideList", "()Ljava/util/List;", "setCmtimeGuideList", "(Ljava/util/List;)V", "GuideMaterial", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Extra {
            @JSONField(name = "duration")
            private int duration;
            @JSONField(name = "limit")
            private int limit;
            @JSONField(name = "default_keyword")
            private String defaultKeyword = "";
            @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_TYPE)
            private int cmtimeType = -1;
            @JSONField(name = "cmtime_guide_materials")
            private List<GuideMaterial> cmtimeGuideList = CollectionsKt.emptyList();

            public final int getDuration() {
                return this.duration;
            }

            public final void setDuration(int i) {
                this.duration = i;
            }

            public final int getLimit() {
                return this.limit;
            }

            public final void setLimit(int i) {
                this.limit = i;
            }

            public final String getDefaultKeyword() {
                return this.defaultKeyword;
            }

            public final void setDefaultKeyword(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.defaultKeyword = str;
            }

            public final int getCmtimeType() {
                return this.cmtimeType;
            }

            public final void setCmtimeType(int i) {
                this.cmtimeType = i;
            }

            public final List<GuideMaterial> getCmtimeGuideList() {
                return EnhancedUnmodifiabilityKt.unmodifiable(this.cmtimeGuideList);
            }

            public final void setCmtimeGuideList(List<GuideMaterial> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.cmtimeGuideList = list;
            }

            /* compiled from: CommandsPanel.kt */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel$Panel$Extra$GuideMaterial;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "upperSlogan", "", "getUpperSlogan", "()Ljava/lang/String;", "setUpperSlogan", "(Ljava/lang/String;)V", "userSlogan", "getUserSlogan", "setUserSlogan", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class GuideMaterial {
                @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_ID)
                private long id = -1;
                @JSONField(name = "guide_barrage")
                private String upperSlogan = "";
                @JSONField(name = "heartbeat_barrage")
                private String userSlogan = "";

                public final long getId() {
                    return this.id;
                }

                public final void setId(long j) {
                    this.id = j;
                }

                public final String getUpperSlogan() {
                    return this.upperSlogan;
                }

                public final void setUpperSlogan(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.upperSlogan = str;
                }

                public final String getUserSlogan() {
                    return this.userSlogan;
                }

                public final void setUserSlogan(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.userSlogan = str;
                }
            }
        }
    }
}