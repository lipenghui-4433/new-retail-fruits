package cn.dingdong.constant;

/**
 * @Auther: liyk8
 * @Date: 2018/12/11 14:41
 * @Description:枚举类
 */
public class ENUM {

	/**
	 * 应用状态
	 */
	public enum ApplicationStatus {
		// 未审核
		UNAUDIT(0),

		// 正常已审核
		AUDIT(1);

		private Integer status;

		ApplicationStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}

	}

	public enum DataSourceType {
		/**
		 * 文件上传
		 */
		FILE("file"),

		/**
		 * mysql数据源
		 */
		MYSQL("mysql"),

		/**
		 * MongoDB数据源
		 */
		MONGODB("mongodb"),

		/**
		 * 爬虫数据源
		 */
		CRAWL("crawl"),

		/**
		 * kafka数据源
		 */
		KAFKA("kafka");

		private String type;

		DataSourceType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	/**
	 * 数据源状态
	 */
	public enum DataSourceStatus {
		// 未开始同步，可修改状态
		INIT(0),

		// 正常状态，不允许修改
		NORMAL(1),

		// 爬虫工作中
		SCRAWLING(2),

		// 数据库同步中
		MYSQL(3),

		// kafka初始化中
		MESSAGE(4),

		// MongoDB同步中
		MONGODB(5);
		private Integer status;

		DataSourceStatus(Integer status) {
			this.status = status;
		}

		public Integer getStatus() {
			return status;
		}
	}

	public enum SynchronzieType {

		/**
		 * 文件上传
		 */
		FILEUPLOAD("fileUpload"),

		/**
		 * 爬虫获取
		 */
		CRAWL("crawl"),

		/**
		 * kafka消息
		 */
		KAKFA("kafka"),

		/**
		 * 全量更新
		 */
		ONCEAll("onceAll"),

		/**
		 * 增量更新
		 */
		INCREASEUPDATE("increaseUpdate"),

		/**
		 * 全量及增量更新
		 */
		ALLUPDATE("allUpdate");

		private String type;

		SynchronzieType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	/**
	 * 同步执行状态
	 */
	public enum SyncExecStatus {
		/**
		 * 执行中
		 */
		EXECUTING(0),

		SUCCESS(1),

		FAIL(2);

		private int status;

		SyncExecStatus(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}
	}

	/**
	 * 语言
	 */
	public enum Language {
		JAPANESE("jp"),

		CHINESE("cn");

		private String abbreviate;

		Language(String abbreviate) {
			this.abbreviate = abbreviate;
		}

		public String getAbbreviate() {
			return abbreviate;
		}
	}

	/**
	 * 操作状态
	 */
	public enum OperateStatus {
		NEWADD(1),

		WAITUPDATE(2),

		WAITDELETE(3),

		UPDATED(4);

		private int status;

		OperateStatus(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}
	}

	/**
	 * 发布状态
	 */
	public enum PublishStatus {
		WAITPUBLISH(1),

		PUBLISHING(2),

		PUBLISHED(3),

		PUBLISHFAIL(4);

		private int status;

		PublishStatus(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}
	}

	/**
	 * 发布任务类型
	 */
	public enum PublishTaskType{
		CATEGORY("category"),

		FILTER("filter");

		private String type;

		PublishTaskType(String type){
			this.type = type;
		}
		public String getType(){
			return type;
		}
	}

}
