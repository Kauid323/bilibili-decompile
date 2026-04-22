package tv.danmaku.biliplayerv2.widget.toast;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: PlayerToast.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 L2\u00020\u0001:\u0003JKLB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\b\u0001\u00104\u001a\u00020\u0007J\u0018\u00105\u001a\u0002012\u0006\u00102\u001a\u0002032\b\b\u0001\u00104\u001a\u00020\u0007J\u0018\u00106\u001a\u0002012\u0006\u00102\u001a\u0002032\b\b\u0001\u00104\u001a\u00020\u0007J\u0016\u00107\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0016\u00108\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000209J\u0016\u0010:\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020;J\u0016\u0010<\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J\u0016\u0010=\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020>J\u0016\u0010?\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020@J\u000e\u0010A\u001a\u00020\u00072\u0006\u00102\u001a\u000203J\u0016\u0010A\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u0010B\u001a\u00020\u0007J\u0010\u0010C\u001a\u0004\u0018\u0001032\u0006\u00102\u001a\u000203J\u0015\u0010D\u001a\u0004\u0018\u00010>2\u0006\u00102\u001a\u000203¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u0002092\u0006\u00102\u001a\u0002032\u0006\u0010B\u001a\u000209J\u0010\u0010G\u001a\u0004\u0018\u00010@2\u0006\u00102\u001a\u000203J\u0010\u0010H\u001a\u0004\u0018\u00010;2\u0006\u00102\u001a\u000203J\b\u0010I\u001a\u00020\u0000H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u0006M"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "", "mToastExtra", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "queueType", "getQueueType", "setQueueType", "toastType", "getToastType", "setToastType", "location", "getLocation", "setLocation", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "refreshDuration", "getRefreshDuration", "setRefreshDuration", "createTime", "getCreateTime", "setCreateTime", "clickListener", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener;", "getClickListener", "()Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener;", "setClickListener", "(Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "toastView", "getToastView", "setToastView", "setExtraLayoutId", "", "key", "", "value", "setExtraColorResource", "setExtraDrawableResource", "setExtraInt", "setExtraBoolean", "", "setExtraIntArray", "", "setExtraString", "setExtraFloat", "", "setExtraParcelable", "Landroid/os/Parcelable;", "getExtraIntValue", "defaultValue", "getExtraString", "getExtraFloatValue", "(Ljava/lang/String;)Ljava/lang/Float;", "getExtraBooleanValue", "getExtraParcelable", "getExtraIntArray", "clone", "MessageClickListener", "Builder", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerToast implements Cloneable {
    public static final Companion Companion = new Companion(null);
    private MessageClickListener clickListener;
    private long createTime;
    private View customView;
    private long duration;
    private int level;
    private int location;
    private final Bundle mToastExtra;
    private int queueType;
    private long refreshDuration;
    private int toastType;
    private View toastView;

    public /* synthetic */ PlayerToast(Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle);
    }

    private PlayerToast(Bundle mToastExtra) {
        this.mToastExtra = mToastExtra;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final int getQueueType() {
        return this.queueType;
    }

    public final void setQueueType(int i) {
        this.queueType = i;
    }

    public final int getToastType() {
        return this.toastType;
    }

    public final void setToastType(int i) {
        this.toastType = i;
    }

    public final int getLocation() {
        return this.location;
    }

    public final void setLocation(int i) {
        this.location = i;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final long getRefreshDuration() {
        return this.refreshDuration;
    }

    public final void setRefreshDuration(long j) {
        this.refreshDuration = j;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final MessageClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(MessageClickListener messageClickListener) {
        this.clickListener = messageClickListener;
    }

    public final View getCustomView() {
        return this.customView;
    }

    public final void setCustomView(View view2) {
        this.customView = view2;
    }

    public final View getToastView() {
        return this.toastView;
    }

    public final void setToastView(View view2) {
        this.toastView = view2;
    }

    /* compiled from: PlayerToast.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener;", "", "onActionWithCollapse", "", "clickId", "", "isCollapse", "", "onDismiss", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface MessageClickListener {
        public static final Companion Companion = Companion.$$INSTANCE;

        void onActionWithCollapse(int i, boolean z);

        void onDismiss();

        /* compiled from: PlayerToast.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener$Companion;", "", "<init>", "()V", "CLICK_ID1", "", "getCLICK_ID1", "()I", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final int CLICK_ID1 = 1;

            private Companion() {
            }

            public final int getCLICK_ID1() {
                return CLICK_ID1;
            }
        }
    }

    public final void setExtraLayoutId(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setExtraInt(key, value);
    }

    public final void setExtraColorResource(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setExtraInt(key, value);
    }

    public final void setExtraDrawableResource(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setExtraInt(key, value);
    }

    public final void setExtraInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mToastExtra.putInt(key, value);
    }

    public final void setExtraBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mToastExtra.putBoolean(key, value);
    }

    public final void setExtraIntArray(String key, int[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mToastExtra.putIntArray(key, value);
    }

    public final void setExtraString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mToastExtra.putString(key, value);
    }

    public final void setExtraFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mToastExtra.putFloat(key, value);
    }

    public final void setExtraParcelable(String key, Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mToastExtra.putParcelable(key, value);
    }

    public final int getExtraIntValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getInt(key, -1);
    }

    public final int getExtraIntValue(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getInt(key, defaultValue);
    }

    public final String getExtraString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getString(key, "");
    }

    public final Float getExtraFloatValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return Float.valueOf(this.mToastExtra.getFloat(key, -1.0f));
    }

    public final boolean getExtraBooleanValue(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getBoolean(key, defaultValue);
    }

    public final Parcelable getExtraParcelable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getParcelable(key);
    }

    public final int[] getExtraIntArray(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mToastExtra.getIntArray(key);
    }

    /* compiled from: PlayerToast.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0005J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0005J\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0010J\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$Builder;", "", "<init>", "()V", "level", "", "queueType", "toastType", "location", "refreshDuration", "", "duration", "createTime", "listener", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$MessageClickListener;", "mCustomView", "Landroid/view/View;", "mExtra", "Landroid/os/Bundle;", "type", "toastItemType", "itemType", "messageClickListener", "setExtraLayoutId", "key", "", "value", "setExtraColorResource", "setExtraDrawableResource", "setExtraBoolean", "", "setExtraInt", "setExtraString", "setExtraFloat", "", "setExtraParcelable", "Landroid/os/Parcelable;", "setExtraIntArray", "", "setCustomView", "view", "build", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private MessageClickListener listener;
        private View mCustomView;
        private int level = 1;
        private int queueType = 48;
        private int toastType = -1;
        private int location = 32;
        private long refreshDuration = -1;
        private long duration = -1;
        private long createTime = -1;
        private final Bundle mExtra = new Bundle();

        public final Builder level(int level) {
            if (level >= 1 && level <= 5) {
                this.level = level;
            } else {
                PlayerLog.e(PlayerLogModule.Toast, "player toast level is illegal!!! ");
            }
            return this;
        }

        public final Builder queueType(int type) {
            this.queueType = type;
            return this;
        }

        public final Builder toastItemType(int itemType) {
            this.toastType = itemType;
            return this;
        }

        public final Builder location(int location) {
            this.location = location;
            return this;
        }

        public final Builder refreshDuration(long duration) {
            if (duration >= -1 && duration <= PlayerToastConfig.DURATION_FOREVER) {
                this.refreshDuration = duration;
            } else {
                PlayerLog.e(PlayerLogModule.Toast, " player toast refresh duration illegal");
            }
            return this;
        }

        public final Builder createTime(long createTime) {
            if (createTime > 0) {
                this.createTime = createTime;
            }
            return this;
        }

        public final Builder duration(long duration) {
            if (duration >= 1000 && duration <= PlayerToastConfig.DURATION_FOREVER) {
                this.duration = duration;
            } else {
                PlayerLog.e(PlayerLogModule.Toast, " player toast duration illegal");
            }
            return this;
        }

        public final Builder messageClickListener(MessageClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder setExtraLayoutId(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return setExtraInt(key, value);
        }

        public final Builder setExtraColorResource(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return setExtraInt(key, value);
        }

        public final Builder setExtraDrawableResource(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return setExtraInt(key, value);
        }

        public final Builder setExtraBoolean(String key, boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mExtra.putBoolean(key, value);
            return this;
        }

        public final Builder setExtraInt(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mExtra.putInt(key, value);
            return this;
        }

        public final Builder setExtraString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.mExtra.putString(key, value);
            return this;
        }

        public final Builder setExtraFloat(String key, float value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mExtra.putFloat(key, value);
            return this;
        }

        public final Builder setExtraParcelable(String key, Parcelable value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.mExtra.putParcelable(key, value);
            return this;
        }

        public final Builder setExtraIntArray(String key, int[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.mExtra.putIntArray(key, value);
            return this;
        }

        public final Builder setCustomView(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.mCustomView = view2;
            return this;
        }

        public final PlayerToast build() {
            PlayerToast toast = new PlayerToast(new Bundle(this.mExtra), null);
            toast.setLevel(this.level);
            toast.setQueueType(this.queueType);
            toast.setToastType(this.toastType);
            toast.setLocation(this.location);
            toast.setDuration(this.duration);
            toast.setClickListener(this.listener);
            toast.setRefreshDuration(this.refreshDuration);
            toast.setCustomView(this.mCustomView);
            if (this.location == 32) {
                if (this.toastType >= 22 || this.toastType <= 16) {
                    throw new IllegalArgumentException("player toast type is illegal, have you define it in PlayerToastConfig class ?");
                }
                if (this.duration <= 0) {
                    throw new IllegalArgumentException("player toast duration is illegal!");
                }
            }
            if (this.createTime > 0) {
                toast.setCreateTime(this.createTime);
            } else {
                toast.setCreateTime(PlayerToast.Companion.generateCreateTimeMillis());
            }
            return toast;
        }
    }

    public PlayerToast clone() {
        PlayerToast newToast = new PlayerToast(new Bundle(this.mToastExtra));
        newToast.level = this.level;
        newToast.toastType = this.toastType;
        newToast.queueType = this.queueType;
        newToast.duration = this.duration;
        newToast.clickListener = this.clickListener;
        newToast.createTime = this.createTime;
        newToast.location = this.location;
        newToast.refreshDuration = this.refreshDuration;
        return newToast;
    }

    /* compiled from: PlayerToast.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast$Companion;", "", "<init>", "()V", "generateCreateTimeMillis", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long generateCreateTimeMillis() {
            return System.currentTimeMillis();
        }
    }
}