package com.cxt.esl.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	private Context mContext;
	public static final String ESLS_AP = "CREATE TABLE 'esls_ap' ("
			+ "'ap_id' TEXT(40) NOT NULL /*�豸id*/,"
			+ "'model' TEXT(41) DEFAULT NULL,"
			+ "'note_tec' TEXT(200) DEFAULT NULL,"
			+ "'note_func' TEXT(200) DEFAULT NULL,"
			+ "'work_mode' INTEGER DEFAULT NULL /*ap����ģʽ*/,"
			+ "'shelf_id' INTEGER DEFAULT NULL,"
			+ "'sn' TEXT(50) NOT NULL DEFAULT '' /*���к�*/,"
			+ "'ver' TEXT(50) DEFAULT NULL /*�����Ӳ���汾��*/,"
			+ "'mac_id' TEXT(20) NOT NULL DEFAULT '' /*MAC��ַ*/,"
			+ "'multipath' INTEGER DEFAULT NULL /*���ص�Դ·��*/,"
			+ "'gate_mac' TEXT(20) DEFAULT NULL /*��������MAC*/,"
			+ "'gate_ip' TEXT(50) DEFAULT NULL /*��������ip*/,"
			+ "'rout_mac' TEXT(20) DEFAULT NULL /*����·����MAC*/,"
			+ "'remarks' TEXT(200) DEFAULT NULL /*��ע*/,"
			+ "'sleep_period' INTEGER DEFAULT NULL /*AP��˯��ʱ�������߰汾����*/,"
			+ "'router_num' INTEGER DEFAULT NULL," + "PRIMARY KEY ('ap_id')"
			+ ")";

	public static final String ESLS_CONFIG = "CREATE TABLE 'esls_config' ("
			+ "'good_syn_time' TEXT NOT NULL DEFAULT '1999-01-01 00:00:00',"
			+ "'price_syn_time' TEXT DEFAULT NULL,"
			+ "'title' TEXT(50) DEFAULT NULL,"
			+ "'copyright' TEXT(200) DEFAULT NULL,"
			+ "'unit' TEXT(50) DEFAULT NULL,"
			+ "'unit_id' TEXT(50) DEFAULT NULL,"
			+ "'retry_times' INTEGER(4) DEFAULT NULL,"
			+ "'blk_crea_period' INTEGER(20) DEFAULT NULL,"
			+ "'check_period' INTEGER(20) DEFAULT NULL,"
			+ "'goods_syn_period' INTEGER(20) DEFAULT NULL,"
			+ "'exceed_period' INTEGER(20) DEFAULT NULL,"
			+ "'wire_exceed_period' INTEGER(20) DEFAULT NULL,"
			+ "'up_down' INTEGER(4) DEFAULT NULL,"
			+ "'upload_period' INTEGER(20) DEFAULT NULL,"
			+ "'threshold_off_warn' INTEGER(20) DEFAULT NULL,"
			+ "'threshold_off_err' INTEGER(20) DEFAULT NULL,"
			+ "'threshold_low_warn' INTEGER(20) DEFAULT NULL,"
			+ "'threshold_low_err' INTEGER(20) DEFAULT NULL,"
			+ "'sys_type' INTEGER(4) DEFAULT NULL,"
			+ "'guide_type' INTEGER(4) DEFAULT NULL /*ϵͳ�Ƿ�֧�֣��ϼ���ָ����*/,"
			+ "'smart_upd_mode' INTEGER(4) DEFAULT NULL /*���ܸ���ģʽ,0-��ͨ����ģʽ��ȫ�����£�Ĭ�ϣ�,1-���ܸ���ģʽ���ֿ����*/,"
			+ "'upd_comfirm' INTEGER(4) DEFAULT NULL /*����esl�Ƿ���Ҫ�û�ȷ��*/,"
			+ "'up_ips' TEXT(100) DEFAULT NULL /*��������ַ�б�*/,"
			+ "'conn_url' TEXT /*���ݿ������ַ���*/,"
			+ "'conn_username' TEXT(100) DEFAULT NULL /*�û���*/,"
			+ "'conn_password' TEXT(100) DEFAULT NULL /*����*/" + ")";

	public static final String ESLS_DEVICE = "CREATE TABLE 'esls_devices' ("
			+ "'device_id' INTEGER PRIMARY KEY AUTOINCREMENT /*�豸id*/,"
			+ "'sn' TEXT(50) DEFAULT NULL /*���к�*/,"
			+ "'ver' TEXT(50) DEFAULT NULL /*����汾��*/,"
			+ "'model' TEXT(50) DEFAULT NULL /*����ͺ�*/,"
			+ "'mac_id' TEXT(20) DEFAULT NULL /*MAC��ַ*/,"
			+ "'device_type' INTEGER DEFAULT NULL /*�豸���ͣ�1-LANӦ������ 2-WANӦ������ 3-����·���� 4-�ƶ�����ն� 5-�ֳֻ�����׿��*/,"
			+ "'user_id' INTEGER DEFAULT NULL /*������id*/,"
			+ "'op_time' TEXT DEFAULT NULL /*����ʱ��*/,"
			+ "'remarks' TEXT(200) DEFAULT NULL /*��ע*/" + ")";

	public static final String ESLS_ESL = "CREATE TABLE 'esls_esl' ("
			+ "'esl_id' INTEGER(20) NOT NULL /*EID*/,"
			+ "'mac_id' TEXT(50) NOT NULL DEFAULT '' /*MAC��ַ*/,"
			+ "'inch' REAL(10,2) DEFAULT NULL /*��Ļ�ߴ磨Ӣ�磩*/,"
			+ "'esl_width' INTEGER DEFAULT NULL /*�����أ�*/,"
			+ "'esl_height' INTEGER DEFAULT NULL /*�ߣ����أ�*/,"
			+ "'bpp' INTEGER(3) DEFAULT NULL /*ÿ������ռλ*/,"
			+ "'kinds_id' TEXT(50) DEFAULT NULL /*����������id��*/,"
			+ "'goods_id' INTEGER DEFAULT NULL /*������Ʒid*/,"
			+ "'pattern_id' INTEGER DEFAULT NULL /*ʹ��ģ��id*/,"
			+ "'ap_id' INTEGER DEFAULT NULL /*����AP*/,"
			+ "'user_id' INTEGER DEFAULT NULL /*������id*/,"
			+ "'sleep_period' INTEGER DEFAULT NULL /*����ʱ������ɱ��β�����ESL�����ߵ�ʱ�䳤�ȣ�ms��*/,"
			+ "'sleep_mode' INTEGER DEFAULT NULL /*����ģʽ*/,"
			+ "'gate_mac' TEXT(20) DEFAULT NULL /*����mac*/,"
			+ "'gate_ip' TEXT(20) DEFAULT NULL /*����ip*/,"
			+ "'rout_mac' TEXT(20) DEFAULT NULL /*·����mac*/,"
			+ "'device_id' INTEGER DEFAULT NULL /*�豸id*/,"
			+ "'last_comm_time' TEXT DEFAULT NULL /*���ͨ��ʱ��*/,"
			+ "'power' INTEGER DEFAULT NULL /*��ص���*/,"
			+ "'op_time' TEXT DEFAULT NULL /*����ʱ��*/,"
			+ "'esl_status' INTEGER NOT NULL DEFAULT '0' /*ESL����״̬��0-��Ч 1-��ͣʹ�� 2-ʧЧ���𻵣�����ȣ�*/,"
			+ "'remarks' TEXT(200) DEFAULT NULL /*��ע*/,"
			+ "'signal' INTEGER DEFAULT NULL /*ͨ���ź�ǿ��*/,"
			+ "'model_id' INTEGER DEFAULT NULL /*�����ͺ�id*/,"
			+ "'mycode' TEXT(20) DEFAULT NULL /*�û��Զ�����*/,"
			+ "'work_status' INTEGER DEFAULT '0' /*����״̬��-1 δ֪�쳣��0 ��ʼ��1 ������2 ����ͼƬ��3 �·�ͼƬûfeedback��4 �·�ͼƬ��feedback��5 esl ������*/,"
			+ "'show_data_url' TEXT(200) DEFAULT NULL /*Ŀǰ��ʾ���ݵ�ͼƬ�ĵ�ַ*/,"
			+ "'has_nogenerate_data' INTEGER DEFAULT '0' /*�Ƿ���δ���ɵ�ͼƬ 0 û�� 1 ��*/,"
			+ "'has_nosend_data' INTEGER DEFAULT '0' /*�Ƿ���δ�·���ͼƬ 0 û�� 1 ��*/,"
			+ "'has_nofeedback_data' INTEGER DEFAULT '0' /*�Ƿ���δ������ͼƬ 0 û�� 1 ��*/,"
			+ "PRIMARY KEY ('esl_id')," + "UNIQUE ('mac_id')" + ")";

	public static final String ESLS_ESL_DISP_HIS = "CREATE TABLE 'esls_esl_disp_his' ("
			+ "'disp_id' INTEGER PRIMARY KEY AUTOINCREMENT /*��ʾ����id*/,"
			+ "'mac_id' TEXT(50) DEFAULT NULL /*����ESL��MAC*/,"
			+ "'width' INTEGER DEFAULT NULL /*��*/,"
			+ "'height' INTEGER DEFAULT NULL /*��*/,"
			+ "'data' BLOB /*�������ݣ���������������*/,"
			+ "'goods_id' INTEGER DEFAULT NULL /*��Ʒid�����ã�*/,"
			+ "'bar_code' TEXT(50) DEFAULT NULL /*��Ʒ�����룩���*/,"
			+ "'pos_name' TEXT(50) DEFAULT NULL /*posϵͳ��Ʒ��*/,"
			+ "'esl_name' TEXT(50) DEFAULT NULL /*ESLϵͳ��Ʒ��*/,"
			+ "'kind_id' TEXT(50) DEFAULT NULL /*��������id�����ã�*/,"
			+ "'kind_name' TEXT(50) DEFAULT NULL /*����������*/,"
			+ "'orig_price' REAL(15,2) DEFAULT NULL /*ԭ��*/,"
			+ "'pres_price' REAL(15,2) DEFAULT NULL /*�ּ�*/,"
			+ "'op_time' TEXT DEFAULT NULL /*��������ʾ�ɹ���ʱ��*/,"
			+ "'up_time' TEXT DEFAULT NULL /*�����ϴ��ɹ�ʱ��*/,"
			+ "'remarks' TEXT(50) DEFAULT NULL /*��ע*/" + ") ";

	public static final String ESLS_ESL_MODEL = "CREATE TABLE 'esls_esl_model' ("
			+ "'model_id' INTEGER PRIMARY KEY AUTOINCREMENT /*�ͺ�ID*/,"
			+ "'model_name' VARCHAR(50) DEFAULT NULL /*����ͺţ�������*/,"
			+ "'model_note' VARCHAR(40) DEFAULT NULL /*�ͺ�����*/,"
			+ "'inch' REAL(10,2) DEFAULT NULL /*��Ļ�ߴ磨Ӣ�磩*/,"
			+ "'esl_width' INTEGER DEFAULT NULL /*�����أ�*/,"
			+ "'esl_height' INTEGER DEFAULT NULL /*�ߣ����أ�*/,"
			+ "'rotate' INTEGER DEFAULT NULL /*��ת�Ƕ�*/,"
			+ "'bpp' tinyint(4) DEFAULT NULL /*ÿ������ռλ���ҽף�*/,"
			+ "'bpp_red' INTEGER DEFAULT NULL /*��ɫbpp*/,"
			+ "'bpp_green' INTEGER DEFAULT NULL /*��ɫbpp*/,"
			+ "'bpp_blue' INTEGER DEFAULT NULL /*��ɫbpp*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/" + ") ";

	public static final String ESLS_ESL_STATE_KIND = "CREATE TABLE 'esls_esl_state_kind' ("
			+ "'state_kind_id' VARCHAR(50) NOT NULL DEFAULT '' /*״̬����id*/,"
			+ "'state_descr' VARCHAR(50) DEFAULT NULL /*״̬����*/,"
			+ "'remarks' VARCHAR(50) DEFAULT NULL /*��ע*/" + ")";

	public static final String ESLS_ESL_STATE_LOG = "CREATE TABLE 'esls_esl_state_log' ("
			+ "'state_id' VARCHAR(50) NOT NULL DEFAULT '' /*״̬id*/,"
			+ "'mac_id' VARCHAR(50) DEFAULT NULL /*��ӦESL��MAC*/,"
			+ "'state_kind_id' VARCHAR(50) DEFAULT NULL /*״̬����*/,"
			+ "'state_time' VARCHAR(50) DEFAULT NULL /*״̬����ʱ��*/,"
			+ "'remarks' VARCHAR(50) DEFAULT NULL /*��ע*/,"
			+ "PRIMARY KEY ('state_id')" + ")";

	public static final String ESLS_ESL_WORKLOG = "CREATE TABLE 'esls_esl_worklog' ("
			+ "'log_id' INTEGER PRIMARY KEY  AUTOINCREMENT,"
			+ "'mac_id' VARCHAR(50) DEFAULT NULL,"
			+ "'esl_id' VARCHAR(20) DEFAULT NULL,"
			+ "'signal' INTEGER DEFAULT NULL /*ͨ���ź�ǿ��*/,"
			+ "'work_time' TEXT DEFAULT NULL,"
			+ "'power' INTEGER DEFAULT NULL /*����ͨ�ŵ�ص���*/,"
			+ "'work_type' INTEGER DEFAULT NULL /*0-���ѣ�request��\n1-������feedback��\n2-������Ԥ����*/,"
			+ "'pack_detail' BLOB /*������ϸ����*/,"
			+ "'ap_id' VARCHAR(20) DEFAULT NULL /*����AP*/,"
			+ "'log_str' VARCHAR(500) DEFAULT NULL /*log�ַ���*/" + ") ";

	public static final String ESLS_GOODS = "CREATE TABLE 'esls_goods' ("
			+ "'goods_id' INTEGER PRIMARY KEY AUTOINCREMENT /*��Ʒid*/,"
			+ "'bar_code' VARCHAR(100) NOT NULL /*��Ʒ�����룩��ţ�ͬposϵͳ��*/,"
			+ "'pos_name' VARCHAR(100) DEFAULT NULL /*��Ʒ����ͬposϵͳ��*/,"
			+ "'esl_name' VARCHAR(100) DEFAULT NULL /*��ʾ����ESLϵͳ��*/,"
			+ "'goods_series' VARCHAR(50) DEFAULT NULL /*��Ʒϵ�У�ͬposϵͳ��*/,"
			+ "'goods_desc' VARCHAR(200) DEFAULT NULL /*��Ʒ������ͬposϵͳ��*/,"
			+ "'orig_price' REAL(15,2) NOT NULL DEFAULT '0.00' /*ԭ�ۣ�ͬposϵͳ��*/,"
			+ "'pres_price' REAL(15,2) DEFAULT '0.00' /*�ּۣ�ͬposϵͳ��*/,"
			+ "'rate' INTEGER DEFAULT NULL /*�ۿ��ʣ�ͬposϵͳ��*/,"
			+ "'prod_area' VARCHAR(100) DEFAULT NULL /*���أ�ͬposϵͳ��*/,"
			+ "'model' VARCHAR(50) DEFAULT NULL /*����ͺ�*/,"
			+ "'stock' INTEGER DEFAULT NULL /*���:��POSͬ���������*/,"
			+ "'salable' INTEGER  DEFAULT NULL /*�ϼ�����*/,"
			+ "'saled' INTEGER  DEFAULT NULL /*��������*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/,"
			+ "'upd_time' TEXT DEFAULT NULL,"
			+ "'kind_id' INTEGER  DEFAULT NULL /*��������*/,"
			+ "'guid' VARCHAR(40) DEFAULT NULL,"
			+ "'promote1' VARCHAR(50) DEFAULT NULL /*������Ϣ1*/,"
			+ "'promote2' VARCHAR(50) DEFAULT NULL /*������Ϣ2*/,"
			+ "'status' INTEGER  NOT NULL DEFAULT '0' /*0-������Ĭ�ϣ���Ʒ��Ϣ��ESL��ȷ��Ӧ��\n1-��Ʒ��Ϣ�޸ģ�������ʾ�У�����Ʒ��ص�ESL������ʾδ��ɣ��ݲ������ۣ�*/,"
			+ "'user_modi_time' TEXT DEFAULT NULL /*MIS���û����һ���޸ĵ�ʱ��*/,"
			+ "'pos_modi_time' TEXT DEFAULT NULL /*������棬�ϼ�����������������POSд��*/,"
			+ "'memb_price' REAL(15,2) DEFAULT NULL /*��Ա��*/,"
			+ "'memb_rate' INTEGER  DEFAULT NULL /*��Ա�ۿ�*/,"
			+ "'tax' REAL(10,2) DEFAULT NULL /*˰��*/,"
			+ "'tax_rate' INTEGER  DEFAULT NULL /*˰��*/,"
			+ "'order_num' INTEGER  DEFAULT '0' /*���*/,"
			+ "'product_date' TEXT DEFAULT NULL /*��������*/,"
			+ "'good_bar_code' VARCHAR(12) DEFAULT NULL /*����ͳһ����*/,"
			+ "'price_unit' VARCHAR(20) DEFAULT NULL /*�Ƽ۵�λ*/,"
			+ "'level' VARCHAR(20) DEFAULT NULL /*�ȼ�*/,"
			+ "'pm' VARCHAR(100) DEFAULT NULL /*���Ա*/,"
			+ "'promote_start_time' TEXT DEFAULT NULL /*������ʼ����*/,"
			+ "'promote_end_time' TEXT DEFAULT NULL /*������������*/,"
			+ "'price_down_flag' INTEGER DEFAULT '0' /*�Ż�ֱ�� �������� 1���� 0������*/,"
			+ "'memb_owner' INTEGER DEFAULT '0' /*��Աר�� �������� 1���� 0����*/,"
			+ "UNIQUE ('bar_code')" + ") ";

	public static final String ESLS_GOOD_IMPORT = "CREATE TABLE 'esls_goods_import' ("
			+ "'goods_id' INTEGER PRIMARY KEY AUTOINCREMENT /*��Ʒid*/,"
			+ "'bar_code' VARCHAR(100) NOT NULL /*��Ʒ�����룩��ţ�ͬposϵͳ��*/,"
			+ "'pos_name' VARCHAR(100) DEFAULT NULL /*��Ʒ����ͬposϵͳ��*/,"
			+ "'esl_name' VARCHAR(100) DEFAULT NULL /*��ʾ����ESLϵͳ��*/,"
			+ "'goods_series' VARCHAR(50) DEFAULT NULL /*��Ʒϵ�У�ͬposϵͳ��*/,"
			+ "'goods_desc' VARCHAR(200) DEFAULT NULL /*��Ʒ������ͬposϵͳ��*/,"
			+ "'orig_price' REAL(15,2) NOT NULL DEFAULT '0.00' /*ԭ�ۣ�ͬposϵͳ��*/,"
			+ "'pres_price' REAL(15,2) DEFAULT '0.00' /*�ּۣ�ͬposϵͳ��*/,"
			+ "'rate' INTEGER DEFAULT NULL /*�ۿ��ʣ�ͬposϵͳ��*/,"
			+ "'prod_area' VARCHAR(100) DEFAULT NULL /*���أ�ͬposϵͳ��*/,"
			+ "'model' VARCHAR(50) DEFAULT NULL /*����ͺ�*/,"
			+ "'stock' INTEGER DEFAULT NULL /*���:��POSͬ���������*/,"
			+ "'salable' INTEGER DEFAULT NULL /*�ϼ�����*/,"
			+ "'saled' INTEGER DEFAULT NULL /*��������*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/,"
			+ "'upd_time' TEXT DEFAULT NULL,"
			+ "'kind_id' VARCHAR(255) DEFAULT NULL /*��������*/,"
			+ "'guid' VARCHAR(40) DEFAULT NULL,"
			+ "'promote1' VARCHAR(50) DEFAULT NULL /*������Ϣ1*/,"
			+ "'promote2' VARCHAR(50) DEFAULT NULL /*������Ϣ2*/,"
			+ "'status' INTEGER NOT NULL DEFAULT '0' /*0-������Ĭ�ϣ���Ʒ��Ϣ��ESL��ȷ��Ӧ��\n1-��Ʒ��Ϣ�޸ģ�������ʾ�У�����Ʒ��ص�ESL������ʾδ��ɣ��ݲ������ۣ�*/,"
			+ "'user_modi_time' TEXT DEFAULT NULL /*MIS���û����һ���޸ĵ�ʱ��*/,"
			+ "'pos_modi_time' TEXT DEFAULT NULL /*������棬�ϼ�����������������POSд��*/,"
			+ "'memb_price' REAL(15,2) DEFAULT NULL /*��Ա��*/,"
			+ "'memb_rate' INTEGER DEFAULT NULL /*��Ա�ۿ�*/,"
			+ "'tax' REAL(10,2) DEFAULT NULL /*˰��*/,"
			+ "'tax_rate' INTEGER DEFAULT NULL /*˰��*/,"
			+ "'order_num' INTEGER DEFAULT '0' /*���*/,"
			+ "'product_date' TEXT DEFAULT NULL /*��������*/,"
			+ "'good_bar_code' VARCHAR(12) DEFAULT NULL /*����ͳһ����*/,"
			+ "'user_id' VARCHAR(16) DEFAULT NULL /*�����û�*/,"
			+ "'handle_status' INTEGER NOT NULL DEFAULT '1' /*1 δ����,0�Ѿ�����*/,"
			+ "'import_time' TEXT NOT NULL  /*����ʱ��,��ǰʱ��*/" + ")";

	public static final String ESLS_GOODS_UPDATE = "CREATE TABLE 'esls_goods_update' ("
			+ "'goods_upd_id' INTEGER PRIMARY KEY AUTOINCREMENT /*��Ʒ��Ϣ�޸ļ�¼id*/,"
			+ "'goods_id' INTEGER DEFAULT NULL /*��Ʒid*/,"
			+ "'bar_code' VARCHAR(100) DEFAULT NULL /*��Ʒ�����룩���,*/,"
			+ "'pos_name' VARCHAR(100) DEFAULT NULL /*��Ʒ��*/,"
			+ "'esl_name' VARCHAR(100) DEFAULT NULL /*��ʾ����ESLϵͳ��*/,"
			+ "'goods_series' VARCHAR(50) DEFAULT NULL /*��Ʒϵ��*/,"
			+ "'goods_desc' VARCHAR(200) DEFAULT NULL /*��Ʒ����*/,"
			+ "'orig_price' REAL(15,2) DEFAULT NULL /*ԭ��*/,"
			+ "'pres_price' REAL(15,2) DEFAULT NULL /*�ּ�*/,"
			+ "'rate' INTEGER DEFAULT NULL /*�ۿ���*/,"
			+ "'prod_area' VARCHAR(50) DEFAULT NULL /*����*/,"
			+ "'model' VARCHAR(50) DEFAULT NULL /*����ͺ�*/,"
			+ "'upd_time' TEXT DEFAULT NULL /*���ͬ��ʱ��,��POSͬ��ʱ��*/,"
			+ "'status' INTEGER DEFAULT NULL /*���¿��������,0-δ���ɣ�1-�����ɣ�2-���ϣ�3 ��ʾ�ɹ�*/,"
			+ "'stock' INTEGER DEFAULT NULL /*���*/,"
			+ "'salable' INTEGER DEFAULT NULL /*�ϼ�����*/,"
			+ "'saled' INTEGER DEFAULT NULL /*��������*/,"
			+ "'reason' INTEGER DEFAULT NULL /*0-��Ʒ��Ϣ�޸� 1-ESL��ʾ���޸� 2-��ʾģ���޸� 3-ESL-��Ʒ��������*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/,"
			+ "'data_flag' VARCHAR(200) DEFAULT '0' /*�����޸����Ӧֵ*/,"
			+ "'promote1' VARCHAR(50) DEFAULT NULL /*������Ϣ1*/,"
			+ "'promote2' VARCHAR(50) DEFAULT NULL /*������Ϣ2*/,"
			+ "'memb_price' REAL(15,2) DEFAULT NULL,"
			+ "'memb_rate' INTEGER DEFAULT NULL,"
			+ "'tax' REAL(10,2) DEFAULT NULL,"
			+ "'tax_rate' INTEGER DEFAULT NULL,"
			+ "'product_date' TEXT DEFAULT NULL /*��������*/,"
			+ "'good_bar_code' VARCHAR(12) DEFAULT NULL /*����ͳһ����*/,"
			+ "'level' VARCHAR(20) DEFAULT NULL /*�ȼ�*/,"
			+ "'pm' VARCHAR(100) DEFAULT NULL /*���Ա*/,"
			+ "'promote_start_time' TEXT DEFAULT NULL /*������ʼ����*/,"
			+ "'promote_end_time' TEXT DEFAULT NULL /*������������*/,"
			+ "'price_down_flag' INTEGER DEFAULT '0' /*�Ż�ֱ�� �������� 1���� 0������*/,"
			+ "'memb_owner' INTEGER DEFAULT '0' /*��Աר�� �������� 1���� 0����*/,"
			+ "'price_unit' VARCHAR(20) DEFAULT NULL /*�Ƽ۵�λ*/" + ")";

	public static final String ESLS_GUIDE_PRICE = "CREATE TABLE 'esls_guide_price' ("
			+ "'guide_id' INTEGER  PRIMARY KEY AUTOINCREMENT,"
			+ "'kind_id' INTEGER DEFAULT NULL,"
			+ "'guide_price' REAL(15,2) DEFAULT NULL,"
			+ "'descri' VARCHAR(200) DEFAULT NULL,"
			+ "'upd_time' TEXT DEFAULT NULL,"
			+ "'type' INTEGER DEFAULT NULL,"
			+ "'guide_state' INTEGER DEFAULT NULL,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL" + ") ";

	public static final String ESLS_KINDS = "CREATE TABLE 'esls_kinds' ("
			+ "'kind_id' INTEGER PRIMARY KEY AUTOINCREMENT /*����id*/,"
			+ "'kind_name' VARCHAR(50) DEFAULT NULL /*������*/,"
			+ "'father_id' INTEGER DEFAULT NULL /*������id*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/,"
			+ "'order_num' INTEGER DEFAULT '0' /*����*/"
			+ ") /*�������� С��1000  ���������1000��ʼ 1000���Զ���*/";

	public static final String ESLS_PATTERN = "CREATE TABLE 'esls_patterns' ("
			+ "'pattern_id' INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'pattern_name' VARCHAR(50) DEFAULT NULL,"
			+ "'pattern_width' INTEGER DEFAULT NULL,"
			+ "'pattern_height' INTEGER DEFAULT NULL,"
			+ "'inch' REAL(10,2) DEFAULT NULL," + "'bpp' INTEGER DEFAULT NULL,"
			+ "'model_id' INTEGER DEFAULT NULL,"
			+ "'model' VARCHAR(50) DEFAULT NULL," + "'code' TEXT,"
			+ "'image_url' VARCHAR(50) DEFAULT NULL," + "'image_examp' BLOB,"
			+ "'readme' VARCHAR(200) DEFAULT NULL,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL,"
			+ "'order_num' INTEGER DEFAULT '0'" + ")";

	public static final String ESLS_SHELFS = "CREATE TABLE 'esls_shelfs' ("
			+ "'shelf_id' INTEGER PRIMARY KEY AUTOINCREMENT /*����id*/,"
			+ "'area_id' INTEGER NOT NULL /*��������*/,"
			+ "'ap_id' INTEGER DEFAULT NULL /*����AP*/,"
			+ "'layer' INTEGER NOT NULL /*����*/,"
			+ "'rank' INTEGER NOT NULL /*����*/,"
			+ "'shelf_name' VARCHAR(50) DEFAULT NULL /*��������,�硰ˮ��-����ˮ����*/,"
			+ "'shelf_code' VARCHAR(10) DEFAULT NULL /*���ܱ�ţ�3λ�Զ��壩,��������λ�ñ���*/,"
			+ "'readme' VARCHAR(200) DEFAULT NULL /*����˵��*/,"
			+ "'remarks' VARCHAR(200) DEFAULT NULL /*��ע*/" + ")";

	public static final String ESLS_SYS_CONFIG = "CREATE TABLE 'esls_sys_config' ("
			+ "'id' INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'ctype' VARCHAR(255) DEFAULT NULL,"
			+ "'ckey' VARCHAR(100) DEFAULT NULL /*ֵ*/,"
			+ "'cvalue' VARCHAR(255) DEFAULT NULL /*vaule*/,"
			+ "'note' VARCHAR(255) DEFAULT NULL" + ")";

	public static final String ESLS_USERS = "CREATE TABLE 'esls_users' ("
			+ "'user_id' INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'guid' VARCHAR(40) NOT NULL DEFAULT '',"
			+ "'username' VARCHAR(50) DEFAULT NULL,"
			+ "'pw' VARCHAR(32) DEFAULT NULL," + "'role' INTEGER DEFAULT NULL"
			+ ")";

	public static final String MARKET_MODULE = "CREATE TABLE 'market_module' ("
			+ "'id' INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'name' VARCHAR(60) NOT NULL /*���� e��*/,"
			+ "'name_comment' VARCHAR(255) NOT NULL /*���ƽ���*/,"
			+ "'parent' INTEGER NOT NULL DEFAULT '0' /*��*/,"
			+ "'order' INTEGER  NOT NULL DEFAULT '0' /*����*/,"
			+ "'status' INTEGER NOT NULL DEFAULT '1' /*1 ��Ч 0��Ч*/" + ")";

	public static final String MARKET_MODULE_URL = "CREATE TABLE 'market_module_url' ("
			+ "'id' INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "'module' VARCHAR(30) NOT NULL /*ģ��*/,"
			+ "'url' VARCHAR(255) NOT NULL /*��ַ*/,"
			+ "'url_name' VARCHAR(255) NOT NULL /*���ƽ���*/,"
			+ "'is_menu' INTEGER NOT NULL DEFAULT '0' /*1,�˵� 0���ǲ˵�*/,"
			+ "'is_check' INTEGER NOT NULL DEFAULT '1' /*1,��飬0����*/,"
			+ "'status' INTEGER NOT NULL DEFAULT '1' /*1��Ч��0��Ч*/,"
			+ "'order' INTEGER DEFAULT '0' /*asc*/,"
			+ "UNIQUE ('module','url')" + ") ";

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ESLS_AP);
		db.execSQL(ESLS_CONFIG);
		db.execSQL(ESLS_DEVICE);
		db.execSQL(ESLS_ESL);
		db.execSQL(ESLS_ESL_DISP_HIS);
		db.execSQL(ESLS_ESL_MODEL);
		db.execSQL(ESLS_ESL_STATE_KIND);
		db.execSQL(ESLS_ESL_STATE_LOG);
		db.execSQL(ESLS_ESL_WORKLOG);
		db.execSQL(ESLS_GOOD_IMPORT);
		db.execSQL(ESLS_GOODS_UPDATE);
		db.execSQL(ESLS_GOODS);
		db.execSQL(ESLS_GUIDE_PRICE);
		db.execSQL(ESLS_KINDS);
		db.execSQL(ESLS_PATTERN);
		db.execSQL(ESLS_SHELFS);
		db.execSQL(ESLS_SYS_CONFIG);
		db.execSQL(ESLS_USERS);
		db.execSQL(MARKET_MODULE);
		db.execSQL(MARKET_MODULE_URL);
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
