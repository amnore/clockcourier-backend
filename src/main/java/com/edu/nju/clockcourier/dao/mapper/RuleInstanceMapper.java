package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.RuleInstancePO;
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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.RuleInstanceDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface RuleInstanceMapper {

    BasicColumn[] selectList = BasicColumn.columnList(ruleId, projectId, fileName, startCommitLink, endCommitLink);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<RuleInstancePO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RuleInstancePO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "RuleInstanceResult", value = {
            @Result(column = "rule_id", property = "ruleId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "start_commit_link", property = "startCommitLink", jdbcType = JdbcType.VARCHAR),
            @Result(column = "end_commit_link", property = "endCommitLink", jdbcType = JdbcType.VARCHAR)
    })
    Optional<RuleInstancePO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("RuleInstanceResult")
    List<RuleInstancePO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ruleInstance, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ruleInstance, completer);
    }

    default int deleteByPrimaryKey(Integer ruleId_, Integer projectId_, String fileName_) {
        return delete(c ->
                c.where(ruleId, isEqualTo(ruleId_))
                        .and(projectId, isEqualTo(projectId_))
                        .and(fileName, isEqualTo(fileName_))
        );
    }

    default int insert(RuleInstancePO record) {
        return MyBatis3Utils.insert(this::insert, record, ruleInstance, c ->
                c.map(ruleId).toProperty("ruleId")
                        .map(projectId).toProperty("projectId")
                        .map(fileName).toProperty("fileName")
                        .map(startCommitLink).toProperty("startCommitLink")
                        .map(endCommitLink).toProperty("endCommitLink")
        );
    }

    default int insertMultiple(Collection<RuleInstancePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ruleInstance, c ->
                c.map(ruleId).toProperty("ruleId")
                        .map(projectId).toProperty("projectId")
                        .map(fileName).toProperty("fileName")
                        .map(startCommitLink).toProperty("startCommitLink")
                        .map(endCommitLink).toProperty("endCommitLink")
        );
    }

    default int insertSelective(RuleInstancePO record) {
        return MyBatis3Utils.insert(this::insert, record, ruleInstance, c ->
                c.map(ruleId).toPropertyWhenPresent("ruleId", record::getRuleId)
                        .map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(fileName).toPropertyWhenPresent("fileName", record::getFileName)
                        .map(startCommitLink).toPropertyWhenPresent("startCommitLink", record::getStartCommitLink)
                        .map(endCommitLink).toPropertyWhenPresent("endCommitLink", record::getEndCommitLink)
        );
    }

    default Optional<RuleInstancePO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ruleInstance, completer);
    }

    default List<RuleInstancePO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ruleInstance, completer);
    }

    default List<RuleInstancePO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ruleInstance, completer);
    }

    default Optional<RuleInstancePO> selectByPrimaryKey(Integer ruleId_, Integer projectId_, String fileName_) {
        return selectOne(c ->
                c.where(ruleId, isEqualTo(ruleId_))
                        .and(projectId, isEqualTo(projectId_))
                        .and(fileName, isEqualTo(fileName_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ruleInstance, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(RuleInstancePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalTo(record::getRuleId)
                .set(projectId).equalTo(record::getProjectId)
                .set(fileName).equalTo(record::getFileName)
                .set(startCommitLink).equalTo(record::getStartCommitLink)
                .set(endCommitLink).equalTo(record::getEndCommitLink);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(RuleInstancePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalToWhenPresent(record::getRuleId)
                .set(projectId).equalToWhenPresent(record::getProjectId)
                .set(fileName).equalToWhenPresent(record::getFileName)
                .set(startCommitLink).equalToWhenPresent(record::getStartCommitLink)
                .set(endCommitLink).equalToWhenPresent(record::getEndCommitLink);
    }

    default int updateByPrimaryKey(RuleInstancePO record) {
        return update(c ->
                c.set(startCommitLink).equalTo(record::getStartCommitLink)
                        .set(endCommitLink).equalTo(record::getEndCommitLink)
                        .where(ruleId, isEqualTo(record::getRuleId))
                        .and(projectId, isEqualTo(record::getProjectId))
                        .and(fileName, isEqualTo(record::getFileName))
        );
    }

    default int updateByPrimaryKeySelective(RuleInstancePO record) {
        return update(c ->
                c.set(startCommitLink).equalToWhenPresent(record::getStartCommitLink)
                        .set(endCommitLink).equalToWhenPresent(record::getEndCommitLink)
                        .where(ruleId, isEqualTo(record::getRuleId))
                        .and(projectId, isEqualTo(record::getProjectId))
                        .and(fileName, isEqualTo(record::getFileName))
        );
    }

}