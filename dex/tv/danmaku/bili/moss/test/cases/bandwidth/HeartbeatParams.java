package tv.danmaku.bili.moss.test.cases.bandwidth;

import com.bilibili.api.base.util.ParamsMap;
import j$.util.Map;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: HeartbeatTestApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001Bù\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ltv/danmaku/bili/moss/test/cases/bandwidth/HeartbeatParams;", "Lcom/bilibili/api/base/util/ParamsMap;", "startTime", "", "session", "", "mid", "avid", "cid", "sid", "epid", "type", "subType", "", "quality", "totalTime", "pausedTime", "playedTime", "videoDuration", "playType", "networkType", "lastPlayProgressTime", "maxPlayProgressTime", "jumpFrom", "fromSpmid", FavoritesConstsKt.SPMID, "epStatus", "playStatus", "userStatus", "actualPlayedTime", "isFromAutoNext", "listPlayTime", "miniPlayTime", "<init>", "(JLjava/lang/String;JJJLjava/lang/String;JLjava/lang/String;IIJJJJLjava/lang/String;IJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJJ)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HeartbeatParams extends ParamsMap implements Map {
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$compute(this, obj, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.-CC.$default$computeIfAbsent(this, obj, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$computeIfPresent(this, obj, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.-CC.$default$forEach(this, biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.-CC.$default$merge(this, obj, obj2, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.-CC.$default$putIfAbsent(this, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.-CC.$default$replace(this, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.-CC.$default$replace(this, obj, obj2, obj3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.-CC.$default$replaceAll(this, biFunction);
    }

    public HeartbeatParams(long startTime, String session, long mid, long avid, long cid, String sid, long epid, String type, int subType, int quality, long totalTime, long pausedTime, long playedTime, long videoDuration, String playType, int networkType, long lastPlayProgressTime, long maxPlayProgressTime, int jumpFrom, String fromSpmid, String spmid, String epStatus, String playStatus, String userStatus, long actualPlayedTime, int isFromAutoNext, long listPlayTime, long miniPlayTime) {
        putParams(new String[]{"start_ts", String.valueOf(startTime)});
        putParams(new String[]{"session", session});
        putParams(new String[]{"mid", String.valueOf(mid)});
        putParams(new String[]{"aid", String.valueOf(avid)});
        putParams(new String[]{"cid", String.valueOf(cid)});
        putParams(new String[]{"sid", sid});
        putParams(new String[]{"epid", String.valueOf(epid)});
        putParams(new String[]{"type", type});
        putParams(new String[]{"sub_type", String.valueOf(subType)});
        putParams(new String[]{"quality", String.valueOf(quality)});
        putParams(new String[]{"total_time", String.valueOf(totalTime)});
        putParams(new String[]{"paused_time", String.valueOf(pausedTime)});
        putParams(new String[]{"played_time", String.valueOf(playedTime)});
        putParams(new String[]{"video_duration", String.valueOf(videoDuration)});
        putParams(new String[]{"play_type", playType});
        putParams(new String[]{"network_type", String.valueOf(networkType)});
        putParams(new String[]{"last_play_progress_time", String.valueOf(lastPlayProgressTime)});
        putParams(new String[]{"max_play_progress_time", String.valueOf(maxPlayProgressTime)});
        putParams(new String[]{"from", String.valueOf(jumpFrom)});
        putParams(new String[]{"from_spmid", fromSpmid});
        putParams(new String[]{FavoritesConstsKt.SPMID, spmid});
        putParams(new String[]{"epid_status", epStatus});
        putParams(new String[]{"play_status", playStatus});
        putParams(new String[]{"user_status", userStatus});
        putParams(new String[]{"actual_played_time", String.valueOf(actualPlayedTime)});
        putParams(new String[]{"auto_play", String.valueOf(isFromAutoNext)});
        putParams(new String[]{"list_play_time", String.valueOf(listPlayTime)});
        putParams(new String[]{"miniplayer_play_time", String.valueOf(miniPlayTime)});
    }

    public final /* bridge */ boolean containsKey(Object key) {
        if (key == null ? true : key instanceof String) {
            return containsKey((String) key);
        }
        return false;
    }

    public /* bridge */ boolean containsKey(String p0) {
        return super.containsKey(p0);
    }

    public final /* bridge */ boolean containsValue(Object value) {
        if (value == null ? true : value instanceof String) {
            return containsValue((String) value);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(String p0) {
        return super.containsValue(p0);
    }

    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ /* synthetic */ Object get(Object key) {
        if (key == null ? true : key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    /* renamed from: get  reason: collision with other method in class */
    public final /* bridge */ String m1232get(Object key) {
        if (key == null ? true : key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    public /* bridge */ String get(String p0) {
        return (String) super.get(p0);
    }

    public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ /* synthetic */ Object getOrDefault(Object key, Object defaultValue) {
        return !(key == null ? true : key instanceof String) ? defaultValue : getOrDefault((String) key, (String) defaultValue);
    }

    public final /* bridge */ String getOrDefault(Object key, String defaultValue) {
        return !(key == null ? true : key instanceof String) ? defaultValue : getOrDefault((String) key, defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ String getOrDefault(String p0, String p1) {
        return (String) Map.-CC.$default$getOrDefault(this, p0, p1);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<String> getValues() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object key) {
        if (key == null ? true : key instanceof String) {
            return remove((String) key);
        }
        return null;
    }

    /* renamed from: remove  reason: collision with other method in class */
    public final /* bridge */ String m1233remove(Object key) {
        if (key == null ? true : key instanceof String) {
            return remove((String) key);
        }
        return null;
    }

    public /* bridge */ String remove(String p0) {
        return (String) super.remove(p0);
    }

    public final /* bridge */ boolean remove(Object key, Object value) {
        if (key == null ? true : key instanceof String) {
            if (value != null ? value instanceof String : true) {
                return remove((String) key, (String) value);
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ boolean remove(String p0, String p1) {
        return Map.-CC.$default$remove(this, p0, p1);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<String> values() {
        return getValues();
    }
}