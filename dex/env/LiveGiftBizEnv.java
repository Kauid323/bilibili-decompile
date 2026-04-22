package env;

import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import proxy.GiftParentBizType;
import tv.danmaku.android.log.BLog;

/* compiled from: LiveGiftBizEnv.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lenv/LiveGiftBizEnv;", "", "giftParentBizType", "Lproxy/GiftParentBizType;", "<init>", "(Lproxy/GiftParentBizType;)V", "getGiftParentBizType", "()Lproxy/GiftParentBizType;", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveGiftBizEnv {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LiveGiftBizEnv";
    private static volatile LiveGiftBizEnv instance;
    private final GiftParentBizType giftParentBizType;

    public /* synthetic */ LiveGiftBizEnv(GiftParentBizType giftParentBizType, DefaultConstructorMarker defaultConstructorMarker) {
        this(giftParentBizType);
    }

    private LiveGiftBizEnv(GiftParentBizType giftParentBizType) {
        this.giftParentBizType = giftParentBizType;
    }

    public final GiftParentBizType getGiftParentBizType() {
        return this.giftParentBizType;
    }

    /* compiled from: LiveGiftBizEnv.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lenv/LiveGiftBizEnv$Companion;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "TAG", "", "logTag", "getLogTag", "()Ljava/lang/String;", "value", "Lenv/LiveGiftBizEnv;", "instance", "getInstance", "()Lenv/LiveGiftBizEnv;", "init", "", "giftParentBizType", "Lproxy/GiftParentBizType;", "isLive", "", "isBlink", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion implements LiveLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public String getLogTag() {
            return LiveGiftBizEnv.TAG;
        }

        public final LiveGiftBizEnv getInstance() {
            return LiveGiftBizEnv.instance;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:57|(2:58|59)|(3:80|81|(12:83|84|62|63|64|65|66|67|(1:69)|70|(1:72)|73))|61|62|63|64|65|66|67|(0)|70|(0)|73) */
        /* JADX WARN: Can't wrap try/catch for region: R(15:106|107|108|(3:129|130|(12:132|133|111|112|113|114|115|116|(1:118)|119|(1:121)|122))|110|111|112|113|114|115|116|(0)|119|(0)|122) */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x026d, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x026f, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
            r0 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0288  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x0292 A[Catch: all -> 0x02c1, TryCatch #1 {, blocks: (B:62:0x0157, B:64:0x015f, B:67:0x017c, B:69:0x018e, B:71:0x0194, B:73:0x019a, B:80:0x01d5, B:82:0x01e0, B:119:0x02ac, B:121:0x02bc, B:76:0x01c4, B:84:0x01f2, B:86:0x01f9, B:90:0x0210, B:92:0x0224, B:94:0x022a, B:100:0x0242, B:102:0x0249, B:114:0x028b, B:116:0x0292, B:117:0x02a1, B:110:0x027a), top: B:130:0x0157, inners: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02c4 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0155  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void init(GiftParentBizType giftParentBizType) {
            String msg$iv$iv$iv$iv;
            LiveLogDelegate logDelegate;
            LiveGiftBizEnv companion;
            String name;
            LiveGiftBizEnv companion2;
            GiftParentBizType giftParentBizType2;
            String name2;
            String msg$iv$iv$iv$iv2;
            LiveLogDelegate logDelegate2;
            LiveGiftBizEnv companion3;
            String name3;
            LiveGiftBizEnv companion4;
            GiftParentBizType giftParentBizType3;
            String name4;
            String str;
            GiftParentBizType giftParentBizType4;
            String str2;
            GiftParentBizType giftParentBizType5;
            Intrinsics.checkNotNullParameter(giftParentBizType, "giftParentBizType");
            LiveGiftBizEnv.instance = null;
            Companion $this$logDebug_u24default$iv = this;
            LiveLog.Companion this_$iv$iv = LiveLog.Companion;
            String tag$iv$iv = $this$logDebug_u24default$iv.getLogTag();
            if (this_$iv$iv.isDebug()) {
                try {
                    LiveGiftBizEnv companion5 = LiveGiftBizEnv.Companion.getInstance();
                    String name5 = giftParentBizType.name();
                    LiveGiftBizEnv companion6 = LiveGiftBizEnv.Companion.getInstance();
                    str2 = "init instance " + companion5 + " giftParentBizType = " + name5 + ", currentBiz = " + ((companion6 == null || (giftParentBizType5 = companion6.getGiftParentBizType()) == null) ? null : giftParentBizType5.name());
                } catch (Exception e$iv$iv$iv) {
                    BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                    str2 = null;
                }
                String msg$iv$iv$iv = str2;
                if (msg$iv$iv$iv == null) {
                    msg$iv$iv$iv = "";
                }
                BLog.d(tag$iv$iv, msg$iv$iv$iv);
                LiveLogDelegate logDelegate3 = this_$iv$iv.getLogDelegate();
                if (logDelegate3 != null) {
                    LiveLogDelegate.-CC.onLog$default(logDelegate3, 4, tag$iv$iv, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
                }
            } else if (this_$iv$iv.matchLevel(4) && this_$iv$iv.matchLevel(3)) {
                try {
                    companion = LiveGiftBizEnv.Companion.getInstance();
                    name = giftParentBizType.name();
                    companion2 = LiveGiftBizEnv.Companion.getInstance();
                } catch (Exception e2) {
                    e$iv$iv$iv$iv = e2;
                }
                if (companion2 != null) {
                    try {
                        giftParentBizType2 = companion2.getGiftParentBizType();
                    } catch (Exception e3) {
                        e$iv$iv$iv$iv = e3;
                        BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv);
                        msg$iv$iv$iv$iv = null;
                        if (msg$iv$iv$iv$iv == null) {
                        }
                        logDelegate = this_$iv$iv.getLogDelegate();
                        if (logDelegate != null) {
                        }
                        BLog.i(tag$iv$iv, msg$iv$iv$iv$iv);
                        if (getInstance() == null) {
                        }
                    }
                    if (giftParentBizType2 != null) {
                        name2 = giftParentBizType2.name();
                        msg$iv$iv$iv$iv = "init instance " + companion + " giftParentBizType = " + name + ", currentBiz = " + name2;
                        if (msg$iv$iv$iv$iv == null) {
                            msg$iv$iv$iv$iv = "";
                        }
                        logDelegate = this_$iv$iv.getLogDelegate();
                        if (logDelegate != null) {
                            LiveLogDelegate.-CC.onLog$default(logDelegate, 3, tag$iv$iv, msg$iv$iv$iv$iv, (Throwable) null, 8, (Object) null);
                        }
                        BLog.i(tag$iv$iv, msg$iv$iv$iv$iv);
                    }
                }
                name2 = null;
                msg$iv$iv$iv$iv = "init instance " + companion + " giftParentBizType = " + name + ", currentBiz = " + name2;
                if (msg$iv$iv$iv$iv == null) {
                }
                logDelegate = this_$iv$iv.getLogDelegate();
                if (logDelegate != null) {
                }
                BLog.i(tag$iv$iv, msg$iv$iv$iv$iv);
            }
            if (getInstance() == null) {
                synchronized (this) {
                    if (LiveGiftBizEnv.Companion.getInstance() == null) {
                        LiveLogger $this$logDebug_u24default$iv2 = LiveGiftBizEnv.Companion;
                        LiveLog.Companion this_$iv$iv2 = LiveLog.Companion;
                        String tag$iv$iv2 = $this$logDebug_u24default$iv2.getLogTag();
                        if (this_$iv$iv2.isDebug()) {
                            try {
                                LiveGiftBizEnv companion7 = LiveGiftBizEnv.Companion.getInstance();
                                String name6 = giftParentBizType.name();
                                LiveGiftBizEnv companion8 = LiveGiftBizEnv.Companion.getInstance();
                                str = "secondary init instance " + companion7 + " giftParentBizType = " + name6 + ", currentBiz = " + ((companion8 == null || (giftParentBizType4 = companion8.getGiftParentBizType()) == null) ? null : giftParentBizType4.name());
                            } catch (Exception e$iv$iv$iv2) {
                                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv2);
                                str = null;
                            }
                            String msg$iv$iv$iv2 = str;
                            if (msg$iv$iv$iv2 == null) {
                                msg$iv$iv$iv2 = "";
                            }
                            BLog.d(tag$iv$iv2, msg$iv$iv$iv2);
                            LiveLogDelegate logDelegate4 = this_$iv$iv2.getLogDelegate();
                            if (logDelegate4 != null) {
                                LiveLogDelegate.-CC.onLog$default(logDelegate4, 4, tag$iv$iv2, msg$iv$iv$iv2, (Throwable) null, 8, (Object) null);
                            }
                        } else if (this_$iv$iv2.matchLevel(4) && this_$iv$iv2.matchLevel(3)) {
                            try {
                                companion3 = LiveGiftBizEnv.Companion.getInstance();
                                name3 = giftParentBizType.name();
                                companion4 = LiveGiftBizEnv.Companion.getInstance();
                            } catch (Exception e4) {
                                e$iv$iv$iv$iv = e4;
                            }
                            if (companion4 != null) {
                                try {
                                    giftParentBizType3 = companion4.getGiftParentBizType();
                                } catch (Exception e5) {
                                    e$iv$iv$iv$iv = e5;
                                    BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv);
                                    msg$iv$iv$iv$iv2 = null;
                                    if (msg$iv$iv$iv$iv2 == null) {
                                    }
                                    logDelegate2 = this_$iv$iv2.getLogDelegate();
                                    if (logDelegate2 != null) {
                                    }
                                    BLog.i(tag$iv$iv2, msg$iv$iv$iv$iv2);
                                    Companion companion9 = LiveGiftBizEnv.Companion;
                                    LiveGiftBizEnv.instance = new LiveGiftBizEnv(giftParentBizType, null);
                                    Unit unit = Unit.INSTANCE;
                                }
                                if (giftParentBizType3 != null) {
                                    name4 = giftParentBizType3.name();
                                    msg$iv$iv$iv$iv2 = "secondary init instance " + companion3 + " giftParentBizType = " + name3 + ", currentBiz = " + name4;
                                    if (msg$iv$iv$iv$iv2 == null) {
                                        msg$iv$iv$iv$iv2 = "";
                                    }
                                    logDelegate2 = this_$iv$iv2.getLogDelegate();
                                    if (logDelegate2 != null) {
                                        LiveLogDelegate.-CC.onLog$default(logDelegate2, 3, tag$iv$iv2, msg$iv$iv$iv$iv2, (Throwable) null, 8, (Object) null);
                                    }
                                    BLog.i(tag$iv$iv2, msg$iv$iv$iv$iv2);
                                }
                            }
                            name4 = null;
                            msg$iv$iv$iv$iv2 = "secondary init instance " + companion3 + " giftParentBizType = " + name3 + ", currentBiz = " + name4;
                            if (msg$iv$iv$iv$iv2 == null) {
                            }
                            logDelegate2 = this_$iv$iv2.getLogDelegate();
                            if (logDelegate2 != null) {
                            }
                            BLog.i(tag$iv$iv2, msg$iv$iv$iv$iv2);
                        }
                        Companion companion92 = LiveGiftBizEnv.Companion;
                        LiveGiftBizEnv.instance = new LiveGiftBizEnv(giftParentBizType, null);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        public final boolean isLive() {
            LiveGiftBizEnv companion = getInstance();
            return (companion != null ? companion.getGiftParentBizType() : null) == GiftParentBizType.LIVE;
        }

        public final boolean isBlink() {
            LiveGiftBizEnv companion = getInstance();
            return (companion != null ? companion.getGiftParentBizType() : null) == GiftParentBizType.BLINK;
        }
    }
}