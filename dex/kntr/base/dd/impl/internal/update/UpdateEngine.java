package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.data.IDataCenter;
import kntr.base.dd.impl.internal.downloader.DDDownloader;
import kntr.base.dd.impl.internal.file.DDFileSystem;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDModelKt;
import kntr.base.dd.impl.internal.update.UpdateException;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: UpdateEngine.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u00013B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00032\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0082@¢\u0006\u0002\u0010#J\"\u0010$\u001a\u00020%2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010&\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'J\"\u0010(\u001a\u00020\n2\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010&\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'J2\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003H\u0082@¢\u0006\u0002\u00100J\u001c\u00101\u001a\u00020\u00132\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0015\u001a\u00020\"H\u0002J\u001c\u00102\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateEngine;", "Lkntr/base/dd/impl/internal/update/IDDUpdateEngine;", "host", "", "appKey", "fs", "Lkntr/base/dd/impl/internal/file/DDFileSystem;", "dataCenter", "Lkntr/base/dd/impl/internal/data/IDataCenter;", "canPerformUpdate", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/impl/internal/file/DDFileSystem;Lkntr/base/dd/impl/internal/data/IDataCenter;Z)V", "downloader", "Lkntr/base/dd/impl/internal/downloader/DDDownloader;", "updating", "Lkotlinx/atomicfu/AtomicBoolean;", "update", "Lkotlin/Result;", "", "from", AppKey.VERSION, "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "Lkntr/base/dd/impl/internal/common/DDEnv;", "force", "update-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fallback", "fallback-0E7RQCE", "(Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOnlineConfigInfo", "Lkntr/base/dd/impl/internal/update/UpdateInfoModel;", "localV", "", "(Ljava/lang/String;JLkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOnlineConfigData", "Lkntr/base/dd/impl/internal/model/DDModel;", "info", "(Lkntr/base/dd/IDeviceDecision$Version$Env;Lkntr/base/dd/impl/internal/update/UpdateInfoModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchOldData", "download", "type", "Lkntr/base/dd/impl/internal/update/UpdateEngine$FileType;", "url", "path", "Lkotlinx/io/files/Path;", "md5", "(Lkntr/base/dd/impl/internal/update/UpdateEngine$FileType;Ljava/lang/String;Lkotlinx/io/files/Path;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clean", "infoURL", "FileType", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpdateEngine implements IDDUpdateEngine {
    private final String appKey;
    private final boolean canPerformUpdate;
    private final IDataCenter dataCenter;
    private final DDDownloader downloader;
    private final DDFileSystem fs;
    private final String host;
    private final AtomicBoolean updating;

    public UpdateEngine(String host, String appKey, DDFileSystem fs, IDataCenter dataCenter, boolean canPerformUpdate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(fs, "fs");
        Intrinsics.checkNotNullParameter(dataCenter, "dataCenter");
        this.host = host;
        this.appKey = appKey;
        this.fs = fs;
        this.dataCenter = dataCenter;
        this.canPerformUpdate = canPerformUpdate;
        this.downloader = new DDDownloader();
        this.updating = AtomicFU.atomic(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ UpdateEngine(String str, String str2, DDFileSystem dDFileSystem, IDataCenter iDataCenter, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, dDFileSystem, iDataCenter, r5);
        boolean z2;
        if ((i & 16) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateEngine.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0012"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateEngine$FileType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Info", "Data", "Patch", "path", "Lkotlinx/io/files/Path;", "fs", "Lkntr/base/dd/impl/internal/file/DDFileSystem;", "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "Lkntr/base/dd/impl/internal/common/DDEnv;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum FileType {
        Info("info"),
        Data("data"),
        Patch("patch");
        
        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<FileType> getEntries() {
            return $ENTRIES;
        }

        FileType(String value) {
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }

        public final Path path(DDFileSystem fs, IDeviceDecision.Version.Env env) {
            Intrinsics.checkNotNullParameter(fs, "fs");
            Intrinsics.checkNotNullParameter(env, "env");
            return fs.path("updater", env.getValue(), this.value);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x043b, code lost:
        if (r5 == null) goto L61;
     */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0390: MOVE  (r7 I:??[long, double]) = (r22 I:??[long, double] A[D('localV' long)]), block:B:161:0x0390 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a9: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY] A[D('env' kntr.base.dd.IDeviceDecision$Version$Env)]), block:B:19:0x00a9 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032a A[LOOP:1: B:130:0x0302->B:143:0x032a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x032d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x022b A[Catch: all -> 0x02dd, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x02dd, blocks: (B:75:0x0202, B:86:0x022b), top: B:222:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029e  */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    @Override // kntr.base.dd.impl.internal.update.IDDUpdateEngine
    /* renamed from: update-yxL6bBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1365updateyxL6bBk(String from, String version, IDeviceDecision.Version.Env env, boolean force, Continuation<? super Result<Unit>> continuation) {
        UpdateEngine$update$1 updateEngine$update$1;
        UpdateEngine$update$1 updateEngine$update$12;
        IDeviceDecision.Version.Env env2;
        String str;
        char c;
        boolean force2;
        String str2;
        long localV;
        UpdateEngine $this$update_yxL6bBk_u24lambda_u240;
        String str3;
        AtomicBoolean $this$update$iv;
        boolean cur$iv;
        boolean z;
        UpdateEngine updateEngine;
        boolean z2;
        char c2;
        boolean force3;
        Object m2636constructorimpl;
        char c3;
        boolean force4;
        Throwable e;
        Pair pair;
        String str4;
        long localV2;
        AtomicBoolean $this$update$iv2;
        int i;
        int i2;
        char c4;
        int i3;
        char c5;
        int i4;
        String str5;
        Object fetchOnlineConfigInfo;
        char c6;
        boolean force5;
        Object fetchOnlineConfigData;
        UpdateInfoModel info;
        char c7;
        boolean force6;
        String from2;
        AtomicBoolean $this$update$iv3;
        boolean cur$iv2;
        UpdateEngine updateEngine2 = this;
        String from3 = from;
        String version2 = version;
        IDeviceDecision.Version.Env env3 = env;
        ?? r11 = force;
        try {
            if (continuation instanceof UpdateEngine$update$1) {
                updateEngine$update$1 = (UpdateEngine$update$1) continuation;
                if ((updateEngine$update$1.label & Integer.MIN_VALUE) != 0) {
                    updateEngine$update$1.label -= Integer.MIN_VALUE;
                    updateEngine$update$12 = updateEngine$update$1;
                    Object $result = updateEngine$update$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (updateEngine$update$12.label) {
                        case 0:
                            str2 = "from";
                            ResultKt.throwOnFailure($result);
                            if (!updateEngine2.canPerformUpdate) {
                                String msg = "current process <" + DDConst.INSTANCE.getProcessName() + "> not be allowed to update.";
                                DDConst.INSTANCE.logI(msg);
                                Result.Companion companion = Result.Companion;
                                return Result.m2636constructorimpl(ResultKt.createFailure(new IllegalStateException(msg)));
                            }
                            localV = updateEngine2.dataCenter.dataWithEnv(env3).getVersion();
                            UpdateEngine longRef = new Ref.LongRef();
                            Long longOrNull = StringsKt.toLongOrNull(version);
                            ((Ref.LongRef) longRef).element = longOrNull != null ? longOrNull.longValue() : 0L;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                $this$update_yxL6bBk_u24lambda_u240 = updateEngine2;
                                str3 = null;
                                i = 0;
                                try {
                                } catch (Throwable th) {
                                    th = th;
                                    localV = localV2;
                                    force3 = r11;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                updateEngine2 = longRef;
                                str = "latest";
                                str3 = str2;
                                c2 = 1;
                                force3 = r11;
                            }
                            if (from3.length() == 0) {
                                throw new UpdateException.ParamsInvalid(str2);
                            }
                            if ($this$update_yxL6bBk_u24lambda_u240.updating.getValue()) {
                                throw new UpdateException.AlreadyUpdating();
                            }
                            if (r11 == 0) {
                                str = "latest";
                                try {
                                    if (localV >= ((Ref.LongRef) longRef).element) {
                                        throw new UpdateException.NoNeedToUpdate(localV, ((Ref.LongRef) longRef).element, false, 4, null);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    updateEngine2 = longRef;
                                    str3 = str2;
                                    c2 = 1;
                                    force3 = r11;
                                    Result.Companion companion3 = Result.Companion;
                                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                    force4 = force3;
                                    c3 = c2;
                                    Object result = m2636constructorimpl;
                                    e = Result.m2639exceptionOrNullimpl(result);
                                    if (e == null) {
                                    }
                                    pair = TuplesKt.to(Boxing.boxInt(0), "");
                                    int code = ((Number) pair.component1()).intValue();
                                    String msg2 = (String) pair.component2();
                                    DDConst dDConst = DDConst.INSTANCE;
                                    Pair[] pairArr = new Pair[7];
                                    pairArr[0] = TuplesKt.to(str3, from3);
                                    pairArr[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                                    pairArr[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                                    pairArr[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result) ? "1" : "0");
                                    pairArr[4] = TuplesKt.to("error_code", String.valueOf(code));
                                    pairArr[5] = TuplesKt.to("error_message", msg2);
                                    pairArr[6] = TuplesKt.to("flag", "v2");
                                    dDConst.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr));
                                    return m2636constructorimpl;
                                }
                            } else {
                                str = "latest";
                            }
                            try {
                                $this$update$iv2 = $this$update_yxL6bBk_u24lambda_u240.updating;
                            } catch (Throwable th4) {
                                th = th4;
                                updateEngine2 = longRef;
                                str3 = str2;
                                c2 = 1;
                                force3 = r11;
                            }
                            while (true) {
                                boolean cur$iv3 = $this$update$iv2.getValue();
                                if (cur$iv3) {
                                }
                                if ($this$update$iv2.compareAndSet(cur$iv3, 1 != 0)) {
                                    try {
                                        DDConst dDConst2 = DDConst.INSTANCE;
                                        String str6 = version2;
                                        if (str6.length() == 0) {
                                            str6 = str;
                                        }
                                        dDConst2.logI("start upgrade " + localV + " to " + ((Object) str6) + " on process<" + DDConst.INSTANCE.getProcessName() + ">.");
                                        try {
                                            updateEngine$update$12.L$0 = from3;
                                            updateEngine$update$12.L$1 = version2;
                                            updateEngine$update$12.L$2 = env3;
                                            updateEngine$update$12.L$3 = longRef;
                                            updateEngine$update$12.L$4 = $this$update_yxL6bBk_u24lambda_u240;
                                            updateEngine$update$12.Z$0 = r11;
                                            updateEngine$update$12.J$0 = localV;
                                            updateEngine$update$12.I$0 = i;
                                            try {
                                                updateEngine$update$12.label = 1;
                                                i3 = i;
                                                c5 = 1;
                                                updateEngine2 = longRef;
                                                i4 = 2;
                                                str5 = str2;
                                                try {
                                                    fetchOnlineConfigInfo = $this$update_yxL6bBk_u24lambda_u240.fetchOnlineConfigInfo(version, localV, env, updateEngine$update$12);
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    str2 = str5;
                                                    $this$update_yxL6bBk_u24lambda_u240 = $this$update_yxL6bBk_u24lambda_u240;
                                                    localV = localV;
                                                    force2 = r11;
                                                    c = c5;
                                                    try {
                                                        $this$update$iv = $this$update_yxL6bBk_u24lambda_u240.updating;
                                                        while (true) {
                                                            cur$iv = $this$update$iv.getValue();
                                                            if (!cur$iv) {
                                                                boolean z3 = c == 1 ? 1 : 0;
                                                            }
                                                            z = !cur$iv ? c == 1 ? 1 : 0 : false;
                                                            if (0 == 0) {
                                                                updateEngine = updateEngine2;
                                                                z2 = c == 1 ? 1 : 0;
                                                            } else {
                                                                updateEngine = updateEngine2;
                                                                z2 = false;
                                                            }
                                                            try {
                                                                if (!$this$update$iv.compareAndSet(z, z2)) {
                                                                    throw th;
                                                                }
                                                                updateEngine2 = updateEngine;
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                updateEngine2 = updateEngine;
                                                                str3 = str2;
                                                                force3 = force2;
                                                                c2 = c;
                                                                Result.Companion companion32 = Result.Companion;
                                                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                                                force4 = force3;
                                                                c3 = c2;
                                                                Object result2 = m2636constructorimpl;
                                                                e = Result.m2639exceptionOrNullimpl(result2);
                                                                if (e == null) {
                                                                }
                                                                pair = TuplesKt.to(Boxing.boxInt(0), "");
                                                                int code2 = ((Number) pair.component1()).intValue();
                                                                String msg22 = (String) pair.component2();
                                                                DDConst dDConst3 = DDConst.INSTANCE;
                                                                Pair[] pairArr2 = new Pair[7];
                                                                pairArr2[0] = TuplesKt.to(str3, from3);
                                                                pairArr2[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                                                                pairArr2[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                                                                pairArr2[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result2) ? "1" : "0");
                                                                pairArr2[4] = TuplesKt.to("error_code", String.valueOf(code2));
                                                                pairArr2[5] = TuplesKt.to("error_message", msg22);
                                                                pairArr2[6] = TuplesKt.to("flag", "v2");
                                                                dDConst3.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr2));
                                                                return m2636constructorimpl;
                                                            }
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        str3 = str2;
                                                        force3 = force2;
                                                        c2 = c;
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                c4 = 1;
                                                i2 = i;
                                                updateEngine2 = longRef;
                                                force2 = r11;
                                                c = c4;
                                                $this$update$iv = $this$update_yxL6bBk_u24lambda_u240.updating;
                                                while (true) {
                                                    cur$iv = $this$update$iv.getValue();
                                                    if (!cur$iv) {
                                                    }
                                                    if (!cur$iv) {
                                                    }
                                                    if (0 == 0) {
                                                    }
                                                    if (!$this$update$iv.compareAndSet(z, z2)) {
                                                    }
                                                    updateEngine2 = updateEngine;
                                                }
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            i2 = i;
                                            updateEngine2 = longRef;
                                            c4 = 1;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        updateEngine2 = longRef;
                                        c2 = 1;
                                        str3 = str2;
                                        force3 = r11;
                                        Result.Companion companion322 = Result.Companion;
                                        m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                        force4 = force3;
                                        c3 = c2;
                                        Object result22 = m2636constructorimpl;
                                        e = Result.m2639exceptionOrNullimpl(result22);
                                        if (e == null) {
                                        }
                                        pair = TuplesKt.to(Boxing.boxInt(0), "");
                                        int code22 = ((Number) pair.component1()).intValue();
                                        String msg222 = (String) pair.component2();
                                        DDConst dDConst32 = DDConst.INSTANCE;
                                        Pair[] pairArr22 = new Pair[7];
                                        pairArr22[0] = TuplesKt.to(str3, from3);
                                        pairArr22[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                                        pairArr22[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                                        pairArr22[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result22) ? "1" : "0");
                                        pairArr22[4] = TuplesKt.to("error_code", String.valueOf(code22));
                                        pairArr22[5] = TuplesKt.to("error_message", msg222);
                                        pairArr22[6] = TuplesKt.to("flag", "v2");
                                        dDConst32.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr22));
                                        return m2636constructorimpl;
                                    }
                                    if (fetchOnlineConfigInfo == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$update_yxL6bBk_u24lambda_u240 = $this$update_yxL6bBk_u24lambda_u240;
                                    localV = localV;
                                    force5 = r11;
                                    c6 = c5;
                                    try {
                                        UpdateInfoModel info2 = (UpdateInfoModel) fetchOnlineConfigInfo;
                                        ((Ref.LongRef) updateEngine2).element = info2.getVersion();
                                        if (localV < ((Ref.LongRef) updateEngine2).element) {
                                            try {
                                                throw new UpdateException.NoNeedToUpdate(localV, ((Ref.LongRef) updateEngine2).element, force5 ? c6 == 1 ? 1 : 0 : false);
                                            } catch (Throwable th11) {
                                                th = th11;
                                                str2 = str5;
                                                force2 = force5;
                                                c = c6;
                                                $this$update$iv = $this$update_yxL6bBk_u24lambda_u240.updating;
                                                while (true) {
                                                    cur$iv = $this$update$iv.getValue();
                                                    if (!cur$iv) {
                                                    }
                                                    if (!cur$iv) {
                                                    }
                                                    if (0 == 0) {
                                                    }
                                                    if (!$this$update$iv.compareAndSet(z, z2)) {
                                                    }
                                                    updateEngine2 = updateEngine;
                                                }
                                            }
                                        } else {
                                            updateEngine$update$12.L$0 = from3;
                                            updateEngine$update$12.L$1 = version2;
                                            updateEngine$update$12.L$2 = env3;
                                            updateEngine$update$12.L$3 = updateEngine2;
                                            updateEngine$update$12.L$4 = $this$update_yxL6bBk_u24lambda_u240;
                                            updateEngine$update$12.L$5 = SpillingKt.nullOutSpilledVariable(info2);
                                            updateEngine$update$12.Z$0 = force5;
                                            updateEngine$update$12.J$0 = localV;
                                            updateEngine$update$12.I$0 = i3;
                                            updateEngine$update$12.label = i4;
                                            fetchOnlineConfigData = $this$update_yxL6bBk_u24lambda_u240.fetchOnlineConfigData(env3, info2, updateEngine$update$12);
                                            if (fetchOnlineConfigData == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            info = info2;
                                            force6 = force5;
                                            c7 = c6;
                                            try {
                                                DDModel model = (DDModel) fetchOnlineConfigData;
                                                $this$update_yxL6bBk_u24lambda_u240.dataCenter.currentData().updateWithModel(model);
                                                str2 = str5;
                                                try {
                                                    from2 = from3;
                                                    try {
                                                        DDConst.INSTANCE.logI("update success { env: " + env3.getValue() + ", version: " + ((Ref.LongRef) updateEngine2).element + " }.");
                                                        $this$update_yxL6bBk_u24lambda_u240.clean(env3, ((Ref.LongRef) updateEngine2).element);
                                                        try {
                                                            $this$update$iv3 = $this$update_yxL6bBk_u24lambda_u240.updating;
                                                            do {
                                                                cur$iv2 = $this$update$iv3.getValue();
                                                                if (!cur$iv2) {
                                                                    boolean z4 = c7 == 1 ? 1 : 0;
                                                                }
                                                            } while (!$this$update$iv3.compareAndSet(!cur$iv2 ? c7 == 1 ? 1 : 0 : false, 0 == 0 ? c7 == 1 ? 1 : 0 : false));
                                                            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                                                            from3 = from2;
                                                            str3 = str2;
                                                            force4 = force6;
                                                            c3 = c7;
                                                        } catch (Throwable th12) {
                                                            th = th12;
                                                            from3 = from2;
                                                            str3 = str2;
                                                            force3 = force6;
                                                            c2 = c7;
                                                            Result.Companion companion3222 = Result.Companion;
                                                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                                            force4 = force3;
                                                            c3 = c2;
                                                            Object result222 = m2636constructorimpl;
                                                            e = Result.m2639exceptionOrNullimpl(result222);
                                                            if (e == null) {
                                                            }
                                                            pair = TuplesKt.to(Boxing.boxInt(0), "");
                                                            int code222 = ((Number) pair.component1()).intValue();
                                                            String msg2222 = (String) pair.component2();
                                                            DDConst dDConst322 = DDConst.INSTANCE;
                                                            Pair[] pairArr222 = new Pair[7];
                                                            pairArr222[0] = TuplesKt.to(str3, from3);
                                                            pairArr222[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                                                            pairArr222[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                                                            pairArr222[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result222) ? "1" : "0");
                                                            pairArr222[4] = TuplesKt.to("error_code", String.valueOf(code222));
                                                            pairArr222[5] = TuplesKt.to("error_message", msg2222);
                                                            pairArr222[6] = TuplesKt.to("flag", "v2");
                                                            dDConst322.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr222));
                                                            return m2636constructorimpl;
                                                        }
                                                        Object result2222 = m2636constructorimpl;
                                                        e = Result.m2639exceptionOrNullimpl(result2222);
                                                        if (e == null) {
                                                            DDConst.logE$default(DDConst.INSTANCE, "update(" + from3 + ", " + ((Object) ((version2.length() == 0 ? c3 : (char) 0) != 0 ? str : str4)) + ", " + env3.getValue() + ", " + force4 + ") has exception: " + e.getMessage(), null, 2, null);
                                                            UpdateException updateException = e instanceof UpdateException ? (UpdateException) e : null;
                                                            Integer boxInt = Boxing.boxInt(updateException != null ? updateException.getCode() : 9999);
                                                            String message = e.getMessage();
                                                            if (message == null) {
                                                                message = "unknown.";
                                                            }
                                                            pair = TuplesKt.to(boxInt, message);
                                                            break;
                                                        }
                                                        pair = TuplesKt.to(Boxing.boxInt(0), "");
                                                        int code2222 = ((Number) pair.component1()).intValue();
                                                        String msg22222 = (String) pair.component2();
                                                        DDConst dDConst3222 = DDConst.INSTANCE;
                                                        Pair[] pairArr2222 = new Pair[7];
                                                        pairArr2222[0] = TuplesKt.to(str3, from3);
                                                        pairArr2222[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                                                        pairArr2222[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                                                        pairArr2222[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result2222) ? "1" : "0");
                                                        pairArr2222[4] = TuplesKt.to("error_code", String.valueOf(code2222));
                                                        pairArr2222[5] = TuplesKt.to("error_message", msg22222);
                                                        pairArr2222[6] = TuplesKt.to("flag", "v2");
                                                        dDConst3222.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr2222));
                                                        return m2636constructorimpl;
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        from3 = from2;
                                                        force2 = force6;
                                                        c = c7;
                                                        $this$update$iv = $this$update_yxL6bBk_u24lambda_u240.updating;
                                                        while (true) {
                                                            cur$iv = $this$update$iv.getValue();
                                                            if (!cur$iv) {
                                                            }
                                                            if (!cur$iv) {
                                                            }
                                                            if (0 == 0) {
                                                            }
                                                            if (!$this$update$iv.compareAndSet(z, z2)) {
                                                            }
                                                            updateEngine2 = updateEngine;
                                                        }
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    force2 = force6;
                                                    c = c7;
                                                }
                                            } catch (Throwable th15) {
                                                th = th15;
                                                str2 = str5;
                                                force2 = force6;
                                                c = c7;
                                            }
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        str2 = str5;
                                        force2 = force5;
                                        c = c6;
                                    }
                                } else {
                                    longRef = longRef;
                                    i = i;
                                }
                            }
                        case 1:
                            int i5 = updateEngine$update$12.I$0;
                            localV = updateEngine$update$12.J$0;
                            boolean force7 = updateEngine$update$12.Z$0;
                            $this$update_yxL6bBk_u24lambda_u240 = (UpdateEngine) updateEngine$update$12.L$4;
                            UpdateEngine updateEngine3 = (Ref.LongRef) updateEngine$update$12.L$3;
                            IDeviceDecision.Version.Env env4 = (IDeviceDecision.Version.Env) updateEngine$update$12.L$2;
                            version2 = (String) updateEngine$update$12.L$1;
                            from3 = (String) updateEngine$update$12.L$0;
                            ResultKt.throwOnFailure($result);
                            i3 = i5;
                            env3 = env4;
                            updateEngine2 = updateEngine3;
                            fetchOnlineConfigInfo = $result;
                            str = "latest";
                            str5 = "from";
                            i4 = 2;
                            c6 = 1;
                            force5 = force7;
                            UpdateInfoModel info22 = (UpdateInfoModel) fetchOnlineConfigInfo;
                            ((Ref.LongRef) updateEngine2).element = info22.getVersion();
                            if (localV < ((Ref.LongRef) updateEngine2).element) {
                            }
                            break;
                        case 2:
                            int i6 = updateEngine$update$12.I$0;
                            localV = updateEngine$update$12.J$0;
                            boolean force8 = updateEngine$update$12.Z$0;
                            info = (UpdateInfoModel) updateEngine$update$12.L$5;
                            $this$update_yxL6bBk_u24lambda_u240 = (UpdateEngine) updateEngine$update$12.L$4;
                            UpdateEngine updateEngine4 = (Ref.LongRef) updateEngine$update$12.L$3;
                            IDeviceDecision.Version.Env env5 = (IDeviceDecision.Version.Env) updateEngine$update$12.L$2;
                            version2 = (String) updateEngine$update$12.L$1;
                            from3 = (String) updateEngine$update$12.L$0;
                            ResultKt.throwOnFailure($result);
                            env3 = env5;
                            updateEngine2 = updateEngine4;
                            str = "latest";
                            str5 = "from";
                            c7 = 1;
                            force6 = force8;
                            fetchOnlineConfigData = $result;
                            DDModel model2 = (DDModel) fetchOnlineConfigData;
                            $this$update_yxL6bBk_u24lambda_u240.dataCenter.currentData().updateWithModel(model2);
                            str2 = str5;
                            from2 = from3;
                            DDConst.INSTANCE.logI("update success { env: " + env3.getValue() + ", version: " + ((Ref.LongRef) updateEngine2).element + " }.");
                            $this$update_yxL6bBk_u24lambda_u240.clean(env3, ((Ref.LongRef) updateEngine2).element);
                            $this$update$iv3 = $this$update_yxL6bBk_u24lambda_u240.updating;
                            do {
                                cur$iv2 = $this$update$iv3.getValue();
                                if (!cur$iv2) {
                                }
                            } while (!$this$update$iv3.compareAndSet(!cur$iv2 ? c7 == 1 ? 1 : 0 : false, 0 == 0 ? c7 == 1 ? 1 : 0 : false));
                            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                            from3 = from2;
                            str3 = str2;
                            force4 = force6;
                            c3 = c7;
                            Object result22222 = m2636constructorimpl;
                            e = Result.m2639exceptionOrNullimpl(result22222);
                            if (e == null) {
                            }
                            pair = TuplesKt.to(Boxing.boxInt(0), "");
                            int code22222 = ((Number) pair.component1()).intValue();
                            String msg222222 = (String) pair.component2();
                            DDConst dDConst32222 = DDConst.INSTANCE;
                            Pair[] pairArr22222 = new Pair[7];
                            pairArr22222[0] = TuplesKt.to(str3, from3);
                            pairArr22222[c3] = TuplesKt.to("oldVer", String.valueOf(localV));
                            pairArr22222[2] = TuplesKt.to("ddver", String.valueOf(((Ref.LongRef) updateEngine2).element));
                            pairArr22222[3] = TuplesKt.to("success", !Result.m2643isSuccessimpl(result22222) ? "1" : "0");
                            pairArr22222[4] = TuplesKt.to("error_code", String.valueOf(code22222));
                            pairArr22222[5] = TuplesKt.to("error_message", msg222222);
                            pairArr22222[6] = TuplesKt.to("flag", "v2");
                            dDConst32222.trackT("public.messagebox.ddver.track", MapsKt.mapOf(pairArr22222));
                            return m2636constructorimpl;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (updateEngine$update$12.label) {
            }
        } catch (Throwable th17) {
            th = th17;
            env3 = env2;
            updateEngine2 = r11;
            str = "latest";
            c = 1;
            force2 = true;
        }
        updateEngine$update$1 = new UpdateEngine$update$1(updateEngine2, continuation);
        updateEngine$update$12 = updateEngine$update$1;
        Object $result2 = updateEngine$update$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025e A[Catch: all -> 0x0268, TryCatch #4 {all -> 0x0268, blocks: (B:73:0x01cc, B:75:0x01d4, B:77:0x01da, B:85:0x01ee, B:104:0x0256, B:105:0x025d, B:106:0x025e, B:107:0x0267), top: B:155:0x01cc }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x029b A[LOOP:1: B:114:0x027a->B:127:0x029b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x029c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d4 A[Catch: all -> 0x0268, TryCatch #4 {all -> 0x0268, blocks: (B:73:0x01cc, B:75:0x01d4, B:77:0x01da, B:85:0x01ee, B:104:0x0256, B:105:0x025d, B:106:0x025e, B:107:0x0267), top: B:155:0x01cc }] */
    @Override // kntr.base.dd.impl.internal.update.IDDUpdateEngine
    /* renamed from: fallback-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1364fallback0E7RQCE(String version, IDeviceDecision.Version.Env env, Continuation<? super Result<Unit>> continuation) {
        Continuation<? super Unit> continuation2;
        UpdateEngine $this$fallback_0E7RQCE_u24lambda_u240;
        long longValue;
        boolean z;
        FileType dataType;
        boolean z2;
        String curl;
        boolean z3;
        FileType dataType2;
        long remoteV;
        String version2;
        Path dataFilePath;
        AtomicBoolean $this$update$iv;
        boolean cur$iv;
        Object m2636constructorimpl;
        Throwable e;
        String data;
        boolean cur$iv2;
        IDeviceDecision.Version.Env env2 = env;
        UpdateEngine$fallback$1 version3 = continuation;
        if (version3 instanceof UpdateEngine$fallback$1) {
            UpdateEngine$fallback$1 updateEngine$fallback$1 = version3;
            if ((updateEngine$fallback$1.label & Integer.MIN_VALUE) != 0) {
                updateEngine$fallback$1.label -= Integer.MIN_VALUE;
                continuation2 = updateEngine$fallback$1;
                Object $result = continuation2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$fallback_0E7RQCE_u24lambda_u240 = this;
                            try {
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            version3 = version;
                        }
                        if ($this$fallback_0E7RQCE_u24lambda_u240.updating.getValue()) {
                            throw new UpdateException.AlreadyUpdating();
                        }
                        Long longOrNull = StringsKt.toLongOrNull(version);
                        if (longOrNull != null) {
                            try {
                                longValue = longOrNull.longValue();
                            } catch (Throwable th3) {
                                th = th3;
                                version3 = version;
                                Result.Companion companion2 = Result.Companion;
                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                version2 = version3;
                                Object result = m2636constructorimpl;
                                e = Result.m2639exceptionOrNullimpl(result);
                                if (e != null) {
                                }
                                return m2636constructorimpl;
                            }
                        } else {
                            longValue = 0;
                        }
                        long remoteV2 = longValue;
                        if (remoteV2 <= 0) {
                            throw new UpdateException.ParamsInvalid(AppKey.VERSION);
                        }
                        DDConst.INSTANCE.logI("start fallback to " + remoteV2 + ".");
                        AtomicBoolean $this$update$iv2 = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                        while (true) {
                            boolean cur$iv3 = $this$update$iv2.getValue();
                            if (cur$iv3) {
                            }
                            if ($this$update$iv2.compareAndSet(cur$iv3, 1 != 0)) {
                                try {
                                    dataType = FileType.Data;
                                    Path dataDir = dataType.path($this$fallback_0E7RQCE_u24lambda_u240.fs, env2);
                                    Path dataFilePath2 = PathsKt.Path(dataDir, new String[]{remoteV2 + ".zip"});
                                    if ($this$fallback_0E7RQCE_u24lambda_u240.fs.exists(dataFilePath2)) {
                                        z3 = true;
                                        dataFilePath = dataFilePath2;
                                        remoteV = remoteV2;
                                        version2 = version;
                                        data = $this$fallback_0E7RQCE_u24lambda_u240.fs.readZipData(dataFilePath);
                                        if (data != null) {
                                        }
                                    } else {
                                        try {
                                            try {
                                                curl = $this$fallback_0E7RQCE_u24lambda_u240.host + "/" + $this$fallback_0E7RQCE_u24lambda_u240.appKey + "/" + env.getValue() + "/default/" + remoteV2 + "/" + $this$fallback_0E7RQCE_u24lambda_u240.appKey + "_default_" + remoteV2 + ".zip";
                                                version3 = version;
                                                try {
                                                    continuation2.L$0 = version3;
                                                    continuation2.L$1 = env2;
                                                    continuation2.L$2 = $this$fallback_0E7RQCE_u24lambda_u240;
                                                    continuation2.L$3 = dataType;
                                                    continuation2.L$4 = SpillingKt.nullOutSpilledVariable(dataDir);
                                                    continuation2.L$5 = dataFilePath2;
                                                    continuation2.L$6 = SpillingKt.nullOutSpilledVariable(curl);
                                                    continuation2.I$0 = 0;
                                                    continuation2.J$0 = remoteV2;
                                                    z3 = true;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    z2 = false;
                                                    try {
                                                        $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                                        while (true) {
                                                            cur$iv = $this$update$iv.getValue();
                                                            if (!cur$iv) {
                                                            }
                                                            if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        Result.Companion companion22 = Result.Companion;
                                                        m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                                        version2 = version3;
                                                        Object result2 = m2636constructorimpl;
                                                        e = Result.m2639exceptionOrNullimpl(result2);
                                                        if (e != null) {
                                                        }
                                                        return m2636constructorimpl;
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                version3 = version;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            version3 = version;
                                            z = false;
                                            $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                            while (true) {
                                                cur$iv = $this$update$iv.getValue();
                                                if (!cur$iv) {
                                                }
                                                if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                                }
                                            }
                                        }
                                        try {
                                            continuation2.label = 1;
                                            try {
                                                if ($this$fallback_0E7RQCE_u24lambda_u240.download(dataType, curl, dataFilePath2, null, continuation2) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                dataType2 = dataType;
                                                remoteV = remoteV2;
                                                $this$fallback_0E7RQCE_u24lambda_u240 = $this$fallback_0E7RQCE_u24lambda_u240;
                                                version2 = version3;
                                                dataFilePath = dataFilePath2;
                                                dataType = dataType2;
                                                try {
                                                    data = $this$fallback_0E7RQCE_u24lambda_u240.fs.readZipData(dataFilePath);
                                                    if (data != null) {
                                                        DDModel model = DDModelKt.decodeStringToDDModel(data);
                                                        if (model != null) {
                                                            if (!(model.getVersion() == remoteV ? z3 : false)) {
                                                                model = null;
                                                            }
                                                            if (model != null) {
                                                                $this$fallback_0E7RQCE_u24lambda_u240.dataCenter.currentData().fallbackWithModel(model);
                                                                DDConst.INSTANCE.logI("fallback success { env: " + env2.getValue() + ", version: " + remoteV + " }.");
                                                                try {
                                                                    AtomicBoolean $this$update$iv3 = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                                                    do {
                                                                        cur$iv2 = $this$update$iv3.getValue();
                                                                        boolean z4 = cur$iv2;
                                                                    } while (!$this$update$iv3.compareAndSet(cur$iv2, 0 != 0));
                                                                    m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    version3 = version2;
                                                                    Result.Companion companion222 = Result.Companion;
                                                                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                                                    version2 = version3;
                                                                    Object result22 = m2636constructorimpl;
                                                                    e = Result.m2639exceptionOrNullimpl(result22);
                                                                    if (e != null) {
                                                                    }
                                                                    return m2636constructorimpl;
                                                                }
                                                                Object result222 = m2636constructorimpl;
                                                                e = Result.m2639exceptionOrNullimpl(result222);
                                                                if (e != null) {
                                                                    DDConst.logE$default(DDConst.INSTANCE, "fallback(" + version2 + ", " + env2.getValue() + ") has exception: " + e.getMessage(), null, 2, null);
                                                                }
                                                                return m2636constructorimpl;
                                                            }
                                                        }
                                                        throw new UpdateException.Serialize("data");
                                                    }
                                                    throw new UpdateException.ReadFile(dataType.getValue());
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    version3 = version2;
                                                    $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                                    while (true) {
                                                        cur$iv = $this$update$iv.getValue();
                                                        if (!cur$iv) {
                                                        }
                                                        if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                $this$fallback_0E7RQCE_u24lambda_u240 = $this$fallback_0E7RQCE_u24lambda_u240;
                                                $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                                while (true) {
                                                    cur$iv = $this$update$iv.getValue();
                                                    if (!cur$iv) {
                                                    }
                                                    if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                                    }
                                                }
                                            }
                                        } catch (Throwable th11) {
                                            th = th11;
                                            z2 = false;
                                            $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                                            while (true) {
                                                cur$iv = $this$update$iv.getValue();
                                                if (!cur$iv) {
                                                }
                                                if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    version3 = version;
                                    z = false;
                                }
                            }
                        }
                    case 1:
                        remoteV = continuation2.J$0;
                        int i = continuation2.I$0;
                        String str = (String) continuation2.L$6;
                        dataFilePath = (Path) continuation2.L$5;
                        Path path = (Path) continuation2.L$4;
                        dataType2 = (FileType) continuation2.L$3;
                        $this$fallback_0E7RQCE_u24lambda_u240 = (UpdateEngine) continuation2.L$2;
                        env2 = (IDeviceDecision.Version.Env) continuation2.L$1;
                        version2 = (String) continuation2.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            z3 = true;
                            dataType = dataType2;
                            data = $this$fallback_0E7RQCE_u24lambda_u240.fs.readZipData(dataFilePath);
                            if (data != null) {
                            }
                        } catch (Throwable th13) {
                            th = th13;
                            version3 = version2;
                            $this$update$iv = $this$fallback_0E7RQCE_u24lambda_u240.updating;
                            while (true) {
                                cur$iv = $this$update$iv.getValue();
                                if (!cur$iv) {
                                }
                                if (!$this$update$iv.compareAndSet(!cur$iv, 0 == 0)) {
                                }
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        continuation2 = new UpdateEngine$fallback$1(this, version3);
        Object $result2 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (continuation2.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchOnlineConfigInfo(String version, long localV, IDeviceDecision.Version.Env env, Continuation<? super UpdateInfoModel> continuation) {
        UpdateEngine$fetchOnlineConfigInfo$1 updateEngine$fetchOnlineConfigInfo$1;
        UpdateEngine$fetchOnlineConfigInfo$1 updateEngine$fetchOnlineConfigInfo$12;
        String str;
        long localV2;
        FileType type;
        Path zipFilePath;
        String data;
        if (continuation instanceof UpdateEngine$fetchOnlineConfigInfo$1) {
            updateEngine$fetchOnlineConfigInfo$1 = (UpdateEngine$fetchOnlineConfigInfo$1) continuation;
            if ((updateEngine$fetchOnlineConfigInfo$1.label & Integer.MIN_VALUE) != 0) {
                updateEngine$fetchOnlineConfigInfo$1.label -= Integer.MIN_VALUE;
                updateEngine$fetchOnlineConfigInfo$12 = updateEngine$fetchOnlineConfigInfo$1;
                Object $result = updateEngine$fetchOnlineConfigInfo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (updateEngine$fetchOnlineConfigInfo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String url = infoURL(version, env);
                        FileType type2 = FileType.Info;
                        Path infoDir = type2.path(this.fs, env);
                        this.fs.removeItem(infoDir);
                        if (StringsKt.isBlank(version)) {
                            str = this.appKey;
                        } else {
                            str = this.appKey + "_" + version;
                        }
                        String fileName = str;
                        Path zipFilePath2 = PathsKt.Path(infoDir, new String[]{fileName + ".zip"});
                        updateEngine$fetchOnlineConfigInfo$12.L$0 = SpillingKt.nullOutSpilledVariable(version);
                        updateEngine$fetchOnlineConfigInfo$12.L$1 = SpillingKt.nullOutSpilledVariable(env);
                        updateEngine$fetchOnlineConfigInfo$12.L$2 = SpillingKt.nullOutSpilledVariable(url);
                        updateEngine$fetchOnlineConfigInfo$12.L$3 = type2;
                        updateEngine$fetchOnlineConfigInfo$12.L$4 = SpillingKt.nullOutSpilledVariable(infoDir);
                        updateEngine$fetchOnlineConfigInfo$12.L$5 = SpillingKt.nullOutSpilledVariable(fileName);
                        updateEngine$fetchOnlineConfigInfo$12.L$6 = zipFilePath2;
                        updateEngine$fetchOnlineConfigInfo$12.J$0 = localV;
                        updateEngine$fetchOnlineConfigInfo$12.label = 1;
                        if (download$default(this, type2, url, zipFilePath2, null, updateEngine$fetchOnlineConfigInfo$12, 8, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        localV2 = localV;
                        type = type2;
                        zipFilePath = zipFilePath2;
                        break;
                    case 1:
                        localV2 = updateEngine$fetchOnlineConfigInfo$12.J$0;
                        zipFilePath = (Path) updateEngine$fetchOnlineConfigInfo$12.L$6;
                        String str2 = (String) updateEngine$fetchOnlineConfigInfo$12.L$5;
                        Path path = (Path) updateEngine$fetchOnlineConfigInfo$12.L$4;
                        type = (FileType) updateEngine$fetchOnlineConfigInfo$12.L$3;
                        String str3 = (String) updateEngine$fetchOnlineConfigInfo$12.L$2;
                        IDeviceDecision.Version.Env env2 = (IDeviceDecision.Version.Env) updateEngine$fetchOnlineConfigInfo$12.L$1;
                        String str4 = (String) updateEngine$fetchOnlineConfigInfo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = this.fs.readZipData(zipFilePath);
                if (data != null) {
                    throw new UpdateException.ReadFile(type.getValue());
                }
                UpdateInfoModel decodeFromString = UpdateInfoModel.Companion.decodeFromString(data, localV2);
                if (decodeFromString != null) {
                    return decodeFromString;
                }
                throw new UpdateException.Serialize("info");
            }
        }
        updateEngine$fetchOnlineConfigInfo$1 = new UpdateEngine$fetchOnlineConfigInfo$1(this, continuation);
        updateEngine$fetchOnlineConfigInfo$12 = updateEngine$fetchOnlineConfigInfo$1;
        Object $result2 = updateEngine$fetchOnlineConfigInfo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (updateEngine$fetchOnlineConfigInfo$12.label) {
        }
        data = this.fs.readZipData(zipFilePath);
        if (data != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchOnlineConfigData(IDeviceDecision.Version.Env env, UpdateInfoModel info, Continuation<? super DDModel> continuation) {
        UpdateEngine$fetchOnlineConfigData$1 updateEngine$fetchOnlineConfigData$1;
        UpdateEngine$fetchOnlineConfigData$1 updateEngine$fetchOnlineConfigData$12;
        IDeviceDecision.Version.Env env2;
        UpdateInfoModel info2;
        Path dataDir;
        Path dataFilePath;
        Object obj;
        FileType dataType;
        IDeviceDecision.Version.Env env3;
        UpdateInfoModel info3;
        Path dataFilePath2;
        Path dataDir2;
        FileType dataType2;
        String data;
        if (continuation instanceof UpdateEngine$fetchOnlineConfigData$1) {
            updateEngine$fetchOnlineConfigData$1 = (UpdateEngine$fetchOnlineConfigData$1) continuation;
            if ((updateEngine$fetchOnlineConfigData$1.label & Integer.MIN_VALUE) != 0) {
                updateEngine$fetchOnlineConfigData$1.label -= Integer.MIN_VALUE;
                updateEngine$fetchOnlineConfigData$12 = updateEngine$fetchOnlineConfigData$1;
                Object $result = updateEngine$fetchOnlineConfigData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (updateEngine$fetchOnlineConfigData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        FileType dataType3 = FileType.Data;
                        Path dataDir3 = dataType3.path(this.fs, env);
                        Path dataFilePath3 = PathsKt.Path(dataDir3, new String[]{info.getVersion() + ".zip"});
                        updateEngine$fetchOnlineConfigData$12.L$0 = SpillingKt.nullOutSpilledVariable(env);
                        updateEngine$fetchOnlineConfigData$12.L$1 = info;
                        updateEngine$fetchOnlineConfigData$12.L$2 = dataType3;
                        updateEngine$fetchOnlineConfigData$12.L$3 = SpillingKt.nullOutSpilledVariable(dataDir3);
                        updateEngine$fetchOnlineConfigData$12.L$4 = dataFilePath3;
                        updateEngine$fetchOnlineConfigData$12.label = 1;
                        Object patchOldData = patchOldData(env, info, updateEngine$fetchOnlineConfigData$12);
                        if (patchOldData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        env2 = env;
                        info2 = info;
                        dataDir = dataDir3;
                        dataFilePath = dataFilePath3;
                        obj = patchOldData;
                        dataType = dataType3;
                        break;
                    case 1:
                        UpdateInfoModel info4 = (UpdateInfoModel) updateEngine$fetchOnlineConfigData$12.L$1;
                        ResultKt.throwOnFailure($result);
                        env2 = (IDeviceDecision.Version.Env) updateEngine$fetchOnlineConfigData$12.L$0;
                        info2 = info4;
                        dataFilePath = (Path) updateEngine$fetchOnlineConfigData$12.L$4;
                        dataDir = (Path) updateEngine$fetchOnlineConfigData$12.L$3;
                        dataType = (FileType) updateEngine$fetchOnlineConfigData$12.L$2;
                        obj = $result;
                        break;
                    case 2:
                        dataFilePath2 = (Path) updateEngine$fetchOnlineConfigData$12.L$4;
                        dataDir2 = (Path) updateEngine$fetchOnlineConfigData$12.L$3;
                        dataType2 = (FileType) updateEngine$fetchOnlineConfigData$12.L$2;
                        info3 = (UpdateInfoModel) updateEngine$fetchOnlineConfigData$12.L$1;
                        env3 = (IDeviceDecision.Version.Env) updateEngine$fetchOnlineConfigData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        info2 = info3;
                        dataFilePath = dataFilePath2;
                        dataType = dataType2;
                        data = this.fs.readZipData(dataFilePath);
                        if (data == null) {
                            throw new UpdateException.ReadFile(dataType.getValue());
                        }
                        DDModel it = DDModelKt.decodeStringToDDModel(data);
                        if (it != null) {
                            if (!(it.getVersion() == info2.getVersion())) {
                                it = null;
                            }
                            if (it != null) {
                                return it;
                            }
                        }
                        throw new UpdateException.Serialize("data");
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    DDConst.INSTANCE.logI("upgrade succeeds by installing patches.");
                    data = this.fs.readZipData(dataFilePath);
                    if (data == null) {
                    }
                } else {
                    String curl = info2.getCurl();
                    String md5 = info2.getMd5();
                    updateEngine$fetchOnlineConfigData$12.L$0 = SpillingKt.nullOutSpilledVariable(env2);
                    updateEngine$fetchOnlineConfigData$12.L$1 = info2;
                    updateEngine$fetchOnlineConfigData$12.L$2 = dataType;
                    updateEngine$fetchOnlineConfigData$12.L$3 = SpillingKt.nullOutSpilledVariable(dataDir);
                    updateEngine$fetchOnlineConfigData$12.L$4 = dataFilePath;
                    updateEngine$fetchOnlineConfigData$12.label = 2;
                    FileType dataType4 = dataType;
                    if (download(dataType, curl, dataFilePath, md5, updateEngine$fetchOnlineConfigData$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    env3 = env2;
                    info3 = info2;
                    dataFilePath2 = dataFilePath;
                    dataDir2 = dataDir;
                    dataType2 = dataType4;
                    info2 = info3;
                    dataFilePath = dataFilePath2;
                    dataType = dataType2;
                    data = this.fs.readZipData(dataFilePath);
                    if (data == null) {
                    }
                }
            }
        }
        updateEngine$fetchOnlineConfigData$1 = new UpdateEngine$fetchOnlineConfigData$1(this, continuation);
        updateEngine$fetchOnlineConfigData$12 = updateEngine$fetchOnlineConfigData$1;
        Object $result2 = updateEngine$fetchOnlineConfigData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (updateEngine$fetchOnlineConfigData$12.label) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object patchOldData(IDeviceDecision.Version.Env env, UpdateInfoModel info, Continuation<? super Boolean> continuation) {
        UpdateEngine$patchOldData$1 updateEngine$patchOldData$1;
        UpdateEngine$patchOldData$1 updateEngine$patchOldData$12;
        boolean z;
        Object obj;
        if (continuation instanceof UpdateEngine$patchOldData$1) {
            updateEngine$patchOldData$1 = (UpdateEngine$patchOldData$1) continuation;
            if ((updateEngine$patchOldData$1.label & Integer.MIN_VALUE) != 0) {
                updateEngine$patchOldData$1.label -= Integer.MIN_VALUE;
                updateEngine$patchOldData$12 = updateEngine$patchOldData$1;
                Object $result = updateEngine$patchOldData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (updateEngine$patchOldData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String patchURL = info.getPatchURL();
                        if (patchURL != null) {
                            Path dataDir = FileType.Data.path(this.fs, env);
                            DDFileSystem dDFileSystem = this.fs;
                            Path Path = PathsKt.Path(dataDir, new String[]{info.getPatchV() + ".zip"});
                            long version = info.getVersion();
                            updateEngine$patchOldData$12.L$0 = SpillingKt.nullOutSpilledVariable(env);
                            updateEngine$patchOldData$12.L$1 = SpillingKt.nullOutSpilledVariable(info);
                            updateEngine$patchOldData$12.L$2 = SpillingKt.nullOutSpilledVariable(patchURL);
                            updateEngine$patchOldData$12.L$3 = SpillingKt.nullOutSpilledVariable(dataDir);
                            updateEngine$patchOldData$12.I$0 = 0;
                            updateEngine$patchOldData$12.label = 1;
                            Object patch = dDFileSystem.patch(Path, PathsKt.Path(dataDir, new String[]{version + ".zip"}), info.getMd5(), new UpdateEngine$patchOldData$2$1(this, env, info, patchURL, null), updateEngine$patchOldData$12);
                            if (patch != coroutine_suspended) {
                                obj = patch;
                                z = ((Boolean) obj).booleanValue();
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    case 1:
                        int i = updateEngine$patchOldData$12.I$0;
                        Path path = (Path) updateEngine$patchOldData$12.L$3;
                        String str = (String) updateEngine$patchOldData$12.L$2;
                        UpdateInfoModel updateInfoModel = (UpdateInfoModel) updateEngine$patchOldData$12.L$1;
                        IDeviceDecision.Version.Env env2 = (IDeviceDecision.Version.Env) updateEngine$patchOldData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        z = ((Boolean) obj).booleanValue();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(z);
            }
        }
        updateEngine$patchOldData$1 = new UpdateEngine$patchOldData$1(this, continuation);
        updateEngine$patchOldData$12 = updateEngine$patchOldData$1;
        Object $result2 = updateEngine$patchOldData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (updateEngine$patchOldData$12.label) {
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object download(FileType type, String url, Path path, String md5, Continuation<? super Unit> continuation) {
        UpdateEngine$download$1 updateEngine$download$1;
        Object obj;
        Throwable e;
        if (continuation instanceof UpdateEngine$download$1) {
            updateEngine$download$1 = (UpdateEngine$download$1) continuation;
            if ((updateEngine$download$1.label & Integer.MIN_VALUE) != 0) {
                updateEngine$download$1.label -= Integer.MIN_VALUE;
                Object $result = updateEngine$download$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (updateEngine$download$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DDDownloader dDDownloader = this.downloader;
                        String path2 = path.toString();
                        updateEngine$download$1.L$0 = type;
                        updateEngine$download$1.L$1 = url;
                        updateEngine$download$1.L$2 = SpillingKt.nullOutSpilledVariable(path);
                        updateEngine$download$1.L$3 = SpillingKt.nullOutSpilledVariable(md5);
                        updateEngine$download$1.label = 1;
                        Object m1355downloadBWLJW6A = dDDownloader.m1355downloadBWLJW6A(url, path2, md5, updateEngine$download$1);
                        if (m1355downloadBWLJW6A == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = m1355downloadBWLJW6A;
                        break;
                    case 1:
                        String str = (String) updateEngine$download$1.L$3;
                        Path path3 = (Path) updateEngine$download$1.L$2;
                        url = (String) updateEngine$download$1.L$1;
                        type = (FileType) updateEngine$download$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).m2645unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e = Result.m2639exceptionOrNullimpl(obj);
                if (e == null) {
                    DDConst.logE$default(DDConst.INSTANCE, "download(" + type.getValue() + ", " + url + ") has exception " + e.getMessage() + ".", null, 2, null);
                    throw new UpdateException.DownloadFile(type.getValue());
                }
                if (Result.m2643isSuccessimpl(obj)) {
                    Unit unit = (Unit) obj;
                    DDConst.INSTANCE.logD("download(" + type.getValue() + ", " + url + ") success.");
                }
                return Unit.INSTANCE;
            }
        }
        updateEngine$download$1 = new UpdateEngine$download$1(this, continuation);
        Object $result2 = updateEngine$download$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (updateEngine$download$1.label) {
        }
        e = Result.m2639exceptionOrNullimpl(obj);
        if (e == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object download$default(UpdateEngine updateEngine, FileType fileType, String str, Path path, String str2, Continuation continuation, int i, Object obj) {
        String str3;
        if ((i & 8) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        return updateEngine.download(fileType, str, path, str3, continuation);
    }

    private final void clean(IDeviceDecision.Version.Env env, long version) {
        try {
            this.fs.removeItem(FileType.Info.path(this.fs, env));
            this.fs.removeItem(FileType.Patch.path(this.fs, env));
            Path dataDir = FileType.Data.path(this.fs, env);
            Iterable $this$forEach$iv = this.fs.list(dataDir);
            for (Object element$iv : $this$forEach$iv) {
                String name = (String) element$iv;
                if (!StringsKt.contains$default(name, String.valueOf(version), false, 2, (Object) null)) {
                    this.fs.removeItem(PathsKt.Path(dataDir, new String[]{name}));
                }
            }
        } catch (Exception e) {
            DDConst.logE$default(DDConst.INSTANCE, "clean(" + env + ", " + version + ") has exception " + e.getMessage(), null, 2, null);
        }
    }

    private final String infoURL(String version, IDeviceDecision.Version.Env env) {
        if (StringsKt.isBlank(version)) {
            String str = this.host;
            String value = env.getValue();
            return str + "/" + value + "/" + this.appKey + ".zip";
        }
        String str2 = this.host;
        String str3 = this.appKey;
        String value2 = env.getValue();
        return str2 + "/" + str3 + "/" + value2 + "/default/" + version + "/" + this.appKey + "_" + version + ".zip";
    }
}