package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.ijk.media.player.utils.IjkNetworkManager;
import tv.danmaku.ijk.media.player.utils.P2PServerResolver;
import video.base.utils.VBNumberExtKt;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public class P2P implements IjkNetworkManager.NetWorkChangeListener {
    private static final int AUDIO_TCP_INIT_BUFFER_SIZE = 40960;
    private static final int AUDIO_TCP_MAX_BUFFER_SIZE = 524288;
    private static final String IJK_P2P_CACHE_DIR = "ijkp2p";
    private static final String KEY_EXT_COMPETE_LOGIC_OPT_ENABLE = "ijkplayer.p2p_compete_logic_opt_enable";
    public static final String KEY_EXT_MAX_CREATE_DYNAMIC_SOCKETS = "ijkplayer.sym_max_keep_dynamic_sockets";
    public static final String KEY_EXT_P2P_ADJUST_CACHE_INDEX_A = "ijkplayer.p2p_adjust_cache_index_a";
    public static final String KEY_EXT_P2P_ADJUST_CACHE_INDEX_B = "ijkplayer.p2p_adjust_cache_index_b";
    private static final String KEY_EXT_P2P_ADJUST_CDN_WEIGHT_BY_P2P_TASK_ENABLE = "ijkplayer.p2p_adjust_cdn_weight_by_p2p_task_enable";
    private static final String KEY_EXT_P2P_AUDIO_LIMIT_PEER_COUNT = "ijkplayer.p2p_audio_limit_peer_count";
    private static final String KEY_EXT_P2P_BILIDNS_CMCC_IP = "ijkplayer.p2p_bilidns_cmcc_ip";
    private static final String KEY_EXT_P2P_BILIDNS_CT_IP = "ijkplayer.p2p_bilidns_ct_ip";
    private static final String KEY_EXT_P2P_BILIDNS_CU_IP = "ijkplayer.p2p_bilidns_cu_ip";
    private static final String KEY_EXT_P2P_BILI_DNS_TIME_OUT = "ijkplayer.p2p_bili_dns_time_out";
    private static final String KEY_EXT_P2P_BITRATE_FACTOR_LOWERBOUND = "ijkplayer.p2p_bitrate_factor_lowerbound";
    private static final String KEY_EXT_P2P_BITRATE_INC_COEFFICIENT = "ijkplayer.p2p_bitrate_inc_coefficient";
    public static final String KEY_EXT_P2P_BUVID = "buvid";
    public static final String KEY_EXT_P2P_CACHE_TO_DISK = "ijkplayer.p2p_cache_to_disk";
    private static final String KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_BITRATE_ENABLE = "ijkplayer.p2p_cdn_assign_interval_bitrate_enable";
    private static final String KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_NET_LEVEL_ENABLE = "ijkplayer.p2p_cdn_assign_interval_net_level_enable";
    private static final String KEY_EXT_P2P_CDN_CONNECTION_MONITOR_ENABLE = "ijkplayer.p2p_cdn_connection_monitor_enable";
    private static final String KEY_EXT_P2P_CDN_INTERVAL_BITRATE_RATIO = "ijkplayer.p2p_cdn_interval_bitrate_ratio";
    private static final String KEY_EXT_P2P_CDN_LOW_SPEED_RATIO = "ijkplayer.p2p_cdn_low_speed_ratio";
    private static final String KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_MIN_TIME_MS = "ijkplayer.p2p_cdn_mode_limit_assign_min_time_ms";
    private static final String KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_TIME_ENABLE = "ijkplayer.p2p_cdn_mode_limit_assign_time_enable";
    private static final String KEY_EXT_P2P_CDN_NET_DETECT_INTERVAL_MS = "ijkplayer.p2p_cdn_net_detect_interval_ms";
    private static final String KEY_EXT_P2P_CDN_NET_MAX_NODES = "ijkplayer.p2p_cdn_net_max_nodes";
    private static final String KEY_EXT_P2P_CDN_NET_QUALITY_ENABLE = "ijkplayer.p2p_cdn_net_quality_enable";
    private static final String KEY_EXT_P2P_CHECK_CDN_DOWNLOAD_SPEED = "ijkplayer.p2p_check_cdn_download_speed";
    private static final String KEY_EXT_P2P_CHECK_P2PSTATUS_CONFIG = "ijkplayer.p2p_http_server_check_p2pstatus_config";
    private static final String KEY_EXT_P2P_CHECK_PLAYER_CACHE_MS = "ijkplayer.p2p_check_player_cache_ms";
    private static final String KEY_EXT_P2P_CHECK_RECIVE_HEADER_ENABLE = "ijkplayer.p2p_check_recive_header_enable";
    private static final String KEY_EXT_P2P_CHECK_SPEED_CONFIG = "ijkplayer.p2p_http_server_check_speed_config";
    private static final String KEY_EXT_P2P_CHECK_UDP_DOWNLOAD_SPEED = "ijkplayer.p2p_check_udp_download_speed";
    public static final String KEY_EXT_P2P_CLOSE_STUN_REFLEX_PORTS = "ijkplayer.p2p_close_stun_reflex_ports";
    public static final String KEY_EXT_P2P_COOLING_TIME = "ijkplayer.p2p_cooling_time";
    public static final String KEY_EXT_P2P_CRC_CHECK_ENABLE = "ijkplayer.p2p_crc_check_enable";
    public static final String KEY_EXT_P2P_DEVICE_TYPE = "ijkplayer.device_type";
    private static final String KEY_EXT_P2P_DIFF_CDN_TYPE_COMPETE_ENABLE = "ijkplayer.p2p_diff_cdn_type_compete_enable";
    private static final String KEY_EXT_P2P_DISABLE_AFTER_CRASH = "ijkplayer.p2p_disble_after_crash";
    public static final String KEY_EXT_P2P_DISABLE_BLACKLIST = "ijkplayer.p2p-disable-whitelist";
    public static final String KEY_EXT_P2P_DISCARD_PEER = "ijkplayer.p2p_discard_peer";
    private static final String KEY_EXT_P2P_DNS_DYNAMIC_TIMEOUT_ENABLE = "ijkplayer.p2p_dns_dynamic_timeout_enable";
    public static final String KEY_EXT_P2P_DOWNLOAD = "ijkplayer.p2p_download";
    public static final String KEY_EXT_P2P_ENABLE_INDEPENDENT_LIVE_VOD_TRACKER = "ijkplayer.p2p_eanble_independent_live_vod_tracker";
    private static final String KEY_EXT_P2P_ENCRYPT_MAGIC_ENABLE = "ijkplayer.encrypt_magic_enable";
    private static final String KEY_EXT_P2P_ENCRYPT_MAGIC_LEVEL = "ijkplayer.subscribe_reserved";
    private static final String KEY_EXT_P2P_FEC_CTYPE = "ijkplayer.p2p_fec_ctype";
    private static final String KEY_EXT_P2P_FEC_ENABLE = "ijkplayer.p2p_fec_enable";
    private static final String KEY_EXT_P2P_FEC_LOWER_BOUND = "ijkplayer.p2p_fec_lower_bound";
    private static final String KEY_EXT_P2P_FEC_UPPER_BOUND = "ijkplayer.p2p_fec_upper_bound";
    public static final String KEY_EXT_P2P_GET_PEER_DELAY_MS = "ijkplayer.p2p_get_peer_delay_ms";
    public static final String KEY_EXT_P2P_HOTPUSH = "ijkplayer.p2p_hot_push";
    private static final String KEY_EXT_P2P_HTTP3_ENABLE = "ijkplayer.p2p_http3_enable";
    private static final String KEY_EXT_P2P_HTTPDNS_BILI_FIRST_ENABLE = "ijkplayer.p2p_httpdns_bili_first_enable";
    private static final String KEY_EXT_P2P_HTTPDNS_BILI_IP = "ijkplayer.p2p_httpdns_bili_ip";
    private static final String KEY_EXT_P2P_HTTPDNS_BILI_IP_ENABLE = "ijkplayer.p2p_httpdns_bili_ip_enable";
    private static final String KEY_EXT_P2P_HTTPDNS_BILI_IP_RETRY_TIMES = "ijkplayer.p2p_httpdns_bili_ip_retry_times";
    private static final String KEY_EXT_P2P_HTTPDNS_GOOGLE_SERVER_IPS = "ijkplayer.p2p_httpdns_google_server_ips";
    public static final String KEY_EXT_P2P_HTTP_CONNECT_TIMEOUT = "ijkplayer.p2p_http_connect_timeout";
    private static final String KEY_EXT_P2P_HTTP_FALLBACK_MCDNHOST = "ijkplayer.p2p_http_fallback_mcdnhost";
    private static final String KEY_EXT_P2P_HTTP_READ_TIMEOUT_RETRY_ENABLE = "ijkplayer.p2p_http_read_timeout_retry_enable";
    private static final String KEY_EXT_P2P_HTTP_SERVER_ENABLE = "ijkplayer.p2p_http_server_enable";
    private static final String KEY_EXT_P2P_HTTP_SERVER_THREAD_COUNT = "ijkplayer.p2p_http_server_thread_count";
    private static final String KEY_EXT_P2P_IMPROVE_DOWNLOAD_SPEED_ENABLE = "ijkplayer.p2p_improve_download_speed_enable";
    private static final String KEY_EXT_P2P_IPV4_DELAY_CONNECT_TIME = "ijkplayer.p2p_ipv4_delay_connect_time";
    private static final String KEY_EXT_P2P_IPV6_ENABLE = "ijkplayer.p2p_ipv6_enable";
    private static final String KEY_EXT_P2P_KCP_ACK_NODELAY = "ijkplayer.p2p_kcp_ack_nodelay";
    private static final String KEY_EXT_P2P_KCP_CWND_ADJUST_THRESHOLD = "ijkplayer.p2p_kcp_cwnd_adjust_threshold";
    private static final String KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_A = "ijkplayer.p2p_kcp_cwnd_gain_value_a";
    private static final String KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_B = "ijkplayer.p2p_kcp_cwnd_gain_value_b";
    private static final String KEY_EXT_P2P_KCP_FAST_RESEND = "ijkplayer.p2p_kcp_fast_resend";
    private static final String KEY_EXT_P2P_KCP_FLOW_CONTROL = "ijkplayer.p2p_kcp_flow_control";
    private static final String KEY_EXT_P2P_KCP_FLUSH_INTERVAL = "ijkplayer.p2p_kcp_flush_interval";
    private static final String KEY_EXT_P2P_KCP_HIGH_RTT_THRESHOLD = "ijkplayer.p2p_kcp_high_rtt_threshold";
    private static final String KEY_EXT_P2P_KCP_INIT_CWND = "ijkplayer.p2p_kcp_init_cwnd";
    private static final String KEY_EXT_P2P_KCP_LOW_RTT_THRESHOLD = "ijkplayer.p2p_kcp_low_rtt_threshold";
    private static final String KEY_EXT_P2P_KCP_MAX_THRESH = "ijkplayer.p2p_kcp_max_thresh";
    private static final String KEY_EXT_P2P_KCP_MIN_CWND = "ijkplayer.p2p_kcp_min_cwnd";
    private static final String KEY_EXT_P2P_KCP_MIN_RTO = "ijkplayer.p2p_kcp_min_rto";
    private static final String KEY_EXT_P2P_KCP_MIN_THRESH = "ijkplayer.p2p_kcp_min_thresh";
    private static final String KEY_EXT_P2P_KCP_RCVWND = "ijkplayer.p2p_kcp_rcvwnd";
    private static final String KEY_EXT_P2P_KCP_SESSION_PRIORITY_ENABLE = "ijkplayer.p2p_kcp_session_priority_enable";
    private static final String KEY_EXT_P2P_KCP_SNDWND = "ijkplayer.p2p_kcp_sndwnd";
    private static final String KEY_EXT_P2P_KCP_UPDATE_ENABLE = "ijkplayer.p2p_kcp_update_enable";
    public static final String KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_COUNT = "ijkplayer.p2p_live_download_timeout_count";
    public static final String KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_RATE = "ijkplayer.p2p_live_download_timeout_rate";
    public static final String KEY_EXT_P2P_LIVE_DOWNLOAD_UPLOAD = "ijkplayer.p2p_live_download_upload";
    public static final String KEY_EXT_P2P_LIVE_GET_PEER_INFO_INTERVAL_RATE = "ijkplayer.p2p_live_get_peer_info_interval_rate";
    public static final String KEY_EXT_P2P_LIVE_GET_PEER_INFO_THRESHOLD = "ijkplayer.p2p_live_get_peer_info_threshold";
    public static final String KEY_EXT_P2P_LIVE_MAX_SWTICH_COUNT = "ijkplayer.p2p_live_max_switch_count";
    public static final String KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_CDN = "ijkplayer.p2p_live_player_cache_ms_switch_cdn";
    public static final String KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_P2P = "ijkplayer.p2p_live_player_cache_ms_switch_p2p";
    public static final String KEY_EXT_P2P_LIVE_QUERY_EMPTY_THRESHOLD = "ijkplayer.p2p_live_query_empty_threshold";
    public static final String KEY_EXT_P2P_LIVE_READ_TIMEOUT_MS = "ijkplayer.p2p_live_read_timeout_ms";
    public static final String KEY_EXT_P2P_LIVE_SEGMENT_TIMEOUT_RATE = "ijkplayer.p2p_live_segment_timeout_rate";
    public static final String KEY_EXT_P2P_LIVE_STREAM_MAX_CONNCTIONS_COUNT = "ijkplayer.p2p_live_stream_max_conenctions_count";
    public static final String KEY_EXT_P2P_LIVE_USERS_WITHOUT_CDN_SUBSEGMENT = "ijkplayer.p2p_live_users_without_cdn_subsegment";
    private static final String KEY_EXT_P2P_LOCAL_CONNECT_ENABLE = "ijkplayer.p2p_local_connect_enable";
    private static final String KEY_EXT_P2P_LOW_SPEED_ERROR_INTERVAL = "ijkplayer.p2p_low_speed_error_interval";
    public static final String KEY_EXT_P2P_MAX_CACHE = "ijkplayer.p2p_max_cache";
    public static final String KEY_EXT_P2P_MAX_CACHE_PERCENT = "ijkplayer.p2p_max_cache_percent";
    public static final String KEY_EXT_P2P_MAX_CACHE_SWITCH_P2P = "ijkplayer.p2p_max_cache_switch_p2p";
    private static final String KEY_EXT_P2P_MAX_CDN_ASSIGN_TIME = "ijkplayer.p2p_max_cdn_assign_time_ms";
    public static final String KEY_EXT_P2P_MAX_CONNECTING_COUNT = "ijkplayer.p2p_max_connecting_count";
    public static final String KEY_EXT_P2P_MAX_CONNECTING_PORTRST_COUNT = "ijkplayer.p2p_max_connecting_portrst_count";
    public static final String KEY_EXT_P2P_MAX_CONNECTING_SYM_COUNT = "ijkplayer.p2p_max_connecting_sym_count";
    public static final String KEY_EXT_P2P_MAX_CONNECTION_COUNT = "ijkplayer.p2p_max_connection_count";
    private static final String KEY_EXT_P2P_MAX_READ_DRIVE_TIME_MS = "ijkplayer.p2p_max_read_drive_time_ms";
    private static final String KEY_EXT_P2P_MAX_SUBSEGMENT_COUNT_INTERVAL = "ijkplayer.p2p_http_server_max_segcount_interval";
    public static final String KEY_EXT_P2P_MAX_UPLOAD_COUNT = "ijkplayer.p2p_max_upload_count";
    public static final String KEY_EXT_P2P_MAX_UPLOAD_SPEED = "ijkplayer.p2p_max_upload_speed";
    private static final String KEY_EXT_P2P_MCDN_IPV6_ENABLE = "ijkplayer.p2p_mcdn_ipv6_enable";
    private static final String KEY_EXT_P2P_MCDN_MATCH_STR = "ijkplayer.p2p_mcdn_match_str";
    private static final String KEY_EXT_P2P_MCDN_ONLY_COMPETE_WITH_MCDN = "ijkplayer.p2p_mcdn_only_compete_with_mcdn";
    public static final String KEY_EXT_P2P_MD5_CHECK_ENABLE = "ijkplayer.p2p_md5_check_enable";
    private static final String KEY_EXT_P2P_MULTI_CDN_CONN_COUNT = "ijkplayer.p2p_multi_cdn_conn_count";
    private static final String KEY_EXT_P2P_MULTI_CDN_COUNT_ENABLE = "ijkplayer.p2p_multi_cdn_count_enable";
    private static final String KEY_EXT_P2P_MULTI_CDN_DOWNLOAD_ENABLE = "ijkplayer.p2p_multi_cdn_download_enable";
    private static final String KEY_EXT_P2P_NETWORK_LEVEL_FACTOR = "ijkplayer.p2p_network_level_factor";
    private static final String KEY_EXT_P2P_NETWORK_LEVEL_FACTOR_ENABLE = "ijkplayer.p2p_network_level_factor_enable";
    private static final String KEY_EXT_P2P_NETWORK_RTT_CHURNS_THRESHOLD = "ijkplayer.p2p_network_rtt_churns_threshold";
    public static final String KEY_EXT_P2P_NEW_DOWNLOAD_ENABLE = "ijkplayer.p2p_new_download_enable";
    private static final String KEY_EXT_P2P_ONE_MINUTE_REBOOT_LIMITED = "ijkplayer.p2p_one_minute_crash_times_limited";
    public static final String KEY_EXT_P2P_ONE_PEER_DOWNLOAD_SPEED = "ijkplayer.p2p_one_peer_download_speed";
    private static final String KEY_EXT_P2P_ONLY_PCDN_ENABLE = "ijkplayer.p2p_only_pcdn_enable";
    private static final String KEY_EXT_P2P_OPEN_MULTI_CDN_BIT_THRESHOLD = "ijkplayer.p2p_open_multi_cdn_bit_threshold";
    private static final String KEY_EXT_P2P_PCDN_DOWNLOAD_ENABLE = "ijkplayer.p2p_pcdn_download_enable";
    public static final String KEY_EXT_P2P_PEER_ENCRYPT_LEVEL = "ijkplayer.p2p_peer_encrypt_level";
    private static final String KEY_EXT_P2P_PEER_UPLOAD_PRIORITY_ENABLE = "ijkplayer.p2p_peer_upload_priority_enable";
    private static final String KEY_EXT_P2P_PEER_UPLOAD_SPEED_RATIO = "ijkplayer.p2p_peer_upload_speed_ratio";
    private static final String KEY_EXT_P2P_PERFORMANCE_OPTIMIZATION_ENABLE = "ijkplayer.p2p_performance_optimization_enable";
    public static final String KEY_EXT_P2P_PLAY_URL = "p2p_playurl";
    private static final String KEY_EXT_P2P_PRE_SEEK_ENABLE = "ijkplayer.p2p_pre_seek_enable";
    public static final String KEY_EXT_P2P_PRINT_CHECK_ENABLE = "ijkplayer.p2p_print_check_enable";
    private static final String KEY_EXT_P2P_READ_DRIVE_BEFORE_GET_PEERS_ENABLE = "ijkplayer.p2p_read_drive_before_get_peers_enable";
    private static final String KEY_EXT_P2P_REFACTOR_FIRST_FRAME_TIME_MS = "ijkplayer.p2p_refactor_first_frame_time_ms";
    private static final String KEY_EXT_P2P_REFACTOR_GET_PEER_DELAY_MS = "ijkplayer.p2p_refactor_get_peer_delay_ms";
    private static final String KEY_EXT_P2P_REFACTOR_RENDER_GAP_MS = "ijkplayer.p2p_refactor_render_gap_ms";
    private static final String KEY_EXT_P2P_REFACTOR_RENDER_MS = "ijkplayer.p2p_refactor_render_ms";
    private static final String KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_COUNT = "ijkplayer.p2p_release_peer_black_list_count";
    private static final String KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_ENABLE = "ijkplayer.p2p_release_peer_black_list_enable";
    private static final String KEY_EXT_P2P_RELEASE_PEER_MUST_CHECK_RTT_ENABLE = "ijkplayer.p2p_relase_peer_must_check_rtt_enable";
    private static final String KEY_EXT_P2P_RELEASE_PEER_RTT_THRESHOLD = "ijkplayer.p2p_release_peer_rtt_threshold";
    private static final String KEY_EXT_P2P_RENDER_CDN_ASSIGN_TIME = "ijkplayer.p2p_render_cdn_assign_time_ms";
    private static final String KEY_EXT_P2P_SEGMENT_ASSIGN_TIME_MS = "ijkplayer.p2p_segment_assign_time_ms";
    public static final String KEY_EXT_P2P_SERVER_URL = "p2p_server_url";
    public static final String KEY_EXT_P2P_SERVER_URL_YUNCHANG = "p2p_server_url_yunchang";
    private static final String KEY_EXT_P2P_SET_MAX_READ_DRIVE_TIME_ENABLE = "ijkplayer.p2p_set_max_read_drive_time_enable";
    private static final String KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_DURATION = "ijkplayer.p2p_speed_mode_min_subsegment_duration";
    private static final String KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_SIZE = "ijkplayer.p2p_speed_mode_min_subsegment_size";
    private static final String KEY_EXT_P2P_STORY_GET_PEER_DELAY_MS = "ijkplayer.p2p_story_get_peer_delay_ms";
    private static final String KEY_EXT_P2P_STORY_OPEN_MULTI_CDN_BIT_THRESHOLD = "ijkplayer.p2p_story_open_multi_cdn_bit_threshold";
    private static final String KEY_EXT_P2P_STORY_PRELOAD_LEVEL = "ijkplayer.p2p_story_preload_level";
    private static final String KEY_EXT_P2P_STORY_STR_CDN_ASSIGN_INTERVAL = "ijkplayer.p2p_story_str_cdn_assign_interval";
    private static final String KEY_EXT_P2P_STREAM_TIMEOUT_BITRATE_CONFIG = "ijkplayer.p2p_stream_timeout_bitrate_config";
    private static final String KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL = "ijkplayer.p2p_str_cdn_assign_interval";
    private static final String KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL_NET_LEVEL_RATIO = "ijkplayer.p2p_str_cdn_assign_interval_net_level_ratio";
    private static final String KEY_EXT_P2P_STR_PRELOAD_FIRST_FRAME_TIME_MS = "ijkplayer.p2p_str_preload_first_frame_time_ms";
    public static final String KEY_EXT_P2P_STUN_REFLEX_DETECT_INTERVAL = "ijkplayer.p2p_stun_reflex_detect_interval";
    public static final String KEY_EXT_P2P_SUBSCRIBE_QUERY_INTERVAL = "ijkplayer.p2p_subscribe_query_interval";
    private static final String KEY_EXT_P2P_SUBSCRIBE_SUCC_RATE_ENABLE = "ijkplayer.p2p_subscribe_succ_rate_enable";
    private static final String KEY_EXT_P2P_SUPER_NODE_SPEED_MEASURE_TIME_GAP_MS = "ijkplayer.p2p_super_node_speed_measure_time_gap_ms";
    public static final String KEY_EXT_P2P_SWITCH_CDN_INTERVAL = "ijkplayer.p2p_switch_cdn_interval";
    public static final String KEY_EXT_P2P_SYM_NEAR_RANGE = "ijkplayer.p2p_sym_near_range";
    private static final String KEY_EXT_P2P_TCP_DYNAMIC_BITRATE_BUFFER_RATE = "ijkplayer.p2p_tcp_dynamic_bitrate_buf_rate";
    private static final String KEY_EXT_P2P_TCP_DYNAMIC_MIN_CONNECT_TIMEOUT = "ijkplayer.p2p_tcp_dynamic_min_connect_timeout";
    private static final String KEY_EXT_P2P_TIMEOUT_INCREASE_TO_MAX_ENABLE = "ijkplayer.p2p_timeout_increase_to_max_enable";
    public static final String KEY_EXT_P2P_TRACKER_HEARTBEAT_INTERVAL_MS = "ijkplayer.p2p_tracker_heartbeat_interval";
    private static final String KEY_EXT_P2P_UDP_LOSS_RATE_PARAMS = "ijkplayer.p2p_udp_loss_rate_params";
    private static final String KEY_EXT_P2P_UDP_LOSS_RATE_SD_PERMILLAGE_CONFIG = "ijkplayer.p2p_udp_loss_rate_sd_permillage_config";
    private static final String KEY_EXT_P2P_UDP_RTT_PARAMS = "ijkplayer.p2p_udp_rtt_params";
    private static final String KEY_EXT_P2P_UDP_RTT_SD_CONFIG = "ijkplayer.p2p_udp_rtt_sd_config";
    private static final String KEY_EXT_P2P_UPDATE_URL_CDN_COMPETE_ENABLE = "ijkplayer.p2p_update_url_cdn_compete_enable";
    public static final String KEY_EXT_P2P_UPLOAD = "ijkplayer.p2p_upload";
    public static final String KEY_EXT_P2P_UPLOAD_LIMIT = "ijkplayer.p2p_upload_limit";
    public static final String KEY_EXT_P2P_UPLOAD_RATE = "ijkplayer.p2p_upload_rate";
    public static final String KEY_EXT_P2P_UPOLOAD_INVALID_COUNT = "ijkplayer.p2p_upload_invalid_count";
    public static final String KEY_EXT_P2P_USE_RELEASE_TRACKER = "ijkplayer.p2p_use_release_tracker";
    private static final String KEY_EXT_P2P_VIDEO_LIMIT_PEER_COUNT = "ijkplayer.p2p_video_limit_peer_count";
    private static final String KEY_EXT_P2P_VOD_DOWNLOAD_TIMEOUT_COUNT = "ijkplayer.p2p_vod_download_timeout_count";
    public static final String KEY_EXT_P2P_VOD_GET_PEER_INFO_INTERVAL_RATE = "ijkplayer.p2p_vod_get_peer_info_interval_rate";
    public static final String KEY_EXT_P2P_VOD_GET_PEER_INFO_THRESHOLD = "ijkplayer.p2p_vod_get_peer_info_threshold";
    public static final String KEY_EXT_P2P_VOD_MAX_BLOCK_COUNT = "ijkplayer.p2p_vod_max_block_count";
    public static final String KEY_EXT_P2P_VOD_MAX_SUB_SEGMENT_COUNT = "ijkplayer.p2p_vod_max_sub_segment_count";
    public static final String KEY_EXT_P2P_VOD_MAX_SWTICH_COUNT = "ijkplayer.p2p_vod_max_switch_count";
    public static final String KEY_EXT_P2P_VOD_MIN_SUB_SEGMENT_COUNT = "ijkplayer.p2p_vod_min_sub_segment_count";
    private static final String KEY_EXT_P2P_VOD_PGC_PLAYER_CACHE_MS_INC = "ijkplayer.p2p_vod_pgc_switch_inc_ms";
    public static final String KEY_EXT_P2P_VOD_PLAYER_CACHE_MS_SWITCH_CDN = "ijkplayer.p2p_vod_player_cache_ms_switch_cdn";
    public static final String KEY_EXT_P2P_VOD_PLAYER_CACHE_MS_SWITCH_P2P = "ijkplayer.p2p_vod_player_cache_ms_switch_p2p";
    public static final String KEY_EXT_P2P_VOD_READ_TIMEOUT_MS = "ijkplayer.p2p_vod_read_timeout_ms";
    private static final String KEY_EXT_P2P_WEAK_NET_TASK_TIMEOUT_RATE = "ijkplayer.p2p_weak_net_timeout_rate";
    private static final String KEY_EXT_P2P_ZONE_BLACK_LIST = "ijkplayer.p2p_zone_black_list";
    private static final String KEY_SP_P2P_DEVICE_ID = "p2p_device_id";
    private static final String KEY_SP_P2P_IPV6_STUN_SERVER1 = "p2p_ipv6_stun_server1";
    private static final String KEY_SP_P2P_IPV6_STUN_SERVER2 = "p2p_ipv6_stun_server2";
    private static final String KEY_SP_P2P_STUN_SERVER1 = "p2p_stun_server1";
    private static final String KEY_SP_P2P_STUN_SERVER2 = "p2p_stun_server2";
    private static final String KEY_SP_P2P_STUN_SERVER3 = "p2p_stun_server3";
    private static final String KEY_SP_P2P_STUN_SERVER4 = "p2p_stun_server4";
    private static final String KEY_SP_P2P_STUN_SERVER5 = "p2p_stun_server5";
    private static final String KEY_SP_P2P_STUN_SERVER6 = "p2p_stun_server6";
    private static final String KEY_SP_P2P_STUN_SERVER7 = "p2p_stun_server7";
    private static final String KEY_SP_P2P_STUN_SERVER8 = "p2p_stun_server8";
    private static final String K_IPV6_STUN_SERVER1 = "ipv6_stun_server_1";
    private static final String K_IPV6_STUN_SERVER2 = "ipv6_stun_server_2";
    private static final String K_MAX_CREATE_DYNAMIC_SOCKETS = "sym_max_keep_dynamic_sockets";
    private static final String K_P2P_ADJUST_CACHE_INDEX_A = "p2p_adjust_cache_index_a";
    private static final String K_P2P_ADJUST_CACHE_INDEX_B = "p2p_adjust_cache_index_b";
    private static final String K_P2P_ADJUST_CDN_WEIGHT_BY_P2P_TASK_ENABLE = "p2p_adjust_cdn_weight_by_p2p_task_enable";
    private static final String K_P2P_AUDIO_LIMIT_PEER_COUNT = "p2p_audio_limit_peer_count";
    private static final String K_P2P_BILIDNS_CMCC_IP = "p2p_bilidns_cmcc_ip";
    private static final String K_P2P_BILIDNS_CT_IP = "p2p_bilidns_ct_ip";
    private static final String K_P2P_BILIDNS_CU_IP = "p2p_bilidns_cu_ip";
    private static final String K_P2P_BILI_DNS_TIME_OUT = "p2p_bili_dns_time_out";
    private static final String K_P2P_BITRATE_FACTOR_LOWERBOUND = "p2p_bitrate_factor_lowerbound";
    private static final String K_P2P_BITRATE_INC_COEFFICIENT = "p2p_bitrate_inc_coefficient";
    private static final String K_P2P_CACHE_PATH = "p2p_cache_path";
    private static final String K_P2P_CACHE_TO_DISK = "p2p_cache_to_disk";
    private static final String K_P2P_CDN_ASSIGN_INTERVAL_BITRATE_ENABLE = "p2p_cdn_assign_interval_bitrate_enable";
    private static final String K_P2P_CDN_ASSIGN_INTERVAL_NET_LEVEL_ENABLE = "p2p_cdn_assign_interval_net_level_enable";
    private static final String K_P2P_CDN_CONNECTION_MONITOR_ENABLE = "p2p_cdn_connection_monitor_enable";
    private static final String K_P2P_CDN_INTERVAL_BITRATE_RATIO = "p2p_cdn_interval_bitrate_ratio";
    private static final String K_P2P_CDN_LOW_SPEED_RATIO = "p2p_cdn_low_speed_ratio";
    private static final String K_P2P_CDN_MODE_LIMIT_ASSIGN_MIN_TIME_MS = "p2p_cdn_mode_limit_assign_min_time_ms";
    private static final String K_P2P_CDN_MODE_LIMIT_ASSIGN_TIME_ENABLE = "p2p_cdn_mode_limit_assign_time_enable";
    private static final String K_P2P_CDN_NET_DETECT_INTERVAL_MS = "p2p_cdn_net_detect_interval_ms";
    private static final String K_P2P_CDN_NET_MAX_NODES = "p2p_cdn_net_max_nodes";
    private static final String K_P2P_CDN_NET_QUALITY_ENABLE = "p2p_cdn_net_quality_enable";
    private static final String K_P2P_CHECK_CDN_DOWNLOAD_SPEED = "p2p_check_cdn_download_speed";
    private static final String K_P2P_CHECK_P2PSTATUS_CONFIG = "p2p_http_server_check_p2pstatus_config";
    private static final String K_P2P_CHECK_PLAYER_CACHE_MS = "p2p_check_player_cache_ms";
    private static final String K_P2P_CHECK_RECIVE_HEADER_ENABLE = "p2p_check_recive_header_enable";
    private static final String K_P2P_CHECK_SPEED_CONFIG = "p2p_http_server_check_speed_config";
    private static final String K_P2P_CHECK_UDP_DOWNLOAD_SPEED = "p2p_check_udp_download_speed";
    private static final String K_P2P_CLOSE_STUN_REFLEX_PORTS = "p2p_close_stun_reflex_ports";
    private static final String K_P2P_COMPETE_LOGIC_OPT_ENABLE = "p2p_compete_logic_opt_enable";
    private static final String K_P2P_COOLING_TIME = "p2p_cooling_time";
    private static final String K_P2P_CRC_CHECK_ENABLE = "p2p_crc_check_enable";
    private static final String K_P2P_DIFF_CDN_TYPE_COMPETE_ENABLE = "p2p_diff_cdn_type_compete_enable";
    private static final String K_P2P_DISABLE_AFTER_CRASH = "p2p_disble_after_crash";
    private static final String K_P2P_DISCARD_PEER = "p2p_discard_peer";
    private static final String K_P2P_DNS_DYNAMIC_TIMEOUT_ENABLE = "p2p_dns_dynamic_timeout_enable";
    private static final String K_P2P_DOWNLOAD_TIMEOUT_RATE = "p2p_download_timeout_rate";
    private static final String K_P2P_ENABLE_INDEPENDENT_LIVE_VOD_TRACKER = "p2p_eanble_independent_live_vod_tracker";
    private static final String K_P2P_ENCRYPT_MAGIC_ENABLE = "encrypt_magic_enable";
    private static final String K_P2P_ENCRYPT_MAGIC_LEVEL = "subscribe_reserved";
    private static final String K_P2P_FEC_CTYPE = "p2p_fec_ctype";
    private static final String K_P2P_FEC_ENABLE = "p2p_fec_enable";
    private static final String K_P2P_FEC_LOWER_BOUND = "p2p_fec_lower_bound";
    private static final String K_P2P_FEC_UPPER_BOUND = "p2p_fec_upper_bound";
    private static final String K_P2P_GET_PEER_DELAY_MS = "p2p_get_peer_delay_ms";
    private static final String K_P2P_HOT_PUSH = "p2p_hot_push";
    private static final String K_P2P_HTTP3_ENABLE = "p2p_http3_enable";
    private static final String K_P2P_HTTPDNS_BILI_FIRST_ENABLE = "p2p_httpdns_bili_first_enable";
    private static final String K_P2P_HTTPDNS_BILI_IP = "p2p_httpdns_bili_ip";
    private static final String K_P2P_HTTPDNS_BILI_IP_ENABLE = "p2p_httpdns_bili_ip_enable";
    private static final String K_P2P_HTTPDNS_BILI_IP_RETRY_TIMES = "p2p_httpdns_bili_ip_retry_times";
    private static final String K_P2P_HTTPDNS_GOOGLE_SERVER_IPS = "p2p_httpdns_google_server_ips";
    private static final String K_P2P_HTTP_CONNECT_TIMEOUT = "p2p_http_connect_timeout";
    private static final String K_P2P_HTTP_FALLBACK_MCDNHOST = "p2p_http_fallback_mcdnhost";
    private static final String K_P2P_HTTP_READ_TIMEOUT_RETRY_ENABLE = "p2p_http_read_timeout_retry_enable";
    private static final String K_P2P_HTTP_SERVER_ENABLE = "p2p_http_server_enable";
    private static final String K_P2P_HTTP_SERVER_THREAD_COUNT = "p2p_http_server_thread_count";
    private static final String K_P2P_IMPROVE_DOWNLOAD_SPEED_ENABLE = "p2p_improve_download_speed_enable";
    private static final String K_P2P_IPV4_DELAY_CONNECT_TIME = "p2p_ipv4_delay_connect_time";
    private static final String K_P2P_IPV6_ENABLE = "p2p_ipv6_enable";
    private static final String K_P2P_KCP_ACK_NODELAY = "p2p_kcp_ack_nodelay";
    private static final String K_P2P_KCP_CWND_ADJUST_THRESHOLD = "p2p_kcp_cwnd_adjust_threshold";
    private static final String K_P2P_KCP_CWND_GAIN_VALUE_A = "p2p_kcp_cwnd_gain_value_a";
    private static final String K_P2P_KCP_CWND_GAIN_VALUE_B = "p2p_kcp_cwnd_gain_value_b";
    private static final String K_P2P_KCP_FAST_RESEND = "p2p_kcp_fast_resend";
    private static final String K_P2P_KCP_FLOW_CONTROL = "p2p_kcp_flow_control";
    private static final String K_P2P_KCP_FLUSH_INTERVAL = "p2p_kcp_flush_interval";
    private static final String K_P2P_KCP_HIGH_RTT_THRESHOLD = "p2p_kcp_high_rtt_threshold";
    private static final String K_P2P_KCP_INIT_CWND = "p2p_kcp_init_cwnd";
    private static final String K_P2P_KCP_LOW_RTT_THRESHOLD = "p2p_kcp_low_rtt_threshold";
    private static final String K_P2P_KCP_MAX_THRESH = "p2p_kcp_max_thresh";
    private static final String K_P2P_KCP_MIN_CWND = "p2p_kcp_min_cwnd";
    private static final String K_P2P_KCP_MIN_RTO = "p2p_kcp_min_rto";
    private static final String K_P2P_KCP_MIN_THRESH = "p2p_kcp_min_thresh";
    private static final String K_P2P_KCP_RCVWND = "p2p_kcp_rcvwnd";
    private static final String K_P2P_KCP_SESSION_PRIORITY_ENABLE = "p2p_kcp_session_priority_enable";
    private static final String K_P2P_KCP_SNDWND = "p2p_kcp_sndwnd";
    private static final String K_P2P_KCP_UPDATE_ENABLE = "p2p_kcp_update_enable";
    private static final String K_P2P_LIVE_DOWNLOAD_TIMEOUT_COUNT = "p2p_live_download_timeout_count";
    private static final String K_P2P_LIVE_GET_PEER_INFO_INTERVAL_RATE = "p2p_live_get_peer_info_interval_rate";
    private static final String K_P2P_LIVE_GET_PEER_INFO_THRESHOLD = "p2p_live_get_peer_info_threshold";
    private static final String K_P2P_LIVE_MAX_SWTICH_COUNT = "p2p_live_max_switch_count";
    private static final String K_P2P_LIVE_QUERY_EMPTY_THRESHOLD = "p2p_live_query_empty_threshold";
    private static final String K_P2P_LIVE_READ_TIMEOUT_MS = "p2p_live_read_timeout_ms";
    private static final String K_P2P_LIVE_SEGMENT_TIMEOUT_RATE = "p2p_live_segment_timeout_rate";
    private static final String K_P2P_LIVE_STREAM_MAX_CONNCTIONS_COUNT = "p2p_live_stream_max_conenctions_count";
    private static final String K_P2P_LIVE_SWITCH_CDN_MS = "p2p_live_switch_cdn_ms";
    private static final String K_P2P_LIVE_SWITCH_P2P_MS = "p2p_live_switch_p2p_ms";
    private static final String K_P2P_LIVE_UPLOAD = "p2p_live_upload";
    private static final String K_P2P_LIVE_USERS_WITHOUT_CDN_SUBSEGMENT = "p2p_live_users_without_cdn_subsegment";
    private static final String K_P2P_LOCAL_CONNECT_ENABLE = "p2p_local_connect_enable";
    private static final String K_P2P_LOW_SPEED_ERROR_INTERVAL = "p2p_low_speed_error_interval";
    private static final String K_P2P_MAX_CACHE_SIZE = "p2p_max_cache_size";
    private static final String K_P2P_MAX_CACHE_SWITCH_P2P = "p2p_max_cache_switch_p2p";
    private static final String K_P2P_MAX_CDN_ASSIGN_TIME = "p2p_max_cdn_assign_time_ms";
    private static final String K_P2P_MAX_CONNECTING_COUNT = "p2p_max_connecting_count";
    private static final String K_P2P_MAX_CONNECTING_PORTRST_COUNT = "p2p_max_connecting_portrst_count";
    private static final String K_P2P_MAX_CONNECTING_SYM_COUNT = "p2p_max_connecting_sym_count";
    private static final String K_P2P_MAX_CONNECTION_COUNT = "p2p_max_connection_count";
    private static final String K_P2P_MAX_READ_DRIVE_TIME_MS = "p2p_max_read_drive_time_ms";
    private static final String K_P2P_MAX_SUBSEGMENT_COUNT_INTERVAL = "p2p_http_server_max_segcount_interval";
    private static final String K_P2P_MAX_UPLOAD_COUNT = "p2p_max_upload_count";
    private static final String K_P2P_MAX_UPLOAD_SPEED = "p2p_max_upload_speed";
    private static final String K_P2P_MCDN_IPV6_ENABLE = "p2p_mcdn_ipv6_enable";
    private static final String K_P2P_MCDN_MATCH_STR = "p2p_mcdn_match_str";
    private static final String K_P2P_MCDN_ONLY_COMPETE_WITH_MCDN = "p2p_mcdn_only_compete_with_mcdn";
    private static final String K_P2P_MD5_CHECK_ENABLE = "p2p_md5_check_enable";
    private static final String K_P2P_MULTI_CDN_CONN_COUNT = "p2p_multi_cdn_conn_count";
    private static final String K_P2P_MULTI_CDN_COUNT_ENABLE = "p2p_multi_cdn_count_enable";
    private static final String K_P2P_MULTI_CDN_DOWNLOAD_ENABLE = "p2p_multi_cdn_download_enable";
    private static final String K_P2P_NETWORK_LEVEL_FACTOR = "p2p_network_level_factor";
    private static final String K_P2P_NETWORK_LEVEL_FACTOR_ENABLE = "p2p_network_level_factor_enable";
    private static final String K_P2P_NETWORK_RTT_CHURNS_THRESHOLD = "p2p_network_rtt_churns_threshold";
    private static final String K_P2P_NEW_DOWNLOAD_ENABLE = "p2p_new_download_enable";
    private static final String K_P2P_ONE_MINUTE_REBOOT_LIMITED = "p2p_one_minute_crash_times_limited";
    private static final String K_P2P_ONE_PEER_DOWNLOAD_SPEED = "p2p_one_peer_download_speed";
    private static final String K_P2P_ONLY_PCDN_ENABLE = "p2p_only_pcdn_enable";
    private static final String K_P2P_OPEN_MULTI_CDN_BIT_THRESHOLD = "p2p_open_multi_cdn_bit_threshold";
    private static final String K_P2P_PCDN_DOWNLOAD_ENABLE = "p2p_pcdn_download_enable";
    private static final String K_P2P_PEER_ENCRYPT_LEVEL = "p2p_peer_encrypt_level";
    private static final String K_P2P_PEER_UPLOAD_PRIORITY_ENABLE = "p2p_peer_upload_priority_enable";
    private static final String K_P2P_PEER_UPLOAD_SPEED_RATIO = "p2p_peer_upload_speed_ratio";
    private static final String K_P2P_PERFORMANCE_OPTIMIZATION_ENABLE = "p2p_performance_optimization_enable";
    private static final String K_P2P_PRE_SEEK_ENABLE = "p2p_pre_seek_enable";
    private static final String K_P2P_PRINT_CHECK_ENABLE = "p2p_print_check_enable";
    private static final String K_P2P_READ_DRIVE_BEFORE_GET_PEERS_ENABLE = "p2p_read_drive_before_get_peers_enable";
    private static final String K_P2P_REFACTOR_FIRST_FRAME_TIME_MS = "p2p_refactor_first_frame_time_ms";
    private static final String K_P2P_REFACTOR_GET_PEER_DELAY_MS = "p2p_refactor_get_peer_delay_ms";
    private static final String K_P2P_REFACTOR_RENDER_GAP_MS = "p2p_refactor_render_gap_ms";
    private static final String K_P2P_REFACTOR_RENDER_MS = "p2p_refactor_render_ms";
    private static final String K_P2P_RELEASE_PEER_BLACK_LIST_COUNT = "p2p_release_peer_black_list_count";
    private static final String K_P2P_RELEASE_PEER_BLACK_LIST_ENABLE = "p2p_release_peer_black_list_enable";
    private static final String K_P2P_RELEASE_PEER_MUST_CHECK_RTT_ENABLE = "p2p_relase_peer_must_check_rtt_enable";
    private static final String K_P2P_RELEASE_PEER_RTT_THRESHOLD = "p2p_release_peer_rtt_threshold";
    private static final String K_P2P_RENDER_CDN_ASSIGN_TIME = "p2p_render_cdn_assign_time_ms";
    private static final String K_P2P_SEGMENT_ASSIGN_TIME_MS = "p2p_segment_assign_time_ms";
    private static final String K_P2P_SET_MAX_READ_DRIVE_TIME_ENABLE = "p2p_set_max_read_drive_time_enable";
    private static final String K_P2P_SPEED_MODE_MIN_SUBSEGMENT_DURATION = "p2p_speed_mode_min_subsegment_duration";
    private static final String K_P2P_SPEED_MODE_MIN_SUBSEGMENT_SIZE = "p2p_speed_mode_min_subsegment_size";
    private static final String K_P2P_STORY_GET_PEER_DELAY_MS = "p2p_story_get_peer_delay_ms";
    private static final String K_P2P_STORY_OPEN_MULTI_CDN_BIT_THRESHOLD = "p2p_story_open_multi_cdn_bit_threshold";
    private static final String K_P2P_STORY_PRELOAD_LEVEL = "p2p_story_preload_level";
    private static final String K_P2P_STORY_STR_CDN_ASSIGN_INTERVAL = "p2p_story_str_cdn_assign_interval";
    private static final String K_P2P_STREAM_TIMEOUT_BITRATE_CONFIG = "p2p_stream_timeout_bitrate_config";
    private static final String K_P2P_STR_CDN_ASSIGN_INTERVAL = "p2p_str_cdn_assign_interval";
    private static final String K_P2P_STR_CDN_ASSIGN_INTERVAL_NET_LEVEL_RATIO = "p2p_str_cdn_assign_interval_net_level_ratio";
    private static final String K_P2P_STR_PRELOAD_FIRST_FRAME_TIME_MS = "p2p_str_preload_first_frame_time_ms";
    private static final String K_P2P_STUN_REFLEX_DETECT_INTERVAL = "p2p_stun_reflex_detect_interval";
    private static final String K_P2P_SUBSCRIBE_QUERY_INTERVAL = "p2p_subscribe_query_interval";
    private static final String K_P2P_SUBSCRIBE_SUCC_RATE_ENABLE = "p2p_subscribe_succ_rate_enable";
    private static final String K_P2P_SUPER_NODE_SPEED_MEASURE_TIME_GAP_MS = "p2p_super_node_speed_measure_time_gap_ms";
    private static final String K_P2P_SWITCH_CDN_INTERVAL = "p2p_switch_cdn_interval";
    private static final String K_P2P_SYM_NEAR_RANGE = "p2p_sym_near_range";
    private static final String K_P2P_TCP_DYNAMIC_BITRATE_BUFFER_RATE = "p2p_tcp_dynamic_bitrate_buf_rate";
    private static final String K_P2P_TCP_DYNAMIC_MIN_CONNECT_TIMEOUT = "p2p_tcp_dynamic_min_connect_timeout";
    private static final String K_P2P_TIMEOUT_INCREASE_TO_MAX_ENABLE = "p2p_timeout_increase_to_max_enable";
    private static final String K_P2P_TRACKER_HEARTBEAT_INTERVAL = "p2p_tracker_heartbeat_interval";
    private static final String K_P2P_UDP_LOSS_RATE_PARAMS = "p2p_udp_loss_rate_params";
    private static final String K_P2P_UDP_LOSS_RATE_SD_PERMILLAGE_CONFIG = "p2p_udp_loss_rate_sd_permillage_config";
    private static final String K_P2P_UDP_RTT_PARAMS = "p2p_udp_rtt_params";
    private static final String K_P2P_UDP_RTT_SD_CONFIG = "p2p_udp_rtt_sd_config";
    private static final String K_P2P_UPDATE_URL_CDN_COMPETE_ENABLE = "p2p_update_url_cdn_compete_enable";
    private static final String K_P2P_UPLOAD_LIMIT = "p2p_upload_limit";
    private static final String K_P2P_UPLOAD_RATE = "p2p_upload_rate";
    private static final String K_P2P_UPOLOAD_INVALID_COUNT = "p2p_upload_invalid_count";
    private static final String K_P2P_VIDEO_LIMIT_PEER_COUNT = "p2p_video_limit_peer_count";
    private static final String K_P2P_VOD_DOWNLOAD_TIMEOUT_COUNT = "p2p_vod_download_timeout_count";
    private static final String K_P2P_VOD_GET_PEER_INFO_INTERVAL_RATE = "p2p_vod_get_peer_info_interval_rate";
    private static final String K_P2P_VOD_GET_PEER_INFO_THRESHOLD = "p2p_vod_get_peer_info_threshold";
    private static final String K_P2P_VOD_MAX_BLOCK_COUNT = "p2p_vod_max_block_count";
    private static final String K_P2P_VOD_MAX_SUB_SEGMENT_COUNT = "p2p_vod_max_sub_segment_count";
    private static final String K_P2P_VOD_MAX_SWTICH_COUNT = "p2p_vod_max_switch_count";
    private static final String K_P2P_VOD_MIN_SUB_SEGMENT_COUNT = "p2p_vod_min_sub_segment_count";
    private static final String K_P2P_VOD_PGC_PLAYER_CACHE_MS_INC = "p2p_vod_pgc_switch_inc_ms";
    private static final String K_P2P_VOD_READ_TIMEOUT_MS = "p2p_vod_read_timeout_ms";
    private static final String K_P2P_VOD_SWITCH_P2P_MS = "p2p_vod_switch_p2p_ms";
    private static final String K_P2P_VOD_UPLOAD = "p2p_vod_upload";
    private static final String K_P2P_WEAK_NET_TASK_TIMEOUT_RATE = "p2p_weak_net_timeout_rate";
    private static final String K_P2P_ZONE_BLACK_LIST = "p2p_zone_black_list";
    private static final String K_PEER_DEVICE_ID = "device_id";
    private static final String K_PEER_DEVICE_TYPE = "device_type";
    private static final String K_PEER_NETWORK_TYPE = "network_type";
    private static final String K_PEER_P2P_LIVE_STRATEGY = "p2p_live_strategy";
    private static final String K_PEER_P2P_STRATEGY = "p2p_strategy";
    private static final String K_STUN_SERVER1 = "stun_server_1";
    private static final String K_STUN_SERVER2 = "stun_server_2";
    private static final String K_STUN_SERVER3 = "stun_server_3";
    private static final String K_STUN_SERVER4 = "stun_server_4";
    private static final String K_STUN_SERVER5 = "stun_server_5";
    private static final String K_STUN_SERVER6 = "stun_server_6";
    private static final String K_STUN_SERVER7 = "stun_server_7";
    private static final String K_STUN_SERVER8 = "stun_server_8";
    private static final String P2P_MD5_CHECK_URL_DEFAULT = "";
    private static final String P2P_PLAY_URL_DEFAULT = "http://app.bilibili.com/x/playurl/ott?";
    private static final String P2P_PROXY_JSON = "p2p_proxy.json";
    private static final String P2P_SERVER_URL_DEFAULT = "https://api.bilibili.com/x/pd-proxy/tracker?";
    private static final String P2P_SERVER_URL_DEFAULT_YUNCHANG = "https://api.bilibili.com/x/pd-proxy/yunchang?";
    private static final String TAG = "IJKMEDIA_P2P";
    private static final int VIDEO_TCP_INIT_BUFFER_SIZE = 102400;
    private static final int VIDEO_TCP_MAX_BUFFER_SIZE = 1048576;
    private static String sP2PDeviceId;
    public static final Bundle sP2POnlineConfig;
    private Context mAppContex;
    private Bundle mApplyConfigs;
    private IP2P mClient;
    private ArrayList<String> mConfigKeyExcepts;
    private Bundle mConfigs;
    private IjkNetworkUtils.NetWorkType mCurNet;
    private boolean mEnable;
    private boolean mGrpcClientInited;
    private P2PTrackerClientProxy mLiveTrackerProxy;
    private List<Long> mP2PRebootTimes = new ArrayList();
    private P2PServerResolver mP2PServerResolver;
    private P2PTrackerClientProxy mTrackerProxy;
    private static P2P sP2P = null;
    public static final List<String> defaultTrackerServers = new ArrayList();
    public static final List<String> defaultStunServers = new ArrayList();
    public static final List<String> defaultIpv6StunServers = new ArrayList();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum DEVICE_TYPE {
        DEVICE_IPHONE,
        DEVICE_ANDROID,
        DEVICE_OTT,
        DEVICE_PC,
        DEVICE_OPENWRT,
        DEVICE_MCDN,
        DEVICE_ANDROID_BLUE
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum P2P_STRATEGY {
        STRATEGY_UPLOAD_DOWNLOAD,
        STRATEGY_DOWNLOAD_NO_UPLOAD,
        STRATEGY_UPLOAD_NO_DOWNLOAD,
        STRATEGY_HOT_PUSH
    }

    static {
        defaultTrackerServers.add("ks-sh-tracker-02.biliapi.net");
        defaultStunServers.add("81.69.192.254:3478");
        defaultStunServers.add("159.75.113.64:3478");
        defaultStunServers.add("82.156.104.30:3478");
        defaultStunServers.add("139.155.176.138:3478");
        defaultStunServers.add("42.192.67.56:3478");
        defaultStunServers.add("159.75.138.193:3478");
        defaultStunServers.add("82.156.104.41:3478");
        defaultStunServers.add("139.155.7.96:3478");
        defaultIpv6StunServers.add("[2402:4e00:1401:cd03:0:9824:892b:3332]:3478");
        defaultIpv6StunServers.add("[2402:4e00:1401:cd03:0:9824:888e:36c2]:3478");
        sP2POnlineConfig = new Bundle();
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DOWNLOAD, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CACHE_TO_DISK, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_UPLOAD, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HOTPUSH, false);
        sP2POnlineConfig.putLong(KEY_EXT_P2P_MAX_CACHE, VBNumberExtKt.MB);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_DEVICE_TYPE, DEVICE_TYPE.DEVICE_ANDROID.ordinal());
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DISABLE_BLACKLIST, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_USE_RELEASE_TRACKER, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_LIVE_DOWNLOAD_UPLOAD, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_CDN, IjkMediaCodecInfo.RANK_MAX);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_P2P, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CACHE_PERCENT, 30);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_TRACKER_HEARTBEAT_INTERVAL_MS, 45000);
        sP2POnlineConfig.putLong(KEY_EXT_P2P_MAX_UPLOAD_SPEED, 50000000L);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_PLAYER_CACHE_MS_SWITCH_CDN, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_PLAYER_CACHE_MS_SWITCH_P2P, 7000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_RATE, 900);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_COUNT, 10);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_ENABLE_INDEPENDENT_LIVE_VOD_TRACKER, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CONNECTION_COUNT, 150);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CONNECTING_COUNT, 50);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_UPLOAD_COUNT, 20);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_UPLOAD_LIMIT, 12);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_READ_TIMEOUT_MS, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_READ_TIMEOUT_MS, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_MAX_SWTICH_COUNT, 2);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_MAX_SWTICH_COUNT, 50);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_GET_PEER_INFO_THRESHOLD, 10);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_GET_PEER_INFO_INTERVAL_RATE, 3);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_GET_PEER_INFO_THRESHOLD, 3);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_GET_PEER_INFO_INTERVAL_RATE, 2);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_ONE_PEER_DOWNLOAD_SPEED, 500000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SUBSCRIBE_QUERY_INTERVAL, 500);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_UPLOAD_RATE, 100);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_PGC_PLAYER_CACHE_MS_INC, 0);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_SEGMENT_TIMEOUT_RATE, 90);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_SNDWND, 24);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_RCVWND, 24);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_LOW_RTT_THRESHOLD, 100);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_HIGH_RTT_THRESHOLD, 300);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_KCP_ACK_NODELAY, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_FLOW_CONTROL, 1);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_FAST_RESEND, 0);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_MIN_RTO, 100);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_MAX_THRESH, 36);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_MIN_THRESH, 12);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_INIT_CWND, 12);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_MIN_CWND, 6);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_FLUSH_INTERVAL, 10);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_DOWNLOAD_TIMEOUT_COUNT, 5);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_MD5_CHECK_ENABLE, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_UPOLOAD_INVALID_COUNT, 10);
        sP2POnlineConfig.putInt(KEY_EXT_MAX_CREATE_DYNAMIC_SOCKETS, 500);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SYM_NEAR_RANGE, 500);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_STREAM_MAX_CONNCTIONS_COUNT, 15);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_LIVE_USERS_WITHOUT_CDN_SUBSEGMENT, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LIVE_QUERY_EMPTY_THRESHOLD, 40);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_HTTP_CONNECT_TIMEOUT, 2000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_STUN_REFLEX_DETECT_INTERVAL, 60000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CLOSE_STUN_REFLEX_PORTS, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_RENDER_CDN_ASSIGN_TIME, 5000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CDN_ASSIGN_TIME, 15000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CONNECTING_SYM_COUNT, 10);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CONNECTING_PORTRST_COUNT, 10);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DISCARD_PEER, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTP_FALLBACK_MCDNHOST, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_ADJUST_CACHE_INDEX_A, 100);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_ADJUST_CACHE_INDEX_B, 5);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_CACHE_SWITCH_P2P, 60000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_GET_PEER_DELAY_MS, 2000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_MAX_BLOCK_COUNT, 3);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_COOLING_TIME, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SWITCH_CDN_INTERVAL, 3000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CRC_CHECK_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_PEER_ENCRYPT_LEVEL, 1);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_PRINT_CHECK_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_MAX_SUB_SEGMENT_COUNT, 30);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VOD_MIN_SUB_SEGMENT_COUNT, 5);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_NEW_DOWNLOAD_ENABLE, false);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_SIZE, 51200);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_DURATION, 300);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_REFACTOR_FIRST_FRAME_TIME_MS, 3000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTP_SERVER_ENABLE, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_PEER_UPLOAD_PRIORITY_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_PEER_UPLOAD_SPEED_RATIO, 200);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_TCP_DYNAMIC_MIN_CONNECT_TIMEOUT, IjkMediaCodecInfo.RANK_LAST_CHANCE);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_ONE_MINUTE_REBOOT_LIMITED, 3);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DISABLE_AFTER_CRASH, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_REFACTOR_RENDER_MS, 6000);
        sP2POnlineConfig.putString(KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL, "3000:100;5500:60;7000:40;9000:20;");
        sP2POnlineConfig.putString(KEY_EXT_P2P_STORY_STR_CDN_ASSIGN_INTERVAL, "2000:50;5000:20;");
        sP2POnlineConfig.putString(KEY_EXT_P2P_STR_PRELOAD_FIRST_FRAME_TIME_MS, "0:5000;1:4000;2:3000;3:2000;4:1000;5:0;6:0;7:0;");
        sP2POnlineConfig.putInt(KEY_EXT_P2P_REFACTOR_GET_PEER_DELAY_MS, IjkMediaCodecInfo.RANK_MAX);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_STORY_PRELOAD_LEVEL, 1);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_REFACTOR_RENDER_GAP_MS, 3000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_WEAK_NET_TASK_TIMEOUT_RATE, 100);
        sP2POnlineConfig.putString(KEY_EXT_P2P_STORY_GET_PEER_DELAY_MS, "0:0;1:500;2:1000;3:0;4:1000;5:1000;6:1000;7:1000;");
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CHECK_PLAYER_CACHE_MS, 2500);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_AUDIO_LIMIT_PEER_COUNT, 5);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_VIDEO_LIMIT_PEER_COUNT, 7);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_HTTP_SERVER_THREAD_COUNT, 8);
        sP2POnlineConfig.putString(KEY_EXT_P2P_UDP_LOSS_RATE_PARAMS, "1:1000;2:1000;3:1000;4:1000;");
        sP2POnlineConfig.putString(KEY_EXT_P2P_UDP_RTT_PARAMS, "1:82;2:99;3:141;4:400;");
        sP2POnlineConfig.putInt(KEY_EXT_P2P_UDP_LOSS_RATE_SD_PERMILLAGE_CONFIG, IjkMediaCodecInfo.RANK_MAX);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_UDP_RTT_SD_CONFIG, 30);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_ENCRYPT_MAGIC_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_ENCRYPT_MAGIC_LEVEL, 2);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_STREAM_TIMEOUT_BITRATE_CONFIG, 600000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_ONLY_PCDN_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_IMPROVE_DOWNLOAD_SPEED_ENABLE, true);
        sP2POnlineConfig.putString(KEY_EXT_P2P_MAX_SUBSEGMENT_COUNT_INTERVAL, "0:20;20:25;50:30;100:40;");
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CHECK_SPEED_CONFIG, 500);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CHECK_P2PSTATUS_CONFIG, 500);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_KCP_UPDATE_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_CWND_ADJUST_THRESHOLD, 64);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_A, 200);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_B, 140);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTPDNS_BILI_IP_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_HTTPDNS_BILI_IP_RETRY_TIMES, 2);
        sP2POnlineConfig.putString(KEY_EXT_P2P_HTTPDNS_BILI_IP, "47.101.175.206;47.100.123.169;120.46.169.234;121.36.72.124;");
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_FEC_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_FEC_CTYPE, 0);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_FEC_LOWER_BOUND, 2);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_FEC_UPPER_BOUND, 11);
        sP2POnlineConfig.putString(KEY_EXT_P2P_ZONE_BLACK_LIST, "");
        sP2POnlineConfig.putString(KEY_EXT_P2P_BILIDNS_CMCC_IP, "116.63.10.135;122.9.7.134;117.185.228.108;117.144.238.29");
        sP2POnlineConfig.putString(KEY_EXT_P2P_BILIDNS_CT_IP, "122.9.13.79;122.9.15.129;101.91.140.224;101.91.140.124");
        sP2POnlineConfig.putString(KEY_EXT_P2P_BILIDNS_CU_IP, "114.116.215.110;116.63.10.31;112.64.218.119;112.65.200.117");
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTP3_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_IPV6_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_RELEASE_PEER_RTT_THRESHOLD, 200);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CHECK_UDP_DOWNLOAD_SPEED, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SEGMENT_ASSIGN_TIME_MS, 5000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_TCP_DYNAMIC_BITRATE_BUFFER_RATE, 5);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_IPV4_DELAY_CONNECT_TIME, 0);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_MULTI_CDN_DOWNLOAD_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MULTI_CDN_CONN_COUNT, 1);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_KCP_SESSION_PRIORITY_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_BILI_DNS_TIME_OUT, 2000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_NETWORK_LEVEL_FACTOR_ENABLE, true);
        sP2POnlineConfig.putString(KEY_EXT_P2P_NETWORK_LEVEL_FACTOR, "0:100;1:125;2:100;3:100;4:75;5:60");
        sP2POnlineConfig.putInt(KEY_EXT_P2P_BITRATE_INC_COEFFICIENT, 5);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_BITRATE_FACTOR_LOWERBOUND, 10);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_MULTI_CDN_COUNT_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_NETWORK_RTT_CHURNS_THRESHOLD, 200);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTP_READ_TIMEOUT_RETRY_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CHECK_CDN_DOWNLOAD_SPEED, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_OPEN_MULTI_CDN_BIT_THRESHOLD, 2400000);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_STORY_OPEN_MULTI_CDN_BIT_THRESHOLD, 1200000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DNS_DYNAMIC_TIMEOUT_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_LOW_SPEED_ERROR_INTERVAL, 30000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CHECK_RECIVE_HEADER_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_RELEASE_PEER_MUST_CHECK_RTT_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_READ_DRIVE_BEFORE_GET_PEERS_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_ADJUST_CDN_WEIGHT_BY_P2P_TASK_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_COUNT, 2);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_SUPER_NODE_SPEED_MEASURE_TIME_GAP_MS, 2000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_SET_MAX_READ_DRIVE_TIME_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_MAX_READ_DRIVE_TIME_MS, 3000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_BITRATE_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CDN_INTERVAL_BITRATE_RATIO, 1);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_PCDN_DOWNLOAD_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_NET_LEVEL_ENABLE, true);
        sP2POnlineConfig.putString(KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL_NET_LEVEL_RATIO, "0:0;1:0;2:5;3:10;4:20;5:25;");
        sP2POnlineConfig.putString(KEY_EXT_P2P_MCDN_MATCH_STR, "os=mcdn");
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_MCDN_ONLY_COMPETE_WITH_MCDN, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_DIFF_CDN_TYPE_COMPETE_ENABLE, false);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_TIME_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_MIN_TIME_MS, 5000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_TIMEOUT_INCREASE_TO_MAX_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_SUBSCRIBE_SUCC_RATE_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_UPDATE_URL_CDN_COMPETE_ENABLE, true);
        sP2POnlineConfig.putInt(KEY_EXT_P2P_CDN_LOW_SPEED_RATIO, 100);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_PRE_SEEK_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CDN_NET_QUALITY_ENABLE, true);
        sP2POnlineConfig.putInt(K_P2P_CDN_NET_MAX_NODES, 4);
        sP2POnlineConfig.putInt(K_P2P_CDN_NET_DETECT_INTERVAL_MS, 5000);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_CDN_CONNECTION_MONITOR_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_LOCAL_CONNECT_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_MCDN_IPV6_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_PERFORMANCE_OPTIMIZATION_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_COMPETE_LOGIC_OPT_ENABLE, true);
        sP2POnlineConfig.putBoolean(KEY_EXT_P2P_HTTPDNS_BILI_FIRST_ENABLE, true);
        sP2POnlineConfig.putString(KEY_EXT_P2P_HTTPDNS_GOOGLE_SERVER_IPS, "8.8.4.4,8.8.8.8,2001:4860:4860::8888,2001:4860:4860::8844");
    }

    public static P2P getInstance(Context context, Bundle config) {
        P2P p2p;
        synchronized (P2P.class) {
            if (sP2P == null) {
                P2P p2p2 = new P2P(context, config);
                if (p2p2.mEnable) {
                    sP2P = p2p2;
                }
            }
            p2p = sP2P;
        }
        return p2p;
    }

    public static P2P getInstance() {
        P2P p2p;
        synchronized (P2P.class) {
            p2p = sP2P;
        }
        return p2p;
    }

    private P2P(Context context, Bundle config) {
        if (context == null) {
            BLog.w(TAG, "P2P construct failed, context null !!");
        } else if (TextUtils.isEmpty(config.getString(KEY_EXT_P2P_BUVID, ""))) {
            BLog.w(TAG, "buvid empty!!!");
        } else {
            this.mConfigKeyExcepts = new ArrayList<>();
            this.mConfigKeyExcepts.add(K_PEER_NETWORK_TYPE);
            this.mConfigKeyExcepts.add(K_P2P_MAX_CACHE_SIZE);
            this.mAppContex = context.getApplicationContext();
            this.mConfigs = parseConfig(this.mAppContex, config);
            if (this.mConfigs != null) {
                resolveP2PServerUrls(config);
                this.mApplyConfigs = this.mConfigs;
                this.mEnable = true;
                IjkNetworkManager.getInstance(this.mAppContex).registerListener(this);
                if (!config.getBoolean(KEY_EXT_P2P_CACHE_TO_DISK, false)) {
                    scanPath(getCacheDirector(this.mAppContex, IJK_P2P_CACHE_DIR));
                    return;
                }
                return;
            }
            scanPath(getCacheDirector(this.mAppContex, IJK_P2P_CACHE_DIR));
        }
    }

    private void resolveP2PServerUrls(final Bundle config) {
        final boolean useReleaseTracker = this.mConfigs.getBoolean(KEY_EXT_P2P_USE_RELEASE_TRACKER, true);
        final String p2pServerUrl = this.mConfigs.getString(KEY_EXT_P2P_SERVER_URL);
        final SharedPreferences sharedPreferences = this.mAppContex.getSharedPreferences("centaurs", 0);
        final String proxyDataPath = getProxyDataPath(this.mAppContex, P2P_PROXY_JSON);
        readSharedPreferences(config, sharedPreferences);
        this.mP2PServerResolver = new P2PServerResolver(p2pServerUrl, DEVICE_TYPE.DEVICE_ANDROID, 3, useReleaseTracker, proxyDataPath);
        AsyncTask.execute(new Runnable() { // from class: tv.danmaku.ijk.media.player.P2P.1
            @Override // java.lang.Runnable
            public void run() {
                List<String> stunServers = null;
                List<String> ipv6StunServers = null;
                List<String> trackerServers = null;
                List<String> liveTrackerServers = null;
                P2PServerResolver p2pServerResolver = new P2PServerResolver(p2pServerUrl, DEVICE_TYPE.DEVICE_ANDROID, 3, useReleaseTracker, proxyDataPath);
                if (p2pServerResolver.resolve()) {
                    stunServers = p2pServerResolver.getStunServers();
                    ipv6StunServers = p2pServerResolver.getIpv6StunServers();
                    trackerServers = p2pServerResolver.getTrackerServers();
                    liveTrackerServers = p2pServerResolver.getLiveTrackerServers();
                }
                if (P2P.this.isServerEffective(stunServers, P2P.defaultStunServers) && P2P.this.isServerEffective(trackerServers, P2P.defaultTrackerServers) && P2P.this.isServerEffective(ipv6StunServers, P2P.defaultIpv6StunServers)) {
                    p2pServerResolver.writeProxyDataToFile();
                } else {
                    String proxyData = p2pServerResolver.readProxyDataFromFile();
                    if (!proxyData.isEmpty()) {
                        p2pServerResolver.parseHttpResp(proxyData);
                        if (!P2P.this.isServerEffective(stunServers, P2P.defaultStunServers)) {
                            BLog.i(P2P.TAG, "stunServers is invalid, get proxy date from Local file");
                            stunServers = p2pServerResolver.getStunServers();
                        }
                        if (!P2P.this.isServerEffective(ipv6StunServers, P2P.defaultIpv6StunServers)) {
                            BLog.i(P2P.TAG, "ipv6StunServers is invalid, get proxy date from Local file");
                            ipv6StunServers = p2pServerResolver.getIpv6StunServers();
                        }
                        if (!P2P.this.isServerEffective(trackerServers, P2P.defaultTrackerServers)) {
                            BLog.i(P2P.TAG, "trackerServers is invalid, get proxy date from Local file");
                            trackerServers = p2pServerResolver.getTrackerServers();
                        }
                        if (liveTrackerServers == null || liveTrackerServers.size() < 1 || TextUtils.isEmpty(liveTrackerServers.get(0))) {
                            BLog.i(P2P.TAG, "liveTrackerServers is invalid, get proxy date from Local file");
                            liveTrackerServers = p2pServerResolver.getLiveTrackerServers();
                        }
                    }
                }
                if (!P2P.this.isServerEffective(stunServers, P2P.defaultStunServers)) {
                    stunServers = P2P.defaultStunServers;
                }
                if (!P2P.this.isServerEffective(ipv6StunServers, P2P.defaultIpv6StunServers)) {
                    ipv6StunServers = P2P.defaultIpv6StunServers;
                }
                if (!P2P.this.isServerEffective(trackerServers, P2P.defaultTrackerServers)) {
                    trackerServers = P2P.defaultTrackerServers;
                }
                String liveTrackerServer = "";
                if (liveTrackerServers != null && liveTrackerServers.size() > 0 && !TextUtils.isEmpty(liveTrackerServers.get(0))) {
                    liveTrackerServer = liveTrackerServers.get(0);
                }
                P2P.this.initGrpcAndStunServerConfig(config, sharedPreferences, P2P.sP2PDeviceId, stunServers.get(0), stunServers.get(1), stunServers.get(2), stunServers.get(3), stunServers.get(4), stunServers.get(5), stunServers.get(6), stunServers.get(7), ipv6StunServers.get(0), ipv6StunServers.get(1), trackerServers.get(0), liveTrackerServer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerEffective(List<String> servers, List<String> defaultServers) {
        if (servers == null || servers.size() < defaultServers.size()) {
            return false;
        }
        for (int i = 0; i < defaultServers.size(); i++) {
            if (TextUtils.isEmpty(servers.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void readSharedPreferences(Bundle config, SharedPreferences sp) {
        String deviceId = sp.getString(KEY_SP_P2P_DEVICE_ID, "");
        String stun1 = sp.getString(KEY_SP_P2P_STUN_SERVER1, "");
        String stun2 = sp.getString(KEY_SP_P2P_STUN_SERVER2, "");
        String stun3 = sp.getString(KEY_SP_P2P_STUN_SERVER3, "");
        String stun4 = sp.getString(KEY_SP_P2P_STUN_SERVER4, "");
        String stun5 = sp.getString(KEY_SP_P2P_STUN_SERVER5, "");
        String stun6 = sp.getString(KEY_SP_P2P_STUN_SERVER6, "");
        String stun7 = sp.getString(KEY_SP_P2P_STUN_SERVER7, "");
        String stun8 = sp.getString(KEY_SP_P2P_STUN_SERVER8, "");
        String ipv6Stun1 = sp.getString(KEY_SP_P2P_IPV6_STUN_SERVER1, "");
        String ipv6Stun2 = sp.getString(KEY_SP_P2P_IPV6_STUN_SERVER2, "");
        initGrpcAndStunServerConfig(config, sp, deviceId, stun1, stun2, stun3, stun4, stun5, stun6, stun7, stun8, ipv6Stun1, ipv6Stun2, "", "");
    }

    private void saveSharedPreferences(SharedPreferences sp, String deviceId, String stun1, String stun2, String stun3, String stun4, String stun5, String stun6, String stun7, String stun8, String ipv6Stun1, String ipv6Stun2) {
        if (!TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(stun1) && !TextUtils.isEmpty(stun2) && !TextUtils.isEmpty(stun3)) {
            if (!TextUtils.isEmpty(stun4) && !TextUtils.isEmpty(stun5) && !TextUtils.isEmpty(stun6) && !TextUtils.isEmpty(stun7)) {
                if (TextUtils.isEmpty(stun8) || TextUtils.isEmpty(ipv6Stun1)) {
                    return;
                }
                if (!TextUtils.isEmpty(ipv6Stun2)) {
                    String savedDeviceId = sp.getString(KEY_SP_P2P_DEVICE_ID, "");
                    String savedStun1 = sp.getString(KEY_SP_P2P_STUN_SERVER1, "");
                    String savedStun2 = sp.getString(KEY_SP_P2P_STUN_SERVER2, "");
                    String savedStun3 = sp.getString(KEY_SP_P2P_STUN_SERVER3, "");
                    String savedStun4 = sp.getString(KEY_SP_P2P_STUN_SERVER4, "");
                    String savedStun5 = sp.getString(KEY_SP_P2P_STUN_SERVER5, "");
                    String savedStun6 = sp.getString(KEY_SP_P2P_STUN_SERVER6, "");
                    String savedStun7 = sp.getString(KEY_SP_P2P_STUN_SERVER7, "");
                    String savedStun8 = sp.getString(KEY_SP_P2P_STUN_SERVER8, "");
                    String savedIpv6Stun1 = sp.getString(KEY_SP_P2P_IPV6_STUN_SERVER1, "");
                    String savedIpv6Stun2 = sp.getString(KEY_SP_P2P_IPV6_STUN_SERVER2, "");
                    if (!savedDeviceId.equalsIgnoreCase(deviceId)) {
                        sp.edit().putString(KEY_SP_P2P_DEVICE_ID, deviceId).apply();
                    }
                    if (!savedStun1.equalsIgnoreCase(stun1)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER1, stun1).apply();
                    }
                    if (!savedStun2.equalsIgnoreCase(stun2)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER2, stun2).apply();
                    }
                    if (!savedStun3.equalsIgnoreCase(stun3)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER3, stun3).apply();
                    }
                    if (!savedStun4.equalsIgnoreCase(stun4)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER4, stun4).apply();
                    }
                    if (!savedStun5.equalsIgnoreCase(stun5)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER5, stun5).apply();
                    }
                    if (!savedStun6.equalsIgnoreCase(stun6)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER6, stun6).apply();
                    }
                    if (!savedStun7.equalsIgnoreCase(stun7)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER7, stun7).apply();
                    }
                    if (!savedStun8.equalsIgnoreCase(stun8)) {
                        sp.edit().putString(KEY_SP_P2P_STUN_SERVER8, stun8).apply();
                    }
                    if (!savedIpv6Stun1.equalsIgnoreCase(ipv6Stun1)) {
                        sp.edit().putString(KEY_SP_P2P_IPV6_STUN_SERVER1, ipv6Stun1).apply();
                    }
                    if (!savedIpv6Stun2.equalsIgnoreCase(ipv6Stun2)) {
                        sp.edit().putString(KEY_SP_P2P_IPV6_STUN_SERVER2, ipv6Stun2).apply();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGrpcAndStunServerConfig(Bundle config, SharedPreferences sp, String deviceId, String stun1, String stun2, String stun3, String stun4, String stun5, String stun6, String stun7, String stun8, String ipv6Stun1, String ipv6Stun2, String tracker, String liveTracker) {
        if (!TextUtils.isEmpty(stun1) && !TextUtils.isEmpty(stun2)) {
            if (!TextUtils.isEmpty(stun3) && !TextUtils.isEmpty(stun4) && !TextUtils.isEmpty(stun5)) {
                if (!TextUtils.isEmpty(stun6) && !TextUtils.isEmpty(stun7) && !TextUtils.isEmpty(stun8)) {
                    if (!TextUtils.isEmpty(ipv6Stun1) && !TextUtils.isEmpty(ipv6Stun2)) {
                        try {
                            GrpcClient.getInstance(this.mAppContex).init(tracker, liveTracker);
                            synchronized (P2P.class) {
                                try {
                                    try {
                                        sP2PDeviceId = deviceId;
                                        String buvid = config.getString(KEY_EXT_P2P_BUVID, "");
                                        if (TextUtils.isEmpty(sP2PDeviceId) || !sP2PDeviceId.startsWith(buvid)) {
                                            Random random = new Random();
                                            sP2PDeviceId = buvid + ":" + random.nextInt();
                                        }
                                        this.mConfigs.putString(K_PEER_DEVICE_ID, sP2PDeviceId);
                                        this.mConfigs.putString(K_STUN_SERVER1, stun1);
                                        this.mConfigs.putString(K_STUN_SERVER2, stun2);
                                        this.mConfigs.putString(K_STUN_SERVER3, stun3);
                                        this.mConfigs.putString(K_STUN_SERVER4, stun4);
                                        this.mConfigs.putString(K_STUN_SERVER5, stun5);
                                        this.mConfigs.putString(K_STUN_SERVER6, stun6);
                                        this.mConfigs.putString(K_STUN_SERVER7, stun7);
                                        this.mConfigs.putString(K_STUN_SERVER8, stun8);
                                        this.mConfigs.putString(K_IPV6_STUN_SERVER1, ipv6Stun1);
                                        this.mConfigs.putString(K_IPV6_STUN_SERVER2, ipv6Stun2);
                                        saveSharedPreferences(sp, sP2PDeviceId, stun1, stun2, stun3, stun4, stun5, stun6, stun7, stun8, ipv6Stun1, ipv6Stun2);
                                        this.mGrpcClientInited = true;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } catch (Throwable th3) {
                            BLog.w(TAG, th3);
                        }
                    }
                }
            }
        }
    }

    private static Bundle parseConfig(Context context, Bundle config) {
        if (config.getBoolean(KEY_EXT_P2P_DISABLE_BLACKLIST, false)) {
            return null;
        }
        Bundle parsedConfig = new Bundle();
        boolean liveEnable = false;
        if (config.getBoolean(KEY_EXT_P2P_LIVE_DOWNLOAD_UPLOAD, false)) {
            parsedConfig.putInt(K_PEER_P2P_LIVE_STRATEGY, P2P_STRATEGY.STRATEGY_UPLOAD_DOWNLOAD.ordinal());
            liveEnable = true;
        }
        if (!config.getBoolean(KEY_EXT_P2P_HOTPUSH, false)) {
            if (config.getBoolean(KEY_EXT_P2P_DOWNLOAD, false) && config.getBoolean(KEY_EXT_P2P_UPLOAD, false)) {
                parsedConfig.putInt(K_PEER_P2P_STRATEGY, P2P_STRATEGY.STRATEGY_UPLOAD_DOWNLOAD.ordinal());
            } else if (config.getBoolean(KEY_EXT_P2P_DOWNLOAD, false)) {
                parsedConfig.putInt(K_PEER_P2P_STRATEGY, P2P_STRATEGY.STRATEGY_DOWNLOAD_NO_UPLOAD.ordinal());
            } else if (config.getBoolean(KEY_EXT_P2P_UPLOAD, false)) {
                parsedConfig.putInt(K_PEER_P2P_STRATEGY, P2P_STRATEGY.STRATEGY_UPLOAD_NO_DOWNLOAD.ordinal());
            } else if (!liveEnable) {
                return null;
            }
        } else {
            parsedConfig.putInt(K_PEER_P2P_STRATEGY, P2P_STRATEGY.STRATEGY_HOT_PUSH.ordinal());
        }
        if (config.getBoolean(KEY_EXT_P2P_LIVE_DOWNLOAD_UPLOAD, false)) {
            parsedConfig.putInt(K_P2P_LIVE_UPLOAD, 1);
        }
        if (config.getBoolean(KEY_EXT_P2P_UPLOAD, false) || config.getBoolean(KEY_EXT_P2P_HOTPUSH, false)) {
            parsedConfig.putInt(K_P2P_VOD_UPLOAD, 1);
        }
        parsedConfig.putBoolean(KEY_EXT_P2P_USE_RELEASE_TRACKER, config.getBoolean(KEY_EXT_P2P_USE_RELEASE_TRACKER, true));
        parsedConfig.putInt(K_P2P_ENABLE_INDEPENDENT_LIVE_VOD_TRACKER, config.getBoolean(KEY_EXT_P2P_ENABLE_INDEPENDENT_LIVE_VOD_TRACKER, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CACHE_TO_DISK, config.getBoolean(KEY_EXT_P2P_CACHE_TO_DISK, false) ? 1 : 0);
        parsedConfig.putInt(K_P2P_LIVE_SWITCH_CDN_MS, config.getInt(KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_CDN, 1500));
        parsedConfig.putInt(K_P2P_LIVE_SWITCH_P2P_MS, config.getInt(KEY_EXT_P2P_LIVE_PLAYER_CACHE_MS_SWITCH_P2P, 3000));
        parsedConfig.putInt(K_P2P_TRACKER_HEARTBEAT_INTERVAL, config.getInt(KEY_EXT_P2P_TRACKER_HEARTBEAT_INTERVAL_MS, 45000));
        parsedConfig.putLong(K_P2P_MAX_UPLOAD_SPEED, config.getLong(KEY_EXT_P2P_MAX_UPLOAD_SPEED, 50000000L));
        parsedConfig.putInt(K_P2P_VOD_SWITCH_P2P_MS, config.getInt(KEY_EXT_P2P_VOD_PLAYER_CACHE_MS_SWITCH_P2P, 7000));
        parsedConfig.putInt(K_P2P_DOWNLOAD_TIMEOUT_RATE, config.getInt(KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_RATE, 900));
        parsedConfig.putInt(K_P2P_LIVE_DOWNLOAD_TIMEOUT_COUNT, config.getInt(KEY_EXT_P2P_LIVE_DOWNLOAD_TIMEOUT_COUNT, 10));
        parsedConfig.putInt(K_P2P_MAX_CONNECTION_COUNT, config.getInt(KEY_EXT_P2P_MAX_CONNECTION_COUNT, 70));
        parsedConfig.putInt(K_P2P_MAX_UPLOAD_COUNT, config.getInt(KEY_EXT_P2P_MAX_UPLOAD_COUNT, 20));
        parsedConfig.putInt(K_P2P_MAX_CONNECTING_COUNT, config.getInt(KEY_EXT_P2P_MAX_CONNECTING_COUNT, 24));
        parsedConfig.putInt(K_P2P_UPLOAD_LIMIT, config.getInt(KEY_EXT_P2P_UPLOAD_LIMIT, 12));
        parsedConfig.putInt(K_P2P_VOD_READ_TIMEOUT_MS, config.getInt(KEY_EXT_P2P_VOD_READ_TIMEOUT_MS, 3000));
        parsedConfig.putInt(K_P2P_LIVE_READ_TIMEOUT_MS, config.getInt(KEY_EXT_P2P_LIVE_READ_TIMEOUT_MS, PersonInfoLoadFragment.ERROR_CODE_MODIFY_FORBIDDEN));
        parsedConfig.putInt(K_P2P_VOD_MAX_SWTICH_COUNT, config.getInt(KEY_EXT_P2P_VOD_MAX_SWTICH_COUNT, 2));
        parsedConfig.putInt(K_P2P_LIVE_MAX_SWTICH_COUNT, config.getInt(KEY_EXT_P2P_LIVE_MAX_SWTICH_COUNT, 50));
        parsedConfig.putInt(K_P2P_LIVE_GET_PEER_INFO_THRESHOLD, config.getInt(KEY_EXT_P2P_LIVE_GET_PEER_INFO_THRESHOLD, 10));
        parsedConfig.putInt(K_P2P_LIVE_GET_PEER_INFO_INTERVAL_RATE, config.getInt(KEY_EXT_P2P_LIVE_GET_PEER_INFO_INTERVAL_RATE, 3));
        parsedConfig.putInt(K_P2P_VOD_GET_PEER_INFO_THRESHOLD, config.getInt(KEY_EXT_P2P_VOD_GET_PEER_INFO_THRESHOLD, 3));
        parsedConfig.putInt(K_P2P_VOD_GET_PEER_INFO_INTERVAL_RATE, config.getInt(KEY_EXT_P2P_VOD_GET_PEER_INFO_INTERVAL_RATE, 2));
        parsedConfig.putInt(K_P2P_ONE_PEER_DOWNLOAD_SPEED, config.getInt(KEY_EXT_P2P_ONE_PEER_DOWNLOAD_SPEED, 500000));
        parsedConfig.putInt(K_P2P_SUBSCRIBE_QUERY_INTERVAL, config.getInt(KEY_EXT_P2P_SUBSCRIBE_QUERY_INTERVAL, 400));
        parsedConfig.putInt(K_P2P_UPLOAD_RATE, config.getInt(KEY_EXT_P2P_UPLOAD_RATE, 100));
        parsedConfig.putInt(K_P2P_VOD_PGC_PLAYER_CACHE_MS_INC, config.getInt(KEY_EXT_P2P_VOD_PGC_PLAYER_CACHE_MS_INC, 0));
        parsedConfig.putInt(K_P2P_LIVE_SEGMENT_TIMEOUT_RATE, config.getInt(KEY_EXT_P2P_LIVE_SEGMENT_TIMEOUT_RATE, 90));
        parsedConfig.putInt(K_P2P_KCP_SNDWND, config.getInt(KEY_EXT_P2P_KCP_SNDWND, 24));
        parsedConfig.putInt(K_P2P_KCP_RCVWND, config.getInt(KEY_EXT_P2P_KCP_RCVWND, 24));
        parsedConfig.putInt(K_P2P_KCP_LOW_RTT_THRESHOLD, config.getInt(KEY_EXT_P2P_KCP_LOW_RTT_THRESHOLD, 100));
        parsedConfig.putInt(K_P2P_KCP_HIGH_RTT_THRESHOLD, config.getInt(KEY_EXT_P2P_KCP_HIGH_RTT_THRESHOLD, 300));
        parsedConfig.putInt(K_P2P_KCP_ACK_NODELAY, config.getBoolean(KEY_EXT_P2P_KCP_ACK_NODELAY, false) ? 1 : 0);
        parsedConfig.putInt(K_P2P_KCP_FLOW_CONTROL, config.getInt(KEY_EXT_P2P_KCP_FLOW_CONTROL, 1));
        parsedConfig.putInt(K_P2P_KCP_FAST_RESEND, config.getInt(KEY_EXT_P2P_KCP_FAST_RESEND, 0));
        parsedConfig.putInt(K_P2P_KCP_MIN_RTO, config.getInt(KEY_EXT_P2P_KCP_MIN_RTO, 100));
        parsedConfig.putInt(K_P2P_KCP_MAX_THRESH, config.getInt(KEY_EXT_P2P_KCP_MAX_THRESH, 36));
        parsedConfig.putInt(K_P2P_KCP_MIN_THRESH, config.getInt(KEY_EXT_P2P_KCP_MIN_THRESH, 12));
        parsedConfig.putInt(K_P2P_KCP_INIT_CWND, config.getInt(KEY_EXT_P2P_KCP_INIT_CWND, 12));
        parsedConfig.putInt(K_P2P_KCP_MIN_CWND, config.getInt(KEY_EXT_P2P_KCP_MIN_CWND, 6));
        parsedConfig.putInt(K_P2P_KCP_FLUSH_INTERVAL, config.getInt(KEY_EXT_P2P_KCP_FLUSH_INTERVAL, 10));
        parsedConfig.putInt(K_P2P_VOD_DOWNLOAD_TIMEOUT_COUNT, config.getInt(KEY_EXT_P2P_VOD_DOWNLOAD_TIMEOUT_COUNT, 5));
        parsedConfig.putInt(K_P2P_MD5_CHECK_ENABLE, config.getBoolean(KEY_EXT_P2P_MD5_CHECK_ENABLE, false) ? 1 : 0);
        parsedConfig.putInt(K_P2P_UPOLOAD_INVALID_COUNT, config.getInt(KEY_EXT_P2P_UPOLOAD_INVALID_COUNT, 10));
        parsedConfig.putInt(K_MAX_CREATE_DYNAMIC_SOCKETS, config.getInt(KEY_EXT_MAX_CREATE_DYNAMIC_SOCKETS, 500));
        parsedConfig.putInt(K_P2P_SYM_NEAR_RANGE, config.getInt(KEY_EXT_P2P_SYM_NEAR_RANGE, 500));
        parsedConfig.putInt(K_P2P_LIVE_STREAM_MAX_CONNCTIONS_COUNT, config.getInt(KEY_EXT_P2P_LIVE_STREAM_MAX_CONNCTIONS_COUNT, 30));
        parsedConfig.putInt(K_P2P_LIVE_USERS_WITHOUT_CDN_SUBSEGMENT, config.getBoolean(KEY_EXT_P2P_LIVE_USERS_WITHOUT_CDN_SUBSEGMENT, false) ? 1 : 0);
        parsedConfig.putInt(K_P2P_LIVE_QUERY_EMPTY_THRESHOLD, config.getInt(KEY_EXT_P2P_LIVE_QUERY_EMPTY_THRESHOLD, 40));
        parsedConfig.putInt(K_P2P_HTTP_CONNECT_TIMEOUT, config.getInt(KEY_EXT_P2P_HTTP_CONNECT_TIMEOUT, 2000));
        parsedConfig.putInt(K_P2P_STUN_REFLEX_DETECT_INTERVAL, config.getInt(KEY_EXT_P2P_STUN_REFLEX_DETECT_INTERVAL, 120000));
        parsedConfig.putInt(K_P2P_CLOSE_STUN_REFLEX_PORTS, config.getBoolean(KEY_EXT_P2P_CLOSE_STUN_REFLEX_PORTS, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_RENDER_CDN_ASSIGN_TIME, config.getInt(KEY_EXT_P2P_RENDER_CDN_ASSIGN_TIME, 5000));
        parsedConfig.putInt(K_P2P_MAX_CDN_ASSIGN_TIME, config.getInt(KEY_EXT_P2P_MAX_CDN_ASSIGN_TIME, 15000));
        parsedConfig.putInt(K_P2P_MAX_CONNECTING_SYM_COUNT, config.getInt(KEY_EXT_P2P_MAX_CONNECTING_SYM_COUNT, 10));
        parsedConfig.putInt(K_P2P_MAX_CONNECTING_PORTRST_COUNT, config.getInt(KEY_EXT_P2P_MAX_CONNECTING_PORTRST_COUNT, 10));
        parsedConfig.putInt(K_P2P_DISCARD_PEER, config.getBoolean(KEY_EXT_P2P_DISCARD_PEER, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_HTTP_FALLBACK_MCDNHOST, config.getBoolean(KEY_EXT_P2P_HTTP_FALLBACK_MCDNHOST, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_ADJUST_CACHE_INDEX_A, config.getInt(KEY_EXT_P2P_ADJUST_CACHE_INDEX_A, 100));
        parsedConfig.putInt(K_P2P_ADJUST_CACHE_INDEX_B, config.getInt(KEY_EXT_P2P_ADJUST_CACHE_INDEX_B, 5));
        parsedConfig.putInt(K_P2P_MAX_CACHE_SWITCH_P2P, config.getInt(KEY_EXT_P2P_MAX_CACHE_SWITCH_P2P, 60000));
        parsedConfig.putInt(K_P2P_GET_PEER_DELAY_MS, config.getInt(KEY_EXT_P2P_GET_PEER_DELAY_MS, 2000));
        parsedConfig.putInt(K_P2P_VOD_MAX_BLOCK_COUNT, config.getInt(KEY_EXT_P2P_VOD_MAX_BLOCK_COUNT, 3));
        parsedConfig.putInt(K_P2P_COOLING_TIME, config.getInt(KEY_EXT_P2P_COOLING_TIME, 3000));
        parsedConfig.putInt(K_P2P_SWITCH_CDN_INTERVAL, config.getInt(KEY_EXT_P2P_SWITCH_CDN_INTERVAL, 3000));
        parsedConfig.putInt(K_P2P_CRC_CHECK_ENABLE, config.getBoolean(KEY_EXT_P2P_CRC_CHECK_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_PEER_ENCRYPT_LEVEL, config.getInt(KEY_EXT_P2P_PEER_ENCRYPT_LEVEL, 1));
        parsedConfig.putInt(K_P2P_PRINT_CHECK_ENABLE, config.getBoolean(KEY_EXT_P2P_PRINT_CHECK_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_VOD_MAX_SUB_SEGMENT_COUNT, config.getInt(KEY_EXT_P2P_VOD_MAX_SUB_SEGMENT_COUNT, 30));
        parsedConfig.putInt(K_P2P_VOD_MIN_SUB_SEGMENT_COUNT, config.getInt(KEY_EXT_P2P_VOD_MIN_SUB_SEGMENT_COUNT, 5));
        parsedConfig.putInt(K_P2P_NEW_DOWNLOAD_ENABLE, config.getBoolean(KEY_EXT_P2P_NEW_DOWNLOAD_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_SPEED_MODE_MIN_SUBSEGMENT_SIZE, config.getInt(KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_SIZE, 51200));
        parsedConfig.putInt(K_P2P_SPEED_MODE_MIN_SUBSEGMENT_DURATION, config.getInt(KEY_EXT_P2P_SPEED_MODE_MIN_SUBSEGMENT_DURATION, 300));
        parsedConfig.putInt(K_P2P_REFACTOR_FIRST_FRAME_TIME_MS, config.getInt(KEY_EXT_P2P_REFACTOR_FIRST_FRAME_TIME_MS, 3000));
        parsedConfig.putInt(K_P2P_HTTP_SERVER_ENABLE, config.getBoolean(KEY_EXT_P2P_HTTP_SERVER_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_PEER_UPLOAD_PRIORITY_ENABLE, config.getBoolean(KEY_EXT_P2P_PEER_UPLOAD_PRIORITY_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_PEER_UPLOAD_SPEED_RATIO, config.getInt(KEY_EXT_P2P_PEER_UPLOAD_SPEED_RATIO, 200));
        parsedConfig.putInt(K_P2P_TCP_DYNAMIC_MIN_CONNECT_TIMEOUT, config.getInt(KEY_EXT_P2P_TCP_DYNAMIC_MIN_CONNECT_TIMEOUT, IjkMediaCodecInfo.RANK_LAST_CHANCE));
        parsedConfig.putInt(K_P2P_ONE_MINUTE_REBOOT_LIMITED, config.getInt(KEY_EXT_P2P_ONE_MINUTE_REBOOT_LIMITED, 3));
        parsedConfig.putInt(K_P2P_DISABLE_AFTER_CRASH, config.getBoolean(KEY_EXT_P2P_DISABLE_AFTER_CRASH, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_REFACTOR_RENDER_MS, config.getInt(KEY_EXT_P2P_REFACTOR_RENDER_MS, 2000));
        parsedConfig.putString(K_P2P_STR_CDN_ASSIGN_INTERVAL, config.getString(KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL, "2000:100;6000:10;"));
        parsedConfig.putString(K_P2P_STORY_STR_CDN_ASSIGN_INTERVAL, config.getString(KEY_EXT_P2P_STORY_STR_CDN_ASSIGN_INTERVAL, "2000:50;5000:20;"));
        parsedConfig.putString(K_P2P_STR_PRELOAD_FIRST_FRAME_TIME_MS, config.getString(KEY_EXT_P2P_STR_PRELOAD_FIRST_FRAME_TIME_MS, "0:5000;1:4000;2:3000;3:2000;4:1000;5:0;6:0;7:0;"));
        parsedConfig.putInt(K_P2P_REFACTOR_GET_PEER_DELAY_MS, config.getInt(KEY_EXT_P2P_REFACTOR_GET_PEER_DELAY_MS, 0));
        parsedConfig.putInt(K_P2P_STORY_PRELOAD_LEVEL, config.getInt(KEY_EXT_P2P_STORY_PRELOAD_LEVEL, 1));
        parsedConfig.putInt(K_P2P_REFACTOR_RENDER_GAP_MS, config.getInt(KEY_EXT_P2P_REFACTOR_RENDER_GAP_MS, 3000));
        parsedConfig.putInt(K_P2P_WEAK_NET_TASK_TIMEOUT_RATE, config.getInt(KEY_EXT_P2P_WEAK_NET_TASK_TIMEOUT_RATE, 100));
        parsedConfig.putString(K_P2P_STORY_GET_PEER_DELAY_MS, config.getString(KEY_EXT_P2P_STORY_GET_PEER_DELAY_MS, "0:0;1:500;2:1000;3:0;4:1000;5:1000;6:1000;7:1000;"));
        parsedConfig.putInt(K_P2P_CHECK_PLAYER_CACHE_MS, config.getInt(KEY_EXT_P2P_CHECK_PLAYER_CACHE_MS, 2500));
        parsedConfig.putInt(K_P2P_AUDIO_LIMIT_PEER_COUNT, config.getInt(KEY_EXT_P2P_AUDIO_LIMIT_PEER_COUNT, 5));
        parsedConfig.putInt(K_P2P_VIDEO_LIMIT_PEER_COUNT, config.getInt(KEY_EXT_P2P_VIDEO_LIMIT_PEER_COUNT, 7));
        parsedConfig.putInt(K_P2P_HTTP_SERVER_THREAD_COUNT, config.getInt(KEY_EXT_P2P_HTTP_SERVER_THREAD_COUNT, 8));
        parsedConfig.putString(K_P2P_UDP_LOSS_RATE_PARAMS, config.getString(KEY_EXT_P2P_UDP_LOSS_RATE_PARAMS, "1:1000;2:1000;3:1000;4:1000;"));
        parsedConfig.putString(K_P2P_UDP_RTT_PARAMS, config.getString(KEY_EXT_P2P_UDP_RTT_PARAMS, "1:82;2:99;3:141;4:400;"));
        parsedConfig.putInt(K_P2P_UDP_LOSS_RATE_SD_PERMILLAGE_CONFIG, config.getInt(KEY_EXT_P2P_UDP_LOSS_RATE_SD_PERMILLAGE_CONFIG, IjkMediaCodecInfo.RANK_MAX));
        parsedConfig.putInt(K_P2P_UDP_RTT_SD_CONFIG, config.getInt(KEY_EXT_P2P_UDP_RTT_SD_CONFIG, 30));
        parsedConfig.putInt(K_P2P_ENCRYPT_MAGIC_ENABLE, config.getBoolean(KEY_EXT_P2P_ENCRYPT_MAGIC_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_ENCRYPT_MAGIC_LEVEL, config.getInt(KEY_EXT_P2P_ENCRYPT_MAGIC_LEVEL, 2));
        parsedConfig.putInt(K_P2P_STREAM_TIMEOUT_BITRATE_CONFIG, config.getInt(KEY_EXT_P2P_STREAM_TIMEOUT_BITRATE_CONFIG, 600000));
        parsedConfig.putInt(K_P2P_ONLY_PCDN_ENABLE, config.getBoolean(KEY_EXT_P2P_ONLY_PCDN_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_IMPROVE_DOWNLOAD_SPEED_ENABLE, config.getBoolean(KEY_EXT_P2P_IMPROVE_DOWNLOAD_SPEED_ENABLE, true) ? 1 : 0);
        parsedConfig.putString(K_P2P_MAX_SUBSEGMENT_COUNT_INTERVAL, config.getString(KEY_EXT_P2P_MAX_SUBSEGMENT_COUNT_INTERVAL, "0:20;20:25;50:30;100:40;"));
        parsedConfig.putInt(K_P2P_CHECK_SPEED_CONFIG, config.getInt(KEY_EXT_P2P_CHECK_SPEED_CONFIG, 500));
        parsedConfig.putInt(K_P2P_CHECK_P2PSTATUS_CONFIG, config.getInt(KEY_EXT_P2P_CHECK_P2PSTATUS_CONFIG, 500));
        parsedConfig.putInt(K_P2P_KCP_UPDATE_ENABLE, config.getBoolean(KEY_EXT_P2P_KCP_UPDATE_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_KCP_CWND_ADJUST_THRESHOLD, config.getInt(KEY_EXT_P2P_KCP_CWND_ADJUST_THRESHOLD, 64));
        parsedConfig.putInt(K_P2P_KCP_CWND_GAIN_VALUE_A, config.getInt(KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_A, 200));
        parsedConfig.putInt(K_P2P_KCP_CWND_GAIN_VALUE_B, config.getInt(KEY_EXT_P2P_KCP_CWND_GAIN_VALUE_B, 140));
        parsedConfig.putInt(K_P2P_HTTPDNS_BILI_IP_ENABLE, config.getBoolean(KEY_EXT_P2P_HTTPDNS_BILI_IP_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_HTTPDNS_BILI_IP_RETRY_TIMES, config.getInt(KEY_EXT_P2P_HTTPDNS_BILI_IP_RETRY_TIMES, 2));
        parsedConfig.putString(K_P2P_HTTPDNS_BILI_IP, config.getString(KEY_EXT_P2P_HTTPDNS_BILI_IP, "47.101.175.206;47.100.123.169;120.46.169.234;121.36.72.124;"));
        parsedConfig.putInt(K_P2P_FEC_ENABLE, config.getBoolean(KEY_EXT_P2P_FEC_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_FEC_CTYPE, config.getInt(KEY_EXT_P2P_FEC_CTYPE, 0));
        parsedConfig.putInt(K_P2P_FEC_LOWER_BOUND, config.getInt(KEY_EXT_P2P_FEC_LOWER_BOUND, 2));
        parsedConfig.putInt(K_P2P_FEC_UPPER_BOUND, config.getInt(KEY_EXT_P2P_FEC_UPPER_BOUND, 11));
        parsedConfig.putString(K_P2P_ZONE_BLACK_LIST, config.getString(KEY_EXT_P2P_ZONE_BLACK_LIST, ""));
        parsedConfig.putString(K_P2P_BILIDNS_CMCC_IP, config.getString(KEY_EXT_P2P_BILIDNS_CMCC_IP, "116.63.10.135;122.9.7.134;117.185.228.108;117.144.238.29"));
        parsedConfig.putString(K_P2P_BILIDNS_CT_IP, config.getString(KEY_EXT_P2P_BILIDNS_CT_IP, "122.9.13.79;122.9.15.129;101.91.140.224;101.91.140.124"));
        parsedConfig.putString(K_P2P_BILIDNS_CU_IP, config.getString(KEY_EXT_P2P_BILIDNS_CU_IP, "114.116.215.110;116.63.10.31;112.64.218.119;112.65.200.117"));
        parsedConfig.putInt(K_P2P_HTTP3_ENABLE, config.getBoolean(KEY_EXT_P2P_HTTP3_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_IPV6_ENABLE, config.getBoolean(KEY_EXT_P2P_IPV6_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_RELEASE_PEER_RTT_THRESHOLD, config.getInt(KEY_EXT_P2P_RELEASE_PEER_RTT_THRESHOLD, 200));
        parsedConfig.putInt(K_P2P_CHECK_UDP_DOWNLOAD_SPEED, config.getBoolean(KEY_EXT_P2P_CHECK_UDP_DOWNLOAD_SPEED, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_SEGMENT_ASSIGN_TIME_MS, config.getInt(KEY_EXT_P2P_SEGMENT_ASSIGN_TIME_MS, 5000));
        parsedConfig.putInt(K_P2P_TCP_DYNAMIC_BITRATE_BUFFER_RATE, config.getInt(KEY_EXT_P2P_TCP_DYNAMIC_BITRATE_BUFFER_RATE, 5));
        parsedConfig.putInt(K_P2P_IPV4_DELAY_CONNECT_TIME, config.getInt(KEY_EXT_P2P_IPV4_DELAY_CONNECT_TIME, 0));
        parsedConfig.putInt(K_P2P_MULTI_CDN_DOWNLOAD_ENABLE, config.getBoolean(KEY_EXT_P2P_MULTI_CDN_DOWNLOAD_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_MULTI_CDN_CONN_COUNT, config.getInt(KEY_EXT_P2P_MULTI_CDN_CONN_COUNT, 1));
        parsedConfig.putInt(K_P2P_KCP_SESSION_PRIORITY_ENABLE, config.getBoolean(KEY_EXT_P2P_KCP_SESSION_PRIORITY_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_BILI_DNS_TIME_OUT, config.getInt(KEY_EXT_P2P_BILI_DNS_TIME_OUT, 2000));
        parsedConfig.putInt(K_P2P_NETWORK_LEVEL_FACTOR_ENABLE, config.getBoolean(KEY_EXT_P2P_NETWORK_LEVEL_FACTOR_ENABLE, true) ? 1 : 0);
        parsedConfig.putString(K_P2P_NETWORK_LEVEL_FACTOR, config.getString(KEY_EXT_P2P_NETWORK_LEVEL_FACTOR, "0:100;1:125;2:100;3:100;4:75;5:60"));
        parsedConfig.putInt(K_P2P_BITRATE_INC_COEFFICIENT, config.getInt(KEY_EXT_P2P_BITRATE_INC_COEFFICIENT, 5));
        parsedConfig.putInt(K_P2P_BITRATE_FACTOR_LOWERBOUND, config.getInt(KEY_EXT_P2P_BITRATE_FACTOR_LOWERBOUND, 10));
        parsedConfig.putInt(K_P2P_MULTI_CDN_COUNT_ENABLE, config.getBoolean(KEY_EXT_P2P_MULTI_CDN_COUNT_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_NETWORK_RTT_CHURNS_THRESHOLD, config.getInt(KEY_EXT_P2P_NETWORK_RTT_CHURNS_THRESHOLD, 200));
        parsedConfig.putInt(K_P2P_HTTP_READ_TIMEOUT_RETRY_ENABLE, config.getBoolean(KEY_EXT_P2P_HTTP_READ_TIMEOUT_RETRY_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CHECK_CDN_DOWNLOAD_SPEED, config.getBoolean(KEY_EXT_P2P_CHECK_CDN_DOWNLOAD_SPEED, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_OPEN_MULTI_CDN_BIT_THRESHOLD, config.getInt(KEY_EXT_P2P_OPEN_MULTI_CDN_BIT_THRESHOLD, 2400000));
        parsedConfig.putInt(K_P2P_STORY_OPEN_MULTI_CDN_BIT_THRESHOLD, config.getInt(KEY_EXT_P2P_STORY_OPEN_MULTI_CDN_BIT_THRESHOLD, 1200000));
        parsedConfig.putInt(K_P2P_DNS_DYNAMIC_TIMEOUT_ENABLE, config.getBoolean(KEY_EXT_P2P_DNS_DYNAMIC_TIMEOUT_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_LOW_SPEED_ERROR_INTERVAL, config.getInt(KEY_EXT_P2P_LOW_SPEED_ERROR_INTERVAL, 30000));
        parsedConfig.putInt(K_P2P_CHECK_RECIVE_HEADER_ENABLE, config.getBoolean(KEY_EXT_P2P_CHECK_RECIVE_HEADER_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_RELEASE_PEER_MUST_CHECK_RTT_ENABLE, config.getBoolean(KEY_EXT_P2P_RELEASE_PEER_MUST_CHECK_RTT_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_READ_DRIVE_BEFORE_GET_PEERS_ENABLE, config.getBoolean(KEY_EXT_P2P_READ_DRIVE_BEFORE_GET_PEERS_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_ADJUST_CDN_WEIGHT_BY_P2P_TASK_ENABLE, config.getBoolean(KEY_EXT_P2P_ADJUST_CDN_WEIGHT_BY_P2P_TASK_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_RELEASE_PEER_BLACK_LIST_ENABLE, config.getBoolean(KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_RELEASE_PEER_BLACK_LIST_COUNT, config.getInt(KEY_EXT_P2P_RELEASE_PEER_BLACK_LIST_COUNT, 2));
        parsedConfig.putInt(K_P2P_SUPER_NODE_SPEED_MEASURE_TIME_GAP_MS, config.getInt(KEY_EXT_P2P_SUPER_NODE_SPEED_MEASURE_TIME_GAP_MS, 2000));
        parsedConfig.putInt(K_P2P_SET_MAX_READ_DRIVE_TIME_ENABLE, config.getBoolean(KEY_EXT_P2P_SET_MAX_READ_DRIVE_TIME_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_MAX_READ_DRIVE_TIME_MS, config.getInt(KEY_EXT_P2P_MAX_READ_DRIVE_TIME_MS, 3000));
        parsedConfig.putInt(K_P2P_CDN_ASSIGN_INTERVAL_BITRATE_ENABLE, config.getBoolean(KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_BITRATE_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_INTERVAL_BITRATE_RATIO, config.getInt(KEY_EXT_P2P_CDN_INTERVAL_BITRATE_RATIO, 1));
        parsedConfig.putInt(K_P2P_PCDN_DOWNLOAD_ENABLE, config.getBoolean(KEY_EXT_P2P_PCDN_DOWNLOAD_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_ASSIGN_INTERVAL_NET_LEVEL_ENABLE, config.getBoolean(KEY_EXT_P2P_CDN_ASSIGN_INTERVAL_NET_LEVEL_ENABLE, true) ? 1 : 0);
        parsedConfig.putString(K_P2P_STR_CDN_ASSIGN_INTERVAL_NET_LEVEL_RATIO, config.getString(KEY_EXT_P2P_STR_CDN_ASSIGN_INTERVAL_NET_LEVEL_RATIO, "0:0;1:0;2:5;3:10;4:20;5:25;"));
        parsedConfig.putString(K_P2P_MCDN_MATCH_STR, config.getString(KEY_EXT_P2P_MCDN_MATCH_STR, "os=mcdn"));
        parsedConfig.putInt(K_P2P_MCDN_ONLY_COMPETE_WITH_MCDN, config.getBoolean(KEY_EXT_P2P_MCDN_ONLY_COMPETE_WITH_MCDN, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_DIFF_CDN_TYPE_COMPETE_ENABLE, config.getBoolean(KEY_EXT_P2P_DIFF_CDN_TYPE_COMPETE_ENABLE, false) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_MODE_LIMIT_ASSIGN_TIME_ENABLE, config.getBoolean(KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_TIME_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_MODE_LIMIT_ASSIGN_MIN_TIME_MS, config.getInt(KEY_EXT_P2P_CDN_MODE_LIMIT_ASSIGN_MIN_TIME_MS, 5000));
        parsedConfig.putInt(K_P2P_TIMEOUT_INCREASE_TO_MAX_ENABLE, config.getBoolean(KEY_EXT_P2P_TIMEOUT_INCREASE_TO_MAX_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_SUBSCRIBE_SUCC_RATE_ENABLE, config.getBoolean(KEY_EXT_P2P_SUBSCRIBE_SUCC_RATE_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_UPDATE_URL_CDN_COMPETE_ENABLE, config.getBoolean(KEY_EXT_P2P_UPDATE_URL_CDN_COMPETE_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_LOW_SPEED_RATIO, config.getInt(KEY_EXT_P2P_CDN_LOW_SPEED_RATIO, 100));
        parsedConfig.putInt(K_P2P_PRE_SEEK_ENABLE, config.getBoolean(KEY_EXT_P2P_PRE_SEEK_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_NET_QUALITY_ENABLE, config.getBoolean(KEY_EXT_P2P_CDN_NET_QUALITY_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_CDN_NET_MAX_NODES, config.getInt(KEY_EXT_P2P_CDN_NET_MAX_NODES, 4));
        parsedConfig.putInt(K_P2P_CDN_NET_DETECT_INTERVAL_MS, config.getInt(KEY_EXT_P2P_CDN_NET_DETECT_INTERVAL_MS, 5000));
        parsedConfig.putInt(K_P2P_CDN_CONNECTION_MONITOR_ENABLE, config.getBoolean(KEY_EXT_P2P_CDN_CONNECTION_MONITOR_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_LOCAL_CONNECT_ENABLE, config.getBoolean(KEY_EXT_P2P_LOCAL_CONNECT_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_MCDN_IPV6_ENABLE, config.getBoolean(KEY_EXT_P2P_MCDN_IPV6_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_PERFORMANCE_OPTIMIZATION_ENABLE, config.getBoolean(KEY_EXT_P2P_PERFORMANCE_OPTIMIZATION_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_COMPETE_LOGIC_OPT_ENABLE, config.getBoolean(KEY_EXT_COMPETE_LOGIC_OPT_ENABLE, true) ? 1 : 0);
        parsedConfig.putInt(K_P2P_HTTPDNS_BILI_FIRST_ENABLE, config.getBoolean(KEY_EXT_P2P_HTTPDNS_BILI_FIRST_ENABLE, true) ? 1 : 0);
        parsedConfig.putString(K_P2P_HTTPDNS_GOOGLE_SERVER_IPS, config.getString(KEY_EXT_P2P_HTTPDNS_GOOGLE_SERVER_IPS, "8.8.4.4,8.8.8.8,2001:4860:4860::8888,2001:4860:4860::8844"));
        String cachePath = getCacheDirector(context, IJK_P2P_CACHE_DIR);
        parsedConfig.putString(K_P2P_CACHE_PATH, cachePath);
        long maxCacheSize = config.getLong(KEY_EXT_P2P_MAX_CACHE, 0L);
        long diskFreeSize = getDiskFreeSpace(cachePath) + getPathSize(cachePath);
        int maxCachePercent = config.getInt(KEY_EXT_P2P_MAX_CACHE_PERCENT, 0);
        parsedConfig.putLong(K_P2P_MAX_CACHE_SIZE, Math.min(maxCacheSize, (Math.min(100, maxCachePercent) * diskFreeSize) / 100));
        parsedConfig.putInt(K_PEER_DEVICE_TYPE, config.getInt(KEY_EXT_P2P_DEVICE_TYPE, DEVICE_TYPE.DEVICE_ANDROID.ordinal()));
        parsedConfig.putString(KEY_EXT_P2P_SERVER_URL, config.getString(KEY_EXT_P2P_SERVER_URL, P2P_SERVER_URL_DEFAULT));
        parsedConfig.putString(KEY_EXT_P2P_SERVER_URL_YUNCHANG, config.getString(KEY_EXT_P2P_SERVER_URL_YUNCHANG, P2P_SERVER_URL_DEFAULT_YUNCHANG));
        parsedConfig.putString(KEY_EXT_P2P_PLAY_URL, config.getString(KEY_EXT_P2P_PLAY_URL, P2P_PLAY_URL_DEFAULT));
        parsedConfig.putString(K_PEER_DEVICE_ID, sP2PDeviceId);
        IjkNetworkUtils.NetWorkType netWorkType = IjkNetworkUtils.getNetworkState(context);
        parsedConfig.putInt(K_PEER_NETWORK_TYPE, netWorkType.ordinal());
        return parsedConfig;
    }

    private void applyNewConfig(Context context, Bundle newConfig) {
        if (context == null) {
            BLog.w(TAG, "P2P applyNewConfig failed, context null !!");
            return;
        }
        Context appContext = context.getApplicationContext();
        Bundle newConfigParsed = parseConfig(appContext, newConfig);
        if (this.mClient != null && !isConfigEqual(newConfigParsed, this.mApplyConfigs, this.mConfigKeyExcepts)) {
            try {
                this.mClient.notifyConfigChange(newConfigParsed);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        this.mApplyConfigs = newConfigParsed;
    }

    private boolean isConfigEqual(Bundle config1, Bundle config2, ArrayList<String> excepts) {
        if (config1 == null && config2 == null) {
            return true;
        }
        if (config1 == null || config2 == null || config1.size() != config2.size()) {
            return false;
        }
        for (String key : config1.keySet()) {
            Object value1 = config1.get(key);
            Object value2 = config2.get(key);
            if (excepts == null || !excepts.contains(key)) {
                if (!(value1 instanceof String) || !((String) value1).equals(value2)) {
                    if (!(value1 instanceof Long) || !((Long) value1).equals(value2)) {
                        if (!(value1 instanceof Integer) || !((Integer) value1).equals(value2)) {
                            if (!(value1 instanceof Boolean) || !((Boolean) value1).equals(value2)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static String getCacheDirector(Context context, String dir) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return "";
        }
        String path = cacheDir.getAbsolutePath() + EntryScannerKt.PATH_SEPARATOR + dir;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        } else if (file.isFile()) {
            file.delete();
            file.mkdir();
        }
        return path;
    }

    private void scanPath(String path) {
        String[] children;
        if (TextUtils.isEmpty(path)) {
            return;
        }
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory() || (children = dir.list()) == null) {
            return;
        }
        for (int i = 0; i < children.length; i++) {
            String p = path + EntryScannerKt.PATH_SEPARATOR + children[i];
            File child = new File(p);
            if (child.isDirectory()) {
                deleteDir(p);
            } else {
                child.delete();
            }
        }
    }

    private void deleteDir(String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                String p = path + EntryScannerKt.PATH_SEPARATOR + children[i];
                File child = new File(p);
                if (child.isFile()) {
                    child.delete();
                } else {
                    deleteDir(p);
                }
            }
            dir.delete();
        }
    }

    private static long getDiskFreeSpace(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0L;
        }
        try {
            StatFs stat = new StatFs(path);
            long blockSize = stat.getBlockSizeLong();
            long availableBlocks = stat.getAvailableBlocksLong();
            return blockSize * availableBlocks;
        } catch (RuntimeException e) {
            return 0L;
        }
    }

    private static long getPathSize(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0L;
        }
        return getFolderSize(new File(path));
    }

    private static long getFolderSize(File file) {
        File[] fileList;
        long size = 0;
        try {
            fileList = file.listFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fileList == null) {
            return 0L;
        }
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                size += getFolderSize(fileList[i]);
            } else {
                size += fileList[i].length();
            }
        }
        return size;
    }

    public void setBinder(IP2P client) {
        synchronized (P2P.class) {
            if ((this.mClient == null || client == null) && this.mClient != client) {
                this.mClient = client;
                if (this.mClient != null) {
                    handleClientReboot();
                    ParcelFileDescriptor[] channels = getTrackerChannelFd();
                    if (channels != null && channels.length == 2) {
                        this.mTrackerProxy = new P2PTrackerClientProxy(channels[0], this.mP2PServerResolver, false);
                        this.mLiveTrackerProxy = new P2PTrackerClientProxy(channels[1], this.mP2PServerResolver, true);
                    }
                } else {
                    if (this.mTrackerProxy != null) {
                        this.mTrackerProxy.release();
                        this.mTrackerProxy = null;
                    }
                    if (this.mLiveTrackerProxy != null) {
                        this.mLiveTrackerProxy.release();
                        this.mLiveTrackerProxy = null;
                    }
                }
            }
        }
    }

    public boolean isNeedCreateClient() {
        boolean z;
        synchronized (P2P.class) {
            z = false;
            if (this.mClient == null && this.mGrpcClientInited && (this.mConfigs.getInt(K_P2P_DISABLE_AFTER_CRASH, 0) <= 0 || this.mP2PRebootTimes.size() <= this.mConfigs.getInt(K_P2P_ONE_MINUTE_REBOOT_LIMITED, 3))) {
                z = true;
            }
        }
        return z;
    }

    public void handleClientReboot() {
        synchronized (P2P.class) {
            long now = SystemClock.elapsedRealtime();
            while (this.mP2PRebootTimes.size() > 0 && this.mP2PRebootTimes.size() <= this.mConfigs.getInt(K_P2P_ONE_MINUTE_REBOOT_LIMITED, 3) && now - this.mP2PRebootTimes.get(0).longValue() > 60000) {
                this.mP2PRebootTimes.remove(0);
            }
            this.mP2PRebootTimes.add(Long.valueOf(now));
            BLog.i(TAG, "handleClientReboot now " + now + " mP2PRebootTimes " + this.mP2PRebootTimes.size());
        }
    }

    public Bundle getConfigs() {
        Bundle bundle;
        synchronized (P2P.class) {
            IjkNetworkUtils.NetWorkType currentNet = this.mCurNet;
            if (currentNet != null) {
                this.mConfigs.putInt(K_PEER_NETWORK_TYPE, currentNet.ordinal());
            }
            bundle = this.mConfigs;
        }
        return bundle;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IjkNetworkManager.NetWorkChangeListener
    public void onNetWorkChange(IjkNetworkUtils.NetWorkType cur, IjkNetworkUtils.NetWorkType old) {
        synchronized (P2P.class) {
            this.mCurNet = cur;
            if (this.mClient != null) {
                try {
                    if (cur != IjkNetworkUtils.NetWorkType.NONE && this.mP2PServerResolver != null && this.mTrackerProxy != null && this.mLiveTrackerProxy != null) {
                        BLog.i(TAG, "P2P network changed, get new tracker host");
                        this.mP2PServerResolver.setNeedResolved();
                        this.mTrackerProxy.switchNewTrackerAsyn();
                        this.mLiveTrackerProxy.switchNewTrackerAsyn();
                    }
                    this.mClient.nofityNetWorkChange(cur.ordinal(), old.ordinal());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ParcelFileDescriptor[] getTrackerChannelFd() {
        IP2P client = this.mClient;
        if (client != null) {
            try {
                ParcelFileDescriptor[] pFd = client.getTrackerChannelFd();
                return pFd;
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public int getHttpServerPort() {
        IP2P client = this.mClient;
        if (client != null) {
            try {
                return client.getHttpServerPort();
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public void dump(FileDescriptor fd, String[] args) {
        IP2P client = this.mClient;
        if (client != null) {
            try {
                client.asBinder().dump(fd, args);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public String dumpState(String[] args) {
        String dumpRet = new String("");
        try {
            ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
            dump(fds[1].getFileDescriptor(), args);
            fds[1].close();
            FileInputStream input = new FileInputStream(fds[0].getFileDescriptor());
            InputStreamReader reader = new InputStreamReader(input);
            char[] buf = new char[1024];
            while (true) {
                int ret = reader.read(buf, 0, buf.length);
                if (ret <= 0) {
                    break;
                }
                dumpRet = dumpRet + new String(buf, 0, ret);
            }
            fds[0].close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dumpRet;
    }

    private static String getProxyDataPath(Context context, String dir) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return "";
        }
        String filePath = cacheDir.getAbsolutePath();
        return filePath + EntryScannerKt.PATH_SEPARATOR + dir;
    }
}