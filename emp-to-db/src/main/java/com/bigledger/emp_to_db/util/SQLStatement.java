package com.bigledger.emp_to_db.util;

public class SQLStatement {

	public static class TableEmpAuditQueries {

		public static final String GetSQLSelectAll() {

			String sql = "SELECT * FROM " + EntityReference.TableEmpAudit.TABLE_NAME;
			return sql;
		}

		public static final String GetSQLSelectByGuidAndPkid( String tableName, String guid, Integer pkid) {

			String sql = "SELECT * FROM " + tableName + " WHERE guid = '" + guid + "' AND pkid = " + pkid ;
			return sql;
		}
	}

	public static class TableAppMessageEventQueries {

		public static final String GetInsertSQL() {

			String sql = "INSERT INTO app_message_event ( doc_json, guid, local_created_time, local_deleted_time, local_login_guid, local_message_time,"
					+ " local_status, local_updated_time, message_store_guid, priority, remarks, remote_created_time, remote_device_id, remote_doc_id,"
					+ " remote_message_guid, remote_user_guid, remote_user_id, status, trigger_key, type)"
					+ " VALUES ( ?::json, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			return sql;
		}
	}

	public static class TableAppMessageStoreQueries {

		public static final String GetInsertSQL() {

			String sql = "INSERT INTO app_message_event ( doc_json, guid, local_created_time, local_deleted_time, local_login_guid, local_message_time,"
					+ " local_status, local_updated_time, priority, remarks, remote_created_time, remote_device_id, remote_doc_id,"
					+ " remote_message_guid, remote_user_guid, remote_user_id, status, trigger_key, type )"
					+ " VALUES ( cast(? as json), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			return sql;
		}
	}
}
