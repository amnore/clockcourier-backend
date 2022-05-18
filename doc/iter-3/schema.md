# Schema v3

数据库格式定义. 只列出在迭代三中有效的库定义.

数据库字符集为 utf8mb4, collate 为 utf8mb4_bin.

## Entity

### mvn_projects

| name | type | description |
| :---: | :---: | :---: |
| `project_id` | integer | mvn 项目的唯一编号 |
| `name` | varchar(1024) | 项目名称 |
| `url` | varchar(1024) | 项目路径, github |

key: `project_id`.

indexes: `[project_id]`.

### mvn_libs

对应在 mvn 中央仓库有链接的第三方库的集合.

| name | type | description |
| :---: | :---: | :---: |
| `lib_id` | integer | mvn lib 的唯一编号 |
| `group_id` | varchar(128) | mvn groupId |
| `artifact_id` | varchar(128) | mvn artifactId |
| `mvn_ctr_url` | varchar(1024) | mvn 中央仓库地址 |
| `github_url` | varchar(1024) | github 地址 |
| `description` | varchar(8192) | lib 描述信息 |

key: `lib_id`.

indexes: `[lib_id, (group_id, artifact_id)]`.

## Relationship

### migration_rules

计算出的 mvn_libs 之间的迁移规则.

| name | type | description |
| :---: | :---: | :---: |
| `rule_id` | integer | 迁移规则的唯一编号 |
| `from_id` | integer | 从某个库迁移出, 这个库的 id, 对应 `mvn_lib` 表的 id |
| `to_id` | integer | 迁移到某个库, 这个库的 id |
| `confidence` | double | 置信度 |
| `rule_sup` | double | 规则支持度 |
| `msg_sup` | double | 消息支持度 |
| `dis_sup` | double | 距离支持度 |
| `api_sup` | double | API 支持度 |

key: `rule_id`.

indexes: `[rule_id, (from_id, to_id)]`.

### rule_instances

迁移规则的实例.

| name | type | description |
| :---: | :---: | :---: |
| `rule_id` | integer | 迁移规则的唯一编号 |
| `project_id` | integer | 计算该迁移规则的信息来源于某些 mvn_projects |
| `file_name` | varchar(256) | 修改的文件名 |
| `start_commit_link` | varchar(1024) | 开始 commit 链接 |
| `end_commit_link` | varchar(1024) | 结束 commit 链接 |

key: (`rule_id`, `project_id`, `file_name`).

indexes: `[rule_id]`.
