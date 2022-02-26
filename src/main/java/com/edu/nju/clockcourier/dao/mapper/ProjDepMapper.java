package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.ProjectDependencyPO;
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

import static com.edu.nju.clockcourier.dao.support.ProjDepDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface ProjDepMapper {

    BasicColumn[] selectList = BasicColumn.columnList(dependencyId, projectId, projectName, platform, projectVersion, dependencyProjectId, dependencyProjectName, dependencyProjectPlatform, dependencyRequirements, dependencyType);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<ProjectDependencyPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ProjectDependencyPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "ProjectDependencyPOResult", value = {
            @Result(column = "dependency_id", property = "dependencyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "project_name", property = "projectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "platform", property = "platform", jdbcType = JdbcType.VARCHAR),
            @Result(column = "project_version", property = "projectVersion", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_project_id", property = "dependencyProjectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "dependency_project_name", property = "dependencyProjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_project_platform", property = "dependencyProjectPlatform", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_requirements", property = "dependencyRequirements", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_type", property = "dependencyType", jdbcType = JdbcType.VARCHAR)
    })
    Optional<ProjectDependencyPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ProjectDependencyPOResult")
    List<ProjectDependencyPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, PROJECT_DEPENDENCIES, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, PROJECT_DEPENDENCIES, completer);
    }

    default int deleteByPrimaryKey(Integer dependencyId_) {
        return delete(c ->
                c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    default int insert(ProjectDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, PROJECT_DEPENDENCIES, c ->
                c.map(dependencyId).toProperty("dependencyId")
                        .map(projectId).toProperty("projectId")
                        .map(projectName).toProperty("projectName")
                        .map(platform).toProperty("platform")
                        .map(projectVersion).toProperty("projectVersion")
                        .map(dependencyProjectId).toProperty("dependencyProjectId")
                        .map(dependencyProjectName).toProperty("dependencyProjectName")
                        .map(dependencyProjectPlatform).toProperty("dependencyProjectPlatform")
                        .map(dependencyRequirements).toProperty("dependencyRequirements")
                        .map(dependencyType).toProperty("dependencyType")
        );
    }

    default int insertMultiple(Collection<ProjectDependencyPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, PROJECT_DEPENDENCIES, c ->
                c.map(dependencyId).toProperty("dependencyId")
                        .map(projectId).toProperty("projectId")
                        .map(projectName).toProperty("projectName")
                        .map(platform).toProperty("platform")
                        .map(projectVersion).toProperty("projectVersion")
                        .map(dependencyProjectId).toProperty("dependencyProjectId")
                        .map(dependencyProjectName).toProperty("dependencyProjectName")
                        .map(dependencyProjectPlatform).toProperty("dependencyProjectPlatform")
                        .map(dependencyRequirements).toProperty("dependencyRequirements")
                        .map(dependencyType).toProperty("dependencyType")
        );
    }

    default int insertSelective(ProjectDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, PROJECT_DEPENDENCIES, c ->
                c.map(dependencyId).toPropertyWhenPresent("dependencyId", record::getDependencyId)
                        .map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(projectName).toPropertyWhenPresent("projectName", record::getProjectName)
                        .map(platform).toPropertyWhenPresent("platform", record::getPlatform)
                        .map(projectVersion).toPropertyWhenPresent("projectVersion", record::getProjectVersion)
                        .map(dependencyProjectId).toPropertyWhenPresent("dependencyProjectId", record::getDependencyProjectId)
                        .map(dependencyProjectName).toPropertyWhenPresent("dependencyProjectName", record::getDependencyProjectName)
                        .map(dependencyProjectPlatform).toPropertyWhenPresent("dependencyProjectPlatform", record::getDependencyProjectPlatform)
                        .map(dependencyRequirements).toPropertyWhenPresent("dependencyRequirements", record::getDependencyRequirements)
                        .map(dependencyType).toPropertyWhenPresent("dependencyType", record::getDependencyType)
        );
    }

    default Optional<ProjectDependencyPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, PROJECT_DEPENDENCIES, completer);
    }

    default List<ProjectDependencyPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, PROJECT_DEPENDENCIES, completer);
    }

    default List<ProjectDependencyPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, PROJECT_DEPENDENCIES, completer);
    }

    default Optional<ProjectDependencyPO> selectByPrimaryKey(Integer dependencyId_) {
        return selectOne(c ->
                c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, PROJECT_DEPENDENCIES, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(ProjectDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dependencyId).equalTo(record::getDependencyId)
                .set(projectId).equalTo(record::getProjectId)
                .set(projectName).equalTo(record::getProjectName)
                .set(platform).equalTo(record::getPlatform)
                .set(projectVersion).equalTo(record::getProjectVersion)
                .set(dependencyProjectId).equalTo(record::getDependencyProjectId)
                .set(dependencyProjectName).equalTo(record::getDependencyProjectName)
                .set(dependencyProjectPlatform).equalTo(record::getDependencyProjectPlatform)
                .set(dependencyRequirements).equalTo(record::getDependencyRequirements)
                .set(dependencyType).equalTo(record::getDependencyType);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(ProjectDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dependencyId).equalToWhenPresent(record::getDependencyId)
                .set(projectId).equalToWhenPresent(record::getProjectId)
                .set(projectName).equalToWhenPresent(record::getProjectName)
                .set(platform).equalToWhenPresent(record::getPlatform)
                .set(projectVersion).equalToWhenPresent(record::getProjectVersion)
                .set(dependencyProjectId).equalToWhenPresent(record::getDependencyProjectId)
                .set(dependencyProjectName).equalToWhenPresent(record::getDependencyProjectName)
                .set(dependencyProjectPlatform).equalToWhenPresent(record::getDependencyProjectPlatform)
                .set(dependencyRequirements).equalToWhenPresent(record::getDependencyRequirements)
                .set(dependencyType).equalToWhenPresent(record::getDependencyType);
    }

    default int updateByPrimaryKey(ProjectDependencyPO record) {
        return update(c ->
                c.set(projectId).equalTo(record::getProjectId)
                        .set(projectName).equalTo(record::getProjectName)
                        .set(platform).equalTo(record::getPlatform)
                        .set(projectVersion).equalTo(record::getProjectVersion)
                        .set(dependencyProjectId).equalTo(record::getDependencyProjectId)
                        .set(dependencyProjectName).equalTo(record::getDependencyProjectName)
                        .set(dependencyProjectPlatform).equalTo(record::getDependencyProjectPlatform)
                        .set(dependencyRequirements).equalTo(record::getDependencyRequirements)
                        .set(dependencyType).equalTo(record::getDependencyType)
                        .where(dependencyId, isEqualTo(record::getDependencyId))
        );
    }

    default int updateByPrimaryKeySelective(ProjectDependencyPO record) {
        return update(c ->
                c.set(projectId).equalToWhenPresent(record::getProjectId)
                        .set(projectName).equalToWhenPresent(record::getProjectName)
                        .set(platform).equalToWhenPresent(record::getPlatform)
                        .set(projectVersion).equalToWhenPresent(record::getProjectVersion)
                        .set(dependencyProjectId).equalToWhenPresent(record::getDependencyProjectId)
                        .set(dependencyProjectName).equalToWhenPresent(record::getDependencyProjectName)
                        .set(dependencyProjectPlatform).equalToWhenPresent(record::getDependencyProjectPlatform)
                        .set(dependencyRequirements).equalToWhenPresent(record::getDependencyRequirements)
                        .set(dependencyType).equalToWhenPresent(record::getDependencyType)
                        .where(dependencyId, isEqualTo(record::getDependencyId))
        );
    }

}