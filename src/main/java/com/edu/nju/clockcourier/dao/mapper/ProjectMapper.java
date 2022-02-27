package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.ProjectPO;
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

import static com.edu.nju.clockcourier.dao.support.ProjectDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface ProjectMapper {

    BasicColumn[] selectList = BasicColumn.columnList(projectId, projectName, platform, language, description, homepageUrl, createTimestamp, updateTimestamp, latestReleasePublishTimestamp, latestReleaseNumber, repositoryId, repositoryUrl, licenses);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<ProjectPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ProjectPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "ProjectPOResult", value = {
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "project_name", property = "projectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "platform", property = "platform", jdbcType = JdbcType.VARCHAR),
            @Result(column = "language", property = "language", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "homepage_url", property = "homepageUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_timestamp", property = "createTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_timestamp", property = "updateTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "latest_release_publish_timestamp", property = "latestReleasePublishTimestamp", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "latest_release_number", property = "latestReleaseNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "repository_id", property = "repositoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "repository_url", property = "repositoryUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "licenses", property = "licenses", jdbcType = JdbcType.VARCHAR)
    })
    Optional<ProjectPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ProjectPOResult")
    List<ProjectPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, PROJECTS, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, PROJECTS, completer);
    }

    default int deleteByPrimaryKey(Integer projectId_) {
        return delete(c ->
                c.where(projectId, isEqualTo(projectId_))
        );
    }

    default int insert(ProjectPO record) {
        return MyBatis3Utils.insert(this::insert, record, PROJECTS, c ->
                c.map(projectId).toProperty("projectId")
                        .map(projectName).toProperty("projectName")
                        .map(platform).toProperty("platform")
                        .map(language).toProperty("language")
                        .map(description).toProperty("description")
                        .map(homepageUrl).toProperty("homepageUrl")
                        .map(createTimestamp).toProperty("createTimestamp")
                        .map(updateTimestamp).toProperty("updateTimestamp")
                        .map(latestReleasePublishTimestamp).toProperty("latestReleasePublishTimestamp")
                        .map(latestReleaseNumber).toProperty("latestReleaseNumber")
                        .map(repositoryId).toProperty("repositoryId")
                        .map(repositoryUrl).toProperty("repositoryUrl")
                        .map(licenses).toProperty("licenses")
        );
    }

    default int insertMultiple(Collection<ProjectPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, PROJECTS, c ->
                c.map(projectId).toProperty("projectId")
                        .map(projectName).toProperty("projectName")
                        .map(platform).toProperty("platform")
                        .map(language).toProperty("language")
                        .map(description).toProperty("description")
                        .map(homepageUrl).toProperty("homepageUrl")
                        .map(createTimestamp).toProperty("createTimestamp")
                        .map(updateTimestamp).toProperty("updateTimestamp")
                        .map(latestReleasePublishTimestamp).toProperty("latestReleasePublishTimestamp")
                        .map(latestReleaseNumber).toProperty("latestReleaseNumber")
                        .map(repositoryId).toProperty("repositoryId")
                        .map(repositoryUrl).toProperty("repositoryUrl")
                        .map(licenses).toProperty("licenses")
        );
    }

    default int insertSelective(ProjectPO record) {
        return MyBatis3Utils.insert(this::insert, record, PROJECTS, c ->
                c.map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(projectName).toPropertyWhenPresent("projectName", record::getProjectName)
                        .map(platform).toPropertyWhenPresent("platform", record::getPlatform)
                        .map(language).toPropertyWhenPresent("language", record::getLanguage)
                        .map(description).toPropertyWhenPresent("description", record::getDescription)
                        .map(homepageUrl).toPropertyWhenPresent("homepageUrl", record::getHomepageUrl)
                        .map(createTimestamp).toPropertyWhenPresent("createTimestamp", record::getCreateTimestamp)
                        .map(updateTimestamp).toPropertyWhenPresent("updateTimestamp", record::getUpdateTimestamp)
                        .map(latestReleasePublishTimestamp).toPropertyWhenPresent("latestReleasePublishTimestamp", record::getLatestReleasePublishTimestamp)
                        .map(latestReleaseNumber).toPropertyWhenPresent("latestReleaseNumber", record::getLatestReleaseNumber)
                        .map(repositoryId).toPropertyWhenPresent("repositoryId", record::getRepositoryId)
                        .map(repositoryUrl).toPropertyWhenPresent("repositoryUrl", record::getRepositoryUrl)
                        .map(licenses).toPropertyWhenPresent("licenses", record::getLicenses)
        );
    }

    default Optional<ProjectPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, PROJECTS, completer);
    }

    default List<ProjectPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, PROJECTS, completer);
    }

    default List<ProjectPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, PROJECTS, completer);
    }

    default Optional<ProjectPO> selectByPrimaryKey(Integer projectId_) {
        return selectOne(c ->
                c.where(projectId, isEqualTo(projectId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, PROJECTS, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(ProjectPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalTo(record::getProjectId)
                .set(projectName).equalTo(record::getProjectName)
                .set(platform).equalTo(record::getPlatform)
                .set(language).equalTo(record::getLanguage)
                .set(description).equalTo(record::getDescription)
                .set(homepageUrl).equalTo(record::getHomepageUrl)
                .set(createTimestamp).equalTo(record::getCreateTimestamp)
                .set(updateTimestamp).equalTo(record::getUpdateTimestamp)
                .set(latestReleasePublishTimestamp).equalTo(record::getLatestReleasePublishTimestamp)
                .set(latestReleaseNumber).equalTo(record::getLatestReleaseNumber)
                .set(repositoryId).equalTo(record::getRepositoryId)
                .set(repositoryUrl).equalTo(record::getRepositoryUrl)
                .set(licenses).equalTo(record::getLicenses);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(ProjectPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalToWhenPresent(record::getProjectId)
                .set(projectName).equalToWhenPresent(record::getProjectName)
                .set(platform).equalToWhenPresent(record::getPlatform)
                .set(language).equalToWhenPresent(record::getLanguage)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(homepageUrl).equalToWhenPresent(record::getHomepageUrl)
                .set(createTimestamp).equalToWhenPresent(record::getCreateTimestamp)
                .set(updateTimestamp).equalToWhenPresent(record::getUpdateTimestamp)
                .set(latestReleasePublishTimestamp).equalToWhenPresent(record::getLatestReleasePublishTimestamp)
                .set(latestReleaseNumber).equalToWhenPresent(record::getLatestReleaseNumber)
                .set(repositoryId).equalToWhenPresent(record::getRepositoryId)
                .set(repositoryUrl).equalToWhenPresent(record::getRepositoryUrl)
                .set(licenses).equalToWhenPresent(record::getLicenses);
    }

    default int updateByPrimaryKey(ProjectPO record) {
        return update(c ->
                c.set(projectName).equalTo(record::getProjectName)
                        .set(platform).equalTo(record::getPlatform)
                        .set(language).equalTo(record::getLanguage)
                        .set(description).equalTo(record::getDescription)
                        .set(homepageUrl).equalTo(record::getHomepageUrl)
                        .set(createTimestamp).equalTo(record::getCreateTimestamp)
                        .set(updateTimestamp).equalTo(record::getUpdateTimestamp)
                        .set(latestReleasePublishTimestamp).equalTo(record::getLatestReleasePublishTimestamp)
                        .set(latestReleaseNumber).equalTo(record::getLatestReleaseNumber)
                        .set(repositoryId).equalTo(record::getRepositoryId)
                        .set(repositoryUrl).equalTo(record::getRepositoryUrl)
                        .set(licenses).equalTo(record::getLicenses)
                        .where(projectId, isEqualTo(record::getProjectId))
        );
    }

    default int updateByPrimaryKeySelective(ProjectPO record) {
        return update(c ->
                c.set(projectName).equalToWhenPresent(record::getProjectName)
                        .set(platform).equalToWhenPresent(record::getPlatform)
                        .set(language).equalToWhenPresent(record::getLanguage)
                        .set(description).equalToWhenPresent(record::getDescription)
                        .set(homepageUrl).equalToWhenPresent(record::getHomepageUrl)
                        .set(createTimestamp).equalToWhenPresent(record::getCreateTimestamp)
                        .set(updateTimestamp).equalToWhenPresent(record::getUpdateTimestamp)
                        .set(latestReleasePublishTimestamp).equalToWhenPresent(record::getLatestReleasePublishTimestamp)
                        .set(latestReleaseNumber).equalToWhenPresent(record::getLatestReleaseNumber)
                        .set(repositoryId).equalToWhenPresent(record::getRepositoryId)
                        .set(repositoryUrl).equalToWhenPresent(record::getRepositoryUrl)
                        .set(licenses).equalToWhenPresent(record::getLicenses)
                        .where(projectId, isEqualTo(record::getProjectId))
        );
    }


}