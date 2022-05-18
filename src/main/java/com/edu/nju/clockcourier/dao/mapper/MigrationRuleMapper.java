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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.MigrationRuleDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface MigrationRuleMapper {

    BasicColumn[] selectList = BasicColumn.columnList(ruleId, fromId, toId, confidence, ruleSup, msgSup, disSup, apiSup);

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
            @Result(column = "rule_id", property = "ruleId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "from_id", property = "fromId", jdbcType = JdbcType.INTEGER),
            @Result(column = "to_id", property = "toId", jdbcType = JdbcType.INTEGER),
            @Result(column = "confidence", property = "confidence", jdbcType = JdbcType.DOUBLE),
            @Result(column = "rule_sup", property = "ruleSup", jdbcType = JdbcType.DOUBLE),
            @Result(column = "msg_sup", property = "msgSup", jdbcType = JdbcType.DOUBLE),
            @Result(column = "dis_sup", property = "disSup", jdbcType = JdbcType.DOUBLE),
            @Result(column = "api_sup", property = "apiSup", jdbcType = JdbcType.DOUBLE)
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

    default int deleteByPrimaryKey(Integer ruleId_) {
        return delete(c ->
                c.where(ruleId, isEqualTo(ruleId_))
        );
    }

    default int insert(MigrationRulePO record) {
        return MyBatis3Utils.insert(this::insert, record, migrationRule, c ->
                c.map(ruleId).toProperty("ruleId")
                        .map(fromId).toProperty("fromId")
                        .map(toId).toProperty("toId")
                        .map(confidence).toProperty("confidence")
                        .map(ruleSup).toProperty("ruleSup")
                        .map(msgSup).toProperty("msgSup")
                        .map(disSup).toProperty("disSup")
                        .map(apiSup).toProperty("apiSup")
        );
    }

    default int insertMultiple(Collection<MigrationRulePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, migrationRule, c ->
                c.map(ruleId).toProperty("ruleId")
                        .map(fromId).toProperty("fromId")
                        .map(toId).toProperty("toId")
                        .map(confidence).toProperty("confidence")
                        .map(ruleSup).toProperty("ruleSup")
                        .map(msgSup).toProperty("msgSup")
                        .map(disSup).toProperty("disSup")
                        .map(apiSup).toProperty("apiSup")
        );
    }

    default int insertSelective(MigrationRulePO record) {
        return MyBatis3Utils.insert(this::insert, record, migrationRule, c ->
                c.map(ruleId).toPropertyWhenPresent("ruleId", record::getRuleId)
                        .map(fromId).toPropertyWhenPresent("fromId", record::getFromId)
                        .map(toId).toPropertyWhenPresent("toId", record::getToId)
                        .map(confidence).toPropertyWhenPresent("confidence", record::getConfidence)
                        .map(ruleSup).toPropertyWhenPresent("ruleSup", record::getRuleSup)
                        .map(msgSup).toPropertyWhenPresent("msgSup", record::getMsgSup)
                        .map(disSup).toPropertyWhenPresent("disSup", record::getDisSup)
                        .map(apiSup).toPropertyWhenPresent("apiSup", record::getApiSup)
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

    default Optional<MigrationRulePO> selectByPrimaryKey(Integer ruleId_) {
        return selectOne(c ->
                c.where(ruleId, isEqualTo(ruleId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, migrationRule, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MigrationRulePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalTo(record::getRuleId)
                .set(fromId).equalTo(record::getFromId)
                .set(toId).equalTo(record::getToId)
                .set(confidence).equalTo(record::getConfidence)
                .set(ruleSup).equalTo(record::getRuleSup)
                .set(msgSup).equalTo(record::getMsgSup)
                .set(disSup).equalTo(record::getDisSup)
                .set(apiSup).equalTo(record::getApiSup);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MigrationRulePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalToWhenPresent(record::getRuleId)
                .set(fromId).equalToWhenPresent(record::getFromId)
                .set(toId).equalToWhenPresent(record::getToId)
                .set(confidence).equalToWhenPresent(record::getConfidence)
                .set(ruleSup).equalToWhenPresent(record::getRuleSup)
                .set(msgSup).equalToWhenPresent(record::getMsgSup)
                .set(disSup).equalToWhenPresent(record::getDisSup)
                .set(apiSup).equalToWhenPresent(record::getApiSup);
    }

    default int updateByPrimaryKey(MigrationRulePO record) {
        return update(c ->
                c.set(fromId).equalTo(record::getFromId)
                        .set(toId).equalTo(record::getToId)
                        .set(confidence).equalTo(record::getConfidence)
                        .set(ruleSup).equalTo(record::getRuleSup)
                        .set(msgSup).equalTo(record::getMsgSup)
                        .set(disSup).equalTo(record::getDisSup)
                        .set(apiSup).equalTo(record::getApiSup)
                        .where(ruleId, isEqualTo(record::getRuleId))
        );
    }

    default int updateByPrimaryKeySelective(MigrationRulePO record) {
        return update(c ->
                c.set(fromId).equalToWhenPresent(record::getFromId)
                        .set(toId).equalToWhenPresent(record::getToId)
                        .set(confidence).equalToWhenPresent(record::getConfidence)
                        .set(ruleSup).equalToWhenPresent(record::getRuleSup)
                        .set(msgSup).equalToWhenPresent(record::getMsgSup)
                        .set(disSup).equalToWhenPresent(record::getDisSup)
                        .set(apiSup).equalToWhenPresent(record::getApiSup)
                        .where(ruleId, isEqualTo(record::getRuleId))
        );
    }

}