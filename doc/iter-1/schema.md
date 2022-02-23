# Schema

数据库格式定义.

由于数据集不怎么可靠, 所以除了主键之外都不是 not null.

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
| `dependency_type` | varchar(16) | 依赖类型: runtime, build, test, development |

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
| `dependency_type` | varchar(16) | 依赖类型: runtime, build, test, development |

