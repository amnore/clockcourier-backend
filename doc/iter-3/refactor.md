# 迭代三重构记录

| 执行者 | 时间 |
| :---: | :---: |
| 侯为栋 | 2022-05-18 |

由于迭代一二和迭代三的差别实在是太大, 为了保证测试的覆盖率, 我们决定对代码进行大规模重构.

我们使用 git 作为版本管理工具, 所以如果条件必要, 我们可以很方便地回滚.

## 删减/修改 api

- 所有 project, repository 相关全部删减
- 将所有 `/project/mvn/lib` 开头的 api 改为 `/library/mvn` 开头
- 删除所有 mvn project 的 api
- 增加 rule 相关 api

## 删减/修改逻辑

### 迭代一

- project 相关
- repository 相关

### 迭代二

- mvn_dependency 相关
- mvn_project 相关

## 删减/修改测试

全部删除, 迭代三单独进行单元测试和集成测试.

## 具体修改

| package | description |
| :---: | :---: |
| config | 无 |
| constant | ProjSortRule, RepoSortRule |
| controller | ProjectController, RepositoryController |
| dao | `/^(Proj|Repo)\w*$/gi` |
| dto | `/^(Proj|Repo)\w*DTO$/gi` |
| exception | 无 |
| po | `/^(Proj|Repo)\w*PO$/gi` |
| service | `/^(Proj|Repo)\w*Service(Impl)?$/gi` |
| task | 全部删除 |
| util | 原 PomUtil 删除, PomAnalyseUtil 改名为 PomUtil |
| vo | `/^(Proj|Repo)\w*VO$/gi` |
