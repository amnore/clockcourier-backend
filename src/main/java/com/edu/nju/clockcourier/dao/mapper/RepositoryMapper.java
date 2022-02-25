package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.RepositoryPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.processing.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.RepositoryDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface RepositoryMapper {

    BasicColumn[] selectList = BasicColumn.columnList(repositoryId, hostType, repositoryName, repositoryOwner, language, description, homepageUrl, createTimestamp, updateTimestamp, latestPushTimestamp, fork, forkCount, watcherCount, starCount, contributorCount, openIssueCount, defaultBranch, licenses);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<RepositoryPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RepositoryPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "RepositoryPOResult", value = {
            @Result(column = "repository_id", property = "repositoryId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "host_type", property = "hostType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "repository_name", property = "repositoryName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "repository_owner", property = "repositoryOwner", jdbcType = JdbcType.VARCHAR),
            @Result(column = "language", property = "language", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "homepage_url", property = "homepageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_timestamp", property = "updateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "latest_push_timestamp", property = "latestPushTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "fork", property = "fork", jdbcType = JdbcType.INTEGER),
            @Result(column = "fork_count", property = "forkCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "watcher_count", property = "watcherCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "star_count", property = "starCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "contributor_count", property = "contributorCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "open_issue_count", property = "openIssueCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "default_branch", property = "defaultBranch", jdbcType = JdbcType.VARCHAR),
            @Result(column = "licenses", property = "licenses", jdbcType = JdbcType.VARCHAR)
    })
    Optional<RepositoryPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("RepositoryPOResult")
    List<RepositoryPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, repositoryPO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, repositoryPO, completer);
    }

    default int deleteByPrimaryKey(Integer repositoryId_) {
        return delete(c ->
                c.where(repositoryId, isEqualTo(repositoryId_))
        );
    }

    default int insert(RepositoryPO record) {
        return MyBatis3Utils.insert(this::insert, record, repositoryPO, c ->
                c.map(repositoryId).toProperty("repositoryId")
                        .map(hostType).toProperty("hostType")
                        .map(repositoryName).toProperty("repositoryName")
                        .map(repositoryOwner).toProperty("repositoryOwner")
                        .map(language).toProperty("language")
                        .map(description).toProperty("description")
                        .map(homepageUrl).toProperty("homepageUrl")
                        .map(createTimestamp).toProperty("createTimestamp")
                        .map(updateTimestamp).toProperty("updateTimestamp")
                        .map(latestPushTimestamp).toProperty("latestPushTimestamp")
                        .map(fork).toProperty("fork")
                        .map(forkCount).toProperty("forkCount")
                        .map(watcherCount).toProperty("watcherCount")
                        .map(starCount).toProperty("starCount")
                        .map(contributorCount).toProperty("contributorCount")
                        .map(openIssueCount).toProperty("openIssueCount")
                        .map(defaultBranch).toProperty("defaultBranch")
                        .map(licenses).toProperty("licenses")
        );
    }

    default int insertMultiple(Collection<RepositoryPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, repositoryPO, c ->
                c.map(repositoryId).toProperty("repositoryId")
                        .map(hostType).toProperty("hostType")
                        .map(repositoryName).toProperty("repositoryName")
                        .map(repositoryOwner).toProperty("repositoryOwner")
                        .map(language).toProperty("language")
                        .map(description).toProperty("description")
                        .map(homepageUrl).toProperty("homepageUrl")
                        .map(createTimestamp).toProperty("createTimestamp")
                        .map(updateTimestamp).toProperty("updateTimestamp")
                        .map(latestPushTimestamp).toProperty("latestPushTimestamp")
                        .map(fork).toProperty("fork")
                        .map(forkCount).toProperty("forkCount")
                        .map(watcherCount).toProperty("watcherCount")
                        .map(starCount).toProperty("starCount")
                        .map(contributorCount).toProperty("contributorCount")
                        .map(openIssueCount).toProperty("openIssueCount")
                        .map(defaultBranch).toProperty("defaultBranch")
                        .map(licenses).toProperty("licenses")
        );
    }

    default int insertSelective(RepositoryPO record) {
        return MyBatis3Utils.insert(this::insert, record, repositoryPO, c ->
                c.map(repositoryId).toPropertyWhenPresent("repositoryId", record::getRepositoryId)
                        .map(hostType).toPropertyWhenPresent("hostType", record::getHostType)
                        .map(repositoryName).toPropertyWhenPresent("repositoryName", record::getRepositoryName)
                        .map(repositoryOwner).toPropertyWhenPresent("repositoryOwner", record::getRepositoryOwner)
                        .map(language).toPropertyWhenPresent("language", record::getLanguage)
                        .map(description).toPropertyWhenPresent("description", record::getDescription)
                        .map(homepageUrl).toPropertyWhenPresent("homepageUrl", record::getHomepageUrl)
                        .map(createTimestamp).toPropertyWhenPresent("createTimestamp", record::getCreateTimestamp)
                        .map(updateTimestamp).toPropertyWhenPresent("updateTimestamp", record::getUpdateTimestamp)
                        .map(latestPushTimestamp).toPropertyWhenPresent("latestPushTimestamp", record::getLatestPushTimestamp)
                        .map(fork).toPropertyWhenPresent("fork", record::getFork)
                        .map(forkCount).toPropertyWhenPresent("forkCount", record::getForkCount)
                        .map(watcherCount).toPropertyWhenPresent("watcherCount", record::getWatcherCount)
                        .map(starCount).toPropertyWhenPresent("starCount", record::getStarCount)
                        .map(contributorCount).toPropertyWhenPresent("contributorCount", record::getContributorCount)
                        .map(openIssueCount).toPropertyWhenPresent("openIssueCount", record::getOpenIssueCount)
                        .map(defaultBranch).toPropertyWhenPresent("defaultBranch", record::getDefaultBranch)
                        .map(licenses).toPropertyWhenPresent("licenses", record::getLicenses)
        );
    }

    default Optional<RepositoryPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, repositoryPO, completer);
    }

    default List<RepositoryPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, repositoryPO, completer);
    }

    default List<RepositoryPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, repositoryPO, completer);
    }

    default Optional<RepositoryPO> selectByPrimaryKey(Integer repositoryId_) {
        return selectOne(c ->
                c.where(repositoryId, isEqualTo(repositoryId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, repositoryPO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(RepositoryPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(repositoryId).equalTo(record::getRepositoryId)
                .set(hostType).equalTo(record::getHostType)
                .set(repositoryName).equalTo(record::getRepositoryName)
                .set(repositoryOwner).equalTo(record::getRepositoryOwner)
                .set(language).equalTo(record::getLanguage)
                .set(description).equalTo(record::getDescription)
                .set(homepageUrl).equalTo(record::getHomepageUrl)
                .set(createTimestamp).equalTo(record::getCreateTimestamp)
                .set(updateTimestamp).equalTo(record::getUpdateTimestamp)
                .set(latestPushTimestamp).equalTo(record::getLatestPushTimestamp)
                .set(fork).equalTo(record::getFork)
                .set(forkCount).equalTo(record::getForkCount)
                .set(watcherCount).equalTo(record::getWatcherCount)
                .set(starCount).equalTo(record::getStarCount)
                .set(contributorCount).equalTo(record::getContributorCount)
                .set(openIssueCount).equalTo(record::getOpenIssueCount)
                .set(defaultBranch).equalTo(record::getDefaultBranch)
                .set(licenses).equalTo(record::getLicenses);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(RepositoryPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(repositoryId).equalToWhenPresent(record::getRepositoryId)
                .set(hostType).equalToWhenPresent(record::getHostType)
                .set(repositoryName).equalToWhenPresent(record::getRepositoryName)
                .set(repositoryOwner).equalToWhenPresent(record::getRepositoryOwner)
                .set(language).equalToWhenPresent(record::getLanguage)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(homepageUrl).equalToWhenPresent(record::getHomepageUrl)
                .set(createTimestamp).equalToWhenPresent(record::getCreateTimestamp)
                .set(updateTimestamp).equalToWhenPresent(record::getUpdateTimestamp)
                .set(latestPushTimestamp).equalToWhenPresent(record::getLatestPushTimestamp)
                .set(fork).equalToWhenPresent(record::getFork)
                .set(forkCount).equalToWhenPresent(record::getForkCount)
                .set(watcherCount).equalToWhenPresent(record::getWatcherCount)
                .set(starCount).equalToWhenPresent(record::getStarCount)
                .set(contributorCount).equalToWhenPresent(record::getContributorCount)
                .set(openIssueCount).equalToWhenPresent(record::getOpenIssueCount)
                .set(defaultBranch).equalToWhenPresent(record::getDefaultBranch)
                .set(licenses).equalToWhenPresent(record::getLicenses);
    }

    default int updateByPrimaryKey(RepositoryPO record) {
        return update(c ->
                c.set(hostType).equalTo(record::getHostType)
                        .set(repositoryName).equalTo(record::getRepositoryName)
                        .set(repositoryOwner).equalTo(record::getRepositoryOwner)
                        .set(language).equalTo(record::getLanguage)
                        .set(description).equalTo(record::getDescription)
                        .set(homepageUrl).equalTo(record::getHomepageUrl)
                        .set(createTimestamp).equalTo(record::getCreateTimestamp)
                        .set(updateTimestamp).equalTo(record::getUpdateTimestamp)
                        .set(latestPushTimestamp).equalTo(record::getLatestPushTimestamp)
                        .set(fork).equalTo(record::getFork)
                        .set(forkCount).equalTo(record::getForkCount)
                        .set(watcherCount).equalTo(record::getWatcherCount)
                        .set(starCount).equalTo(record::getStarCount)
                        .set(contributorCount).equalTo(record::getContributorCount)
                        .set(openIssueCount).equalTo(record::getOpenIssueCount)
                        .set(defaultBranch).equalTo(record::getDefaultBranch)
                        .set(licenses).equalTo(record::getLicenses)
                        .where(repositoryId, isEqualTo(record::getRepositoryId))
        );
    }

    default int updateByPrimaryKeySelective(RepositoryPO record) {
        return update(c ->
                c.set(hostType).equalToWhenPresent(record::getHostType)
                        .set(repositoryName).equalToWhenPresent(record::getRepositoryName)
                        .set(repositoryOwner).equalToWhenPresent(record::getRepositoryOwner)
                        .set(language).equalToWhenPresent(record::getLanguage)
                        .set(description).equalToWhenPresent(record::getDescription)
                        .set(homepageUrl).equalToWhenPresent(record::getHomepageUrl)
                        .set(createTimestamp).equalToWhenPresent(record::getCreateTimestamp)
                        .set(updateTimestamp).equalToWhenPresent(record::getUpdateTimestamp)
                        .set(latestPushTimestamp).equalToWhenPresent(record::getLatestPushTimestamp)
                        .set(fork).equalToWhenPresent(record::getFork)
                        .set(forkCount).equalToWhenPresent(record::getForkCount)
                        .set(watcherCount).equalToWhenPresent(record::getWatcherCount)
                        .set(starCount).equalToWhenPresent(record::getStarCount)
                        .set(contributorCount).equalToWhenPresent(record::getContributorCount)
                        .set(openIssueCount).equalToWhenPresent(record::getOpenIssueCount)
                        .set(defaultBranch).equalToWhenPresent(record::getDefaultBranch)
                        .set(licenses).equalToWhenPresent(record::getLicenses)
                        .where(repositoryId, isEqualTo(record::getRepositoryId))
        );
    }

}