package tv.danmaku.ijk.media.player.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class P2PManuscriptInfo {
    public static final String K_P2P_MANUSCRIPT_AVID = "p2p_manuscript_avid";
    public static final String K_P2P_MANUSCRIPT_CID = "p2p_manuscript_cid";
    public static final String K_P2P_MANUSCRIPT_EPISODE_ID = "p2p_manuscript_episode_id";
    public static final String K_P2P_MANUSCRIPT_SEASON_ID = "p2p_manuscript_season_id";
    public static final String K_P2P_MANUSCRIPT_TYPE = "p2p_manuscript_type";
    public static final String K_P2P_MANUSCRIPT_UPLOAD_UTC_TIMESTAMP = "p2p_manuscript_upload_utc_timestamp";
    public static final String K_P2P_MANUSCRIPT_UP_MID = "p2p_manuscript_up_mid";
    private long mAvid;
    private long mCid;
    private long mEpisodeId;
    ManuscriptType mManuscriptType;
    private long mSeasonId;
    private long mUpMid;
    private long mUploadUtcTimeStamp;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ManuscriptType {
        MANUSCRIPT_UNKNOWN,
        MANUSCRIPT_PGC,
        MANUSCRIPT_UGC
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Builder {
        private P2PManuscriptInfo target = new P2PManuscriptInfo();

        public Builder setSeasonId(long seasonId) {
            this.target.mSeasonId = seasonId;
            return this;
        }

        public Builder setEpisodeId(long episodeId) {
            this.target.mEpisodeId = episodeId;
            return this;
        }

        public Builder setAvid(long avid) {
            this.target.mAvid = avid;
            return this;
        }

        public Builder setUpMid(long upMid) {
            this.target.mUpMid = upMid;
            return this;
        }

        public Builder setCid(long cid) {
            this.target.mCid = cid;
            return this;
        }

        public Builder setUploadUtcTime(long utcTime) {
            this.target.mUploadUtcTimeStamp = utcTime;
            return this;
        }

        public Builder setManuscriptType(ManuscriptType type) {
            this.target.mManuscriptType = type;
            return this;
        }

        public P2PManuscriptInfo build() {
            P2PManuscriptInfo result = this.target;
            this.target = null;
            return result;
        }
    }

    public String toJsonString() {
        JSONObject object = new JSONObject();
        try {
            object.put(K_P2P_MANUSCRIPT_SEASON_ID, this.mSeasonId);
            object.put(K_P2P_MANUSCRIPT_EPISODE_ID, this.mEpisodeId);
            object.put(K_P2P_MANUSCRIPT_AVID, Long.valueOf(this.mAvid).toString());
            object.put(K_P2P_MANUSCRIPT_CID, this.mCid);
            object.put(K_P2P_MANUSCRIPT_UP_MID, this.mUpMid);
            object.put(K_P2P_MANUSCRIPT_UPLOAD_UTC_TIMESTAMP, this.mUploadUtcTimeStamp);
            object.put(K_P2P_MANUSCRIPT_TYPE, this.mManuscriptType.ordinal());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}