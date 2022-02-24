package com.edu.nju.clockcourier.dao;

import static com.edu.nju.clockcourier.dao.support.ProjectDependencyPODynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface ProjectDependencyPOMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(dependencyId, projectId, projectName, platform, projectVersion, dependencyProjectId, dependencyProjectName, dependencyProjectPlatform, dependencyRequirements, dependencyType);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ProjectDependencyPO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ProjectDependencyPO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProjectDependencyPOResult", value = {
        @Result(column="dependency_id", property="dependencyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="project_id", property="projectId", jdbcType=JdbcType.INTEGER),
        @Result(column="project_name", property="projectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform", property="platform", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_version", property="projectVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_id", property="dependencyProjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="dependency_project_name", property="dependencyProjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_platform", property="dependencyProjectPlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_requirements", property="dependencyRequirements", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_type", property="dependencyType", jdbcType=JdbcType.VARCHAR)
    })
    Optional<ProjectDependencyPO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProjectDependencyPOResult2", value = {
        @Result(column="dependency_id", property="dependencyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="project_id", property="projectId", jdbcType=JdbcType.INTEGER),
        @Result(column="project_name", property="projectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform", property="platform", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_version", property="projectVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_id", property="dependencyProjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="dependency_project_name", property="dependencyProjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_platform", property="dependencyProjectPlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_requirements", property="dependencyRequirements", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_type", property="dependencyType", jdbcType=JdbcType.VARCHAR)
    })
    List<ProjectDependencyPO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer dependencyId_) {
        return delete(c -> 
            c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ProjectDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, projectDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ProjectDependencyPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, projectDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ProjectDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, projectDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProjectDependencyPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProjectDependencyPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProjectDependencyPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProjectDependencyPO> selectByPrimaryKey(Integer dependencyId_) {
        return selectOne(c ->
            c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, projectDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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