--<ScriptOptions statementTerminator=";"/>

CREATE TABLE func (
	name CHAR(64) NOT NULL,
	ret BIT DEFAULT 0 NOT NULL,
	dl CHAR(128) NOT NULL,
	type ENUM NOT NULL,
	PRIMARY KEY (name)
) ENGINE=MyISAM;

CREATE TABLE innodb_table_stats (
	database_name VARCHAR(64) NOT NULL,
	table_name VARCHAR(64) NOT NULL,
	last_update TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	n_rows BIGINT UNSIGNED NOT NULL,
	clustered_index_size BIGINT UNSIGNED NOT NULL,
	sum_of_other_index_sizes BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (database_name,table_name)
) ENGINE=InnoDB;

CREATE TABLE ndb_binlog_index (
	Position BIGINT UNSIGNED NOT NULL,
	File VARCHAR(255) NOT NULL,
	epoch BIGINT UNSIGNED NOT NULL,
	inserts INTEGER UNSIGNED NOT NULL,
	updates INTEGER UNSIGNED NOT NULL,
	deletes INTEGER UNSIGNED NOT NULL,
	schemaops INTEGER UNSIGNED NOT NULL,
	orig_server_id INTEGER UNSIGNED NOT NULL,
	orig_epoch BIGINT UNSIGNED NOT NULL,
	gci INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (epoch,orig_server_id,orig_epoch)
) ENGINE=MyISAM;

CREATE TABLE help_keyword (
	help_keyword_id INTEGER UNSIGNED NOT NULL,
	name CHAR(64) NOT NULL,
	PRIMARY KEY (help_keyword_id)
) ENGINE=MyISAM;

CREATE TABLE proc (
	db CHAR(64) NOT NULL,
	name CHAR(64) NOT NULL,
	type ENUM NOT NULL,
	specific_name CHAR(64) NOT NULL,
	language ENUM DEFAULT SQL NOT NULL,
	sql_data_access ENUM DEFAULT CONTAINS_SQL NOT NULL,
	is_deterministic ENUM DEFAULT NO NOT NULL,
	security_type ENUM DEFAULT DEFINER NOT NULL,
	param_list BLOB NOT NULL,
	returns LONGBLOB NOT NULL,
	body LONGBLOB NOT NULL,
	definer CHAR(77) NOT NULL,
	created TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	modified TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
	sql_mode null NOT NULL,
	comment TEXT NOT NULL,
	character_set_client CHAR(32),
	collation_connection CHAR(32),
	db_collation CHAR(32),
	body_utf8 LONGBLOB,
	PRIMARY KEY (db,name,type)
) ENGINE=MyISAM;

CREATE TABLE columns_priv (
	Host CHAR(60) NOT NULL,
	Db CHAR(64) NOT NULL,
	User CHAR(16) NOT NULL,
	Table_name CHAR(64) NOT NULL,
	Column_name CHAR(64) NOT NULL,
	Timestamp TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	Column_priv null NOT NULL,
	PRIMARY KEY (Host,Db,User,Table_name,Column_name)
) ENGINE=MyISAM;

CREATE TABLE time_zone (
	Time_zone_id INTEGER UNSIGNED NOT NULL,
	Use_leap_seconds ENUM DEFAULT N NOT NULL,
	PRIMARY KEY (Time_zone_id)
) ENGINE=MyISAM;

CREATE TABLE tables_priv (
	Host CHAR(60) NOT NULL,
	Db CHAR(64) NOT NULL,
	User CHAR(16) NOT NULL,
	Table_name CHAR(64) NOT NULL,
	Grantor CHAR(77) NOT NULL,
	Timestamp TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	Table_priv null NOT NULL,
	Column_priv null NOT NULL,
	PRIMARY KEY (Host,Db,User,Table_name)
) ENGINE=MyISAM;

