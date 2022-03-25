# Schema v2

数据库格式定义.

数据库字符集为 utf8, collate 为 utf8_bin.

## Entity

### projects

| name | type | description |
| :---: | :---: | :---: |
| `project_id` | integer | 项目的唯一编号 |
| `project_name` | varchar(128) | 项目的名称 |
| `platform` | varchar(32) | 项目所属的库文件管理平台 |
| `language` | varchar(32) | 项目采用的编程语言 |
| `description` | varchar(1024) | 项目描述信息 |
| `homepage_url` | varchar(1024) | 项目地址 |
| `create_timestamp` | timestamp | 初次收集该项目数据的时间戳 |
| `update_timestamp` | timestamp | 更新该项目数据的时间戳 |
| `latest_release_publish_timestamp` | timestamp | 最新版本发布的时间戳 |
| `latest_release_number` | varchar(16) | 最新版本对应的版本号 |
| `repository_id` | integer | 项目所属代码仓库的编号 |
| `repository_url` | varchar(1024) | 项目所属代码仓库的地址 |
| `licenses` | varchar(32) | 许可证 |

key: `project_id`.

### mvn_projects

| name | type | description |
| :---: | :---: | :---: |
| `project_id` | integer | 项目的唯一编号, 和 projects 表中 id 独立, 如果需要对应的话再说 |
| `version` | varchar(64) | 项目版本 |
| `group_id` | varchar(128) | mvn 项目 groupId |
| `artifact_id` | integer(128) | mvn 项目 artifactId |
| `name` | varchar(128) | 项目名称 |
| `url` | varchar(1024) | 项目路径 |
| `description` | varchar(8192) | 项目描述信息 |

key: (`project_id`, `version`).

### mvn_libs

对应在 mvn 中央仓库有链接的第三方库的集合.

| name | type | description |
| :---: | :---: | :---: |
| `lib_id` | integer | lib 的唯一编号 |
| `group_id` | varchar(128) | mvn groupId |
| `artifact_id` | integer(128) | mvn artifactId |

key: `lib_id`.

### repositories

| name | type | description |
| :---: | :---: | :---: |
| `repository_id` | integer | 仓库的唯一编号 |
| `host_type` | varchar(128) | 仓库所属托管平台名称 |
| `repository_name` | varchar(128) | 仓库名称 |
| `repository_owner` | varchar(64) | 仓库所有者 |
| `language` | varchar(32) | 采用的编程语言 |
| `decription` | varchar(1024) | 仓库描述信息 |
| `homepage_url` | varchar(1024) | 仓库地址 |
| `create_timestamp` | timestamp | 初次收集该仓库数据的时间戳 |
| `update_timestamp` | timestamp | 更新该仓库数据的时间戳 |
| `latest_push_timestamp` | timestamp | 最后一次进行 push 操作的时间戳 |
| `fork` | boolean | 是否能进行 fork 操作 |
| `fork_count` | integer | fork 数量 |
| `watcher_count` | integer | watcher 数量 |
| `star_count` | integer | star 数量 |
| `contributor_count` | integer | contributor 数量 |
| `open_issue_count` | integer | 开放的 issue 数量 |
| `default_branch` | varchar(16) | 默认分支 |
| `licenses` | varchar(32) | 许可证 |

## Relationship

### mvn_dependencies

| name | type | description |
| :---: | :---: | :---: |
| `project_id` | integer | 项目的唯一编号 |
| `version` | varchar(64) | 项目版本 |
| `lib_id` | integer | 对应依赖的唯一编号 |
| `lib_version` | varchar(64) | 依赖的版本 |

key: (`project_id`, `version`, `lib_id`).

### migration_rules

| name | type | description |
| :---: | :---: | :---: |
| `from_id` | integer | 从某个库迁移出, 这个库的 id, 对应 `mvn_lib` 表的 id |
| `to_id` | integer | 迁移到某个库, 这个库的 id |
| `confidence` | double | 置信度 |
| `project_id` | integer | 有这种迁移关系的库的 id |
| `version` | varchar(64) | 有这种迁移关系的库的 version |

key: (`from_id`, `to_id`, `project_id`, `version`).


### project_dependencies

| name | type | description |
| :---: | :---: | :---: |
| `dependency_id` | integer | 依赖的唯一编号 |
| `project_id` | integer | 项目的唯一编号 |
| `project_name` | varchar(128) | 项目的名称 |
| `platform` | varchar(32) | 项目所属的库文件管理平台 |
| `project_version` | varchar(16) | 项目版本号 |
| `dependency_project_id` | integer | 依赖的项目编号 |
| `dependency_project_name` | varchar(128) | 依赖的项目名称 |
| `dependency_project_platform` | varchar(32) | 依赖的项目所属库文件管理平台 |
| `dependency_requirements` | varchar(16) | 依赖的项目版本要求 |
| `dependency_type` | varchar(16) | 依赖类型 |

### repository_dependencies

| name | type | description |
| :---: | :---: | :---: |
| `dependency_id` | integer | 依赖的唯一编号 |
| `repository_id` | integer | 仓库的唯一编号 |
| `repository_name` | varchar(128) | 仓库名称 |
| `repository_owner` | varchar(32) | 仓库所有者 |
| `host_type` | varchar(32) | 仓库所属托管平台名称 |
| `dependency_project_id` | integer | 依赖的项目编号 |
| `dependency_project_name` | varchar(128) | 依赖的项目名称 |
| `dependency_requirements` | varchar(16) | 依赖的项目版本要求 |
| `dependency_type` | varchar(16) | 依赖类型 |

