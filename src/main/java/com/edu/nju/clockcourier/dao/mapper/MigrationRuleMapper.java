package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.MigrationRulePO;
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

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.MigrationRuleDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface MigrationRuleMapper {

    BasicColumn[] selectList = BasicColumn.columnList(fromId, toId, projectId, version, confidence);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<MigrationRulePO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MigrationRulePO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MigrationRuleResult", value = {
            @Result(column = "from_id", property = "fromId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "to_id", property = "toId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "version", property = "version", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "confidence", property = "confidence", jdbcType = JdbcType.DOUBLE)
    })
    Optional<MigrationRulePO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MigrationRuleResult")
    List<MigrationRulePO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, migrationRule, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, migrationRule, completer);
    }

    default int deleteByPrimaryKey(Integer fromId_, Integer toId_, Integer projectId_, String version_) {
        return delete(c ->
                c.where(fromId, isEqualTo(fromId_))
                        .and(toId, isEqualTo(toId_))
                        .and(projectId, isEqualTo(projectId_))
                        .and(version, isEqualTo(version_))
        );
    }

    default int insert(MigrationRulePO record) {
        return MyBatis3Utils.insert(this::insert, record, migrationRule, c ->
                c.map(fromId).toProperty("fromId")
                        .map(toId).toProperty("toId")
                        .map(projectId).toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(confidence).toProperty("confidence")
        );
    }

    default int insertMultiple(Collection<MigrationRulePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, migrationRule, c ->
                c.map(fromId).toProperty("fromId")
                        .map(toId).toProperty("toId")
                        .map(projectId).toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(confidence).toProperty("confidence")
        );
    }

    default int insertSelective(MigrationRulePO record) {
        return MyBatis3Utils.insert(this::insert, record, migrationRule, c ->
                c.map(fromId).toPropertyWhenPresent("fromId", record::getFromId)
                        .map(toId).toPropertyWhenPresent("toId", record::getToId)
                        .map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(version).toPropertyWhenPresent("version", record::getVersion)
                        .map(confidence).toPropertyWhenPresent("confidence", record::getConfidence)
        );
    }

    default Optional<MigrationRulePO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, migrationRule, completer);
    }

    default List<MigrationRulePO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, migrationRule, completer);
    }

    default List<MigrationRulePO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, migrationRule, completer);
    }

    default Optional<MigrationRulePO> selectByPrimaryKey(Integer fromId_, Integer toId_, Integer projectId_, String version_) {
        return selectOne(c ->
                c.where(fromId, isEqualTo(fromId_))
                        .and(toId, isEqualTo(toId_))
                        .and(projectId, isEqualTo(projectId_))
                        .and(version, isEqualTo(version_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, migrationRule, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MigrationRulePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fromId).equalTo(record::getFromId)
                .set(toId).equalTo(record::getToId)
                .set(projectId).equalTo(record::getProjectId)
                .set(version).equalTo(record::getVersion)
                .set(confidence).equalTo(record::getConfidence);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MigrationRulePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(fromId).equalToWhenPresent(record::getFromId)
                .set(toId).equalToWhenPresent(record::getToId)
                .set(projectId).equalToWhenPresent(record::getProjectId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(confidence).equalToWhenPresent(record::getConfidence);
    }

    default int updateByPrimaryKey(MigrationRulePO record) {
        return update(c ->
                c.set(confidence).equalTo(record::getConfidence)
                        .where(fromId, isEqualTo(record::getFromId))
                        .and(toId, isEqualTo(record::getToId))
                        .and(projectId, isEqualTo(record::getProjectId))
                        .and(version, isEqualTo(record::getVersion))
        );
    }

    default int updateByPrimaryKeySelective(MigrationRulePO record) {
        return update(c ->
                c.set(confidence).equalToWhenPresent(record::getConfidence)
                        .where(fromId, isEqualTo(record::getFromId))
                        .and(toId, isEqualTo(record::getToId))
                        .and(projectId, isEqualTo(record::getProjectId))
                        .and(version, isEqualTo(record::getVersion))
        );
    }

}