CREATE TABLE slave_worker_info (
	Id INTEGER UNSIGNED NOT NULL,
	Relay_log_name TEXT NOT NULL,
	Relay_log_pos BIGINT UNSIGNED NOT NULL,
	Master_log_name TEXT NOT NULL,
	Master_log_pos BIGINT UNSIGNED NOT NULL,
	Checkpoint_relay_log_name TEXT NOT NULL,
	Checkpoint_relay_log_pos BIGINT UNSIGNED NOT NULL,
	Checkpoint_master_log_name TEXT NOT NULL,
	Checkpoint_master_log_pos BIGINT UNSIGNED NOT NULL,
	Checkpoint_seqno INTEGER UNSIGNED NOT NULL,
	Checkpoint_group_size INTEGER UNSIGNED NOT NULL,
	Checkpoint_group_bitmap BLOB NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE time_zone_name (
	Name CHAR(64) NOT NULL,
	Time_zone_id INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (Name)
) ENGINE=MyISAM;

CREATE TABLE slave_master_info (
	Number_of_lines INTEGER UNSIGNED NOT NULL,
	Master_log_name TEXT NOT NULL,
	Master_log_pos BIGINT UNSIGNED NOT NULL,
	Host CHAR(64) NOT NULL,
	User_name TEXT,
	User_password TEXT,
	Port INTEGER UNSIGNED NOT NULL,
	Connect_retry INTEGER UNSIGNED NOT NULL,
	Enabled_ssl BIT NOT NULL,
	Ssl_ca TEXT,
	Ssl_capath TEXT,
	Ssl_cert TEXT,
	Ssl_cipher TEXT,
	Ssl_key TEXT,
	Ssl_verify_server_cert BIT NOT NULL,
	Heartbeat FLOAT NOT NULL,
	Bind TEXT,
	Ignored_server_ids TEXT,
	Uuid TEXT,
	Retry_count BIGINT UNSIGNED NOT NULL,
	Ssl_crl TEXT,
	Ssl_crlpath TEXT,
	Enabled_auto_position BIT NOT NULL,
	PRIMARY KEY (Host,Port)
) ENGINE=InnoDB;

CREATE TABLE slow_log (
	start_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	user_host MEDIUMTEXT NOT NULL,
	query_time TIME NOT NULL,
	lock_time TIME NOT NULL,
	rows_sent INT NOT NULL,
	rows_examined INT NOT NULL,
	db VARCHAR(512) NOT NULL,
	last_insert_id INT NOT NULL,
	insert_id INT NOT NULL,
	server_id INTEGER UNSIGNED NOT NULL,
	sql_text MEDIUMTEXT NOT NULL,
	thread_id BIGINT UNSIGNED NOT NULL
) ENGINE=CSV;

CREATE TABLE help_category (
	help_category_id SMALLINT UNSIGNED NOT NULL,
	name CHAR(64) NOT NULL,
	parent_category_id SMALLINT UNSIGNED,
	url TEXT NOT NULL,
	PRIMARY KEY (help_category_id)
) ENGINE=MyISAM;

CREATE TABLE db (
	Host CHAR(60) NOT NULL,
	Db CHAR(64) NOT NULL,
	User CHAR(16) NOT NULL,
	Select_priv ENUM DEFAULT N NOT NULL,
	Insert_priv ENUM DEFAULT N NOT NULL,
	Update_priv ENUM DEFAULT N NOT NULL,
	Delete_priv ENUM DEFAULT N NOT NULL,
	Create_priv ENUM DEFAULT N NOT NULL,
	Drop_priv ENUM DEFAULT N NOT NULL,
	Grant_priv ENUM DEFAULT N NOT NULL,
	References_priv ENUM DEFAULT N NOT NULL,
	Index_priv ENUM DEFAULT N NOT NULL,
	Alter_priv ENUM DEFAULT N NOT NULL,
	Create_tmp_table_priv ENUM DEFAULT N NOT NULL,
	Lock_tables_priv ENUM DEFAULT N NOT NULL,
	Create_view_priv ENUM DEFAULT N NOT NULL,
	Show_view_priv ENUM DEFAULT N NOT NULL,
	Create_routine_priv ENUM DEFAULT N NOT NULL,
	Alter_routine_priv ENUM DEFAULT N NOT NULL,
	Execute_priv ENUM DEFAULT N NOT NULL,
	Event_priv ENUM DEFAULT N NOT NULL,
	Trigger_priv ENUM DEFAULT N NOT NULL,
	PRIMARY KEY (Host,Db,User)
) ENGINE=MyISAM;

CREATE TABLE plugin (
	name VARCHAR(64) NOT NULL,
	dl VARCHAR(128) NOT NULL,
	PRIMARY KEY (name)
) ENGINE=MyISAM;

CREATE TABLE slave_relay_log_info (
	Number_of_lines INTEGER UNSIGNED NOT NULL,
	Relay_log_name TEXT NOT NULL,
	Relay_log_pos BIGINT UNSIGNED NOT NULL,
	Master_log_name TEXT NOT NULL,
	Master_log_pos BIGINT UNSIGNED NOT NULL,
	Sql_delay INT NOT NULL,
	Number_of_workers INTEGER UNSIGNED NOT NULL,
	Id INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE time_zone_transition_type (
	Time_zone_id INTEGER UNSIGNED NOT NULL,
	Transition_type_id INTEGER UNSIGNED NOT NULL,
	Offset INT DEFAULT 0 NOT NULL,
	Is_DST TINYINT UNSIGNED DEFAULT 0 NOT NULL,
	Abbreviation CHAR(8) NOT NULL,
	PRIMARY KEY (Time_zone_id,Transition_type_id)
) ENGINE=MyISAM;

CREATE TABLE servers (
	Server_name CHAR(64) NOT NULL,
	Host CHAR(64) NOT NULL,
	Db CHAR(64) NOT NULL,
	Username CHAR(64) NOT NULL,
	Password CHAR(64) NOT NULL,
	Port INT DEFAULT 0 NOT NULL,
	Socket CHAR(64) NOT NULL,
	Wrapper CHAR(64) NOT NULL,
	Owner CHAR(64) NOT NULL,
	PRIMARY KEY (Server_name)
) ENGINE=MyISAM;

CREATE TABLE time_zone_leap_second (
	Transition_time BIGINT NOT NULL,
	Correction INT NOT NULL,
	PRIMARY KEY (Transition_time)
) ENGINE=MyISAM;

CREATE TABLE innodb_index_stats (
	database_name VARCHAR(64) NOT NULL,
	table_name VARCHAR(64) NOT NULL,
	index_name VARCHAR(64) NOT NULL,
	last_update TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	stat_name VARCHAR(64) NOT NULL,
	stat_value BIGINT UNSIGNED NOT NULL,
	sample_size BIGINT UNSIGNED,
	stat_description VARCHAR(1024) NOT NULL,
	PRIMARY KEY (database_name,table_name,index_name,stat_name)
) ENGINE=InnoDB;

CREATE TABLE user (
	Host CHAR(60) NOT NULL,
	User CHAR(16) NOT NULL,
	Password CHAR(41) NOT NULL,
	Select_priv ENUM DEFAULT N NOT NULL,
	Insert_priv ENUM DEFAULT N NOT NULL,
	Update_priv ENUM DEFAULT N NOT NULL,
	Delete_priv ENUM DEFAULT N NOT NULL,
	Create_priv ENUM DEFAULT N NOT NULL,
	Drop_priv ENUM DEFAULT N NOT NULL,
	Reload_priv ENUM DEFAULT N NOT NULL,
	Shutdown_priv ENUM DEFAULT N NOT NULL,
	Process_priv ENUM DEFAULT N NOT NULL,
	File_priv ENUM DEFAULT N NOT NULL,
	Grant_priv ENUM DEFAULT N NOT NULL,
	References_priv ENUM DEFAULT N NOT NULL,
	Index_priv ENUM DEFAULT N NOT NULL,
	Alter_priv ENUM DEFAULT N NOT NULL,
	Show_db_priv ENUM DEFAULT N NOT NULL,
	Super_priv ENUM DEFAULT N NOT NULL,
	Create_tmp_table_priv ENUM DEFAULT N NOT NULL,
	Lock_tables_priv ENUM DEFAULT N NOT NULL,
	Execute_priv ENUM DEFAULT N NOT NULL,
	Repl_slave_priv ENUM DEFAULT N NOT NULL,
	Repl_client_priv ENUM DEFAULT N NOT NULL,
	Create_view_priv ENUM DEFAULT N NOT NULL,
	Show_view_priv ENUM DEFAULT N NOT NULL,
	Create_routine_priv ENUM DEFAULT N NOT NULL,
	Alter_routine_priv ENUM DEFAULT N NOT NULL,
	Create_user_priv ENUM DEFAULT N NOT NULL,
	Event_priv ENUM DEFAULT N NOT NULL,
	Trigger_priv ENUM DEFAULT N NOT NULL,
	Create_tablespace_priv ENUM DEFAULT N NOT NULL,
	ssl_type ENUM NOT NULL,
	ssl_cipher BLOB NOT NULL,
	x509_issuer BLOB NOT NULL,
	x509_subject BLOB NOT NULL,
	max_questions INTEGER UNSIGNED DEFAULT 0 NOT NULL,
	max_updates INTEGER UNSIGNED DEFAULT 0 NOT NULL,
	max_connections INTEGER UNSIGNED DEFAULT 0 NOT NULL,
	max_user_connections INTEGER UNSIGNED DEFAULT 0 NOT NULL,
	plugin CHAR(64),
	authentication_string TEXT,
	password_expired ENUM DEFAULT N NOT NULL,
	PRIMARY KEY (Host,User)
) ENGINE=MyISAM;

CREATE TABLE event (
	db CHAR(64) NOT NULL,
	name CHAR(64) NOT NULL,
	body LONGBLOB NOT NULL,
	definer CHAR(77) NOT NULL,
	execute_at DATETIME,
	interval_value INT,
	interval_field ENUM,
	created TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	modified TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
	last_executed DATETIME,
	starts DATETIME,
	ends DATETIME,
	status ENUM DEFAULT ENABLED NOT NULL,
	on_completion ENUM DEFAULT DROP NOT NULL,
	sql_mode null NOT NULL,
	comment CHAR(64) NOT NULL,
	originator INTEGER UNSIGNED NOT NULL,
	time_zone CHAR(64) DEFAULT SYSTEM NOT NULL,
	character_set_client CHAR(32),
	collation_connection CHAR(32),
	db_collation CHAR(32),
	body_utf8 LONGBLOB,
	PRIMARY KEY (db,name)
) ENGINE=MyISAM;

CREATE TABLE general_log (
	event_time TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	user_host MEDIUMTEXT NOT NULL,
	thread_id BIGINT UNSIGNED NOT NULL,
	server_id INTEGER UNSIGNED NOT NULL,
	command_type VARCHAR(64) NOT NULL,
	argument MEDIUMTEXT NOT NULL
) ENGINE=CSV;

CREATE TABLE help_relation (
	help_topic_id INTEGER UNSIGNED NOT NULL,
	help_keyword_id INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (help_keyword_id,help_topic_id)
) ENGINE=MyISAM;

CREATE TABLE time_zone_transition (
	Time_zone_id INTEGER UNSIGNED NOT NULL,
	Transition_time BIGINT NOT NULL,
	Transition_type_id INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (Time_zone_id,Transition_time)
) ENGINE=MyISAM;

CREATE TABLE proxies_priv (
	Host CHAR(60) NOT NULL,
	User CHAR(16) NOT NULL,
	Proxied_host CHAR(60) NOT NULL,
	Proxied_user CHAR(16) NOT NULL,
	With_grant BIT DEFAULT 0 NOT NULL,
	Grantor CHAR(77) NOT NULL,
	Timestamp TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (Host,User,Proxied_host,Proxied_user)
) ENGINE=MyISAM;

CREATE TABLE help_topic (
	help_topic_id INTEGER UNSIGNED NOT NULL,
	name CHAR(64) NOT NULL,
	help_category_id SMALLINT UNSIGNED NOT NULL,
	description TEXT NOT NULL,
	example TEXT NOT NULL,
	url TEXT NOT NULL,
	PRIMARY KEY (help_topic_id)
) ENGINE=MyISAM;

CREATE TABLE procs_priv (
	Host CHAR(60) NOT NULL,
	Db CHAR(64) NOT NULL,
	User CHAR(16) NOT NULL,
	Routine_name CHAR(64) NOT NULL,
	Routine_type ENUM NOT NULL,
	Grantor CHAR(77) NOT NULL,
	Proc_priv null NOT NULL,
	Timestamp TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (Host,Db,User,Routine_name,Routine_type)
) ENGINE=MyISAM;

CREATE TABLE example_innodb (
	id INT,
	data VARCHAR(100)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX name ON help_category (name ASC);

CREATE UNIQUE INDEX name ON help_topic (name ASC);

CREATE INDEX Grantor ON tables_priv (Grantor ASC);

CREATE INDEX Grantor ON procs_priv (Grantor ASC);

CREATE INDEX Grantor ON proxies_priv (Grantor ASC);

CREATE UNIQUE INDEX name ON help_keyword (name ASC);

CREATE INDEX User ON db (User ASC);

