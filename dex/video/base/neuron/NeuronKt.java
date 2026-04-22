package video.base.neuron;

import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.neuron.IVBNeuron;

/* compiled from: Neuron.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"VBNeuron", "Lvideo/base/neuron/IVBNeuron;", "getVBNeuron", "()Lvideo/base/neuron/IVBNeuron;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NeuronKt {
    private static final IVBNeuron VBNeuron = new IVBNeuron() { // from class: video.base.neuron.NeuronKt$VBNeuron$1
        @Override // video.base.neuron.IVBNeuron
        public /* bridge */ void reportClick(boolean force, String eventId, Map<String, String> map) {
            IVBNeuron.CC.$default$reportClick(this, force, eventId, map);
        }

        @Override // video.base.neuron.IVBNeuron
        public /* bridge */ void reportExposure(boolean force, String eventId, Map<String, String> map) {
            IVBNeuron.CC.$default$reportExposure(this, force, eventId, map);
        }

        @Override // video.base.neuron.IVBNeuron
        public /* bridge */ void reportPlayer(boolean force, String eventId, String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat, Map<String, String> map) {
            IVBNeuron.CC.$default$reportPlayer(this, force, eventId, playFromSpmid, seasonId, type, subType, epId, progress, avid, cid, networkType, danmaku, status, playMethod, playType, playerSessionId, speed, playerClarity, isAutoplay, videoFormat, map);
        }

        @Override // video.base.neuron.IVBNeuron
        public /* bridge */ void trackT(String eventId, boolean force, Map<String, String> map, int sampler) {
            IVBNeuron.CC.$default$trackT(this, eventId, force, map, sampler);
        }
    };

    public static final IVBNeuron getVBNeuron() {
        return VBNeuron;
    }
}