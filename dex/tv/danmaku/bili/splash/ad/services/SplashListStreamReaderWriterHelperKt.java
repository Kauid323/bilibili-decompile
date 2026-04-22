package tv.danmaku.bili.splash.ad.services;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.FileUtils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.splash.ad.utils.SplashAESUtils;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: SplashListStreamReaderWriterHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a-\u0010\n\u001a\u0004\u0018\u00010\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005\u001a\b\u0010\u000b\u001a\u00020\u0006H\u0002\u001a\b\u0010\f\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\r\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000\u001a\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000¨\u0006\u0012"}, d2 = {"saveSplashListResponseToDisk", "", "response", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "onError", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "errMsg", "readSplashListResponseFromDisk", "splashListResponseSavePath", "splashListEncryptSavePath", "saveEncryptSplashListToDisk", "encryptedList", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "readEncryptSplashListFromDisk", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashListStreamReaderWriterHelperKt {
    public static /* synthetic */ void saveSplashListResponseToDisk$default(SplashListResponse splashListResponse, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.splash.ad.services.SplashListStreamReaderWriterHelperKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit saveSplashListResponseToDisk$lambda$0;
                    saveSplashListResponseToDisk$lambda$0 = SplashListStreamReaderWriterHelperKt.saveSplashListResponseToDisk$lambda$0((String) obj2);
                    return saveSplashListResponseToDisk$lambda$0;
                }
            };
        }
        saveSplashListResponseToDisk(splashListResponse, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveSplashListResponseToDisk$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009c A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:3:0x0011, B:5:0x008b, B:15:0x009c, B:16:0x00ae, B:18:0x00b4, B:19:0x00c6, B:20:0x00cb, B:22:0x00d6, B:31:0x00e6, B:32:0x00f8, B:34:0x00fe, B:35:0x0114, B:36:0x0119, B:38:0x0124, B:44:0x0130, B:45:0x0143, B:47:0x0149, B:48:0x015f, B:49:0x0164), top: B:57:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6 A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:3:0x0011, B:5:0x008b, B:15:0x009c, B:16:0x00ae, B:18:0x00b4, B:19:0x00c6, B:20:0x00cb, B:22:0x00d6, B:31:0x00e6, B:32:0x00f8, B:34:0x00fe, B:35:0x0114, B:36:0x0119, B:38:0x0124, B:44:0x0130, B:45:0x0143, B:47:0x0149, B:48:0x015f, B:49:0x0164), top: B:57:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0124 A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:3:0x0011, B:5:0x008b, B:15:0x009c, B:16:0x00ae, B:18:0x00b4, B:19:0x00c6, B:20:0x00cb, B:22:0x00d6, B:31:0x00e6, B:32:0x00f8, B:34:0x00fe, B:35:0x0114, B:36:0x0119, B:38:0x0124, B:44:0x0130, B:45:0x0143, B:47:0x0149, B:48:0x015f, B:49:0x0164), top: B:57:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0130 A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:3:0x0011, B:5:0x008b, B:15:0x009c, B:16:0x00ae, B:18:0x00b4, B:19:0x00c6, B:20:0x00cb, B:22:0x00d6, B:31:0x00e6, B:32:0x00f8, B:34:0x00fe, B:35:0x0114, B:36:0x0119, B:38:0x0124, B:44:0x0130, B:45:0x0143, B:47:0x0149, B:48:0x015f, B:49:0x0164), top: B:57:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void saveSplashListResponseToDisk(SplashListResponse response, Function1<? super String, Unit> function1) {
        Object obj;
        Throwable it;
        JsonWriter writer;
        Iterable keepIds;
        List<Long> list;
        boolean z;
        Iterable strategyList;
        List<SplashShowStrategy> list2;
        boolean z2;
        Iterable it2;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(function1, "onError");
        SplashListResponseKit.INSTANCE.saveResource(response);
        try {
            Result.Companion companion = Result.Companion;
            writer = new JsonWriter(new FileWriter(splashListResponseSavePath()));
            writer.beginObject();
            writer.name("max_time").value(Integer.valueOf(response.getMaxCount()));
            writer.name("min_interval").value(Integer.valueOf(response.getIntervalForShow()));
            writer.name("pull_interval").value(Integer.valueOf(response.getIntervalForUpdate()));
            writer.name("splash_request_id").value(response.getSplashRequestId());
            writer.name("disperse_interval").value(response.getDisperseInterval());
            keepIds = response.getKeepIds();
            list = (Collection) keepIds;
            boolean z3 = false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (list != null && !list.isEmpty()) {
            z = false;
            if (!z) {
                keepIds = null;
            }
            if (keepIds != null) {
                writer.name("keep_ids");
                writer.beginArray();
                Iterable $this$forEach$iv = keepIds;
                for (Object element$iv : $this$forEach$iv) {
                    writer.value(((Number) element$iv).longValue());
                }
                writer.endArray();
            }
            strategyList = response.getStrategyList();
            list2 = (Collection) strategyList;
            if (list2 != null && !list2.isEmpty()) {
                z2 = false;
                if (!z2) {
                    strategyList = null;
                }
                if (strategyList != null) {
                    writer.name(ReportEvent.EVENT_TYPE_SHOW);
                    writer.beginArray();
                    Iterable $this$forEach$iv2 = strategyList;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        writer.jsonValue(SplashGsonParserKt.getGson().toJson((SplashShowStrategy) element$iv2));
                    }
                    writer.endArray();
                }
                Iterable it3 = response.getSplashList();
                List<SplashOrder> list3 = (Collection) it3;
                it2 = (list3 != null || list3.isEmpty()) ? true : true ? null : it3;
                if (it2 != null) {
                    Iterable list4 = it2;
                    writer.name("list");
                    writer.beginArray();
                    Iterable $this$forEach$iv3 = list4;
                    for (Object element$iv3 : $this$forEach$iv3) {
                        writer.jsonValue(SplashGsonParserKt.getGson().toJson((SplashOrder) element$iv3));
                    }
                    writer.endArray();
                }
                writer.endObject();
                writer.flush();
                writer.close();
                obj = Result.constructor-impl(Unit.INSTANCE);
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                    function1.invoke(String.valueOf(it.getMessage()));
                    return;
                }
                return;
            }
            z2 = true;
            if (!z2) {
            }
            if (strategyList != null) {
            }
            Iterable it32 = response.getSplashList();
            List<SplashOrder> list32 = (Collection) it32;
            if (list32 != null) {
            }
            if ((list32 != null || list32.isEmpty()) ? true : true) {
            }
            if (it2 != null) {
            }
            writer.endObject();
            writer.flush();
            writer.close();
            obj = Result.constructor-impl(Unit.INSTANCE);
            it = Result.exceptionOrNull-impl(obj);
            if (it == null) {
            }
        }
        z = true;
        if (!z) {
        }
        if (keepIds != null) {
        }
        strategyList = response.getStrategyList();
        list2 = (Collection) strategyList;
        if (list2 != null) {
            z2 = false;
            if (!z2) {
            }
            if (strategyList != null) {
            }
            Iterable it322 = response.getSplashList();
            List<SplashOrder> list322 = (Collection) it322;
            if (list322 != null) {
            }
            if ((list322 != null || list322.isEmpty()) ? true : true) {
            }
            if (it2 != null) {
            }
            writer.endObject();
            writer.flush();
            writer.close();
            obj = Result.constructor-impl(Unit.INSTANCE);
            it = Result.exceptionOrNull-impl(obj);
            if (it == null) {
            }
        }
        z2 = true;
        if (!z2) {
        }
        if (strategyList != null) {
        }
        Iterable it3222 = response.getSplashList();
        List<SplashOrder> list3222 = (Collection) it3222;
        if (list3222 != null) {
        }
        if ((list3222 != null || list3222.isEmpty()) ? true : true) {
        }
        if (it2 != null) {
        }
        writer.endObject();
        writer.flush();
        writer.close();
        obj = Result.constructor-impl(Unit.INSTANCE);
        it = Result.exceptionOrNull-impl(obj);
        if (it == null) {
        }
    }

    public static /* synthetic */ SplashListResponse readSplashListResponseFromDisk$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.splash.ad.services.SplashListStreamReaderWriterHelperKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit readSplashListResponseFromDisk$lambda$0;
                    readSplashListResponseFromDisk$lambda$0 = SplashListStreamReaderWriterHelperKt.readSplashListResponseFromDisk$lambda$0((String) obj2);
                    return readSplashListResponseFromDisk$lambda$0;
                }
            };
        }
        return readSplashListResponseFromDisk(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readSplashListResponseFromDisk$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final SplashListResponse readSplashListResponseFromDisk(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onError");
        try {
            Result.Companion companion = Result.Companion;
            FileReader reader = new FileReader(splashListResponseSavePath());
            SplashListResponse resp = (SplashListResponse) SplashGsonParserKt.getGson().fromJson(reader, SplashListResponse.class);
            return resp;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable it = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (it != null) {
                function1.invoke(String.valueOf(it.getMessage()));
                return null;
            }
            return null;
        }
    }

    private static final String splashListResponseSavePath() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        File folder = new File(application.getFilesDir(), "splash2");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String absolutePath = new File(folder, "splash.json").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private static final String splashListEncryptSavePath() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        File folder = new File(application.getFilesDir(), "splash2");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String absolutePath = new File(folder, "splash.data").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public static final void saveEncryptSplashListToDisk(List<SplashOrder> list) {
        List<SplashOrder> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            File $this$saveEncryptSplashListToDisk_u24lambda_u240 = new File(splashListEncryptSavePath());
            if ($this$saveEncryptSplashListToDisk_u24lambda_u240.exists()) {
                FileUtils.deleteQuietly($this$saveEncryptSplashListToDisk_u24lambda_u240);
                return;
            }
            return;
        }
        String jsonData = SplashGsonParserKt.getGson().toJson(list);
        String splashListEncryptSavePath = splashListEncryptSavePath();
        Intrinsics.checkNotNull(jsonData);
        FileUtils.stringToFile(splashListEncryptSavePath, SplashAESUtils.encrypt(jsonData));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:5:0x0011, B:7:0x0020, B:17:0x0032, B:22:0x0045, B:24:0x004a, B:26:0x0061), top: B:33:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:5:0x0011, B:7:0x0020, B:17:0x0032, B:22:0x0045, B:24:0x004a, B:26:0x0061), top: B:33:0x0011 }] */
    /* JADX WARN: Type inference failed for: r5v2, types: [tv.danmaku.bili.splash.ad.services.SplashListStreamReaderWriterHelperKt$readEncryptSplashListFromDisk$1$list$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<SplashOrder> readEncryptSplashListFromDisk() {
        boolean z;
        String jsonData;
        File file = new File(splashListEncryptSavePath());
        if (!file.exists()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            String it = FileUtils.readFileToString(file);
            String str = it;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
                if (!z) {
                    it = null;
                }
                if (it == null) {
                    it = "";
                }
                jsonData = SplashAESUtils.decrypt(it);
                if (!StringsKt.isBlank(jsonData)) {
                    jsonData = null;
                }
                if (jsonData != null) {
                    return CollectionsKt.emptyList();
                }
                List list = (List) SplashGsonParserKt.getGson().fromJson(jsonData, new TypeToken<List<? extends SplashOrder>>() { // from class: tv.danmaku.bili.splash.ad.services.SplashListStreamReaderWriterHelperKt$readEncryptSplashListFromDisk$1$list$1
                }.getType());
                if (list == null || list.isEmpty()) {
                    return null;
                }
                return list;
            }
            z = true;
            if (!z) {
            }
            if (it == null) {
            }
            jsonData = SplashAESUtils.decrypt(it);
            if (!StringsKt.isBlank(jsonData)) {
            }
            if (jsonData != null) {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return null;
        }
    }
}